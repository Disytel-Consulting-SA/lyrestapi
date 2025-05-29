package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.POS;
import org.libertya.api.stub.model.POSPaymentMedium;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class POSIntegrationTests extends MaestroIntegrationTests{
    @Override
    protected String getMaestroContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        POS pos = new POS();
        pos.setAdClientId(1010016);
        pos.setAdOrgId(1010053);
        pos.setName("POS Prueba");
        pos.setDescription("");
        pos.setHelp("");
        pos.setSalesrepId(1000692);
        pos.setMPricelistId(1000581);
        pos.setCCashbookId(1010024);
        pos.setMWarehouseId(1010048);
        pos.setPrintername("");
        pos.setCPoskeylayoutId(1000001);
        pos.setIsmodifyprice(false);
        pos.setCBpartnercashtrxId(1002050);
        pos.setCDoctypeId(1000341);
        pos.setAdRoleId(1000043);
        pos.setCBankaccountId(1000025);
        pos.setCOrderdoctypeId(1000338);
        pos.setPosnumber(43);
        pos.setIssearchbyvalue(true);
        pos.setIssearchbyvaluelike(false);
        pos.setIssearchbyupc(false);
        pos.setIssearchbyupclike(false);
        pos.setIssearchbyname(false);
        pos.setIssearchbynamelike(false);
        pos.setIssearchtoday(false);
        pos.setAllowcreditnotesearch(true);

        return objectMapper.writeValueAsString(pos);
    }

    @Override
    protected String getMaestroPath() {
        return "pos/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getRecordIDWithComapnyMismatch() {
        return "1000001";
    }
}
