package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.Tax;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class TaxIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Tax tax = new Tax();
        tax.setAdClientId(1010016);
        tax.setAdOrgId(1010053);
        tax.setName("Tax de prueba");
        tax.setDescription(null);
        tax.setRate(BigDecimal.ZERO);
        tax.setParentTaxId(null);
        tax.setCCountryId(119);
        tax.setCRegionId(null);
        tax.setToCountryId(null);
        tax.setToRegionId(null);
        tax.setCTaxcategoryId(1010328);
        tax.setSopotype("B");
        tax.setTaxtype("G");
        tax.setCBpGroupId(null);
        tax.setMProductCategoryId(null);
        tax.setMProductId(null);
        tax.setPerceptiontype("I");
        tax.setTaxareatype("N");

        return objectMapper.writeValueAsString(tax);
    }

    @Override
    protected String getMaestroPath() {
        return "taxes/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "1000056";
    }
}
