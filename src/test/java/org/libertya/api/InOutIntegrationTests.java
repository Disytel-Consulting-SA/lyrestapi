package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.libertya.api.stub.model.InOut;
import org.libertya.api.stub.model.InOutDocument;
import org.libertya.api.stub.model.InOutLine;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InOutIntegrationTests extends CommonIntegrationTests {

    /** Generacion de un remito.  Basado en contenido iniciarl en BDD bajo compañía Libertya (1010016) */
    protected String getInOutContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        InOut inout = new InOut();
        inout.setIssotrx(false);
        inout.setAdOrgId(1010053);
        inout.setCBpartnerId(1012145);
        inout.setCBpartnerLocationId(1012158);
        inout.setCDoctypeId(1010522);
        inout.setMovementdate("2023-06-01 18:00:00");
        inout.setDateacct("2023-06-01 18:00:00");
        inout.setMWarehouseId(1010048);
        inout.setMovementtype("V+");

        InOutLine line1 = new InOutLine();
        line1.setLine(10);
        line1.setAdOrgId(1010053);
        line1.setMProductId(1015400);
        line1.setMovementqty(new BigDecimal(5));
        line1.setQtyentered(new BigDecimal(5));
        line1.setMLocatorId(1010278);

        InOutLine line2 = new InOutLine();
        line2.setLine(20);
        line2.setAdOrgId(1010053);
        line2.setMProductId(1015400);
        line2.setMovementqty(new BigDecimal(3));
        line2.setQtyentered(new BigDecimal(3));
        line2.setMLocatorId(1010278);

        InOutDocument doc = new InOutDocument();
        doc.setHeader(inout);
        doc.addLinesItem(line1);
        doc.addLinesItem(line2);

        return objectMapper.writeValueAsString(doc);
    }

    // ==================
    // CREACION ENTIDADES
    // ==================

    @Test
    @Order(1)
    void createInOutSouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("inouts"),
                        HttpMethod.POST,
                        new HttpEntity<>(getInOutContent(), getHeaders(new String[]{"Content-Type=application/json", "Authorization="+token})),
                        String.class);
        System.out.println(response.getBody());
        assertThat(response.getStatusCode().toString()).contains("200");
        documentID = Integer.parseInt(response.getBody());
        assertThat(documentID>0);
    }

    // =========================
    // RECUPERACION DE ENTIDADES
    // =========================

    @Test
    @Order(200)
    void retrieveCreatedInOutShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("inouts/" + documentID),
                        HttpMethod.GET,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        ObjectMapper mapper = new ObjectMapper();
        InOutDocument doc = mapper.readValue(response.getBody(), InOutDocument.class);
        assertThat(doc.getHeader().getDocstatus().equals("CO"));
    }

    // ======================
    // MODIFICACION ENTIDADES
    // ======================

    @Test
    @Order(500)
    void modifyInOutShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("inouts/" + documentID),
                        HttpMethod.PUT,
                        new HttpEntity<>("{ \"descrption\" : \"Prueba\"}", getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("200");
    }

    @Test
    @Order(500)
    void modifyInexistentInOutShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("inouts/-1"),
                        HttpMethod.PUT,
                        new HttpEntity<>("{ \"documentno\" : \"-1\"}", getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }


    // =====================
    // ELIMINACION ENTIDADES
    // =====================

    @Test
    void deleteInOutWithWrongTokenShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("inouts/1"),
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getUnauthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("403");
    }

    @Test
    void deleteInexistentInOutShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("inouts/-1"), // <- Registro inexistente
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }

    @Test
    void deleteInOutWithCompanyMismatchShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("inouts/1011608"),	// <- Registro de AD_Client_ID = 1000005
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("401");
    }

    @Test
    @Order(1000)
    void deleteProcessedInOutShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("inouts/" + documentID),	// <- Registro procesado cuyo AD_Client_ID = 1010016
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("409");
    }

}
