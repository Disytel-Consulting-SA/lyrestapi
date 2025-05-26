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
 * UOM
 */
@Validated



public class UOM   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("allowdecimals")
  private Boolean allowdecimals = null;

  @JsonProperty("costingprecision")
  private Integer costingprecision = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_uom_group_id")
  private Integer cUomGroupId = null;

  @JsonProperty("c_uom_id")
  private Integer cUomId = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isdefault")
  private Boolean isdefault = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("productselectable")
  private Boolean productselectable = null;

  @JsonProperty("stdprecision")
  private Integer stdprecision = null;

  @JsonProperty("uomcodefe")
  private String uomcodefe = null;

  @JsonProperty("uomsymbol")
  private String uomsymbol = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("x12de355")
  private String x12de355 = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public UOM adClientId(Integer adClientId) {
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

  public UOM adComponentobjectuid(String adComponentobjectuid) {
    this.adComponentobjectuid = adComponentobjectuid;
    return this;
  }

  /**
   *  
   * @return adComponentobjectuid
   **/
  @Schema(description = " ")
  
    public String getAdComponentobjectuid() {
    return adComponentobjectuid;
  }

  public void setAdComponentobjectuid(String adComponentobjectuid) {
    this.adComponentobjectuid = adComponentobjectuid;
  }

  public UOM adOrgId(Integer adOrgId) {
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

  public UOM allowdecimals(Boolean allowdecimals) {
    this.allowdecimals = allowdecimals;
    return this;
  }

  /**
   * Permitir decimales en cantidades de líneas de documentos
   * @return allowdecimals
   **/
  @Schema(required = true, description = "Permitir decimales en cantidades de líneas de documentos")
      @NotNull

    public Boolean isAllowdecimals() {
    return allowdecimals;
  }

  public void setAllowdecimals(Boolean allowdecimals) {
    this.allowdecimals = allowdecimals;
  }

  public UOM costingprecision(Integer costingprecision) {
    this.costingprecision = costingprecision;
    return this;
  }

  /**
   * Redondeo usado en el cálculo de costes
   * @return costingprecision
   **/
  @Schema(required = true, description = "Redondeo usado en el cálculo de costes")
      @NotNull

    public Integer getCostingprecision() {
    return costingprecision;
  }

  public void setCostingprecision(Integer costingprecision) {
    this.costingprecision = costingprecision;
  }

  public UOM created(String created) {
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

  public UOM createdby(Integer createdby) {
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

  public UOM cUomGroupId(Integer cUomGroupId) {
    this.cUomGroupId = cUomGroupId;
    return this;
  }

  /**
   *  
   * @return cUomGroupId
   **/
  @Schema(description = " ")
  
    public Integer getCUomGroupId() {
    return cUomGroupId;
  }

  public void setCUomGroupId(Integer cUomGroupId) {
    this.cUomGroupId = cUomGroupId;
  }

  public UOM cUomId(Integer cUomId) {
    this.cUomId = cUomId;
    return this;
  }

  /**
   * Unidad de Medida
   * @return cUomId
   **/
  @Schema(required = true, description = "Unidad de Medida")
      @NotNull

    public Integer getCUomId() {
    return cUomId;
  }

  public void setCUomId(Integer cUomId) {
    this.cUomId = cUomId;
  }

  public UOM description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Descripción corta opcional del registro
   * @return description
   **/
  @Schema(description = "Descripción corta opcional del registro")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public UOM isactive(Boolean isactive) {
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

  public UOM isdefault(Boolean isdefault) {
    this.isdefault = isdefault;
    return this;
  }

  /**
   * Valor Predeterminado
   * @return isdefault
   **/
  @Schema(required = true, description = "Valor Predeterminado")
      @NotNull

    public Boolean isIsdefault() {
    return isdefault;
  }

  public void setIsdefault(Boolean isdefault) {
    this.isdefault = isdefault;
  }

  public UOM name(String name) {
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

  public UOM productselectable(Boolean productselectable) {
    this.productselectable = productselectable;
    return this;
  }

  /**
   * Si está marcado el campo, la unidad de medida está permitida para configurar artículos
   * @return productselectable
   **/
  @Schema(required = true, description = "Si está marcado el campo, la unidad de medida está permitida para configurar artículos")
      @NotNull

    public Boolean isProductselectable() {
    return productselectable;
  }

  public void setProductselectable(Boolean productselectable) {
    this.productselectable = productselectable;
  }

  public UOM stdprecision(Integer stdprecision) {
    this.stdprecision = stdprecision;
    return this;
  }

  /**
   * Regla de redondeo para los importes calculados
   * @return stdprecision
   **/
  @Schema(required = true, description = "Regla de redondeo para los importes calculados")
      @NotNull

    public Integer getStdprecision() {
    return stdprecision;
  }

  public void setStdprecision(Integer stdprecision) {
    this.stdprecision = stdprecision;
  }

  public UOM uomcodefe(String uomcodefe) {
    this.uomcodefe = uomcodefe;
    return this;
  }

  /**
   *  
   * @return uomcodefe
   **/
  @Schema(description = " ")
  
    public String getUomcodefe() {
    return uomcodefe;
  }

  public void setUomcodefe(String uomcodefe) {
    this.uomcodefe = uomcodefe;
  }

  public UOM uomsymbol(String uomsymbol) {
    this.uomsymbol = uomsymbol;
    return this;
  }

  /**
   * Símbolo para una unidad de medida
   * @return uomsymbol
   **/
  @Schema(description = "Símbolo para una unidad de medida")
  
    public String getUomsymbol() {
    return uomsymbol;
  }

  public void setUomsymbol(String uomsymbol) {
    this.uomsymbol = uomsymbol;
  }

  public UOM updated(String updated) {
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

  public UOM updatedby(Integer updatedby) {
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

  public UOM x12de355(String x12de355) {
    this.x12de355 = x12de355;
    return this;
  }

  /**
   * Código EDI
   * @return x12de355
   **/
  @Schema(required = true, description = "Código EDI")
      @NotNull

    public String getX12de355() {
    return x12de355;
  }

  public void setX12de355(String x12de355) {
    this.x12de355 = x12de355;
  }

  public UOM additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public UOM addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public UOM referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public UOM addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    UOM UOM = (UOM) o;
    return Objects.equals(this.adClientId, UOM.adClientId) &&
        Objects.equals(this.adComponentobjectuid, UOM.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, UOM.adOrgId) &&
        Objects.equals(this.allowdecimals, UOM.allowdecimals) &&
        Objects.equals(this.costingprecision, UOM.costingprecision) &&
        Objects.equals(this.created, UOM.created) &&
        Objects.equals(this.createdby, UOM.createdby) &&
        Objects.equals(this.cUomGroupId, UOM.cUomGroupId) &&
        Objects.equals(this.cUomId, UOM.cUomId) &&
        Objects.equals(this.description, UOM.description) &&
        Objects.equals(this.isactive, UOM.isactive) &&
        Objects.equals(this.isdefault, UOM.isdefault) &&
        Objects.equals(this.name, UOM.name) &&
        Objects.equals(this.productselectable, UOM.productselectable) &&
        Objects.equals(this.stdprecision, UOM.stdprecision) &&
        Objects.equals(this.uomcodefe, UOM.uomcodefe) &&
        Objects.equals(this.uomsymbol, UOM.uomsymbol) &&
        Objects.equals(this.updated, UOM.updated) &&
        Objects.equals(this.updatedby, UOM.updatedby) &&
        Objects.equals(this.x12de355, UOM.x12de355) &&
        Objects.equals(this.additionalvalues, UOM.additionalvalues) &&
        Objects.equals(this.referencedvalues, UOM.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adOrgId, allowdecimals, costingprecision, created, createdby, cUomGroupId, cUomId, description, isactive, isdefault, name, productselectable, stdprecision, uomcodefe, uomsymbol, updated, updatedby, x12de355, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UOM {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    allowdecimals: ").append(toIndentedString(allowdecimals)).append("\n");
    sb.append("    costingprecision: ").append(toIndentedString(costingprecision)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cUomGroupId: ").append(toIndentedString(cUomGroupId)).append("\n");
    sb.append("    cUomId: ").append(toIndentedString(cUomId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isdefault: ").append(toIndentedString(isdefault)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    productselectable: ").append(toIndentedString(productselectable)).append("\n");
    sb.append("    stdprecision: ").append(toIndentedString(stdprecision)).append("\n");
    sb.append("    uomcodefe: ").append(toIndentedString(uomcodefe)).append("\n");
    sb.append("    uomsymbol: ").append(toIndentedString(uomsymbol)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    x12de355: ").append(toIndentedString(x12de355)).append("\n");
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
