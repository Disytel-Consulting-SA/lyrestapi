package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class MaestroIntegrationTests extends CommonIntegrationTests{

    /** Generacion de un maestro.  Basado en contenido inicial en BDD bajo compañía Libertya (1010016) */
    protected abstract String getMaestroContent() throws JsonProcessingException;

    // path a utilizar, ej: "locations/"
    protected abstract String getMaestroPath();

    // ==================
    // CREACION ENTIDADES
    // ==================

    @Test
    @Order(1)
    void createMaestroShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(getMaestroPath()),
                        HttpMethod.POST,
                        new HttpEntity<>(getMaestroContent(), getAuthHeaders()),
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
    void retrieveCreatedMaestroShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(getMaestroPath() + entityID),
                        HttpMethod.GET,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
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
    @Order(500)
    void modifyMaestroShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(getMaestroPath() + entityID),
                        HttpMethod.PUT,
                        new HttpEntity<>(getModificationBody(), getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("200");
    }

    // método hook para declarar el body a utilizar en la modificación del maestro, ej:
    // return "{ \"descrption\" : \"Prueba en location\"}"
    protected abstract String getModificationBody();

    @Test
    @Order(500)
    void modifyInexistentMaestroShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(getMaestroPath()+"-1"),
                        HttpMethod.PUT,
                        new HttpEntity<>(getModificationBody(), getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }


    // =====================
    // ELIMINACION ENTIDADES
    // =====================

    @Test
    void deleteMaestroWithWrongTokenShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(getMaestroPath()+"1"),
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getUnauthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("403");
    }

    @Test
    void deleteInexistentMaestroShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(getMaestroPath()+"-1"), // <- Registro inexistente
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }

    @Test
    void deleteMaestroWithCompanyMismatchShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(getMaestroPath()+getRecordIDWithComapnyMismatch()),	// <- Registro de AD_Client_ID = 1000005
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("401");
    }

    // método hook para declarar ID de registro a utilizar con distinto AD_Client_ID ej: 1000005
    protected abstract String getRecordIDWithComapnyMismatch();

    @Test
    @Order(1000)
    void deleteMaestroShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(getMaestroPath() + entityID),	// <- Maestro creado cuyo AD_Client_ID = 1010016
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("204");
    }




}
