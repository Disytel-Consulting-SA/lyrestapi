package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.TaxCategory;

import java.sql.Timestamp;

public class TaxCategoriesIntegrationTests extends MaestroIntegrationTests{

    @Override
    protected String getMaestroContent() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        TaxCategory taxCategory = new TaxCategory();
        taxCategory.setAdClientId(1010016);
        taxCategory.setAdOrgId(1010053);
        taxCategory.setName("Categoría de prueba");
        taxCategory.setDescription(null);
        return objectMapper.writeValueAsString(taxCategory);
    }

    @Override
    protected String getMaestroPath() {
        return "taxcategories/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "1000024";
    }
}
