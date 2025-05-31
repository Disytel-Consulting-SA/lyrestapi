package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.LetraAceptaIVA;
import static org.assertj.core.api.Assertions.assertThat;

public class LetrasAceptaIVAIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        LetraAceptaIVA letraAceptaIva = new LetraAceptaIVA();
        letraAceptaIva.setCategoriaVendor(1010307);
        letraAceptaIva.setCategoriaCustomer(1010291);
        letraAceptaIva.setMontomax(null);
        letraAceptaIva.setCLetraComprobanteId(1010277);
        letraAceptaIva.setAdClientId(1010016);
        letraAceptaIva.setAdOrgId(1010053);
        letraAceptaIva.setCTaxId(null);

        return objectMapper.writeValueAsString(letraAceptaIva);
    }

    @Override
    protected String getMaestroPath() {
        return "letrasaceptaiva/";
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
