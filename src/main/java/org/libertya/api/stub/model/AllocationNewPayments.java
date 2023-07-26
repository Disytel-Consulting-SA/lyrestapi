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
 * AllocationNewPayments
 */
@Validated



public class AllocationNewPayments   {
  @JsonProperty("c_pospaymentmedium_id")
  private Integer cPospaymentmediumId = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("c_invoice_id")
  private Integer cInvoiceId = null;

  @JsonProperty("c_bankaccount_id")
  private Integer cBankaccountId = null;

  @JsonProperty("c_bank_id")
  private Integer cBankId = null;

  @JsonProperty("a_bank")
  private String aBank = null;

  @JsonProperty("transferno")
  private String transferno = null;

  @JsonProperty("transferdate")
  private String transferdate = null;

  @JsonProperty("m_entidadfinancieraplan_id")
  private Integer mEntidadfinancieraplanId = null;

  @JsonProperty("creditcardnumber")
  private String creditcardnumber = null;

  @JsonProperty("couponnumber")
  private String couponnumber = null;

  @JsonProperty("checkno")
  private String checkno = null;

  @JsonProperty("datetrx")
  private String datetrx = null;

  @JsonProperty("duedate")
  private String duedate = null;

  @JsonProperty("c_cash_id")
  private Integer cCashId = null;

  @JsonProperty("c_cashline_id")
  private Integer cCashlineId = null;

  @JsonProperty("c_payment_id")
  private Integer cPaymentId = null;

  @JsonProperty("c_retencionschema_id")
  private Integer cRetencionschemaId = null;

  @JsonProperty("retenc_documentno")
  private String retencDocumentno = null;

  @JsonProperty("retenc_date")
  private String retencDate = null;

  public AllocationNewPayments cPospaymentmediumId(Integer cPospaymentmediumId) {
    this.cPospaymentmediumId = cPospaymentmediumId;
    return this;
  }

  /**
   * Get cPospaymentmediumId
   * @return cPospaymentmediumId
   **/
  @Schema(description = "")
  
    public Integer getCPospaymentmediumId() {
    return cPospaymentmediumId;
  }

  public void setCPospaymentmediumId(Integer cPospaymentmediumId) {
    this.cPospaymentmediumId = cPospaymentmediumId;
  }

  public AllocationNewPayments amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public AllocationNewPayments cInvoiceId(Integer cInvoiceId) {
    this.cInvoiceId = cInvoiceId;
    return this;
  }

  /**
   * Get cInvoiceId
   * @return cInvoiceId
   **/
  @Schema(description = "")
  
    public Integer getCInvoiceId() {
    return cInvoiceId;
  }

  public void setCInvoiceId(Integer cInvoiceId) {
    this.cInvoiceId = cInvoiceId;
  }

  public AllocationNewPayments cBankaccountId(Integer cBankaccountId) {
    this.cBankaccountId = cBankaccountId;
    return this;
  }

  /**
   * Get cBankaccountId
   * @return cBankaccountId
   **/
  @Schema(description = "")
  
    public Integer getCBankaccountId() {
    return cBankaccountId;
  }

  public void setCBankaccountId(Integer cBankaccountId) {
    this.cBankaccountId = cBankaccountId;
  }

  public AllocationNewPayments cBankId(Integer cBankId) {
    this.cBankId = cBankId;
    return this;
  }

  /**
   * Get cBankId
   * @return cBankId
   **/
  @Schema(description = "")
  
    public Integer getCBankId() {
    return cBankId;
  }

  public void setCBankId(Integer cBankId) {
    this.cBankId = cBankId;
  }

  public AllocationNewPayments aBank(String aBank) {
    this.aBank = aBank;
    return this;
  }

  /**
   * Get aBank
   * @return aBank
   **/
  @Schema(description = "")
  
    public String getABank() {
    return aBank;
  }

  public void setABank(String aBank) {
    this.aBank = aBank;
  }

  public AllocationNewPayments transferno(String transferno) {
    this.transferno = transferno;
    return this;
  }

  /**
   * Get transferno
   * @return transferno
   **/
  @Schema(description = "")
  
    public String getTransferno() {
    return transferno;
  }

  public void setTransferno(String transferno) {
    this.transferno = transferno;
  }

  public AllocationNewPayments transferdate(String transferdate) {
    this.transferdate = transferdate;
    return this;
  }

  /**
   * Get transferdate
   * @return transferdate
   **/
  @Schema(description = "")
  
    public String getTransferdate() {
    return transferdate;
  }

  public void setTransferdate(String transferdate) {
    this.transferdate = transferdate;
  }

  public AllocationNewPayments mEntidadfinancieraplanId(Integer mEntidadfinancieraplanId) {
    this.mEntidadfinancieraplanId = mEntidadfinancieraplanId;
    return this;
  }

  /**
   * Get mEntidadfinancieraplanId
   * @return mEntidadfinancieraplanId
   **/
  @Schema(description = "")
  
    public Integer getMEntidadfinancieraplanId() {
    return mEntidadfinancieraplanId;
  }

  public void setMEntidadfinancieraplanId(Integer mEntidadfinancieraplanId) {
    this.mEntidadfinancieraplanId = mEntidadfinancieraplanId;
  }

  public AllocationNewPayments creditcardnumber(String creditcardnumber) {
    this.creditcardnumber = creditcardnumber;
    return this;
  }

  /**
   * Get creditcardnumber
   * @return creditcardnumber
   **/
  @Schema(description = "")
  
    public String getCreditcardnumber() {
    return creditcardnumber;
  }

  public void setCreditcardnumber(String creditcardnumber) {
    this.creditcardnumber = creditcardnumber;
  }

  public AllocationNewPayments couponnumber(String couponnumber) {
    this.couponnumber = couponnumber;
    return this;
  }

  /**
   * Get couponnumber
   * @return couponnumber
   **/
  @Schema(description = "")
  
    public String getCouponnumber() {
    return couponnumber;
  }

  public void setCouponnumber(String couponnumber) {
    this.couponnumber = couponnumber;
  }

  public AllocationNewPayments checkno(String checkno) {
    this.checkno = checkno;
    return this;
  }

  /**
   * Get checkno
   * @return checkno
   **/
  @Schema(description = "")
  
    public String getCheckno() {
    return checkno;
  }

  public void setCheckno(String checkno) {
    this.checkno = checkno;
  }

  public AllocationNewPayments datetrx(String datetrx) {
    this.datetrx = datetrx;
    return this;
  }

  /**
   * Get datetrx
   * @return datetrx
   **/
  @Schema(description = "")
  
    public String getDatetrx() {
    return datetrx;
  }

  public void setDatetrx(String datetrx) {
    this.datetrx = datetrx;
  }

  public AllocationNewPayments duedate(String duedate) {
    this.duedate = duedate;
    return this;
  }

  /**
   * Get duedate
   * @return duedate
   **/
  @Schema(description = "")
  
    public String getDuedate() {
    return duedate;
  }

  public void setDuedate(String duedate) {
    this.duedate = duedate;
  }

  public AllocationNewPayments cCashId(Integer cCashId) {
    this.cCashId = cCashId;
    return this;
  }

  /**
   * Get cCashId
   * @return cCashId
   **/
  @Schema(description = "")
  
    public Integer getCCashId() {
    return cCashId;
  }

  public void setCCashId(Integer cCashId) {
    this.cCashId = cCashId;
  }

  public AllocationNewPayments cCashlineId(Integer cCashlineId) {
    this.cCashlineId = cCashlineId;
    return this;
  }

  /**
   * Get cCashlineId
   * @return cCashlineId
   **/
  @Schema(description = "")
  
    public Integer getCCashlineId() {
    return cCashlineId;
  }

  public void setCCashlineId(Integer cCashlineId) {
    this.cCashlineId = cCashlineId;
  }

  public AllocationNewPayments cPaymentId(Integer cPaymentId) {
    this.cPaymentId = cPaymentId;
    return this;
  }

  /**
   * Get cPaymentId
   * @return cPaymentId
   **/
  @Schema(description = "")
  
    public Integer getCPaymentId() {
    return cPaymentId;
  }

  public void setCPaymentId(Integer cPaymentId) {
    this.cPaymentId = cPaymentId;
  }

  public AllocationNewPayments cRetencionschemaId(Integer cRetencionschemaId) {
    this.cRetencionschemaId = cRetencionschemaId;
    return this;
  }

  /**
   * Get cRetencionschemaId
   * @return cRetencionschemaId
   **/
  @Schema(description = "")
  
    public Integer getCRetencionschemaId() {
    return cRetencionschemaId;
  }

  public void setCRetencionschemaId(Integer cRetencionschemaId) {
    this.cRetencionschemaId = cRetencionschemaId;
  }

  public AllocationNewPayments retencDocumentno(String retencDocumentno) {
    this.retencDocumentno = retencDocumentno;
    return this;
  }

  /**
   * Get retencDocumentno
   * @return retencDocumentno
   **/
  @Schema(description = "")
  
    public String getRetencDocumentno() {
    return retencDocumentno;
  }

  public void setRetencDocumentno(String retencDocumentno) {
    this.retencDocumentno = retencDocumentno;
  }

  public AllocationNewPayments retencDate(String retencDate) {
    this.retencDate = retencDate;
    return this;
  }

  /**
   * Get retencDate
   * @return retencDate
   **/
  @Schema(description = "")
  
    public String getRetencDate() {
    return retencDate;
  }

  public void setRetencDate(String retencDate) {
    this.retencDate = retencDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AllocationNewPayments allocationNewPayments = (AllocationNewPayments) o;
    return Objects.equals(this.cPospaymentmediumId, allocationNewPayments.cPospaymentmediumId) &&
        Objects.equals(this.amount, allocationNewPayments.amount) &&
        Objects.equals(this.cInvoiceId, allocationNewPayments.cInvoiceId) &&
        Objects.equals(this.cBankaccountId, allocationNewPayments.cBankaccountId) &&
        Objects.equals(this.cBankId, allocationNewPayments.cBankId) &&
        Objects.equals(this.aBank, allocationNewPayments.aBank) &&
        Objects.equals(this.transferno, allocationNewPayments.transferno) &&
        Objects.equals(this.transferdate, allocationNewPayments.transferdate) &&
        Objects.equals(this.mEntidadfinancieraplanId, allocationNewPayments.mEntidadfinancieraplanId) &&
        Objects.equals(this.creditcardnumber, allocationNewPayments.creditcardnumber) &&
        Objects.equals(this.couponnumber, allocationNewPayments.couponnumber) &&
        Objects.equals(this.checkno, allocationNewPayments.checkno) &&
        Objects.equals(this.datetrx, allocationNewPayments.datetrx) &&
        Objects.equals(this.duedate, allocationNewPayments.duedate) &&
        Objects.equals(this.cCashId, allocationNewPayments.cCashId) &&
        Objects.equals(this.cCashlineId, allocationNewPayments.cCashlineId) &&
        Objects.equals(this.cPaymentId, allocationNewPayments.cPaymentId) &&
        Objects.equals(this.cRetencionschemaId, allocationNewPayments.cRetencionschemaId) &&
        Objects.equals(this.retencDocumentno, allocationNewPayments.retencDocumentno) &&
        Objects.equals(this.retencDate, allocationNewPayments.retencDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cPospaymentmediumId, amount, cInvoiceId, cBankaccountId, cBankId, aBank, transferno, transferdate, mEntidadfinancieraplanId, creditcardnumber, couponnumber, checkno, datetrx, duedate, cCashId, cCashlineId, cPaymentId, cRetencionschemaId, retencDocumentno, retencDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AllocationNewPayments {\n");
    
    sb.append("    cPospaymentmediumId: ").append(toIndentedString(cPospaymentmediumId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    cInvoiceId: ").append(toIndentedString(cInvoiceId)).append("\n");
    sb.append("    cBankaccountId: ").append(toIndentedString(cBankaccountId)).append("\n");
    sb.append("    cBankId: ").append(toIndentedString(cBankId)).append("\n");
    sb.append("    aBank: ").append(toIndentedString(aBank)).append("\n");
    sb.append("    transferno: ").append(toIndentedString(transferno)).append("\n");
    sb.append("    transferdate: ").append(toIndentedString(transferdate)).append("\n");
    sb.append("    mEntidadfinancieraplanId: ").append(toIndentedString(mEntidadfinancieraplanId)).append("\n");
    sb.append("    creditcardnumber: ").append(toIndentedString(creditcardnumber)).append("\n");
    sb.append("    couponnumber: ").append(toIndentedString(couponnumber)).append("\n");
    sb.append("    checkno: ").append(toIndentedString(checkno)).append("\n");
    sb.append("    datetrx: ").append(toIndentedString(datetrx)).append("\n");
    sb.append("    duedate: ").append(toIndentedString(duedate)).append("\n");
    sb.append("    cCashId: ").append(toIndentedString(cCashId)).append("\n");
    sb.append("    cCashlineId: ").append(toIndentedString(cCashlineId)).append("\n");
    sb.append("    cPaymentId: ").append(toIndentedString(cPaymentId)).append("\n");
    sb.append("    cRetencionschemaId: ").append(toIndentedString(cRetencionschemaId)).append("\n");
    sb.append("    retencDocumentno: ").append(toIndentedString(retencDocumentno)).append("\n");
    sb.append("    retencDate: ").append(toIndentedString(retencDate)).append("\n");
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
