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
 * Inventory
 */
@Validated



public class Inventory   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_orgtrx_id")
  private Integer adOrgtrxId = null;

  @JsonProperty("approvalamt")
  private BigDecimal approvalamt = null;

  @JsonProperty("c_activity_id")
  private Integer cActivityId = null;

  @JsonProperty("c_campaign_id")
  private Integer cCampaignId = null;

  @JsonProperty("c_charge_id")
  private Integer cChargeId = null;

  @JsonProperty("c_doctype_id")
  private Integer cDoctypeId = null;

  @JsonProperty("c_project_id")
  private Integer cProjectId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("docstatus")
  private String docstatus = null;

  @JsonProperty("documentno")
  private String documentno = null;

  @JsonProperty("inventorykind")
  private String inventorykind = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isapproved")
  private Boolean isapproved = null;

  @JsonProperty("m_inventory_id")
  private Integer mInventoryId = null;

  @JsonProperty("movementdate")
  private String movementdate = null;

  @JsonProperty("m_perpetualinv_id")
  private Integer mPerpetualinvId = null;

  @JsonProperty("m_warehouse_id")
  private Integer mWarehouseId = null;

  @JsonProperty("paper_form")
  private String paperForm = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("processing")
  private Boolean processing = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("user1_id")
  private Integer user1Id = null;

  @JsonProperty("user2_id")
  private Integer user2Id = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public Inventory adClientId(Integer adClientId) {
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

  public Inventory adOrgId(Integer adOrgId) {
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

  public Inventory adOrgtrxId(Integer adOrgtrxId) {
    this.adOrgtrxId = adOrgtrxId;
    return this;
  }

  /**
   * Get adOrgtrxId
   * @return adOrgtrxId
   **/
  @Schema(description = "")
  
    public Integer getAdOrgtrxId() {
    return adOrgtrxId;
  }

  public void setAdOrgtrxId(Integer adOrgtrxId) {
    this.adOrgtrxId = adOrgtrxId;
  }

  public Inventory approvalamt(BigDecimal approvalamt) {
    this.approvalamt = approvalamt;
    return this;
  }

  /**
   * Get approvalamt
   * @return approvalamt
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getApprovalamt() {
    return approvalamt;
  }

  public void setApprovalamt(BigDecimal approvalamt) {
    this.approvalamt = approvalamt;
  }

  public Inventory cActivityId(Integer cActivityId) {
    this.cActivityId = cActivityId;
    return this;
  }

  /**
   * Get cActivityId
   * @return cActivityId
   **/
  @Schema(description = "")
  
    public Integer getCActivityId() {
    return cActivityId;
  }

  public void setCActivityId(Integer cActivityId) {
    this.cActivityId = cActivityId;
  }

  public Inventory cCampaignId(Integer cCampaignId) {
    this.cCampaignId = cCampaignId;
    return this;
  }

  /**
   * Get cCampaignId
   * @return cCampaignId
   **/
  @Schema(description = "")
  
    public Integer getCCampaignId() {
    return cCampaignId;
  }

  public void setCCampaignId(Integer cCampaignId) {
    this.cCampaignId = cCampaignId;
  }

  public Inventory cChargeId(Integer cChargeId) {
    this.cChargeId = cChargeId;
    return this;
  }

  /**
   * Get cChargeId
   * @return cChargeId
   **/
  @Schema(description = "")
  
    public Integer getCChargeId() {
    return cChargeId;
  }

  public void setCChargeId(Integer cChargeId) {
    this.cChargeId = cChargeId;
  }

  public Inventory cDoctypeId(Integer cDoctypeId) {
    this.cDoctypeId = cDoctypeId;
    return this;
  }

  /**
   * Get cDoctypeId
   * @return cDoctypeId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCDoctypeId() {
    return cDoctypeId;
  }

  public void setCDoctypeId(Integer cDoctypeId) {
    this.cDoctypeId = cDoctypeId;
  }

  public Inventory cProjectId(Integer cProjectId) {
    this.cProjectId = cProjectId;
    return this;
  }

  /**
   * Get cProjectId
   * @return cProjectId
   **/
  @Schema(description = "")
  
    public Integer getCProjectId() {
    return cProjectId;
  }

  public void setCProjectId(Integer cProjectId) {
    this.cProjectId = cProjectId;
  }

  public Inventory created(String created) {
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

  public Inventory createdby(Integer createdby) {
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

  public Inventory description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  @Schema(description = "")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Inventory docstatus(String docstatus) {
    this.docstatus = docstatus;
    return this;
  }

  /**
   * Get docstatus
   * @return docstatus
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDocstatus() {
    return docstatus;
  }

  public void setDocstatus(String docstatus) {
    this.docstatus = docstatus;
  }

  public Inventory documentno(String documentno) {
    this.documentno = documentno;
    return this;
  }

  /**
   * Get documentno
   * @return documentno
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDocumentno() {
    return documentno;
  }

  public void setDocumentno(String documentno) {
    this.documentno = documentno;
  }

  public Inventory inventorykind(String inventorykind) {
    this.inventorykind = inventorykind;
    return this;
  }

  /**
   * Get inventorykind
   * @return inventorykind
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getInventorykind() {
    return inventorykind;
  }

  public void setInventorykind(String inventorykind) {
    this.inventorykind = inventorykind;
  }

  public Inventory isactive(Boolean isactive) {
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

  public Inventory isapproved(Boolean isapproved) {
    this.isapproved = isapproved;
    return this;
  }

  /**
   * Get isapproved
   * @return isapproved
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsapproved() {
    return isapproved;
  }

  public void setIsapproved(Boolean isapproved) {
    this.isapproved = isapproved;
  }

  public Inventory mInventoryId(Integer mInventoryId) {
    this.mInventoryId = mInventoryId;
    return this;
  }

  /**
   * Get mInventoryId
   * @return mInventoryId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getMInventoryId() {
    return mInventoryId;
  }

  public void setMInventoryId(Integer mInventoryId) {
    this.mInventoryId = mInventoryId;
  }

  public Inventory movementdate(String movementdate) {
    this.movementdate = movementdate;
    return this;
  }

  /**
   * Get movementdate
   * @return movementdate
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getMovementdate() {
    return movementdate;
  }

  public void setMovementdate(String movementdate) {
    this.movementdate = movementdate;
  }

  public Inventory mPerpetualinvId(Integer mPerpetualinvId) {
    this.mPerpetualinvId = mPerpetualinvId;
    return this;
  }

  /**
   * Get mPerpetualinvId
   * @return mPerpetualinvId
   **/
  @Schema(description = "")
  
    public Integer getMPerpetualinvId() {
    return mPerpetualinvId;
  }

  public void setMPerpetualinvId(Integer mPerpetualinvId) {
    this.mPerpetualinvId = mPerpetualinvId;
  }

  public Inventory mWarehouseId(Integer mWarehouseId) {
    this.mWarehouseId = mWarehouseId;
    return this;
  }

  /**
   * Get mWarehouseId
   * @return mWarehouseId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getMWarehouseId() {
    return mWarehouseId;
  }

  public void setMWarehouseId(Integer mWarehouseId) {
    this.mWarehouseId = mWarehouseId;
  }

  public Inventory paperForm(String paperForm) {
    this.paperForm = paperForm;
    return this;
  }

  /**
   * Get paperForm
   * @return paperForm
   **/
  @Schema(description = "")
  
    public String getPaperForm() {
    return paperForm;
  }

  public void setPaperForm(String paperForm) {
    this.paperForm = paperForm;
  }

  public Inventory processed(Boolean processed) {
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

  public Inventory processing(Boolean processing) {
    this.processing = processing;
    return this;
  }

  /**
   * Get processing
   * @return processing
   **/
  @Schema(description = "")
  
    public Boolean isProcessing() {
    return processing;
  }

  public void setProcessing(Boolean processing) {
    this.processing = processing;
  }

  public Inventory updated(String updated) {
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

  public Inventory updatedby(Integer updatedby) {
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

  public Inventory user1Id(Integer user1Id) {
    this.user1Id = user1Id;
    return this;
  }

  /**
   * Get user1Id
   * @return user1Id
   **/
  @Schema(description = "")
  
    public Integer getUser1Id() {
    return user1Id;
  }

  public void setUser1Id(Integer user1Id) {
    this.user1Id = user1Id;
  }

  public Inventory user2Id(Integer user2Id) {
    this.user2Id = user2Id;
    return this;
  }

  /**
   * Get user2Id
   * @return user2Id
   **/
  @Schema(description = "")
  
    public Integer getUser2Id() {
    return user2Id;
  }

  public void setUser2Id(Integer user2Id) {
    this.user2Id = user2Id;
  }

  public Inventory additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Inventory addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Inventory referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Inventory addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Inventory inventory = (Inventory) o;
    return Objects.equals(this.adClientId, inventory.adClientId) &&
        Objects.equals(this.adOrgId, inventory.adOrgId) &&
        Objects.equals(this.adOrgtrxId, inventory.adOrgtrxId) &&
        Objects.equals(this.approvalamt, inventory.approvalamt) &&
        Objects.equals(this.cActivityId, inventory.cActivityId) &&
        Objects.equals(this.cCampaignId, inventory.cCampaignId) &&
        Objects.equals(this.cChargeId, inventory.cChargeId) &&
        Objects.equals(this.cDoctypeId, inventory.cDoctypeId) &&
        Objects.equals(this.cProjectId, inventory.cProjectId) &&
        Objects.equals(this.created, inventory.created) &&
        Objects.equals(this.createdby, inventory.createdby) &&
        Objects.equals(this.description, inventory.description) &&
        Objects.equals(this.docstatus, inventory.docstatus) &&
        Objects.equals(this.documentno, inventory.documentno) &&
        Objects.equals(this.inventorykind, inventory.inventorykind) &&
        Objects.equals(this.isactive, inventory.isactive) &&
        Objects.equals(this.isapproved, inventory.isapproved) &&
        Objects.equals(this.mInventoryId, inventory.mInventoryId) &&
        Objects.equals(this.movementdate, inventory.movementdate) &&
        Objects.equals(this.mPerpetualinvId, inventory.mPerpetualinvId) &&
        Objects.equals(this.mWarehouseId, inventory.mWarehouseId) &&
        Objects.equals(this.paperForm, inventory.paperForm) &&
        Objects.equals(this.processed, inventory.processed) &&
        Objects.equals(this.processing, inventory.processing) &&
        Objects.equals(this.updated, inventory.updated) &&
        Objects.equals(this.updatedby, inventory.updatedby) &&
        Objects.equals(this.user1Id, inventory.user1Id) &&
        Objects.equals(this.user2Id, inventory.user2Id) &&
        Objects.equals(this.additionalvalues, inventory.additionalvalues) &&
        Objects.equals(this.referencedvalues, inventory.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, adOrgtrxId, approvalamt, cActivityId, cCampaignId, cChargeId, cDoctypeId, cProjectId, created, createdby, description, docstatus, documentno, inventorykind, isactive, isapproved, mInventoryId, movementdate, mPerpetualinvId, mWarehouseId, paperForm, processed, processing, updated, updatedby, user1Id, user2Id, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Inventory {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adOrgtrxId: ").append(toIndentedString(adOrgtrxId)).append("\n");
    sb.append("    approvalamt: ").append(toIndentedString(approvalamt)).append("\n");
    sb.append("    cActivityId: ").append(toIndentedString(cActivityId)).append("\n");
    sb.append("    cCampaignId: ").append(toIndentedString(cCampaignId)).append("\n");
    sb.append("    cChargeId: ").append(toIndentedString(cChargeId)).append("\n");
    sb.append("    cDoctypeId: ").append(toIndentedString(cDoctypeId)).append("\n");
    sb.append("    cProjectId: ").append(toIndentedString(cProjectId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    docstatus: ").append(toIndentedString(docstatus)).append("\n");
    sb.append("    documentno: ").append(toIndentedString(documentno)).append("\n");
    sb.append("    inventorykind: ").append(toIndentedString(inventorykind)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isapproved: ").append(toIndentedString(isapproved)).append("\n");
    sb.append("    mInventoryId: ").append(toIndentedString(mInventoryId)).append("\n");
    sb.append("    movementdate: ").append(toIndentedString(movementdate)).append("\n");
    sb.append("    mPerpetualinvId: ").append(toIndentedString(mPerpetualinvId)).append("\n");
    sb.append("    mWarehouseId: ").append(toIndentedString(mWarehouseId)).append("\n");
    sb.append("    paperForm: ").append(toIndentedString(paperForm)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    processing: ").append(toIndentedString(processing)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    user1Id: ").append(toIndentedString(user1Id)).append("\n");
    sb.append("    user2Id: ").append(toIndentedString(user2Id)).append("\n");
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
