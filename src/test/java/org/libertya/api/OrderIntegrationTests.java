package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.libertya.api.stub.model.*;
import org.libertya.api.stub.model.Order;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderIntegrationTests extends CommonIntegrationTests {

	/** Generacion de un pedido.  Basado en contenido inicial en BDD bajo compañía Libertya (1010016) */
	protected String getOrderContent() throws JsonProcessingException {
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

	// ==================
	// CREACION ENTIDADES
	// ==================

	@Test
	@org.junit.jupiter.api.Order(1)
	void createOrderShouldReturnOK() throws Exception {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("orders"),
						HttpMethod.POST,
						new HttpEntity<>(getOrderContent(), getAuthHeaders()),
						String.class);
		System.out.println(response.getBody());
		assertThat(response.getStatusCode().toString()).contains("200");
		entityID = Integer.parseInt(response.getBody());
		assertThat(entityID >0);
	}

	// =========================
	// RECUPERACION DE ENTIDADES
	// =========================

	@Test
	@org.junit.jupiter.api.Order(200)
	void retrieveCreatedOrderShouldReturnOK() throws Exception {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("orders/" + entityID),
						HttpMethod.GET,
						new HttpEntity<>(null, getAuthHeaders()),
						String.class);
		ObjectMapper mapper = new ObjectMapper();
		assertThat(response.getStatusCode().toString()).contains("200");
	}

	// ======================
	// MODIFICACION ENTIDADES
	// ======================

	@Test
	@org.junit.jupiter.api.Order(500)
	void modifyOrderShouldReturnOK() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("orders/" + entityID),
						HttpMethod.PUT,
						new HttpEntity<>("{ \"descrption\" : \"Prueba en order\"}", getAuthHeaders()),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("200");
	}

	@Test
	@org.junit.jupiter.api.Order(500)
	void modifyInexistentOrderShouldReturnKO() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("orders/-1"),
						HttpMethod.PUT,
						new HttpEntity<>("{ \"documentno\" : \"-1\"}", getAuthHeaders()),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("404");
	}


	// =====================
	// ELIMINACION ENTIDADES
	// =====================

	@Test
	void deleteOrderWithWrongTokenShouldReturnKO() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("orders/1"),
						HttpMethod.DELETE,
						new HttpEntity<>(null, getUnauthHeaders()),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("403");
	}

	@Test
	void deleteInexistentOrderShouldReturnKO() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("orders/-1"), // <- Registro inexistente
						HttpMethod.DELETE,
						new HttpEntity<>(null, getAuthHeaders()),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("404");
	}

	@Test
	void deleteOrderWithCompanyMismatchShouldReturnKO() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("orders/1003820"),	// <- Registro de AD_Client_ID = 1000005
						HttpMethod.DELETE,
						new HttpEntity<>(null, getAuthHeaders()),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("401");
	}

	@Test
	@org.junit.jupiter.api.Order(1000)
	void deleteProcessedInvoiceShouldReturnKO() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("orders/" + entityID),	// <- Order procesada cuyo AD_Client_ID = 1010016
						HttpMethod.DELETE,
						new HttpEntity<>(null, getAuthHeaders()),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("409");
	}

	@Test
	@org.junit.jupiter.api.Order(1500)
	void voidCompletedOrderShouldReturnOK() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("orders/" + entityID + "/process?action=VO"),	// <- Order procesada cuyo AD_Client_ID = 1010016
						HttpMethod.PUT,
						new HttpEntity<>(null, getAuthHeaders()),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("200");
	}

}
