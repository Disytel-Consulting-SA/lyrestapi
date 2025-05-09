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
 * PaymentTerm
 */
@Validated



public class PaymentTerm   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("afterdelivery")
  private Boolean afterdelivery = null;

  @JsonProperty("applicationcontext")
  private String applicationcontext = null;

  @JsonProperty("applicationdate")
  private String applicationdate = null;

  @JsonProperty("c_paymentterm_id")
  private Integer cPaymenttermId = null;

  @JsonProperty("c_pospaymentmedium_id")
  private Integer cPospaymentmediumId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("discount")
  private BigDecimal discount = null;

  @JsonProperty("discount2")
  private BigDecimal discount2 = null;

  @JsonProperty("discountapplicationtype")
  private String discountapplicationtype = null;

  @JsonProperty("discountapplicationtype2")
  private String discountapplicationtype2 = null;

  @JsonProperty("discountdays")
  private Integer discountdays = null;

  @JsonProperty("discountdays2")
  private Integer discountdays2 = null;

  @JsonProperty("documentnote")
  private String documentnote = null;

  @JsonProperty("fixmonthcutoff")
  private Integer fixmonthcutoff = null;

  @JsonProperty("fixmonthday")
  private Integer fixmonthday = null;

  @JsonProperty("fixmonthday2")
  private Integer fixmonthday2 = null;

  @JsonProperty("fixmonthoffset")
  private Integer fixmonthoffset = null;

  @JsonProperty("gracedays")
  private Integer gracedays = null;

  @JsonProperty("gracedays2")
  private Integer gracedays2 = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isdefault")
  private Boolean isdefault = null;

  @JsonProperty("isduefixed")
  private Boolean isduefixed = null;

  @JsonProperty("isnextbusinessday")
  private Boolean isnextbusinessday = null;

  @JsonProperty("isvalid")
  private Boolean isvalid = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("netday")
  private String netday = null;

  @JsonProperty("netdays")
  private Integer netdays = null;

  @JsonProperty("processing")
  private String processing = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public PaymentTerm adClientId(Integer adClientId) {
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

  public PaymentTerm adComponentobjectuid(String adComponentobjectuid) {
    this.adComponentobjectuid = adComponentobjectuid;
    return this;
  }

  /**
   * Get adComponentobjectuid
   * @return adComponentobjectuid
   **/
  @Schema(description = "")
  
    public String getAdComponentobjectuid() {
    return adComponentobjectuid;
  }

  public void setAdComponentobjectuid(String adComponentobjectuid) {
    this.adComponentobjectuid = adComponentobjectuid;
  }

  public PaymentTerm adOrgId(Integer adOrgId) {
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

  public PaymentTerm afterdelivery(Boolean afterdelivery) {
    this.afterdelivery = afterdelivery;
    return this;
  }

  /**
   * Get afterdelivery
   * @return afterdelivery
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isAfterdelivery() {
    return afterdelivery;
  }

  public void setAfterdelivery(Boolean afterdelivery) {
    this.afterdelivery = afterdelivery;
  }

  public PaymentTerm applicationcontext(String applicationcontext) {
    this.applicationcontext = applicationcontext;
    return this;
  }

  /**
   * Get applicationcontext
   * @return applicationcontext
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getApplicationcontext() {
    return applicationcontext;
  }

  public void setApplicationcontext(String applicationcontext) {
    this.applicationcontext = applicationcontext;
  }

  public PaymentTerm applicationdate(String applicationdate) {
    this.applicationdate = applicationdate;
    return this;
  }

  /**
   * Get applicationdate
   * @return applicationdate
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getApplicationdate() {
    return applicationdate;
  }

  public void setApplicationdate(String applicationdate) {
    this.applicationdate = applicationdate;
  }

  public PaymentTerm cPaymenttermId(Integer cPaymenttermId) {
    this.cPaymenttermId = cPaymenttermId;
    return this;
  }

  /**
   * Get cPaymenttermId
   * @return cPaymenttermId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCPaymenttermId() {
    return cPaymenttermId;
  }

  public void setCPaymenttermId(Integer cPaymenttermId) {
    this.cPaymenttermId = cPaymenttermId;
  }

  public PaymentTerm cPospaymentmediumId(Integer cPospaymentmediumId) {
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

  public PaymentTerm created(String created) {
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

  public PaymentTerm createdby(Integer createdby) {
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

  public PaymentTerm description(String description) {
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

  public PaymentTerm discount(BigDecimal discount) {
    this.discount = discount;
    return this;
  }

  /**
   * Get discount
   * @return discount
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getDiscount() {
    return discount;
  }

  public void setDiscount(BigDecimal discount) {
    this.discount = discount;
  }

  public PaymentTerm discount2(BigDecimal discount2) {
    this.discount2 = discount2;
    return this;
  }

  /**
   * Get discount2
   * @return discount2
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getDiscount2() {
    return discount2;
  }

  public void setDiscount2(BigDecimal discount2) {
    this.discount2 = discount2;
  }

  public PaymentTerm discountapplicationtype(String discountapplicationtype) {
    this.discountapplicationtype = discountapplicationtype;
    return this;
  }

  /**
   * Get discountapplicationtype
   * @return discountapplicationtype
   **/
  @Schema(description = "")
  
    public String getDiscountapplicationtype() {
    return discountapplicationtype;
  }

  public void setDiscountapplicationtype(String discountapplicationtype) {
    this.discountapplicationtype = discountapplicationtype;
  }

  public PaymentTerm discountapplicationtype2(String discountapplicationtype2) {
    this.discountapplicationtype2 = discountapplicationtype2;
    return this;
  }

  /**
   * Get discountapplicationtype2
   * @return discountapplicationtype2
   **/
  @Schema(description = "")
  
    public String getDiscountapplicationtype2() {
    return discountapplicationtype2;
  }

  public void setDiscountapplicationtype2(String discountapplicationtype2) {
    this.discountapplicationtype2 = discountapplicationtype2;
  }

  public PaymentTerm discountdays(Integer discountdays) {
    this.discountdays = discountdays;
    return this;
  }

  /**
   * Get discountdays
   * @return discountdays
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getDiscountdays() {
    return discountdays;
  }

  public void setDiscountdays(Integer discountdays) {
    this.discountdays = discountdays;
  }

  public PaymentTerm discountdays2(Integer discountdays2) {
    this.discountdays2 = discountdays2;
    return this;
  }

  /**
   * Get discountdays2
   * @return discountdays2
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getDiscountdays2() {
    return discountdays2;
  }

  public void setDiscountdays2(Integer discountdays2) {
    this.discountdays2 = discountdays2;
  }

  public PaymentTerm documentnote(String documentnote) {
    this.documentnote = documentnote;
    return this;
  }

  /**
   * Get documentnote
   * @return documentnote
   **/
  @Schema(description = "")
  
    public String getDocumentnote() {
    return documentnote;
  }

  public void setDocumentnote(String documentnote) {
    this.documentnote = documentnote;
  }

  public PaymentTerm fixmonthcutoff(Integer fixmonthcutoff) {
    this.fixmonthcutoff = fixmonthcutoff;
    return this;
  }

  /**
   * Get fixmonthcutoff
   * @return fixmonthcutoff
   **/
  @Schema(description = "")
  
    public Integer getFixmonthcutoff() {
    return fixmonthcutoff;
  }

  public void setFixmonthcutoff(Integer fixmonthcutoff) {
    this.fixmonthcutoff = fixmonthcutoff;
  }

  public PaymentTerm fixmonthday(Integer fixmonthday) {
    this.fixmonthday = fixmonthday;
    return this;
  }

  /**
   * Get fixmonthday
   * @return fixmonthday
   **/
  @Schema(description = "")
  
    public Integer getFixmonthday() {
    return fixmonthday;
  }

  public void setFixmonthday(Integer fixmonthday) {
    this.fixmonthday = fixmonthday;
  }

  public PaymentTerm fixmonthday2(Integer fixmonthday2) {
    this.fixmonthday2 = fixmonthday2;
    return this;
  }

  /**
   * Get fixmonthday2
   * @return fixmonthday2
   **/
  @Schema(description = "")
  
    public Integer getFixmonthday2() {
    return fixmonthday2;
  }

  public void setFixmonthday2(Integer fixmonthday2) {
    this.fixmonthday2 = fixmonthday2;
  }

  public PaymentTerm fixmonthoffset(Integer fixmonthoffset) {
    this.fixmonthoffset = fixmonthoffset;
    return this;
  }

  /**
   * Get fixmonthoffset
   * @return fixmonthoffset
   **/
  @Schema(description = "")
  
    public Integer getFixmonthoffset() {
    return fixmonthoffset;
  }

  public void setFixmonthoffset(Integer fixmonthoffset) {
    this.fixmonthoffset = fixmonthoffset;
  }

  public PaymentTerm gracedays(Integer gracedays) {
    this.gracedays = gracedays;
    return this;
  }

  /**
   * Get gracedays
   * @return gracedays
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getGracedays() {
    return gracedays;
  }

  public void setGracedays(Integer gracedays) {
    this.gracedays = gracedays;
  }

  public PaymentTerm gracedays2(Integer gracedays2) {
    this.gracedays2 = gracedays2;
    return this;
  }

  /**
   * Get gracedays2
   * @return gracedays2
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getGracedays2() {
    return gracedays2;
  }

  public void setGracedays2(Integer gracedays2) {
    this.gracedays2 = gracedays2;
  }

  public PaymentTerm isactive(Boolean isactive) {
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

  public PaymentTerm isdefault(Boolean isdefault) {
    this.isdefault = isdefault;
    return this;
  }

  /**
   * Get isdefault
   * @return isdefault
   **/
  @Schema(description = "")
  
    public Boolean isIsdefault() {
    return isdefault;
  }

  public void setIsdefault(Boolean isdefault) {
    this.isdefault = isdefault;
  }

  public PaymentTerm isduefixed(Boolean isduefixed) {
    this.isduefixed = isduefixed;
    return this;
  }

  /**
   * Get isduefixed
   * @return isduefixed
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsduefixed() {
    return isduefixed;
  }

  public void setIsduefixed(Boolean isduefixed) {
    this.isduefixed = isduefixed;
  }

  public PaymentTerm isnextbusinessday(Boolean isnextbusinessday) {
    this.isnextbusinessday = isnextbusinessday;
    return this;
  }

  /**
   * Get isnextbusinessday
   * @return isnextbusinessday
   **/
  @Schema(description = "")
  
    public Boolean isIsnextbusinessday() {
    return isnextbusinessday;
  }

  public void setIsnextbusinessday(Boolean isnextbusinessday) {
    this.isnextbusinessday = isnextbusinessday;
  }

  public PaymentTerm isvalid(Boolean isvalid) {
    this.isvalid = isvalid;
    return this;
  }

  /**
   * Get isvalid
   * @return isvalid
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsvalid() {
    return isvalid;
  }

  public void setIsvalid(Boolean isvalid) {
    this.isvalid = isvalid;
  }

  public PaymentTerm name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PaymentTerm netday(String netday) {
    this.netday = netday;
    return this;
  }

  /**
   * Get netday
   * @return netday
   **/
  @Schema(description = "")
  
    public String getNetday() {
    return netday;
  }

  public void setNetday(String netday) {
    this.netday = netday;
  }

  public PaymentTerm netdays(Integer netdays) {
    this.netdays = netdays;
    return this;
  }

  /**
   * Get netdays
   * @return netdays
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getNetdays() {
    return netdays;
  }

  public void setNetdays(Integer netdays) {
    this.netdays = netdays;
  }

  public PaymentTerm processing(String processing) {
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

  public PaymentTerm updated(String updated) {
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

  public PaymentTerm updatedby(Integer updatedby) {
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

  public PaymentTerm value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public PaymentTerm additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public PaymentTerm addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public PaymentTerm referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public PaymentTerm addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    PaymentTerm paymentTerm = (PaymentTerm) o;
    return Objects.equals(this.adClientId, paymentTerm.adClientId) &&
        Objects.equals(this.adComponentobjectuid, paymentTerm.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, paymentTerm.adOrgId) &&
        Objects.equals(this.afterdelivery, paymentTerm.afterdelivery) &&
        Objects.equals(this.applicationcontext, paymentTerm.applicationcontext) &&
        Objects.equals(this.applicationdate, paymentTerm.applicationdate) &&
        Objects.equals(this.cPaymenttermId, paymentTerm.cPaymenttermId) &&
        Objects.equals(this.cPospaymentmediumId, paymentTerm.cPospaymentmediumId) &&
        Objects.equals(this.created, paymentTerm.created) &&
        Objects.equals(this.createdby, paymentTerm.createdby) &&
        Objects.equals(this.description, paymentTerm.description) &&
        Objects.equals(this.discount, paymentTerm.discount) &&
        Objects.equals(this.discount2, paymentTerm.discount2) &&
        Objects.equals(this.discountapplicationtype, paymentTerm.discountapplicationtype) &&
        Objects.equals(this.discountapplicationtype2, paymentTerm.discountapplicationtype2) &&
        Objects.equals(this.discountdays, paymentTerm.discountdays) &&
        Objects.equals(this.discountdays2, paymentTerm.discountdays2) &&
        Objects.equals(this.documentnote, paymentTerm.documentnote) &&
        Objects.equals(this.fixmonthcutoff, paymentTerm.fixmonthcutoff) &&
        Objects.equals(this.fixmonthday, paymentTerm.fixmonthday) &&
        Objects.equals(this.fixmonthday2, paymentTerm.fixmonthday2) &&
        Objects.equals(this.fixmonthoffset, paymentTerm.fixmonthoffset) &&
        Objects.equals(this.gracedays, paymentTerm.gracedays) &&
        Objects.equals(this.gracedays2, paymentTerm.gracedays2) &&
        Objects.equals(this.isactive, paymentTerm.isactive) &&
        Objects.equals(this.isdefault, paymentTerm.isdefault) &&
        Objects.equals(this.isduefixed, paymentTerm.isduefixed) &&
        Objects.equals(this.isnextbusinessday, paymentTerm.isnextbusinessday) &&
        Objects.equals(this.isvalid, paymentTerm.isvalid) &&
        Objects.equals(this.name, paymentTerm.name) &&
        Objects.equals(this.netday, paymentTerm.netday) &&
        Objects.equals(this.netdays, paymentTerm.netdays) &&
        Objects.equals(this.processing, paymentTerm.processing) &&
        Objects.equals(this.updated, paymentTerm.updated) &&
        Objects.equals(this.updatedby, paymentTerm.updatedby) &&
        Objects.equals(this.value, paymentTerm.value) &&
        Objects.equals(this.additionalvalues, paymentTerm.additionalvalues) &&
        Objects.equals(this.referencedvalues, paymentTerm.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adOrgId, afterdelivery, applicationcontext, applicationdate, cPaymenttermId, cPospaymentmediumId, created, createdby, description, discount, discount2, discountapplicationtype, discountapplicationtype2, discountdays, discountdays2, documentnote, fixmonthcutoff, fixmonthday, fixmonthday2, fixmonthoffset, gracedays, gracedays2, isactive, isdefault, isduefixed, isnextbusinessday, isvalid, name, netday, netdays, processing, updated, updatedby, value, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentTerm {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    afterdelivery: ").append(toIndentedString(afterdelivery)).append("\n");
    sb.append("    applicationcontext: ").append(toIndentedString(applicationcontext)).append("\n");
    sb.append("    applicationdate: ").append(toIndentedString(applicationdate)).append("\n");
    sb.append("    cPaymenttermId: ").append(toIndentedString(cPaymenttermId)).append("\n");
    sb.append("    cPospaymentmediumId: ").append(toIndentedString(cPospaymentmediumId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
    sb.append("    discount2: ").append(toIndentedString(discount2)).append("\n");
    sb.append("    discountapplicationtype: ").append(toIndentedString(discountapplicationtype)).append("\n");
    sb.append("    discountapplicationtype2: ").append(toIndentedString(discountapplicationtype2)).append("\n");
    sb.append("    discountdays: ").append(toIndentedString(discountdays)).append("\n");
    sb.append("    discountdays2: ").append(toIndentedString(discountdays2)).append("\n");
    sb.append("    documentnote: ").append(toIndentedString(documentnote)).append("\n");
    sb.append("    fixmonthcutoff: ").append(toIndentedString(fixmonthcutoff)).append("\n");
    sb.append("    fixmonthday: ").append(toIndentedString(fixmonthday)).append("\n");
    sb.append("    fixmonthday2: ").append(toIndentedString(fixmonthday2)).append("\n");
    sb.append("    fixmonthoffset: ").append(toIndentedString(fixmonthoffset)).append("\n");
    sb.append("    gracedays: ").append(toIndentedString(gracedays)).append("\n");
    sb.append("    gracedays2: ").append(toIndentedString(gracedays2)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isdefault: ").append(toIndentedString(isdefault)).append("\n");
    sb.append("    isduefixed: ").append(toIndentedString(isduefixed)).append("\n");
    sb.append("    isnextbusinessday: ").append(toIndentedString(isnextbusinessday)).append("\n");
    sb.append("    isvalid: ").append(toIndentedString(isvalid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    netday: ").append(toIndentedString(netday)).append("\n");
    sb.append("    netdays: ").append(toIndentedString(netdays)).append("\n");
    sb.append("    processing: ").append(toIndentedString(processing)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
