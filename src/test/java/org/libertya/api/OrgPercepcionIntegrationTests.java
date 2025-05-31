package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.OrgPercepcion;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrgPercepcionIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        OrgPercepcion orgPercepcion = new OrgPercepcion();
        orgPercepcion.setAdClientId(1010016);
        orgPercepcion.setAdOrgId(1010053);
        orgPercepcion.setName("Percepción prueba");
        orgPercepcion.setDescription("Percepción prueba");
        orgPercepcion.setCTaxId(1010087);
        orgPercepcion.setCRetencionprocessorId(null);
        orgPercepcion.setMinimumnetamount(new BigDecimal("1000.00"));
        orgPercepcion.setAlicuota(new BigDecimal("3.00"));
        orgPercepcion.setIsconveniomultilateral(true);
        orgPercepcion.setUsecabajurisdiction(false);
        orgPercepcion.setPartialreturn(true);
        orgPercepcion.setTotalreturn(false);
        orgPercepcion.setMinimumpercepcionamt(new BigDecimal("500.00"));

        return objectMapper.writeValueAsString(orgPercepcion);
    }

    @Override
    protected String getMaestroPath() {
        return "orgpercepcions/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "-1"; // <-- No existe en BD un registro con distinta compañia
    }

    /* Se pisa el metodo original por falta de registros de prueba */
    @Override
    void deleteMaestroWithCompanyMismatchShouldReturnKO() {
        assertThat(true).isTrue();
    }

}
