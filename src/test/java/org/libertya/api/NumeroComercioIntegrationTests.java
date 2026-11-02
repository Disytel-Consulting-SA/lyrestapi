package org.libertya.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openXpertya.util.DB;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Maestro de numeros de comercio (M_NumeroComercio), de solo lectura.
 *
 * Es el maestro que resuelve el c_bpartner_id de una liquidacion de tarjetas. Ver
 * docs/liquidaciones-tarjetas-api.md.
 *
 * EL TEST QUE MAS IMPORTA ES retrieveDebeResolverLaClaseDelPlugin. M_NumeroComercio no tiene clase generada
 * en org.openXpertya.model: es una tabla de plugin, y M_Table.getPO() devuelve null -sin excepcion- cuando no
 * encuentra la clase. Si ese test devuelve 404 contra una base que si tiene filas, lo que falta es el
 * registro del owner de la tabla en AD_Component / AD_ComponentVersion, no el endpoint.
 *
 * Contra una base que no es la de Tehuelche la tabla no existe y los tests se saltean solos.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NumeroComercioIntegrationTests extends CommonIntegrationTests {

    private static final String COMERCIOS = "numeroscomercio";

    private final ObjectMapper mapper = new ObjectMapper();

    /** Si la base tiene el diccionario de Tehuelche */
    private static Boolean esTehuelche;

    /** Un comercio activo de la compania de prueba, resuelto una sola vez */
    private static Integer comercioID;
    private static String comercioNumero;
    private static String comercioAdquirente;
    private static String comercioFinancingService;
    private static Integer comercioBPartnerID;

    @Test
    @Order(10)
    void listadoDebeTraerLosCamposDelComercio() throws Exception {
        if (!fixturesDisponibles()) return;

        ResponseEntity<String> response = get(COMERCIOS + "?limit=5");
        assertThat(response.getStatusCode().toString())
                .as("fallo el listado: " + response.getBody())
                .contains("200");

        JsonNode json = mapper.readTree(response.getBody());
        assertThat(json.isArray()).isTrue();
        assertThat(json.size()).isGreaterThan(0);

        JsonNode first = json.get(0);
        // Los tres campos que hacen util al endpoint. financingservice y value son ismandatory='N' en el
        // diccionario: si el schema se regenerara sin el filtro explicito de columnas, desaparecerian.
        assertThat(first.hasNonNull("numerocomercio")).as("falta numerocomercio").isTrue();
        assertThat(first.hasNonNull("adquirente")).as("falta adquirente").isTrue();
        assertThat(first.hasNonNull("c_bpartner_id")).as("falta c_bpartner_id").isTrue();
        assertThat(first.has("financingservice")).as("falta financingservice en el schema").isTrue();
        assertThat(first.has("value")).as("falta value en el schema").isTrue();
    }

    /**
     * La recuperacion por id es la que prueba que M_Table resuelve la clase del plugin
     * (com.hipertehuelche.sucursales.model.MNumeroComercio) a partir del owner declarado en el diccionario.
     * Sin esa resolucion getPO() devuelve null y el endpoint contesta 404 aunque la fila exista.
     */
    @Test
    @Order(20)
    void retrieveDebeResolverLaClaseDelPlugin() throws Exception {
        if (!fixturesDisponibles()) return;

        ResponseEntity<String> response = get(COMERCIOS + "/" + comercioID);
        assertThat(response.getStatusCode().toString())
                .as("no se pudo recuperar el comercio " + comercioID + ", revisar el owner de la tabla en " +
                    "AD_Component: " + response.getBody())
                .contains("200");

        JsonNode json = mapper.readTree(response.getBody());
        assertThat(json.get("m_numerocomercio_id").asInt()).isEqualTo(comercioID);
        assertThat(json.get("numerocomercio").asText()).isEqualTo(comercioNumero);
        assertThat(json.get("c_bpartner_id").asInt()).isEqualTo(comercioBPartnerID);
    }

    /**
     * La clave natural del comercio es la terna que usa MCreditCardSettlement.getM_NumeroComercio_ID():
     * numerocomercio + adquirente + financingservice. NO es unica -hay comercios repetidos entre sucursales,
     * y algunos repetidos dentro de la misma-, asi que el consumidor tiene que estar preparado para mas de
     * una fila. Lo que si es estable en los datos es el c_bpartner_id, que es el unico dato que el consumidor
     * necesita para armar la cabecera de la liquidacion.
     */
    @Test
    @Order(30)
    void filtroPorLaTernaDebeDevolverUnUnicoBPartner() throws Exception {
        if (!fixturesDisponibles()) return;
        if (comercioFinancingService == null) return;

        String filter = "numerocomercio='" + comercioNumero + "'" +
                        " AND adquirente='" + comercioAdquirente + "'" +
                        " AND financingservice='" + comercioFinancingService + "'" +
                        " AND isactive='Y'";
        ResponseEntity<String> response = getWithFilter(COMERCIOS, filter);
        assertThat(response.getStatusCode().toString())
                .as("fallo el filtro: " + response.getBody())
                .contains("200");

        JsonNode json = mapper.readTree(response.getBody());
        assertThat(json.size()).as("la terna no encontro ninguna fila").isGreaterThan(0);
        for (JsonNode row : json)
            assertThat(row.get("c_bpartner_id").asInt())
                    .as("la terna " + comercioNumero + "/" + comercioAdquirente + "/" +
                        comercioFinancingService + " apunta a mas de una entidad comercial")
                    .isEqualTo(comercioBPartnerID);
    }

    /**
     * El motivo de existir del endpoint: el c_bpartner_id NO se deduce del adquirente. Si en esta base hay
     * algun adquirente que opera contra mas de una entidad comercial, se verifica que el endpoint discrimine
     * por comercio y no por adquirente.
     */
    @Test
    @Order(40)
    void elBPartnerNoSeDeduceDelAdquirente() throws Exception {
        if (!fixturesDisponibles()) return;

        String adquirenteAmbiguo = null;
        String sql = " SELECT adquirente FROM m_numerocomercio WHERE isactive = 'Y' AND ad_client_id = ? " +
                     " GROUP BY adquirente HAVING count(DISTINCT c_bpartner_id) > 1 LIMIT 1 ";
        try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
            ps.setInt(1, clientID());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) adquirenteAmbiguo = rs.getString(1);
            }
        } catch (Exception ignored) {
            return;
        }
        // Base sin adquirentes ambiguos: no hay nada que probar aca
        if (adquirenteAmbiguo == null) return;

        ResponseEntity<String> response = getWithFilter(COMERCIOS,
                "adquirente='" + adquirenteAmbiguo + "' AND isactive='Y'");
        assertThat(response.getStatusCode().toString()).contains("200");

        JsonNode json = mapper.readTree(response.getBody());
        long distintos = java.util.stream.StreamSupport.stream(json.spliterator(), false)
                .map(row -> row.get("c_bpartner_id").asInt())
                .distinct().count();
        assertThat(distintos)
                .as("el adquirente " + adquirenteAmbiguo + " deberia operar contra mas de una entidad " +
                    "comercial; si el endpoint devuelve una sola, esta filtrando de mas")
                .isGreaterThan(1);
    }

    // =========================================================================
    // Helpers
    // =========================================================================

    private ResponseEntity<String> get(String path) {
        return restTemplate.exchange(getBaseURL(path), HttpMethod.GET,
                new HttpEntity<>(null, getAuthHeaders()), String.class);
    }

    /** GET con filter: el parametro es una clausula WHERE y hay que mandarlo ya codificado */
    private ResponseEntity<String> getWithFilter(String path, String filter) {
        URI uri = UriComponentsBuilder.fromHttpUrl(getBaseURL(path)).queryParam("filter", filter).build().encode().toUri();
        return restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(null, getAuthHeaders()), String.class);
    }

    private int clientID() {
        return Integer.parseInt(credentials[2].split("=")[1]);
    }

    private boolean diccionarioTehuelche() {
        if (esTehuelche == null)
            esTehuelche = DB.getSQLValue(null,
                    "SELECT count(1) FROM information_schema.tables WHERE table_name = 'm_numerocomercio'") > 0;
        return esTehuelche;
    }

    /**
     * Resuelve un comercio activo de la compania de prueba. Si no hay ninguno los tests se saltean: un
     * maestro vacio no es un defecto del endpoint.
     */
    private boolean fixturesDisponibles() {
        if (!diccionarioTehuelche()) return false;
        if (comercioID != null) return true;

        String sql = " SELECT m_numerocomercio_id, numerocomercio, adquirente, financingservice, c_bpartner_id " +
                     " FROM m_numerocomercio WHERE isactive = 'Y' AND ad_client_id = ? " +
                     " ORDER BY m_numerocomercio_id LIMIT 1 ";
        try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
            ps.setInt(1, clientID());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    comercioID = rs.getInt(1);
                    comercioNumero = rs.getString(2);
                    comercioAdquirente = rs.getString(3);
                    comercioFinancingService = rs.getString(4);
                    comercioBPartnerID = rs.getInt(5);
                }
            }
        } catch (Exception ignored) {
            // sin fixture, los tests se saltean
        }
        return comercioID != null;
    }
}
