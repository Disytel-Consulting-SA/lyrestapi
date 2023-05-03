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
 * Product
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-03T10:38:15.253-03:00[America/Argentina/Buenos_Aires]")
public class Product   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("amortizationperc")
  private BigDecimal amortizationperc = null;

  @JsonProperty("checkoutplace")
  private String checkoutplace = null;

  @JsonProperty("classification")
  private String classification = null;

  @JsonProperty("common_ref")
  private BigDecimal commonRef = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_revenuerecognition_id")
  private Integer cRevenuerecognitionId = null;

  @JsonProperty("c_subscriptiontype_id")
  private Integer cSubscriptiontypeId = null;

  @JsonProperty("c_taxcategory_id")
  private Integer cTaxcategoryId = null;

  @JsonProperty("c_uom_id")
  private Integer cUomId = null;

  @JsonProperty("deliverytime_promised")
  private BigDecimal deliverytimePromised = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("descriptionurl")
  private String descriptionurl = null;

  @JsonProperty("discontinued")
  private Boolean discontinued = null;

  @JsonProperty("discontinuedby")
  private String discontinuedby = null;

  @JsonProperty("documentnote")
  private String documentnote = null;

  @JsonProperty("downloadurl")
  private String downloadurl = null;

  @JsonProperty("guaranteedays")
  private Integer guaranteedays = null;

  @JsonProperty("guaranteedaysmin")
  private Integer guaranteedaysmin = null;

  @JsonProperty("help")
  private String help = null;

  @JsonProperty("imageurl")
  private String imageurl = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isbom")
  private Boolean isbom = null;

  @JsonProperty("isdropship")
  private Boolean isdropship = null;

  @JsonProperty("ishelp")
  private Boolean ishelp = null;

  @JsonProperty("isinventoried")
  private Boolean isinventoried = null;

  @JsonProperty("isinvoiceprintdetails")
  private Boolean isinvoiceprintdetails = null;

  @JsonProperty("ispicklistprintdetails")
  private Boolean ispicklistprintdetails = null;

  @JsonProperty("ispurchased")
  private Boolean ispurchased = null;

  @JsonProperty("isselfservice")
  private Boolean isselfservice = null;

  @JsonProperty("issold")
  private Boolean issold = null;

  @JsonProperty("isstocked")
  private Boolean isstocked = null;

  @JsonProperty("issummary")
  private Boolean issummary = null;

  @JsonProperty("istoformule")
  private Boolean istoformule = null;

  @JsonProperty("isverified")
  private Boolean isverified = null;

  @JsonProperty("iswebstorefeatured")
  private Boolean iswebstorefeatured = null;

  @JsonProperty("lowlevel")
  private Integer lowlevel = null;

  @JsonProperty("marketingblocked")
  private Boolean marketingblocked = null;

  @JsonProperty("marketingblockeddescr")
  private String marketingblockeddescr = null;

  @JsonProperty("m_attributeset_id")
  private Integer mAttributesetId = null;

  @JsonProperty("m_attributesetinstance_id")
  private Integer mAttributesetinstanceId = null;

  @JsonProperty("m_freightcategory_id")
  private Integer mFreightcategoryId = null;

  @JsonProperty("m_intrastatcode_id")
  private BigDecimal mIntrastatcodeId = null;

  @JsonProperty("m_locator_id")
  private Integer mLocatorId = null;

  @JsonProperty("m_product_category_id")
  private Integer mProductCategoryId = null;

  @JsonProperty("m_product_family_id")
  private Integer mProductFamilyId = null;

  @JsonProperty("m_product_id")
  private Integer mProductId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("producttype")
  private String producttype = null;

  @JsonProperty("r_mailtext_id")
  private Integer rMailtextId = null;

  @JsonProperty("sales_order_min")
  private BigDecimal salesOrderMin = null;

  @JsonProperty("sales_order_pack")
  private BigDecimal salesOrderPack = null;

  @JsonProperty("salesrep_id")
  private Integer salesrepId = null;

  @JsonProperty("s_expensetype_id")
  private Integer sExpensetypeId = null;

  @JsonProperty("shelfdepth")
  private Integer shelfdepth = null;

  @JsonProperty("shelfheight")
  private Integer shelfheight = null;

  @JsonProperty("shelfwidth")
  private Integer shelfwidth = null;

  @JsonProperty("sku")
  private String sku = null;

  @JsonProperty("s_resource_id")
  private Integer sResourceId = null;

  @JsonProperty("unitsperpallet")
  private Integer unitsperpallet = null;

  @JsonProperty("upc")
  private String upc = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("versionno")
  private String versionno = null;

  @JsonProperty("volume")
  private BigDecimal volume = null;

  @JsonProperty("weight")
  private BigDecimal weight = null;

  @JsonProperty("yearlife")
  private Integer yearlife = null;

  public Product adClientId(Integer adClientId) {
    this.adClientId = adClientId;
    return this;
  }

  /**
   * Get adClientId
   * @return adClientId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getAdClientId() {
    return adClientId;
  }

  public void setAdClientId(Integer adClientId) {
    this.adClientId = adClientId;
  }

  public Product adComponentobjectuid(String adComponentobjectuid) {
    this.adComponentobjectuid = adComponentobjectuid;
    return this;
  }

  /**
   * Get adComponentobjectuid
   * @return adComponentobjectuid
  **/
  @ApiModelProperty(value = "")
  
    public String getAdComponentobjectuid() {
    return adComponentobjectuid;
  }

  public void setAdComponentobjectuid(String adComponentobjectuid) {
    this.adComponentobjectuid = adComponentobjectuid;
  }

  public Product adOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
    return this;
  }

  /**
   * Get adOrgId
   * @return adOrgId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getAdOrgId() {
    return adOrgId;
  }

  public void setAdOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
  }

  public Product amortizationperc(BigDecimal amortizationperc) {
    this.amortizationperc = amortizationperc;
    return this;
  }

  /**
   * Get amortizationperc
   * @return amortizationperc
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getAmortizationperc() {
    return amortizationperc;
  }

  public void setAmortizationperc(BigDecimal amortizationperc) {
    this.amortizationperc = amortizationperc;
  }

  public Product checkoutplace(String checkoutplace) {
    this.checkoutplace = checkoutplace;
    return this;
  }

  /**
   * Get checkoutplace
   * @return checkoutplace
  **/
  @ApiModelProperty(value = "")
  
    public String getCheckoutplace() {
    return checkoutplace;
  }

  public void setCheckoutplace(String checkoutplace) {
    this.checkoutplace = checkoutplace;
  }

  public Product classification(String classification) {
    this.classification = classification;
    return this;
  }

  /**
   * Get classification
   * @return classification
  **/
  @ApiModelProperty(value = "")
  
    public String getClassification() {
    return classification;
  }

  public void setClassification(String classification) {
    this.classification = classification;
  }

  public Product commonRef(BigDecimal commonRef) {
    this.commonRef = commonRef;
    return this;
  }

  /**
   * Get commonRef
   * @return commonRef
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getCommonRef() {
    return commonRef;
  }

  public void setCommonRef(BigDecimal commonRef) {
    this.commonRef = commonRef;
  }

  public Product created(String created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
  **/
  @ApiModelProperty(value = "")
  
    public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public Product createdby(Integer createdby) {
    this.createdby = createdby;
    return this;
  }

  /**
   * Get createdby
   * @return createdby
  **/
  @ApiModelProperty(value = "")
  
    public Integer getCreatedby() {
    return createdby;
  }

  public void setCreatedby(Integer createdby) {
    this.createdby = createdby;
  }

  public Product cRevenuerecognitionId(Integer cRevenuerecognitionId) {
    this.cRevenuerecognitionId = cRevenuerecognitionId;
    return this;
  }

  /**
   * Get cRevenuerecognitionId
   * @return cRevenuerecognitionId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getCRevenuerecognitionId() {
    return cRevenuerecognitionId;
  }

  public void setCRevenuerecognitionId(Integer cRevenuerecognitionId) {
    this.cRevenuerecognitionId = cRevenuerecognitionId;
  }

  public Product cSubscriptiontypeId(Integer cSubscriptiontypeId) {
    this.cSubscriptiontypeId = cSubscriptiontypeId;
    return this;
  }

  /**
   * Get cSubscriptiontypeId
   * @return cSubscriptiontypeId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getCSubscriptiontypeId() {
    return cSubscriptiontypeId;
  }

  public void setCSubscriptiontypeId(Integer cSubscriptiontypeId) {
    this.cSubscriptiontypeId = cSubscriptiontypeId;
  }

  public Product cTaxcategoryId(Integer cTaxcategoryId) {
    this.cTaxcategoryId = cTaxcategoryId;
    return this;
  }

  /**
   * Get cTaxcategoryId
   * @return cTaxcategoryId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getCTaxcategoryId() {
    return cTaxcategoryId;
  }

  public void setCTaxcategoryId(Integer cTaxcategoryId) {
    this.cTaxcategoryId = cTaxcategoryId;
  }

  public Product cUomId(Integer cUomId) {
    this.cUomId = cUomId;
    return this;
  }

  /**
   * Get cUomId
   * @return cUomId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getCUomId() {
    return cUomId;
  }

  public void setCUomId(Integer cUomId) {
    this.cUomId = cUomId;
  }

  public Product deliverytimePromised(BigDecimal deliverytimePromised) {
    this.deliverytimePromised = deliverytimePromised;
    return this;
  }

  /**
   * Get deliverytimePromised
   * @return deliverytimePromised
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getDeliverytimePromised() {
    return deliverytimePromised;
  }

  public void setDeliverytimePromised(BigDecimal deliverytimePromised) {
    this.deliverytimePromised = deliverytimePromised;
  }

  public Product description(String description) {
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

  public Product descriptionurl(String descriptionurl) {
    this.descriptionurl = descriptionurl;
    return this;
  }

  /**
   * Get descriptionurl
   * @return descriptionurl
  **/
  @ApiModelProperty(value = "")
  
    public String getDescriptionurl() {
    return descriptionurl;
  }

  public void setDescriptionurl(String descriptionurl) {
    this.descriptionurl = descriptionurl;
  }

  public Product discontinued(Boolean discontinued) {
    this.discontinued = discontinued;
    return this;
  }

  /**
   * Get discontinued
   * @return discontinued
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isDiscontinued() {
    return discontinued;
  }

  public void setDiscontinued(Boolean discontinued) {
    this.discontinued = discontinued;
  }

  public Product discontinuedby(String discontinuedby) {
    this.discontinuedby = discontinuedby;
    return this;
  }

  /**
   * Get discontinuedby
   * @return discontinuedby
  **/
  @ApiModelProperty(value = "")
  
    public String getDiscontinuedby() {
    return discontinuedby;
  }

  public void setDiscontinuedby(String discontinuedby) {
    this.discontinuedby = discontinuedby;
  }

  public Product documentnote(String documentnote) {
    this.documentnote = documentnote;
    return this;
  }

  /**
   * Get documentnote
   * @return documentnote
  **/
  @ApiModelProperty(value = "")
  
    public String getDocumentnote() {
    return documentnote;
  }

  public void setDocumentnote(String documentnote) {
    this.documentnote = documentnote;
  }

  public Product downloadurl(String downloadurl) {
    this.downloadurl = downloadurl;
    return this;
  }

  /**
   * Get downloadurl
   * @return downloadurl
  **/
  @ApiModelProperty(value = "")
  
    public String getDownloadurl() {
    return downloadurl;
  }

  public void setDownloadurl(String downloadurl) {
    this.downloadurl = downloadurl;
  }

  public Product guaranteedays(Integer guaranteedays) {
    this.guaranteedays = guaranteedays;
    return this;
  }

  /**
   * Get guaranteedays
   * @return guaranteedays
  **/
  @ApiModelProperty(value = "")
  
    public Integer getGuaranteedays() {
    return guaranteedays;
  }

  public void setGuaranteedays(Integer guaranteedays) {
    this.guaranteedays = guaranteedays;
  }

  public Product guaranteedaysmin(Integer guaranteedaysmin) {
    this.guaranteedaysmin = guaranteedaysmin;
    return this;
  }

  /**
   * Get guaranteedaysmin
   * @return guaranteedaysmin
  **/
  @ApiModelProperty(value = "")
  
    public Integer getGuaranteedaysmin() {
    return guaranteedaysmin;
  }

  public void setGuaranteedaysmin(Integer guaranteedaysmin) {
    this.guaranteedaysmin = guaranteedaysmin;
  }

  public Product help(String help) {
    this.help = help;
    return this;
  }

  /**
   * Get help
   * @return help
  **/
  @ApiModelProperty(value = "")
  
    public String getHelp() {
    return help;
  }

  public void setHelp(String help) {
    this.help = help;
  }

  public Product imageurl(String imageurl) {
    this.imageurl = imageurl;
    return this;
  }

  /**
   * Get imageurl
   * @return imageurl
  **/
  @ApiModelProperty(value = "")
  
    public String getImageurl() {
    return imageurl;
  }

  public void setImageurl(String imageurl) {
    this.imageurl = imageurl;
  }

  public Product isactive(Boolean isactive) {
    this.isactive = isactive;
    return this;
  }

  /**
   * Get isactive
   * @return isactive
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIsactive() {
    return isactive;
  }

  public void setIsactive(Boolean isactive) {
    this.isactive = isactive;
  }

  public Product isbom(Boolean isbom) {
    this.isbom = isbom;
    return this;
  }

  /**
   * Get isbom
   * @return isbom
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIsbom() {
    return isbom;
  }

  public void setIsbom(Boolean isbom) {
    this.isbom = isbom;
  }

  public Product isdropship(Boolean isdropship) {
    this.isdropship = isdropship;
    return this;
  }

  /**
   * Get isdropship
   * @return isdropship
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIsdropship() {
    return isdropship;
  }

  public void setIsdropship(Boolean isdropship) {
    this.isdropship = isdropship;
  }

  public Product ishelp(Boolean ishelp) {
    this.ishelp = ishelp;
    return this;
  }

  /**
   * Get ishelp
   * @return ishelp
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIshelp() {
    return ishelp;
  }

  public void setIshelp(Boolean ishelp) {
    this.ishelp = ishelp;
  }

  public Product isinventoried(Boolean isinventoried) {
    this.isinventoried = isinventoried;
    return this;
  }

  /**
   * Get isinventoried
   * @return isinventoried
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIsinventoried() {
    return isinventoried;
  }

  public void setIsinventoried(Boolean isinventoried) {
    this.isinventoried = isinventoried;
  }

  public Product isinvoiceprintdetails(Boolean isinvoiceprintdetails) {
    this.isinvoiceprintdetails = isinvoiceprintdetails;
    return this;
  }

  /**
   * Get isinvoiceprintdetails
   * @return isinvoiceprintdetails
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIsinvoiceprintdetails() {
    return isinvoiceprintdetails;
  }

  public void setIsinvoiceprintdetails(Boolean isinvoiceprintdetails) {
    this.isinvoiceprintdetails = isinvoiceprintdetails;
  }

  public Product ispicklistprintdetails(Boolean ispicklistprintdetails) {
    this.ispicklistprintdetails = ispicklistprintdetails;
    return this;
  }

  /**
   * Get ispicklistprintdetails
   * @return ispicklistprintdetails
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIspicklistprintdetails() {
    return ispicklistprintdetails;
  }

  public void setIspicklistprintdetails(Boolean ispicklistprintdetails) {
    this.ispicklistprintdetails = ispicklistprintdetails;
  }

  public Product ispurchased(Boolean ispurchased) {
    this.ispurchased = ispurchased;
    return this;
  }

  /**
   * Get ispurchased
   * @return ispurchased
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIspurchased() {
    return ispurchased;
  }

  public void setIspurchased(Boolean ispurchased) {
    this.ispurchased = ispurchased;
  }

  public Product isselfservice(Boolean isselfservice) {
    this.isselfservice = isselfservice;
    return this;
  }

  /**
   * Get isselfservice
   * @return isselfservice
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIsselfservice() {
    return isselfservice;
  }

  public void setIsselfservice(Boolean isselfservice) {
    this.isselfservice = isselfservice;
  }

  public Product issold(Boolean issold) {
    this.issold = issold;
    return this;
  }

  /**
   * Get issold
   * @return issold
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIssold() {
    return issold;
  }

  public void setIssold(Boolean issold) {
    this.issold = issold;
  }

  public Product isstocked(Boolean isstocked) {
    this.isstocked = isstocked;
    return this;
  }

  /**
   * Get isstocked
   * @return isstocked
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIsstocked() {
    return isstocked;
  }

  public void setIsstocked(Boolean isstocked) {
    this.isstocked = isstocked;
  }

  public Product issummary(Boolean issummary) {
    this.issummary = issummary;
    return this;
  }

  /**
   * Get issummary
   * @return issummary
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIssummary() {
    return issummary;
  }

  public void setIssummary(Boolean issummary) {
    this.issummary = issummary;
  }

  public Product istoformule(Boolean istoformule) {
    this.istoformule = istoformule;
    return this;
  }

  /**
   * Get istoformule
   * @return istoformule
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIstoformule() {
    return istoformule;
  }

  public void setIstoformule(Boolean istoformule) {
    this.istoformule = istoformule;
  }

  public Product isverified(Boolean isverified) {
    this.isverified = isverified;
    return this;
  }

  /**
   * Get isverified
   * @return isverified
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIsverified() {
    return isverified;
  }

  public void setIsverified(Boolean isverified) {
    this.isverified = isverified;
  }

  public Product iswebstorefeatured(Boolean iswebstorefeatured) {
    this.iswebstorefeatured = iswebstorefeatured;
    return this;
  }

  /**
   * Get iswebstorefeatured
   * @return iswebstorefeatured
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIswebstorefeatured() {
    return iswebstorefeatured;
  }

  public void setIswebstorefeatured(Boolean iswebstorefeatured) {
    this.iswebstorefeatured = iswebstorefeatured;
  }

  public Product lowlevel(Integer lowlevel) {
    this.lowlevel = lowlevel;
    return this;
  }

  /**
   * Get lowlevel
   * @return lowlevel
  **/
  @ApiModelProperty(value = "")
  
    public Integer getLowlevel() {
    return lowlevel;
  }

  public void setLowlevel(Integer lowlevel) {
    this.lowlevel = lowlevel;
  }

  public Product marketingblocked(Boolean marketingblocked) {
    this.marketingblocked = marketingblocked;
    return this;
  }

  /**
   * Get marketingblocked
   * @return marketingblocked
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isMarketingblocked() {
    return marketingblocked;
  }

  public void setMarketingblocked(Boolean marketingblocked) {
    this.marketingblocked = marketingblocked;
  }

  public Product marketingblockeddescr(String marketingblockeddescr) {
    this.marketingblockeddescr = marketingblockeddescr;
    return this;
  }

  /**
   * Get marketingblockeddescr
   * @return marketingblockeddescr
  **/
  @ApiModelProperty(value = "")
  
    public String getMarketingblockeddescr() {
    return marketingblockeddescr;
  }

  public void setMarketingblockeddescr(String marketingblockeddescr) {
    this.marketingblockeddescr = marketingblockeddescr;
  }

  public Product mAttributesetId(Integer mAttributesetId) {
    this.mAttributesetId = mAttributesetId;
    return this;
  }

  /**
   * Get mAttributesetId
   * @return mAttributesetId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getMAttributesetId() {
    return mAttributesetId;
  }

  public void setMAttributesetId(Integer mAttributesetId) {
    this.mAttributesetId = mAttributesetId;
  }

  public Product mAttributesetinstanceId(Integer mAttributesetinstanceId) {
    this.mAttributesetinstanceId = mAttributesetinstanceId;
    return this;
  }

  /**
   * Get mAttributesetinstanceId
   * @return mAttributesetinstanceId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getMAttributesetinstanceId() {
    return mAttributesetinstanceId;
  }

  public void setMAttributesetinstanceId(Integer mAttributesetinstanceId) {
    this.mAttributesetinstanceId = mAttributesetinstanceId;
  }

  public Product mFreightcategoryId(Integer mFreightcategoryId) {
    this.mFreightcategoryId = mFreightcategoryId;
    return this;
  }

  /**
   * Get mFreightcategoryId
   * @return mFreightcategoryId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getMFreightcategoryId() {
    return mFreightcategoryId;
  }

  public void setMFreightcategoryId(Integer mFreightcategoryId) {
    this.mFreightcategoryId = mFreightcategoryId;
  }

  public Product mIntrastatcodeId(BigDecimal mIntrastatcodeId) {
    this.mIntrastatcodeId = mIntrastatcodeId;
    return this;
  }

  /**
   * Get mIntrastatcodeId
   * @return mIntrastatcodeId
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getMIntrastatcodeId() {
    return mIntrastatcodeId;
  }

  public void setMIntrastatcodeId(BigDecimal mIntrastatcodeId) {
    this.mIntrastatcodeId = mIntrastatcodeId;
  }

  public Product mLocatorId(Integer mLocatorId) {
    this.mLocatorId = mLocatorId;
    return this;
  }

  /**
   * Get mLocatorId
   * @return mLocatorId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getMLocatorId() {
    return mLocatorId;
  }

  public void setMLocatorId(Integer mLocatorId) {
    this.mLocatorId = mLocatorId;
  }

  public Product mProductCategoryId(Integer mProductCategoryId) {
    this.mProductCategoryId = mProductCategoryId;
    return this;
  }

  /**
   * Get mProductCategoryId
   * @return mProductCategoryId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getMProductCategoryId() {
    return mProductCategoryId;
  }

  public void setMProductCategoryId(Integer mProductCategoryId) {
    this.mProductCategoryId = mProductCategoryId;
  }

  public Product mProductFamilyId(Integer mProductFamilyId) {
    this.mProductFamilyId = mProductFamilyId;
    return this;
  }

  /**
   * Get mProductFamilyId
   * @return mProductFamilyId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getMProductFamilyId() {
    return mProductFamilyId;
  }

  public void setMProductFamilyId(Integer mProductFamilyId) {
    this.mProductFamilyId = mProductFamilyId;
  }

  public Product mProductId(Integer mProductId) {
    this.mProductId = mProductId;
    return this;
  }

  /**
   * Get mProductId
   * @return mProductId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getMProductId() {
    return mProductId;
  }

  public void setMProductId(Integer mProductId) {
    this.mProductId = mProductId;
  }

  public Product name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Product producttype(String producttype) {
    this.producttype = producttype;
    return this;
  }

  /**
   * Get producttype
   * @return producttype
  **/
  @ApiModelProperty(value = "")
  
    public String getProducttype() {
    return producttype;
  }

  public void setProducttype(String producttype) {
    this.producttype = producttype;
  }

  public Product rMailtextId(Integer rMailtextId) {
    this.rMailtextId = rMailtextId;
    return this;
  }

  /**
   * Get rMailtextId
   * @return rMailtextId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getRMailtextId() {
    return rMailtextId;
  }

  public void setRMailtextId(Integer rMailtextId) {
    this.rMailtextId = rMailtextId;
  }

  public Product salesOrderMin(BigDecimal salesOrderMin) {
    this.salesOrderMin = salesOrderMin;
    return this;
  }

  /**
   * Get salesOrderMin
   * @return salesOrderMin
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getSalesOrderMin() {
    return salesOrderMin;
  }

  public void setSalesOrderMin(BigDecimal salesOrderMin) {
    this.salesOrderMin = salesOrderMin;
  }

  public Product salesOrderPack(BigDecimal salesOrderPack) {
    this.salesOrderPack = salesOrderPack;
    return this;
  }

  /**
   * Get salesOrderPack
   * @return salesOrderPack
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getSalesOrderPack() {
    return salesOrderPack;
  }

  public void setSalesOrderPack(BigDecimal salesOrderPack) {
    this.salesOrderPack = salesOrderPack;
  }

  public Product salesrepId(Integer salesrepId) {
    this.salesrepId = salesrepId;
    return this;
  }

  /**
   * Get salesrepId
   * @return salesrepId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getSalesrepId() {
    return salesrepId;
  }

  public void setSalesrepId(Integer salesrepId) {
    this.salesrepId = salesrepId;
  }

  public Product sExpensetypeId(Integer sExpensetypeId) {
    this.sExpensetypeId = sExpensetypeId;
    return this;
  }

  /**
   * Get sExpensetypeId
   * @return sExpensetypeId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getSExpensetypeId() {
    return sExpensetypeId;
  }

  public void setSExpensetypeId(Integer sExpensetypeId) {
    this.sExpensetypeId = sExpensetypeId;
  }

  public Product shelfdepth(Integer shelfdepth) {
    this.shelfdepth = shelfdepth;
    return this;
  }

  /**
   * Get shelfdepth
   * @return shelfdepth
  **/
  @ApiModelProperty(value = "")
  
    public Integer getShelfdepth() {
    return shelfdepth;
  }

  public void setShelfdepth(Integer shelfdepth) {
    this.shelfdepth = shelfdepth;
  }

  public Product shelfheight(Integer shelfheight) {
    this.shelfheight = shelfheight;
    return this;
  }

  /**
   * Get shelfheight
   * @return shelfheight
  **/
  @ApiModelProperty(value = "")
  
    public Integer getShelfheight() {
    return shelfheight;
  }

  public void setShelfheight(Integer shelfheight) {
    this.shelfheight = shelfheight;
  }

  public Product shelfwidth(Integer shelfwidth) {
    this.shelfwidth = shelfwidth;
    return this;
  }

  /**
   * Get shelfwidth
   * @return shelfwidth
  **/
  @ApiModelProperty(value = "")
  
    public Integer getShelfwidth() {
    return shelfwidth;
  }

  public void setShelfwidth(Integer shelfwidth) {
    this.shelfwidth = shelfwidth;
  }

  public Product sku(String sku) {
    this.sku = sku;
    return this;
  }

  /**
   * Get sku
   * @return sku
  **/
  @ApiModelProperty(value = "")
  
    public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public Product sResourceId(Integer sResourceId) {
    this.sResourceId = sResourceId;
    return this;
  }

  /**
   * Get sResourceId
   * @return sResourceId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getSResourceId() {
    return sResourceId;
  }

  public void setSResourceId(Integer sResourceId) {
    this.sResourceId = sResourceId;
  }

  public Product unitsperpallet(Integer unitsperpallet) {
    this.unitsperpallet = unitsperpallet;
    return this;
  }

  /**
   * Get unitsperpallet
   * @return unitsperpallet
  **/
  @ApiModelProperty(value = "")
  
    public Integer getUnitsperpallet() {
    return unitsperpallet;
  }

  public void setUnitsperpallet(Integer unitsperpallet) {
    this.unitsperpallet = unitsperpallet;
  }

  public Product upc(String upc) {
    this.upc = upc;
    return this;
  }

  /**
   * Get upc
   * @return upc
  **/
  @ApiModelProperty(value = "")
  
    public String getUpc() {
    return upc;
  }

  public void setUpc(String upc) {
    this.upc = upc;
  }

  public Product updated(String updated) {
    this.updated = updated;
    return this;
  }

  /**
   * Get updated
   * @return updated
  **/
  @ApiModelProperty(value = "")
  
    public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  public Product updatedby(Integer updatedby) {
    this.updatedby = updatedby;
    return this;
  }

  /**
   * Get updatedby
   * @return updatedby
  **/
  @ApiModelProperty(value = "")
  
    public Integer getUpdatedby() {
    return updatedby;
  }

  public void setUpdatedby(Integer updatedby) {
    this.updatedby = updatedby;
  }

  public Product value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")
  
    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Product versionno(String versionno) {
    this.versionno = versionno;
    return this;
  }

  /**
   * Get versionno
   * @return versionno
  **/
  @ApiModelProperty(value = "")
  
    public String getVersionno() {
    return versionno;
  }

  public void setVersionno(String versionno) {
    this.versionno = versionno;
  }

  public Product volume(BigDecimal volume) {
    this.volume = volume;
    return this;
  }

  /**
   * Get volume
   * @return volume
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getVolume() {
    return volume;
  }

  public void setVolume(BigDecimal volume) {
    this.volume = volume;
  }

  public Product weight(BigDecimal weight) {
    this.weight = weight;
    return this;
  }

  /**
   * Get weight
   * @return weight
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getWeight() {
    return weight;
  }

  public void setWeight(BigDecimal weight) {
    this.weight = weight;
  }

  public Product yearlife(Integer yearlife) {
    this.yearlife = yearlife;
    return this;
  }

  /**
   * Get yearlife
   * @return yearlife
  **/
  @ApiModelProperty(value = "")
  
    public Integer getYearlife() {
    return yearlife;
  }

  public void setYearlife(Integer yearlife) {
    this.yearlife = yearlife;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.adClientId, product.adClientId) &&
        Objects.equals(this.adComponentobjectuid, product.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, product.adOrgId) &&
        Objects.equals(this.amortizationperc, product.amortizationperc) &&
        Objects.equals(this.checkoutplace, product.checkoutplace) &&
        Objects.equals(this.classification, product.classification) &&
        Objects.equals(this.commonRef, product.commonRef) &&
        Objects.equals(this.created, product.created) &&
        Objects.equals(this.createdby, product.createdby) &&
        Objects.equals(this.cRevenuerecognitionId, product.cRevenuerecognitionId) &&
        Objects.equals(this.cSubscriptiontypeId, product.cSubscriptiontypeId) &&
        Objects.equals(this.cTaxcategoryId, product.cTaxcategoryId) &&
        Objects.equals(this.cUomId, product.cUomId) &&
        Objects.equals(this.deliverytimePromised, product.deliverytimePromised) &&
        Objects.equals(this.description, product.description) &&
        Objects.equals(this.descriptionurl, product.descriptionurl) &&
        Objects.equals(this.discontinued, product.discontinued) &&
        Objects.equals(this.discontinuedby, product.discontinuedby) &&
        Objects.equals(this.documentnote, product.documentnote) &&
        Objects.equals(this.downloadurl, product.downloadurl) &&
        Objects.equals(this.guaranteedays, product.guaranteedays) &&
        Objects.equals(this.guaranteedaysmin, product.guaranteedaysmin) &&
        Objects.equals(this.help, product.help) &&
        Objects.equals(this.imageurl, product.imageurl) &&
        Objects.equals(this.isactive, product.isactive) &&
        Objects.equals(this.isbom, product.isbom) &&
        Objects.equals(this.isdropship, product.isdropship) &&
        Objects.equals(this.ishelp, product.ishelp) &&
        Objects.equals(this.isinventoried, product.isinventoried) &&
        Objects.equals(this.isinvoiceprintdetails, product.isinvoiceprintdetails) &&
        Objects.equals(this.ispicklistprintdetails, product.ispicklistprintdetails) &&
        Objects.equals(this.ispurchased, product.ispurchased) &&
        Objects.equals(this.isselfservice, product.isselfservice) &&
        Objects.equals(this.issold, product.issold) &&
        Objects.equals(this.isstocked, product.isstocked) &&
        Objects.equals(this.issummary, product.issummary) &&
        Objects.equals(this.istoformule, product.istoformule) &&
        Objects.equals(this.isverified, product.isverified) &&
        Objects.equals(this.iswebstorefeatured, product.iswebstorefeatured) &&
        Objects.equals(this.lowlevel, product.lowlevel) &&
        Objects.equals(this.marketingblocked, product.marketingblocked) &&
        Objects.equals(this.marketingblockeddescr, product.marketingblockeddescr) &&
        Objects.equals(this.mAttributesetId, product.mAttributesetId) &&
        Objects.equals(this.mAttributesetinstanceId, product.mAttributesetinstanceId) &&
        Objects.equals(this.mFreightcategoryId, product.mFreightcategoryId) &&
        Objects.equals(this.mIntrastatcodeId, product.mIntrastatcodeId) &&
        Objects.equals(this.mLocatorId, product.mLocatorId) &&
        Objects.equals(this.mProductCategoryId, product.mProductCategoryId) &&
        Objects.equals(this.mProductFamilyId, product.mProductFamilyId) &&
        Objects.equals(this.mProductId, product.mProductId) &&
        Objects.equals(this.name, product.name) &&
        Objects.equals(this.producttype, product.producttype) &&
        Objects.equals(this.rMailtextId, product.rMailtextId) &&
        Objects.equals(this.salesOrderMin, product.salesOrderMin) &&
        Objects.equals(this.salesOrderPack, product.salesOrderPack) &&
        Objects.equals(this.salesrepId, product.salesrepId) &&
        Objects.equals(this.sExpensetypeId, product.sExpensetypeId) &&
        Objects.equals(this.shelfdepth, product.shelfdepth) &&
        Objects.equals(this.shelfheight, product.shelfheight) &&
        Objects.equals(this.shelfwidth, product.shelfwidth) &&
        Objects.equals(this.sku, product.sku) &&
        Objects.equals(this.sResourceId, product.sResourceId) &&
        Objects.equals(this.unitsperpallet, product.unitsperpallet) &&
        Objects.equals(this.upc, product.upc) &&
        Objects.equals(this.updated, product.updated) &&
        Objects.equals(this.updatedby, product.updatedby) &&
        Objects.equals(this.value, product.value) &&
        Objects.equals(this.versionno, product.versionno) &&
        Objects.equals(this.volume, product.volume) &&
        Objects.equals(this.weight, product.weight) &&
        Objects.equals(this.yearlife, product.yearlife);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adOrgId, amortizationperc, checkoutplace, classification, commonRef, created, createdby, cRevenuerecognitionId, cSubscriptiontypeId, cTaxcategoryId, cUomId, deliverytimePromised, description, descriptionurl, discontinued, discontinuedby, documentnote, downloadurl, guaranteedays, guaranteedaysmin, help, imageurl, isactive, isbom, isdropship, ishelp, isinventoried, isinvoiceprintdetails, ispicklistprintdetails, ispurchased, isselfservice, issold, isstocked, issummary, istoformule, isverified, iswebstorefeatured, lowlevel, marketingblocked, marketingblockeddescr, mAttributesetId, mAttributesetinstanceId, mFreightcategoryId, mIntrastatcodeId, mLocatorId, mProductCategoryId, mProductFamilyId, mProductId, name, producttype, rMailtextId, salesOrderMin, salesOrderPack, salesrepId, sExpensetypeId, shelfdepth, shelfheight, shelfwidth, sku, sResourceId, unitsperpallet, upc, updated, updatedby, value, versionno, volume, weight, yearlife);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    amortizationperc: ").append(toIndentedString(amortizationperc)).append("\n");
    sb.append("    checkoutplace: ").append(toIndentedString(checkoutplace)).append("\n");
    sb.append("    classification: ").append(toIndentedString(classification)).append("\n");
    sb.append("    commonRef: ").append(toIndentedString(commonRef)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cRevenuerecognitionId: ").append(toIndentedString(cRevenuerecognitionId)).append("\n");
    sb.append("    cSubscriptiontypeId: ").append(toIndentedString(cSubscriptiontypeId)).append("\n");
    sb.append("    cTaxcategoryId: ").append(toIndentedString(cTaxcategoryId)).append("\n");
    sb.append("    cUomId: ").append(toIndentedString(cUomId)).append("\n");
    sb.append("    deliverytimePromised: ").append(toIndentedString(deliverytimePromised)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    descriptionurl: ").append(toIndentedString(descriptionurl)).append("\n");
    sb.append("    discontinued: ").append(toIndentedString(discontinued)).append("\n");
    sb.append("    discontinuedby: ").append(toIndentedString(discontinuedby)).append("\n");
    sb.append("    documentnote: ").append(toIndentedString(documentnote)).append("\n");
    sb.append("    downloadurl: ").append(toIndentedString(downloadurl)).append("\n");
    sb.append("    guaranteedays: ").append(toIndentedString(guaranteedays)).append("\n");
    sb.append("    guaranteedaysmin: ").append(toIndentedString(guaranteedaysmin)).append("\n");
    sb.append("    help: ").append(toIndentedString(help)).append("\n");
    sb.append("    imageurl: ").append(toIndentedString(imageurl)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isbom: ").append(toIndentedString(isbom)).append("\n");
    sb.append("    isdropship: ").append(toIndentedString(isdropship)).append("\n");
    sb.append("    ishelp: ").append(toIndentedString(ishelp)).append("\n");
    sb.append("    isinventoried: ").append(toIndentedString(isinventoried)).append("\n");
    sb.append("    isinvoiceprintdetails: ").append(toIndentedString(isinvoiceprintdetails)).append("\n");
    sb.append("    ispicklistprintdetails: ").append(toIndentedString(ispicklistprintdetails)).append("\n");
    sb.append("    ispurchased: ").append(toIndentedString(ispurchased)).append("\n");
    sb.append("    isselfservice: ").append(toIndentedString(isselfservice)).append("\n");
    sb.append("    issold: ").append(toIndentedString(issold)).append("\n");
    sb.append("    isstocked: ").append(toIndentedString(isstocked)).append("\n");
    sb.append("    issummary: ").append(toIndentedString(issummary)).append("\n");
    sb.append("    istoformule: ").append(toIndentedString(istoformule)).append("\n");
    sb.append("    isverified: ").append(toIndentedString(isverified)).append("\n");
    sb.append("    iswebstorefeatured: ").append(toIndentedString(iswebstorefeatured)).append("\n");
    sb.append("    lowlevel: ").append(toIndentedString(lowlevel)).append("\n");
    sb.append("    marketingblocked: ").append(toIndentedString(marketingblocked)).append("\n");
    sb.append("    marketingblockeddescr: ").append(toIndentedString(marketingblockeddescr)).append("\n");
    sb.append("    mAttributesetId: ").append(toIndentedString(mAttributesetId)).append("\n");
    sb.append("    mAttributesetinstanceId: ").append(toIndentedString(mAttributesetinstanceId)).append("\n");
    sb.append("    mFreightcategoryId: ").append(toIndentedString(mFreightcategoryId)).append("\n");
    sb.append("    mIntrastatcodeId: ").append(toIndentedString(mIntrastatcodeId)).append("\n");
    sb.append("    mLocatorId: ").append(toIndentedString(mLocatorId)).append("\n");
    sb.append("    mProductCategoryId: ").append(toIndentedString(mProductCategoryId)).append("\n");
    sb.append("    mProductFamilyId: ").append(toIndentedString(mProductFamilyId)).append("\n");
    sb.append("    mProductId: ").append(toIndentedString(mProductId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    producttype: ").append(toIndentedString(producttype)).append("\n");
    sb.append("    rMailtextId: ").append(toIndentedString(rMailtextId)).append("\n");
    sb.append("    salesOrderMin: ").append(toIndentedString(salesOrderMin)).append("\n");
    sb.append("    salesOrderPack: ").append(toIndentedString(salesOrderPack)).append("\n");
    sb.append("    salesrepId: ").append(toIndentedString(salesrepId)).append("\n");
    sb.append("    sExpensetypeId: ").append(toIndentedString(sExpensetypeId)).append("\n");
    sb.append("    shelfdepth: ").append(toIndentedString(shelfdepth)).append("\n");
    sb.append("    shelfheight: ").append(toIndentedString(shelfheight)).append("\n");
    sb.append("    shelfwidth: ").append(toIndentedString(shelfwidth)).append("\n");
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
    sb.append("    sResourceId: ").append(toIndentedString(sResourceId)).append("\n");
    sb.append("    unitsperpallet: ").append(toIndentedString(unitsperpallet)).append("\n");
    sb.append("    upc: ").append(toIndentedString(upc)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    versionno: ").append(toIndentedString(versionno)).append("\n");
    sb.append("    volume: ").append(toIndentedString(volume)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    yearlife: ").append(toIndentedString(yearlife)).append("\n");
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
