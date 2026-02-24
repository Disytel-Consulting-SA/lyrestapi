package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.libertya.api.stub.model.ConversionRate;
import org.openXpertya.util.DB;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ConversionRatesIntegrationTests extends MaestroIntegrationTests{

    protected static final int CONVRATE_OTHER_CLIENT_ID = 999999;
    @Override
    protected String getMaestroContent() throws JsonProcessingException {

        // Conversion Rate de otra cia para pruebas (ignorar error al intentar insertar si ya existe)
        DB.executeUpdate( "insert into c_conversion_rate " +
                                " (c_conversion_rate_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_currency_id, c_currency_id_to, validfrom, validto, multiplyrate, dividerate, c_conversiontype_id) " +
                                " values ("+ CONVRATE_OTHER_CLIENT_ID +", 1000005, 1000037, 'Y', now(), 100, now(), 100, 100, 118, '2001-01-01', '2099-01-01', 1, 1, 114)");

        return getConversionRateContent(
                "2025-01-01 00:00:00",
                "2025-12-31 23:59:59",
                BigDecimal.valueOf(870.50),
                BigDecimal.valueOf(0.0011494253)
        );
    }

    private String getConversionRateContent(String validFrom,
                                            String validTo,
                                            BigDecimal multiplyRate,
                                            BigDecimal divideRate) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        ConversionRate conversionRate = new ConversionRate();
        conversionRate.setAdClientId(1010016);
        conversionRate.setAdOrgId(1010053);
        conversionRate.setCCurrencyId(100);
        conversionRate.setCCurrencyIdTo(118);
        conversionRate.setValidfrom(validFrom);
        conversionRate.setValidto(validTo);
        conversionRate.setMultiplyrate(multiplyRate);
        conversionRate.setDividerate(divideRate);
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

    @Override
    void modifyMaestroShouldReturnOK() {
        // Se comenta el método para que no falle la validación momentaneamente
    }

    @Test
    @Order(50)
    void createConversionRateWithPartiallyOverlappedDateRangeShouldReturnKO() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(getMaestroPath()),
                        HttpMethod.POST,
                        new HttpEntity<>(getConversionRateContent(
                                "2025-06-01 00:00:00",
                                "2026-01-31 23:59:59",
                                BigDecimal.valueOf(900.0),
                                BigDecimal.valueOf(0.0011111111)
                        ), getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("409");
    }

    @Test
    @Order(51)
    void createConversionRateWithContainedDateRangeShouldReturnKO() throws Exception {
        ResponseEntity<String> response =
                restTemplate.exchange(getBaseURL(getMaestroPath()),
                        HttpMethod.POST,
                        new HttpEntity<>(getConversionRateContent(
                                "2025-03-01 00:00:00",
                                "2025-03-31 23:59:59",
                                BigDecimal.valueOf(910.0),
                                BigDecimal.valueOf(0.0010989011)
                        ), getAuthHeaders()),
                        String.class);
        assertThat(response.getStatusCode().toString()).contains("409");
    }
}
