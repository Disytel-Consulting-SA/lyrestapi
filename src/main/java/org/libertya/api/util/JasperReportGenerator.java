package org.libertya.api.util;

import org.libertya.api.common.UserInfo;
import org.libertya.api.stub.model.ProcessExecuteRequest;
import org.openXpertya.model.MAttachment;
import org.openXpertya.model.MAttachmentEntry;
import org.openXpertya.model.MPInstance;
import org.openXpertya.model.MProcess;
import org.openXpertya.model.MProcessPara;
import org.openXpertya.model.MRole;
import org.openXpertya.process.ProcessInfo;
import org.openXpertya.process.ProcessInfoParameter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
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
        String jasper = process.getJasperReport();
        boolean dynamicJasper = process.isDynamicReport() && jasper != null
                && !jasper.trim().isEmpty()
                && !jasper.toLowerCase(java.util.Locale.ROOT).contains("xls");
        if (!process.isReport() || (!process.isJasperReport() && !dynamicJasper)) {
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
        Map<String, String> jasperTypes = readJasperParameterTypes(process, jasper);

        if (values != null) {
            for (Map.Entry<String, String> entry : values.entrySet()) {
                MProcessPara param = requireParameter(process, entry.getKey());
                Object from = adaptJasperType(ProcessExecutor.convert(process, entry.getKey(), entry.getValue()),
                        jasperTypes.get(entry.getKey()), entry.getKey());
                Object to = valuesTo == null ? null
                        : adaptJasperType(ProcessExecutor.convert(process, entry.getKey(), valuesTo.get(entry.getKey())),
                                jasperTypes.get(entry.getKey()), entry.getKey());
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
                Object to = adaptJasperType(ProcessExecutor.convert(process, entry.getKey(), entry.getValue()),
                        jasperTypes.get(entry.getKey()), entry.getKey());
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

    /** Lee únicamente las declaraciones de parámetros del JRXML, sin compilar ni ejecutar el informe. */
    private static Map<String, String> readJasperParameterTypes(MProcess process, String reportPath) {
        Map<String, String> types = new HashMap<>();
        if (reportPath == null || !reportPath.toLowerCase(java.util.Locale.ROOT).endsWith(".jrxml")) {
            return types;
        }
        try {
            byte[] xml = null;
            if (reportPath.startsWith("attachment:")) {
                String name = reportPath.substring("attachment:".length()).trim();
                MAttachment attachment = process.getAttachment();
                if (attachment != null) {
                    for (MAttachmentEntry entry : attachment.getEntries()) {
                        if (name.equals(entry.getName())) {
                            xml = entry.getData();
                            break;
                        }
                    }
                }
            } else if (reportPath.startsWith("/")) {
                xml = Files.readAllBytes(Paths.get(reportPath));
            }
            // Otros orígenes (resource:, http:, etc.) mantienen la conversión de metadatos de Libertya.
            if (xml == null) return types;

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Los JRXML antiguos incluyen DOCTYPE; permitirlo sin resolver DTD ni entidades externas.
            factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
            factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            factory.setXIncludeAware(false);
            factory.setExpandEntityReferences(false);
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
            NodeList nodes = factory.newDocumentBuilder()
                    .parse(new ByteArrayInputStream(xml)).getElementsByTagName("parameter");
            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                String name = element.getAttribute("name");
                String type = element.getAttribute("class");
                if (!name.isEmpty() && !type.isEmpty()) types.put(name, type);
            }
        } catch (Exception e) {
            throw new IllegalStateException("No se pudieron leer los tipos de parámetros Jasper del informe "
                    + process.getAD_Process_ID() + ": " + e.getMessage(), e);
        }
        return types;
    }

    /** Convierte según la clase declarada por Jasper; nunca reintenta ejecutar el informe. */
    private static Object adaptJasperType(Object value, String type, String name) {
        if (value == null || type == null || type.isEmpty()) return value;
        try {
            switch (type) {
                case "java.math.BigDecimal":
                    return value instanceof BigDecimal ? value : new BigDecimal(value.toString());
                case "java.lang.Integer":
                    return value instanceof Integer ? value : new BigDecimal(value.toString()).intValueExact();
                case "java.lang.Long":
                    return value instanceof Long ? value : new BigDecimal(value.toString()).longValueExact();
                case "java.lang.Short":
                    return value instanceof Short ? value : new BigDecimal(value.toString()).shortValueExact();
                case "java.lang.Double":
                    return value instanceof Double ? value : Double.valueOf(value.toString());
                case "java.lang.Float":
                    return value instanceof Float ? value : Float.valueOf(value.toString());
                case "java.lang.String":
                    return value.toString();
                case "java.sql.Date":
                    if (value instanceof java.util.Date)
                        return new java.sql.Date(((java.util.Date) value).getTime());
                    break;
                case "java.sql.Timestamp":
                    if (value instanceof java.util.Date)
                        return new java.sql.Timestamp(((java.util.Date) value).getTime());
                    break;
                case "java.util.Date":
                    if (value instanceof java.util.Date) return value;
                    break;
                default:
                    // Clases especiales: no introducir conversiones especulativas.
                    return value;
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("El parámetro Jasper " + name
                    + " no admite el valor recibido para " + type + ": " + value, e);
        }
        throw new IllegalArgumentException("Tipo incompatible para parámetro Jasper " + name
                + ": " + value.getClass().getName() + " -> " + type);
    }

    private static MProcessPara requireParameter(MProcess process, String name) {
        MProcessPara param = process.getParameter(name);
        if (param == null) {
            throw new IllegalArgumentException("Parámetro ajeno al proceso: " + name);
        }
        return param;
    }
}
