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
 * PaySchedule
 */
@Validated



public class PaySchedule   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_paymentterm_id")
  private Integer cPaymenttermId = null;

  @JsonProperty("c_payschedule_id")
  private Integer cPayscheduleId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("discount")
  private BigDecimal discount = null;

  @JsonProperty("discountapplicationtype")
  private String discountapplicationtype = null;

  @JsonProperty("discountdays")
  private Integer discountdays = null;

  @JsonProperty("gracedays")
  private Integer gracedays = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isvalid")
  private Boolean isvalid = null;

  @JsonProperty("netday")
  private String netday = null;

  @JsonProperty("netdays")
  private Integer netdays = null;

  @JsonProperty("percentage")
  private BigDecimal percentage = null;

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

  public PaySchedule adClientId(Integer adClientId) {
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

  public PaySchedule adComponentobjectuid(String adComponentobjectuid) {
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

  public PaySchedule adOrgId(Integer adOrgId) {
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

  public PaySchedule cPaymenttermId(Integer cPaymenttermId) {
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

  public PaySchedule cPayscheduleId(Integer cPayscheduleId) {
    this.cPayscheduleId = cPayscheduleId;
    return this;
  }

  /**
   * Get cPayscheduleId
   * @return cPayscheduleId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCPayscheduleId() {
    return cPayscheduleId;
  }

  public void setCPayscheduleId(Integer cPayscheduleId) {
    this.cPayscheduleId = cPayscheduleId;
  }

  public PaySchedule created(String created) {
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

  public PaySchedule createdby(Integer createdby) {
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

  public PaySchedule discount(BigDecimal discount) {
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

  public PaySchedule discountapplicationtype(String discountapplicationtype) {
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

  public PaySchedule discountdays(Integer discountdays) {
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

  public PaySchedule gracedays(Integer gracedays) {
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

  public PaySchedule isactive(Boolean isactive) {
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

  public PaySchedule isvalid(Boolean isvalid) {
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

  public PaySchedule netday(String netday) {
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

  public PaySchedule netdays(Integer netdays) {
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

  public PaySchedule percentage(BigDecimal percentage) {
    this.percentage = percentage;
    return this;
  }

  /**
   * Get percentage
   * @return percentage
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getPercentage() {
    return percentage;
  }

  public void setPercentage(BigDecimal percentage) {
    this.percentage = percentage;
  }

  public PaySchedule updated(String updated) {
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

  public PaySchedule updatedby(Integer updatedby) {
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

  public PaySchedule additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public PaySchedule addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public PaySchedule referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public PaySchedule addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    PaySchedule paySchedule = (PaySchedule) o;
    return Objects.equals(this.adClientId, paySchedule.adClientId) &&
        Objects.equals(this.adComponentobjectuid, paySchedule.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, paySchedule.adOrgId) &&
        Objects.equals(this.cPaymenttermId, paySchedule.cPaymenttermId) &&
        Objects.equals(this.cPayscheduleId, paySchedule.cPayscheduleId) &&
        Objects.equals(this.created, paySchedule.created) &&
        Objects.equals(this.createdby, paySchedule.createdby) &&
        Objects.equals(this.discount, paySchedule.discount) &&
        Objects.equals(this.discountapplicationtype, paySchedule.discountapplicationtype) &&
        Objects.equals(this.discountdays, paySchedule.discountdays) &&
        Objects.equals(this.gracedays, paySchedule.gracedays) &&
        Objects.equals(this.isactive, paySchedule.isactive) &&
        Objects.equals(this.isvalid, paySchedule.isvalid) &&
        Objects.equals(this.netday, paySchedule.netday) &&
        Objects.equals(this.netdays, paySchedule.netdays) &&
        Objects.equals(this.percentage, paySchedule.percentage) &&
        Objects.equals(this.updated, paySchedule.updated) &&
        Objects.equals(this.updatedby, paySchedule.updatedby) &&
        Objects.equals(this.additionalvalues, paySchedule.additionalvalues) &&
        Objects.equals(this.referencedvalues, paySchedule.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adOrgId, cPaymenttermId, cPayscheduleId, created, createdby, discount, discountapplicationtype, discountdays, gracedays, isactive, isvalid, netday, netdays, percentage, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaySchedule {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cPaymenttermId: ").append(toIndentedString(cPaymenttermId)).append("\n");
    sb.append("    cPayscheduleId: ").append(toIndentedString(cPayscheduleId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
    sb.append("    discountapplicationtype: ").append(toIndentedString(discountapplicationtype)).append("\n");
    sb.append("    discountdays: ").append(toIndentedString(discountdays)).append("\n");
    sb.append("    gracedays: ").append(toIndentedString(gracedays)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isvalid: ").append(toIndentedString(isvalid)).append("\n");
    sb.append("    netday: ").append(toIndentedString(netday)).append("\n");
    sb.append("    netdays: ").append(toIndentedString(netdays)).append("\n");
    sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
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
