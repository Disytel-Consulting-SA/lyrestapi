package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Una partida con saldo del estado de cuenta. Todos los importes estan en la moneda del comprobante y multiplicados por signo: positivo es deuda de la entidad, negativo es saldo a su favor. 
 */
@Schema(description = "Una partida con saldo del estado de cuenta. Todos los importes estan en la moneda del comprobante y multiplicados por signo: positivo es deuda de la entidad, negativo es saldo a su favor. ")
@Validated



public class AccountStatementLine   {
  @JsonProperty("rowtype")
  private String rowtype = null;

  @JsonProperty("doc_id")
  private Integer docId = null;

  @JsonProperty("c_invoicepayschedule_id")
  private Integer cInvoicepayscheduleId = null;

  @JsonProperty("installmentno")
  private Integer installmentno = null;

  @JsonProperty("installmentcount")
  private Integer installmentcount = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("issotrx")
  private Boolean issotrx = null;

  @JsonProperty("c_doctype_id")
  private Integer cDoctypeId = null;

  @JsonProperty("doctypekey")
  private String doctypekey = null;

  @JsonProperty("docbasetype")
  private String docbasetype = null;

  @JsonProperty("doctypename")
  private String doctypename = null;

  @JsonProperty("doctypeprintname")
  private String doctypeprintname = null;

  @JsonProperty("documentno")
  private String documentno = null;

  @JsonProperty("puntodeventa")
  private Integer puntodeventa = null;

  @JsonProperty("numerocomprobante")
  private Integer numerocomprobante = null;

  @JsonProperty("letra")
  private String letra = null;

  @JsonProperty("dateinvoiced")
  private String dateinvoiced = null;

  @JsonProperty("dateacct")
  private String dateacct = null;

  @JsonProperty("duedate")
  private String duedate = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("iso_code")
  private String isoCode = null;

  @JsonProperty("signo")
  private Integer signo = null;

  @JsonProperty("grandtotal")
  private BigDecimal grandtotal = null;

  @JsonProperty("dueamt")
  private BigDecimal dueamt = null;

  @JsonProperty("paidamt")
  private BigDecimal paidamt = null;

  @JsonProperty("openamt")
  private BigDecimal openamt = null;

  @JsonProperty("salesrep_id")
  private Integer salesrepId = null;

  @JsonProperty("c_paymentterm_id")
  private Integer cPaymenttermId = null;

  @JsonProperty("paymentrule")
  private String paymentrule = null;

  @JsonProperty("c_order_id")
  private Integer cOrderId = null;

  public AccountStatementLine rowtype(String rowtype) {
    this.rowtype = rowtype;
    return this;
  }

  /**
   * invoice = factura sin cuotas validas; installment = una cuota de una factura con cuotas validas; payment = cobro o pago sin imputar; cashline = linea de caja sin imputar 
   * @return rowtype
   **/
  @Schema(description = "invoice = factura sin cuotas validas; installment = una cuota de una factura con cuotas validas; payment = cobro o pago sin imputar; cashline = linea de caja sin imputar ")
  
    public String getRowtype() {
    return rowtype;
  }

  public void setRowtype(String rowtype) {
    this.rowtype = rowtype;
  }

  public AccountStatementLine docId(Integer docId) {
    this.docId = docId;
    return this;
  }

  /**
   * c_invoice_id, c_payment_id o c_cashline_id segun rowtype. Los ids de tablas distintas pueden coincidir
   * @return docId
   **/
  @Schema(description = "c_invoice_id, c_payment_id o c_cashline_id segun rowtype. Los ids de tablas distintas pueden coincidir")
  
    public Integer getDocId() {
    return docId;
  }

  public void setDocId(Integer docId) {
    this.docId = docId;
  }

  public AccountStatementLine cInvoicepayscheduleId(Integer cInvoicepayscheduleId) {
    this.cInvoicepayscheduleId = cInvoicepayscheduleId;
    return this;
  }

  /**
   * Cuota. Solo en rowtype=installment
   * @return cInvoicepayscheduleId
   **/
  @Schema(description = "Cuota. Solo en rowtype=installment")
  
    public Integer getCInvoicepayscheduleId() {
    return cInvoicepayscheduleId;
  }

  public void setCInvoicepayscheduleId(Integer cInvoicepayscheduleId) {
    this.cInvoicepayscheduleId = cInvoicepayscheduleId;
  }

  public AccountStatementLine installmentno(Integer installmentno) {
    this.installmentno = installmentno;
    return this;
  }

  /**
   * Numero de la cuota entre las cuotas validas de la factura, ordenadas por vencimiento y por id. Se numera antes de descartar las cuotas pagadas. Solo en rowtype=installment 
   * @return installmentno
   **/
  @Schema(description = "Numero de la cuota entre las cuotas validas de la factura, ordenadas por vencimiento y por id. Se numera antes de descartar las cuotas pagadas. Solo en rowtype=installment ")
  
    public Integer getInstallmentno() {
    return installmentno;
  }

  public void setInstallmentno(Integer installmentno) {
    this.installmentno = installmentno;
  }

  public AccountStatementLine installmentcount(Integer installmentcount) {
    this.installmentcount = installmentcount;
    return this;
  }

  /**
   * Cantidad de cuotas validas de la factura. Solo en rowtype=installment
   * @return installmentcount
   **/
  @Schema(description = "Cantidad de cuotas validas de la factura. Solo en rowtype=installment")
  
    public Integer getInstallmentcount() {
    return installmentcount;
  }

  public void setInstallmentcount(Integer installmentcount) {
    this.installmentcount = installmentcount;
  }

  public AccountStatementLine cBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
    return this;
  }

  /**
   * Entidad comercial. En las lineas de caja sin entidad propia, la de su factura
   * @return cBpartnerId
   **/
  @Schema(description = "Entidad comercial. En las lineas de caja sin entidad propia, la de su factura")
  
    public Integer getCBpartnerId() {
    return cBpartnerId;
  }

  public void setCBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
  }

  public AccountStatementLine adOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
    return this;
  }

  /**
   * Organizacion del comprobante
   * @return adOrgId
   **/
  @Schema(description = "Organizacion del comprobante")
  
    public Integer getAdOrgId() {
    return adOrgId;
  }

  public void setAdOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
  }

  public AccountStatementLine issotrx(Boolean issotrx) {
    this.issotrx = issotrx;
    return this;
  }

  /**
   * Factura: issotrx. Cobro o pago: isreceipt. Linea de caja: importe mayor o igual a cero
   * @return issotrx
   **/
  @Schema(description = "Factura: issotrx. Cobro o pago: isreceipt. Linea de caja: importe mayor o igual a cero")
  
    public Boolean isIssotrx() {
    return issotrx;
  }

  public void setIssotrx(Boolean issotrx) {
    this.issotrx = issotrx;
  }

  public AccountStatementLine cDoctypeId(Integer cDoctypeId) {
    this.cDoctypeId = cDoctypeId;
    return this;
  }

  /**
   * Tipo de documento. En las lineas de caja, el tipo CMC de la compania
   * @return cDoctypeId
   **/
  @Schema(description = "Tipo de documento. En las lineas de caja, el tipo CMC de la compania")
  
    public Integer getCDoctypeId() {
    return cDoctypeId;
  }

  public void setCDoctypeId(Integer cDoctypeId) {
    this.cDoctypeId = cDoctypeId;
  }

  public AccountStatementLine doctypekey(String doctypekey) {
    this.doctypekey = doctypekey;
    return this;
  }

  /**
   * Clave del tipo de documento
   * @return doctypekey
   **/
  @Schema(description = "Clave del tipo de documento")
  
    public String getDoctypekey() {
    return doctypekey;
  }

  public void setDoctypekey(String doctypekey) {
    this.doctypekey = doctypekey;
  }

  public AccountStatementLine docbasetype(String docbasetype) {
    this.docbasetype = docbasetype;
    return this;
  }

  /**
   * Tipo base del documento (ARI, ARC, ARR, API, APC, APP, CMC...)
   * @return docbasetype
   **/
  @Schema(description = "Tipo base del documento (ARI, ARC, ARR, API, APC, APP, CMC...)")
  
    public String getDocbasetype() {
    return docbasetype;
  }

  public void setDocbasetype(String docbasetype) {
    this.docbasetype = docbasetype;
  }

  public AccountStatementLine doctypename(String doctypename) {
    this.doctypename = doctypename;
    return this;
  }

  /**
   * Nombre del tipo de documento
   * @return doctypename
   **/
  @Schema(description = "Nombre del tipo de documento")
  
    public String getDoctypename() {
    return doctypename;
  }

  public void setDoctypename(String doctypename) {
    this.doctypename = doctypename;
  }

  public AccountStatementLine doctypeprintname(String doctypeprintname) {
    this.doctypeprintname = doctypeprintname;
    return this;
  }

  /**
   * Nombre de impresion del tipo de documento
   * @return doctypeprintname
   **/
  @Schema(description = "Nombre de impresion del tipo de documento")
  
    public String getDoctypeprintname() {
    return doctypeprintname;
  }

  public void setDoctypeprintname(String doctypeprintname) {
    this.doctypeprintname = doctypeprintname;
  }

  public AccountStatementLine documentno(String documentno) {
    this.documentno = documentno;
    return this;
  }

  /**
   * Numero de documento. En las lineas de caja, <nombre de la caja> / <linea>
   * @return documentno
   **/
  @Schema(description = "Numero de documento. En las lineas de caja, <nombre de la caja> / <linea>")
  
    public String getDocumentno() {
    return documentno;
  }

  public void setDocumentno(String documentno) {
    this.documentno = documentno;
  }

  public AccountStatementLine puntodeventa(Integer puntodeventa) {
    this.puntodeventa = puntodeventa;
    return this;
  }

  /**
   * Punto de venta. Solo facturas
   * @return puntodeventa
   **/
  @Schema(description = "Punto de venta. Solo facturas")
  
    public Integer getPuntodeventa() {
    return puntodeventa;
  }

  public void setPuntodeventa(Integer puntodeventa) {
    this.puntodeventa = puntodeventa;
  }

  public AccountStatementLine numerocomprobante(Integer numerocomprobante) {
    this.numerocomprobante = numerocomprobante;
    return this;
  }

  /**
   * Numero de comprobante. Solo facturas
   * @return numerocomprobante
   **/
  @Schema(description = "Numero de comprobante. Solo facturas")
  
    public Integer getNumerocomprobante() {
    return numerocomprobante;
  }

  public void setNumerocomprobante(Integer numerocomprobante) {
    this.numerocomprobante = numerocomprobante;
  }

  public AccountStatementLine letra(String letra) {
    this.letra = letra;
    return this;
  }

  /**
   * Letra del comprobante (la letra, no el id). Solo facturas
   * @return letra
   **/
  @Schema(description = "Letra del comprobante (la letra, no el id). Solo facturas")
  
    public String getLetra() {
    return letra;
  }

  public void setLetra(String letra) {
    this.letra = letra;
  }

  public AccountStatementLine dateinvoiced(String dateinvoiced) {
    this.dateinvoiced = dateinvoiced;
    return this;
  }

  /**
   * yyyy-MM-dd. Factura: fecha de facturacion. Cobro o pago: fecha de transaccion. Linea de caja: fecha del extracto
   * @return dateinvoiced
   **/
  @Schema(description = "yyyy-MM-dd. Factura: fecha de facturacion. Cobro o pago: fecha de transaccion. Linea de caja: fecha del extracto")
  
    public String getDateinvoiced() {
    return dateinvoiced;
  }

  public void setDateinvoiced(String dateinvoiced) {
    this.dateinvoiced = dateinvoiced;
  }

  public AccountStatementLine dateacct(String dateacct) {
    this.dateacct = dateacct;
    return this;
  }

  /**
   * yyyy-MM-dd. Fecha contable
   * @return dateacct
   **/
  @Schema(description = "yyyy-MM-dd. Fecha contable")
  
    public String getDateacct() {
    return dateacct;
  }

  public void setDateacct(String dateacct) {
    this.dateacct = dateacct;
  }

  public AccountStatementLine duedate(String duedate) {
    this.duedate = duedate;
    return this;
  }

  /**
   * yyyy-MM-dd. Factura sin cuotas: vencimiento segun el termino de pago (paymenttermduedate). Cuota: su vencimiento. Vacio en cobros, pagos y lineas de caja
   * @return duedate
   **/
  @Schema(description = "yyyy-MM-dd. Factura sin cuotas: vencimiento segun el termino de pago (paymenttermduedate). Cuota: su vencimiento. Vacio en cobros, pagos y lineas de caja")
  
    public String getDuedate() {
    return duedate;
  }

  public void setDuedate(String duedate) {
    this.duedate = duedate;
  }

  public AccountStatementLine cCurrencyId(Integer cCurrencyId) {
    this.cCurrencyId = cCurrencyId;
    return this;
  }

  /**
   * Moneda del comprobante
   * @return cCurrencyId
   **/
  @Schema(description = "Moneda del comprobante")
  
    public Integer getCCurrencyId() {
    return cCurrencyId;
  }

  public void setCCurrencyId(Integer cCurrencyId) {
    this.cCurrencyId = cCurrencyId;
  }

  public AccountStatementLine isoCode(String isoCode) {
    this.isoCode = isoCode;
    return this;
  }

  /**
   * Codigo ISO de la moneda del comprobante
   * @return isoCode
   **/
  @Schema(description = "Codigo ISO de la moneda del comprobante")
  
    public String getIsoCode() {
    return isoCode;
  }

  public void setIsoCode(String isoCode) {
    this.isoCode = isoCode;
  }

  public AccountStatementLine signo(Integer signo) {
    this.signo = signo;
    return this;
  }

  /**
   * 1 o -1. signo_issotrx del tipo de documento; en las lineas de caja, 1 si el importe es negativo y -1 si no
   * @return signo
   **/
  @Schema(description = "1 o -1. signo_issotrx del tipo de documento; en las lineas de caja, 1 si el importe es negativo y -1 si no")
  
    public Integer getSigno() {
    return signo;
  }

  public void setSigno(Integer signo) {
    this.signo = signo;
  }

  public AccountStatementLine grandtotal(BigDecimal grandtotal) {
    this.grandtotal = grandtotal;
    return this;
  }

  /**
   * Total del comprobante por signo. Factura: c_invoice.grandtotal. Cobro o pago: payamt, con su signo. Linea de caja: abs(amount)
   * @return grandtotal
   **/
  @Schema(description = "Total del comprobante por signo. Factura: c_invoice.grandtotal. Cobro o pago: payamt, con su signo. Linea de caja: abs(amount)")
  
    @Valid
    public BigDecimal getGrandtotal() {
    return grandtotal;
  }

  public void setGrandtotal(BigDecimal grandtotal) {
    this.grandtotal = grandtotal;
  }

  public AccountStatementLine dueamt(BigDecimal dueamt) {
    this.dueamt = dueamt;
    return this;
  }

  /**
   * Importe de la cuota por signo. Solo en rowtype=installment
   * @return dueamt
   **/
  @Schema(description = "Importe de la cuota por signo. Solo en rowtype=installment")
  
    @Valid
    public BigDecimal getDueamt() {
    return dueamt;
  }

  public void setDueamt(BigDecimal dueamt) {
    this.dueamt = dueamt;
  }

  public AccountStatementLine paidamt(BigDecimal paidamt) {
    this.paidamt = paidamt;
    return this;
  }

  /**
   * Imputado por signo. En las cuotas es dueamt - openamt
   * @return paidamt
   **/
  @Schema(description = "Imputado por signo. En las cuotas es dueamt - openamt")
  
    @Valid
    public BigDecimal getPaidamt() {
    return paidamt;
  }

  public void setPaidamt(BigDecimal paidamt) {
    this.paidamt = paidamt;
  }

  public AccountStatementLine openamt(BigDecimal openamt) {
    this.openamt = openamt;
    return this;
  }

  /**
   * Saldo calculado por Libertya, por signo
   * @return openamt
   **/
  @Schema(description = "Saldo calculado por Libertya, por signo")
  
    @Valid
    public BigDecimal getOpenamt() {
    return openamt;
  }

  public void setOpenamt(BigDecimal openamt) {
    this.openamt = openamt;
  }

  public AccountStatementLine salesrepId(Integer salesrepId) {
    this.salesrepId = salesrepId;
    return this;
  }

  /**
   * Vendedor de la factura. Solo facturas
   * @return salesrepId
   **/
  @Schema(description = "Vendedor de la factura. Solo facturas")
  
    public Integer getSalesrepId() {
    return salesrepId;
  }

  public void setSalesrepId(Integer salesrepId) {
    this.salesrepId = salesrepId;
  }

  public AccountStatementLine cPaymenttermId(Integer cPaymenttermId) {
    this.cPaymenttermId = cPaymenttermId;
    return this;
  }

  /**
   * Termino de pago de la factura. Solo facturas
   * @return cPaymenttermId
   **/
  @Schema(description = "Termino de pago de la factura. Solo facturas")
  
    public Integer getCPaymenttermId() {
    return cPaymenttermId;
  }

  public void setCPaymenttermId(Integer cPaymenttermId) {
    this.cPaymenttermId = cPaymenttermId;
  }

  public AccountStatementLine paymentrule(String paymentrule) {
    this.paymentrule = paymentrule;
    return this;
  }

  /**
   * Forma de pago de la factura. Solo facturas
   * @return paymentrule
   **/
  @Schema(description = "Forma de pago de la factura. Solo facturas")
  
    public String getPaymentrule() {
    return paymentrule;
  }

  public void setPaymentrule(String paymentrule) {
    this.paymentrule = paymentrule;
  }

  public AccountStatementLine cOrderId(Integer cOrderId) {
    this.cOrderId = cOrderId;
    return this;
  }

  /**
   * Pedido de la factura. Solo facturas
   * @return cOrderId
   **/
  @Schema(description = "Pedido de la factura. Solo facturas")
  
    public Integer getCOrderId() {
    return cOrderId;
  }

  public void setCOrderId(Integer cOrderId) {
    this.cOrderId = cOrderId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountStatementLine accountStatementLine = (AccountStatementLine) o;
    return Objects.equals(this.rowtype, accountStatementLine.rowtype) &&
        Objects.equals(this.docId, accountStatementLine.docId) &&
        Objects.equals(this.cInvoicepayscheduleId, accountStatementLine.cInvoicepayscheduleId) &&
        Objects.equals(this.installmentno, accountStatementLine.installmentno) &&
        Objects.equals(this.installmentcount, accountStatementLine.installmentcount) &&
        Objects.equals(this.cBpartnerId, accountStatementLine.cBpartnerId) &&
        Objects.equals(this.adOrgId, accountStatementLine.adOrgId) &&
        Objects.equals(this.issotrx, accountStatementLine.issotrx) &&
        Objects.equals(this.cDoctypeId, accountStatementLine.cDoctypeId) &&
        Objects.equals(this.doctypekey, accountStatementLine.doctypekey) &&
        Objects.equals(this.docbasetype, accountStatementLine.docbasetype) &&
        Objects.equals(this.doctypename, accountStatementLine.doctypename) &&
        Objects.equals(this.doctypeprintname, accountStatementLine.doctypeprintname) &&
        Objects.equals(this.documentno, accountStatementLine.documentno) &&
        Objects.equals(this.puntodeventa, accountStatementLine.puntodeventa) &&
        Objects.equals(this.numerocomprobante, accountStatementLine.numerocomprobante) &&
        Objects.equals(this.letra, accountStatementLine.letra) &&
        Objects.equals(this.dateinvoiced, accountStatementLine.dateinvoiced) &&
        Objects.equals(this.dateacct, accountStatementLine.dateacct) &&
        Objects.equals(this.duedate, accountStatementLine.duedate) &&
        Objects.equals(this.cCurrencyId, accountStatementLine.cCurrencyId) &&
        Objects.equals(this.isoCode, accountStatementLine.isoCode) &&
        Objects.equals(this.signo, accountStatementLine.signo) &&
        Objects.equals(this.grandtotal, accountStatementLine.grandtotal) &&
        Objects.equals(this.dueamt, accountStatementLine.dueamt) &&
        Objects.equals(this.paidamt, accountStatementLine.paidamt) &&
        Objects.equals(this.openamt, accountStatementLine.openamt) &&
        Objects.equals(this.salesrepId, accountStatementLine.salesrepId) &&
        Objects.equals(this.cPaymenttermId, accountStatementLine.cPaymenttermId) &&
        Objects.equals(this.paymentrule, accountStatementLine.paymentrule) &&
        Objects.equals(this.cOrderId, accountStatementLine.cOrderId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rowtype, docId, cInvoicepayscheduleId, installmentno, installmentcount, cBpartnerId, adOrgId, issotrx, cDoctypeId, doctypekey, docbasetype, doctypename, doctypeprintname, documentno, puntodeventa, numerocomprobante, letra, dateinvoiced, dateacct, duedate, cCurrencyId, isoCode, signo, grandtotal, dueamt, paidamt, openamt, salesrepId, cPaymenttermId, paymentrule, cOrderId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountStatementLine {\n");
    
    sb.append("    rowtype: ").append(toIndentedString(rowtype)).append("\n");
    sb.append("    docId: ").append(toIndentedString(docId)).append("\n");
    sb.append("    cInvoicepayscheduleId: ").append(toIndentedString(cInvoicepayscheduleId)).append("\n");
    sb.append("    installmentno: ").append(toIndentedString(installmentno)).append("\n");
    sb.append("    installmentcount: ").append(toIndentedString(installmentcount)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    issotrx: ").append(toIndentedString(issotrx)).append("\n");
    sb.append("    cDoctypeId: ").append(toIndentedString(cDoctypeId)).append("\n");
    sb.append("    doctypekey: ").append(toIndentedString(doctypekey)).append("\n");
    sb.append("    docbasetype: ").append(toIndentedString(docbasetype)).append("\n");
    sb.append("    doctypename: ").append(toIndentedString(doctypename)).append("\n");
    sb.append("    doctypeprintname: ").append(toIndentedString(doctypeprintname)).append("\n");
    sb.append("    documentno: ").append(toIndentedString(documentno)).append("\n");
    sb.append("    puntodeventa: ").append(toIndentedString(puntodeventa)).append("\n");
    sb.append("    numerocomprobante: ").append(toIndentedString(numerocomprobante)).append("\n");
    sb.append("    letra: ").append(toIndentedString(letra)).append("\n");
    sb.append("    dateinvoiced: ").append(toIndentedString(dateinvoiced)).append("\n");
    sb.append("    dateacct: ").append(toIndentedString(dateacct)).append("\n");
    sb.append("    duedate: ").append(toIndentedString(duedate)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    isoCode: ").append(toIndentedString(isoCode)).append("\n");
    sb.append("    signo: ").append(toIndentedString(signo)).append("\n");
    sb.append("    grandtotal: ").append(toIndentedString(grandtotal)).append("\n");
    sb.append("    dueamt: ").append(toIndentedString(dueamt)).append("\n");
    sb.append("    paidamt: ").append(toIndentedString(paidamt)).append("\n");
    sb.append("    openamt: ").append(toIndentedString(openamt)).append("\n");
    sb.append("    salesrepId: ").append(toIndentedString(salesrepId)).append("\n");
    sb.append("    cPaymenttermId: ").append(toIndentedString(cPaymenttermId)).append("\n");
    sb.append("    paymentrule: ").append(toIndentedString(paymentrule)).append("\n");
    sb.append("    cOrderId: ").append(toIndentedString(cOrderId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
