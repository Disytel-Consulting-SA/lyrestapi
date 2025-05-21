package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public abstract class DocumentIntegrationTests extends CommonIntegrationTests{

    /** Generacion de un documento.  Basado en contenido inicial en BDD bajo compañía Libertya (1010016) */
    protected abstract String getDocumentContent() throws JsonProcessingException;

    // path a utilizar, ej: "invoices/"
    protected abstract String getDocumentPath();

    // ==================
    // CREACION ENTIDADES
    // ==================

    @Test
    @org.junit.jupiter.api.Order(1)
    void createDocumentShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(getDocumentPath()),
                        HttpMethod.POST,
                        new HttpEntity<>(getDocumentContent(), getAuthHeaders()),
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
    @org.junit.jupiter.api.Order(200)
    void retrieveCreatedOrderShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(getDocumentPath() + entityID),
                        HttpMethod.GET,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        ObjectMapper mapper = new ObjectMapper();
        assertThat(response.getStatusCode().toString()).contains("200");
    }

    // Método hook para validaciones ad-hoc post retrieve
    protected abstract void afterRetrieve(String responseBody) throws Exception;
    //ejemplo de implementación para facturas:
//    @Override
//    protected void afterRetrieve(String responseBody) throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//        InvoiceDocument doc = mapper.readValue(responseBody, InvoiceDocument.class);
//        // Validaciones específicas de facturas
//        assertThat(doc.getHeader().getGrandtotal().equals(new BigDecimal(350)));
//    }


    // ======================
    // MODIFICACION ENTIDADES
    // ======================

    @Test
    @org.junit.jupiter.api.Order(500)
    void modifyDocumentShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(getDocumentPath() + entityID),
                        HttpMethod.PUT,
                        new HttpEntity<>(getModificationBody(), getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("200");
    }

    // método hook para declarar el body a utilizar en la modificación del documento, ej:
    // return "{ \"descrption\" : \"Prueba en order\"}"
    protected abstract String getModificationBody();

    @Test
    @org.junit.jupiter.api.Order(500)
    void modifyInexistentDocumentShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(getDocumentPath() +"-1"),
                        HttpMethod.PUT,
                        new HttpEntity<>(getModificationBody(), getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }


    // =====================
    // ELIMINACION ENTIDADES
    // =====================

    @Test
    void deleteDocumentWithWrongTokenShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(getDocumentPath()+"1"),
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getUnauthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("403");
    }

    @Test
    void deleteInexistentDocumentShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(getDocumentPath()+"-1"), // <- Registro inexistente
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }

    /* PENDIENTE -> necesita customización para obtener el registro a utilizar, quizás como hook */
//    @Test
//    void deleteDocumentWithCompanyMismatchShouldReturnKO() {
//        ResponseEntity<String> response =
//                restTemplate.exchange(getBaseURL("orders/1003820"),	// <- Registro de AD_Client_ID = 1000005
//                        HttpMethod.DELETE,
//                        new HttpEntity<>(null, getAuthHeaders()),
//                        String.class);
//        assertThat(response.getStatusCode().toString()).contains("401");
//    }

    @Test
    @org.junit.jupiter.api.Order(1000)
    void deleteProcessedDocumentShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(getDocumentPath() + entityID),	// <- Document procesado cuyo AD_Client_ID = 1010016
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("409");
    }

    @Test
    @org.junit.jupiter.api.Order(1500)
    void voidCompletedDocumentShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(getDocumentPath() + entityID + "/process?action=VO"),	// <- Document procesado cuyo AD_Client_ID = 1010016
                        HttpMethod.PUT,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("200");
    }


}
