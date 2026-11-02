package org.libertya.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openXpertya.util.DB;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * referencedvalues de las columnas de referencia que no son campos del schema y viajan en additionalvalues.
 *
 * Se ejercita con /v1.0/orginfos: su schema deja afuera C_Categoria_IVA_ID, que es una referencia a tabla.
 * La organizacion se elige por SQL entre las de la compania del token que tengan esa columna informada.
 */
public class ReferencedValuesIntegrationTests extends CommonIntegrationTests {

    /** Columna de AD_OrgInfo que no es campo del schema de orginfos */
    private static final String COLUMN = "c_categoria_iva_id";

    private final ObjectMapper mapper = new ObjectMapper();

    private int orgID;

    @BeforeEach
    void resolveOrg() {
        orgID = DB.getSQLValue(null,
                " SELECT MIN(ad_org_id) FROM AD_OrgInfo WHERE " + COLUMN + " IS NOT NULL AND ad_org_id > 0 " +
                " AND ad_client_id = (SELECT ad_client_id FROM AD_Org WHERE ad_org_id = " + getOrgID() + ")");
        assumeTrue(orgID > 0, "No hay una organizacion con " + COLUMN + " informado");
    }

    @Test
    void withoutFieldsShouldReferenceAdditionalColumns() throws Exception {
        JsonNode orgInfo = retrieve(null);
        assertThat(hasKey(orgInfo.get("additionalvalues"), COLUMN)).isTrue();
        assertThat(hasKeyPrefix(orgInfo.get("referencedvalues"), COLUMN + "__")).isTrue();
    }

    @Test
    void withFieldsShouldReferenceOnlyRequestedAdditionalColumns() throws Exception {
        JsonNode notRequested = retrieve("ad_org_id,additionalvalues");
        assertThat(hasKey(notRequested.get("additionalvalues"), COLUMN)).isTrue();
        assertThat(hasKeyPrefix(notRequested.get("referencedvalues"), COLUMN + "__")).isFalse();

        JsonNode requested = retrieve("ad_org_id,additionalvalues," + COLUMN);
        assertThat(hasKeyPrefix(requested.get("referencedvalues"), COLUMN + "__")).isTrue();
    }

    /** Por el listado y no por /orginfos/{id}, que no recibe fields */
    protected JsonNode retrieve(String fields) throws Exception {
        String path = "orginfos?filter=ad_org_id=" + orgID + (fields == null ? "" : "&fields=" + fields);
        ResponseEntity<String> response = restTemplate.exchange(getBaseURL(path), HttpMethod.GET,
                new HttpEntity<>(null, getAuthHeaders()), String.class);
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        JsonNode orgInfos = mapper.readTree(response.getBody());
        assertThat(orgInfos.size()).isEqualTo(1);
        return orgInfos.get(0);
    }

    /** La organizacion con la que se pidio el token */
    private int getOrgID() {
        return Integer.parseInt(credentials[3].split("=")[1]);
    }

    /** Las claves de additionalvalues llegan normalizadas (minusculas, sin guiones bajos) salvo colision */
    private boolean hasKey(JsonNode props, String key) {
        if (props == null)
            return false;
        for (JsonNode prop : props)
            if (normalize(key).equals(normalize(prop.path("key").asText())))
                return true;
        return false;
    }

    private String normalize(String key) {
        return key.toLowerCase().replace("_", "");
    }

    private boolean hasKeyPrefix(JsonNode props, String prefix) {
        if (props == null)
            return false;
        for (JsonNode prop : props)
            if (prop.path("key").asText().startsWith(prefix))
                return true;
        return false;
    }
}
