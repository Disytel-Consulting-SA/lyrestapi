package org.libertya.api.util;

import org.libertya.api.common.UserInfo;
import org.libertya.api.security.RecordAccessFilter;
import org.libertya.api.exception.AuthException;
import org.libertya.api.stub.model.ProcessExecuteRequest;
import org.openXpertya.model.MProcess;
import org.openXpertya.model.MRole;
import org.openXpertya.model.MProcessPara;
import org.openXpertya.model.MPInstance;
import org.openXpertya.model.MPInstancePara;
import org.openXpertya.process.ProcessInfo;
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
        if (process.getAD_PrintFormat_ID() <= 0 && process.getAD_ReportView_ID() > 0) {
            return generateFromReportView(ctx, user, process, request);
        }
        if (process.getAD_PrintFormat_ID() <= 0) {
            throw new IllegalArgumentException("El proceso no tiene formato de impresión ni vista de reporte: " + processId);
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
        // Calificar columnas de seguridad: el formato puede incorporar JOINs
        // con tablas que también contienen AD_Client_ID y AD_Org_ID.
        String clientWhere = role.getClientWhere(false);
        if (clientWhere != null && !clientWhere.trim().isEmpty()) {
            query.addRestriction("(" + clientWhere.replaceAll("(?i)\\bAD_Client_ID\\b",
                    tableName + ".AD_Client_ID") + ")");
        }
        String orgWhere = role.getOrgWhere(false);
        if (orgWhere != null && !orgWhere.trim().isEmpty()) {
            query.addRestriction("(" + orgWhere.replaceAll("(?i)\\bAD_Org_ID\\b",
                    tableName + ".AD_Org_ID") + ")");
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


    /**
     * Reportes definidos por AD_ReportView: delegar a CORE la elección o creación
     * del formato, la cláusula WhereClause y el armado de la consulta por parámetros.
     */
    private byte[] generateFromReportView(Properties ctx, UserInfo user, MProcess process,
                                          ProcessExecuteRequest request) throws AuthException {
        int processId = process.getAD_Process_ID();
        if (!user.hasRole()) {
            throw new SecurityException("Se requiere un token con rol para generar informes");
        }
        MRole role = MRole.get(ctx, user.getRoleID(), user.getUserID(), false);
        if (role == null || role.getProcessAccess(processId) == null) {
            throw new SecurityException("Acceso no autorizado al informe " + processId);
        }
        if (request != null && (request.getRecordId() != null
                || (request.getTable() != null && !request.getTable().trim().isEmpty()))) {
            throw new IllegalArgumentException("No se admite ejecutar este informe por registro");
        }

        Map<String, String> values = request == null ? null : request.getValues();
        Map<String, String> valuesTo = request == null ? null : request.getValuesTo();
        for (MProcessPara parameter : process.getParameters()) {
            if (!parameter.isMandatory()) continue;
            String value = values == null ? null : values.get(parameter.getColumnName());
            if (value == null || value.trim().isEmpty()) {
                throw new IllegalArgumentException("Falta parámetro obligatorio: " + parameter.getColumnName());
            }
        }

        // Validar todos los parámetros antes de crear registros persistentes.
        java.util.Map<String, Object[]> converted = new java.util.LinkedHashMap<>();
        java.util.Set<String> names = new java.util.LinkedHashSet<>();
        if (values != null) names.addAll(values.keySet());
        if (valuesTo != null) names.addAll(valuesTo.keySet());
        for (String name : names) {
            MProcessPara parameter = requireParameter(process, name);
            String fromText = values == null ? null : values.get(name);
            String toText = valuesTo == null ? null : valuesTo.get(name);
            Object from = ProcessExecutor.convert(process, name, fromText);
            Object to = ProcessExecutor.convert(process, name, toText);
            if (to != null && !parameter.isRange()) {
                throw new IllegalArgumentException("El parámetro no admite rango: " + name);
            }
            if ("AD_Org_ID".equalsIgnoreCase(name) && from != null) {
                int orgId = new java.math.BigDecimal(from.toString()).intValueExact();
                if (orgId < 0 || !role.isOrgAccess(orgId, false)) {
                    throw new SecurityException("Acceso no autorizado a la organización " + orgId);
                }
            }
            if (from != null || to != null) converted.put(name, new Object[]{parameter, from, to});
        }

        MPInstance instance = new MPInstance(ctx, processId, 0, null);
        if (!instance.save()) {
            throw new IllegalStateException("No se pudo crear AD_PInstance para el informe " + processId);
        }
        int seq = 10;
        for (java.util.Map.Entry<String, Object[]> entry : converted.entrySet()) {
            MProcessPara parameter = (MProcessPara) entry.getValue()[0];
            MPInstancePara instancePara = new MPInstancePara(instance, seq);
            instancePara.setParameterName(entry.getKey());
            if (entry.getValue()[1] != null) {
                instancePara.setParameter(parameter.getAD_Reference_ID(), entry.getValue()[1], false);
            }
            if (entry.getValue()[2] != null) {
                instancePara.setParameter(parameter.getAD_Reference_ID(), entry.getValue()[2], true);
            }
            if (!instancePara.save()) {
                throw new IllegalStateException("No se pudo guardar el parámetro " + entry.getKey());
            }
            seq += 10;
        }

        ProcessInfo pi = new ProcessInfo(process.getName(), processId);
        pi.setAD_PInstance_ID(instance.getID());
        // setQuery=false evita consultar datos antes de incorporar filtros de seguridad.
        ReportEngine engine = ReportEngine.get(ctx, pi, false);
        if (engine == null) {
            throw new IllegalStateException("CORE no pudo resolver el formato de la vista del informe " + processId);
        }
        MPrintFormat format = engine.getPrintFormat();
        M_Table table = M_Table.get(ctx, format.getAD_Table_ID());
        if (table == null || !role.isTableAccess(format.getAD_Table_ID(), true)) {
            throw new SecurityException("Acceso no autorizado a la tabla del informe");
        }
        String tableName = M_Table.getTableName(ctx, format.getAD_Table_ID());
        MQuery query = engine.getQuery();
        if (query == null || tableName == null || tableName.trim().isEmpty()) {
            throw new IllegalStateException("No se pudo construir la consulta del informe");
        }
        String clientWhere = role.getClientWhere(false);
        if (clientWhere != null && !clientWhere.trim().isEmpty()) {
            query.addRestriction("(" + clientWhere.replaceAll("(?i)\\bAD_Client_ID\\b",
                    tableName + ".AD_Client_ID") + ")");
        }
        String orgWhere = role.getOrgWhere(false);
        if (orgWhere != null && !orgWhere.trim().isEmpty()) {
            query.addRestriction("(" + orgWhere.replaceAll("(?i)\\bAD_Org_ID\\b",
                    tableName + ".AD_Org_ID") + ")");
        }
        query.addRestriction(RecordAccessFilter.where(role, table, tableName));
        engine.setQuery(query);
        byte[] pdf = engine.createPDFData();
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
