package org.libertya.api.util;

import org.libertya.api.common.UserInfo;
import org.libertya.api.repository.GenericRepository;
import org.libertya.api.stub.model.GenericRecord;
import org.libertya.api.stub.model.ProcessParameterState;
import org.libertya.api.stub.model.ProcessState;
import org.libertya.api.stub.model.ProcessStateRequest;
import org.openXpertya.model.CalloutProcess;
import org.openXpertya.model.MField;
import org.openXpertya.model.MFieldVO;
import org.openXpertya.model.MLookup;
import org.openXpertya.util.DB;
import org.openXpertya.util.DisplayType;
import org.openXpertya.util.Env;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.StringTokenizer;

public class ProcessFieldStateEngine {
    private static final int WINDOW_NO = 100;

    public ProcessState resolve(UserInfo info, int processId, ProcessStateRequest request) throws Exception {
        Properties ctx = new Properties();
        ctx.putAll(info.getCtx());

        loadRecordContext(info, ctx, request);
        Map<String, String> suppliedValues = request != null ? request.getValues() : null;
        if (suppliedValues != null) suppliedValues.forEach((key, value) -> setContext(ctx, key, value));

        List<MField> fields = loadFields(ctx, processId);
        if (fields.isEmpty() && !processExists(processId)) throw new IllegalArgumentException("No existe AD_Process_ID=" + processId);

        Map<String, MField> fieldsByColumn = new LinkedHashMap<>();
        for (MField field : fields) fieldsByColumn.put(field.getColumnName(), field);

        applyValuesAndDefaults(ctx, fields, suppliedValues);

        List<String> changedParameters = request != null ? request.getChangedParameters() : null;
        if (changedParameters == null || changedParameters.isEmpty()) {
            processCalloutsOnLoad(ctx, fieldsByColumn);
            for (MField field : fields) processDependencies(field, fields);
        } else {
            for (String columnName : changedParameters) {
                MField changedField = fieldsByColumn.get(columnName);
                if (changedField == null) throw new IllegalArgumentException("Parametro ajeno al proceso: " + columnName);
                processCallout(ctx, changedField, changedField.getValue(), fieldsByColumn);
                syncContext(ctx, fields);
                processDependencies(changedField, fields);
                syncContext(ctx, fields);
            }
        }

        Map<String, String> values = collectValues(fields);
        List<ProcessParameterState> parameterStates = new ArrayList<>();
        for (MField field : fields) {
            field.lookupLoadComplete();
            field.validateValue();
            parameterStates.add(new ProcessParameterState().processParaId(field.getAD_Column_ID()).columnname(field.getColumnName())
                    .displayed(field.isDisplayed(true)).readonly(!field.isEditablePara(true)));
        }

        return new ProcessState().values(values).parameters(parameterStates);
    }

    private void applyValuesAndDefaults(Properties ctx, List<MField> fields, Map<String, String> suppliedValues) {
        for (MField field : fields) {
            String supplied = suppliedValues != null ? suppliedValues.get(field.getColumnName()) : null;
            if (supplied != null) {
                field.setValue(toCoreValue(field, supplied), true, true);
            } else {
                Object defaultValue = field.getDefault();
                if (defaultValue != null) {
                    field.refreshLookup();
                    field.setValue(defaultValue, true, true);
                }
            }
            setContext(ctx, field.getColumnName(), toProtocolValue(field.getValue()));
        }
    }

    private void processCalloutsOnLoad(Properties ctx, Map<String, MField> fields) {
        for (MField field : fields.values()) {
            if (!field.isCalloutAlsoOnLoad()) continue;
            processCallout(ctx, field, field.getValue(), fields);
            syncContext(ctx, fields.values());
        }
    }

    private void processCallout(Properties ctx, MField field, Object newValue, Map<String, MField> fields) {
        String callout = field.getCallout();
        if (callout == null || callout.trim().isEmpty()) return;

        StringTokenizer commands = new StringTokenizer(callout, ";", false);
        while (commands.hasMoreTokens()) {
            String command = commands.nextToken().trim();
            int methodStart = command.lastIndexOf('.');
            if (methodStart <= 0 || methodStart == command.length() - 1) throw new IllegalStateException("Callout invalido: " + command);

            String className = command.substring(0, methodStart);
            String method = command.substring(methodStart + 1);
            try {
                CalloutProcess instance = (CalloutProcess) Class.forName(className).newInstance();
                String result = instance.start(ctx, WINDOW_NO, method, field, newValue, field.getOldValue(), fields);
                if (result != null && !result.isEmpty()) throw new IllegalStateException("Callout " + field.getColumnName() + ": " + result);
            } catch (IllegalStateException e) {
                throw e;
            } catch (Exception e) {
                throw new IllegalStateException("Callout invalido: " + command, e);
            }
        }
    }

    private void processDependencies(MField changedField, List<MField> fields) {
        String columnName = changedField.getColumnName();
        for (MField dependentField : fields) {
            if (!dependentField.getDependentOn().contains(columnName) || !(dependentField.getLookup() instanceof MLookup)) continue;
            MLookup lookup = (MLookup) dependentField.getLookup();
            if (lookup.getValidation().contains("@" + columnName + "@")) {
                dependentField.setValue(null, true);
                dependentField.refreshLookup();
            }
        }
    }

    private void syncContext(Properties ctx, Iterable<MField> fields) {
        for (MField field : fields) setContext(ctx, field.getColumnName(), toProtocolValue(field.getValue()));
    }

    private Map<String, String> collectValues(List<MField> fields) {
        Map<String, String> values = new LinkedHashMap<>();
        for (MField field : fields) {
            String value = toProtocolValue(field.getValue());
            if (value != null) values.put(field.getColumnName(), value);
        }
        return values;
    }

    private List<MField> loadFields(Properties ctx, int processId) throws Exception {
        String sql = "SELECT p.Name, p.Description, p.Help, p.AD_Reference_ID, p.AD_Process_Para_ID, p.FieldLength, p.IsMandatory, p.IsRange, p.ColumnName, " +
                "p.DefaultValue, p.DefaultValue2, p.VFormat, p.ValueMin, p.ValueMax, p.SeqNo, p.AD_Reference_Value_ID, vr.Code AS ValidationCode, " +
                "p.sameline, p.displaylogic, p.isencrypted, p.isreadonly, p.ReadOnlyLogic, p.Callout, p.CalloutAlsoOnLoad " +
                "FROM AD_Process_Para p LEFT JOIN AD_Val_Rule vr ON p.AD_Val_Rule_ID=vr.AD_Val_Rule_ID " +
                "WHERE p.AD_Process_ID=? AND p.IsActive='Y' ORDER BY p.SeqNo, p.AD_Process_Para_ID";
        List<MField> fields = new ArrayList<>();
        try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
            ps.setInt(1, processId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) fields.add(new MField(MFieldVO.createParameter(ctx, WINDOW_NO, rs)));
            }
        }
        return fields;
    }

    private void loadRecordContext(UserInfo info, Properties ctx, ProcessStateRequest request) throws Exception {
        if (request == null || request.getTable() == null || request.getTable().trim().isEmpty() || request.getRecordId() == null) return;

        GenericRepository repository = new GenericRepository();
        GenericRepository.TableSpec spec = repository.resolveTable(info, request.getTable().trim());
        Optional<GenericRecord> record = repository.retrieveRecord(info, spec.getTableName(), request.getRecordId(), null);
        if (!record.isPresent()) throw new IllegalArgumentException("No existe " + spec.getTableName() + " ID=" + request.getRecordId());

        for (Map.Entry<String, Object> entry : record.get().entrySet()) {
            if (entry.getValue() != null) setContext(ctx, entry.getKey(), String.valueOf(entry.getValue()));
        }
        setContext(ctx, "AD_Table_ID", String.valueOf(org.openXpertya.model.M_Table.get(ctx, spec.getTableName()).getAD_Table_ID()));
        setContext(ctx, spec.getKeyColumn(), String.valueOf(request.getRecordId()));
    }

    private Object toCoreValue(MField field, Object value) {
        if (value == null) return null;
        int type = field.getDisplayType();
        try {
            if (type == DisplayType.YesNo) {
                if (value instanceof Boolean) return value;
                if ("Y".equals(value) || "N".equals(value)) return "Y".equals(value);
            } else if (DisplayType.isID(type) || type == DisplayType.Integer) {
                return new BigDecimal(value.toString()).intValueExact();
            } else if (DisplayType.isNumeric(type)) {
                return new BigDecimal(value.toString());
            } else if ((type == DisplayType.Date || type == DisplayType.DateTime || type == DisplayType.Time) && value instanceof String) {
                String date = (String) value;
                if (date.endsWith("Z")) return Timestamp.from(Instant.parse(date));
                if (date.length() == 10) return Timestamp.valueOf(LocalDate.parse(date).atStartOfDay());
                return Timestamp.valueOf(date.replace('T', ' '));
            } else {
                return value;
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Valor invalido para " + field.getColumnName(), e);
        }
        throw new IllegalArgumentException("Valor invalido para " + field.getColumnName());
    }

    private void setContext(Properties ctx, String key, String value) {
        if (key != null) Env.setContext(ctx, WINDOW_NO, key, value == null ? "" : value);
    }

    private boolean processExists(int processId) {
        return DB.getSQLValue(null, "SELECT AD_Process_ID FROM AD_Process WHERE AD_Process_ID=? AND IsActive='Y'", processId) == processId;
    }

    private String toProtocolValue(Object value) {
        if (value == null) return null;
        if (value instanceof Boolean) return ((Boolean) value) ? "Y" : "N";
        return value.toString();
    }
}
