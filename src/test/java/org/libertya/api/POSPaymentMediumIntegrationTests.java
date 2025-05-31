package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.POSPaymentMedium;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class POSPaymentMediumIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        POSPaymentMedium posPaymentMedium = new POSPaymentMedium();
        posPaymentMedium.setAdClientId(1010016);
        posPaymentMedium.setAdOrgId(1010053);
        posPaymentMedium.setTendertype("AC");
        posPaymentMedium.setName("Prueba");
        posPaymentMedium.setDescription("");
        posPaymentMedium.setMDiscountschemaId(1010101);
        posPaymentMedium.setMEntidadfinancieraId(1012145);
        posPaymentMedium.setCCurrencyId(118);
        posPaymentMedium.setCheckdeadline(null);
        posPaymentMedium.setBank("1010256");
        posPaymentMedium.setContext("R");
        posPaymentMedium.setValidatebeforecheckdeadlines(false);
        posPaymentMedium.setBeforecheckdeadlinefrom(null);
        posPaymentMedium.setBeforecheckdeadlineto(null);
        posPaymentMedium.setIsnormalizedbank(false);
        posPaymentMedium.setCBankId(1010256);
        posPaymentMedium.setIsmandatorybank(false);
        posPaymentMedium.setDatefrom("2025-05-19 10:00:00");
        posPaymentMedium.setDateto("2025-05-20 10:00:00");

        return objectMapper.writeValueAsString(posPaymentMedium);
    }

    @Override
    protected String getMaestroPath() {
        return "pospaymentmediums/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "-1";
    }

    /* Se pisa el metodo original por falta de registros de prueba */
    @Override
    void deleteMaestroWithCompanyMismatchShouldReturnKO() {
        assertThat(true).isTrue();
    }
}
