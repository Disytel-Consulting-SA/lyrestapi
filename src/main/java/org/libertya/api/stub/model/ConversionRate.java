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
 * ConversionRate
 */
@Validated



public class ConversionRate   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_conversion_rate_id")
  private Integer cConversionRateId = null;

  @JsonProperty("c_conversiontype_id")
  private Integer cConversiontypeId = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("c_currency_id_to")
  private Integer cCurrencyIdTo = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("dividerate")
  private BigDecimal dividerate = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("multiplyrate")
  private BigDecimal multiplyrate = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("validfrom")
  private String validfrom = null;

  @JsonProperty("validto")
  private String validto = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public ConversionRate adClientId(Integer adClientId) {
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

  public ConversionRate adOrgId(Integer adOrgId) {
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

  public ConversionRate cConversionRateId(Integer cConversionRateId) {
    this.cConversionRateId = cConversionRateId;
    return this;
  }

  /**
   * Tasa usada para conversión de monedas
   * @return cConversionRateId
   **/
  @Schema(required = true, description = "Tasa usada para conversión de monedas")
      @NotNull

    public Integer getCConversionRateId() {
    return cConversionRateId;
  }

  public void setCConversionRateId(Integer cConversionRateId) {
    this.cConversionRateId = cConversionRateId;
  }

  public ConversionRate cConversiontypeId(Integer cConversiontypeId) {
    this.cConversiontypeId = cConversiontypeId;
    return this;
  }

  /**
   * Tipo de Divisa
   * @return cConversiontypeId
   **/
  @Schema(required = true, description = "Tipo de Divisa")
      @NotNull

    public Integer getCConversiontypeId() {
    return cConversiontypeId;
  }

  public void setCConversiontypeId(Integer cConversiontypeId) {
    this.cConversiontypeId = cConversiontypeId;
  }

  public ConversionRate cCurrencyId(Integer cCurrencyId) {
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

  public ConversionRate cCurrencyIdTo(Integer cCurrencyIdTo) {
    this.cCurrencyIdTo = cCurrencyIdTo;
    return this;
  }

  /**
   * Moneda a convertir
   * @return cCurrencyIdTo
   **/
  @Schema(required = true, description = "Moneda a convertir")
      @NotNull

    public Integer getCCurrencyIdTo() {
    return cCurrencyIdTo;
  }

  public void setCCurrencyIdTo(Integer cCurrencyIdTo) {
    this.cCurrencyIdTo = cCurrencyIdTo;
  }

  public ConversionRate created(String created) {
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

  public ConversionRate createdby(Integer createdby) {
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

  public ConversionRate dividerate(BigDecimal dividerate) {
    this.dividerate = dividerate;
    return this;
  }

  /**
   * Convierte el número fuente a número destino; el fuente entre el número divisor
   * @return dividerate
   **/
  @Schema(required = true, description = "Convierte el número fuente a número destino; el fuente entre el número divisor")
      @NotNull

    @Valid
    public BigDecimal getDividerate() {
    return dividerate;
  }

  public void setDividerate(BigDecimal dividerate) {
    this.dividerate = dividerate;
  }

  public ConversionRate isactive(Boolean isactive) {
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

  public ConversionRate multiplyrate(BigDecimal multiplyrate) {
    this.multiplyrate = multiplyrate;
    return this;
  }

  /**
   * Tasa por la que se multiplica la fuente para encontrar el objetivo
   * @return multiplyrate
   **/
  @Schema(required = true, description = "Tasa por la que se multiplica la fuente para encontrar el objetivo")
      @NotNull

    @Valid
    public BigDecimal getMultiplyrate() {
    return multiplyrate;
  }

  public void setMultiplyrate(BigDecimal multiplyrate) {
    this.multiplyrate = multiplyrate;
  }

  public ConversionRate updated(String updated) {
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

  public ConversionRate updatedby(Integer updatedby) {
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

  public ConversionRate validfrom(String validfrom) {
    this.validfrom = validfrom;
    return this;
  }

  /**
   * Válido desde; incluyendo esta fecha (primer día)
   * @return validfrom
   **/
  @Schema(required = true, description = "Válido desde; incluyendo esta fecha (primer día)")
      @NotNull

    public String getValidfrom() {
    return validfrom;
  }

  public void setValidfrom(String validfrom) {
    this.validfrom = validfrom;
  }

  public ConversionRate validto(String validto) {
    this.validto = validto;
    return this;
  }

  /**
   * Válido hasta; incluyendo esta fecha (ultimo día)
   * @return validto
   **/
  @Schema(description = "Válido hasta; incluyendo esta fecha (ultimo día)")
  
    public String getValidto() {
    return validto;
  }

  public void setValidto(String validto) {
    this.validto = validto;
  }

  public ConversionRate additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public ConversionRate addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public ConversionRate referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public ConversionRate addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    ConversionRate conversionRate = (ConversionRate) o;
    return Objects.equals(this.adClientId, conversionRate.adClientId) &&
        Objects.equals(this.adOrgId, conversionRate.adOrgId) &&
        Objects.equals(this.cConversionRateId, conversionRate.cConversionRateId) &&
        Objects.equals(this.cConversiontypeId, conversionRate.cConversiontypeId) &&
        Objects.equals(this.cCurrencyId, conversionRate.cCurrencyId) &&
        Objects.equals(this.cCurrencyIdTo, conversionRate.cCurrencyIdTo) &&
        Objects.equals(this.created, conversionRate.created) &&
        Objects.equals(this.createdby, conversionRate.createdby) &&
        Objects.equals(this.dividerate, conversionRate.dividerate) &&
        Objects.equals(this.isactive, conversionRate.isactive) &&
        Objects.equals(this.multiplyrate, conversionRate.multiplyrate) &&
        Objects.equals(this.updated, conversionRate.updated) &&
        Objects.equals(this.updatedby, conversionRate.updatedby) &&
        Objects.equals(this.validfrom, conversionRate.validfrom) &&
        Objects.equals(this.validto, conversionRate.validto) &&
        Objects.equals(this.additionalvalues, conversionRate.additionalvalues) &&
        Objects.equals(this.referencedvalues, conversionRate.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, cConversionRateId, cConversiontypeId, cCurrencyId, cCurrencyIdTo, created, createdby, dividerate, isactive, multiplyrate, updated, updatedby, validfrom, validto, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversionRate {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cConversionRateId: ").append(toIndentedString(cConversionRateId)).append("\n");
    sb.append("    cConversiontypeId: ").append(toIndentedString(cConversiontypeId)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    cCurrencyIdTo: ").append(toIndentedString(cCurrencyIdTo)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    dividerate: ").append(toIndentedString(dividerate)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    multiplyrate: ").append(toIndentedString(multiplyrate)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    validfrom: ").append(toIndentedString(validfrom)).append("\n");
    sb.append("    validto: ").append(toIndentedString(validto)).append("\n");
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
