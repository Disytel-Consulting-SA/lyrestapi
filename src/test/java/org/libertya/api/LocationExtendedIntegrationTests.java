package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.Location;

public class LocationExtendedIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Location location = new Location();
        location.setAdClientId(1010016);
        location.setAdOrgId(1010053);
        location.setAddress1("RONDEAU 1234 Piso:02 Depto:42");
        location.setCity("CAPITAL FEDERAL");
        location.setPostal("1086");
        location.setCCountryId(119);
        location.setCRegionId(1000083);

        return objectMapper.writeValueAsString(location);
    }

    @Override
    protected String getMaestroPath() {
        return "locations/";
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
        return "1002133";
    }
}
