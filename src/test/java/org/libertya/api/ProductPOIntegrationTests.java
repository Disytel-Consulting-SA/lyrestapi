package org.libertya.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openXpertya.util.DB;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * Relacion articulo-proveedor (/v1.0/productpos), con PK compuesta M_Product_ID + C_BPartner_ID.
 * El articulo y el proveedor se eligen por SQL: un proveedor activo de la compania 1010016 y un articulo sin UPC
 * que todavia no este relacionado con el (MProductPO.beforeSave rechaza un UPC repetido entre articulos).
 */
public class ProductPOIntegrationTests extends CommonIntegrationTests {

    private final ObjectMapper mapper = new ObjectMapper();

    /** Nro. de articulo del proveedor, unico por corrida */
    private final String vendorProductNo = "PO-" + System.currentTimeMillis();

    private int productID = -1;

    private int bpartnerID = -1;

    private int uomID = -1;

    protected ResponseEntity<String> call(HttpMethod method, String path, String body) {
        return restTemplate.exchange(getBaseURL("productpos" + path),
                method,
                new HttpEntity<>(body, getAuthHeaders()),
                String.class);
    }

    protected String keyPath() {
        return "/" + productID + "/" + bpartnerID;
    }

    protected JsonNode json(ResponseEntity<String> response) throws Exception {
        return mapper.readTree(response.getBody());
    }

    @Test
    @Order(1)
    void createShouldReturnCompositeID() {
        bpartnerID = DB.getSQLValue(null, "SELECT MIN(c_bpartner_id) FROM c_bpartner WHERE ad_client_id = 1010016 AND isactive = 'Y' AND isvendor = 'Y'");
        assumeTrue(bpartnerID > 0, "La compania 1010016 no tiene proveedores activos");
        productID = DB.getSQLValue(null, "SELECT MIN(p.m_product_id) FROM m_product p WHERE p.ad_client_id = 1010016 AND p.isactive = 'Y' " +
                " AND COALESCE(TRIM(p.upc), '') = '' " +
                " AND NOT EXISTS (SELECT 1 FROM m_product_po po WHERE po.m_product_id = p.m_product_id AND po.c_bpartner_id = ?)", bpartnerID);
        assumeTrue(productID > 0, "No hay articulos sin UPC y sin relacion con el proveedor " + bpartnerID);
        uomID = DB.getSQLValue(null, "SELECT c_uom_id FROM m_product WHERE m_product_id = ?", productID);

        ResponseEntity<String> response = call(HttpMethod.POST, "",
                "{\"m_product_id\": " + productID + ", \"c_bpartner_id\": " + bpartnerID + ", \"c_uom_id\": " + uomID +
                        ", \"vendorproductno\": \"" + vendorProductNo + "\", \"iscurrentvendor\": true, \"isactive\": true}");
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(productID + "-" + bpartnerID);
    }

    @Test
    @Order(2)
    void createDuplicateShouldReturnConflict() {
        assumeTrue(productID > 0, "No se creo la relacion");
        ResponseEntity<String> response = call(HttpMethod.POST, "",
                "{\"m_product_id\": " + productID + ", \"c_bpartner_id\": " + bpartnerID + "}");
        assertThat(response.getStatusCode().value()).isEqualTo(409);
    }

    @Test
    @Order(10)
    void retrieveShouldReturnTheRelation() throws Exception {
        assumeTrue(productID > 0, "No se creo la relacion");
        ResponseEntity<String> response = call(HttpMethod.GET, keyPath(), null);
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        JsonNode record = json(response);
        assertThat(record.get("m_product_id").asInt()).isEqualTo(productID);
        assertThat(record.get("c_bpartner_id").asInt()).isEqualTo(bpartnerID);
        assertThat(record.get("c_uom_id").asInt()).isEqualTo(uomID);
        assertThat(record.get("vendorproductno").asText()).isEqualTo(vendorProductNo);
        assertThat(record.get("iscurrentvendor").asBoolean()).isTrue();
        assertThat(record.get("isactive").asBoolean()).isTrue();
    }

    @Test
    @Order(11)
    void retrieveAllShouldFilterByKey() throws Exception {
        assumeTrue(productID > 0, "No se creo la relacion");
        ResponseEntity<String> response = call(HttpMethod.GET,
                "?filter=m_product_id=" + productID + " AND c_bpartner_id=" + bpartnerID, null);
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        JsonNode records = json(response);
        assertThat(records.size()).isEqualTo(1);
        assertThat(records.get(0).get("vendorproductno").asText()).isEqualTo(vendorProductNo);
    }

    @Test
    @Order(12)
    void retrieveMissingShouldReturnNotFound() {
        assumeTrue(productID > 0, "No se creo la relacion");
        ResponseEntity<String> response = call(HttpMethod.GET, "/" + productID + "/0", null);
        assertThat(response.getStatusCode().value()).isEqualTo(404);
    }

    @Test
    @Order(20)
    void updateShouldChangeOnlyTheSentColumns() throws Exception {
        assumeTrue(productID > 0, "No se creo la relacion");
        // Las columnas clave con el mismo valor de la URL se aceptan (reenvio de lo recibido en un GET)
        ResponseEntity<String> response = call(HttpMethod.PUT, keyPath(),
                "{\"m_product_id\": " + productID + ", \"c_bpartner_id\": " + bpartnerID +
                        ", \"vendorproductno\": \"" + vendorProductNo + "-B\", \"iscurrentvendor\": false}");
        assertThat(response.getStatusCode().value()).isEqualTo(200);

        JsonNode record = json(call(HttpMethod.GET, keyPath(), null));
        assertThat(record.get("vendorproductno").asText()).isEqualTo(vendorProductNo + "-B");
        assertThat(record.get("iscurrentvendor").asBoolean()).isFalse();
        assertThat(record.get("c_uom_id").asInt()).isEqualTo(uomID);
        assertThat(record.get("isactive").asBoolean()).isTrue();
    }

    @Test
    @Order(21)
    void updateChangingKeyShouldReturnConflict() {
        assumeTrue(productID > 0, "No se creo la relacion");
        ResponseEntity<String> response = call(HttpMethod.PUT, keyPath(),
                "{\"c_bpartner_id\": " + (bpartnerID + 1) + "}");
        assertThat(response.getStatusCode().value()).isEqualTo(409);
        assertThat(response.getBody()).contains("C_BPartner_ID");

        response = call(HttpMethod.PUT, keyPath(),
                "{\"additionalvalues\": [{\"key\": \"m_product_id\", \"value\": \"" + (productID + 1) + "\"}]}");
        assertThat(response.getStatusCode().value()).isEqualTo(409);
        assertThat(response.getBody()).contains("M_Product_ID");

        // La relacion sigue identificada por la clave original
        assertThat(call(HttpMethod.GET, keyPath(), null).getStatusCode().value()).isEqualTo(200);
    }

    @Test
    @Order(30)
    void updateMissingShouldReturnNotFound() {
        assumeTrue(productID > 0, "No se creo la relacion");
        ResponseEntity<String> response = call(HttpMethod.PUT, "/" + productID + "/0",
                "{\"vendorproductno\": \"X\"}");
        assertThat(response.getStatusCode().value()).isEqualTo(404);
    }

    @Test
    @Order(1000)
    void deleteShouldRemoveTheRelation() {
        assumeTrue(productID > 0, "No se creo la relacion");
        ResponseEntity<String> response = call(HttpMethod.DELETE, keyPath(), null);
        assertThat(response.getStatusCode().value()).isEqualTo(204);
        assertThat(call(HttpMethod.GET, keyPath(), null).getStatusCode().value()).isEqualTo(404);
    }
}
