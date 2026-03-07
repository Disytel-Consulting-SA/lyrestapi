package org.libertya.api.invoice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.libertya.api.CommonIntegrationTests;
import org.libertya.api.stub.model.Invoice;
import org.libertya.api.stub.model.InvoiceDocument;
import org.libertya.api.stub.model.InvoiceLine;
import org.openXpertya.util.DB;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InvoiceChronologicalControlIntegrationTests extends CommonIntegrationTests {

	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private static final int TEST_DOC_TYPE_ID = 1010507;
	private static final int CHRONOLOGY_TEST_POINT_OF_SALE = 9000;

	@Test
	@Order(1)
	void shouldAllowIncreasingInvoiceDatesAndRejectBackdatedNextNumber() throws Exception {
		// Given
		LocalDate today = LocalDate.now();
		int pointOfSale = CHRONOLOGY_TEST_POINT_OF_SALE;
		int firstVoucherNumber = findNextVoucherNumber(pointOfSale);
		LocalDate lastInvoiceDate = findLastInvoiceDate(pointOfSale);
		LocalDate firstInvoiceDay = (lastInvoiceDate != null ? lastInvoiceDate : today.minusDays(1));
		LocalDate secondInvoiceDay = firstInvoiceDay.plusDays(1);

		String accountingDate = atNoon(today);
		String firstInvoiceDate = atNoon(firstInvoiceDay);
		String secondInvoiceDate = atNoon(secondInvoiceDay);
		String invalidEarlierInvoiceDate = firstInvoiceDate;

		// When
		ResponseEntity<String> firstResponse = createInvoiceForChronology(accountingDate, firstInvoiceDate, pointOfSale, firstVoucherNumber);
		ResponseEntity<String> secondResponse = createInvoiceForChronology(accountingDate, secondInvoiceDate, pointOfSale, firstVoucherNumber + 1);
		ResponseEntity<String> invalidResponse = createInvoiceForChronology(accountingDate, invalidEarlierInvoiceDate, pointOfSale, firstVoucherNumber + 2);

		// Then
		assertThat(firstResponse.getStatusCode().toString()).contains("200");
		assertThat(secondResponse.getStatusCode().toString()).contains("200");
		assertThat(invalidResponse.getStatusCode().toString()).contains("409");
		assertThat(invalidResponse.getBody()).containsIgnoringCase("comprobante actual no puede ser menor");
	}

	private ResponseEntity<String> createInvoiceForChronology(String accountingDate, String invoiceDate, int pointOfSale, int voucherNumber) throws JsonProcessingException {
		return restTemplate.exchange(getBaseURL("invoices"),
				HttpMethod.POST,
				new HttpEntity<>(buildInvoiceContent(accountingDate, invoiceDate, pointOfSale, voucherNumber), getAuthHeaders()),
				String.class);
	}

	private String buildInvoiceContent(String dateAcct, String dateInvoiced, int pointOfSale, int voucherNumber) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		Invoice inv = new Invoice();
		inv.setIssotrx(true);
		inv.setAdOrgId(1010053);
		inv.setCBpartnerId(defaultBPartnerId);
		inv.setCBpartnerLocationId(defaultBPartnerLocationId);
		inv.setCCurrencyId(118);
		inv.setCDoctypeId(TEST_DOC_TYPE_ID);
		inv.setCDoctypetargetId(TEST_DOC_TYPE_ID);
		inv.setCPaymenttermId(1010083);
		inv.setDateacct(dateAcct);
		inv.setDateinvoiced(dateInvoiced);
		inv.setMPricelistId(1010595);
		inv.setPaymentrule("S");
		inv.setSalesrepId(100);
		inv.setAdUserId(100);
		inv.setPuntodeventa(pointOfSale);
		inv.setNumerocomprobante(voucherNumber);
		inv.setManualdocumentno(true);
		inv.setCLetraComprobanteId(defaultLetraComprobante);
		inv.setDocumentno(String.format("%04d-%08d", pointOfSale, voucherNumber));

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

	private int findNextVoucherNumber(int pointOfSale) {
		final String sql = "SELECT COALESCE(MAX(numerocomprobante), 0) " +
				"FROM c_invoice " +
				"WHERE c_doctypetarget_id = ? " +
				"AND issotrx = 'Y' " +
				"AND puntodeventa = ?";
		try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
			ps.setInt(1, TEST_DOC_TYPE_ID);
			ps.setInt(2, pointOfSale);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1) + 1;
				}
			}
		} catch (SQLException ex) {
			throw new IllegalStateException("No se pudo obtener la próxima numeración para el test cronológico", ex);
		}
		return 1;
	}

	private LocalDate findLastInvoiceDate(int pointOfSale) {
		final String sql = "SELECT dateinvoiced::date " +
				"FROM c_invoice " +
				"WHERE c_doctypetarget_id = ? " +
				"AND issotrx = 'Y' " +
				"AND puntodeventa = ? " +
				"AND numerocomprobante > 0 " +
				"ORDER BY numerocomprobante DESC, created DESC LIMIT 1";
		try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
			ps.setInt(1, TEST_DOC_TYPE_ID);
			ps.setInt(2, pointOfSale);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getDate(1).toLocalDate();
				}
			}
		} catch (SQLException ex) {
			throw new IllegalStateException("No se pudo obtener la última fecha de factura para el test cronológico", ex);
		}
		return null;
	}

	private String atNoon(LocalDate date) {
		return date.atTime(12, 0, 0).format(DATE_FORMAT);
	}
}
