package org.libertya.api.util;

import org.libertya.api.common.UserInfo;
import org.libertya.api.stub.model.ProcessExecuteRequest;
import org.openXpertya.model.MPInstance;
import org.openXpertya.model.MProcess;
import org.openXpertya.model.MProcessPara;
import org.openXpertya.model.MRole;
import org.openXpertya.process.ProcessInfo;
import org.openXpertya.process.ProcessInfoParameter;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Ejecuta informes Jasper mediante el circuito existente de CORE.
 * No compila JRXML ni selecciona motores: ReportStarter/MJasperReport
 * resuelven el adjunto y exportan a ProcessInfo.reportResultStream.
 */
public class JasperReportGenerator {

    private static final String DYNAMIC_JASPER_CLASS =
            "org.openXpertya.JasperReport.ReportStarter";

    public byte[] generate(UserInfo user, int processId, ProcessExecuteRequest request) {
        Properties ctx = new Properties();
        ctx.putAll(user.getCtx());

        MProcess process = MProcess.get(ctx, processId);
        if (process == null || process.getID() <= 0 || !process.isActive()) {
            throw new IllegalArgumentException("No existe el proceso activo AD_Process_ID=" + processId);
        }
        if (!process.isReport() || !process.isJasperReport()) {
            throw new IllegalArgumentException("El proceso no es un informe Jasper: " + processId);
        }
        if (!user.hasRole()) {
            throw new SecurityException("Se requiere un token con rol para generar informes");
        }
        MRole role = MRole.get(ctx, user.getRoleID(), user.getUserID(), false);
        if (role == null || role.getProcessAccess(processId) == null) {
            throw new SecurityException("Acceso no autorizado al proceso " + processId);
        }
        if (request != null && (request.getRecordId() != null
                || (request.getTable() != null && !request.getTable().trim().isEmpty()))) {
            throw new IllegalArgumentException("La ejecución Jasper por registro todavía no está implementada");
        }

        Map<String, String> values = request == null ? null : request.getValues();
        Map<String, String> valuesTo = request == null ? null : request.getValuesTo();
        List<ProcessInfoParameter> parameters = new ArrayList<>();

        if (values != null) {
            for (Map.Entry<String, String> entry : values.entrySet()) {
                MProcessPara param = requireParameter(process, entry.getKey());
                Object from = ProcessExecutor.convert(process, entry.getKey(), entry.getValue());
                Object to = valuesTo == null ? null
                        : ProcessExecutor.convert(process, entry.getKey(), valuesTo.get(entry.getKey()));
                if (to != null && !param.isRange()) {
                    throw new IllegalArgumentException("El parámetro no admite rango: " + entry.getKey());
                }
                if (from != null || to != null) {
                    parameters.add(new ProcessInfoParameter(entry.getKey(), from, to, null, null));
                }
            }
        }
        if (valuesTo != null) {
            for (Map.Entry<String, String> entry : valuesTo.entrySet()) {
                if (values != null && values.containsKey(entry.getKey())) continue;
                MProcessPara param = requireParameter(process, entry.getKey());
                if (!param.isRange()) {
                    throw new IllegalArgumentException("El parámetro no admite rango: " + entry.getKey());
                }
                Object to = ProcessExecutor.convert(process, entry.getKey(), entry.getValue());
                if (to != null) {
                    parameters.add(new ProcessInfoParameter(entry.getKey(), null, to, null, null));
                }
            }
        }
        for (MProcessPara param : process.getParameters()) {
            if (!param.isMandatory()) continue;
            String value = values == null ? null : values.get(param.getColumnName());
            if (value == null || value.trim().isEmpty()) {
                throw new IllegalArgumentException("Falta parámetro obligatorio: " + param.getColumnName());
            }
        }

        // ReportStarter.getReportData requiere una AD_PInstance persistida.
        MPInstance instance = new MPInstance(ctx, processId, 0, null);
        if (!instance.save()) {
            throw new IllegalStateException("No se pudo crear AD_PInstance para el informe " + processId);
        }

        ProcessInfo pi = new ProcessInfo(process.getName(), processId);
        pi.setAD_PInstance_ID(instance.getID());
        pi.setToStreamOnly(true);
        pi.setClassName(DYNAMIC_JASPER_CLASS);
        pi.setParameter(parameters.toArray(new ProcessInfoParameter[0]));

        MProcess.execute(ctx, process, pi, null);
        if (pi.isError()) {
            throw new IllegalStateException("Error ejecutando informe Jasper: " + pi.getSummary());
        }
        ByteArrayOutputStream stream = pi.getReportResultStream();
        if (stream == null) {
            throw new IllegalStateException("CORE no devolvió un stream PDF para el informe " + processId);
        }
        byte[] pdf = stream.toByteArray();
        if (pdf.length < 5 || pdf[0] != '%' || pdf[1] != 'P'
                || pdf[2] != 'D' || pdf[3] != 'F' || pdf[4] != '-') {
            throw new IllegalStateException("CORE no devolvió un PDF válido para el informe " + processId);
        }
        return pdf;
    }

    private static MProcessPara requireParameter(MProcess process, String name) {
        MProcessPara param = process.getParameter(name);
        if (param == null) {
            throw new IllegalArgumentException("Parámetro ajeno al proceso: " + name);
        }
        return param;
    }
}
