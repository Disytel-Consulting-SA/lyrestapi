package org.libertya.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.libertya.api.security.JWTUtils;
import org.libertya.api.stub.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApiApplicationTests {

	protected final String inexistentInvioceID = "0";

	protected String existentInvoiceID;

	String token;

	@Autowired
	protected TestRestTemplate restTemplate;

	@Autowired
	protected JWTUtils jwtUtils;

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

	@Test
	@BeforeAll
	void newTokenWithCorrectCredentialsShouldReturnOK() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("token"),
						HttpMethod.POST,
						new HttpEntity<>(null, getHeaders(new String[]{"username=AdminLibertya", "password=AdminLibertya", "clientid=1010016", "orgid=0"})),
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
	void deleteInvoiceWithWrongTokenShouldReturnKO() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("v1.0/invoices/1"),
						HttpMethod.DELETE,
						new HttpEntity<>(null, getHeaders(new String[]{"Content-Type=application/json", "Authorization=Bearer FOOBAR"})),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("403");
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
	void deleteProcessedInvoiceShouldReturnKO() {
		ResponseEntity<String> response =
				restTemplate.exchange(getBaseURL("v1.0/invoices/1021981"),	// <- Factura procesada cuyo AD_Client_ID = 1010016
						HttpMethod.DELETE,
						new HttpEntity<>(null, getHeaders(new String[]{"Content-Type=application/json", "Authorization="+token})),
						String.class);
		assertThat(response.getStatusCode().toString()).contains("409");
	}

}
