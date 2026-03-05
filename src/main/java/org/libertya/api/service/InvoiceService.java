package org.libertya.api.service;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.QueryParams;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.exception.NotFoundException;
import org.libertya.api.repository.AbstractRepository;
import org.libertya.api.repository.InvoiceLineRepository;
import org.libertya.api.repository.InvoiceRepository;
import org.libertya.api.repository.InvoiceTaxRepository;
import org.libertya.api.stub.model.*;
import net.sf.jasperreports.engine.JasperExportManager;
import org.openXpertya.JasperReport.LaunchInvoice;
import org.openXpertya.JasperReport.MJasperReport;
import org.openXpertya.model.MInvoice;
import org.openXpertya.model.MProcess;
import org.openXpertya.model.M_Table;
import org.openXpertya.model.X_C_Invoice;
import org.openXpertya.process.ProcessInfo;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class InvoiceService extends AbstractService {

    private final InvoiceRepository invRepository;

    private final InvoiceLineRepository invLineRepository;

    private final InvoiceTaxRepository invTaxRepository;

    @Override
    protected AbstractRepository getRepository() {
        return invRepository;
    }

    @Override
    protected Optional<InvoiceDocument> performRetrieve(UserInfo info, int id) throws ModelException, AuthException {
        InvoiceDocument doc = new InvoiceDocument();

        // Cabecera
        Optional<Invoice> inv = invRepository.retrieve(info, id);
        if (!inv.isPresent())
            return Optional.empty();
        doc.setHeader(inv.get());

        // Lineas
        QueryParams params = new QueryParams();
        params.setFilter("c_invoice_id="+id);
        for (Object item : invLineRepository.retrieveAll(info, params)) {
            doc.addLinesItem(((Optional<InvoiceLine>)item).get());
        }

        // Impuestos
        for (Object item : invTaxRepository.retrieveAll(info, params)) {
            doc.addTaxesItem(((Optional<InvoiceTax>)item).get());
        }

        return Optional.of(doc);
    }

    @Override
    protected String performCreate(UserInfo info, Object document, String trxName) throws Exception {
        InvoiceDocument invoiceDocument = (InvoiceDocument)document;

        // Cabecera
        Integer id = Integer.parseInt(invRepository.insert(info, invoiceDocument.getHeader(), trxName));

        // Lineas
        for (InvoiceLine invoiceLine : getList(invoiceDocument.getLines())) {
            invoiceLine.setCInvoiceId(id);
            invLineRepository.insert(info, invoiceLine, trxName);
        }

        // Impuestos
        for (InvoiceTax invoiceTax : getList(invoiceDocument.getTaxes())) {
            invoiceTax.setCInvoiceId(id);
            invTaxRepository.insert(info, invoiceTax, trxName);
        }

        return Integer.toString(id);
    }

    /**
     * Genera la impresión PDF de la factura y la retorna codificada en base64.
     */
    public String printBase64(UserInfo info, int id) throws ModelException, NotFoundException, AuthException {
        if (!invRepository.retrieve(info, id).isPresent()) {
            throw new NotFoundException();
        }

        int processId = retrieveInvoicePrintProcessId();
        if (processId <= 0) {
            throw new ModelException("No se encontró proceso de impresión de facturas (IsJasperReport=Y, LaunchInvoice)");
        }
        byte[] pdfBytes = generatePdfFromJasperProcess(info, id, processId);
        return Base64.getEncoder().encodeToString(pdfBytes);
    }

    protected byte[] generatePdfFromJasperProcess(UserInfo info, int id, int processId) throws ModelException {
        try {
            MInvoice invoice = new MInvoice(info.getCtx(), id, null);

            // Contexto con la org de la factura para que LaunchInvoice resuelva el template correcto
            Properties ctx = new Properties();
            ctx.putAll(info.getCtx());
            org.openXpertya.util.Env.setContext(ctx, "#AD_Org_ID", invoice.getAD_Org_ID());

            LaunchInvoice launchInvoice = new LaunchInvoice();
            launchInvoice.setAD_Record_ID(id);
            int invoiceTableId = M_Table.getTableID(X_C_Invoice.Table_Name);
            ProcessInfo processInfo = new ProcessInfo("InvoicePrint", processId, invoiceTableId, id);
            processInfo.setToStreamOnly(true);
            processInfo.setAD_Client_ID(info.getClientID());
            launchInvoice.startProcess(ctx, processInfo, null);

            if (processInfo.isError()) {
                String msg = processInfo.getSummary();
                throw new ModelException(msg != null && msg.trim().length() > 0 ? msg : "Error al generar la impresión de la factura");
            }

            // Preferir el stream generado por startProcess
            if (processInfo.getReportResultStream() != null && processInfo.getReportResultStream().size() > 0) {
                return processInfo.getReportResultStream().toByteArray();
            }

            // Si no hay stream, exportar con JasperExportManager desde el JasperPrint
            MJasperReport wrapper = launchInvoice.getJasperwrapper();
            if (wrapper == null || wrapper.getJasperPrint() == null) {
                throw new ModelException("No fue posible obtener el reporte Jasper de la factura");
            }
            return JasperExportManager.exportReportToPdf(wrapper.getJasperPrint());
        } catch (ModelException e) {
            throw e;
        } catch (Exception e) {
            throw new ModelException("Error al generar PDF Jasper de factura: " + e.getMessage());
        }
    }

    protected int retrieveInvoicePrintProcessId() {
        // Proceso estándar esperado en la mayoría de instalaciones de Libertya.
        // Preferir "Factura Electrónica" sobre el template genérico
        String sqlElectronica =
                "SELECT p.AD_Process_ID " +
                "FROM AD_Process p " +
                "JOIN AD_JasperReport r ON r.AD_JasperReport_ID = p.AD_JasperReport_ID " +
                "WHERE p.IsActive='Y' " +
                "  AND p.IsJasperReport='Y' " +
                "  AND p.Classname = ? " +
                "  AND lower(r.Name) LIKE '%factura electr%' " +
                "ORDER BY p.AD_Process_ID DESC " +
                "LIMIT 1";
        int processId = intFromObject(DB.getSQLObject(
                null,
                sqlElectronica,
                new Object[]{"org.openXpertya.JasperReport.LaunchInvoice"}
        ));

        if (processId > 0) {
            return processId;
        }

        // Fallback: cualquier proceso LaunchInvoice con template de factura
        String sqlByName =
                "SELECT p.AD_Process_ID " +
                "FROM AD_Process p " +
                "LEFT JOIN AD_JasperReport r ON r.AD_JasperReport_ID = p.AD_JasperReport_ID " +
                "WHERE p.IsActive='Y' " +
                "  AND p.IsJasperReport='Y' " +
                "  AND p.Classname = ? " +
                "  AND (lower(coalesce(p.Name,'')) LIKE ? OR lower(coalesce(r.Name,'')) LIKE ?) " +
                "ORDER BY p.AD_Process_ID DESC " +
                "LIMIT 1";
        processId = intFromObject(DB.getSQLObject(
                null,
                sqlByName,
                new Object[]{"org.openXpertya.JasperReport.LaunchInvoice", "%factura%", "%factura%"}
        ));

        if (processId > 0) {
            return processId;
        }

        // Último fallback por classname.
        String sqlLikeClass =
                "SELECT AD_Process_ID " +
                "FROM AD_Process " +
                "WHERE IsActive='Y' " +
                "  AND IsJasperReport='Y' " +
                "  AND lower(coalesce(Classname,'')) LIKE ? " +
                "ORDER BY AD_Process_ID DESC " +
                "LIMIT 1";
        return intFromObject(DB.getSQLObject(
                null,
                sqlLikeClass,
                new Object[]{"%launchinvoice%"}
        ));
    }

    protected int intFromObject(Object value) {
        if (!(value instanceof Number)) {
            return -1;
        }
        return ((Number)value).intValue();
    }


}
