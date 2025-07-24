package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.libertya.api.stub.model.Invoice;
import org.libertya.api.stub.model.InvoiceDocument;
import org.libertya.api.stub.model.InvoiceLine;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InvoiceIntegrationTests extends CommonIntegrationTests {

	/** Generacion de una factura.  Basado en contenido iniciarl en BDD bajo compañía Libertya (1010016) */
	protected String getInvoiceContent() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		Invoice inv = new Invoice();
		inv.setIssotrx(true);
		inv.setAdOrgId(1010053);
		inv.setCBpartnerId(1012145);
		inv.setCBpartnerLocationId(1012158);
		inv.setCCurrencyId(118);
		inv.setCDoctypeId(1010507);
		inv.setCDoctypetargetId(1010507);
		inv.setCPaymenttermId(1010083);
		inv.setDateacct(getFormattedDate());
		inv.setDateinvoiced(getFormattedDate());
		inv.setMPricelistId(1010595);
		inv.setPaymentrule("S");
		inv.setSalesrepId(100);
		inv.setAdUserId(100);

		InvoiceLine line1 = new InvoiceLine();
		line1.setLine(10);
		line1.setAdOrgId(1010053);
		line1.setQtyinvoiced(new BigDecimal(2));
		line1.setPriceactual(new BigDecimal(100));
		line1.setPricelist(new BigDecimal(100));
		line1.setPriceentered(new BigDecimal(100));

		InvoiceLine line2 = new InvoiceLine();
		line2.setLine(20);
		line2.setAdOrgId(1010053);
		line2.setQtyinvoiced(new BigDecimal(5));
		line2.setPriceactual(new BigDecimal(30));
		line2.setPricelist(new BigDecimal(30));
		line2.setPriceentered(new BigDecimal(30));

		InvoiceDocument doc = new InvoiceDocument();
		doc.setHeader(inv);
		doc.addLinesItem(line1);
		doc.addLinesItem(line2);

		return objectMapper.writeValueAsString(doc);
	}

	// ==================
	// CREACION ENTIDADES
	// ==================

	@Test
	@Order(1)
	void createInvoiceShouldReturnOK() throws Exception {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("invoices"),
						HttpMethod.POST,
						new HttpEntity<>(getInvoiceContent(), getAuthHeaders()),
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
	@Order(200)
	void retrieveCreatedInvoiceShouldReturnOKAndAmountShouldBeCorrect() throws Exception {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("invoices/" + entityID),
						HttpMethod.GET,
						new HttpEntity<>(null, getAuthHeaders()),
						String.class);
		ObjectMapper mapper = new ObjectMapper();
		InvoiceDocument doc = mapper.readValue(response.getBody(), InvoiceDocument.class);
		assertThat(doc.getHeader().getGrandtotal().equals(new BigDecimal(350)));
	}

	// ======================
	// MODIFICACION ENTIDADES
	// ======================

	@Test
	@Order(500)
	void modifyInvoiceShouldReturnOK() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("invoices/" + entityID),
						HttpMethod.PUT,
						new HttpEntity<>("{ \"descrption\" : \"Prueba\"}", getAuthHeaders()),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("200");
	}

	@Test
	@Order(500)
	void modifyInexistentInvoiceShouldReturnKO() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("invoices/-1"),
						HttpMethod.PUT,
						new HttpEntity<>("{ \"documentno\" : \"-1\"}", getAuthHeaders()),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("404");
	}


	// =====================
	// ELIMINACION ENTIDADES
	// =====================

	@Test
	void deleteInvoiceWithWrongTokenShouldReturnKO() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("invoices/1"),
						HttpMethod.DELETE,
						new HttpEntity<>(null, getUnauthHeaders()),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("403");
	}

	@Test
	void deleteInexistentInvoiceShouldReturnKO() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("invoices/-1"), // <- Registro inexistente
						HttpMethod.DELETE,
						new HttpEntity<>(null, getAuthHeaders()),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("404");
	}

	@Test
	void deleteInvoiceWithCompanyMismatchShouldReturnKO() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("invoices/1011608"),	// <- Registro de AD_Client_ID = 1000005
						HttpMethod.DELETE,
						new HttpEntity<>(null, getAuthHeaders()),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("401");
	}

	@Test
	@Order(1000)
	void deleteProcessedInvoiceShouldReturnKO() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("invoices/" + entityID),	// <- Factura procesada cuyo AD_Client_ID = 1010016
						HttpMethod.DELETE,
						new HttpEntity<>(null, getAuthHeaders()),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("409");
	}

	@Test
	@Order(1500)
	void voidCompletedInvoiceShouldReturnOK() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("invoices/" + entityID + "/process?action=VO"),	// <- Factura procesada cuyo AD_Client_ID = 1010016
						HttpMethod.PUT,
						new HttpEntity<>(null, getAuthHeaders()),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("200");
	}

	// =====================
	// INVOICE LINES
	// =====================

	/* Se descartan los tests de invoice lines haciendolo desde un unico payload en el create de invoice */

//	protected String getInvoiceLineContent() throws JsonProcessingException {
//		ObjectMapper objectMapper = new ObjectMapper();
//		InvoiceLine line = new InvoiceLine();
//		line.setLine(30);
//		line.setCInvoiceId(entityID);
//		line.setAdOrgId(1010053);
//		line.setQtyinvoiced(new BigDecimal(9));
//		line.setPriceactual(new BigDecimal(900));
//		return objectMapper.writeValueAsString(line);
//	}

//	@Test
//	@Order(50)
//	void createInvoiceLineShouldReturnOK() throws Exception {
//		ResponseEntity<String> response =
//				restTemplate.exchange(getBaseURL("invoicelines/"),
//						HttpMethod.POST,
//						new HttpEntity<>(getInvoiceLineContent(), getAuthHeaders()),
//						String.class);
//		System.out.println(response.getBody());
//		assertThat(response.getStatusCode().toString()).contains("200");
//	}


}
