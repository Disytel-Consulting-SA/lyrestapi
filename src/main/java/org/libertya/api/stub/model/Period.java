package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.Propertiesmap;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Period
 */
@Validated



public class Period   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_period_id")
  private Integer cPeriodId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_year_id")
  private Integer cYearId = null;

  @JsonProperty("enddate")
  private String enddate = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("periodno")
  private Integer periodno = null;

  @JsonProperty("periodtype")
  private String periodtype = null;

  @JsonProperty("startdate")
  private String startdate = null;

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

  public Period adClientId(Integer adClientId) {
    this.adClientId = adClientId;
    return this;
  }

  /**
   * Compañía o empresa que utiliza ésta instalación
   * @return adClientId
   **/
  @Schema(required = true, description = "Compañía o empresa que utiliza ésta instalación")
      @NotNull

    public Integer getAdClientId() {
    return adClientId;
  }

  public void setAdClientId(Integer adClientId) {
    this.adClientId = adClientId;
  }

  public Period adOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
    return this;
  }

  /**
   * Entidad organizacional dentro de la compañía
   * @return adOrgId
   **/
  @Schema(required = true, description = "Entidad organizacional dentro de la compañía")
      @NotNull

    public Integer getAdOrgId() {
    return adOrgId;
  }

  public void setAdOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
  }

  public Period cPeriodId(Integer cPeriodId) {
    this.cPeriodId = cPeriodId;
    return this;
  }

  /**
   * Período de Calendario
   * @return cPeriodId
   **/
  @Schema(required = true, description = "Período de Calendario")
      @NotNull

    public Integer getCPeriodId() {
    return cPeriodId;
  }

  public void setCPeriodId(Integer cPeriodId) {
    this.cPeriodId = cPeriodId;
  }

  public Period created(String created) {
    this.created = created;
    return this;
  }

  /**
   * Fecha de creación de este registro
   * @return created
   **/
  @Schema(required = true, description = "Fecha de creación de este registro")
      @NotNull

    public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public Period createdby(Integer createdby) {
    this.createdby = createdby;
    return this;
  }

  /**
   * Usuario que creó este registro
   * @return createdby
   **/
  @Schema(required = true, description = "Usuario que creó este registro")
      @NotNull

    public Integer getCreatedby() {
    return createdby;
  }

  public void setCreatedby(Integer createdby) {
    this.createdby = createdby;
  }

  public Period cYearId(Integer cYearId) {
    this.cYearId = cYearId;
    return this;
  }

  /**
   * Año del calendario
   * @return cYearId
   **/
  @Schema(required = true, description = "Año del calendario")
      @NotNull

    public Integer getCYearId() {
    return cYearId;
  }

  public void setCYearId(Integer cYearId) {
    this.cYearId = cYearId;
  }

  public Period enddate(String enddate) {
    this.enddate = enddate;
    return this;
  }

  /**
   * Última fecha efectiva (inclusive)
   * @return enddate
   **/
  @Schema(description = "Última fecha efectiva (inclusive)")
  
    public String getEnddate() {
    return enddate;
  }

  public void setEnddate(String enddate) {
    this.enddate = enddate;
  }

  public Period isactive(Boolean isactive) {
    this.isactive = isactive;
    return this;
  }

  /**
   * El registro está activo en el sistema
   * @return isactive
   **/
  @Schema(required = true, description = "El registro está activo en el sistema")
      @NotNull

    public Boolean isIsactive() {
    return isactive;
  }

  public void setIsactive(Boolean isactive) {
    this.isactive = isactive;
  }

  public Period name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Identificador alfanumérico de la Entidad
   * @return name
   **/
  @Schema(required = true, description = "Identificador alfanumérico de la Entidad")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Period periodno(Integer periodno) {
    this.periodno = periodno;
    return this;
  }

  /**
   * Número de Período único
   * @return periodno
   **/
  @Schema(required = true, description = "Número de Período único")
      @NotNull

    public Integer getPeriodno() {
    return periodno;
  }

  public void setPeriodno(Integer periodno) {
    this.periodno = periodno;
  }

  public Period periodtype(String periodtype) {
    this.periodtype = periodtype;
    return this;
  }

  /**
   * Tipo de período
   * @return periodtype
   **/
  @Schema(required = true, description = "Tipo de período")
      @NotNull

    public String getPeriodtype() {
    return periodtype;
  }

  public void setPeriodtype(String periodtype) {
    this.periodtype = periodtype;
  }

  public Period startdate(String startdate) {
    this.startdate = startdate;
    return this;
  }

  /**
   * Primer día efectivo (inclusive)
   * @return startdate
   **/
  @Schema(required = true, description = "Primer día efectivo (inclusive)")
      @NotNull

    public String getStartdate() {
    return startdate;
  }

  public void setStartdate(String startdate) {
    this.startdate = startdate;
  }

  public Period updated(String updated) {
    this.updated = updated;
    return this;
  }

  /**
   * Determina si el campo esta actualizado
   * @return updated
   **/
  @Schema(required = true, description = "Determina si el campo esta actualizado")
      @NotNull

    public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  public Period updatedby(Integer updatedby) {
    this.updatedby = updatedby;
    return this;
  }

  /**
   * Determina quien actualizó el campo
   * @return updatedby
   **/
  @Schema(required = true, description = "Determina quien actualizó el campo")
      @NotNull

    public Integer getUpdatedby() {
    return updatedby;
  }

  public void setUpdatedby(Integer updatedby) {
    this.updatedby = updatedby;
  }

  public Period additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Period addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Period referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Period addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Period period = (Period) o;
    return Objects.equals(this.adClientId, period.adClientId) &&
        Objects.equals(this.adOrgId, period.adOrgId) &&
        Objects.equals(this.cPeriodId, period.cPeriodId) &&
        Objects.equals(this.created, period.created) &&
        Objects.equals(this.createdby, period.createdby) &&
        Objects.equals(this.cYearId, period.cYearId) &&
        Objects.equals(this.enddate, period.enddate) &&
        Objects.equals(this.isactive, period.isactive) &&
        Objects.equals(this.name, period.name) &&
        Objects.equals(this.periodno, period.periodno) &&
        Objects.equals(this.periodtype, period.periodtype) &&
        Objects.equals(this.startdate, period.startdate) &&
        Objects.equals(this.updated, period.updated) &&
        Objects.equals(this.updatedby, period.updatedby) &&
        Objects.equals(this.additionalvalues, period.additionalvalues) &&
        Objects.equals(this.referencedvalues, period.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, cPeriodId, created, createdby, cYearId, enddate, isactive, name, periodno, periodtype, startdate, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Period {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cPeriodId: ").append(toIndentedString(cPeriodId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cYearId: ").append(toIndentedString(cYearId)).append("\n");
    sb.append("    enddate: ").append(toIndentedString(enddate)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    periodno: ").append(toIndentedString(periodno)).append("\n");
    sb.append("    periodtype: ").append(toIndentedString(periodtype)).append("\n");
    sb.append("    startdate: ").append(toIndentedString(startdate)).append("\n");
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
