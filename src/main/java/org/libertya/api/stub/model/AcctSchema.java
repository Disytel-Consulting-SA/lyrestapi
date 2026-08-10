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
 * AcctSchema
 */
@Validated



public class AcctSchema   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("autoperiodcontrol")
  private Boolean autoperiodcontrol = null;

  @JsonProperty("c_acctschema_id")
  private Integer cAcctschemaId = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("costingmethod")
  private String costingmethod = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("factacctbalanceactive")
  private Boolean factacctbalanceactive = null;

  @JsonProperty("gaap")
  private String gaap = null;

  @JsonProperty("hasalias")
  private Boolean hasalias = null;

  @JsonProperty("hascombination")
  private Boolean hascombination = null;

  @JsonProperty("isaccrual")
  private Boolean isaccrual = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isdiscountcorrectstax")
  private Boolean isdiscountcorrectstax = null;

  @JsonProperty("istradediscountposted")
  private Boolean istradediscountposted = null;

  @JsonProperty("m_costtype_id")
  private Integer mCosttypeId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("separator")
  private String separator = null;

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

  public AcctSchema adClientId(Integer adClientId) {
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

  public AcctSchema adOrgId(Integer adOrgId) {
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

  public AcctSchema autoperiodcontrol(Boolean autoperiodcontrol) {
    this.autoperiodcontrol = autoperiodcontrol;
    return this;
  }

  /**
   * Si es seleccionado; los períodos son abiertos y cerrados automáticamente
   * @return autoperiodcontrol
   **/
  @Schema(required = true, description = "Si es seleccionado; los períodos son abiertos y cerrados automáticamente")
      @NotNull

    public Boolean isAutoperiodcontrol() {
    return autoperiodcontrol;
  }

  public void setAutoperiodcontrol(Boolean autoperiodcontrol) {
    this.autoperiodcontrol = autoperiodcontrol;
  }

  public AcctSchema cAcctschemaId(Integer cAcctschemaId) {
    this.cAcctschemaId = cAcctschemaId;
    return this;
  }

  /**
   * Reglas para contabilizar
   * @return cAcctschemaId
   **/
  @Schema(required = true, description = "Reglas para contabilizar")
      @NotNull

    public Integer getCAcctschemaId() {
    return cAcctschemaId;
  }

  public void setCAcctschemaId(Integer cAcctschemaId) {
    this.cAcctschemaId = cAcctschemaId;
  }

  public AcctSchema cCurrencyId(Integer cCurrencyId) {
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

  public AcctSchema costingmethod(String costingmethod) {
    this.costingmethod = costingmethod;
    return this;
  }

  /**
   * Indica cómo serán calculados los Costos
   * @return costingmethod
   **/
  @Schema(required = true, description = "Indica cómo serán calculados los Costos")
      @NotNull

    public String getCostingmethod() {
    return costingmethod;
  }

  public void setCostingmethod(String costingmethod) {
    this.costingmethod = costingmethod;
  }

  public AcctSchema created(String created) {
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

  public AcctSchema createdby(Integer createdby) {
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

  public AcctSchema description(String description) {
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

  public AcctSchema factacctbalanceactive(Boolean factacctbalanceactive) {
    this.factacctbalanceactive = factacctbalanceactive;
    return this;
  }

  /**
   * Determina si la Contabilidad Agrupada se encuentra activa
   * @return factacctbalanceactive
   **/
  @Schema(required = true, description = "Determina si la Contabilidad Agrupada se encuentra activa")
      @NotNull

    public Boolean isFactacctbalanceactive() {
    return factacctbalanceactive;
  }

  public void setFactacctbalanceactive(Boolean factacctbalanceactive) {
    this.factacctbalanceactive = factacctbalanceactive;
  }

  public AcctSchema gaap(String gaap) {
    this.gaap = gaap;
    return this;
  }

  /**
   * Principios contables aceptados generalmente
   * @return gaap
   **/
  @Schema(required = true, description = "Principios contables aceptados generalmente")
      @NotNull

    public String getGaap() {
    return gaap;
  }

  public void setGaap(String gaap) {
    this.gaap = gaap;
  }

  public AcctSchema hasalias(Boolean hasalias) {
    this.hasalias = hasalias;
    return this;
  }

  /**
   * Capacidad para seleccionar (parcial) combinaciones de cuenta por medio de un alias
   * @return hasalias
   **/
  @Schema(required = true, description = "Capacidad para seleccionar (parcial) combinaciones de cuenta por medio de un alias")
      @NotNull

    public Boolean isHasalias() {
    return hasalias;
  }

  public void setHasalias(Boolean hasalias) {
    this.hasalias = hasalias;
  }

  public AcctSchema hascombination(Boolean hascombination) {
    this.hascombination = hascombination;
    return this;
  }

  /**
   * Verificación de la combinación de los elementos de la cuenta
   * @return hascombination
   **/
  @Schema(required = true, description = "Verificación de la combinación de los elementos de la cuenta")
      @NotNull

    public Boolean isHascombination() {
    return hascombination;
  }

  public void setHascombination(Boolean hascombination) {
    this.hascombination = hascombination;
  }

  public AcctSchema isaccrual(Boolean isaccrual) {
    this.isaccrual = isaccrual;
    return this;
  }

  /**
   * Indica se usará contabilidad basada en efectivo o absorción
   * @return isaccrual
   **/
  @Schema(required = true, description = "Indica se usará contabilidad basada en efectivo o absorción")
      @NotNull

    public Boolean isIsaccrual() {
    return isaccrual;
  }

  public void setIsaccrual(Boolean isaccrual) {
    this.isaccrual = isaccrual;
  }

  public AcctSchema isactive(Boolean isactive) {
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

  public AcctSchema isdiscountcorrectstax(Boolean isdiscountcorrectstax) {
    this.isdiscountcorrectstax = isdiscountcorrectstax;
    return this;
  }

  /**
   * Corregir Impuesto para Descuento y Cargos
   * @return isdiscountcorrectstax
   **/
  @Schema(required = true, description = "Corregir Impuesto para Descuento y Cargos")
      @NotNull

    public Boolean isIsdiscountcorrectstax() {
    return isdiscountcorrectstax;
  }

  public void setIsdiscountcorrectstax(Boolean isdiscountcorrectstax) {
    this.isdiscountcorrectstax = isdiscountcorrectstax;
  }

  public AcctSchema istradediscountposted(Boolean istradediscountposted) {
    this.istradediscountposted = istradediscountposted;
    return this;
  }

  /**
   * Genera registro para descuentos comerciales
   * @return istradediscountposted
   **/
  @Schema(required = true, description = "Genera registro para descuentos comerciales")
      @NotNull

    public Boolean isIstradediscountposted() {
    return istradediscountposted;
  }

  public void setIstradediscountposted(Boolean istradediscountposted) {
    this.istradediscountposted = istradediscountposted;
  }

  public AcctSchema mCosttypeId(Integer mCosttypeId) {
    this.mCosttypeId = mCosttypeId;
    return this;
  }

  /**
   * Tipo de Coste
   * @return mCosttypeId
   **/
  @Schema(required = true, description = "Tipo de Coste")
      @NotNull

    public Integer getMCosttypeId() {
    return mCosttypeId;
  }

  public void setMCosttypeId(Integer mCosttypeId) {
    this.mCosttypeId = mCosttypeId;
  }

  public AcctSchema name(String name) {
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

  public AcctSchema separator(String separator) {
    this.separator = separator;
    return this;
  }

  /**
   * Separador de los Elementos de la cuenta
   * @return separator
   **/
  @Schema(required = true, description = "Separador de los Elementos de la cuenta")
      @NotNull

    public String getSeparator() {
    return separator;
  }

  public void setSeparator(String separator) {
    this.separator = separator;
  }

  public AcctSchema updated(String updated) {
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

  public AcctSchema updatedby(Integer updatedby) {
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

  public AcctSchema additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public AcctSchema addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public AcctSchema referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public AcctSchema addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    AcctSchema acctSchema = (AcctSchema) o;
    return Objects.equals(this.adClientId, acctSchema.adClientId) &&
        Objects.equals(this.adOrgId, acctSchema.adOrgId) &&
        Objects.equals(this.autoperiodcontrol, acctSchema.autoperiodcontrol) &&
        Objects.equals(this.cAcctschemaId, acctSchema.cAcctschemaId) &&
        Objects.equals(this.cCurrencyId, acctSchema.cCurrencyId) &&
        Objects.equals(this.costingmethod, acctSchema.costingmethod) &&
        Objects.equals(this.created, acctSchema.created) &&
        Objects.equals(this.createdby, acctSchema.createdby) &&
        Objects.equals(this.description, acctSchema.description) &&
        Objects.equals(this.factacctbalanceactive, acctSchema.factacctbalanceactive) &&
        Objects.equals(this.gaap, acctSchema.gaap) &&
        Objects.equals(this.hasalias, acctSchema.hasalias) &&
        Objects.equals(this.hascombination, acctSchema.hascombination) &&
        Objects.equals(this.isaccrual, acctSchema.isaccrual) &&
        Objects.equals(this.isactive, acctSchema.isactive) &&
        Objects.equals(this.isdiscountcorrectstax, acctSchema.isdiscountcorrectstax) &&
        Objects.equals(this.istradediscountposted, acctSchema.istradediscountposted) &&
        Objects.equals(this.mCosttypeId, acctSchema.mCosttypeId) &&
        Objects.equals(this.name, acctSchema.name) &&
        Objects.equals(this.separator, acctSchema.separator) &&
        Objects.equals(this.updated, acctSchema.updated) &&
        Objects.equals(this.updatedby, acctSchema.updatedby) &&
        Objects.equals(this.additionalvalues, acctSchema.additionalvalues) &&
        Objects.equals(this.referencedvalues, acctSchema.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, autoperiodcontrol, cAcctschemaId, cCurrencyId, costingmethod, created, createdby, description, factacctbalanceactive, gaap, hasalias, hascombination, isaccrual, isactive, isdiscountcorrectstax, istradediscountposted, mCosttypeId, name, separator, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AcctSchema {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    autoperiodcontrol: ").append(toIndentedString(autoperiodcontrol)).append("\n");
    sb.append("    cAcctschemaId: ").append(toIndentedString(cAcctschemaId)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    costingmethod: ").append(toIndentedString(costingmethod)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    factacctbalanceactive: ").append(toIndentedString(factacctbalanceactive)).append("\n");
    sb.append("    gaap: ").append(toIndentedString(gaap)).append("\n");
    sb.append("    hasalias: ").append(toIndentedString(hasalias)).append("\n");
    sb.append("    hascombination: ").append(toIndentedString(hascombination)).append("\n");
    sb.append("    isaccrual: ").append(toIndentedString(isaccrual)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isdiscountcorrectstax: ").append(toIndentedString(isdiscountcorrectstax)).append("\n");
    sb.append("    istradediscountposted: ").append(toIndentedString(istradediscountposted)).append("\n");
    sb.append("    mCosttypeId: ").append(toIndentedString(mCosttypeId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    separator: ").append(toIndentedString(separator)).append("\n");
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
