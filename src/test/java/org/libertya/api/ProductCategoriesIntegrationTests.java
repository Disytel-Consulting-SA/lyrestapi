package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.ProductCategories;

import java.math.BigDecimal;

public class ProductCategoriesIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        ProductCategories category = new ProductCategories();
        category.setAdClientId(1010016);
        category.setAdOrgId(1010053);
        category.setValue("Prueba");
        category.setName("Prueba");
        category.setDescription(null);
        category.setIsdefault(false);
        category.setPlannedmargin(BigDecimal.ZERO);
        category.setIsselfservice(true);
        category.setMmpolicy("F");
        category.setYearlife(0);
        category.setAmortizationperc(BigDecimal.ZERO);

        return objectMapper.writeValueAsString(category);
    }

    @Override
    protected String getMaestroPath() {
        return "productcategories/";
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
        return "1000096";
    }
}
