package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InOutLine
 */
@Validated
public class InOutLine   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_charge_id")
  private Integer cChargeId = null;

  @JsonProperty("c_country_id")
  private Integer cCountryId = null;

  @JsonProperty("c_invoiceline_id")
  private Integer cInvoicelineId = null;

  @JsonProperty("confirmedqty")
  private BigDecimal confirmedqty = null;

  @JsonProperty("c_orderline_id")
  private Integer cOrderlineId = null;

  @JsonProperty("costprice")
  private BigDecimal costprice = null;

  @JsonProperty("c_project_id")
  private Integer cProjectId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_uom_id")
  private Integer cUomId = null;

  @JsonProperty("declarationno")
  private String declarationno = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isdescription")
  private Boolean isdescription = null;

  @JsonProperty("isinvoiced")
  private Boolean isinvoiced = null;

  @JsonProperty("isselected")
  private Boolean isselected = null;

  @JsonProperty("line")
  private Integer line = null;

  @JsonProperty("m_attributesetinstance_id")
  private Integer mAttributesetinstanceId = null;

  @JsonProperty("m_import_clearance_id")
  private Integer mImportClearanceId = null;

  @JsonProperty("m_inout_id")
  private Integer mInoutId = null;

  @JsonProperty("m_inoutline_id")
  private Integer mInoutlineId = null;

  @JsonProperty("m_locator_id")
  private Integer mLocatorId = null;

  @JsonProperty("movementqty")
  private BigDecimal movementqty = null;

  @JsonProperty("m_product_id")
  private Integer mProductId = null;

  @JsonProperty("pickedqty")
  private BigDecimal pickedqty = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("qtyentered")
  private BigDecimal qtyentered = null;

  @JsonProperty("ref_inoutline_id")
  private Integer refInoutlineId = null;

  @JsonProperty("scrappedqty")
  private BigDecimal scrappedqty = null;

  @JsonProperty("targetqty")
  private BigDecimal targetqty = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  public InOutLine adClientId(Integer adClientId) {
    this.adClientId = adClientId;
    return this;
  }

  /**
   * Get adClientId
   * @return adClientId
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getAdClientId() {
    return adClientId;
  }

  public void setAdClientId(Integer adClientId) {
    this.adClientId = adClientId;
  }

  public InOutLine adOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
    return this;
  }

  /**
   * Get adOrgId
   * @return adOrgId
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getAdOrgId() {
    return adOrgId;
  }

  public void setAdOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
  }

  public InOutLine cChargeId(Integer cChargeId) {
    this.cChargeId = cChargeId;
    return this;
  }

  /**
   * Get cChargeId
   * @return cChargeId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getCChargeId() {
    return cChargeId;
  }

  public void setCChargeId(Integer cChargeId) {
    this.cChargeId = cChargeId;
  }

  public InOutLine cCountryId(Integer cCountryId) {
    this.cCountryId = cCountryId;
    return this;
  }

  /**
   * Get cCountryId
   * @return cCountryId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getCCountryId() {
    return cCountryId;
  }

  public void setCCountryId(Integer cCountryId) {
    this.cCountryId = cCountryId;
  }

  public InOutLine cInvoicelineId(Integer cInvoicelineId) {
    this.cInvoicelineId = cInvoicelineId;
    return this;
  }

  /**
   * Get cInvoicelineId
   * @return cInvoicelineId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getCInvoicelineId() {
    return cInvoicelineId;
  }

  public void setCInvoicelineId(Integer cInvoicelineId) {
    this.cInvoicelineId = cInvoicelineId;
  }

  public InOutLine confirmedqty(BigDecimal confirmedqty) {
    this.confirmedqty = confirmedqty;
    return this;
  }

  /**
   * Get confirmedqty
   * @return confirmedqty
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getConfirmedqty() {
    return confirmedqty;
  }

  public void setConfirmedqty(BigDecimal confirmedqty) {
    this.confirmedqty = confirmedqty;
  }

  public InOutLine cOrderlineId(Integer cOrderlineId) {
    this.cOrderlineId = cOrderlineId;
    return this;
  }

  /**
   * Get cOrderlineId
   * @return cOrderlineId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getCOrderlineId() {
    return cOrderlineId;
  }

  public void setCOrderlineId(Integer cOrderlineId) {
    this.cOrderlineId = cOrderlineId;
  }

  public InOutLine costprice(BigDecimal costprice) {
    this.costprice = costprice;
    return this;
  }

  /**
   * Get costprice
   * @return costprice
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public BigDecimal getCostprice() {
    return costprice;
  }

  public void setCostprice(BigDecimal costprice) {
    this.costprice = costprice;
  }

  public InOutLine cProjectId(Integer cProjectId) {
    this.cProjectId = cProjectId;
    return this;
  }

  /**
   * Get cProjectId
   * @return cProjectId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getCProjectId() {
    return cProjectId;
  }

  public void setCProjectId(Integer cProjectId) {
    this.cProjectId = cProjectId;
  }

  public InOutLine created(String created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public InOutLine createdby(Integer createdby) {
    this.createdby = createdby;
    return this;
  }

  /**
   * Get createdby
   * @return createdby
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getCreatedby() {
    return createdby;
  }

  public void setCreatedby(Integer createdby) {
    this.createdby = createdby;
  }

  public InOutLine cUomId(Integer cUomId) {
    this.cUomId = cUomId;
    return this;
  }

  /**
   * Get cUomId
   * @return cUomId
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getCUomId() {
    return cUomId;
  }

  public void setCUomId(Integer cUomId) {
    this.cUomId = cUomId;
  }

  public InOutLine declarationno(String declarationno) {
    this.declarationno = declarationno;
    return this;
  }

  /**
   * Get declarationno
   * @return declarationno
  **/
  @ApiModelProperty(value = "")
  
    public String getDeclarationno() {
    return declarationno;
  }

  public void setDeclarationno(String declarationno) {
    this.declarationno = declarationno;
  }

  public InOutLine description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public InOutLine isactive(Boolean isactive) {
    this.isactive = isactive;
    return this;
  }

  /**
   * Get isactive
   * @return isactive
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Boolean isIsactive() {
    return isactive;
  }

  public void setIsactive(Boolean isactive) {
    this.isactive = isactive;
  }

  public InOutLine isdescription(Boolean isdescription) {
    this.isdescription = isdescription;
    return this;
  }

  /**
   * Get isdescription
   * @return isdescription
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Boolean isIsdescription() {
    return isdescription;
  }

  public void setIsdescription(Boolean isdescription) {
    this.isdescription = isdescription;
  }

  public InOutLine isinvoiced(Boolean isinvoiced) {
    this.isinvoiced = isinvoiced;
    return this;
  }

  /**
   * Get isinvoiced
   * @return isinvoiced
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Boolean isIsinvoiced() {
    return isinvoiced;
  }

  public void setIsinvoiced(Boolean isinvoiced) {
    this.isinvoiced = isinvoiced;
  }

  public InOutLine isselected(Boolean isselected) {
    this.isselected = isselected;
    return this;
  }

  /**
   * Get isselected
   * @return isselected
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Boolean isIsselected() {
    return isselected;
  }

  public void setIsselected(Boolean isselected) {
    this.isselected = isselected;
  }

  public InOutLine line(Integer line) {
    this.line = line;
    return this;
  }

  /**
   * Get line
   * @return line
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getLine() {
    return line;
  }

  public void setLine(Integer line) {
    this.line = line;
  }

  public InOutLine mAttributesetinstanceId(Integer mAttributesetinstanceId) {
    this.mAttributesetinstanceId = mAttributesetinstanceId;
    return this;
  }

  /**
   * Get mAttributesetinstanceId
   * @return mAttributesetinstanceId
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getMAttributesetinstanceId() {
    return mAttributesetinstanceId;
  }

  public void setMAttributesetinstanceId(Integer mAttributesetinstanceId) {
    this.mAttributesetinstanceId = mAttributesetinstanceId;
  }

  public InOutLine mImportClearanceId(Integer mImportClearanceId) {
    this.mImportClearanceId = mImportClearanceId;
    return this;
  }

  /**
   * Get mImportClearanceId
   * @return mImportClearanceId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getMImportClearanceId() {
    return mImportClearanceId;
  }

  public void setMImportClearanceId(Integer mImportClearanceId) {
    this.mImportClearanceId = mImportClearanceId;
  }

  public InOutLine mInoutId(Integer mInoutId) {
    this.mInoutId = mInoutId;
    return this;
  }

  /**
   * Get mInoutId
   * @return mInoutId
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getMInoutId() {
    return mInoutId;
  }

  public void setMInoutId(Integer mInoutId) {
    this.mInoutId = mInoutId;
  }

  public InOutLine mInoutlineId(Integer mInoutlineId) {
    this.mInoutlineId = mInoutlineId;
    return this;
  }

  /**
   * Get mInoutlineId
   * @return mInoutlineId
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getMInoutlineId() {
    return mInoutlineId;
  }

  public void setMInoutlineId(Integer mInoutlineId) {
    this.mInoutlineId = mInoutlineId;
  }

  public InOutLine mLocatorId(Integer mLocatorId) {
    this.mLocatorId = mLocatorId;
    return this;
  }

  /**
   * Get mLocatorId
   * @return mLocatorId
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getMLocatorId() {
    return mLocatorId;
  }

  public void setMLocatorId(Integer mLocatorId) {
    this.mLocatorId = mLocatorId;
  }

  public InOutLine movementqty(BigDecimal movementqty) {
    this.movementqty = movementqty;
    return this;
  }

  /**
   * Get movementqty
   * @return movementqty
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public BigDecimal getMovementqty() {
    return movementqty;
  }

  public void setMovementqty(BigDecimal movementqty) {
    this.movementqty = movementqty;
  }

  public InOutLine mProductId(Integer mProductId) {
    this.mProductId = mProductId;
    return this;
  }

  /**
   * Get mProductId
   * @return mProductId
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getMProductId() {
    return mProductId;
  }

  public void setMProductId(Integer mProductId) {
    this.mProductId = mProductId;
  }

  public InOutLine pickedqty(BigDecimal pickedqty) {
    this.pickedqty = pickedqty;
    return this;
  }

  /**
   * Get pickedqty
   * @return pickedqty
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getPickedqty() {
    return pickedqty;
  }

  public void setPickedqty(BigDecimal pickedqty) {
    this.pickedqty = pickedqty;
  }

  public InOutLine processed(Boolean processed) {
    this.processed = processed;
    return this;
  }

  /**
   * Get processed
   * @return processed
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Boolean isProcessed() {
    return processed;
  }

  public void setProcessed(Boolean processed) {
    this.processed = processed;
  }

  public InOutLine qtyentered(BigDecimal qtyentered) {
    this.qtyentered = qtyentered;
    return this;
  }

  /**
   * Get qtyentered
   * @return qtyentered
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public BigDecimal getQtyentered() {
    return qtyentered;
  }

  public void setQtyentered(BigDecimal qtyentered) {
    this.qtyentered = qtyentered;
  }

  public InOutLine refInoutlineId(Integer refInoutlineId) {
    this.refInoutlineId = refInoutlineId;
    return this;
  }

  /**
   * Get refInoutlineId
   * @return refInoutlineId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getRefInoutlineId() {
    return refInoutlineId;
  }

  public void setRefInoutlineId(Integer refInoutlineId) {
    this.refInoutlineId = refInoutlineId;
  }

  public InOutLine scrappedqty(BigDecimal scrappedqty) {
    this.scrappedqty = scrappedqty;
    return this;
  }

  /**
   * Get scrappedqty
   * @return scrappedqty
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getScrappedqty() {
    return scrappedqty;
  }

  public void setScrappedqty(BigDecimal scrappedqty) {
    this.scrappedqty = scrappedqty;
  }

  public InOutLine targetqty(BigDecimal targetqty) {
    this.targetqty = targetqty;
    return this;
  }

  /**
   * Get targetqty
   * @return targetqty
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getTargetqty() {
    return targetqty;
  }

  public void setTargetqty(BigDecimal targetqty) {
    this.targetqty = targetqty;
  }

  public InOutLine updated(String updated) {
    this.updated = updated;
    return this;
  }

  /**
   * Get updated
   * @return updated
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  public InOutLine updatedby(Integer updatedby) {
    this.updatedby = updatedby;
    return this;
  }

  /**
   * Get updatedby
   * @return updatedby
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getUpdatedby() {
    return updatedby;
  }

  public void setUpdatedby(Integer updatedby) {
    this.updatedby = updatedby;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InOutLine inOutLine = (InOutLine) o;
    return Objects.equals(this.adClientId, inOutLine.adClientId) &&
        Objects.equals(this.adOrgId, inOutLine.adOrgId) &&
        Objects.equals(this.cChargeId, inOutLine.cChargeId) &&
        Objects.equals(this.cCountryId, inOutLine.cCountryId) &&
        Objects.equals(this.cInvoicelineId, inOutLine.cInvoicelineId) &&
        Objects.equals(this.confirmedqty, inOutLine.confirmedqty) &&
        Objects.equals(this.cOrderlineId, inOutLine.cOrderlineId) &&
        Objects.equals(this.costprice, inOutLine.costprice) &&
        Objects.equals(this.cProjectId, inOutLine.cProjectId) &&
        Objects.equals(this.created, inOutLine.created) &&
        Objects.equals(this.createdby, inOutLine.createdby) &&
        Objects.equals(this.cUomId, inOutLine.cUomId) &&
        Objects.equals(this.declarationno, inOutLine.declarationno) &&
        Objects.equals(this.description, inOutLine.description) &&
        Objects.equals(this.isactive, inOutLine.isactive) &&
        Objects.equals(this.isdescription, inOutLine.isdescription) &&
        Objects.equals(this.isinvoiced, inOutLine.isinvoiced) &&
        Objects.equals(this.isselected, inOutLine.isselected) &&
        Objects.equals(this.line, inOutLine.line) &&
        Objects.equals(this.mAttributesetinstanceId, inOutLine.mAttributesetinstanceId) &&
        Objects.equals(this.mImportClearanceId, inOutLine.mImportClearanceId) &&
        Objects.equals(this.mInoutId, inOutLine.mInoutId) &&
        Objects.equals(this.mInoutlineId, inOutLine.mInoutlineId) &&
        Objects.equals(this.mLocatorId, inOutLine.mLocatorId) &&
        Objects.equals(this.movementqty, inOutLine.movementqty) &&
        Objects.equals(this.mProductId, inOutLine.mProductId) &&
        Objects.equals(this.pickedqty, inOutLine.pickedqty) &&
        Objects.equals(this.processed, inOutLine.processed) &&
        Objects.equals(this.qtyentered, inOutLine.qtyentered) &&
        Objects.equals(this.refInoutlineId, inOutLine.refInoutlineId) &&
        Objects.equals(this.scrappedqty, inOutLine.scrappedqty) &&
        Objects.equals(this.targetqty, inOutLine.targetqty) &&
        Objects.equals(this.updated, inOutLine.updated) &&
        Objects.equals(this.updatedby, inOutLine.updatedby);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, cChargeId, cCountryId, cInvoicelineId, confirmedqty, cOrderlineId, costprice, cProjectId, created, createdby, cUomId, declarationno, description, isactive, isdescription, isinvoiced, isselected, line, mAttributesetinstanceId, mImportClearanceId, mInoutId, mInoutlineId, mLocatorId, movementqty, mProductId, pickedqty, processed, qtyentered, refInoutlineId, scrappedqty, targetqty, updated, updatedby);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InOutLine {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cChargeId: ").append(toIndentedString(cChargeId)).append("\n");
    sb.append("    cCountryId: ").append(toIndentedString(cCountryId)).append("\n");
    sb.append("    cInvoicelineId: ").append(toIndentedString(cInvoicelineId)).append("\n");
    sb.append("    confirmedqty: ").append(toIndentedString(confirmedqty)).append("\n");
    sb.append("    cOrderlineId: ").append(toIndentedString(cOrderlineId)).append("\n");
    sb.append("    costprice: ").append(toIndentedString(costprice)).append("\n");
    sb.append("    cProjectId: ").append(toIndentedString(cProjectId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cUomId: ").append(toIndentedString(cUomId)).append("\n");
    sb.append("    declarationno: ").append(toIndentedString(declarationno)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isdescription: ").append(toIndentedString(isdescription)).append("\n");
    sb.append("    isinvoiced: ").append(toIndentedString(isinvoiced)).append("\n");
    sb.append("    isselected: ").append(toIndentedString(isselected)).append("\n");
    sb.append("    line: ").append(toIndentedString(line)).append("\n");
    sb.append("    mAttributesetinstanceId: ").append(toIndentedString(mAttributesetinstanceId)).append("\n");
    sb.append("    mImportClearanceId: ").append(toIndentedString(mImportClearanceId)).append("\n");
    sb.append("    mInoutId: ").append(toIndentedString(mInoutId)).append("\n");
    sb.append("    mInoutlineId: ").append(toIndentedString(mInoutlineId)).append("\n");
    sb.append("    mLocatorId: ").append(toIndentedString(mLocatorId)).append("\n");
    sb.append("    movementqty: ").append(toIndentedString(movementqty)).append("\n");
    sb.append("    mProductId: ").append(toIndentedString(mProductId)).append("\n");
    sb.append("    pickedqty: ").append(toIndentedString(pickedqty)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    qtyentered: ").append(toIndentedString(qtyentered)).append("\n");
    sb.append("    refInoutlineId: ").append(toIndentedString(refInoutlineId)).append("\n");
    sb.append("    scrappedqty: ").append(toIndentedString(scrappedqty)).append("\n");
    sb.append("    targetqty: ").append(toIndentedString(targetqty)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
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
