package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.UOM;

import java.sql.Timestamp;

public class UOMsIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        UOM uom = new UOM();
        uom.setAdClientId(1010016);
        uom.setAdOrgId(1010053);
        uom.setX12de355("Prueba");
        uom.setUomsymbol("Prueba");
        uom.setName("Prueba");
        uom.setDescription(null);
        uom.setStdprecision(2);
        uom.setCostingprecision(0);
        uom.setIsdefault(false);
        uom.setCUomGroupId(null);
        uom.setAllowdecimals(true);
        uom.setUomcodefe("3");
        uom.setProductselectable(true);

        return objectMapper.writeValueAsString(uom);
    }

    @Override
    protected String getMaestroPath() {
        return "uoms/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "1000018";
    }
}
