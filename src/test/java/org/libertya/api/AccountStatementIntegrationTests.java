package org.libertya.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openXpertya.util.DB;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * Estado de cuenta (GET /v1.0/bpartners/{id}/accountstatement). Ver docs/planes/plan-estado-de-cuenta.md §8.
 *
 * Los socios se eligen por SQL y no con DEFAULT_BPARTNER_ID, que ya no existe en la base de tests. La base de tests
 * no tiene facturas en varias cuotas ni notas de credito con saldo: esos casos, y la comparacion fila por fila con
 * el informe de Estado de Cuenta, se validan a mano contra una base con esos datos.
 */
public class AccountStatementIntegrationTests extends CommonIntegrationTests {

    private static final int CLIENT_ID = 1010016;

    private static final Set<String> ROW_TYPES = new HashSet<>(Arrays.asList("invoice", "installment", "payment", "cashline"));

    private final ObjectMapper mapper = new ObjectMapper().enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);

    /** Socio con mas facturas con saldo */
    private int bpartnerID = -1;

    private ResponseEntity<String> statement(int bpartner, String query, HttpHeaders headers) {
        return restTemplate.exchange(getBaseURL("bpartners/" + bpartner + "/accountstatement" + query),
                HttpMethod.GET,
                new HttpEntity<>(null, headers),
                String.class);
    }

    private ResponseEntity<String> statement(int bpartner, String query) {
        return statement(bpartner, query, getAuthHeaders());
    }

    private List<JsonNode> rows(ResponseEntity<String> response) throws Exception {
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        JsonNode body = mapper.readTree(response.getBody());
        assertThat(body.isArray()).isTrue();
        List<JsonNode> rows = new ArrayList<>();
        body.forEach(rows::add);
        return rows;
    }

    private Set<Integer> ids(String sql, int param) throws SQLException {
        Set<Integer> ids = new HashSet<>();
        try (PreparedStatement ps = DB.prepareStatement(sql, null)) {
            ps.setInt(1, param);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next())
                    ids.add(rs.getInt(1));
            }
        }
        return ids;
    }

    private static Integer intOrNull(JsonNode row, String field) {
        return row.hasNonNull(field) ? row.get(field).intValue() : null;
    }

    @Test
    @Order(1)
    void statementShouldListEveryOpenInvoice() throws Exception {
        bpartnerID = DB.getSQLValue(null,
                "SELECT c_bpartner_id FROM c_invoice WHERE ad_client_id = ? AND docstatus IN ('CO','CL','WC') " +
                " AND invoiceopen(c_invoice_id, 0) <> 0 GROUP BY c_bpartner_id ORDER BY count(*) DESC, c_bpartner_id LIMIT 1",
                CLIENT_ID);
        assumeTrue(bpartnerID > 0, "La compania " + CLIENT_ID + " no tiene facturas con saldo");

        List<JsonNode> rows = rows(statement(bpartnerID, ""));
        assertThat(rows).isNotEmpty();

        Set<Integer> expected = ids("SELECT c_invoice_id FROM c_invoice WHERE c_bpartner_id = ? " +
                " AND docstatus IN ('CO','CL','WC') AND invoiceopen(c_invoice_id, 0) <> 0", bpartnerID);
        Set<Integer> actual = new HashSet<>();
        for (JsonNode row : rows)
            if ("invoice".equals(row.get("rowtype").asText()) || "installment".equals(row.get("rowtype").asText()))
                actual.add(row.get("doc_id").intValue());
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Order(2)
    void rowsShouldHoldInvariants() throws Exception {
        assumeTrue(bpartnerID > 0, "No hay socio con saldo");
        List<JsonNode> rows = rows(statement(bpartnerID, ""));

        Map<Integer, BigDecimal> openByInvoice = new HashMap<>();
        Map<Integer, Integer> signByInvoice = new HashMap<>();
        for (JsonNode row : rows) {
            assertThat(ROW_TYPES).contains(row.get("rowtype").asText());
            assertThat(row.get("c_bpartner_id").intValue()).isEqualTo(bpartnerID);
            assertThat(row.get("signo").intValue()).isIn(1, -1);
            assertThat(row.get("openamt").decimalValue().signum()).isNotZero();
            assertThat(row.get("dateacct").asText()).matches("\\d{4}-\\d{2}-\\d{2}");
            assertThat(row.get("dateinvoiced").asText()).matches("\\d{4}-\\d{2}-\\d{2}");
            if (row.hasNonNull("duedate"))
                assertThat(row.get("duedate").asText()).matches("\\d{4}-\\d{2}-\\d{2}");

            if ("installment".equals(row.get("rowtype").asText())) {
                BigDecimal due = row.get("dueamt").decimalValue();
                BigDecimal paid = row.get("paidamt").decimalValue();
                BigDecimal open = row.get("openamt").decimalValue();
                assertThat(paid.add(open)).isEqualByComparingTo(due);
                assertThat(row.get("installmentno").intValue()).isBetween(1, row.get("installmentcount").intValue());
                int invoice = row.get("doc_id").intValue();
                openByInvoice.merge(invoice, open, BigDecimal::add);
                signByInvoice.put(invoice, row.get("signo").intValue());
            }
        }
        // El saldo de las cuotas de una factura suma el saldo de la factura, con signo
        for (Map.Entry<Integer, BigDecimal> e : openByInvoice.entrySet()) {
            BigDecimal invoiceOpen = DB.getSQLValueBD(null, "SELECT invoiceopen(?, 0)", e.getKey());
            assertThat(e.getValue()).isEqualByComparingTo(invoiceOpen.multiply(BigDecimal.valueOf(signByInvoice.get(e.getKey()))));
        }
    }

    @Test
    @Order(3)
    void rowsShouldComeInStableOrder() throws Exception {
        assumeTrue(bpartnerID > 0, "No hay socio con saldo");
        ResponseEntity<String> first = statement(bpartnerID, "");
        ResponseEntity<String> second = statement(bpartnerID, "");
        // Un consumidor puede calcular un hash sobre la respuesta: sin cambios en la base tiene que ser identica
        assertThat(second.getBody()).isEqualTo(first.getBody());

        Comparator<JsonNode> order = Comparator
                .comparing((JsonNode r) -> r.get("dateacct").asText())
                .thenComparing(r -> r.get("doc_id").intValue())
                .thenComparing(r -> intOrNull(r, "installmentno"), Comparator.nullsLast(Comparator.naturalOrder()))
                .thenComparing(r -> r.get("rowtype").asText());
        List<JsonNode> rows = rows(first);
        List<JsonNode> sorted = new ArrayList<>(rows);
        sorted.sort(order);
        assertThat(rows).isEqualTo(sorted);
    }

    /**
     * Las claves salen solo con los nombres del contrato y en su orden (AccountStatementJsonConfig). Sin eso, el DTO
     * generado agrega claves derivadas de los getters (cbpartnerId...) en un orden que cambia en cada arranque de la
     * JVM, y un hash sobre la respuesta cambiaria despues de cada reinicio de la API.
     */
    @Test
    @Order(9)
    void keysShouldFollowContractOrder() throws Exception {
        assumeTrue(bpartnerID > 0, "No hay socio con saldo");
        List<String> contract = Arrays.asList("rowtype", "doc_id", "c_invoicepayschedule_id", "installmentno",
                "installmentcount", "c_bpartner_id", "ad_org_id", "issotrx", "c_doctype_id", "doctypekey", "docbasetype",
                "doctypename", "doctypeprintname", "documentno", "puntodeventa", "numerocomprobante", "letra",
                "dateinvoiced", "dateacct", "duedate", "c_currency_id", "iso_code", "signo", "grandtotal", "dueamt",
                "paidamt", "openamt", "salesrep_id", "c_paymentterm_id", "paymentrule", "c_order_id");
        for (JsonNode row : rows(statement(bpartnerID, ""))) {
            List<String> keys = new ArrayList<>();
            row.fieldNames().forEachRemaining(keys::add);
            List<String> expected = new ArrayList<>(contract);
            expected.retainAll(keys);
            assertThat(keys).isEqualTo(expected);
        }
    }

    @Test
    @Order(4)
    void orgFilterShouldOnlyReturnThatOrg() throws Exception {
        assumeTrue(bpartnerID > 0, "No hay socio con saldo");
        List<JsonNode> all = rows(statement(bpartnerID, ""));
        int org = all.get(0).get("ad_org_id").intValue();
        long expected = all.stream().filter(r -> r.get("ad_org_id").intValue() == org).count();

        List<JsonNode> filtered = rows(statement(bpartnerID, "?ad_org_id=" + org));
        assertThat(filtered).hasSize((int) expected);
        assertThat(filtered).allMatch(r -> r.get("ad_org_id").intValue() == org);

        // Ningun comprobante es de la organizacion *
        assertThat(rows(statement(bpartnerID, "?ad_org_id=0"))).isEmpty();
    }

    @Test
    @Order(5)
    void bpartnerWithoutBalanceShouldReturnEmptyList() throws Exception {
        int noBalance = DB.getSQLValue(null,
                "SELECT bp.c_bpartner_id FROM c_bpartner bp WHERE bp.ad_client_id = ? " +
                " AND NOT EXISTS (SELECT 1 FROM c_invoice i WHERE i.c_bpartner_id = bp.c_bpartner_id " +
                "                  AND i.docstatus IN ('CO','CL','WC') AND invoiceopen(i.c_invoice_id, 0) <> 0) " +
                " AND NOT EXISTS (SELECT 1 FROM c_payment p WHERE p.c_bpartner_id = bp.c_bpartner_id " +
                "                  AND p.docstatus IN ('CO','CL','WC') AND paymentavailable(p.c_payment_id) <> 0) " +
                " AND NOT EXISTS (SELECT 1 FROM c_cashline cl LEFT JOIN c_invoice ci ON ci.c_invoice_id = cl.c_invoice_id " +
                "                  WHERE COALESCE(cl.c_bpartner_id, ci.c_bpartner_id) = bp.c_bpartner_id " +
                "                  AND cl.docstatus IN ('CO','CL','WC') AND cashlineavailable(cl.c_cashline_id) <> 0) " +
                " ORDER BY bp.c_bpartner_id LIMIT 1",
                CLIENT_ID);
        assumeTrue(noBalance > 0, "No hay socios sin saldo en la compania " + CLIENT_ID);
        assertThat(rows(statement(noBalance, ""))).isEmpty();
    }

    @Test
    @Order(6)
    void inexistentBPartnerShouldReturnNotFound() {
        int inexistent = DB.getSQLValue(null, "SELECT COALESCE(MAX(c_bpartner_id), 0) + 1000000 FROM c_bpartner");
        assertThat(statement(inexistent, "").getStatusCode().value()).isEqualTo(404);
    }

    @Test
    @Order(7)
    void bpartnerOfAnotherClientShouldReturnUnauthorized() {
        int otherClient = DB.getSQLValue(null,
                "SELECT MIN(c_bpartner_id) FROM c_bpartner WHERE ad_client_id NOT IN (0, ?)", CLIENT_ID);
        assumeTrue(otherClient > 0, "No hay socios de otra compania");
        assertThat(statement(otherClient, "").getStatusCode().value()).isEqualTo(401);
    }

    @Test
    @Order(8)
    void invalidTokenShouldBeRejected() {
        assumeTrue(bpartnerID > 0, "No hay socio con saldo");
        assertThat(statement(bpartnerID, "", getUnauthHeaders()).getStatusCode().value()).isEqualTo(403);
    }

    /**
     * Un cobro con payamt negativo (el contra-movimiento de una boleta de deposito) tiene que salir con total, pagado
     * y saldo del mismo signo, y grandtotal = paidamt + openamt. Con abs(payamt), como el informe, el total quedaba con
     * el signo contrario al saldo. Se saltea si la compania no tiene cobros negativos con saldo.
     */
    @Test
    @Order(10)
    void negativePaymentShouldKeepOneSign() throws Exception {
        int paymentID = DB.getSQLValue(null,
                "SELECT MIN(c_payment_id) FROM c_payment WHERE ad_client_id = ? AND payamt < 0 " +
                " AND docstatus IN ('CO','CL','WC') AND paymentavailable(c_payment_id) <> 0", CLIENT_ID);
        assumeTrue(paymentID > 0, "La compania " + CLIENT_ID + " no tiene cobros negativos con saldo");
        int partner = DB.getSQLValue(null, "SELECT c_bpartner_id FROM c_payment WHERE c_payment_id = ?", paymentID);

        JsonNode row = rows(statement(partner, "")).stream()
                .filter(r -> "payment".equals(r.get("rowtype").asText()) && r.get("doc_id").intValue() == paymentID)
                .findFirst().orElseThrow(() -> new AssertionError("El cobro " + paymentID + " no esta en el estado de cuenta"));
        BigDecimal total = row.get("grandtotal").decimalValue();
        BigDecimal paid = row.get("paidamt").decimalValue();
        BigDecimal open = row.get("openamt").decimalValue();
        int expectedSign = -row.get("signo").intValue(); // payamt < 0 invierte el signo del tipo de documento
        assertThat(total.signum()).isEqualTo(expectedSign);
        assertThat(open.signum()).isEqualTo(expectedSign);
        assertThat(paid.signum()).isIn(0, expectedSign);
        assertThat(paid.add(open)).isEqualByComparingTo(total);
    }
}
