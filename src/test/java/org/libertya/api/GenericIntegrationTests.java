package org.libertya.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openXpertya.model.M_Table;
import org.openXpertya.util.DB;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * Endpoint generico /v1.0/generic/{table}, ejercitado solo con tablas del core.
 * Precondiciones: las de CommonIntegrationTests, y para el flujo de GL_Journal los datos contables de la
 * compania 1010016 y el periodo ene-24 abierto para GLJ (ver docs/planes/plan-asientos-manuales.md §12.2).
 */
public class GenericIntegrationTests extends CommonIntegrationTests {

    /** Distinta de TEST_DATE: el periodo de TEST_DATE esta cerrado para GLJ. Ver plan-asientos-manuales.md §12.2 */
    private static final String TEST_DATE_GLJ = "2024-01-10";

    private static final int ORG_ID = 1010053;
    private static final int GLJ_DOCTYPE_ID = 1010506;
    private static final int GLJ_ACCTSCHEMA_ID = 1010016;
    private static final int GLJ_CURRENCY_ID = 118;
    private static final int GLJ_CATEGORY_ID = 1010098;
    private static final int GLJ_CONVERSIONTYPE_ID = 114;
    private static final int GLJ_ACCOUNT_DR_ID = 1012830;
    private static final int GLJ_ACCOUNT_CR_ID = 1012839;

    private final ObjectMapper mapper = new ObjectMapper();

    /** Value de la campania creada, unico por corrida */
    private final String campaignValue = "GEN-" + System.currentTimeMillis();

    private int campaignID = -1;

    private int journalID = -1;

    protected ResponseEntity<String> call(HttpMethod method, String path, String body) {
        return restTemplate.exchange(getBaseURL("generic/" + path),
                method,
                new HttpEntity<>(body, getAuthHeaders()),
                String.class);
    }

    protected JsonNode json(ResponseEntity<String> response) throws Exception {
        return mapper.readTree(response.getBody());
    }

    // =====================
    // CRUD DE UN MAESTRO
    // =====================

    @Test
    @Order(1)
    void createMasterShouldReturnOK() {
        ResponseEntity<String> response = call(HttpMethod.POST, "C_Campaign",
                "{\"value\": \"" + campaignValue + "\", \"name\": \"Campania generica\", \"description\": \"original\"}");
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        campaignID = Integer.parseInt(response.getBody());
        assertThat(campaignID).isGreaterThan(0);
    }

    @Test
    @Order(2)
    void retrieveMasterShouldReturnColumnsAsLowercaseKeys() throws Exception {
        // El nombre de la tabla no distingue mayusculas
        ResponseEntity<String> response = call(HttpMethod.GET, "c_campaign/" + campaignID, null);
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        JsonNode record = json(response);
        assertThat(record.get("c_campaign_id").asInt()).isEqualTo(campaignID);
        assertThat(record.get("value").asText()).isEqualTo(campaignValue);
        assertThat(record.get("isactive").asBoolean()).isTrue();
        assertThat(record.get("ad_client_id").asInt()).isEqualTo(1010016);
        // Las fechas se informan como en los DTO
        assertThat(record.get("created").asText()).matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}.*");
    }

    @Test
    @Order(3)
    void retrieveMasterWithFieldsShouldReturnOnlyThoseFields() throws Exception {
        ResponseEntity<String> response = call(HttpMethod.GET, "C_Campaign/" + campaignID + "?fields=value,name", null);
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        Set<String> keys = new HashSet<>();
        json(response).fieldNames().forEachRemaining(keys::add);
        assertThat(keys).containsExactlyInAnyOrder("value", "name");
    }

    @Test
    @Order(4)
    void listMastersWithFilterShouldReturnCreatedAndTotal() throws Exception {
        ResponseEntity<String> response = call(HttpMethod.GET,
                "C_Campaign?filter=value='" + campaignValue + "'&includeTotal=true", null);
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        JsonNode records = json(response);
        assertThat(records.isArray()).isTrue();
        assertThat(records.size()).isEqualTo(1);
        assertThat(records.get(0).get("c_campaign_id").asInt()).isEqualTo(campaignID);
        assertThat(response.getHeaders().getFirst("X-Total-Count")).isEqualTo("1");
    }

    @Test
    @Order(5)
    void updateMasterShouldModifyOnlySentColumns() throws Exception {
        ResponseEntity<String> response = call(HttpMethod.PUT, "C_Campaign/" + campaignID, "{\"description\": \"modificada\"}");
        assertThat(response.getStatusCode().value()).isEqualTo(200);

        JsonNode record = json(call(HttpMethod.GET, "C_Campaign/" + campaignID, null));
        assertThat(record.get("description").asText()).isEqualTo("modificada");
        assertThat(record.get("name").asText()).isEqualTo("Campania generica");
    }

    @Test
    @Order(6)
    void unknownKeyShouldReturnConflictNamingTheKey() {
        ResponseEntity<String> response = call(HttpMethod.PUT, "C_Campaign/" + campaignID, "{\"nmae\": \"x\"}");
        assertThat(response.getStatusCode().value()).isEqualTo(409);
        assertThat(response.getBody()).contains("nmae");

        response = call(HttpMethod.POST, "C_Campaign", "{\"value\": \"" + campaignValue + "-2\", \"nmae\": \"x\"}");
        assertThat(response.getStatusCode().value()).isEqualTo(409);
        assertThat(response.getBody()).contains("nmae");
    }

    @Test
    @Order(7)
    void processOnMasterShouldReturnConflict() {
        ResponseEntity<String> response = call(HttpMethod.PUT, "C_Campaign/" + campaignID + "/process?action=CO", null);
        assertThat(response.getStatusCode().value()).isEqualTo(409);
        assertThat(response.getBody()).contains("no es un documento");
    }

    @Test
    @Order(8)
    void deleteMasterShouldReturnNoContent() {
        ResponseEntity<String> response = call(HttpMethod.DELETE, "C_Campaign/" + campaignID, null);
        assertThat(response.getStatusCode().value()).isEqualTo(204);

        response = call(HttpMethod.GET, "C_Campaign/" + campaignID, null);
        assertThat(response.getStatusCode().value()).isEqualTo(404);
    }

    // ======================================
    // DOCUMENTO EN VARIAS LLAMADAS (GL_Journal)
    // ======================================

    @Test
    @Order(20)
    void createDocumentHeaderShouldLeaveItInDraft() throws Exception {
        ResponseEntity<String> response = call(HttpMethod.POST, "GL_Journal",
                "{\"ad_org_id\": " + ORG_ID + ", \"c_acctschema_id\": " + GLJ_ACCTSCHEMA_ID +
                ", \"c_doctype_id\": " + GLJ_DOCTYPE_ID + ", \"c_currency_id\": " + GLJ_CURRENCY_ID +
                ", \"gl_category_id\": " + GLJ_CATEGORY_ID + ", \"c_conversiontype_id\": " + GLJ_CONVERSIONTYPE_ID +
                ", \"dateacct\": \"" + TEST_DATE_GLJ + "\", \"datedoc\": \"" + TEST_DATE_GLJ + "\"" +
                ", \"postingtype\": \"A\", \"description\": \"Asiento del endpoint generico\"}");
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        journalID = Integer.parseInt(response.getBody());

        // El alta no completa: completar es siempre un process explicito
        JsonNode record = json(call(HttpMethod.GET, "GL_Journal/" + journalID + "?fields=docstatus", null));
        assertThat(record.get("docstatus").asText()).isEqualTo("DR");
    }

    @Test
    @Order(21)
    void addDocumentLinesShouldReturnOK() {
        // A diferencia de POST /journals, las lineas tienen que traer ad_org_id y dateacct
        for (String amounts : new String[]{
                "\"c_elementvalue_id\": " + GLJ_ACCOUNT_DR_ID + ", \"amtsourcedr\": 100, \"amtsourcecr\": 0",
                "\"c_elementvalue_id\": " + GLJ_ACCOUNT_CR_ID + ", \"amtsourcedr\": 0, \"amtsourcecr\": 100"}) {
            ResponseEntity<String> response = call(HttpMethod.POST, "GL_JournalLine",
                    "{\"gl_journal_id\": " + journalID + ", \"ad_org_id\": " + ORG_ID +
                    ", \"dateacct\": \"" + TEST_DATE_GLJ + "\", \"c_currency_id\": " + GLJ_CURRENCY_ID +
                    ", \"c_conversiontype_id\": " + GLJ_CONVERSIONTYPE_ID + ", " + amounts + "}");
            assertThat(response.getStatusCode().value()).isEqualTo(200);
        }
    }

    @Test
    @Order(22)
    void completeDocumentShouldLeaveItCompleted() throws Exception {
        ResponseEntity<String> response = call(HttpMethod.PUT, "GL_Journal/" + journalID + "/process?action=CO", null);
        assertThat(response.getStatusCode().value()).isEqualTo(200);

        JsonNode record = json(call(HttpMethod.GET, "GL_Journal/" + journalID, null));
        assertThat(record.get("docstatus").asText()).isEqualTo("CO");
        assertThat(record.get("totaldr").decimalValue()).isEqualByComparingTo(new BigDecimal(100));
        assertThat(record.get("totalcr").decimalValue()).isEqualByComparingTo(new BigDecimal(100));
    }

    // =====================================
    // PARIDAD CON LOS ENDPOINTS TIPADOS
    // =====================================

    @Test
    void genericRecordShouldMatchTypedEndpoint() throws Exception {
        int bpartnerID = DB.getSQLValue(null, "SELECT MIN(c_bpartner_id) FROM c_bpartner WHERE ad_client_id = 1010016 AND isactive = 'Y'");
        assumeTrue(bpartnerID > 0, "La compania 1010016 no tiene entidades comerciales activas");
        ResponseEntity<String> typed = restTemplate.exchange(getBaseURL("bpartners/" + bpartnerID),
                HttpMethod.GET, new HttpEntity<>(null, getAuthHeaders()), String.class);
        ResponseEntity<String> generic = call(HttpMethod.GET, "C_BPartner/" + bpartnerID, null);
        assertThat(typed.getStatusCode().value()).isEqualTo(200);
        assertThat(generic.getStatusCode().value()).isEqualTo(200);

        JsonNode typedRecord = json(typed);
        JsonNode genericRecord = json(generic);
        int common = 0;
        for (Iterator<String> it = typedRecord.fieldNames(); it.hasNext(); ) {
            String key = it.next();
            if ("referencedvalues".equals(key) || "additionalvalues".equals(key) || !genericRecord.has(key))
                continue;
            assertThat(genericRecord.get(key).asText()).as(key).isEqualTo(typedRecord.get(key).asText());
            common++;
        }
        assertThat(common).isGreaterThan(10);
    }

    // =====================
    // CASOS NEGATIVOS
    // =====================

    @Test
    void inexistentTableShouldReturnNotFound() {
        assertThat(call(HttpMethod.GET, "NoExisteLaTabla", null).getStatusCode().value()).isEqualTo(404);
        assertThat(call(HttpMethod.GET, "NoExisteLaTabla/1", null).getStatusCode().value()).isEqualTo(404);
        assertThat(call(HttpMethod.POST, "NoExisteLaTabla", "{}").getStatusCode().value()).isEqualTo(404);
        assertThat(call(HttpMethod.PUT, "NoExisteLaTabla/1", "{}").getStatusCode().value()).isEqualTo(404);
        assertThat(call(HttpMethod.DELETE, "NoExisteLaTabla/1", null).getStatusCode().value()).isEqualTo(404);
    }

    @Test
    void tableWithoutModelClassShouldReturnConflict() {
        String tableName = findPluginTableWithoutModelClass();
        assumeTrue(tableName != null, "La base no tiene tablas de plugin sin clase de modelo en el classpath");
        ResponseEntity<String> response = call(HttpMethod.GET, tableName, null);
        assertThat(response.getStatusCode().value()).isEqualTo(409);
        assertThat(response.getBody()).contains("No se encontro la clase de modelo").contains(tableName);
    }

    @Test
    void compositeKeyTableShouldReturnConflict() {
        ResponseEntity<String> response = call(HttpMethod.GET, "C_InvoiceTax", null);
        assertThat(response.getStatusCode().value()).isEqualTo(409);
        assertThat(response.getBody()).contains("clave simple");
    }

    @Test
    void viewShouldBeReadOnly() throws Exception {
        // La clave de RV_BPartner es C_BPartner_ID, no RV_BPartner_ID: tanto el listado como el detalle la respetan
        ResponseEntity<String> response = call(HttpMethod.GET, "RV_BPartner?limit=1", null);
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        JsonNode records = json(response);
        assertThat(records.size()).isEqualTo(1);
        assertThat(records.get(0).isObject()).isTrue();
        int bpartnerID = records.get(0).get("c_bpartner_id").asInt();

        response = call(HttpMethod.GET, "RV_BPartner/" + bpartnerID, null);
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(json(response).get("c_bpartner_id").asInt()).isEqualTo(bpartnerID);

        response = call(HttpMethod.POST, "RV_BPartner", "{\"name\": \"x\"}");
        assertThat(response.getStatusCode().value()).isEqualTo(409);
        assertThat(response.getBody()).contains("vista");
    }

    @Test
    void wrongTokenShouldReturnKO() {
        ResponseEntity<String> response = restTemplate.exchange(getBaseURL("generic/C_Campaign"),
                HttpMethod.GET, new HttpEntity<>(null, getUnauthHeaders()), String.class);
        assertThat(response.getStatusCode().value()).isEqualTo(403);
    }

    /** Una tabla de un componente que no es el core, cuya clase de modelo no esta en el classpath */
    private String findPluginTableWithoutModelClass() {
        String sql = " SELECT t.tablename FROM AD_Table t " +
                " INNER JOIN AD_ComponentVersion cv ON cv.AD_ComponentVersion_ID = t.AD_ComponentVersion_ID " +
                " INNER JOIN AD_Component c ON c.AD_Component_ID = cv.AD_Component_ID " +
                " WHERE c.corelevel <> 0 AND t.isview = 'N' AND t.isactive = 'Y' ORDER BY t.tablename";
        try (PreparedStatement ps = DB.prepareStatement(sql, null);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                if (M_Table.getClass(rs.getString(1)) == null)
                    return rs.getString(1);
            }
        } catch (Exception e) {
            throw new IllegalStateException("No se pudieron recorrer las tablas de plugins", e);
        }
        return null;
    }
}
