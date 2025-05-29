package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.ConversionRate;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ConversionRatesIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        ConversionRate conversionRate = new ConversionRate();
        conversionRate.setAdClientId(1010016);
        conversionRate.setAdOrgId(1010053);
        conversionRate.setCCurrencyId(100);
        conversionRate.setCCurrencyIdTo(118);
        conversionRate.setValidfrom("2025-01-01 00:00:00");
        conversionRate.setValidto("2025-12-31 23:59:59");
        conversionRate.setMultiplyrate(BigDecimal.valueOf(870.50));
        conversionRate.setDividerate(BigDecimal.valueOf(0.0011494253));
        conversionRate.setCConversiontypeId(114);

        return objectMapper.writeValueAsString(conversionRate);
    }

    @Override
    protected String getMaestroPath() {
        return "conversionrates/";
    }

    @Override
    protected String getModificationBody() {
        return "{ \"multiplyrate\" : \"770.50\"}";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "-1"; // <-- No existen registros en la BD
    }
}
