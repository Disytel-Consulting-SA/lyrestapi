package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.libertya.api.stub.model.Inventory;
import org.libertya.api.stub.model.InventoryDocument;
import org.libertya.api.stub.model.InventoryLine;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InventoryIntegrationTest extends CommonIntegrationTests {

    /** Generacion de un inventario.  Basado en contenido inicial en BDD bajo compañía Libertya (1010016) */
    protected String getInventoryContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Inventory inv = new Inventory();
        inv.setAdOrgId(1010053);
        inv.setCDoctypeId(1010529);
        inv.setDocstatus("DR");
        inv.setInventorykind("PI");
        inv.setMWarehouseId(1010048);

        InventoryLine line = new InventoryLine();
        line.setAdOrgId(1010053);
        line.setMLocatorId(1010278);
        line.setMProductId(1015400);
        line.setQtybook(new BigDecimal(90));
        line.setQtycount(new BigDecimal(90));

        InventoryDocument doc = new InventoryDocument();
        doc.setHeader(inv);
        doc.addLinesItem(line);

        return objectMapper.writeValueAsString(doc);

    }

    // ==================
    // CREACION ENTIDADES
    // ==================

    @Test
    @Order(1)
    void createInventoryShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("inventories"),
                        HttpMethod.POST,
                        new HttpEntity<>(getInventoryContent(), getAuthHeaders()),
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
    void retrieveCreatedInventoryShouldReturnOKAndStatusShouldBeCorrect() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("inventories/" + entityID),
                        HttpMethod.GET,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        ObjectMapper mapper = new ObjectMapper();
        InventoryDocument doc = mapper.readValue(response.getBody(), InventoryDocument.class);
        assertThat("CO".equalsIgnoreCase(doc.getHeader().getDocstatus()));
    }

    // ======================
    // MODIFICACION ENTIDADES
    // ======================

    @Test
    @Order(500)
    void modifyInventoryShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("inventories/" + entityID),
                        HttpMethod.PUT,
                        new HttpEntity<>("{ \"descrption\" : \"Prueba\"}", getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("200");
    }

    @Test
    @Order(500)
    void modifyInexistentInventoryShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("inventories/-1"),
                        HttpMethod.PUT,
                        new HttpEntity<>("{ \"documentno\" : \"-1\"}", getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }

    // =====================
    // ELIMINACION ENTIDADES
    // =====================

    @Test
    void deleteInventoryWithWrongTokenShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("inventories/1"),
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getUnauthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("403");
    }

    @Test
    void deleteInexistentInventoryShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("inventories/-1"), // <- Registro inexistente
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }

    @Test
    void deleteInventoryWithCompanyMismatchShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("inventories/1000240"),	// <- Registro de AD_Client_ID = 1000005
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("401");
    }

    @Test
    @Order(1000)
    void deleteProcessedInventoryShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("inventories/" + entityID),	// <- Inventario procesado cuyo AD_Client_ID = 1010016
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("409");
    }


    @Test
    @Order(1500)
    void voidCompletedInventoryShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("inventories/" + entityID + "/process?action=VO"),	// <- Inventario procesado cuyo AD_Client_ID = 1010016
                        HttpMethod.PUT,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("200");
    }
}
