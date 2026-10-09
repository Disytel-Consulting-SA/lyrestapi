package org.libertya.api.util;

import org.libertya.api.common.UserInfo;
import org.libertya.api.repository.GenericRepository;
import org.libertya.api.stub.model.GenericRecord;
import org.libertya.api.stub.model.ProcessExecuteRequest;
import org.libertya.api.stub.model.ProcessExecuteResponse;
import org.openXpertya.model.MProcess;
import org.openXpertya.model.MProcessPara;
import org.openXpertya.model.M_Table;
import org.openXpertya.process.ProcessInfo;
import org.openXpertya.util.DisplayType;
import org.openXpertya.util.Env;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

public class ProcessExecutor {

    public ProcessExecuteResponse execute(UserInfo info, int processId, ProcessExecuteRequest request) throws Exception {
        Properties ctx = new Properties();
        ctx.putAll(info.getCtx());

        MProcess process = MProcess.get(ctx, processId);
        if (process == null || process.getID() == 0 || !process.isActive()) throw new IllegalArgumentException("No existe AD_Process_ID=" + processId);

        int tableId = 0;
        Integer recordId = null;
        if (request != null && request.getTable() != null && !request.getTable().trim().isEmpty()) {
            if (request.getRecordId() == null) throw new IllegalArgumentException("record_id es obligatorio cuando se informa table");
            GenericRepository repository = new GenericRepository();
            GenericRepository.TableSpec spec = repository.resolveTable(info, request.getTable().trim());
            Optional<GenericRecord> record = repository.retrieveRecord(info, spec.getTableName(), request.getRecordId(), null);
            if (!record.isPresent()) throw new IllegalArgumentException("No existe " + spec.getTableName() + " ID=" + request.getRecordId());
            M_Table table = M_Table.get(ctx, spec.getTableName());
            tableId = table.getAD_Table_ID();
            recordId = request.getRecordId();
            for (Map.Entry<String, Object> entry : record.get().entrySet()) if (entry.getValue() != null) Env.setContext(ctx, 0, entry.getKey(), String.valueOf(entry.getValue()));
        } else if (request != null && request.getRecordId() != null) {
            throw new IllegalArgumentException("table es obligatorio cuando se informa record_id");
        }

        Map<String, Object> parameters = new LinkedHashMap<>();
        if (request != null && request.getValues() != null) {
            for (Map.Entry<String, String> entry : request.getValues().entrySet()) parameters.put(entry.getKey(), convert(process, entry.getKey(), entry.getValue()));
        }
        if (request != null && request.getValuesTo() != null) {
            for (Map.Entry<String, String> entry : request.getValuesTo().entrySet()) parameters.put(entry.getKey() + "_To", convert(process, entry.getKey(), entry.getValue()));
        }

        ProcessInfo pi = MProcess.execute(ctx, processId, tableId, parameters, null, recordId);
        if (pi == null) throw new IllegalStateException("CORE no pudo crear o ejecutar la instancia del proceso");

        return new ProcessExecuteResponse().processInstanceId(pi.getAD_PInstance_ID()).success(!pi.isError()).summary(pi.getSummary());
    }

    private Object convert(MProcess process, String columnName, String value) {
        MProcessPara parameter = process.getParameter(columnName);
        if (parameter == null) throw new IllegalArgumentException("Parametro ajeno al proceso: " + columnName);
        if (value == null || value.isEmpty()) return null;

        int type = parameter.getAD_Reference_ID();
        try {
            if (type == DisplayType.YesNo) return "Y".equalsIgnoreCase(value) || "true".equalsIgnoreCase(value);
            if (DisplayType.isID(type) || type == DisplayType.Integer) return new BigDecimal(value).intValueExact();
            if (DisplayType.isNumeric(type)) return new BigDecimal(value);
            if (type == DisplayType.Date || type == DisplayType.DateTime || type == DisplayType.Time) {
                if (value.endsWith("Z")) return Timestamp.from(Instant.parse(value));
                if (value.length() == 10) return Timestamp.valueOf(LocalDate.parse(value).atStartOfDay());
                return Timestamp.valueOf(value.replace('T', ' '));
            }
            return value;
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Valor invalido para " + columnName, e);
        }
    }
}
