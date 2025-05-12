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
 * ProductCategories
 */
@Validated



public class ProductCategories   {
  @JsonProperty("a_asset_group_id")
  private Integer aAssetGroupId = null;

  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("ad_printcolor_id")
  private Integer adPrintcolorId = null;

  @JsonProperty("amortizationperc")
  private BigDecimal amortizationperc = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isdefault")
  private Boolean isdefault = null;

  @JsonProperty("isselfservice")
  private Boolean isselfservice = null;

  @JsonProperty("mmpolicy")
  private String mmpolicy = null;

  @JsonProperty("m_product_category_id")
  private Integer mProductCategoryId = null;

  @JsonProperty("m_product_gamas_id")
  private Integer mProductGamasId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("plannedmargin")
  private BigDecimal plannedmargin = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("yearlife")
  private Integer yearlife = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public ProductCategories aAssetGroupId(Integer aAssetGroupId) {
    this.aAssetGroupId = aAssetGroupId;
    return this;
  }

  /**
   * Grupo de Activos
   * @return aAssetGroupId
   **/
  @Schema(description = "Grupo de Activos")
  
    public Integer getAAssetGroupId() {
    return aAssetGroupId;
  }

  public void setAAssetGroupId(Integer aAssetGroupId) {
    this.aAssetGroupId = aAssetGroupId;
  }

  public ProductCategories adClientId(Integer adClientId) {
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

  public ProductCategories adComponentobjectuid(String adComponentobjectuid) {
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

  public ProductCategories adOrgId(Integer adOrgId) {
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

  public ProductCategories adPrintcolorId(Integer adPrintcolorId) {
    this.adPrintcolorId = adPrintcolorId;
    return this;
  }

  /**
   * Color usado para imprimir
   * @return adPrintcolorId
   **/
  @Schema(description = "Color usado para imprimir")
  
    public Integer getAdPrintcolorId() {
    return adPrintcolorId;
  }

  public void setAdPrintcolorId(Integer adPrintcolorId) {
    this.adPrintcolorId = adPrintcolorId;
  }

  public ProductCategories amortizationperc(BigDecimal amortizationperc) {
    this.amortizationperc = amortizationperc;
    return this;
  }

  /**
   * Porcentaje de amortización del período de amortización
   * @return amortizationperc
   **/
  @Schema(required = true, description = "Porcentaje de amortización del período de amortización")
      @NotNull

    @Valid
    public BigDecimal getAmortizationperc() {
    return amortizationperc;
  }

  public void setAmortizationperc(BigDecimal amortizationperc) {
    this.amortizationperc = amortizationperc;
  }

  public ProductCategories created(String created) {
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

  public ProductCategories createdby(Integer createdby) {
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

  public ProductCategories description(String description) {
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

  public ProductCategories isactive(Boolean isactive) {
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

  public ProductCategories isdefault(Boolean isdefault) {
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

  public ProductCategories isselfservice(Boolean isselfservice) {
    this.isselfservice = isselfservice;
    return this;
  }

  /**
   * Disp. en Web
   * @return isselfservice
   **/
  @Schema(required = true, description = "Disp. en Web")
      @NotNull

    public Boolean isIsselfservice() {
    return isselfservice;
  }

  public void setIsselfservice(Boolean isselfservice) {
    this.isselfservice = isselfservice;
  }

  public ProductCategories mmpolicy(String mmpolicy) {
    this.mmpolicy = mmpolicy;
    return this;
  }

  /**
   * Politica de Material
   * @return mmpolicy
   **/
  @Schema(required = true, description = "Politica de Material")
      @NotNull

    public String getMmpolicy() {
    return mmpolicy;
  }

  public void setMmpolicy(String mmpolicy) {
    this.mmpolicy = mmpolicy;
  }

  public ProductCategories mProductCategoryId(Integer mProductCategoryId) {
    this.mProductCategoryId = mProductCategoryId;
    return this;
  }

  /**
   * Categoría de la que este producto es parte
   * @return mProductCategoryId
   **/
  @Schema(required = true, description = "Categoría de la que este producto es parte")
      @NotNull

    public Integer getMProductCategoryId() {
    return mProductCategoryId;
  }

  public void setMProductCategoryId(Integer mProductCategoryId) {
    this.mProductCategoryId = mProductCategoryId;
  }

  public ProductCategories mProductGamasId(Integer mProductGamasId) {
    this.mProductGamasId = mProductGamasId;
    return this;
  }

  /**
   *  
   * @return mProductGamasId
   **/
  @Schema(description = " ")
  
    public Integer getMProductGamasId() {
    return mProductGamasId;
  }

  public void setMProductGamasId(Integer mProductGamasId) {
    this.mProductGamasId = mProductGamasId;
  }

  public ProductCategories name(String name) {
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

  public ProductCategories plannedmargin(BigDecimal plannedmargin) {
    this.plannedmargin = plannedmargin;
    return this;
  }

  /**
   * % de Margen Planeado para este proyecto
   * @return plannedmargin
   **/
  @Schema(required = true, description = "% de Margen Planeado para este proyecto")
      @NotNull

    @Valid
    public BigDecimal getPlannedmargin() {
    return plannedmargin;
  }

  public void setPlannedmargin(BigDecimal plannedmargin) {
    this.plannedmargin = plannedmargin;
  }

  public ProductCategories updated(String updated) {
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

  public ProductCategories updatedby(Integer updatedby) {
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

  public ProductCategories value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Clave de búsqueda para el registro en el formato requerido; debe ser única
   * @return value
   **/
  @Schema(required = true, description = "Clave de búsqueda para el registro en el formato requerido; debe ser única")
      @NotNull

    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public ProductCategories yearlife(Integer yearlife) {
    this.yearlife = yearlife;
    return this;
  }

  /**
   * Vida útil en años
   * @return yearlife
   **/
  @Schema(required = true, description = "Vida útil en años")
      @NotNull

    public Integer getYearlife() {
    return yearlife;
  }

  public void setYearlife(Integer yearlife) {
    this.yearlife = yearlife;
  }

  public ProductCategories additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public ProductCategories addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public ProductCategories referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public ProductCategories addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    ProductCategories productCategories = (ProductCategories) o;
    return Objects.equals(this.aAssetGroupId, productCategories.aAssetGroupId) &&
        Objects.equals(this.adClientId, productCategories.adClientId) &&
        Objects.equals(this.adComponentobjectuid, productCategories.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, productCategories.adOrgId) &&
        Objects.equals(this.adPrintcolorId, productCategories.adPrintcolorId) &&
        Objects.equals(this.amortizationperc, productCategories.amortizationperc) &&
        Objects.equals(this.created, productCategories.created) &&
        Objects.equals(this.createdby, productCategories.createdby) &&
        Objects.equals(this.description, productCategories.description) &&
        Objects.equals(this.isactive, productCategories.isactive) &&
        Objects.equals(this.isdefault, productCategories.isdefault) &&
        Objects.equals(this.isselfservice, productCategories.isselfservice) &&
        Objects.equals(this.mmpolicy, productCategories.mmpolicy) &&
        Objects.equals(this.mProductCategoryId, productCategories.mProductCategoryId) &&
        Objects.equals(this.mProductGamasId, productCategories.mProductGamasId) &&
        Objects.equals(this.name, productCategories.name) &&
        Objects.equals(this.plannedmargin, productCategories.plannedmargin) &&
        Objects.equals(this.updated, productCategories.updated) &&
        Objects.equals(this.updatedby, productCategories.updatedby) &&
        Objects.equals(this.value, productCategories.value) &&
        Objects.equals(this.yearlife, productCategories.yearlife) &&
        Objects.equals(this.additionalvalues, productCategories.additionalvalues) &&
        Objects.equals(this.referencedvalues, productCategories.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aAssetGroupId, adClientId, adComponentobjectuid, adOrgId, adPrintcolorId, amortizationperc, created, createdby, description, isactive, isdefault, isselfservice, mmpolicy, mProductCategoryId, mProductGamasId, name, plannedmargin, updated, updatedby, value, yearlife, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductCategories {\n");
    
    sb.append("    aAssetGroupId: ").append(toIndentedString(aAssetGroupId)).append("\n");
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adPrintcolorId: ").append(toIndentedString(adPrintcolorId)).append("\n");
    sb.append("    amortizationperc: ").append(toIndentedString(amortizationperc)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isdefault: ").append(toIndentedString(isdefault)).append("\n");
    sb.append("    isselfservice: ").append(toIndentedString(isselfservice)).append("\n");
    sb.append("    mmpolicy: ").append(toIndentedString(mmpolicy)).append("\n");
    sb.append("    mProductCategoryId: ").append(toIndentedString(mProductCategoryId)).append("\n");
    sb.append("    mProductGamasId: ").append(toIndentedString(mProductGamasId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    plannedmargin: ").append(toIndentedString(plannedmargin)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    yearlife: ").append(toIndentedString(yearlife)).append("\n");
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
