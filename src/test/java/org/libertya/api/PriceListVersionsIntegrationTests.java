package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.PriceListVersion;

import java.sql.Date;
import java.sql.Timestamp;

public class PriceListVersionsIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        PriceListVersion priceListVersion = new PriceListVersion();
        priceListVersion.setAdClientId(1010016);
        priceListVersion.setAdOrgId(1010053);
        priceListVersion.setName("Prueba");
        priceListVersion.setDescription(null);
        priceListVersion.setMPricelistId(1010595);
        priceListVersion.setMDiscountschemaId(1010101);
        priceListVersion.setValidfrom("2025-04-01 10:00:00");
        priceListVersion.setProccreate("N");
        priceListVersion.setMPricelistVersionBaseId(null);

        return objectMapper.writeValueAsString(priceListVersion);
    }

    @Override
    protected String getMaestroPath() {
        return "pricelistversions/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "1000512";
    }
}
