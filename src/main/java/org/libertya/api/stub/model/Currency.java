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
 * Currency
 */
@Validated



public class Currency   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("costingprecision")
  private Integer costingprecision = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("cursymbol")
  private String cursymbol = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("emuentrydate")
  private String emuentrydate = null;

  @JsonProperty("emurate")
  private BigDecimal emurate = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isemumember")
  private Boolean isemumember = null;

  @JsonProperty("iseuro")
  private Boolean iseuro = null;

  @JsonProperty("iso_code")
  private String isoCode = null;

  @JsonProperty("stdprecision")
  private Integer stdprecision = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("wsfecode")
  private String wsfecode = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public Currency adClientId(Integer adClientId) {
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

  public Currency adComponentobjectuid(String adComponentobjectuid) {
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

  public Currency adOrgId(Integer adOrgId) {
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

  public Currency cCurrencyId(Integer cCurrencyId) {
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

  public Currency costingprecision(Integer costingprecision) {
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

  public Currency created(String created) {
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

  public Currency createdby(Integer createdby) {
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

  public Currency cursymbol(String cursymbol) {
    this.cursymbol = cursymbol;
    return this;
  }

  /**
   * Símbolo de la Moneda (opción usada sólo para impresión)
   * @return cursymbol
   **/
  @Schema(description = "Símbolo de la Moneda (opción usada sólo para impresión)")
  
    public String getCursymbol() {
    return cursymbol;
  }

  public void setCursymbol(String cursymbol) {
    this.cursymbol = cursymbol;
  }

  public Currency description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Descripción corta opcional del registro
   * @return description
   **/
  @Schema(required = true, description = "Descripción corta opcional del registro")
      @NotNull

    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Currency emuentrydate(String emuentrydate) {
    this.emuentrydate = emuentrydate;
    return this;
  }

  /**
   * Fecha en que la moneda se unió / unirá a la EMU
   * @return emuentrydate
   **/
  @Schema(description = "Fecha en que la moneda se unió / unirá a la EMU")
  
    public String getEmuentrydate() {
    return emuentrydate;
  }

  public void setEmuentrydate(String emuentrydate) {
    this.emuentrydate = emuentrydate;
  }

  public Currency emurate(BigDecimal emurate) {
    this.emurate = emurate;
    return this;
  }

  /**
   * Tasa oficial para convertir al Euro
   * @return emurate
   **/
  @Schema(description = "Tasa oficial para convertir al Euro")
  
    @Valid
    public BigDecimal getEmurate() {
    return emurate;
  }

  public void setEmurate(BigDecimal emurate) {
    this.emurate = emurate;
  }

  public Currency isactive(Boolean isactive) {
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

  public Currency isemumember(Boolean isemumember) {
    this.isemumember = isemumember;
    return this;
  }

  /**
   * La moneda es una moneda de la Unión Monetaria Europea
   * @return isemumember
   **/
  @Schema(required = true, description = "La moneda es una moneda de la Unión Monetaria Europea")
      @NotNull

    public Boolean isIsemumember() {
    return isemumember;
  }

  public void setIsemumember(Boolean isemumember) {
    this.isemumember = isemumember;
  }

  public Currency iseuro(Boolean iseuro) {
    this.iseuro = iseuro;
    return this;
  }

  /**
   * La moneda es el Euro
   * @return iseuro
   **/
  @Schema(required = true, description = "La moneda es el Euro")
      @NotNull

    public Boolean isIseuro() {
    return iseuro;
  }

  public void setIseuro(Boolean iseuro) {
    this.iseuro = iseuro;
  }

  public Currency isoCode(String isoCode) {
    this.isoCode = isoCode;
    return this;
  }

  /**
   * Código ISO 4217 de la moneda
   * @return isoCode
   **/
  @Schema(required = true, description = "Código ISO 4217 de la moneda")
      @NotNull

    public String getIsoCode() {
    return isoCode;
  }

  public void setIsoCode(String isoCode) {
    this.isoCode = isoCode;
  }

  public Currency stdprecision(Integer stdprecision) {
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

  public Currency updated(String updated) {
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

  public Currency updatedby(Integer updatedby) {
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

  public Currency wsfecode(String wsfecode) {
    this.wsfecode = wsfecode;
    return this;
  }

  /**
   * Código WSFE
   * @return wsfecode
   **/
  @Schema(description = "Código WSFE")
  
    public String getWsfecode() {
    return wsfecode;
  }

  public void setWsfecode(String wsfecode) {
    this.wsfecode = wsfecode;
  }

  public Currency additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Currency addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Currency referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Currency addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Currency currency = (Currency) o;
    return Objects.equals(this.adClientId, currency.adClientId) &&
        Objects.equals(this.adComponentobjectuid, currency.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, currency.adOrgId) &&
        Objects.equals(this.cCurrencyId, currency.cCurrencyId) &&
        Objects.equals(this.costingprecision, currency.costingprecision) &&
        Objects.equals(this.created, currency.created) &&
        Objects.equals(this.createdby, currency.createdby) &&
        Objects.equals(this.cursymbol, currency.cursymbol) &&
        Objects.equals(this.description, currency.description) &&
        Objects.equals(this.emuentrydate, currency.emuentrydate) &&
        Objects.equals(this.emurate, currency.emurate) &&
        Objects.equals(this.isactive, currency.isactive) &&
        Objects.equals(this.isemumember, currency.isemumember) &&
        Objects.equals(this.iseuro, currency.iseuro) &&
        Objects.equals(this.isoCode, currency.isoCode) &&
        Objects.equals(this.stdprecision, currency.stdprecision) &&
        Objects.equals(this.updated, currency.updated) &&
        Objects.equals(this.updatedby, currency.updatedby) &&
        Objects.equals(this.wsfecode, currency.wsfecode) &&
        Objects.equals(this.additionalvalues, currency.additionalvalues) &&
        Objects.equals(this.referencedvalues, currency.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adOrgId, cCurrencyId, costingprecision, created, createdby, cursymbol, description, emuentrydate, emurate, isactive, isemumember, iseuro, isoCode, stdprecision, updated, updatedby, wsfecode, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Currency {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    costingprecision: ").append(toIndentedString(costingprecision)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cursymbol: ").append(toIndentedString(cursymbol)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    emuentrydate: ").append(toIndentedString(emuentrydate)).append("\n");
    sb.append("    emurate: ").append(toIndentedString(emurate)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isemumember: ").append(toIndentedString(isemumember)).append("\n");
    sb.append("    iseuro: ").append(toIndentedString(iseuro)).append("\n");
    sb.append("    isoCode: ").append(toIndentedString(isoCode)).append("\n");
    sb.append("    stdprecision: ").append(toIndentedString(stdprecision)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    wsfecode: ").append(toIndentedString(wsfecode)).append("\n");
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
