package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.Org;

import java.sql.Timestamp;

public class OrgsIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Org org = new Org();
        org.setAdClientId(1010016);
        org.setValue("Prueba");
        org.setName("Prueba");
        org.setDescription(null);
        org.setIssummary(false);
        return objectMapper.writeValueAsString(org);
    }

    @Override
    protected String getMaestroPath() {
        return "orgs/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "1000036";
    }
}
