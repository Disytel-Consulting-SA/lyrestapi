package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.ProductGamas;

public class ProductGamasIntegrationTests extends MaestroIntegrationTests{

    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        ProductGamas productGamas = new ProductGamas();
        productGamas.setAdClientId(1010016);
        productGamas.setAdOrgId(1010053);
        productGamas.setName("Prueba");
        productGamas.setIsdefault(false);
        productGamas.setIsselfservice(false);
        productGamas.setProcessed(false);
        productGamas.setValue(null);

        return objectMapper.writeValueAsString(productGamas);
    }

    @Override
    protected String getMaestroPath() {
        return "productgamas/";
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
        return "1000001";
    }
}
