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
 * NumeroComercio
 */
@Validated



public class NumeroComercio   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("adquirente")
  private String adquirente = null;

  @JsonProperty("c_bankaccount_id")
  private Integer cBankaccountId = null;

  @JsonProperty("c_bankaccount_settlement_id")
  private Integer cBankaccountSettlementId = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("financingservice")
  private String financingservice = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("m_numerocomercio_id")
  private Integer mNumerocomercioId = null;

  @JsonProperty("numerocomercio")
  private String numerocomercio = null;

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

  public NumeroComercio adClientId(Integer adClientId) {
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

  public NumeroComercio adOrgId(Integer adOrgId) {
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

  public NumeroComercio adquirente(String adquirente) {
    this.adquirente = adquirente;
    return this;
  }

  /**
   *  
   * @return adquirente
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public String getAdquirente() {
    return adquirente;
  }

  public void setAdquirente(String adquirente) {
    this.adquirente = adquirente;
  }

  public NumeroComercio cBankaccountId(Integer cBankaccountId) {
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

  public NumeroComercio cBankaccountSettlementId(Integer cBankaccountSettlementId) {
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

  public NumeroComercio cBpartnerId(Integer cBpartnerId) {
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

  public NumeroComercio created(String created) {
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

  public NumeroComercio createdby(Integer createdby) {
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

  public NumeroComercio financingservice(String financingservice) {
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

  public NumeroComercio isactive(Boolean isactive) {
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

  public NumeroComercio mNumerocomercioId(Integer mNumerocomercioId) {
    this.mNumerocomercioId = mNumerocomercioId;
    return this;
  }

  /**
   *  
   * @return mNumerocomercioId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getMNumerocomercioId() {
    return mNumerocomercioId;
  }

  public void setMNumerocomercioId(Integer mNumerocomercioId) {
    this.mNumerocomercioId = mNumerocomercioId;
  }

  public NumeroComercio numerocomercio(String numerocomercio) {
    this.numerocomercio = numerocomercio;
    return this;
  }

  /**
   *  
   * @return numerocomercio
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public String getNumerocomercio() {
    return numerocomercio;
  }

  public void setNumerocomercio(String numerocomercio) {
    this.numerocomercio = numerocomercio;
  }

  public NumeroComercio updated(String updated) {
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

  public NumeroComercio updatedby(Integer updatedby) {
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

  public NumeroComercio value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Clave de búsqueda para el registro en el formato requerido; debe ser única
   * @return value
   **/
  @Schema(description = "Clave de búsqueda para el registro en el formato requerido; debe ser única")
  
    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public NumeroComercio additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public NumeroComercio addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public NumeroComercio referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public NumeroComercio addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    NumeroComercio numeroComercio = (NumeroComercio) o;
    return Objects.equals(this.adClientId, numeroComercio.adClientId) &&
        Objects.equals(this.adOrgId, numeroComercio.adOrgId) &&
        Objects.equals(this.adquirente, numeroComercio.adquirente) &&
        Objects.equals(this.cBankaccountId, numeroComercio.cBankaccountId) &&
        Objects.equals(this.cBankaccountSettlementId, numeroComercio.cBankaccountSettlementId) &&
        Objects.equals(this.cBpartnerId, numeroComercio.cBpartnerId) &&
        Objects.equals(this.created, numeroComercio.created) &&
        Objects.equals(this.createdby, numeroComercio.createdby) &&
        Objects.equals(this.financingservice, numeroComercio.financingservice) &&
        Objects.equals(this.isactive, numeroComercio.isactive) &&
        Objects.equals(this.mNumerocomercioId, numeroComercio.mNumerocomercioId) &&
        Objects.equals(this.numerocomercio, numeroComercio.numerocomercio) &&
        Objects.equals(this.updated, numeroComercio.updated) &&
        Objects.equals(this.updatedby, numeroComercio.updatedby) &&
        Objects.equals(this.value, numeroComercio.value) &&
        Objects.equals(this.additionalvalues, numeroComercio.additionalvalues) &&
        Objects.equals(this.referencedvalues, numeroComercio.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, adquirente, cBankaccountId, cBankaccountSettlementId, cBpartnerId, created, createdby, financingservice, isactive, mNumerocomercioId, numerocomercio, updated, updatedby, value, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NumeroComercio {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    adquirente: ").append(toIndentedString(adquirente)).append("\n");
    sb.append("    cBankaccountId: ").append(toIndentedString(cBankaccountId)).append("\n");
    sb.append("    cBankaccountSettlementId: ").append(toIndentedString(cBankaccountSettlementId)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    financingservice: ").append(toIndentedString(financingservice)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    mNumerocomercioId: ").append(toIndentedString(mNumerocomercioId)).append("\n");
    sb.append("    numerocomercio: ").append(toIndentedString(numerocomercio)).append("\n");
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
