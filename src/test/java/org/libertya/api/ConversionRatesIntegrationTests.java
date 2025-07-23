package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.ConversionRate;
import org.openXpertya.util.DB;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ConversionRatesIntegrationTests extends MaestroIntegrationTests{

    protected static final int CONVRATE_OTHER_CLIENT_ID = 999999;
    @Override
    protected String getMaestroContent() throws JsonProcessingException {

        // Conversion Rate de otra cia para pruebas (ignorar error al intentar insertar si ya existe)
        DB.executeUpdate( "insert into c_conversion_rate " +
                                " (c_conversion_rate_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_currency_id, c_currency_id_to, validfrom, validto, multiplyrate, dividerate, c_conversiontype_id) " +
                                " values ("+ CONVRATE_OTHER_CLIENT_ID +", 1000005, 1000037, 'Y', now(), 100, now(), 100, 100, 118, '2001-01-01', '2099-01-01', 1, 1, 114)");

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
        return ""+CONVRATE_OTHER_CLIENT_ID;
    }
}
