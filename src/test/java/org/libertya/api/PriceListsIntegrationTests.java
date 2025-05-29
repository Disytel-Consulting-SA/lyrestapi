package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.PriceList;

import java.math.BigDecimal;

public class PriceListsIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        PriceList priceList = new PriceList();
        priceList.setAdClientId(1010016);
        priceList.setAdOrgId(1010053);
        priceList.setName("Prueba");
        priceList.setDescription(null);
        priceList.setBasepricelistId(null);
        priceList.setIstaxincluded(true);
        priceList.setIssopricelist(false);
        priceList.setIsdefault(false);
        priceList.setCCurrencyId(118);
        priceList.setEnforcepricelimit(false);
        priceList.setPriceprecision(new BigDecimal("2.000000"));
        priceList.setIsperceptionsincluded(true);
        priceList.setActualizarpreciosconfacturadecompra(false);

        return objectMapper.writeValueAsString(priceList);
    }

    @Override
    protected String getMaestroPath() {
        return "pricelists/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "1000522";
    }
}
