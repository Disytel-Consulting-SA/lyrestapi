package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.libertya.api.stub.model.CashLine;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

public class CashLineIntegrationTests extends CommonIntegrationTests{

    /** Generacion de cashline.  Basado en contenido inicial en BDD bajo compañía Libertya (1010016) */
    protected String getCashLineContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        CashLine cashLine = new CashLine();
        cashLine.setAdClientId(1010016);
        cashLine.setAdOrgId(1010053);
        cashLine.setCCashId(1000018);
        cashLine.setLine(20);
        cashLine.setCashtype("E");
        cashLine.setCCurrencyId(102);
        cashLine.setAmount(new BigDecimal(1000));

        return objectMapper.writeValueAsString(cashLine);
    }

    // ==================
    // CREACION ENTIDADES
    // ==================

    @Test
    @Order(1)
    void createCashLineShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("cashlines/"),
                        HttpMethod.POST,
                        new HttpEntity<>(getCashLineContent(), getAuthHeaders()),
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
    void retrieveCreatedCashLineShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("cashlines/" + entityID),
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
    void modifyCashLineShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("cashlines/" + entityID),
                        HttpMethod.PUT,
                        new HttpEntity<>("{ \"descrption\" : \"Prueba\"}", getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("200");
    }

    @Test
    @Order(500)
    void modifyInexistentCashLineShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("cashlines/-1"),
                        HttpMethod.PUT,
                        new HttpEntity<>("{ \"documentno\" : \"-1\"}", getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }


    // =====================
    // ELIMINACION ENTIDADES
    // =====================

    @Test
    void deleteCashLineWithWrongTokenShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("cashlines/1"),
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getUnauthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("403");
    }

    @Test
    void deleteInexistentCashLineShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("cashlines/-1"), // <- Registro inexistente
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }
}
