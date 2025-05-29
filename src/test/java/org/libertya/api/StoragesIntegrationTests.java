package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.libertya.api.stub.model.InvoiceDocument;
import org.libertya.api.stub.model.Storage;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
* Al momento de escribir estos tests Storages solo incluye métodos GET
* */
public class StoragesIntegrationTests extends CommonIntegrationTests{

    final String PATH = "storages/";
    final String M_PRODUCT_ID = "1015400";
    final String M_LOCATOR_ID = "1010278";

    @Test
    void retrieveAllStoragesShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(PATH),
                        HttpMethod.GET,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);

        assertThat(response.getStatusCode().toString()).contains("200");
        ObjectMapper mapper = new ObjectMapper();
        List<Storage> storages = mapper.readValue(response.getBody(), new TypeReference<List<Storage>>() {});
        assertThat(storages).isNotEmpty();
    }

    //m_product_id -> 1015400
    @Test
    void retrieveStorageByProductIdShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(PATH + M_PRODUCT_ID),
                        HttpMethod.GET,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);

        assertThat(response.getStatusCode().toString()).contains("200");
        ObjectMapper mapper = new ObjectMapper();
        List<Storage> storages = mapper.readValue(response.getBody(), new TypeReference<List<Storage>>() {});
        assertThat(storages).isNotEmpty();
    }

    @Test
    void retrieveStorageByProductIdAndLocatorIdShouldReturnOK() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(PATH + M_PRODUCT_ID + "/" + M_LOCATOR_ID),
                        HttpMethod.GET,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);

        assertThat(response.getStatusCode().toString()).contains("200");
        ObjectMapper mapper = new ObjectMapper();
        Storage storage = mapper.readValue(response.getBody(), Storage.class);
        assertThat(storage.getMProductId().toString().equalsIgnoreCase(M_PRODUCT_ID)).isTrue();
    }

    @Test
    void retrieveStorageByProductIdAndLocatorIdWithMismatchCompanyShouldReturnKO() throws Exception {
        String MISMATCH_PRODUCT_ID = "1003856";
        String MISMATCH_LOCATOR_ID = "1000261";
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(PATH + MISMATCH_PRODUCT_ID + "/" + MISMATCH_LOCATOR_ID),
                        HttpMethod.GET,
                        new HttpEntity<>(null, getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("401");
    }
}

//public class StoragesIntegrationTests extends DocumentIntegrationTests{
//    @Override
//    protected String getDocumentContent() throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        Storage storage = new Storage();
//        storage.setAdClientId(1010016);
//        storage.setAdOrgId(1010053);
//        storage.setMProductId(1015400);
//        storage.setMLocatorId(1010278);
//        storage.setQtyonhand(new BigDecimal("10.0000"));
//        storage.setQtyreserved(BigDecimal.ZERO);
//        storage.setQtyordered(BigDecimal.ZERO);
//        //storage.setDatelastinventory(Timestamp.valueOf("2025-05-15 21:33:45.303"));
//        storage.setMAttributesetinstanceId(0);
//
//        return objectMapper.writeValueAsString(storage);
//    }
//
//    @Override
//    protected String getDocumentPath() {
//        return "storages/";
//    }
//
//    @Override
//    protected void afterRetrieve(String responseBody) throws Exception {
//
//    }
//
//    @Override
//    protected String getModificationBody() {
//        return "{ \"descrption\" : \"Prueba en order\"}";
//    }
//}
