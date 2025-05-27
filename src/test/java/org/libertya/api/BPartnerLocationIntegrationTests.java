package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.BPartnerLocation;

public class BPartnerLocationIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        BPartnerLocation bpl = new BPartnerLocation();
        bpl.setAdClientId(1010016);
        bpl.setAdOrgId(1010053);
        bpl.setName("JUAN B. JUSTO 1122 Piso:01 Depto:12");
        bpl.setIsbillto(true);
        bpl.setIsshipto(true);
        bpl.setIspayfrom(true);
        bpl.setIsremitto(true);
        bpl.setCBpartnerId(1012145);
        bpl.setCLocationId(1012296);
        bpl.setIstemporal(false);

        return objectMapper.writeValueAsString(bpl);
    }

    @Override
    protected String getMaestroPath() {
        return "bpartnerlocations/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getModificationBody() {
        return "{ \"descrption\" : \"Prueba\"}";
    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "1002060";
    }
}
