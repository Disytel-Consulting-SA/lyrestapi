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
 * InOut
 */
@Validated



public class InOut   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_orgtrx_id")
  private Integer adOrgtrxId = null;

  @JsonProperty("ad_user_id")
  private Integer adUserId = null;

  @JsonProperty("c_activity_id")
  private Integer cActivityId = null;

  @JsonProperty("cai")
  private String cai = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("c_bpartner_location_id")
  private Integer cBpartnerLocationId = null;

  @JsonProperty("c_campaign_id")
  private Integer cCampaignId = null;

  @JsonProperty("c_charge_id")
  private Integer cChargeId = null;

  @JsonProperty("c_doctype_id")
  private Integer cDoctypeId = null;

  @JsonProperty("chargeamt")
  private BigDecimal chargeamt = null;

  @JsonProperty("c_invoice_id")
  private Integer cInvoiceId = null;

  @JsonProperty("clearancenumber")
  private String clearancenumber = null;

  @JsonProperty("c_order_id")
  private Integer cOrderId = null;

  @JsonProperty("c_project_id")
  private Integer cProjectId = null;

  @JsonProperty("createconfirm")
  private String createconfirm = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("createfrom")
  private String createfrom = null;

  @JsonProperty("createpackage")
  private String createpackage = null;

  @JsonProperty("dateacct")
  private String dateacct = null;

  @JsonProperty("datecai")
  private String datecai = null;

  @JsonProperty("dateordered")
  private String dateordered = null;

  @JsonProperty("dateprinted")
  private String dateprinted = null;

  @JsonProperty("datereceived")
  private String datereceived = null;

  @JsonProperty("deliveryrule")
  private String deliveryrule = null;

  @JsonProperty("deliveryviarule")
  private String deliveryviarule = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("docaction")
  private String docaction = null;

  @JsonProperty("docstatus")
  private String docstatus = null;

  @JsonProperty("documentno")
  private String documentno = null;

  @JsonProperty("freightamt")
  private BigDecimal freightamt = null;

  @JsonProperty("freightcostrule")
  private String freightcostrule = null;

  @JsonProperty("generateto")
  private String generateto = null;

  @JsonProperty("inoutdate")
  private String inoutdate = null;

  @JsonProperty("inoutreceptiondate")
  private String inoutreceptiondate = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isapproved")
  private Boolean isapproved = null;

  @JsonProperty("isindispute")
  private Boolean isindispute = null;

  @JsonProperty("isintransit")
  private Boolean isintransit = null;

  @JsonProperty("isprinted")
  private Boolean isprinted = null;

  @JsonProperty("issotrx")
  private Boolean issotrx = null;

  @JsonProperty("m_inout_id")
  private Integer mInoutId = null;

  @JsonProperty("movementdate")
  private String movementdate = null;

  @JsonProperty("movementtype")
  private String movementtype = null;

  @JsonProperty("m_shipper_id")
  private Integer mShipperId = null;

  @JsonProperty("m_warehouse_id")
  private Integer mWarehouseId = null;

  @JsonProperty("nopackages")
  private Integer nopackages = null;

  @JsonProperty("pickdate")
  private String pickdate = null;

  @JsonProperty("poreference")
  private String poreference = null;

  @JsonProperty("posted")
  private String posted = null;

  @JsonProperty("preprinted_docno")
  private String preprintedDocno = null;

  @JsonProperty("printtype")
  private String printtype = null;

  @JsonProperty("priorityrule")
  private String priorityrule = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("processing")
  private String processing = null;

  @JsonProperty("receptiondate")
  private String receptiondate = null;

  @JsonProperty("ref_inout_id")
  private Integer refInoutId = null;

  @JsonProperty("salesrep_id")
  private Integer salesrepId = null;

  @JsonProperty("sendemail")
  private Boolean sendemail = null;

  @JsonProperty("shipdate")
  private String shipdate = null;

  @JsonProperty("trackingno")
  private String trackingno = null;

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

  public InOut adClientId(Integer adClientId) {
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

  public InOut adOrgId(Integer adOrgId) {
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

  public InOut adOrgtrxId(Integer adOrgtrxId) {
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

  public InOut adUserId(Integer adUserId) {
    this.adUserId = adUserId;
    return this;
  }

  /**
   * Get adUserId
   * @return adUserId
   **/
  @Schema(description = "")
  
    public Integer getAdUserId() {
    return adUserId;
  }

  public void setAdUserId(Integer adUserId) {
    this.adUserId = adUserId;
  }

  public InOut cActivityId(Integer cActivityId) {
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

  public InOut cai(String cai) {
    this.cai = cai;
    return this;
  }

  /**
   * Get cai
   * @return cai
   **/
  @Schema(description = "")
  
    public String getCai() {
    return cai;
  }

  public void setCai(String cai) {
    this.cai = cai;
  }

  public InOut cBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
    return this;
  }

  /**
   * Get cBpartnerId
   * @return cBpartnerId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCBpartnerId() {
    return cBpartnerId;
  }

  public void setCBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
  }

  public InOut cBpartnerLocationId(Integer cBpartnerLocationId) {
    this.cBpartnerLocationId = cBpartnerLocationId;
    return this;
  }

  /**
   * Get cBpartnerLocationId
   * @return cBpartnerLocationId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCBpartnerLocationId() {
    return cBpartnerLocationId;
  }

  public void setCBpartnerLocationId(Integer cBpartnerLocationId) {
    this.cBpartnerLocationId = cBpartnerLocationId;
  }

  public InOut cCampaignId(Integer cCampaignId) {
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

  public InOut cChargeId(Integer cChargeId) {
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

  public InOut cDoctypeId(Integer cDoctypeId) {
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

  public InOut chargeamt(BigDecimal chargeamt) {
    this.chargeamt = chargeamt;
    return this;
  }

  /**
   * Get chargeamt
   * @return chargeamt
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getChargeamt() {
    return chargeamt;
  }

  public void setChargeamt(BigDecimal chargeamt) {
    this.chargeamt = chargeamt;
  }

  public InOut cInvoiceId(Integer cInvoiceId) {
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

  public InOut clearancenumber(String clearancenumber) {
    this.clearancenumber = clearancenumber;
    return this;
  }

  /**
   * Get clearancenumber
   * @return clearancenumber
   **/
  @Schema(description = "")
  
    public String getClearancenumber() {
    return clearancenumber;
  }

  public void setClearancenumber(String clearancenumber) {
    this.clearancenumber = clearancenumber;
  }

  public InOut cOrderId(Integer cOrderId) {
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

  public InOut cProjectId(Integer cProjectId) {
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

  public InOut createconfirm(String createconfirm) {
    this.createconfirm = createconfirm;
    return this;
  }

  /**
   * Get createconfirm
   * @return createconfirm
   **/
  @Schema(description = "")
  
    public String getCreateconfirm() {
    return createconfirm;
  }

  public void setCreateconfirm(String createconfirm) {
    this.createconfirm = createconfirm;
  }

  public InOut created(String created) {
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

  public InOut createdby(Integer createdby) {
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

  public InOut createfrom(String createfrom) {
    this.createfrom = createfrom;
    return this;
  }

  /**
   * Get createfrom
   * @return createfrom
   **/
  @Schema(description = "")
  
    public String getCreatefrom() {
    return createfrom;
  }

  public void setCreatefrom(String createfrom) {
    this.createfrom = createfrom;
  }

  public InOut createpackage(String createpackage) {
    this.createpackage = createpackage;
    return this;
  }

  /**
   * Get createpackage
   * @return createpackage
   **/
  @Schema(description = "")
  
    public String getCreatepackage() {
    return createpackage;
  }

  public void setCreatepackage(String createpackage) {
    this.createpackage = createpackage;
  }

  public InOut dateacct(String dateacct) {
    this.dateacct = dateacct;
    return this;
  }

  /**
   * Get dateacct
   * @return dateacct
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDateacct() {
    return dateacct;
  }

  public void setDateacct(String dateacct) {
    this.dateacct = dateacct;
  }

  public InOut datecai(String datecai) {
    this.datecai = datecai;
    return this;
  }

  /**
   * Get datecai
   * @return datecai
   **/
  @Schema(description = "")
  
    public String getDatecai() {
    return datecai;
  }

  public void setDatecai(String datecai) {
    this.datecai = datecai;
  }

  public InOut dateordered(String dateordered) {
    this.dateordered = dateordered;
    return this;
  }

  /**
   * Get dateordered
   * @return dateordered
   **/
  @Schema(description = "")
  
    public String getDateordered() {
    return dateordered;
  }

  public void setDateordered(String dateordered) {
    this.dateordered = dateordered;
  }

  public InOut dateprinted(String dateprinted) {
    this.dateprinted = dateprinted;
    return this;
  }

  /**
   * Get dateprinted
   * @return dateprinted
   **/
  @Schema(description = "")
  
    public String getDateprinted() {
    return dateprinted;
  }

  public void setDateprinted(String dateprinted) {
    this.dateprinted = dateprinted;
  }

  public InOut datereceived(String datereceived) {
    this.datereceived = datereceived;
    return this;
  }

  /**
   * Get datereceived
   * @return datereceived
   **/
  @Schema(description = "")
  
    public String getDatereceived() {
    return datereceived;
  }

  public void setDatereceived(String datereceived) {
    this.datereceived = datereceived;
  }

  public InOut deliveryrule(String deliveryrule) {
    this.deliveryrule = deliveryrule;
    return this;
  }

  /**
   * Get deliveryrule
   * @return deliveryrule
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDeliveryrule() {
    return deliveryrule;
  }

  public void setDeliveryrule(String deliveryrule) {
    this.deliveryrule = deliveryrule;
  }

  public InOut deliveryviarule(String deliveryviarule) {
    this.deliveryviarule = deliveryviarule;
    return this;
  }

  /**
   * Get deliveryviarule
   * @return deliveryviarule
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDeliveryviarule() {
    return deliveryviarule;
  }

  public void setDeliveryviarule(String deliveryviarule) {
    this.deliveryviarule = deliveryviarule;
  }

  public InOut description(String description) {
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

  public InOut docaction(String docaction) {
    this.docaction = docaction;
    return this;
  }

  /**
   * Get docaction
   * @return docaction
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDocaction() {
    return docaction;
  }

  public void setDocaction(String docaction) {
    this.docaction = docaction;
  }

  public InOut docstatus(String docstatus) {
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

  public InOut documentno(String documentno) {
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

  public InOut freightamt(BigDecimal freightamt) {
    this.freightamt = freightamt;
    return this;
  }

  /**
   * Get freightamt
   * @return freightamt
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getFreightamt() {
    return freightamt;
  }

  public void setFreightamt(BigDecimal freightamt) {
    this.freightamt = freightamt;
  }

  public InOut freightcostrule(String freightcostrule) {
    this.freightcostrule = freightcostrule;
    return this;
  }

  /**
   * Get freightcostrule
   * @return freightcostrule
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getFreightcostrule() {
    return freightcostrule;
  }

  public void setFreightcostrule(String freightcostrule) {
    this.freightcostrule = freightcostrule;
  }

  public InOut generateto(String generateto) {
    this.generateto = generateto;
    return this;
  }

  /**
   * Get generateto
   * @return generateto
   **/
  @Schema(description = "")
  
    public String getGenerateto() {
    return generateto;
  }

  public void setGenerateto(String generateto) {
    this.generateto = generateto;
  }

  public InOut inoutdate(String inoutdate) {
    this.inoutdate = inoutdate;
    return this;
  }

  /**
   * Get inoutdate
   * @return inoutdate
   **/
  @Schema(description = "")
  
    public String getInoutdate() {
    return inoutdate;
  }

  public void setInoutdate(String inoutdate) {
    this.inoutdate = inoutdate;
  }

  public InOut inoutreceptiondate(String inoutreceptiondate) {
    this.inoutreceptiondate = inoutreceptiondate;
    return this;
  }

  /**
   * Get inoutreceptiondate
   * @return inoutreceptiondate
   **/
  @Schema(description = "")
  
    public String getInoutreceptiondate() {
    return inoutreceptiondate;
  }

  public void setInoutreceptiondate(String inoutreceptiondate) {
    this.inoutreceptiondate = inoutreceptiondate;
  }

  public InOut isactive(Boolean isactive) {
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

  public InOut isapproved(Boolean isapproved) {
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

  public InOut isindispute(Boolean isindispute) {
    this.isindispute = isindispute;
    return this;
  }

  /**
   * Get isindispute
   * @return isindispute
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsindispute() {
    return isindispute;
  }

  public void setIsindispute(Boolean isindispute) {
    this.isindispute = isindispute;
  }

  public InOut isintransit(Boolean isintransit) {
    this.isintransit = isintransit;
    return this;
  }

  /**
   * Get isintransit
   * @return isintransit
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsintransit() {
    return isintransit;
  }

  public void setIsintransit(Boolean isintransit) {
    this.isintransit = isintransit;
  }

  public InOut isprinted(Boolean isprinted) {
    this.isprinted = isprinted;
    return this;
  }

  /**
   * Get isprinted
   * @return isprinted
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsprinted() {
    return isprinted;
  }

  public void setIsprinted(Boolean isprinted) {
    this.isprinted = isprinted;
  }

  public InOut issotrx(Boolean issotrx) {
    this.issotrx = issotrx;
    return this;
  }

  /**
   * Get issotrx
   * @return issotrx
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIssotrx() {
    return issotrx;
  }

  public void setIssotrx(Boolean issotrx) {
    this.issotrx = issotrx;
  }

  public InOut mInoutId(Integer mInoutId) {
    this.mInoutId = mInoutId;
    return this;
  }

  /**
   * Get mInoutId
   * @return mInoutId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getMInoutId() {
    return mInoutId;
  }

  public void setMInoutId(Integer mInoutId) {
    this.mInoutId = mInoutId;
  }

  public InOut movementdate(String movementdate) {
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

  public InOut movementtype(String movementtype) {
    this.movementtype = movementtype;
    return this;
  }

  /**
   * Get movementtype
   * @return movementtype
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getMovementtype() {
    return movementtype;
  }

  public void setMovementtype(String movementtype) {
    this.movementtype = movementtype;
  }

  public InOut mShipperId(Integer mShipperId) {
    this.mShipperId = mShipperId;
    return this;
  }

  /**
   * Get mShipperId
   * @return mShipperId
   **/
  @Schema(description = "")
  
    public Integer getMShipperId() {
    return mShipperId;
  }

  public void setMShipperId(Integer mShipperId) {
    this.mShipperId = mShipperId;
  }

  public InOut mWarehouseId(Integer mWarehouseId) {
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

  public InOut nopackages(Integer nopackages) {
    this.nopackages = nopackages;
    return this;
  }

  /**
   * Get nopackages
   * @return nopackages
   **/
  @Schema(description = "")
  
    public Integer getNopackages() {
    return nopackages;
  }

  public void setNopackages(Integer nopackages) {
    this.nopackages = nopackages;
  }

  public InOut pickdate(String pickdate) {
    this.pickdate = pickdate;
    return this;
  }

  /**
   * Get pickdate
   * @return pickdate
   **/
  @Schema(description = "")
  
    public String getPickdate() {
    return pickdate;
  }

  public void setPickdate(String pickdate) {
    this.pickdate = pickdate;
  }

  public InOut poreference(String poreference) {
    this.poreference = poreference;
    return this;
  }

  /**
   * Get poreference
   * @return poreference
   **/
  @Schema(description = "")
  
    public String getPoreference() {
    return poreference;
  }

  public void setPoreference(String poreference) {
    this.poreference = poreference;
  }

  public InOut posted(String posted) {
    this.posted = posted;
    return this;
  }

  /**
   * Get posted
   * @return posted
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getPosted() {
    return posted;
  }

  public void setPosted(String posted) {
    this.posted = posted;
  }

  public InOut preprintedDocno(String preprintedDocno) {
    this.preprintedDocno = preprintedDocno;
    return this;
  }

  /**
   * Get preprintedDocno
   * @return preprintedDocno
   **/
  @Schema(description = "")
  
    public String getPreprintedDocno() {
    return preprintedDocno;
  }

  public void setPreprintedDocno(String preprintedDocno) {
    this.preprintedDocno = preprintedDocno;
  }

  public InOut printtype(String printtype) {
    this.printtype = printtype;
    return this;
  }

  /**
   * Get printtype
   * @return printtype
   **/
  @Schema(description = "")
  
    public String getPrinttype() {
    return printtype;
  }

  public void setPrinttype(String printtype) {
    this.printtype = printtype;
  }

  public InOut priorityrule(String priorityrule) {
    this.priorityrule = priorityrule;
    return this;
  }

  /**
   * Get priorityrule
   * @return priorityrule
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getPriorityrule() {
    return priorityrule;
  }

  public void setPriorityrule(String priorityrule) {
    this.priorityrule = priorityrule;
  }

  public InOut processed(Boolean processed) {
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

  public InOut processing(String processing) {
    this.processing = processing;
    return this;
  }

  /**
   * Get processing
   * @return processing
   **/
  @Schema(description = "")
  
    public String getProcessing() {
    return processing;
  }

  public void setProcessing(String processing) {
    this.processing = processing;
  }

  public InOut receptiondate(String receptiondate) {
    this.receptiondate = receptiondate;
    return this;
  }

  /**
   * Get receptiondate
   * @return receptiondate
   **/
  @Schema(description = "")
  
    public String getReceptiondate() {
    return receptiondate;
  }

  public void setReceptiondate(String receptiondate) {
    this.receptiondate = receptiondate;
  }

  public InOut refInoutId(Integer refInoutId) {
    this.refInoutId = refInoutId;
    return this;
  }

  /**
   * Get refInoutId
   * @return refInoutId
   **/
  @Schema(description = "")
  
    public Integer getRefInoutId() {
    return refInoutId;
  }

  public void setRefInoutId(Integer refInoutId) {
    this.refInoutId = refInoutId;
  }

  public InOut salesrepId(Integer salesrepId) {
    this.salesrepId = salesrepId;
    return this;
  }

  /**
   * Get salesrepId
   * @return salesrepId
   **/
  @Schema(description = "")
  
    public Integer getSalesrepId() {
    return salesrepId;
  }

  public void setSalesrepId(Integer salesrepId) {
    this.salesrepId = salesrepId;
  }

  public InOut sendemail(Boolean sendemail) {
    this.sendemail = sendemail;
    return this;
  }

  /**
   * Get sendemail
   * @return sendemail
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isSendemail() {
    return sendemail;
  }

  public void setSendemail(Boolean sendemail) {
    this.sendemail = sendemail;
  }

  public InOut shipdate(String shipdate) {
    this.shipdate = shipdate;
    return this;
  }

  /**
   * Get shipdate
   * @return shipdate
   **/
  @Schema(description = "")
  
    public String getShipdate() {
    return shipdate;
  }

  public void setShipdate(String shipdate) {
    this.shipdate = shipdate;
  }

  public InOut trackingno(String trackingno) {
    this.trackingno = trackingno;
    return this;
  }

  /**
   * Get trackingno
   * @return trackingno
   **/
  @Schema(description = "")
  
    public String getTrackingno() {
    return trackingno;
  }

  public void setTrackingno(String trackingno) {
    this.trackingno = trackingno;
  }

  public InOut updated(String updated) {
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

  public InOut updatedby(Integer updatedby) {
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

  public InOut user1Id(Integer user1Id) {
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

  public InOut user2Id(Integer user2Id) {
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

  public InOut additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public InOut addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public InOut referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public InOut addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    InOut inOut = (InOut) o;
    return Objects.equals(this.adClientId, inOut.adClientId) &&
        Objects.equals(this.adOrgId, inOut.adOrgId) &&
        Objects.equals(this.adOrgtrxId, inOut.adOrgtrxId) &&
        Objects.equals(this.adUserId, inOut.adUserId) &&
        Objects.equals(this.cActivityId, inOut.cActivityId) &&
        Objects.equals(this.cai, inOut.cai) &&
        Objects.equals(this.cBpartnerId, inOut.cBpartnerId) &&
        Objects.equals(this.cBpartnerLocationId, inOut.cBpartnerLocationId) &&
        Objects.equals(this.cCampaignId, inOut.cCampaignId) &&
        Objects.equals(this.cChargeId, inOut.cChargeId) &&
        Objects.equals(this.cDoctypeId, inOut.cDoctypeId) &&
        Objects.equals(this.chargeamt, inOut.chargeamt) &&
        Objects.equals(this.cInvoiceId, inOut.cInvoiceId) &&
        Objects.equals(this.clearancenumber, inOut.clearancenumber) &&
        Objects.equals(this.cOrderId, inOut.cOrderId) &&
        Objects.equals(this.cProjectId, inOut.cProjectId) &&
        Objects.equals(this.createconfirm, inOut.createconfirm) &&
        Objects.equals(this.created, inOut.created) &&
        Objects.equals(this.createdby, inOut.createdby) &&
        Objects.equals(this.createfrom, inOut.createfrom) &&
        Objects.equals(this.createpackage, inOut.createpackage) &&
        Objects.equals(this.dateacct, inOut.dateacct) &&
        Objects.equals(this.datecai, inOut.datecai) &&
        Objects.equals(this.dateordered, inOut.dateordered) &&
        Objects.equals(this.dateprinted, inOut.dateprinted) &&
        Objects.equals(this.datereceived, inOut.datereceived) &&
        Objects.equals(this.deliveryrule, inOut.deliveryrule) &&
        Objects.equals(this.deliveryviarule, inOut.deliveryviarule) &&
        Objects.equals(this.description, inOut.description) &&
        Objects.equals(this.docaction, inOut.docaction) &&
        Objects.equals(this.docstatus, inOut.docstatus) &&
        Objects.equals(this.documentno, inOut.documentno) &&
        Objects.equals(this.freightamt, inOut.freightamt) &&
        Objects.equals(this.freightcostrule, inOut.freightcostrule) &&
        Objects.equals(this.generateto, inOut.generateto) &&
        Objects.equals(this.inoutdate, inOut.inoutdate) &&
        Objects.equals(this.inoutreceptiondate, inOut.inoutreceptiondate) &&
        Objects.equals(this.isactive, inOut.isactive) &&
        Objects.equals(this.isapproved, inOut.isapproved) &&
        Objects.equals(this.isindispute, inOut.isindispute) &&
        Objects.equals(this.isintransit, inOut.isintransit) &&
        Objects.equals(this.isprinted, inOut.isprinted) &&
        Objects.equals(this.issotrx, inOut.issotrx) &&
        Objects.equals(this.mInoutId, inOut.mInoutId) &&
        Objects.equals(this.movementdate, inOut.movementdate) &&
        Objects.equals(this.movementtype, inOut.movementtype) &&
        Objects.equals(this.mShipperId, inOut.mShipperId) &&
        Objects.equals(this.mWarehouseId, inOut.mWarehouseId) &&
        Objects.equals(this.nopackages, inOut.nopackages) &&
        Objects.equals(this.pickdate, inOut.pickdate) &&
        Objects.equals(this.poreference, inOut.poreference) &&
        Objects.equals(this.posted, inOut.posted) &&
        Objects.equals(this.preprintedDocno, inOut.preprintedDocno) &&
        Objects.equals(this.printtype, inOut.printtype) &&
        Objects.equals(this.priorityrule, inOut.priorityrule) &&
        Objects.equals(this.processed, inOut.processed) &&
        Objects.equals(this.processing, inOut.processing) &&
        Objects.equals(this.receptiondate, inOut.receptiondate) &&
        Objects.equals(this.refInoutId, inOut.refInoutId) &&
        Objects.equals(this.salesrepId, inOut.salesrepId) &&
        Objects.equals(this.sendemail, inOut.sendemail) &&
        Objects.equals(this.shipdate, inOut.shipdate) &&
        Objects.equals(this.trackingno, inOut.trackingno) &&
        Objects.equals(this.updated, inOut.updated) &&
        Objects.equals(this.updatedby, inOut.updatedby) &&
        Objects.equals(this.user1Id, inOut.user1Id) &&
        Objects.equals(this.user2Id, inOut.user2Id) &&
        Objects.equals(this.additionalvalues, inOut.additionalvalues) &&
        Objects.equals(this.referencedvalues, inOut.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, adOrgtrxId, adUserId, cActivityId, cai, cBpartnerId, cBpartnerLocationId, cCampaignId, cChargeId, cDoctypeId, chargeamt, cInvoiceId, clearancenumber, cOrderId, cProjectId, createconfirm, created, createdby, createfrom, createpackage, dateacct, datecai, dateordered, dateprinted, datereceived, deliveryrule, deliveryviarule, description, docaction, docstatus, documentno, freightamt, freightcostrule, generateto, inoutdate, inoutreceptiondate, isactive, isapproved, isindispute, isintransit, isprinted, issotrx, mInoutId, movementdate, movementtype, mShipperId, mWarehouseId, nopackages, pickdate, poreference, posted, preprintedDocno, printtype, priorityrule, processed, processing, receptiondate, refInoutId, salesrepId, sendemail, shipdate, trackingno, updated, updatedby, user1Id, user2Id, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InOut {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adOrgtrxId: ").append(toIndentedString(adOrgtrxId)).append("\n");
    sb.append("    adUserId: ").append(toIndentedString(adUserId)).append("\n");
    sb.append("    cActivityId: ").append(toIndentedString(cActivityId)).append("\n");
    sb.append("    cai: ").append(toIndentedString(cai)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    cBpartnerLocationId: ").append(toIndentedString(cBpartnerLocationId)).append("\n");
    sb.append("    cCampaignId: ").append(toIndentedString(cCampaignId)).append("\n");
    sb.append("    cChargeId: ").append(toIndentedString(cChargeId)).append("\n");
    sb.append("    cDoctypeId: ").append(toIndentedString(cDoctypeId)).append("\n");
    sb.append("    chargeamt: ").append(toIndentedString(chargeamt)).append("\n");
    sb.append("    cInvoiceId: ").append(toIndentedString(cInvoiceId)).append("\n");
    sb.append("    clearancenumber: ").append(toIndentedString(clearancenumber)).append("\n");
    sb.append("    cOrderId: ").append(toIndentedString(cOrderId)).append("\n");
    sb.append("    cProjectId: ").append(toIndentedString(cProjectId)).append("\n");
    sb.append("    createconfirm: ").append(toIndentedString(createconfirm)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    createfrom: ").append(toIndentedString(createfrom)).append("\n");
    sb.append("    createpackage: ").append(toIndentedString(createpackage)).append("\n");
    sb.append("    dateacct: ").append(toIndentedString(dateacct)).append("\n");
    sb.append("    datecai: ").append(toIndentedString(datecai)).append("\n");
    sb.append("    dateordered: ").append(toIndentedString(dateordered)).append("\n");
    sb.append("    dateprinted: ").append(toIndentedString(dateprinted)).append("\n");
    sb.append("    datereceived: ").append(toIndentedString(datereceived)).append("\n");
    sb.append("    deliveryrule: ").append(toIndentedString(deliveryrule)).append("\n");
    sb.append("    deliveryviarule: ").append(toIndentedString(deliveryviarule)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    docaction: ").append(toIndentedString(docaction)).append("\n");
    sb.append("    docstatus: ").append(toIndentedString(docstatus)).append("\n");
    sb.append("    documentno: ").append(toIndentedString(documentno)).append("\n");
    sb.append("    freightamt: ").append(toIndentedString(freightamt)).append("\n");
    sb.append("    freightcostrule: ").append(toIndentedString(freightcostrule)).append("\n");
    sb.append("    generateto: ").append(toIndentedString(generateto)).append("\n");
    sb.append("    inoutdate: ").append(toIndentedString(inoutdate)).append("\n");
    sb.append("    inoutreceptiondate: ").append(toIndentedString(inoutreceptiondate)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isapproved: ").append(toIndentedString(isapproved)).append("\n");
    sb.append("    isindispute: ").append(toIndentedString(isindispute)).append("\n");
    sb.append("    isintransit: ").append(toIndentedString(isintransit)).append("\n");
    sb.append("    isprinted: ").append(toIndentedString(isprinted)).append("\n");
    sb.append("    issotrx: ").append(toIndentedString(issotrx)).append("\n");
    sb.append("    mInoutId: ").append(toIndentedString(mInoutId)).append("\n");
    sb.append("    movementdate: ").append(toIndentedString(movementdate)).append("\n");
    sb.append("    movementtype: ").append(toIndentedString(movementtype)).append("\n");
    sb.append("    mShipperId: ").append(toIndentedString(mShipperId)).append("\n");
    sb.append("    mWarehouseId: ").append(toIndentedString(mWarehouseId)).append("\n");
    sb.append("    nopackages: ").append(toIndentedString(nopackages)).append("\n");
    sb.append("    pickdate: ").append(toIndentedString(pickdate)).append("\n");
    sb.append("    poreference: ").append(toIndentedString(poreference)).append("\n");
    sb.append("    posted: ").append(toIndentedString(posted)).append("\n");
    sb.append("    preprintedDocno: ").append(toIndentedString(preprintedDocno)).append("\n");
    sb.append("    printtype: ").append(toIndentedString(printtype)).append("\n");
    sb.append("    priorityrule: ").append(toIndentedString(priorityrule)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    processing: ").append(toIndentedString(processing)).append("\n");
    sb.append("    receptiondate: ").append(toIndentedString(receptiondate)).append("\n");
    sb.append("    refInoutId: ").append(toIndentedString(refInoutId)).append("\n");
    sb.append("    salesrepId: ").append(toIndentedString(salesrepId)).append("\n");
    sb.append("    sendemail: ").append(toIndentedString(sendemail)).append("\n");
    sb.append("    shipdate: ").append(toIndentedString(shipdate)).append("\n");
    sb.append("    trackingno: ").append(toIndentedString(trackingno)).append("\n");
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
