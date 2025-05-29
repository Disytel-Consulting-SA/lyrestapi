package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.Currency;
import org.libertya.api.stub.model.UOM;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CurrenciesIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Currency currency = new Currency();
        currency.setAdClientId(1010016);
        currency.setAdOrgId(1010053);
        currency.setIsoCode("Prueba");
        currency.setCursymbol("Prueba");
        currency.setDescription("Prueba");
        currency.setStdprecision(2);
        currency.setCostingprecision(4);
        currency.setIseuro(false);
        currency.setIsemumember(false);
        currency.setEmuentrydate(null);
        currency.setEmurate(BigDecimal.ZERO);
        currency.setWsfecode("PRU");

        return objectMapper.writeValueAsString(currency);
    }

    @Override
    protected String getMaestroPath() {
        return "currencies/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "277";
    }
}
