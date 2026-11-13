package org.libertya.api.repository;

import org.libertya.api.common.UserInfo;
import org.libertya.api.exception.AuthException;
import org.libertya.api.exception.ModelException;
import org.libertya.api.stub.model.AccountStatementLine;
import org.libertya.api.stub.model.BPartner;
import org.openXpertya.model.X_C_BPartner;
import org.openXpertya.model.X_C_CashLine;
import org.openXpertya.model.X_C_Invoice;
import org.openXpertya.model.X_C_Payment;
import org.openXpertya.util.DB;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Estado de cuenta de una entidad comercial: GET /v1.0/bpartners/{id}/accountstatement.
 *
 * Es la consulta del informe EstadoDeCuentaProcess (cuenta de clientes, solo saldo pendiente, sin filtros)
 * llevada a SQL propio de solo lectura, para un socio. El saldo de cada comprobante y de cada cuota lo calculan
 * las funciones de la base que usa el informe (invoiceopen, getallocatedamt, paymentavailable, paymentallocated,
 * cashlineavailable): aca no se copia la logica de imputacion. Diseno y decisiones en
 * docs/planes/plan-estado-de-cuenta.md (R1 a R7).
 *
 * Cuatro partes unidas con UNION ALL, una fila por partida con saldo distinto de cero:
 *   1. facturas sin cuotas validas;
 *   2. una fila por cuota con saldo de las facturas con cuotas validas;
 *   3. cobros y pagos sin imputar;
 *   4. lineas de caja sin imputar.
 *
 * Diferencias deliberadas con el informe:
 *   - estados CO/CL/WC en las cuatro partes, en cualquier instalacion (R2): el core publico admite VO;
 *   - todos los importes de una fila se multiplican por el mismo signo, y el total sale de c_invoice y no de
 *     rv_c_invoice, que ya niega el de las NC (R1). Por lo mismo, el total de un cobro es payamt con su signo y no
 *     abs(payamt): en un cobro negativo (el contra-movimiento de una boleta de deposito) el abs() lo dejaba con el
 *     signo contrario al de su saldo;
 *   - en las cuotas, paidamt = dueamt - openamt (R4);
 *   - el vencimiento de una factura sin cuotas sale de paymenttermduedate(), que contempla los terminos de
 *     vencimiento fijo (R7);
 *   - el socio no se filtra por isActive ni por isCustomer (R7);
 *   - en las lineas de caja el socio es el de la linea o, si no tiene, el de su factura, e issotrx y documentno
 *     se informan (el informe los pierde).
 *
 * Seguridad (R3): el socio se valida con el retrieve() heredado, el mismo camino que GET /v1.0/bpartners/{id}.
 * Cada parte se filtra con filterByRole sobre su tabla base. Esas clausulas usan nombres de columna sin alias, asi
 * que van dentro de un subselect sobre la tabla base. Los valores de la request viajan como parametros ligados: lo
 * unico que se concatena es lo que arma filterByRole a partir del rol.
 *
 * No es una tabla: tableName/iface son los de C_BPartner solo para que retrieve() valide el socio.
 */
@Repository
public class AccountStatementRepository extends AbstractRepository {

    /** Fecha de corte de las funciones de saldo: la misma expresion que el informe sin fecha hasta */
    private static final String CORTE = "now()::timestamp(6) without time zone";

    /** Estados que entran en el estado de cuenta (R2) */
    private static final String ESTADOS = "('CO','CL','WC')";

    /** Signo de una linea de caja, como lo calcula V_DOCUMENTS: 1 si sale dinero, -1 si entra */
    private static final String SIGNO_CAJA = "(CASE WHEN cl.amount < 0 THEN 1 ELSE -1 END)";

    public AccountStatementRepository() {
        tableName = X_C_BPartner.Table_Name;
        iface = BPartner::new;
    }

    /**
     * @param bpartnerID socio
     * @param orgID si no es null, solo las filas de esa organizacion
     * @return vacio si el socio no existe; si existe, la lista (vacia si no tiene saldo)
     * @throws AuthException si el socio es de otra compania, el rol no lo ve, o el rol no puede leer
     *         C_Invoice, C_Payment o C_CashLine
     */
    public Optional<List<AccountStatementLine>> retrieveStatement(UserInfo info, int bpartnerID, Integer orgID) throws ModelException, AuthException {
        Optional<BPartner> bpartner = retrieve(info, bpartnerID, null, "c_bpartner_id,ad_client_id");
        if (!bpartner.isPresent())
            return Optional.empty();

        // Si el rol no puede leer alguna tabla, filterByRole lanza AuthException y la llamada entera es 401:
        // un estado de cuenta sin una de sus partes daria un saldo equivocado.
        String invoiceAccess = filterByRole(info, X_C_Invoice.Table_Name);
        String paymentAccess = filterByRole(info, X_C_Payment.Table_Name);
        String cashLineAccess = filterByRole(info, X_C_CashLine.Table_Name);

        // La compania es la del token. Un token de compania 0 ve todas (filterByClient), asi que en ese caso se usa
        // la del socio, que ya paso la validacion.
        int clientID = info.getClientID() > 0 ? info.getClientID()
                : bpartner.get().getAdClientId() != null ? bpartner.get().getAdClientId() : 0;

        List<Object> params = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM (");
        appendInvoices(sql, params, clientID, bpartnerID, orgID, invoiceAccess);
        sql.append(" UNION ALL ");
        appendInstallments(sql, params, clientID, bpartnerID, orgID, invoiceAccess);
        sql.append(" UNION ALL ");
        appendPayments(sql, params, clientID, bpartnerID, orgID, paymentAccess);
        sql.append(" UNION ALL ");
        appendCashLines(sql, params, clientID, bpartnerID, orgID, cashLineAccess);
        // Orden total y estable: un consumidor puede calcular un hash sobre la respuesta. rowtype desempata los ids de
        // tablas distintas que coinciden.
        sql.append(") ec ORDER BY dateacct, doc_id, installmentno, rowtype");

        List<AccountStatementLine> lines = new ArrayList<>();
        try (PreparedStatement pstmt = DB.prepareStatement(sql.toString(), null)) {
            for (int i = 0; i < params.size(); i++)
                pstmt.setInt(i + 1, (Integer) params.get(i));
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next())
                    lines.add(toLine(rs));
            }
        } catch (SQLException e) {
            throw new ModelException("Error al calcular el estado de cuenta. " + e.getMessage());
        }
        return Optional.of(lines);
    }

    /** Parte 1: facturas sin cuotas validas */
    private void appendInvoices(StringBuilder sql, List<Object> params, int clientID, int bpartnerID, Integer orgID, String access) {
        sql.append(
            " SELECT 'invoice'::text AS rowtype, i.c_invoice_id AS doc_id, NULL::integer AS c_invoicepayschedule_id," +
            "        NULL::integer AS installmentno, NULL::integer AS installmentcount," +
            "        i.c_bpartner_id, i.ad_org_id, (i.issotrx = 'Y') AS issotrx," +
            "        dt.c_doctype_id, dt.doctypekey::text AS doctypekey, dt.docbasetype::text AS docbasetype," +
            "        dt.name::text AS doctypename, dt.printname::text AS doctypeprintname," +
            "        i.documentno::text AS documentno, i.puntodeventa, i.numerocomprobante, lc.letra::text AS letra," +
            "        to_char(i.dateinvoiced, 'YYYY-MM-DD') AS dateinvoiced, to_char(i.dateacct, 'YYYY-MM-DD') AS dateacct," +
            "        to_char(paymenttermduedate(i.c_paymentterm_id, i.dateinvoiced), 'YYYY-MM-DD') AS duedate," +
            "        i.c_currency_id, cur.iso_code::text AS iso_code, dt.signo_issotrx AS signo," +
            "        i.grandtotal * dt.signo_issotrx AS grandtotal, NULL::numeric AS dueamt," +
            "        getallocatedamt(i.c_invoice_id, i.c_currency_id, i.c_conversiontype_id, 1, " + CORTE + ") * dt.signo_issotrx AS paidamt," +
            "        invoiceopen(i.c_invoice_id, 0, i.c_currency_id, i.c_conversiontype_id, " + CORTE + ") * dt.signo_issotrx AS openamt," +
            "        i.salesrep_id, i.c_paymentterm_id, i.paymentrule::text AS paymentrule, i.c_order_id" +
            "   FROM c_invoice i" +
            "   JOIN c_doctype dt ON dt.c_doctype_id = i.c_doctype_id" +
            "   LEFT JOIN c_currency cur ON cur.c_currency_id = i.c_currency_id" +
            "   LEFT JOIN c_letra_comprobante lc ON lc.c_letra_comprobante_id = i.c_letra_comprobante_id" +
            "  WHERE i.ad_client_id = ? AND i.c_bpartner_id = ?" +
            "    AND i.docstatus IN " + ESTADOS +
            "    AND i.ispayschedulevalid <> 'Y'" +
            "    AND invoiceopen(i.c_invoice_id, 0, " + CORTE + ") <> 0");
        params.add(clientID);
        params.add(bpartnerID);
        appendOrg(sql, params, "i", orgID);
        sql.append("    AND i.c_invoice_id IN (SELECT c_invoice_id FROM c_invoice WHERE c_bpartner_id = ? AND (" + access + "))");
        params.add(bpartnerID);
    }

    /**
     * Parte 2: una fila por cuota con saldo. Las cuotas se numeran entre todas las validas de la factura, por
     * vencimiento y por id, ANTES de descartar las pagadas: la cuota 2 sigue siendo la 2 aunque la 1 este paga.
     */
    private void appendInstallments(StringBuilder sql, List<Object> params, int clientID, int bpartnerID, Integer orgID, String access) {
        sql.append(
            " SELECT 'installment'::text, i.c_invoice_id, ips.c_invoicepayschedule_id," +
            "        ips.installmentno::integer, ips.installmentcount::integer," +
            "        i.c_bpartner_id, i.ad_org_id, (i.issotrx = 'Y')," +
            "        dt.c_doctype_id, dt.doctypekey::text, dt.docbasetype::text, dt.name::text, dt.printname::text," +
            "        i.documentno::text, i.puntodeventa, i.numerocomprobante, lc.letra::text," +
            "        to_char(i.dateinvoiced, 'YYYY-MM-DD'), to_char(i.dateacct, 'YYYY-MM-DD'), to_char(ips.duedate, 'YYYY-MM-DD')," +
            "        i.c_currency_id, cur.iso_code::text, dt.signo_issotrx," +
            "        i.grandtotal * dt.signo_issotrx, ips.dueamt * dt.signo_issotrx," +
            "        (ips.dueamt - invoiceopen(i.c_invoice_id, ips.c_invoicepayschedule_id, i.c_currency_id, i.c_conversiontype_id, " + CORTE + ")) * dt.signo_issotrx," +
            "        invoiceopen(i.c_invoice_id, ips.c_invoicepayschedule_id, i.c_currency_id, i.c_conversiontype_id, " + CORTE + ") * dt.signo_issotrx," +
            "        i.salesrep_id, i.c_paymentterm_id, i.paymentrule::text, i.c_order_id" +
            "   FROM c_invoice i" +
            "   JOIN (SELECT s.c_invoice_id, s.c_invoicepayschedule_id, s.duedate, s.dueamt," +
            "                row_number() OVER (PARTITION BY s.c_invoice_id ORDER BY s.duedate, s.c_invoicepayschedule_id) AS installmentno," +
            "                count(*) OVER (PARTITION BY s.c_invoice_id) AS installmentcount" +
            "           FROM c_invoicepayschedule s" +
            "          WHERE s.isvalid = 'Y'" +
            "            AND s.c_invoice_id IN (SELECT c_invoice_id FROM c_invoice WHERE c_bpartner_id = ?)) ips" +
            "        ON ips.c_invoice_id = i.c_invoice_id" +
            "   JOIN c_doctype dt ON dt.c_doctype_id = i.c_doctype_id" +
            "   LEFT JOIN c_currency cur ON cur.c_currency_id = i.c_currency_id" +
            "   LEFT JOIN c_letra_comprobante lc ON lc.c_letra_comprobante_id = i.c_letra_comprobante_id" +
            "  WHERE i.ad_client_id = ? AND i.c_bpartner_id = ?" +
            "    AND i.docstatus IN " + ESTADOS +
            "    AND i.ispayschedulevalid = 'Y'" +
            "    AND invoiceopen(i.c_invoice_id, 0, " + CORTE + ") <> 0" +
            "    AND invoiceopen(i.c_invoice_id, ips.c_invoicepayschedule_id, " + CORTE + ") <> 0");
        params.add(bpartnerID);
        params.add(clientID);
        params.add(bpartnerID);
        appendOrg(sql, params, "i", orgID);
        sql.append("    AND i.c_invoice_id IN (SELECT c_invoice_id FROM c_invoice WHERE c_bpartner_id = ? AND (" + access + "))");
        params.add(bpartnerID);
    }

    /**
     * Parte 3: cobros (y pagos, si el socio tambien es proveedor) sin imputar.
     *
     * El total es payamt con su signo. paymentavailable devuelve el saldo con el signo de payamt, y las
     * imputaciones a un cobro negativo tambien son negativas (paymentallocated), asi que los tres importes quedan
     * con el mismo signo y grandtotal = paidamt + openamt tambien en un cobro negativo. El informe usa abs(payamt).
     */
    private void appendPayments(StringBuilder sql, List<Object> params, int clientID, int bpartnerID, Integer orgID, String access) {
        sql.append(
            " SELECT 'payment'::text, p.c_payment_id, NULL::integer, NULL::integer, NULL::integer," +
            "        p.c_bpartner_id, p.ad_org_id, (p.isreceipt = 'Y')," +
            "        dt.c_doctype_id, dt.doctypekey::text, dt.docbasetype::text, dt.name::text, dt.printname::text," +
            "        p.documentno::text, NULL::integer, NULL::integer, NULL::text," +
            "        to_char(p.datetrx, 'YYYY-MM-DD'), to_char(p.dateacct, 'YYYY-MM-DD'), NULL::text," +
            "        p.c_currency_id, cur.iso_code::text, dt.signo_issotrx," +
            "        p.payamt * dt.signo_issotrx, NULL::numeric," +
            "        paymentallocated(p.c_payment_id, p.c_currency_id, " + CORTE + ") * dt.signo_issotrx," +
            "        paymentavailable(p.c_payment_id, " + CORTE + ") * dt.signo_issotrx," +
            "        NULL::integer, NULL::integer, NULL::text, NULL::integer" +
            "   FROM c_payment p" +
            "   JOIN c_doctype dt ON dt.c_doctype_id = p.c_doctype_id" +
            "   LEFT JOIN c_currency cur ON cur.c_currency_id = p.c_currency_id" +
            "  WHERE p.ad_client_id = ? AND p.c_bpartner_id = ?" +
            "    AND p.docstatus IN " + ESTADOS +
            "    AND paymentavailable(p.c_payment_id, " + CORTE + ") <> 0");
        params.add(clientID);
        params.add(bpartnerID);
        appendOrg(sql, params, "p", orgID);
        sql.append("    AND p.c_payment_id IN (SELECT c_payment_id FROM c_payment WHERE c_bpartner_id = ? AND (" + access + "))");
        params.add(bpartnerID);
    }

    /**
     * Parte 4: lineas de caja sin imputar. El socio es el de la linea o, si no tiene (ventas en efectivo por Libro
     * de Caja), el de su factura. El tipo de documento es el CMC de la compania; si hubiera mas de uno se toma el
     * de menor id, para que el resultado no dependa del plan de ejecucion. Es LEFT JOIN: una compania sin tipo CMC
     * no pierde sus lineas de caja.
     */
    private void appendCashLines(StringBuilder sql, List<Object> params, int clientID, int bpartnerID, Integer orgID, String access) {
        sql.append(
            " SELECT 'cashline'::text, cl.c_cashline_id, NULL::integer, NULL::integer, NULL::integer," +
            "        COALESCE(cl.c_bpartner_id, ic.c_bpartner_id), cl.ad_org_id, (cl.amount >= 0)," +
            "        dt.c_doctype_id, dt.doctypekey::text, dt.docbasetype::text, dt.name::text, dt.printname::text," +
            "        c.name || ' / ' || cl.line::character varying, NULL::integer, NULL::integer, NULL::text," +
            "        to_char(c.statementdate, 'YYYY-MM-DD'), to_char(c.dateacct, 'YYYY-MM-DD'), NULL::text," +
            "        cl.c_currency_id, cur.iso_code::text, " + SIGNO_CAJA + "," +
            "        abs(cl.amount) * " + SIGNO_CAJA + ", NULL::numeric," +
            "        (abs(cl.amount) - abs(cashlineavailable(cl.c_cashline_id, " + CORTE + "))) * " + SIGNO_CAJA + "," +
            "        abs(cashlineavailable(cl.c_cashline_id, " + CORTE + ")) * " + SIGNO_CAJA + "," +
            "        NULL::integer, NULL::integer, NULL::text, NULL::integer" +
            "   FROM c_cashline cl" +
            "   JOIN c_cash c ON c.c_cash_id = cl.c_cash_id" +
            "   LEFT JOIN c_invoice ic ON ic.c_invoice_id = cl.c_invoice_id" +
            "   LEFT JOIN c_currency cur ON cur.c_currency_id = cl.c_currency_id" +
            "   LEFT JOIN LATERAL (SELECT d.c_doctype_id, d.doctypekey, d.docbasetype, d.name, d.printname" +
            "                        FROM c_doctype d" +
            "                       WHERE d.doctypekey = 'CMC' AND d.ad_client_id = cl.ad_client_id" +
            "                       ORDER BY d.c_doctype_id LIMIT 1) dt ON true" +
            "  WHERE cl.ad_client_id = ?" +
            "    AND cl.docstatus IN " + ESTADOS +
            "    AND cashlineavailable(cl.c_cashline_id, " + CORTE + ") <> 0" +
            // El filtro del rol va en el mismo subselect que elige las lineas del socio, para que no recorra
            // todas las lineas de caja de la compania.
            "    AND cl.c_cashline_id IN (SELECT c_cashline_id FROM c_cashline" +
            "                              WHERE c_bpartner_id = ? AND (" + access + ")" +
            "                             UNION ALL" +
            "                             SELECT c_cashline_id FROM c_cashline" +
            "                              WHERE c_bpartner_id IS NULL" +
            "                                AND c_invoice_id IN (SELECT c_invoice_id FROM c_invoice WHERE c_bpartner_id = ?)" +
            "                                AND (" + access + "))");
        params.add(clientID);
        params.add(bpartnerID);
        params.add(bpartnerID);
        appendOrg(sql, params, "cl", orgID);
    }

    private void appendOrg(StringBuilder sql, List<Object> params, String alias, Integer orgID) {
        if (orgID == null)
            return;
        sql.append("    AND ").append(alias).append(".ad_org_id = ?");
        params.add(orgID);
    }

    private AccountStatementLine toLine(ResultSet rs) throws SQLException {
        AccountStatementLine line = new AccountStatementLine();
        line.setRowtype(rs.getString("rowtype"));
        line.setDocId(getInteger(rs, "doc_id"));
        line.setCInvoicepayscheduleId(getInteger(rs, "c_invoicepayschedule_id"));
        line.setInstallmentno(getInteger(rs, "installmentno"));
        line.setInstallmentcount(getInteger(rs, "installmentcount"));
        line.setCBpartnerId(getInteger(rs, "c_bpartner_id"));
        line.setAdOrgId(getInteger(rs, "ad_org_id"));
        line.setIssotrx(getBoolean(rs, "issotrx"));
        line.setCDoctypeId(getInteger(rs, "c_doctype_id"));
        line.setDoctypekey(rs.getString("doctypekey"));
        line.setDocbasetype(rs.getString("docbasetype"));
        line.setDoctypename(rs.getString("doctypename"));
        line.setDoctypeprintname(rs.getString("doctypeprintname"));
        line.setDocumentno(rs.getString("documentno"));
        line.setPuntodeventa(getInteger(rs, "puntodeventa"));
        line.setNumerocomprobante(getInteger(rs, "numerocomprobante"));
        line.setLetra(rs.getString("letra"));
        line.setDateinvoiced(rs.getString("dateinvoiced"));
        line.setDateacct(rs.getString("dateacct"));
        line.setDuedate(rs.getString("duedate"));
        line.setCCurrencyId(getInteger(rs, "c_currency_id"));
        line.setIsoCode(rs.getString("iso_code"));
        line.setSigno(getInteger(rs, "signo"));
        line.setGrandtotal(rs.getBigDecimal("grandtotal"));
        line.setDueamt(rs.getBigDecimal("dueamt"));
        line.setPaidamt(rs.getBigDecimal("paidamt"));
        line.setOpenamt(rs.getBigDecimal("openamt"));
        line.setSalesrepId(getInteger(rs, "salesrep_id"));
        line.setCPaymenttermId(getInteger(rs, "c_paymentterm_id"));
        line.setPaymentrule(rs.getString("paymentrule"));
        line.setCOrderId(getInteger(rs, "c_order_id"));
        return line;
    }

    /** getInt() convierte null en 0: los enteros que pueden faltar se leen como objeto */
    private Integer getInteger(ResultSet rs, String column) throws SQLException {
        Object value = rs.getObject(column);
        return value == null ? null : ((Number) value).intValue();
    }

    private Boolean getBoolean(ResultSet rs, String column) throws SQLException {
        boolean value = rs.getBoolean(column);
        return rs.wasNull() ? null : value;
    }
}
