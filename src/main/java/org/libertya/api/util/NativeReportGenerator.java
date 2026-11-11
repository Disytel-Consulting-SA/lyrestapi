package org.libertya.api.util;

import org.libertya.api.common.UserInfo;
import org.libertya.api.security.RecordAccessFilter;
import org.libertya.api.exception.AuthException;
import org.libertya.api.stub.model.ProcessExecuteRequest;
import org.openXpertya.model.MProcess;
import org.openXpertya.model.MRole;
import org.openXpertya.model.MProcessPara;
import org.openXpertya.model.MQuery;
import org.openXpertya.model.M_Table;
import org.openXpertya.model.PrintInfo;
import org.openXpertya.print.MPrintFormat;
import org.openXpertya.print.ReportEngine;
import org.openXpertya.util.DisplayType;

import java.util.Map;
import java.util.Properties;

/**
 * Generación síncrona de informes nativos basados en un formato de impresión.
 *
 * Esta clase NO implementa autorización sobre procesos ni registros. El servicio
 * REST definitivo deberá verificarla antes de invocar este generador.
 */
public class NativeReportGenerator {

    public byte[] generate(UserInfo user, int processId, ProcessExecuteRequest request) throws AuthException {
        Properties ctx = new Properties();
        ctx.putAll(user.getCtx());

        MProcess process = MProcess.get(ctx, processId);
        if (process == null || process.getID() <= 0 || !process.isActive()) {
            throw new IllegalArgumentException("No existe el proceso activo AD_Process_ID=" + processId);
        }
        if (!process.isReport() || process.isJasperReport()) {
            throw new IllegalArgumentException("El proceso no es un informe nativo: " + processId);
        }
        if (process.getAD_PrintFormat_ID() <= 0) {
            throw new IllegalArgumentException("El proceso no tiene formato de impresión: " + processId);
        }

        MPrintFormat format = MPrintFormat.get(ctx, process.getAD_PrintFormat_ID(), true);
        if (format == null || format.getID() <= 0) {
            throw new IllegalStateException("No se encontró el formato de impresión del proceso " + processId);
        }

        String tableName = M_Table.getTableName(ctx, format.getAD_Table_ID());
        if (tableName == null || tableName.trim().isEmpty()) {
            throw new IllegalStateException("No se encontró la tabla del formato de impresión");
        }

        // Los informes consultan conjuntos de registros: JWT no basta.
        if (!user.hasRole()) {
            throw new SecurityException("Se requiere un token con rol para generar informes");
        }
        MRole role = MRole.get(ctx, user.getRoleID(), user.getUserID(), false);
        if (role == null || role.getProcessAccess(processId) == null
                || !role.isTableAccess(format.getAD_Table_ID(), true)) {
            throw new SecurityException("Acceso no autorizado al proceso o a la tabla del informe");
        }
        M_Table table = M_Table.get(ctx, tableName);
        if (table == null) {
            throw new IllegalStateException("No se encontraron metadatos de la tabla del informe");
        }

        MQuery query = new MQuery(tableName);
        // Mismas restricciones de lectura que los listados de la REST API.
        if (user.getClientID() > 0) {
            query.addRestriction("AD_Client_ID IN (0, " + user.getClientID() + ")");
        }
        query.addRestriction("(" + role.getClientWhere(false) + ")");
        String orgWhere = role.getOrgWhere(false);
        if (orgWhere != null && !orgWhere.trim().isEmpty()) {
            query.addRestriction("(" + orgWhere + ")");
        }
        query.addRestriction(RecordAccessFilter.where(role, table, tableName));
        Map<String, String> values = request == null ? null : request.getValues();
        Map<String, String> valuesTo = request == null ? null : request.getValuesTo();

        if (values != null) {
            for (Map.Entry<String, String> entry : values.entrySet()) {
                MProcessPara parameter = requireParameter(process, entry.getKey());
                Object from = ProcessExecutor.convert(process, entry.getKey(), entry.getValue());
                Object to = valuesTo == null ? null : ProcessExecutor.convert(process, entry.getKey(), valuesTo.get(entry.getKey()));
                apply(query, parameter, from, to);
            }
        }
        if (valuesTo != null) {
            for (Map.Entry<String, String> entry : valuesTo.entrySet()) {
                if (values != null && values.containsKey(entry.getKey())) continue;
                MProcessPara parameter = requireParameter(process, entry.getKey());
                apply(query, parameter, null, ProcessExecutor.convert(process, entry.getKey(), entry.getValue()));
            }
        }

        for (MProcessPara parameter : process.getParameters()) {
            if (!parameter.isMandatory()) continue;
            String value = values == null ? null : values.get(parameter.getColumnName());
            if (value == null || value.trim().isEmpty()) {
                throw new IllegalArgumentException("Falta parámetro obligatorio: " + parameter.getColumnName());
            }
        }

        PrintInfo printInfo = new PrintInfo(format.getName(), format.getAD_Table_ID(), 0);
        byte[] pdf = new ReportEngine(ctx, format, query, printInfo).createPDFData();
        if (pdf == null || pdf.length < 5 || pdf[0] != '%' || pdf[1] != 'P'
                || pdf[2] != 'D' || pdf[3] != 'F' || pdf[4] != '-') {
            throw new IllegalStateException("El reporteador no devolvió un PDF válido");
        }
        return pdf;
    }

    private MProcessPara requireParameter(MProcess process, String column) {
        MProcessPara parameter = process.getParameter(column);
        if (parameter == null) {
            throw new IllegalArgumentException("Parámetro ajeno al proceso: " + column);
        }
        return parameter;
    }

    private void apply(MQuery query, MProcessPara parameter, Object from, Object to) {
        String column = parameter.getColumnName();
        int type = parameter.getAD_Reference_ID();
        boolean date = type == DisplayType.Date || type == DisplayType.DateTime || type == DisplayType.Time;

        if (to != null && !parameter.isRange()) {
            throw new IllegalArgumentException("El parámetro no admite rango: " + column);
        }
        if (from == null && to == null) return;

        String expression = date ? "TRUNC(" + column + ")" : column;
        if (from != null && to != null) {
            query.addRangeRestriction(expression, from, to);
        } else if (from != null) {
            if (parameter.isRange()) {
                query.addRestriction(expression, MQuery.GREATER_EQUAL, from);
            } else if (from instanceof String && ((String) from).contains("%")) {
                query.addRestriction(expression, MQuery.LIKE, from);
            } else {
                query.addRestriction(expression, MQuery.EQUAL, from);
            }
        } else {
            query.addRestriction(expression, MQuery.LESS_EQUAL, to);
        }
    }
}
