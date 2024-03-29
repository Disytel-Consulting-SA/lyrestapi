package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.Propertiesmap;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InvoiceTax
 */
@Validated



public class InvoiceTax   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("arcibanormcode")
  private String arcibanormcode = null;

  @JsonProperty("c_invoice_id")
  private Integer cInvoiceId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_tax_id")
  private Integer cTaxId = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isperceptionsincluded")
  private Boolean isperceptionsincluded = null;

  @JsonProperty("istaxincluded")
  private Boolean istaxincluded = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("rate")
  private BigDecimal rate = null;

  @JsonProperty("taxamt")
  private BigDecimal taxamt = null;

  @JsonProperty("taxbaseamt")
  private BigDecimal taxbaseamt = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public InvoiceTax adClientId(Integer adClientId) {
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

  public InvoiceTax adOrgId(Integer adOrgId) {
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

  public InvoiceTax arcibanormcode(String arcibanormcode) {
    this.arcibanormcode = arcibanormcode;
    return this;
  }

  /**
   * Get arcibanormcode
   * @return arcibanormcode
   **/
  @Schema(description = "")
  
    public String getArcibanormcode() {
    return arcibanormcode;
  }

  public void setArcibanormcode(String arcibanormcode) {
    this.arcibanormcode = arcibanormcode;
  }

  public InvoiceTax cInvoiceId(Integer cInvoiceId) {
    this.cInvoiceId = cInvoiceId;
    return this;
  }

  /**
   * Get cInvoiceId
   * @return cInvoiceId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCInvoiceId() {
    return cInvoiceId;
  }

  public void setCInvoiceId(Integer cInvoiceId) {
    this.cInvoiceId = cInvoiceId;
  }

  public InvoiceTax created(String created) {
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

  public InvoiceTax createdby(Integer createdby) {
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

  public InvoiceTax cTaxId(Integer cTaxId) {
    this.cTaxId = cTaxId;
    return this;
  }

  /**
   * Get cTaxId
   * @return cTaxId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCTaxId() {
    return cTaxId;
  }

  public void setCTaxId(Integer cTaxId) {
    this.cTaxId = cTaxId;
  }

  public InvoiceTax isactive(Boolean isactive) {
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

  public InvoiceTax isperceptionsincluded(Boolean isperceptionsincluded) {
    this.isperceptionsincluded = isperceptionsincluded;
    return this;
  }

  /**
   * Get isperceptionsincluded
   * @return isperceptionsincluded
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsperceptionsincluded() {
    return isperceptionsincluded;
  }

  public void setIsperceptionsincluded(Boolean isperceptionsincluded) {
    this.isperceptionsincluded = isperceptionsincluded;
  }

  public InvoiceTax istaxincluded(Boolean istaxincluded) {
    this.istaxincluded = istaxincluded;
    return this;
  }

  /**
   * Get istaxincluded
   * @return istaxincluded
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIstaxincluded() {
    return istaxincluded;
  }

  public void setIstaxincluded(Boolean istaxincluded) {
    this.istaxincluded = istaxincluded;
  }

  public InvoiceTax processed(Boolean processed) {
    this.processed = processed;
    return this;
  }

  /**
   * Get processed
   * @return processed
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isProcessed() {
    return processed;
  }

  public void setProcessed(Boolean processed) {
    this.processed = processed;
  }

  public InvoiceTax rate(BigDecimal rate) {
    this.rate = rate;
    return this;
  }

  /**
   * Get rate
   * @return rate
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getRate() {
    return rate;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  public InvoiceTax taxamt(BigDecimal taxamt) {
    this.taxamt = taxamt;
    return this;
  }

  /**
   * Get taxamt
   * @return taxamt
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getTaxamt() {
    return taxamt;
  }

  public void setTaxamt(BigDecimal taxamt) {
    this.taxamt = taxamt;
  }

  public InvoiceTax taxbaseamt(BigDecimal taxbaseamt) {
    this.taxbaseamt = taxbaseamt;
    return this;
  }

  /**
   * Get taxbaseamt
   * @return taxbaseamt
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getTaxbaseamt() {
    return taxbaseamt;
  }

  public void setTaxbaseamt(BigDecimal taxbaseamt) {
    this.taxbaseamt = taxbaseamt;
  }

  public InvoiceTax updated(String updated) {
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

  public InvoiceTax updatedby(Integer updatedby) {
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

  public InvoiceTax additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public InvoiceTax addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
    if (this.additionalvalues == null) {
      this.additionalvalues = new ArrayList<>();
    }
    this.additionalvalues.add(additionalvaluesItem);
    return this;
  }

  /**
   * Get additionalvalues
   * @return additionalvalues
   **/
  @Schema(description = "")
      @Valid
    public List<Propertiesmap> getAdditionalvalues() {
    return additionalvalues;
  }

  public void setAdditionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
  }

  public InvoiceTax referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public InvoiceTax addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
    if (this.referencedvalues == null) {
      this.referencedvalues = new ArrayList<>();
    }
    this.referencedvalues.add(referencedvaluesItem);
    return this;
  }

  /**
   * Get referencedvalues
   * @return referencedvalues
   **/
  @Schema(description = "")
      @Valid
    public List<Propertiesmap> getReferencedvalues() {
    return referencedvalues;
  }

  public void setReferencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvoiceTax invoiceTax = (InvoiceTax) o;
    return Objects.equals(this.adClientId, invoiceTax.adClientId) &&
        Objects.equals(this.adOrgId, invoiceTax.adOrgId) &&
        Objects.equals(this.arcibanormcode, invoiceTax.arcibanormcode) &&
        Objects.equals(this.cInvoiceId, invoiceTax.cInvoiceId) &&
        Objects.equals(this.created, invoiceTax.created) &&
        Objects.equals(this.createdby, invoiceTax.createdby) &&
        Objects.equals(this.cTaxId, invoiceTax.cTaxId) &&
        Objects.equals(this.isactive, invoiceTax.isactive) &&
        Objects.equals(this.isperceptionsincluded, invoiceTax.isperceptionsincluded) &&
        Objects.equals(this.istaxincluded, invoiceTax.istaxincluded) &&
        Objects.equals(this.processed, invoiceTax.processed) &&
        Objects.equals(this.rate, invoiceTax.rate) &&
        Objects.equals(this.taxamt, invoiceTax.taxamt) &&
        Objects.equals(this.taxbaseamt, invoiceTax.taxbaseamt) &&
        Objects.equals(this.updated, invoiceTax.updated) &&
        Objects.equals(this.updatedby, invoiceTax.updatedby) &&
        Objects.equals(this.additionalvalues, invoiceTax.additionalvalues) &&
        Objects.equals(this.referencedvalues, invoiceTax.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, arcibanormcode, cInvoiceId, created, createdby, cTaxId, isactive, isperceptionsincluded, istaxincluded, processed, rate, taxamt, taxbaseamt, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvoiceTax {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    arcibanormcode: ").append(toIndentedString(arcibanormcode)).append("\n");
    sb.append("    cInvoiceId: ").append(toIndentedString(cInvoiceId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cTaxId: ").append(toIndentedString(cTaxId)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isperceptionsincluded: ").append(toIndentedString(isperceptionsincluded)).append("\n");
    sb.append("    istaxincluded: ").append(toIndentedString(istaxincluded)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    taxamt: ").append(toIndentedString(taxamt)).append("\n");
    sb.append("    taxbaseamt: ").append(toIndentedString(taxbaseamt)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    additionalvalues: ").append(toIndentedString(additionalvalues)).append("\n");
    sb.append("    referencedvalues: ").append(toIndentedString(referencedvalues)).append("\n");
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
