package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.libertya.api.stub.model.Product;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductIntegrationTests extends CommonIntegrationTests {

    /** Informacion de base.  Basado en contenido inicial en BDD bajo compañía Libertya (1010016) */
    protected String getProductContent() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        Product product = new Product();
        product.setValue("ART_" + System.nanoTime());
        product.setName("ART_" + System.nanoTime());
        product.setCUomId(100);
        product.setMProductCategoryId(1010146);
        product.setCTaxcategoryId(1010048);

        return objectMapper.writeValueAsString(product);
    }

    // ==================
    // CREACION ENTIDADES
    // ==================

    @Test
    @Order(1)
    void createProductShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("products"),
                        HttpMethod.POST,
                        new HttpEntity<>(getProductContent(), getAuthHeaders()),
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
    void retrieveCreatedProductShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("products/" + entityID),
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
    void modifyProductShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("products/" + entityID),
                        HttpMethod.PUT,
                        new HttpEntity<>("{ \"descrption\" : \"Articulo de prueba\"}", getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("200");
    }

    @Test
    @Order(500)
    void modifyInexistentProductShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("products/-1"),
                        HttpMethod.PUT,
                        new HttpEntity<>("{ \"descrption\" : \"NA\"}", getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }


    // =====================
    // ELIMINACION ENTIDADES
    // =====================

    @Test
    void deleteProductWithWrongTokenShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("products/" + entityID),
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getUnauthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("403");
    }

    @Test
    void deleteInexistentProductShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("products/-1"), // <- Registro inexistente
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }

    @Test
    void deleteProductWithCompanyMismatchShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("products/1003922"),	// <- Registro de AD_Client_ID = 1000005
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("401");
    }

    @Test
    @Order(1000)
    void deleteProductShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("products/" + entityID),
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("204");
    }

}
