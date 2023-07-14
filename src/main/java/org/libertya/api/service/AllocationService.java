package org.libertya.api.service;

import lombok.RequiredArgsConstructor;
import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.repository.*;
import org.libertya.api.stub.model.*;
import org.openXpertya.model.*;
import org.openXpertya.model.POCRGenerator.POCRType;
import org.openXpertya.process.DocAction;
import org.openXpertya.process.DocumentEngine;
import org.openXpertya.process.GeneratorRetenciones;
import org.openXpertya.util.CLogger;
import org.openXpertya.util.DB;
import org.openXpertya.util.Env;
import org.openXpertya.util.Msg;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.Properties;
import java.util.Vector;

@Service
@RequiredArgsConstructor
public class AllocationService extends AbstractService {

    private final AllocationHdrRepository allocHdrRepository;

    private final AllocationLineRepository allocLineRepository;

    private final InvoiceRepository invoiceRepository;

    private final CashLineRepository cashLineRepository;

    private final PaymentRepository paymentRepository;

    @Override
    protected String performCreate(UserInfo info, Object document, String trxName) throws Exception {
        AllocationNew allocData = (AllocationNew)document;

        // EC adecuada?
        if (allocData.getCBpartnerId() == null || allocData.getCBpartnerId() == 0)
            throw new Exception("No se ha podido recuperar una entidad comercial con los criterios especificados");

        // Si es un RC de tipo adelantado, no deberían recibirse facturas a cancelar
        if (allocData.isEarlypayment() && allocData.getInvoices()!=null && allocData.getInvoices().size() > 0) {
            throw new Exception("En los recibos de cliente adelantados no pueden recibirse facturas a cancelar");
        }

        // Si es un RC de tipo normal, debería recibirse al menos una factura a pagar
        if (!allocData.isEarlypayment() && (allocData.getInvoices()==null || allocData.getInvoices().size() == 0)) {
            throw new Exception("No se han indicado facturas a cancelar para este recibo de cliente");
        }

        // La OP/RC requiere un AD_Org_ID especificamente mayor a 0
        // Por lo tanto se utiliza o bien el del token o el indicado en los datos recibidos (priorizando este ultimo
        if (allocData.getAdOrgId()!=null)
            Env.setContext(info.getCtx(), "#AD_Org_ID", allocData.getAdOrgId());

        // Crear encabezado
        POCRGenerator rcGenerator = new POCRGenerator(info.getCtx(), POCRType.CUSTOMER_RECEIPT, allocData.getPaymentrule(), trxName);
        MAllocationHdr allocationHdr = rcGenerator.createAllocationHdr();
        allocationHdr.setC_BPartner_ID(allocData.getCBpartnerId());
        allocationHdr.setIsManual(false);

        // Guardar encabezado
        if (!allocationHdr.save())
            throw new Exception("Error al guardar encabezado: " + CLogger.retrieveErrorAsString());

        // Agregar las facturas a cancelar
        for (AllocationNewInvoices invoice : allocData.getInvoices()) {
            int invoiceID;
            BigDecimal amount;
            try {
                invoiceID = invoice.getCInvoiceId();
                amount = invoice.getAmount();
            }
            catch (Exception e) {
                throw new ModelException(" Error al recuperar datos de la factura a cancelar: " + e.getMessage());
            }
            if (invoiceID<=0 || amount.compareTo(BigDecimal.ZERO)<=0)
                throw new ModelException(" Valores indicados para la factura a cancelar son inválidos" );
            rcGenerator.addInvoice(invoiceID, amount);
        }

        // Agregar los medios de pago para cancelar las facturas
        for (AllocationNewPayments payment : allocData.getPayments()) {
            // Adicionar el pago a la nomina
            addPaymentToAllocation(info, rcGenerator, payment, allocData.getCBpartnerId(), allocationHdr, allocData.isEarlypayment(), rcGenerator.getPaymentRule(), trxName);
        }

        // Generar las lineas del allocation en funcion de los pagos y facturas cargados en rcGenerator
        rcGenerator.generateLines();
        rcGenerator.completeAllocation();

        return Integer.toString(allocationHdr.getC_AllocationHdr_ID());
    }

    @Override
    protected Optional<AllocationDocument> performRetrieve(UserInfo info, int id) throws ModelException, AuthException {
        AllocationDocument doc = new AllocationDocument();

        // Cabecera
        Optional<AllocationHdr> header = allocHdrRepository.retrieve(info, id);
        if (!header.isPresent())
            return Optional.empty();
        doc.setHeader(header.get());

        // Lineas
        for (Object item : allocLineRepository.retrieveAll(info, "c_allocationhdr_id="+id, null, null, null, null)) {
            doc.addLinesItem(((Optional<AllocationLine>)item).get());
        }

        return Optional.of(doc);
    }

    @Override
    protected AbstractRepository getRepository() {
        return allocHdrRepository;
    }


    // =================================================================================================================================
    // ===================== Metodos porteados y adaptados desde org.libertya.ws.handler.AllocationDocumentHandler =====================
    // =================================================================================================================================

    /**
     * Incorpora un nuevo pago al generador
     * @param rcGenerator generador de pagos
     * @param payment datos del pago
     */
    protected void addPaymentToAllocation(UserInfo info, POCRGenerator rcGenerator, AllocationNewPayments payment, int bPartnerID, MAllocationHdr allocationHdr, boolean isEarlyPayment, String paymentRule, String trxName) throws Exception {

        if (payment.getCPospaymentmediumId()==null || payment.getCPospaymentmediumId()<=0) {
            throw new Exception("Debe especificar el C_POSPaymentMedium_ID para el pago");
        }

        // Determinar el monto y tipo de pago a instanciar
        BigDecimal amount = payment.getAmount();
        int posPaymentMediumID = payment.getCPospaymentmediumId();
        MPOSPaymentMedium ppm = new MPOSPaymentMedium(Env.getCtx(), posPaymentMediumID, trxName);

        /* A Credito no es un medio de cobro valido en RC */
        if (MPOSPaymentMedium.TENDERTYPE_Credit.equals(ppm.getTenderType()))
            throw new ModelException("El tipo de medio de pago Credito no es valido para recibos de cliente");

            /* Retención (invoice) */
        else if (MPOSPaymentMedium.TENDERTYPE_Retencion.equals(ppm.getTenderType())) {
            // Incorporar la retencion (en Recibos de Cliente, la misma NO es calculada)
            GeneratorRetenciones genRet = new GeneratorRetenciones(bPartnerID, new Vector<>(), new Vector<BigDecimal>(), amount, true, paymentRule);
            genRet.setTrxName(trxName);
            RetencionProcessor rp = genRet.addRetencion(payment.getCRetencionschemaId());
            rp.setAmount(amount);
            rp.setRetencionNumber(payment.getRetencDocumentno());
            rp.setDateTrx(Timestamp.valueOf(payment.getRetencDate()));
            rp.setCurrency(new MCurrency(Env.getCtx(), ppm.getC_Currency_ID(), trxName));
            // Para retenciones no se setean demas campos mediante setValues()
            genRet.save(allocationHdr);
            // Recuperar el ID de la factura de retención (credito) recien generada
            int invoiceID = DB.getSQLValue(trxName, " SELECT C_Invoice_ID FROM M_Retencion_Invoice WHERE C_AllocationHdr_ID = ? ORDER BY M_Retencion_Invoice_ID DESC", allocationHdr.getC_AllocationHdr_ID());
            if (invoiceID>0)
                rcGenerator.addInvoicePaymentMedium(invoiceID, amount);
            else
                throw new ModelException(" Error al generar la retencion como medio de pago ");
        }

        /* Nota de crédito (invoice) */
        else if (MPOSPaymentMedium.TENDERTYPE_CreditNote.equals(ppm.getTenderType())) {

            // Recibos de cliente adelantado no pueden generarse con notas de credito
            if (isEarlyPayment)
                throw new ModelException(" Una nota de crédito no puede ser parte de un recibo de cliente anticipado ");

            int invoiceID = -1;
            try {
                invoiceID = payment.getCInvoiceId();
            }
            catch (Exception e) {
                throw new ModelException(" Error al recuperar el C_Invoice_ID de la nota de credito:" + e.getMessage());
            }
            if (invoiceID<=0)
                throw new ModelException(" C_Invoice_ID de la nota de credito invalido (debe ser mayor que cero)");
            MInvoice anInvoice = (MInvoice)invoiceRepository.getPO(info, invoiceRepository.getTableName(), new int[]{invoiceID}, trxName);
            // Verificar monedas
            validateInvoiceCurrency(anInvoice, ppm);
            // Para NC no se setean demas campos mediante serValues()
            rcGenerator.addInvoicePaymentMedium(invoiceID, amount);
        }

        /* Cheque (payment) */
        else if (MPOSPaymentMedium.TENDERTYPE_Check.equals(ppm.getTenderType())) {
            MPayment check = new MPayment(Env.getCtx(), 0, trxName);
            // Setear valores
            check.setIsReceipt(true);
            check.setC_DocType_ID(true);
            check.setC_BPartner_ID(bPartnerID);
            check.setAmount(ppm.getC_Currency_ID(), amount);
            // Antes de persistir, verificar monedas entre la cuenta bancaria y el tipo de medio de pago
            validatePaymentCurrency(check, ppm, trxName);
            // Setear en el pago el currency del tipo de medio de pago
            check.setC_Currency_ID(ppm.getC_Currency_ID());
            if (!DocumentEngine.processAndSave(check, DocAction.ACTION_Complete, true))
                throw new ModelException("Error al crear el pago con cheque: " + Msg.parseTranslation(Env.getCtx(), check.getProcessMsg()));
            rcGenerator.addPaymentPaymentMedium(check.getC_Payment_ID(), amount);
        }

        /* Tarjeta de credito (payment) */
        else if (MPOSPaymentMedium.TENDERTYPE_CreditCard.equals(ppm.getTenderType())) {
            MPayment creditCard = new MPayment(Env.getCtx(), 0, trxName);
            // Setear valores
            creditCard.setIsReceipt(true);
            creditCard.setC_DocType_ID(true);
            creditCard.setC_BPartner_ID(bPartnerID);
            creditCard.setAmount(ppm.getC_Currency_ID(), amount);
            creditCard.setC_BankAccount_ID(getBankAccountIDFromEntidadFinancieraPlan(creditCard, trxName));
            // Antes de persistir, verificar monedas entre la cuenta bancaria y el tipo de medio de pago
            validatePaymentCurrency(creditCard, ppm, trxName);
            // Setear en el pago el currency del tipo de medio de pago
            creditCard.setC_Currency_ID(ppm.getC_Currency_ID());
            if (!DocumentEngine.processAndSave(creditCard, DocAction.ACTION_Complete, true))
                throw new ModelException("Error al crear el pago con tarjeta de credito: " + Msg.parseTranslation(Env.getCtx(), creditCard.getProcessMsg()));
            rcGenerator.addPaymentPaymentMedium(creditCard.getC_Payment_ID(), amount);
        }

        /* Transferencia bancaria (payment) */
        else if (MPOSPaymentMedium.TENDERTYPE_DirectDeposit.equals(ppm.getTenderType())) {
            MPayment deposit = new MPayment(Env.getCtx(), 0, trxName);
            // Setear valores
            deposit.setIsReceipt(true);
            deposit.setC_DocType_ID(true);
            deposit.setC_BPartner_ID(bPartnerID);
            deposit.setAmount(ppm.getC_Currency_ID(), amount);
            // Antes de persistir, verificar monedas entre la cuenta bancaria y el tipo de medio de pago
            validatePaymentCurrency(deposit, ppm, trxName);
            // Setear en el pago el currency del tipo de medio de pago
            deposit.setC_Currency_ID(ppm.getC_Currency_ID());
            if (!DocumentEngine.processAndSave(deposit, DocAction.ACTION_Complete, true))
                throw new ModelException("Error al generar pago mediante transferencia bancaria o deposito: " + Msg.parseTranslation(Env.getCtx(), deposit.getProcessMsg()));

            rcGenerator.addPaymentPaymentMedium(deposit.getC_Payment_ID(), amount);
        }

        /* Pago en efectivo (cashLine) */
        else if (MPOSPaymentMedium.TENDERTYPE_Cash.equals(ppm.getTenderType())) {
            // Recuperar la caja
            int cashID = -1;
            try {
                cashID = payment.getCCashId();
            }
            catch (Exception e) {
                throw new ModelException(" Error al recuperar el C_Cash_ID correspondiente a la caja: " + e.getMessage());
            }
            if (cashID<=0)
                throw new ModelException(" C_Cash_ID invalido (debe ser mayor que cero)");
            MCash cash = new MCash(Env.getCtx(), cashID, trxName);
            // Nueva línea de caja
            MCashLine cashLine = new MCashLine(cash);
            // Setear valores
            cashLine.setAmount(amount);
            cashLine.setCashType(MCashLine.CASHTYPE_Invoice);
            cashLine.setC_BPartner_ID(bPartnerID);
            // Anters de persistir, verificar monedas
            validateCashLineCurrency(cashLine, ppm, trxName);
            // Setear en el pago el currency del tipo de medio de pago
            cashLine.setC_Currency_ID(ppm.getC_Currency_ID());
            // Persistir la nueva línea de caja (guardar, procesar y volver a guardar)
            if (!DocumentEngine.processAndSave(cashLine, DocAction.ACTION_Complete, true))
                throw new ModelException("Error al generar el pago en efectivo: " + Msg.parseTranslation(Env.getCtx(), cashLine.getProcessMsg()));

            // Incorporar el nuevo pago en efectivo
            rcGenerator.addCashLinePaymentMedium(cashLine.getC_CashLine_ID(), payment.getAmount());
        }

        /* Cobro adelantado (puede ser efectivo o payment) */
        else if (MPOSPaymentMedium.TENDERTYPE_AdvanceReceipt.equals(ppm.getTenderType())) {

            // Recibos de cliente adelantado no pueden generarse con pagos adelantados
            if (isEarlyPayment)
                throw new ModelException(" Un cobro adelantado no puede ser parte de un recibo de cliente anticipado ");

            // Si no se especifico ningun medio, error
            if (payment.getCPaymentId()==null && payment.getCCashlineId()==null)
                throw new ModelException("Cobro adelantado requiere id del pago o linea de caja a utilizar (ID debe ser no nulo)");
            // Determinar que se especifico
            int paymentID = -1;
            int cashLineID = -1;
            try {
                paymentID = payment.getCPaymentId();
            }
            catch (Exception e) {}
            try {
                cashLineID = payment.getCCashlineId();
            }
            catch (Exception e) {}
            if (paymentID <= 0 && cashLineID <= 0)
                throw new ModelException("Cobro adelantado requiere id del pago o linea de caja a utilizar (ID debe ser mayor a cero)");
            // Especificar ambos tampoco es correcto
            if (paymentID > 0 && cashLineID > 0)
                throw new ModelException("Se debe especificar SOLO el id del pago o la linea de caja a utilizar, pero no ambas");
            // Para pago anticipado no se setean demas campos mediante setValues()
            // Si es un pago...
            if (paymentID > 0) {
                // Verificar monedas
                MPayment aPayment = (MPayment)paymentRepository.getPO(info, paymentRepository.getTableName(), new int[]{paymentID}, trxName);
                validatePaymentCurrency(aPayment, ppm, trxName);
                rcGenerator.addPaymentPaymentMedium(paymentID, amount);
            }
            // Si es una linea de caja...
            else if (cashLineID > 0) {
                MCashLine cashLine = (MCashLine)cashLineRepository.getPO(info, cashLineRepository.getTableName(), new int[]{cashLineID}, trxName);
                validateCashLineCurrency(cashLine, ppm, trxName);
                rcGenerator.addCashLinePaymentMedium(cashLineID, amount);
            }
        }
    }

    /**
     * Valida que las monedas del medio de pago seleccionado y de la nota de credito coincidan
     * @param invoice nota de credito a usar como medio de pago
     * @param ppm tipo de medio de pago
     * @throws Exception en caso de no concordar las monedas
     */
    protected void validateInvoiceCurrency(MInvoice invoice, MPOSPaymentMedium ppm) throws ModelException {
        if (ppm.getC_Currency_ID() != invoice.getC_Currency_ID())
            throw new ModelException (" La moneda del tipo de medio de pago (POSPaymentMedium) difiere con respecto a la moneda de la nota de credito ");
    }

    /**
     * Valida que las monedas del medio de pago seleccionado y el payment indicado coincidan
     * @param payment el pago (transferencia, cheque, tarjeta de credito) a usar como medio de pago
     * @param ppm tipo de medio de pago
     * @throws Exception en caso de no concordar las monedas o de no poder determinar la moneda de la cuenta
     */
    protected void validatePaymentCurrency(MPayment payment, MPOSPaymentMedium ppm, String trxName) throws ModelException {
        // Para tarjeta de credito la cuenta se determina indirectamente a traves de la entidad financiera
        // En los otros casos (cheques, transferencias bancarias o pago anticipado, la cuenta se obtiene de manera directa)
        // De todas maneras esta lógica queda fuera de este método, siendo el método que invoca el encargado de setear
        // correctamente el c_bankaccount_id en cada caso
        MBankAccount ba = new MBankAccount(Env.getCtx(), payment.getC_BankAccount_ID(), trxName);
        if (ppm.getC_Currency_ID() != ba.getC_Currency_ID())
            throw new ModelException (" La moneda del tipo de medio de pago (POSPaymentMedium) difiere con respecto a la moneda de la cuenta del pago ");
    }

    /**
     * Para pagos en tarjeta se obtiene la cuenta bancaria a partir del plan de entidad financiera
     * @param payment pago con tarjeta
     * @return el ID de la cuenta bancaria asociada al pago con tarjeta
     * @throws ModelException en caso de no poder determinar la cuenta bancaria
     */
    protected int getBankAccountIDFromEntidadFinancieraPlan(MPayment payment, String trxName) throws ModelException {
        MEntidadFinancieraPlan efp = null;
        MEntidadFinanciera ef = null;
        int bankAccountID = -1;
        if (payment.getM_EntidadFinancieraPlan_ID() > 0)
            efp = new MEntidadFinancieraPlan(Env.getCtx(), payment.getM_EntidadFinancieraPlan_ID(), trxName);
        else
            throw new ModelException( " Imposible determinar la cuenta bancaria relacionada con el pago con tarjeta de credito (pago sin plan de entidad financiera) ");
        if (efp.getM_EntidadFinanciera_ID() > 0)
            ef = new MEntidadFinanciera(Env.getCtx(), efp.getM_EntidadFinanciera_ID(), trxName);
        else
            throw new ModelException( " Imposible determinar la cuenta bancaria relacionada con el pago con tarjeta de credito (plan de entidad financiera sin entidad financiera) ");
        if (ef.getC_BankAccount_ID() > 0)
            bankAccountID = ef.getC_BankAccount_ID();
        else
            throw new ModelException( " Imposible determinar la cuenta bancaria relacionada con el pago con tarjeta de credito (entidad financiera sin cuenta bancaria) ");
        return bankAccountID;
    }

    /**
     * Valida que las monedas del medio de pago seleccionado y el libro de caja coincidan
     * @param cashLine linea de caja a usar como medio de pago
     * @param ppm tipo de medio de pago
     * @throws Exception en caso de no concordar las monedas
     */
    protected void validateCashLineCurrency(MCashLine cashLine, MPOSPaymentMedium ppm, String trxName) throws ModelException {
        MCash cash = new MCash(Env.getCtx(), cashLine.getC_Cash_ID(), trxName);
        MCashBook cashBook = new MCashBook(Env.getCtx(), cash.getC_CashBook_ID(), trxName);
        if (ppm.getC_Currency_ID() != cashBook.getC_Currency_ID())
            throw new ModelException (" La moneda del tipo de medio de pago (POSPaymentMedium) difiere con respecto a la moneda del libro de caja ");
    }

    /** El copmletado del Allocation lo realiza automaticamente rcGenerator.completeAllocation */
    protected boolean shouldComplete() {
        return false;
    }

}
