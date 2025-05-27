package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.libertya.api.stub.model.Location;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;


import static org.assertj.core.api.Assertions.assertThat;

public class LocationIntegrationTests extends CommonIntegrationTests{

    /** Generacion de una location.  Basado en contenido inicial en BDD bajo compañía Libertya (1010016) */
    protected String getLocationContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Location location = new Location();
        location.setAdClientId(1010016);
        location.setAdOrgId(1010053);
        location.setAddress1("RONDEAU 1234 Piso:02 Depto:42");
        location.setCity("CAPITAL FEDERAL");
        location.setPostal("1086");
        location.setCCountryId(119);
        location.setCRegionId(1000083);

        return objectMapper.writeValueAsString(location);
    }

    // ==================
    // CREACION ENTIDADES
    // ==================

    @Test
    @Order(1)
    void createLocationShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("locations/"),
                        HttpMethod.POST,
                        new HttpEntity<>(getLocationContent(), getAuthHeaders()),
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
    void retrieveCreatedLocationShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("locations/" + entityID),
                        HttpMethod.GET,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("200");
    }

    // ======================
    // MODIFICACION ENTIDADES
    // ======================

    @Test
    @Order(500)
    void modifyLocationShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("locations/" + entityID),
                        HttpMethod.PUT,
                        new HttpEntity<>("{ \"descrption\" : \"Prueba\"}", getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("200");
    }

    @Test
    @Order(500)
    void modifyInexistentLocationShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("locations/-1"),
                        HttpMethod.PUT,
                        new HttpEntity<>("{ \"description\" : \"Prueba\"}", getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }


    // =====================
    // ELIMINACION ENTIDADES
    // =====================

    @Test
    void deleteLocationWithWrongTokenShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("locations/1"),
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getUnauthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("403");
    }

    @Test
    void deleteInexistentLocationShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("locations/-1"), // <- Registro inexistente
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }

    @Test
    void deleteLocationWithCompanyMismatchShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("locations/1002133"),	// <- Registro de AD_Client_ID = 1000005
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("401");
    }

    @Test
    @Order(1000)
    void deleteLocationShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("locations/" + entityID),	// <- Location creada cuyo AD_Client_ID = 1010016
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("204");
    }


}
