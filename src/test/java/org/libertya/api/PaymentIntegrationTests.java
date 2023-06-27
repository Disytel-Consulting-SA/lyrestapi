package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.libertya.api.stub.model.Payment;
import org.openXpertya.util.DB;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentIntegrationTests extends CommonIntegrationTests {

    /** Generacion de un pago.  Basado en contenido inicial en BDD bajo compañía Libertya (1010016) */
    protected String getPaymentContent() throws JsonProcessingException {

        // Se requiere una cuenta bancaria para las pruebas
        DB.executeUpdate("INSERT INTO libertya.c_bankaccount " +
                "(c_bankaccount_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_bank_id, c_currency_id, bankaccounttype, accountno, currentbalance, creditlimit, isdefault, description, iban, bban, cc, dc, oficina, sucursal, ischequesencartera, ad_componentobjectuid, c_bankaccount_location_id, electronicpaymentsaccount) " +
                "VALUES(9999999, 1010016, 1010053, 'Y', now(), 100, now(), 100, 1010112, 118, 'C', '123', 0.000000, 0.000000, 'N', '123', NULL, NULL, NULL, NULL, NULL, '321', 'N', NULL, NULL, 'N'); ");

        ObjectMapper objectMapper = new ObjectMapper();

        Payment payment = new Payment();
        payment.setIssotrx(true);
        payment.setAdOrgId(1010053);
        payment.setCBpartnerId(1012145);
        payment.setCCurrencyId(118);
        payment.setCDoctypeId(1010512);
        payment.setDateacct(TEST_DATE);
        payment.setBankPaymentDate(TEST_DATE);
        payment.setPayamt(new BigDecimal(350));
        payment.setTendertype("K");
        payment.setDateemissioncheck(TEST_DATE);
        payment.setCBankaccountId(9999999);

        return objectMapper.writeValueAsString(payment);
    }

    // ==================
    // CREACION ENTIDADES
    // ==================

    @Test
    @Order(1)
    void createPaymentShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("payments"),
                        HttpMethod.POST,
                        new HttpEntity<>(getPaymentContent(), getAuthHeaders()),
                        String.class);
        System.out.println(response.getBody());
        assertThat(response.getStatusCode().toString()).contains("200");
        documentID = Integer.parseInt(response.getBody());
        assertThat(documentID >0);
    }

    // =========================
    // RECUPERACION DE ENTIDADES
    // =========================

    @Test
    @Order(200)
    void retrieveCreatedPaymentShouldReturnOKAndAmountShouldBeCorrect() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("payments/" + documentID),
                        HttpMethod.GET,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        ObjectMapper mapper = new ObjectMapper();
        Payment payment = mapper.readValue(response.getBody(), Payment.class);
        assertThat(payment.getPayamt().equals(new BigDecimal(350)));
    }

    // ======================
    // MODIFICACION ENTIDADES
    // ======================

    @Test
    @Order(500)
    void modifyPaymentShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("payments/" + documentID),
                        HttpMethod.PUT,
                        new HttpEntity<>("{ \"descrption\" : \"Prueba\"}", getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("200");
    }

    @Test
    @Order(500)
    void modifyInexistentPaymentShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("payments/-1"),
                        HttpMethod.PUT,
                        new HttpEntity<>("{ \"documentno\" : \"-1\"}", getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }


    // =====================
    // ELIMINACION ENTIDADES
    // =====================

    @Test
    void deletePaymentWithWrongTokenShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("payments/1"),
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getUnauthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("403");
    }

    @Test
    void deleteInexistentPaymentShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("payments/-1"), // <- Registro inexistente
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }

    @Test
    void deletePaymentWithCompanyMismatchShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("payments/1001870"),	// <- Registro de AD_Client_ID = 1000005
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("401");
    }

    @Test
    @Order(1000)
    void deleteProcessedPaymentShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("payments/" + documentID),	// <- Pago procesado cuyo AD_Client_ID = 1010016
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("409");
    }

    @Test
    @Order(1000)
    void voidProcessedPaymentShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("payments/" + documentID),	// <- Pago procesado cuyo AD_Client_ID = 1010016
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("409");
    }

}
