package org.libertya.api.util;

import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.repository.GenericRepository;
import org.libertya.api.stub.model.GenericRecord;
import org.libertya.api.stub.model.ProcessParameterState;
import org.libertya.api.stub.model.ProcessState;
import org.libertya.api.stub.model.ProcessStateRequest;
import org.openXpertya.model.MField;
import org.openXpertya.model.MFieldVO;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

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

        Map<String, String> values = new LinkedHashMap<>();
        for (MField field : fields) {
            String supplied = suppliedValues != null ? suppliedValues.get(field.getColumnName()) : null;
            if (supplied != null) {
                field.setValue(supplied, true);
                values.put(field.getColumnName(), toProtocolValue(field.getValue()));
                setContext(ctx, field.getColumnName(), toProtocolValue(field.getValue()));
            } else {
                Object defaultValue = field.getDefault();
                if (defaultValue != null) {
                    field.setValue(defaultValue, true);
                    String value = toProtocolValue(field.getValue());
                    if (value != null) {
                        values.put(field.getColumnName(), value);
                        setContext(ctx, field.getColumnName(), value);
                    }
                }
            }
        }

        List<ProcessParameterState> parameterStates = new ArrayList<>();
        for (MField field : fields) {
            field.lookupLoadComplete();
            field.validateValue();
            parameterStates.add(new ProcessParameterState().processParaId(field.getAD_Column_ID()).columnname(field.getColumnName())
                    .displayed(field.isDisplayed(true)).readonly(!field.isEditablePara(true)));
        }

        return new ProcessState().values(values).parameters(parameterStates);
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

    private void setContext(Properties ctx, String key, String value) {
        if (key != null && value != null) Env.setContext(ctx, WINDOW_NO, key, value);
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
