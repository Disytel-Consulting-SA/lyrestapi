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
 * AllocationLine
 */
@Validated



public class AllocationLine   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("c_allocationhdr_id")
  private Integer cAllocationhdrId = null;

  @JsonProperty("c_allocationline_id")
  private Integer cAllocationlineId = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("c_cashline_id")
  private Integer cCashlineId = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("changeamt")
  private BigDecimal changeamt = null;

  @JsonProperty("c_invoice_credit_id")
  private Integer cInvoiceCreditId = null;

  @JsonProperty("c_invoice_id")
  private Integer cInvoiceId = null;

  @JsonProperty("c_order_id")
  private Integer cOrderId = null;

  @JsonProperty("c_payment_id")
  private Integer cPaymentId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("datetrx")
  private String datetrx = null;

  @JsonProperty("discountamt")
  private BigDecimal discountamt = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("ismanual")
  private Boolean ismanual = null;

  @JsonProperty("line_description")
  private String lineDescription = null;

  @JsonProperty("overunderamt")
  private BigDecimal overunderamt = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("writeoffamt")
  private BigDecimal writeoffamt = null;

  public AllocationLine adClientId(Integer adClientId) {
    this.adClientId = adClientId;
    return this;
  }

  /**
   * Get adClientId
   * @return adClientId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getAdClientId() {
    return adClientId;
  }

  public void setAdClientId(Integer adClientId) {
    this.adClientId = adClientId;
  }

  public AllocationLine adOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
    return this;
  }

  /**
   * Get adOrgId
   * @return adOrgId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getAdOrgId() {
    return adOrgId;
  }

  public void setAdOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
  }

  public AllocationLine amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public AllocationLine cAllocationhdrId(Integer cAllocationhdrId) {
    this.cAllocationhdrId = cAllocationhdrId;
    return this;
  }

  /**
   * Get cAllocationhdrId
   * @return cAllocationhdrId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCAllocationhdrId() {
    return cAllocationhdrId;
  }

  public void setCAllocationhdrId(Integer cAllocationhdrId) {
    this.cAllocationhdrId = cAllocationhdrId;
  }

  public AllocationLine cAllocationlineId(Integer cAllocationlineId) {
    this.cAllocationlineId = cAllocationlineId;
    return this;
  }

  /**
   * Get cAllocationlineId
   * @return cAllocationlineId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCAllocationlineId() {
    return cAllocationlineId;
  }

  public void setCAllocationlineId(Integer cAllocationlineId) {
    this.cAllocationlineId = cAllocationlineId;
  }

  public AllocationLine cBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
    return this;
  }

  /**
   * Get cBpartnerId
   * @return cBpartnerId
   **/
  @Schema(description = "")
  
    public Integer getCBpartnerId() {
    return cBpartnerId;
  }

  public void setCBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
  }

  public AllocationLine cCashlineId(Integer cCashlineId) {
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

  public AllocationLine cCurrencyId(Integer cCurrencyId) {
    this.cCurrencyId = cCurrencyId;
    return this;
  }

  /**
   * Get cCurrencyId
   * @return cCurrencyId
   **/
  @Schema(description = "")
  
    public Integer getCCurrencyId() {
    return cCurrencyId;
  }

  public void setCCurrencyId(Integer cCurrencyId) {
    this.cCurrencyId = cCurrencyId;
  }

  public AllocationLine changeamt(BigDecimal changeamt) {
    this.changeamt = changeamt;
    return this;
  }

  /**
   * Get changeamt
   * @return changeamt
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getChangeamt() {
    return changeamt;
  }

  public void setChangeamt(BigDecimal changeamt) {
    this.changeamt = changeamt;
  }

  public AllocationLine cInvoiceCreditId(Integer cInvoiceCreditId) {
    this.cInvoiceCreditId = cInvoiceCreditId;
    return this;
  }

  /**
   * Get cInvoiceCreditId
   * @return cInvoiceCreditId
   **/
  @Schema(description = "")
  
    public Integer getCInvoiceCreditId() {
    return cInvoiceCreditId;
  }

  public void setCInvoiceCreditId(Integer cInvoiceCreditId) {
    this.cInvoiceCreditId = cInvoiceCreditId;
  }

  public AllocationLine cInvoiceId(Integer cInvoiceId) {
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

  public AllocationLine cOrderId(Integer cOrderId) {
    this.cOrderId = cOrderId;
    return this;
  }

  /**
   * Get cOrderId
   * @return cOrderId
   **/
  @Schema(description = "")
  
    public Integer getCOrderId() {
    return cOrderId;
  }

  public void setCOrderId(Integer cOrderId) {
    this.cOrderId = cOrderId;
  }

  public AllocationLine cPaymentId(Integer cPaymentId) {
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

  public AllocationLine created(String created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public AllocationLine createdby(Integer createdby) {
    this.createdby = createdby;
    return this;
  }

  /**
   * Get createdby
   * @return createdby
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCreatedby() {
    return createdby;
  }

  public void setCreatedby(Integer createdby) {
    this.createdby = createdby;
  }

  public AllocationLine datetrx(String datetrx) {
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

  public AllocationLine discountamt(BigDecimal discountamt) {
    this.discountamt = discountamt;
    return this;
  }

  /**
   * Get discountamt
   * @return discountamt
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getDiscountamt() {
    return discountamt;
  }

  public void setDiscountamt(BigDecimal discountamt) {
    this.discountamt = discountamt;
  }

  public AllocationLine isactive(Boolean isactive) {
    this.isactive = isactive;
    return this;
  }

  /**
   * Get isactive
   * @return isactive
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsactive() {
    return isactive;
  }

  public void setIsactive(Boolean isactive) {
    this.isactive = isactive;
  }

  public AllocationLine ismanual(Boolean ismanual) {
    this.ismanual = ismanual;
    return this;
  }

  /**
   * Get ismanual
   * @return ismanual
   **/
  @Schema(description = "")
  
    public Boolean isIsmanual() {
    return ismanual;
  }

  public void setIsmanual(Boolean ismanual) {
    this.ismanual = ismanual;
  }

  public AllocationLine lineDescription(String lineDescription) {
    this.lineDescription = lineDescription;
    return this;
  }

  /**
   * Get lineDescription
   * @return lineDescription
   **/
  @Schema(description = "")
  
    public String getLineDescription() {
    return lineDescription;
  }

  public void setLineDescription(String lineDescription) {
    this.lineDescription = lineDescription;
  }

  public AllocationLine overunderamt(BigDecimal overunderamt) {
    this.overunderamt = overunderamt;
    return this;
  }

  /**
   * Get overunderamt
   * @return overunderamt
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getOverunderamt() {
    return overunderamt;
  }

  public void setOverunderamt(BigDecimal overunderamt) {
    this.overunderamt = overunderamt;
  }

  public AllocationLine updated(String updated) {
    this.updated = updated;
    return this;
  }

  /**
   * Get updated
   * @return updated
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  public AllocationLine updatedby(Integer updatedby) {
    this.updatedby = updatedby;
    return this;
  }

  /**
   * Get updatedby
   * @return updatedby
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getUpdatedby() {
    return updatedby;
  }

  public void setUpdatedby(Integer updatedby) {
    this.updatedby = updatedby;
  }

  public AllocationLine writeoffamt(BigDecimal writeoffamt) {
    this.writeoffamt = writeoffamt;
    return this;
  }

  /**
   * Get writeoffamt
   * @return writeoffamt
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getWriteoffamt() {
    return writeoffamt;
  }

  public void setWriteoffamt(BigDecimal writeoffamt) {
    this.writeoffamt = writeoffamt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AllocationLine allocationLine = (AllocationLine) o;
    return Objects.equals(this.adClientId, allocationLine.adClientId) &&
        Objects.equals(this.adOrgId, allocationLine.adOrgId) &&
        Objects.equals(this.amount, allocationLine.amount) &&
        Objects.equals(this.cAllocationhdrId, allocationLine.cAllocationhdrId) &&
        Objects.equals(this.cAllocationlineId, allocationLine.cAllocationlineId) &&
        Objects.equals(this.cBpartnerId, allocationLine.cBpartnerId) &&
        Objects.equals(this.cCashlineId, allocationLine.cCashlineId) &&
        Objects.equals(this.cCurrencyId, allocationLine.cCurrencyId) &&
        Objects.equals(this.changeamt, allocationLine.changeamt) &&
        Objects.equals(this.cInvoiceCreditId, allocationLine.cInvoiceCreditId) &&
        Objects.equals(this.cInvoiceId, allocationLine.cInvoiceId) &&
        Objects.equals(this.cOrderId, allocationLine.cOrderId) &&
        Objects.equals(this.cPaymentId, allocationLine.cPaymentId) &&
        Objects.equals(this.created, allocationLine.created) &&
        Objects.equals(this.createdby, allocationLine.createdby) &&
        Objects.equals(this.datetrx, allocationLine.datetrx) &&
        Objects.equals(this.discountamt, allocationLine.discountamt) &&
        Objects.equals(this.isactive, allocationLine.isactive) &&
        Objects.equals(this.ismanual, allocationLine.ismanual) &&
        Objects.equals(this.lineDescription, allocationLine.lineDescription) &&
        Objects.equals(this.overunderamt, allocationLine.overunderamt) &&
        Objects.equals(this.updated, allocationLine.updated) &&
        Objects.equals(this.updatedby, allocationLine.updatedby) &&
        Objects.equals(this.writeoffamt, allocationLine.writeoffamt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, amount, cAllocationhdrId, cAllocationlineId, cBpartnerId, cCashlineId, cCurrencyId, changeamt, cInvoiceCreditId, cInvoiceId, cOrderId, cPaymentId, created, createdby, datetrx, discountamt, isactive, ismanual, lineDescription, overunderamt, updated, updatedby, writeoffamt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AllocationLine {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    cAllocationhdrId: ").append(toIndentedString(cAllocationhdrId)).append("\n");
    sb.append("    cAllocationlineId: ").append(toIndentedString(cAllocationlineId)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    cCashlineId: ").append(toIndentedString(cCashlineId)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    changeamt: ").append(toIndentedString(changeamt)).append("\n");
    sb.append("    cInvoiceCreditId: ").append(toIndentedString(cInvoiceCreditId)).append("\n");
    sb.append("    cInvoiceId: ").append(toIndentedString(cInvoiceId)).append("\n");
    sb.append("    cOrderId: ").append(toIndentedString(cOrderId)).append("\n");
    sb.append("    cPaymentId: ").append(toIndentedString(cPaymentId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    datetrx: ").append(toIndentedString(datetrx)).append("\n");
    sb.append("    discountamt: ").append(toIndentedString(discountamt)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    ismanual: ").append(toIndentedString(ismanual)).append("\n");
    sb.append("    lineDescription: ").append(toIndentedString(lineDescription)).append("\n");
    sb.append("    overunderamt: ").append(toIndentedString(overunderamt)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    writeoffamt: ").append(toIndentedString(writeoffamt)).append("\n");
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
