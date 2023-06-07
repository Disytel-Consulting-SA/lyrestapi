package org.libertya.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.libertya.api.stub.model.Invoice;
import org.libertya.api.stub.model.InvoiceDocument;
import org.libertya.api.stub.model.InvoiceLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test de integracion sobre circuito de facturacion.
 * Precondiciones:
 * 	- Debe existir la informacion preexistente de la compañía 1010016 y organizacion 1010053
 * 	- La preferencia org.libertya.api.service.doc.complete en application.properties debe poseer el valor Y
 * 	- El periodo debe estar abierto para la fecha de la factura a fin de poder completar la misma. Ver getInvoiceContent()
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApiApplicationTests {

	/** Datos de acceso a la compañía para obtencion del token a utilizar en las pruebas */
	String[] credentials = new String[]{"username=AdminLibertya", "password=AdminLibertya", "clientid=1010016", "orgid=0"};
	/** Contenido del token */
	String token;
	/** ID de la factura creada */
	int invoiceID = -1;

	@Autowired
	protected TestRestTemplate restTemplate;

	@LocalServerPort
	protected int port;

	protected String getBaseURL(String path) {
		return String.format("http://localhost:%s/%s", port, path);
	}

	/** Crea el header recibiendo un array de key-values, en donde cada kv posee el formato k=v */
	protected HttpHeaders getHeaders(String[] kvs) {
		HttpHeaders headers = new HttpHeaders();
		for (String kv : kvs) {
			headers.set(kv.split("=")[0], 	kv.split("=")[1]);
		}
		return headers;
	}

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
		inv.setDateacct("2023-06-01 18:00:00");
		inv.setDateinvoiced("2023-06-01 18:00:00");
		inv.setMPricelistId(1010595);
		inv.setPaymentrule("S");
		inv.setSalesrepId(100);

		InvoiceLine line1 = new InvoiceLine();
		line1.setLine(10);
		line1.setAdOrgId(1010053);
		line1.setQtyinvoiced(new BigDecimal(2));
		line1.setPriceactual(new BigDecimal(100));

		InvoiceLine line2 = new InvoiceLine();
		line2.setLine(20);
		line2.setAdOrgId(1010053);
		line2.setQtyinvoiced(new BigDecimal(5));
		line2.setPriceactual(new BigDecimal(30));

		InvoiceDocument doc = new InvoiceDocument();
		doc.setHeader(inv);
		doc.addLinesItem(line1);
		doc.addLinesItem(line2);

		return objectMapper.writeValueAsString(doc);
	}

	// =============
	// GESTION TOKEN
	// =============

	@Test
	@BeforeAll
	void newTokenWithCorrectCredentialsShouldReturnOK() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("token"),
						HttpMethod.POST,
						new HttpEntity<>(null, getHeaders(credentials)),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("200");
		assertThat(response.getBody()).isNotEmpty();
		assertThat(response.getBody().startsWith("Bearer"));
		token = response.getBody();
	}

	@Test
	void newTokenWithIncorrectCredentialsShouldReturnKO() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("token"),
						HttpMethod.POST,
						new HttpEntity<>(null, getHeaders(new String[]{"username=AdminLibertya", "clientid=1010016", "orgid=0"})),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("403");
	}

	// ==================
	// CREACION ENTIDADES
	// ==================

	@Test
	@Order(1)
	void createInvoiceSouldReturnOK() throws Exception {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("v1.0/invoices"),
						HttpMethod.POST,
						new HttpEntity<>(getInvoiceContent(), getHeaders(new String[]{"Content-Type=application/json", "Authorization="+token})),
						String.class);
		System.out.println(response.getBody());
		assertThat(response.getStatusCode().toString()).contains("200");
		invoiceID = Integer.parseInt(response.getBody());
		assertThat(invoiceID>0);
	}

	// =========================
	// RECUPERACION DE ENTIDADES
	// =========================

	@Test
	@Order(200)
	void retrieveCreatedInvoiceShouldReturnOKAndAmountShouldBeCorrect() throws Exception {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("v1.0/invoices/" + invoiceID),
						HttpMethod.GET,
						new HttpEntity<>(null, getHeaders(new String[]{"Content-Type=application/json", "Authorization="+token})),
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
				restTemplate.exchange(getBaseURL("v1.0/invoices/" + invoiceID),	// <- Factura procesada cuyo AD_Client_ID = 1010016
						HttpMethod.PUT,
						new HttpEntity<>("{ \"descrption\" : \"Prueba\"}", getHeaders(new String[]{"Content-Type=application/json", "Authorization="+token})),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("200");
	}

	@Test
	@Order(500)
	void modifyInexistentInvoiceShouldReturnKO() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("v1.0/invoices/-1"),
						HttpMethod.PUT,
						new HttpEntity<>("{ \"documentno\" : \"-1\"}", getHeaders(new String[]{"Content-Type=application/json", "Authorization="+token})),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("404");
	}


	// =====================
	// ELIMINACION ENTIDADES
	// =====================

	@Test
	void deleteInvoiceWithWrongTokenShouldReturnKO() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("v1.0/invoices/1"),
						HttpMethod.DELETE,
						new HttpEntity<>(null, getHeaders(new String[]{"Content-Type=application/json", "Authorization=Bearer FOOBAR"})),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("403");
	}

	@Test
	void deleteInexistentInvoiceShouldReturnKO() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("v1.0/invoices/-1"), // <- Factura inexistente
						HttpMethod.DELETE,
						new HttpEntity<>(null, getHeaders(new String[]{"Content-Type=application/json", "Authorization="+token})),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("404");
	}

	@Test
	void deleteInvoiceWithCompanyMismatchShouldReturnKO() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("v1.0/invoices/1011608"),	// <- Factura de AD_Client_ID = 1000005
						HttpMethod.DELETE,
						new HttpEntity<>(null, getHeaders(new String[]{"Content-Type=application/json", "Authorization="+token})),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("401");
	}

	@Test
	@Order(1000)
	void deleteProcessedInvoiceShouldReturnKO() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("v1.0/invoices/" + invoiceID),	// <- Factura procesada cuyo AD_Client_ID = 1010016
						HttpMethod.DELETE,
						new HttpEntity<>(null, getHeaders(new String[]{"Content-Type=application/json", "Authorization="+token})),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("409");
	}

}
