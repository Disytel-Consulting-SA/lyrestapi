package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.libertya.api.stub.model.*;
import org.openXpertya.util.DB;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AllocationIntegrationTests extends CommonIntegrationTests {

    /** Generacion de un allocation.  Basado en contenido inicial en BDD bajo compañía Libertya (1010016) */
    protected String getAllocationContent() throws JsonProcessingException {

        // Se requiere una factura
        DB.executeUpdate(" INSERT INTO c_invoice " +
                " (c_invoice_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, issotrx, documentno, docstatus, docaction, processing, processed, posted, c_doctype_id, c_doctypetarget_id, c_order_id, description, isapproved, istransferred, isprinted, salesrep_id, dateinvoiced, dateprinted, dateacct, c_bpartner_id, c_bpartner_location_id, poreference, isdiscountprinted, dateordered, c_currency_id, paymentrule, c_paymentterm_id, c_charge_id, chargeamt, totallines, grandtotal, m_pricelist_id, istaxincluded, c_campaign_id, c_project_id, c_activity_id, ispaid, c_payment_id, c_cashline_id, createfrom, generateto, sendemail, ad_user_id, copyfrom, isselfservice, ad_orgtrx_id, user1_id, user2_id, c_conversiontype_id, ispayschedulevalid, ref_invoice_id, isindispute, c_letra_comprobante_id, datecai, numerocomprobante, puntodeventa, cai, cuit, numerodedocumento, c_region_id, c_invoice_orig_id, nombrecli, caja, invoice_adress, fiscalalreadyprinted, nroidentificcliente, cae, vtocae, idcae, caecbte, caeerror, createcashline, iscopy, authcode, authmatch, c_posjournal_id, manualgeneraldiscount, notexchangeablecredit, initialcurrentaccountamt, c_pospaymentmedium_id, managedragorderdiscounts, isexchange, manualdocumentno, applypercepcion, tipocomprobante, m_rma_id, c_pospaymentmedium_credit_id, netamount, fiscaldescription, printtype, updateorderqty, c_region_delivery_id, isvoidable, daterecepted, fechadetcparaactualizarprecios, importclearance, skipipnocaevalidation, manageelectronicinvoice, m_authorizationchain_id, authorize, oldgrandtotal, m_inouttransport_id, authorizationchainstatus, managedragordersurcharges, c_order_orig_id, originvtipo, originvptovta, originvnro, originvfecha, deliveryviarule) " +
                " VALUES(99999999, 1010016, 1010053, 'Y', now(), 100, now(), 100, 'Y', '100073', 'CO', 'CL', 'N', 'Y', 'N', 1010507, 1010507, NULL, NULL, 'Y', 'N', 'N', 100, now(), NULL, now(), 1012145, 1012158, NULL, 'N', NULL, 118, 'S', 1010083, NULL, 0.00, 350.00, 350.00, 1010595, 'N', NULL, NULL, NULL, 'N', NULL, NULL, NULL, NULL, 'N', NULL, NULL, 'N', NULL, NULL, NULL, NULL, 'Y', NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ADMINISTRACION FEDERAL DE INGRESOS PUBLI', NULL, 'YRIGOYEN HIPOLITO 370 Piso:04 Depto:148, CAPITAL FEDERAL,  1086, Buenos Aires ', 'N', '33-69345023-9', NULL, NULL, NULL, NULL, NULL, 'Y', 'N', NULL, 'Y', NULL, 0.00, 'N', 350.00, NULL, 'N', 'N', 'N', 'Y', NULL, NULL, NULL, 350.00, NULL, NULL, 'N', NULL, 'N', NULL, NULL, NULL, 'N', 'N', NULL, NULL, 0.00, NULL, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL); ");


        // Se requiere una cuenta bancaria para las pruebas
        DB.executeUpdate("INSERT INTO c_bankaccount " +
                "(c_bankaccount_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_bank_id, c_currency_id, bankaccounttype, accountno, currentbalance, creditlimit, isdefault, description, iban, bban, cc, dc, oficina, sucursal, ischequesencartera, ad_componentobjectuid, c_bankaccount_location_id, electronicpaymentsaccount) " +
                "VALUES(99999999, 1010016, 1010053, 'Y', now(), 100, now(), 100, 1010112, 118, 'C', '123', 0.000000, 0.000000, 'N', '123', NULL, NULL, NULL, NULL, NULL, '321', 'N', NULL, NULL, 'N'); ");

        // Se requiere un pago adelantado
        DB.executeUpdate(" INSERT INTO c_payment " +
                " (c_payment_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, documentno, datetrx, isreceipt, c_doctype_id, trxtype, c_bankaccount_id, c_bpartner_id, c_invoice_id, c_bp_bankaccount_id, c_paymentbatch_id, tendertype, creditcardtype, creditcardnumber, creditcardvv, creditcardexpmm, creditcardexpyy, micr, routingno, accountno, checkno, a_name, a_street, a_city, a_state, a_zip, a_ident_dl, a_ident_ssn, a_email, voiceauthcode, orig_trxid, ponum, c_currency_id, payamt, discountamt, writeoffamt, taxamt, isapproved, r_pnref, r_result, r_respmsg, r_authcode, r_avsaddr, r_avszip, r_info, processing, oprocessing, docstatus, docaction, isreconciled, isallocated, isonline, processed, posted, isoverunderpayment, overunderamt, a_country, c_project_id, isselfservice, chargeamt, c_charge_id, isdelayedcapture, r_authcode_dc, r_cvv2match, r_pnref_dc, swipe, ad_orgtrx_id, c_campaign_id, c_activity_id, user1_id, user2_id, c_conversiontype_id, description, dateacct, c_order_id, isprepayment, ref_payment_id, checked, m_boletadeposito_id, issotrx, a_bank, a_cuit, duedate, couponnumber, m_entidadfinancieraplan_id, authcode, authmatch, c_posjournal_id, posnet, c_pospaymentmedium_id, c_bank_id, original_ref_payment_id, dateemissioncheck, couponbatchnumber, checkstatus, rejecteddate, rejectedcomments, bank_payment_documentno, bank_payment_date, c_bankpaymentstatus_id, auditstatus, ismanual, accounting_c_charge_id, banklist_registerno, bank_payment_msg_description, c_invoice_check_rejected_id) " +
                " VALUES(99999999, 1010016, 1010053, 'Y', now(), 100, now(), 100, '1000013', now(), 'Y', 1010512, 'S', 99999999, 1012145, NULL, NULL, NULL, 'K', NULL, '', '', 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 118, 350.00, 0.00, 0.00, 0.00, 'Y', NULL, NULL, NULL, NULL, 'X', 'X', NULL, 'N', NULL, 'CO', 'CL', 'N', 'N', 'N', 'Y', 'N', 'N', 0.00, NULL, NULL, 'N', 0, NULL, 'N', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2023-06-01 18:00:00.000', NULL, 'N', NULL, 'Y', NULL, 'Y', NULL, NULL, '2023-07-10 12:39:46.829', NULL, NULL, NULL, 'Y', NULL, NULL, NULL, NULL, NULL, now(), NULL, NULL, NULL, NULL, NULL, now(), NULL, NULL, 'N', NULL, NULL, NULL, NULL); " );

        // Se requiere POSPaymentMedium de tipo pago adelantado
        DB.executeUpdate("INSERT INTO c_pospaymentmedium " +
                " (c_pospaymentmedium_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, tendertype, name, description, m_discountschema_id, datefrom, dateto, m_entidadfinanciera_id, c_currency_id, checkdeadline, bank, context, validatebeforecheckdeadlines, beforecheckdeadlinefrom, beforecheckdeadlineto, isnormalizedbank, c_bank_id, ismandatorybank, ad_componentobjectuid, ad_componentversion_id) " +
                " VALUES(99999999, 1010016, 1010053, 'Y', now(), 100, now(), 100, 'AC', 'Cobro Anticipado', NULL, NULL, '2023-07-13 00:00:00.000', '2099-12-31 00:00:00.000', NULL, 118, NULL, NULL, 'R', 'N', NULL, NULL, 'N', NULL, 'N', null, null); ");

        ObjectMapper objectMapper = new ObjectMapper();

        AllocationNew alloc = new AllocationNew();
        alloc.setAdOrgId(1010053);
        alloc.setCBpartnerId(1012142);
        alloc.setEarlypayment(false);
        alloc.setCDoctypeId(1010568);

        AllocationNewInvoices invoice = new AllocationNewInvoices();
        invoice.setCInvoiceId(99999999);
        invoice.setAmount(BigDecimal.ONE);
        ArrayList<AllocationNewInvoices> invoices = new ArrayList<>();
        invoices.add(invoice);

        AllocationNewPayments payment = new AllocationNewPayments();
        payment.setCPospaymentmediumId(99999999);
        payment.setCPaymentId(99999999);
        payment.setAmount(BigDecimal.ONE);
        ArrayList<AllocationNewPayments> payments = new ArrayList<>();
        payments.add(payment);

        alloc.setInvoices(invoices);
        alloc.setPayments(payments);

        return objectMapper.writeValueAsString(alloc);
    }

    // ==================
    // CREACION ENTIDADES
    // ==================

    @Test
    @Order(1)
    void createAllocationShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("allocations"),
                        HttpMethod.POST,
                        new HttpEntity<>(getAllocationContent(), getAuthHeaders()),
                        String.class);
        System.out.println(response.getBody());
        assertThat(response.getStatusCode().toString()).contains("200");
        entityID = Integer.parseInt(response.getBody());
        assertThat(entityID >0);
    }

    // =========================
    // RECUPERACION DE ENTIDADES
    // =========================

    @Test
    @Order(200)
    void retrieveCreatedAllocationShouldReturnOKAndAmountShouldBeCorrect() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("allocations/" + entityID),
                        HttpMethod.GET,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        ObjectMapper mapper = new ObjectMapper();
        AllocationDocument allocation = mapper.readValue(response.getBody(), AllocationDocument.class);
        assertThat(allocation.getHeader().getGrandtotal().equals(new BigDecimal(1)));
    }


    // ======================
    // MODIFICACION ENTIDADES
    // ======================

    @Test
    @Order(500)
    void modifyAllocationShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("allocations/" + entityID),
                        HttpMethod.PUT,
                        new HttpEntity<>("{ \"descrption\" : \"Prueba\"}", getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("200");
    }

    @Test
    @Order(500)
    void modifyInexistentAllocationShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("allocations/-1"),
                        HttpMethod.PUT,
                        new HttpEntity<>("{ \"documentno\" : \"-1\"}", getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }

    // =====================
    // ELIMINACION ENTIDADES
    // =====================

    @Test
    void deleteAllocationWithWrongTokenShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("allocations/1"),
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getUnauthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("403");
    }

    @Test
    void deleteInexistentAllocationShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("allocations/-1"), // <- Registro inexistente
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }

    @Test
    void deleteAllocationWithCompanyMismatchShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("allocations/1001810"),	// <- Registro de AD_Client_ID = 1000005
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("401");
    }

    @Test
    @Order(1000)
    void deleteProcessedAllocationShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("allocations/" + entityID),	// <- Allocation procesado cuyo AD_Client_ID = 1010016
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("409");
    }

    @Test
    @Order(1000)
    void voidProcessedAllocationShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("allocations/" + entityID + "/process?action=VO"),	// <- Pago procesado cuyo AD_Client_ID = 1010016
                        HttpMethod.PUT,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("200");
    }

    @Test
    @Order(1500)
    void voidVoidedAllocationShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("allocations/" + entityID + "/process?action=VO"),	// <- Pago procesado cuyo AD_Client_ID = 1010016
                        HttpMethod.PUT,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("409");
    }

}
