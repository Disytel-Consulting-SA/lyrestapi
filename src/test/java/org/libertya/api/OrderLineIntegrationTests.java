package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.libertya.api.stub.model.Order;
import org.libertya.api.stub.model.OrderDocument;
import org.libertya.api.stub.model.OrderLine;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "org.libertya.api.service.doc.complete=N")
class OrderLineIntegrationTests extends CommonIntegrationTests {

    private String getOrderHeaderOnlyContent() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Order order = new Order();
        order.setIssotrx(true);
        order.setAdOrgId(1010053);
        order.setCBpartnerId(defaultBPartnerId);
        order.setCBpartnerLocationId(defaultBPartnerLocationId);
        order.setCCurrencyId(118);
        order.setCDoctypeId(1010532);
        order.setCDoctypetargetId(1010532);
        order.setCPaymenttermId(1010083);
        order.setDateordered(getFormattedDate());
        order.setDateacct(getFormattedDate());
        order.setMPricelistId(1010595);
        order.setPaymentrule("S");
        order.setSalesrepId(100);
        order.setMWarehouseId(1010048);
        order.setCConversiontypeId(114);
        order.setBillBpartnerId(defaultBPartnerId);
        order.setBillLocationId(defaultBPartnerLocationId);
        order.setAdUserId(100);

        OrderDocument doc = new OrderDocument();
        doc.setHeader(order);

        return objectMapper.writeValueAsString(doc);
    }

    private String getOrderLineWithoutProductContent(int orderId) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        OrderLine orderLine = new OrderLine();
        orderLine.setAdClientId(1010016);
        orderLine.setAdOrgId(1010053);
        orderLine.setCOrderId(orderId);
        orderLine.setLine(10);
        orderLine.setCUomId(100);
        orderLine.setCCurrencyId(118);
        orderLine.setQtyordered(BigDecimal.ONE);
        orderLine.setQtyentered(BigDecimal.ONE);
        orderLine.setPriceactual(new BigDecimal(100));
        orderLine.setPriceentered(new BigDecimal(100));
        orderLine.setPricelist(new BigDecimal(100));
        // intencionalmente sin m_product_id para validar la regla de negocio

        return objectMapper.writeValueAsString(orderLine);
    }

    @Test
    void createOrderLineWithoutProductShouldReturnKO() throws Exception {
        ResponseEntity<String> orderResponse =
                restTemplate.exchange(getBaseURL("orders"),
                        HttpMethod.POST,
                        new HttpEntity<>(getOrderHeaderOnlyContent(), getAuthHeaders()),
                        String.class);
        assertThat(orderResponse.getStatusCode().toString()).contains("200");
        Integer orderId = Integer.parseInt(orderResponse.getBody());

        ResponseEntity<String> orderLineResponse =
                restTemplate.exchange(getBaseURL("orderlines/"),
                        HttpMethod.POST,
                        new HttpEntity<>(getOrderLineWithoutProductContent(orderId), getAuthHeaders()),
                        String.class);
        assertThat(orderLineResponse.getStatusCode().toString()).contains("409");
    }
}
