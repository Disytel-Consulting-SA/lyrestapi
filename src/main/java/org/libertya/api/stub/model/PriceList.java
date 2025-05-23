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
 * PriceList
 */
@Validated



public class PriceList   {
  @JsonProperty("actualizarpreciosconfacturadecompra")
  private Boolean actualizarpreciosconfacturadecompra = null;

  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_componentversion_id")
  private Integer adComponentversionId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("basepricelist_id")
  private Integer basepricelistId = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("enforcepricelimit")
  private Boolean enforcepricelimit = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isdefault")
  private Boolean isdefault = null;

  @JsonProperty("isperceptionsincluded")
  private Boolean isperceptionsincluded = null;

  @JsonProperty("issopricelist")
  private Boolean issopricelist = null;

  @JsonProperty("istaxincluded")
  private Boolean istaxincluded = null;

  @JsonProperty("m_pricelist_id")
  private Integer mPricelistId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("priceprecision")
  private BigDecimal priceprecision = null;

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

  public PriceList actualizarpreciosconfacturadecompra(Boolean actualizarpreciosconfacturadecompra) {
    this.actualizarpreciosconfacturadecompra = actualizarpreciosconfacturadecompra;
    return this;
  }

  /**
   *  
   * @return actualizarpreciosconfacturadecompra
   **/
  @Schema(description = " ")
  
    public Boolean isActualizarpreciosconfacturadecompra() {
    return actualizarpreciosconfacturadecompra;
  }

  public void setActualizarpreciosconfacturadecompra(Boolean actualizarpreciosconfacturadecompra) {
    this.actualizarpreciosconfacturadecompra = actualizarpreciosconfacturadecompra;
  }

  public PriceList adClientId(Integer adClientId) {
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

  public PriceList adComponentobjectuid(String adComponentobjectuid) {
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

  public PriceList adComponentversionId(Integer adComponentversionId) {
    this.adComponentversionId = adComponentversionId;
    return this;
  }

  /**
   * Versión de Componente propietaria de este registro
   * @return adComponentversionId
   **/
  @Schema(description = "Versión de Componente propietaria de este registro")
  
    public Integer getAdComponentversionId() {
    return adComponentversionId;
  }

  public void setAdComponentversionId(Integer adComponentversionId) {
    this.adComponentversionId = adComponentversionId;
  }

  public PriceList adOrgId(Integer adOrgId) {
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

  public PriceList basepricelistId(Integer basepricelistId) {
    this.basepricelistId = basepricelistId;
    return this;
  }

  /**
   * Lista de precios a ser usada; si el producto no se encontró en esta Lista de precios
   * @return basepricelistId
   **/
  @Schema(description = "Lista de precios a ser usada; si el producto no se encontró en esta Lista de precios")
  
    public Integer getBasepricelistId() {
    return basepricelistId;
  }

  public void setBasepricelistId(Integer basepricelistId) {
    this.basepricelistId = basepricelistId;
  }

  public PriceList cCurrencyId(Integer cCurrencyId) {
    this.cCurrencyId = cCurrencyId;
    return this;
  }

  /**
   * Moneda para este registro
   * @return cCurrencyId
   **/
  @Schema(required = true, description = "Moneda para este registro")
      @NotNull

    public Integer getCCurrencyId() {
    return cCurrencyId;
  }

  public void setCCurrencyId(Integer cCurrencyId) {
    this.cCurrencyId = cCurrencyId;
  }

  public PriceList created(String created) {
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

  public PriceList createdby(Integer createdby) {
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

  public PriceList description(String description) {
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

  public PriceList enforcepricelimit(Boolean enforcepricelimit) {
    this.enforcepricelimit = enforcepricelimit;
    return this;
  }

  /**
   * No se permiten precios por debajo del Precio Límite
   * @return enforcepricelimit
   **/
  @Schema(required = true, description = "No se permiten precios por debajo del Precio Límite")
      @NotNull

    public Boolean isEnforcepricelimit() {
    return enforcepricelimit;
  }

  public void setEnforcepricelimit(Boolean enforcepricelimit) {
    this.enforcepricelimit = enforcepricelimit;
  }

  public PriceList isactive(Boolean isactive) {
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

  public PriceList isdefault(Boolean isdefault) {
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

  public PriceList isperceptionsincluded(Boolean isperceptionsincluded) {
    this.isperceptionsincluded = isperceptionsincluded;
    return this;
  }

  /**
   *  
   * @return isperceptionsincluded
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isIsperceptionsincluded() {
    return isperceptionsincluded;
  }

  public void setIsperceptionsincluded(Boolean isperceptionsincluded) {
    this.isperceptionsincluded = isperceptionsincluded;
  }

  public PriceList issopricelist(Boolean issopricelist) {
    this.issopricelist = issopricelist;
    return this;
  }

  /**
   * Esta es una Lista de Precios de Venta
   * @return issopricelist
   **/
  @Schema(required = true, description = "Esta es una Lista de Precios de Venta")
      @NotNull

    public Boolean isIssopricelist() {
    return issopricelist;
  }

  public void setIssopricelist(Boolean issopricelist) {
    this.issopricelist = issopricelist;
  }

  public PriceList istaxincluded(Boolean istaxincluded) {
    this.istaxincluded = istaxincluded;
    return this;
  }

  /**
   * Impuesto incluido en el precio
   * @return istaxincluded
   **/
  @Schema(required = true, description = "Impuesto incluido en el precio")
      @NotNull

    public Boolean isIstaxincluded() {
    return istaxincluded;
  }

  public void setIstaxincluded(Boolean istaxincluded) {
    this.istaxincluded = istaxincluded;
  }

  public PriceList mPricelistId(Integer mPricelistId) {
    this.mPricelistId = mPricelistId;
    return this;
  }

  /**
   * Identificador único de mi lista de precios
   * @return mPricelistId
   **/
  @Schema(required = true, description = "Identificador único de mi lista de precios")
      @NotNull

    public Integer getMPricelistId() {
    return mPricelistId;
  }

  public void setMPricelistId(Integer mPricelistId) {
    this.mPricelistId = mPricelistId;
  }

  public PriceList name(String name) {
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

  public PriceList priceprecision(BigDecimal priceprecision) {
    this.priceprecision = priceprecision;
    return this;
  }

  /**
   * Precision en el Precio
   * @return priceprecision
   **/
  @Schema(required = true, description = "Precision en el Precio")
      @NotNull

    @Valid
    public BigDecimal getPriceprecision() {
    return priceprecision;
  }

  public void setPriceprecision(BigDecimal priceprecision) {
    this.priceprecision = priceprecision;
  }

  public PriceList updated(String updated) {
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

  public PriceList updatedby(Integer updatedby) {
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

  public PriceList additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public PriceList addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public PriceList referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public PriceList addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    PriceList priceList = (PriceList) o;
    return Objects.equals(this.actualizarpreciosconfacturadecompra, priceList.actualizarpreciosconfacturadecompra) &&
        Objects.equals(this.adClientId, priceList.adClientId) &&
        Objects.equals(this.adComponentobjectuid, priceList.adComponentobjectuid) &&
        Objects.equals(this.adComponentversionId, priceList.adComponentversionId) &&
        Objects.equals(this.adOrgId, priceList.adOrgId) &&
        Objects.equals(this.basepricelistId, priceList.basepricelistId) &&
        Objects.equals(this.cCurrencyId, priceList.cCurrencyId) &&
        Objects.equals(this.created, priceList.created) &&
        Objects.equals(this.createdby, priceList.createdby) &&
        Objects.equals(this.description, priceList.description) &&
        Objects.equals(this.enforcepricelimit, priceList.enforcepricelimit) &&
        Objects.equals(this.isactive, priceList.isactive) &&
        Objects.equals(this.isdefault, priceList.isdefault) &&
        Objects.equals(this.isperceptionsincluded, priceList.isperceptionsincluded) &&
        Objects.equals(this.issopricelist, priceList.issopricelist) &&
        Objects.equals(this.istaxincluded, priceList.istaxincluded) &&
        Objects.equals(this.mPricelistId, priceList.mPricelistId) &&
        Objects.equals(this.name, priceList.name) &&
        Objects.equals(this.priceprecision, priceList.priceprecision) &&
        Objects.equals(this.updated, priceList.updated) &&
        Objects.equals(this.updatedby, priceList.updatedby) &&
        Objects.equals(this.additionalvalues, priceList.additionalvalues) &&
        Objects.equals(this.referencedvalues, priceList.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(actualizarpreciosconfacturadecompra, adClientId, adComponentobjectuid, adComponentversionId, adOrgId, basepricelistId, cCurrencyId, created, createdby, description, enforcepricelimit, isactive, isdefault, isperceptionsincluded, issopricelist, istaxincluded, mPricelistId, name, priceprecision, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceList {\n");
    
    sb.append("    actualizarpreciosconfacturadecompra: ").append(toIndentedString(actualizarpreciosconfacturadecompra)).append("\n");
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adComponentversionId: ").append(toIndentedString(adComponentversionId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    basepricelistId: ").append(toIndentedString(basepricelistId)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    enforcepricelimit: ").append(toIndentedString(enforcepricelimit)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isdefault: ").append(toIndentedString(isdefault)).append("\n");
    sb.append("    isperceptionsincluded: ").append(toIndentedString(isperceptionsincluded)).append("\n");
    sb.append("    issopricelist: ").append(toIndentedString(issopricelist)).append("\n");
    sb.append("    istaxincluded: ").append(toIndentedString(istaxincluded)).append("\n");
    sb.append("    mPricelistId: ").append(toIndentedString(mPricelistId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    priceprecision: ").append(toIndentedString(priceprecision)).append("\n");
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
