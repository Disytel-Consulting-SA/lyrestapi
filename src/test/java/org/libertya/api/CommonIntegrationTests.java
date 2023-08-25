package org.libertya.api;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Clase en comun para tests de integracion.
 * Precondiciones:
 * 	- Debe existir la informacion preexistente de la compañía 1010016 y organizacion 1010053
 * 	- La preferencia org.libertya.api.service.doc.complete en application.properties debe poseer el valor Y
 * 	- El periodo debe estar abierto para la fecha de la factura a fin de poder completar la misma. Ver TEST_DATE.
 * 	- El usuario AdminLibertya (pass AdminLibertya) debe existir y encontrarse activo
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommonIntegrationTests {

    @Autowired
    protected TestRestTemplate restTemplate;

    @LocalServerPort
    protected int port;

    /** Fecha a especificar en los documentos a crear */
    public static final String TEST_DATE = "2023-06-01 18:00:00";

    public static final String API_VERSION = "v1.0";

    /** Datos de acceso a la compañía para obtencion del token a utilizar en las pruebas */
    String[] credentials = new String[]{"username=AdminLibertya", "password=AdminLibertya", "clientid=1010016", "orgid=1010053"};

    /** Contenido del token a utilizar en las pruebas */
    String token;

    /** ID del documento creado en las subclases */
    int entityID = -1;

    /** URL base para los requests */
    protected String getBaseURL(String path) {
        return String.format("http://localhost:%s/%s/%s", port, API_VERSION, path);
    }

    /** URL para lo obtencion de tokens */
    protected String getTokenURL() {
        return String.format("http://localhost:%s/token", port);
    }

    /** Crea el header recibiendo un array de key-values, en donde cada kv posee el formato k=v */
    protected HttpHeaders getHeaders(String[] kvs) {
        HttpHeaders headers = new HttpHeaders();
        for (String kv : kvs) {
            headers.set(kv.split("=")[0], 	kv.split("=")[1]);
        }
        return headers;
    }

    /** Obtiene los headers CON autorizacion correctos */
    protected HttpHeaders getAuthHeaders() {
        return getHeaders(new String[]{"Content-Type=application/json", "Authorization="+token});
    }

    /** Obtiene los headers SIN autorizacion correctos */
    protected HttpHeaders getUnauthHeaders() {
        return getHeaders(new String[]{"Content-Type=application/json", "Authorization=Bearer FOOBAR"});
    }

    // =============
    // GESTION TOKEN
    // =============

    @Test
    @BeforeAll
    void newTokenWithCorrectCredentialsShouldReturnOK() {
        ResponseEntity<String> response =
                restTemplate.exchange(getTokenURL(),
                        HttpMethod.POST,
                        new HttpEntity<>(null, getHeaders(credentials)),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("200");
        assertThat(response.getBody()).isNotEmpty();
        assertThat(response.getBody().startsWith("Bearer"));
        token = response.getBody();
    }

    @Test
    void newTokenWithIncorrectCredentialsShouldReturnKO() {
        ResponseEntity<String> response =
                restTemplate.exchange(getTokenURL(),
                        HttpMethod.POST,
                        new HttpEntity<>(null, getHeaders(new String[]{credentials[0]})),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("403");
    }

}
