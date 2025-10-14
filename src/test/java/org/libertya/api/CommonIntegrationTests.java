package org.libertya.api;

import org.junit.jupiter.api.*;
import org.openXpertya.util.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    private static final int DEFAULT_CLIENT_ID = 1010016;
    private static final int DEFAULT_ORG_ID = 1010053;
    private static final int DEFAULT_BPARTNER_ID = 1012145;
    private static final int DEFAULT_BPARTNER_LOCATION_ID = 1012158;
    private static final int DEFAULT_LETRA_COMPROBANTE_ID = 1010277;
    private static final int DEFAULT_CURRENCY_ID = 102;

    /** Datos de acceso a la compañía para obtencion del token a utilizar en las pruebas */
    String[] credentials = new String[]{"username=AdminLibertya", "password=AdminLibertya", "clientid=" + DEFAULT_CLIENT_ID, "orgid=" + DEFAULT_ORG_ID};

    /** Contenido del token a utilizar en las pruebas */
    String token;

    /** ID del documento creado en las subclases */
    int entityID = -1;

    @Value("${org.libertya.tests.use-dynamic-defaults:false}")
    private boolean useDynamicDefaults;

    int defaultBPartnerId;
    int defaultBPartnerLocationId;
    int defaultLetraComprobante;
    int defaultCurrencyId;

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

    protected String getFormattedDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
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

    @BeforeAll
    void setValues(){
        BPartnerWithLocation defaultBPartner = findBPartnerWithLocation();
        defaultBPartnerId = defaultBPartner.getBpartnerId();
        defaultBPartnerLocationId = defaultBPartner.getLocationId();
        defaultLetraComprobante = findLetraComprobanteId();
        defaultCurrencyId = findCurrencyId();
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

    // ============================
    // GESTION DE IDs POR DEFECTO
    // ============================

    int findBPartnerId() {
        return findBPartnerWithLocation().getBpartnerId();
    }

    int findBPartnerLocationId() {
        return findBPartnerWithLocation().getLocationId();
    }

    private BPartnerWithLocation findBPartnerWithLocation() {
        final String sql = "SELECT bp.c_bpartner_id, bpl.c_bpartner_location_id " +
                "FROM c_bpartner bp " +
                "JOIN c_bpartner_location bpl ON bpl.c_bpartner_id = bp.c_bpartner_id " +
                "AND bpl.ad_client_id = bp.ad_client_id " +
                "AND bpl.isactive = 'Y' " +
                "WHERE bp.ad_client_id=" + DEFAULT_CLIENT_ID + " AND bp.ad_org_id=" + DEFAULT_ORG_ID + " " +
                "AND bp.isactive='Y' " +
                "AND bp.trxenabled='Y' " +
                "ORDER BY bp.created DESC, bpl.created DESC limit 1";
        BPartnerWithLocation fallback = new BPartnerWithLocation(DEFAULT_BPARTNER_ID, DEFAULT_BPARTNER_LOCATION_ID);
        if (!useDynamicDefaults) {
            return fallback;
        }
        try (PreparedStatement ps = DB.prepareStatement(sql, null);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int partnerId = rs.getInt(1);
                int locationId = rs.getInt(2);
                if (locationId == 0) {
                    return fallback;
                }
                return new BPartnerWithLocation(partnerId, locationId);
            }
        } catch (SQLException ex) {
            throw new IllegalStateException("No se pudo resolver el c_bpartner_id a utilizar", ex);
        }
        return fallback;
    }

    int findLetraComprobanteId() {
        final String sql = "select c_letra_comprobante_id from c_letra_comprobante where letra = 'A' or isdefault = 'Y' limit 1;";
        return fetchId(sql, DEFAULT_LETRA_COMPROBANTE_ID, "No se pudo resolver el c_letra_comprobante_id a utilizar");
    }

    int findCurrencyId() {
        final String sql = "SELECT c_currency_id " +
                "FROM c_invoice " +
                "WHERE ad_client_id = " + DEFAULT_CLIENT_ID + " AND ad_org_id = " + DEFAULT_ORG_ID + " " +
                "AND isactive = 'Y' " +
                "ORDER BY created DESC " +
                "LIMIT 1";
        return fetchId(sql, DEFAULT_CURRENCY_ID, "No se pudo resolver el c_currency_id a utilizar");
    }

    private int fetchId(String sql, int defaultValue, String errorMessage) {
        if (!useDynamicDefaults) {
            return defaultValue;
        }
        try (PreparedStatement ps = DB.prepareStatement(sql, null);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw new IllegalStateException(errorMessage, ex);
        }
        return defaultValue;
    }

    private static class BPartnerWithLocation {
        private final int bpartnerId;
        private final int locationId;

        BPartnerWithLocation(int bpartnerId, int locationId) {
            this.bpartnerId = bpartnerId;
            this.locationId = locationId;
        }

        int getBpartnerId() {
            return bpartnerId;
        }

        int getLocationId() {
            return locationId;
        }
    }
}
