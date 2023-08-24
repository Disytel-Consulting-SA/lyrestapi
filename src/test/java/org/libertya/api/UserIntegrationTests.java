package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.libertya.api.stub.model.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserIntegrationTests extends CommonIntegrationTests {

    /** Informacion de base.  Basado en contenido inicial en BDD bajo compañía Libertya (1010016) */
    protected String getUserContent() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("Un usuario " + System.nanoTime());
        user.setPassword("FooBarPass");

        return objectMapper.writeValueAsString(user);
    }

    // ==================
    // CREACION ENTIDADES
    // ==================

    @Test
    @Order(1)
    void createUserShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("users"),
                        HttpMethod.POST,
                        new HttpEntity<>(getUserContent(), getAuthHeaders()),
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
    void retrieveCreatedUserShouldReturnOKAndNotContainPassword() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("users/" + entityID),
                        HttpMethod.GET,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(response.getBody(), User.class);
        assertThat(user.getPassword()==null);
    }

    // ======================
    // MODIFICACION ENTIDADES
    // ======================

    @Test
    @Order(500)
    void modifyUserShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("users/" + entityID),
                        HttpMethod.PUT,
                        new HttpEntity<>("{ \"descrption\" : \"Usuario de prueba\"}", getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("200");
    }

    @Test
    @Order(500)
    void modifyInexistentUserShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("users/-1"),
                        HttpMethod.PUT,
                        new HttpEntity<>("{ \"descrption\" : \"NA\"}", getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }


    // =====================
    // ELIMINACION ENTIDADES
    // =====================

    @Test
    void deleteUserWithWrongTokenShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("users/" + entityID),
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getUnauthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("403");
    }

    @Test
    void deleteInexistentUserShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("users/-1"), // <- Registro inexistente
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("404");
    }

    @Test
    void deleteUserWithCompanyMismatchShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("users/1000703"),	// <- Registro de AD_Client_ID = 1000005
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("401");
    }

    @Test
    @Order(1000)
    void deleteUserShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL("users/" + entityID),
                        HttpMethod.DELETE,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("204");
    }

}
