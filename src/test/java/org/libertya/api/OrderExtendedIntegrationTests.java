package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.libertya.api.stub.model.Order;
import org.libertya.api.stub.model.OrderDocument;
import org.libertya.api.stub.model.OrderLine;

import java.math.BigDecimal;

public class OrderExtendedIntegrationTests extends DocumentIntegrationTests{
    @Override
    protected String getDocumentContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Order order = new Order();
        order.setIssotrx(true);
        order.setAdOrgId(1010053);
        order.setCBpartnerId(1012142);
        order.setCBpartnerLocationId(1012157);
        order.setCCurrencyId(118);
        order.setCDoctypeId(1010532);
        order.setCDoctypetargetId(1010532);
        order.setCPaymenttermId(1010083);
        order.setDateordered(TEST_DATE);
        order.setDateacct(TEST_DATE);
        order.setMPricelistId(1010595);
        order.setPaymentrule("S");
        order.setSalesrepId(100);
        order.setMWarehouseId(1010048);
        order.setCConversiontypeId(114);
        order.setBillBpartnerId(1012142);
        order.setBillLocationId(1012157);
        order.setAdUserId(100);

        // Líneas del pedido
        OrderLine line1 = new OrderLine();
        line1.setLine(10);
        line1.setAdOrgId(1010053);
        line1.setCUomId(100);
        line1.setQtyordered(new BigDecimal(3));
        line1.setPriceactual(new BigDecimal(120));

        OrderDocument doc = new OrderDocument();
        doc.setHeader(order);
        doc.addLinesItem(line1);

        return objectMapper.writeValueAsString(doc);
    }

    @Override
    protected String getDocumentPath() {
        return "orders/";
    }

    @Override
    protected void afterRetrieve(String responseBody) throws Exception {

    }

    @Override
    protected String getModificationBody() {
        return "{ \"descrption\" : \"Prueba en order\"}";
    }
}
