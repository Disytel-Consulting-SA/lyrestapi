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
 * EntidadFinanciera
 */
@Validated



public class EntidadFinanciera   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("cardmask")
  private String cardmask = null;

  @JsonProperty("c_bankaccount_id")
  private Integer cBankaccountId = null;

  @JsonProperty("c_bankaccount_settlement_id")
  private Integer cBankaccountSettlementId = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("c_city_id")
  private Integer cCityId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("creditcardcashretirementlimit")
  private BigDecimal creditcardcashretirementlimit = null;

  @JsonProperty("creditcardtype")
  private String creditcardtype = null;

  @JsonProperty("c_region_id")
  private Integer cRegionId = null;

  @JsonProperty("establishmentnumber")
  private String establishmentnumber = null;

  @JsonProperty("financingservice")
  private String financingservice = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isallowcreditcardcashretirement")
  private Boolean isallowcreditcardcashretirement = null;

  @JsonProperty("m_entidadfinanciera_id")
  private Integer mEntidadfinancieraId = null;

  @JsonProperty("name")
  private String name = null;

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

  public EntidadFinanciera adClientId(Integer adClientId) {
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

  public EntidadFinanciera adComponentobjectuid(String adComponentobjectuid) {
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

  public EntidadFinanciera adOrgId(Integer adOrgId) {
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

  public EntidadFinanciera cardmask(String cardmask) {
    this.cardmask = cardmask;
    return this;
  }

  /**
   * Caracteres iniciales de la tarjeta que identifica la tarjeta o entidad financiera específica al pasarla por el lector en el TPV
   * @return cardmask
   **/
  @Schema(description = "Caracteres iniciales de la tarjeta que identifica la tarjeta o entidad financiera específica al pasarla por el lector en el TPV")
  
    public String getCardmask() {
    return cardmask;
  }

  public void setCardmask(String cardmask) {
    this.cardmask = cardmask;
  }

  public EntidadFinanciera cBankaccountId(Integer cBankaccountId) {
    this.cBankaccountId = cBankaccountId;
    return this;
  }

  /**
   * Cuenta Bancaria
   * @return cBankaccountId
   **/
  @Schema(required = true, description = "Cuenta Bancaria")
      @NotNull

    public Integer getCBankaccountId() {
    return cBankaccountId;
  }

  public void setCBankaccountId(Integer cBankaccountId) {
    this.cBankaccountId = cBankaccountId;
  }

  public EntidadFinanciera cBankaccountSettlementId(Integer cBankaccountSettlementId) {
    this.cBankaccountSettlementId = cBankaccountSettlementId;
    return this;
  }

  /**
   * Cuenta Bancaria utilizada para el pago resultante en Liquidaciones
   * @return cBankaccountSettlementId
   **/
  @Schema(description = "Cuenta Bancaria utilizada para el pago resultante en Liquidaciones")
  
    public Integer getCBankaccountSettlementId() {
    return cBankaccountSettlementId;
  }

  public void setCBankaccountSettlementId(Integer cBankaccountSettlementId) {
    this.cBankaccountSettlementId = cBankaccountSettlementId;
  }

  public EntidadFinanciera cBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
    return this;
  }

  /**
   * Identifica una Entidad Comercial
   * @return cBpartnerId
   **/
  @Schema(required = true, description = "Identifica una Entidad Comercial")
      @NotNull

    public Integer getCBpartnerId() {
    return cBpartnerId;
  }

  public void setCBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
  }

  public EntidadFinanciera cCityId(Integer cCityId) {
    this.cCityId = cCityId;
    return this;
  }

  /**
   * Ciudad
   * @return cCityId
   **/
  @Schema(description = "Ciudad")
  
    public Integer getCCityId() {
    return cCityId;
  }

  public void setCCityId(Integer cCityId) {
    this.cCityId = cCityId;
  }

  public EntidadFinanciera created(String created) {
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

  public EntidadFinanciera createdby(Integer createdby) {
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

  public EntidadFinanciera creditcardcashretirementlimit(BigDecimal creditcardcashretirementlimit) {
    this.creditcardcashretirementlimit = creditcardcashretirementlimit;
    return this;
  }

  /**
   * Límite de retiro de efectivo de tarjeta
   * @return creditcardcashretirementlimit
   **/
  @Schema(required = true, description = "Límite de retiro de efectivo de tarjeta")
      @NotNull

    @Valid
    public BigDecimal getCreditcardcashretirementlimit() {
    return creditcardcashretirementlimit;
  }

  public void setCreditcardcashretirementlimit(BigDecimal creditcardcashretirementlimit) {
    this.creditcardcashretirementlimit = creditcardcashretirementlimit;
  }

  public EntidadFinanciera creditcardtype(String creditcardtype) {
    this.creditcardtype = creditcardtype;
    return this;
  }

  /**
   * Tarjeta de Crédito 
   * @return creditcardtype
   **/
  @Schema(required = true, description = "Tarjeta de Crédito ")
      @NotNull

    public String getCreditcardtype() {
    return creditcardtype;
  }

  public void setCreditcardtype(String creditcardtype) {
    this.creditcardtype = creditcardtype;
  }

  public EntidadFinanciera cRegionId(Integer cRegionId) {
    this.cRegionId = cRegionId;
    return this;
  }

  /**
   * Identifica una región geográfica
   * @return cRegionId
   **/
  @Schema(description = "Identifica una región geográfica")
  
    public Integer getCRegionId() {
    return cRegionId;
  }

  public void setCRegionId(Integer cRegionId) {
    this.cRegionId = cRegionId;
  }

  public EntidadFinanciera establishmentnumber(String establishmentnumber) {
    this.establishmentnumber = establishmentnumber;
    return this;
  }

  /**
   * Nro de Comercio / Establecimiento
   * @return establishmentnumber
   **/
  @Schema(description = "Nro de Comercio / Establecimiento")
  
    public String getEstablishmentnumber() {
    return establishmentnumber;
  }

  public void setEstablishmentnumber(String establishmentnumber) {
    this.establishmentnumber = establishmentnumber;
  }

  public EntidadFinanciera financingservice(String financingservice) {
    this.financingservice = financingservice;
    return this;
  }

  /**
   *  
   * @return financingservice
   **/
  @Schema(description = " ")
  
    public String getFinancingservice() {
    return financingservice;
  }

  public void setFinancingservice(String financingservice) {
    this.financingservice = financingservice;
  }

  public EntidadFinanciera isactive(Boolean isactive) {
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

  public EntidadFinanciera isallowcreditcardcashretirement(Boolean isallowcreditcardcashretirement) {
    this.isallowcreditcardcashretirement = isallowcreditcardcashretirement;
    return this;
  }

  /**
   * El retiro de efectivo de tarjeta de crédito está permitido
   * @return isallowcreditcardcashretirement
   **/
  @Schema(required = true, description = "El retiro de efectivo de tarjeta de crédito está permitido")
      @NotNull

    public Boolean isIsallowcreditcardcashretirement() {
    return isallowcreditcardcashretirement;
  }

  public void setIsallowcreditcardcashretirement(Boolean isallowcreditcardcashretirement) {
    this.isallowcreditcardcashretirement = isallowcreditcardcashretirement;
  }

  public EntidadFinanciera mEntidadfinancieraId(Integer mEntidadfinancieraId) {
    this.mEntidadfinancieraId = mEntidadfinancieraId;
    return this;
  }

  /**
   *  
   * @return mEntidadfinancieraId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getMEntidadfinancieraId() {
    return mEntidadfinancieraId;
  }

  public void setMEntidadfinancieraId(Integer mEntidadfinancieraId) {
    this.mEntidadfinancieraId = mEntidadfinancieraId;
  }

  public EntidadFinanciera name(String name) {
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

  public EntidadFinanciera updated(String updated) {
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

  public EntidadFinanciera updatedby(Integer updatedby) {
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

  public EntidadFinanciera value(String value) {
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

  public EntidadFinanciera additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public EntidadFinanciera addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public EntidadFinanciera referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public EntidadFinanciera addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    EntidadFinanciera entidadFinanciera = (EntidadFinanciera) o;
    return Objects.equals(this.adClientId, entidadFinanciera.adClientId) &&
        Objects.equals(this.adComponentobjectuid, entidadFinanciera.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, entidadFinanciera.adOrgId) &&
        Objects.equals(this.cardmask, entidadFinanciera.cardmask) &&
        Objects.equals(this.cBankaccountId, entidadFinanciera.cBankaccountId) &&
        Objects.equals(this.cBankaccountSettlementId, entidadFinanciera.cBankaccountSettlementId) &&
        Objects.equals(this.cBpartnerId, entidadFinanciera.cBpartnerId) &&
        Objects.equals(this.cCityId, entidadFinanciera.cCityId) &&
        Objects.equals(this.created, entidadFinanciera.created) &&
        Objects.equals(this.createdby, entidadFinanciera.createdby) &&
        Objects.equals(this.creditcardcashretirementlimit, entidadFinanciera.creditcardcashretirementlimit) &&
        Objects.equals(this.creditcardtype, entidadFinanciera.creditcardtype) &&
        Objects.equals(this.cRegionId, entidadFinanciera.cRegionId) &&
        Objects.equals(this.establishmentnumber, entidadFinanciera.establishmentnumber) &&
        Objects.equals(this.financingservice, entidadFinanciera.financingservice) &&
        Objects.equals(this.isactive, entidadFinanciera.isactive) &&
        Objects.equals(this.isallowcreditcardcashretirement, entidadFinanciera.isallowcreditcardcashretirement) &&
        Objects.equals(this.mEntidadfinancieraId, entidadFinanciera.mEntidadfinancieraId) &&
        Objects.equals(this.name, entidadFinanciera.name) &&
        Objects.equals(this.updated, entidadFinanciera.updated) &&
        Objects.equals(this.updatedby, entidadFinanciera.updatedby) &&
        Objects.equals(this.value, entidadFinanciera.value) &&
        Objects.equals(this.additionalvalues, entidadFinanciera.additionalvalues) &&
        Objects.equals(this.referencedvalues, entidadFinanciera.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adOrgId, cardmask, cBankaccountId, cBankaccountSettlementId, cBpartnerId, cCityId, created, createdby, creditcardcashretirementlimit, creditcardtype, cRegionId, establishmentnumber, financingservice, isactive, isallowcreditcardcashretirement, mEntidadfinancieraId, name, updated, updatedby, value, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntidadFinanciera {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cardmask: ").append(toIndentedString(cardmask)).append("\n");
    sb.append("    cBankaccountId: ").append(toIndentedString(cBankaccountId)).append("\n");
    sb.append("    cBankaccountSettlementId: ").append(toIndentedString(cBankaccountSettlementId)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    cCityId: ").append(toIndentedString(cCityId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    creditcardcashretirementlimit: ").append(toIndentedString(creditcardcashretirementlimit)).append("\n");
    sb.append("    creditcardtype: ").append(toIndentedString(creditcardtype)).append("\n");
    sb.append("    cRegionId: ").append(toIndentedString(cRegionId)).append("\n");
    sb.append("    establishmentnumber: ").append(toIndentedString(establishmentnumber)).append("\n");
    sb.append("    financingservice: ").append(toIndentedString(financingservice)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isallowcreditcardcashretirement: ").append(toIndentedString(isallowcreditcardcashretirement)).append("\n");
    sb.append("    mEntidadfinancieraId: ").append(toIndentedString(mEntidadfinancieraId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
