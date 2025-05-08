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
 * OrgPercepcion
 */
@Validated



public class OrgPercepcion   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_org_percepcion_id")
  private Integer adOrgPercepcionId = null;

  @JsonProperty("alicuota")
  private BigDecimal alicuota = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_retencionprocessor_id")
  private Integer cRetencionprocessorId = null;

  @JsonProperty("c_tax_id")
  private Integer cTaxId = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isconveniomultilateral")
  private Boolean isconveniomultilateral = null;

  @JsonProperty("minimumnetamount")
  private BigDecimal minimumnetamount = null;

  @JsonProperty("minimumpercepcionamt")
  private BigDecimal minimumpercepcionamt = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("partialreturn")
  private Boolean partialreturn = null;

  @JsonProperty("totalreturn")
  private Boolean totalreturn = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("usecabajurisdiction")
  private Boolean usecabajurisdiction = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public OrgPercepcion adClientId(Integer adClientId) {
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

  public OrgPercepcion adOrgId(Integer adOrgId) {
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

  public OrgPercepcion adOrgPercepcionId(Integer adOrgPercepcionId) {
    this.adOrgPercepcionId = adOrgPercepcionId;
    return this;
  }

  /**
   * Get adOrgPercepcionId
   * @return adOrgPercepcionId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getAdOrgPercepcionId() {
    return adOrgPercepcionId;
  }

  public void setAdOrgPercepcionId(Integer adOrgPercepcionId) {
    this.adOrgPercepcionId = adOrgPercepcionId;
  }

  public OrgPercepcion alicuota(BigDecimal alicuota) {
    this.alicuota = alicuota;
    return this;
  }

  /**
   * Get alicuota
   * @return alicuota
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getAlicuota() {
    return alicuota;
  }

  public void setAlicuota(BigDecimal alicuota) {
    this.alicuota = alicuota;
  }

  public OrgPercepcion created(String created) {
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

  public OrgPercepcion createdby(Integer createdby) {
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

  public OrgPercepcion cRetencionprocessorId(Integer cRetencionprocessorId) {
    this.cRetencionprocessorId = cRetencionprocessorId;
    return this;
  }

  /**
   * Get cRetencionprocessorId
   * @return cRetencionprocessorId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCRetencionprocessorId() {
    return cRetencionprocessorId;
  }

  public void setCRetencionprocessorId(Integer cRetencionprocessorId) {
    this.cRetencionprocessorId = cRetencionprocessorId;
  }

  public OrgPercepcion cTaxId(Integer cTaxId) {
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

  public OrgPercepcion description(String description) {
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

  public OrgPercepcion isactive(Boolean isactive) {
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

  public OrgPercepcion isconveniomultilateral(Boolean isconveniomultilateral) {
    this.isconveniomultilateral = isconveniomultilateral;
    return this;
  }

  /**
   * Get isconveniomultilateral
   * @return isconveniomultilateral
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsconveniomultilateral() {
    return isconveniomultilateral;
  }

  public void setIsconveniomultilateral(Boolean isconveniomultilateral) {
    this.isconveniomultilateral = isconveniomultilateral;
  }

  public OrgPercepcion minimumnetamount(BigDecimal minimumnetamount) {
    this.minimumnetamount = minimumnetamount;
    return this;
  }

  /**
   * Get minimumnetamount
   * @return minimumnetamount
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getMinimumnetamount() {
    return minimumnetamount;
  }

  public void setMinimumnetamount(BigDecimal minimumnetamount) {
    this.minimumnetamount = minimumnetamount;
  }

  public OrgPercepcion minimumpercepcionamt(BigDecimal minimumpercepcionamt) {
    this.minimumpercepcionamt = minimumpercepcionamt;
    return this;
  }

  /**
   * Get minimumpercepcionamt
   * @return minimumpercepcionamt
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getMinimumpercepcionamt() {
    return minimumpercepcionamt;
  }

  public void setMinimumpercepcionamt(BigDecimal minimumpercepcionamt) {
    this.minimumpercepcionamt = minimumpercepcionamt;
  }

  public OrgPercepcion name(String name) {
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

  public OrgPercepcion partialreturn(Boolean partialreturn) {
    this.partialreturn = partialreturn;
    return this;
  }

  /**
   * Get partialreturn
   * @return partialreturn
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isPartialreturn() {
    return partialreturn;
  }

  public void setPartialreturn(Boolean partialreturn) {
    this.partialreturn = partialreturn;
  }

  public OrgPercepcion totalreturn(Boolean totalreturn) {
    this.totalreturn = totalreturn;
    return this;
  }

  /**
   * Get totalreturn
   * @return totalreturn
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isTotalreturn() {
    return totalreturn;
  }

  public void setTotalreturn(Boolean totalreturn) {
    this.totalreturn = totalreturn;
  }

  public OrgPercepcion updated(String updated) {
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

  public OrgPercepcion updatedby(Integer updatedby) {
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

  public OrgPercepcion usecabajurisdiction(Boolean usecabajurisdiction) {
    this.usecabajurisdiction = usecabajurisdiction;
    return this;
  }

  /**
   * Get usecabajurisdiction
   * @return usecabajurisdiction
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isUsecabajurisdiction() {
    return usecabajurisdiction;
  }

  public void setUsecabajurisdiction(Boolean usecabajurisdiction) {
    this.usecabajurisdiction = usecabajurisdiction;
  }

  public OrgPercepcion additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public OrgPercepcion addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public OrgPercepcion referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public OrgPercepcion addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    OrgPercepcion orgPercepcion = (OrgPercepcion) o;
    return Objects.equals(this.adClientId, orgPercepcion.adClientId) &&
        Objects.equals(this.adOrgId, orgPercepcion.adOrgId) &&
        Objects.equals(this.adOrgPercepcionId, orgPercepcion.adOrgPercepcionId) &&
        Objects.equals(this.alicuota, orgPercepcion.alicuota) &&
        Objects.equals(this.created, orgPercepcion.created) &&
        Objects.equals(this.createdby, orgPercepcion.createdby) &&
        Objects.equals(this.cRetencionprocessorId, orgPercepcion.cRetencionprocessorId) &&
        Objects.equals(this.cTaxId, orgPercepcion.cTaxId) &&
        Objects.equals(this.description, orgPercepcion.description) &&
        Objects.equals(this.isactive, orgPercepcion.isactive) &&
        Objects.equals(this.isconveniomultilateral, orgPercepcion.isconveniomultilateral) &&
        Objects.equals(this.minimumnetamount, orgPercepcion.minimumnetamount) &&
        Objects.equals(this.minimumpercepcionamt, orgPercepcion.minimumpercepcionamt) &&
        Objects.equals(this.name, orgPercepcion.name) &&
        Objects.equals(this.partialreturn, orgPercepcion.partialreturn) &&
        Objects.equals(this.totalreturn, orgPercepcion.totalreturn) &&
        Objects.equals(this.updated, orgPercepcion.updated) &&
        Objects.equals(this.updatedby, orgPercepcion.updatedby) &&
        Objects.equals(this.usecabajurisdiction, orgPercepcion.usecabajurisdiction) &&
        Objects.equals(this.additionalvalues, orgPercepcion.additionalvalues) &&
        Objects.equals(this.referencedvalues, orgPercepcion.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, adOrgPercepcionId, alicuota, created, createdby, cRetencionprocessorId, cTaxId, description, isactive, isconveniomultilateral, minimumnetamount, minimumpercepcionamt, name, partialreturn, totalreturn, updated, updatedby, usecabajurisdiction, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrgPercepcion {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adOrgPercepcionId: ").append(toIndentedString(adOrgPercepcionId)).append("\n");
    sb.append("    alicuota: ").append(toIndentedString(alicuota)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cRetencionprocessorId: ").append(toIndentedString(cRetencionprocessorId)).append("\n");
    sb.append("    cTaxId: ").append(toIndentedString(cTaxId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isconveniomultilateral: ").append(toIndentedString(isconveniomultilateral)).append("\n");
    sb.append("    minimumnetamount: ").append(toIndentedString(minimumnetamount)).append("\n");
    sb.append("    minimumpercepcionamt: ").append(toIndentedString(minimumpercepcionamt)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    partialreturn: ").append(toIndentedString(partialreturn)).append("\n");
    sb.append("    totalreturn: ").append(toIndentedString(totalreturn)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    usecabajurisdiction: ").append(toIndentedString(usecabajurisdiction)).append("\n");
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
