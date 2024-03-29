package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.AllocationNewInvoices;
import org.libertya.api.stub.model.AllocationNewPayments;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AllocationNew
 */
@Validated



public class AllocationNew   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_doctype_id")
  private Integer cDoctypeId = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("paymentrule")
  private String paymentrule = null;

  @JsonProperty("earlypayment")
  private Boolean earlypayment = null;

  @JsonProperty("invoices")
  @Valid
  private List<AllocationNewInvoices> invoices = null;

  @JsonProperty("payments")
  @Valid
  private List<AllocationNewPayments> payments = null;

  public AllocationNew adClientId(Integer adClientId) {
    this.adClientId = adClientId;
    return this;
  }

  /**
   * Get adClientId
   * @return adClientId
   **/
  @Schema(description = "")
  
    public Integer getAdClientId() {
    return adClientId;
  }

  public void setAdClientId(Integer adClientId) {
    this.adClientId = adClientId;
  }

  public AllocationNew adOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
    return this;
  }

  /**
   * Get adOrgId
   * @return adOrgId
   **/
  @Schema(description = "")
  
    public Integer getAdOrgId() {
    return adOrgId;
  }

  public void setAdOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
  }

  public AllocationNew cDoctypeId(Integer cDoctypeId) {
    this.cDoctypeId = cDoctypeId;
    return this;
  }

  /**
   * Get cDoctypeId
   * @return cDoctypeId
   **/
  @Schema(description = "")
  
    public Integer getCDoctypeId() {
    return cDoctypeId;
  }

  public void setCDoctypeId(Integer cDoctypeId) {
    this.cDoctypeId = cDoctypeId;
  }

  public AllocationNew cBpartnerId(Integer cBpartnerId) {
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

  public AllocationNew paymentrule(String paymentrule) {
    this.paymentrule = paymentrule;
    return this;
  }

  /**
   * Get paymentrule
   * @return paymentrule
   **/
  @Schema(description = "")
  
    public String getPaymentrule() {
    return paymentrule;
  }

  public void setPaymentrule(String paymentrule) {
    this.paymentrule = paymentrule;
  }

  public AllocationNew earlypayment(Boolean earlypayment) {
    this.earlypayment = earlypayment;
    return this;
  }

  /**
   * Get earlypayment
   * @return earlypayment
   **/
  @Schema(description = "")
  
    public Boolean isEarlypayment() {
    return earlypayment;
  }

  public void setEarlypayment(Boolean earlypayment) {
    this.earlypayment = earlypayment;
  }

  public AllocationNew invoices(List<AllocationNewInvoices> invoices) {
    this.invoices = invoices;
    return this;
  }

  public AllocationNew addInvoicesItem(AllocationNewInvoices invoicesItem) {
    if (this.invoices == null) {
      this.invoices = new ArrayList<>();
    }
    this.invoices.add(invoicesItem);
    return this;
  }

  /**
   * Get invoices
   * @return invoices
   **/
  @Schema(description = "")
      @Valid
    public List<AllocationNewInvoices> getInvoices() {
    return invoices;
  }

  public void setInvoices(List<AllocationNewInvoices> invoices) {
    this.invoices = invoices;
  }

  public AllocationNew payments(List<AllocationNewPayments> payments) {
    this.payments = payments;
    return this;
  }

  public AllocationNew addPaymentsItem(AllocationNewPayments paymentsItem) {
    if (this.payments == null) {
      this.payments = new ArrayList<>();
    }
    this.payments.add(paymentsItem);
    return this;
  }

  /**
   * Get payments
   * @return payments
   **/
  @Schema(description = "")
      @Valid
    public List<AllocationNewPayments> getPayments() {
    return payments;
  }

  public void setPayments(List<AllocationNewPayments> payments) {
    this.payments = payments;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AllocationNew allocationNew = (AllocationNew) o;
    return Objects.equals(this.adClientId, allocationNew.adClientId) &&
        Objects.equals(this.adOrgId, allocationNew.adOrgId) &&
        Objects.equals(this.cDoctypeId, allocationNew.cDoctypeId) &&
        Objects.equals(this.cBpartnerId, allocationNew.cBpartnerId) &&
        Objects.equals(this.paymentrule, allocationNew.paymentrule) &&
        Objects.equals(this.earlypayment, allocationNew.earlypayment) &&
        Objects.equals(this.invoices, allocationNew.invoices) &&
        Objects.equals(this.payments, allocationNew.payments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, cDoctypeId, cBpartnerId, paymentrule, earlypayment, invoices, payments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AllocationNew {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cDoctypeId: ").append(toIndentedString(cDoctypeId)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    paymentrule: ").append(toIndentedString(paymentrule)).append("\n");
    sb.append("    earlypayment: ").append(toIndentedString(earlypayment)).append("\n");
    sb.append("    invoices: ").append(toIndentedString(invoices)).append("\n");
    sb.append("    payments: ").append(toIndentedString(payments)).append("\n");
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
