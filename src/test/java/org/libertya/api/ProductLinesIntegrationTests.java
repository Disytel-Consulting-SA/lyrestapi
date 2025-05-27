package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.ProductLines;

public class ProductLinesIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        ProductLines productLines = new ProductLines();
        productLines.setAdClientId(1010016);
        productLines.setAdOrgId(1010053);
        productLines.setName("Azul");
        productLines.setIsdefault(false);
        productLines.setIsselfservice(false);
        productLines.setProcessed(false);
        productLines.setValue("Azul");

        return objectMapper.writeValueAsString(productLines);
    }

    @Override
    protected String getMaestroPath() {
        return "productlines/";
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
        return "-1";
    }
}
