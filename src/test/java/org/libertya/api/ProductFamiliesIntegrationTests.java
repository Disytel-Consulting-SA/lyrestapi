package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.ProductFamilies;

public class ProductFamiliesIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        ProductFamilies family = new ProductFamilies();
        family.setAdClientId(1010016);
        family.setAdOrgId(1010053);
        family.setValue("ABC");
        family.setName("Prueba");
        family.setDescription(null);
        family.setIsdefault(false);
        family.setIsselfservice(false);

        return objectMapper.writeValueAsString(family);
    }

    @Override
    protected String getMaestroPath() {
        return "productfamilies/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getModificationBody() {
        return "{ \"descrption\" : \"Prueba en bpartner\"}";
    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "1000000";
    }
}
