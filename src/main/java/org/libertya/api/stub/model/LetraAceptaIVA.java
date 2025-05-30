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
 * LetraAceptaIVA
 */
@Validated



public class LetraAceptaIVA   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("categoria_customer")
  private Integer categoriaCustomer = null;

  @JsonProperty("categoria_vendor")
  private Integer categoriaVendor = null;

  @JsonProperty("c_letra_acepta_iva_id")
  private Integer cLetraAceptaIvaId = null;

  @JsonProperty("c_letra_comprobante_id")
  private Integer cLetraComprobanteId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_tax_id")
  private Integer cTaxId = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("montomax")
  private BigDecimal montomax = null;

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

  public LetraAceptaIVA adClientId(Integer adClientId) {
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

  public LetraAceptaIVA adComponentobjectuid(String adComponentobjectuid) {
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

  public LetraAceptaIVA adOrgId(Integer adOrgId) {
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

  public LetraAceptaIVA categoriaCustomer(Integer categoriaCustomer) {
    this.categoriaCustomer = categoriaCustomer;
    return this;
  }

  /**
   *  
   * @return categoriaCustomer
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCategoriaCustomer() {
    return categoriaCustomer;
  }

  public void setCategoriaCustomer(Integer categoriaCustomer) {
    this.categoriaCustomer = categoriaCustomer;
  }

  public LetraAceptaIVA categoriaVendor(Integer categoriaVendor) {
    this.categoriaVendor = categoriaVendor;
    return this;
  }

  /**
   *  
   * @return categoriaVendor
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCategoriaVendor() {
    return categoriaVendor;
  }

  public void setCategoriaVendor(Integer categoriaVendor) {
    this.categoriaVendor = categoriaVendor;
  }

  public LetraAceptaIVA cLetraAceptaIvaId(Integer cLetraAceptaIvaId) {
    this.cLetraAceptaIvaId = cLetraAceptaIvaId;
    return this;
  }

  /**
   *  
   * @return cLetraAceptaIvaId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCLetraAceptaIvaId() {
    return cLetraAceptaIvaId;
  }

  public void setCLetraAceptaIvaId(Integer cLetraAceptaIvaId) {
    this.cLetraAceptaIvaId = cLetraAceptaIvaId;
  }

  public LetraAceptaIVA cLetraComprobanteId(Integer cLetraComprobanteId) {
    this.cLetraComprobanteId = cLetraComprobanteId;
    return this;
  }

  /**
   *  
   * @return cLetraComprobanteId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCLetraComprobanteId() {
    return cLetraComprobanteId;
  }

  public void setCLetraComprobanteId(Integer cLetraComprobanteId) {
    this.cLetraComprobanteId = cLetraComprobanteId;
  }

  public LetraAceptaIVA created(String created) {
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

  public LetraAceptaIVA createdby(Integer createdby) {
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

  public LetraAceptaIVA cTaxId(Integer cTaxId) {
    this.cTaxId = cTaxId;
    return this;
  }

  /**
   * Identificador del Impuesto
   * @return cTaxId
   **/
  @Schema(description = "Identificador del Impuesto")
  
    public Integer getCTaxId() {
    return cTaxId;
  }

  public void setCTaxId(Integer cTaxId) {
    this.cTaxId = cTaxId;
  }

  public LetraAceptaIVA isactive(Boolean isactive) {
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

  public LetraAceptaIVA montomax(BigDecimal montomax) {
    this.montomax = montomax;
    return this;
  }

  /**
   *  
   * @return montomax
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getMontomax() {
    return montomax;
  }

  public void setMontomax(BigDecimal montomax) {
    this.montomax = montomax;
  }

  public LetraAceptaIVA updated(String updated) {
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

  public LetraAceptaIVA updatedby(Integer updatedby) {
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

  public LetraAceptaIVA additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public LetraAceptaIVA addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public LetraAceptaIVA referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public LetraAceptaIVA addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    LetraAceptaIVA letraAceptaIVA = (LetraAceptaIVA) o;
    return Objects.equals(this.adClientId, letraAceptaIVA.adClientId) &&
        Objects.equals(this.adComponentobjectuid, letraAceptaIVA.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, letraAceptaIVA.adOrgId) &&
        Objects.equals(this.categoriaCustomer, letraAceptaIVA.categoriaCustomer) &&
        Objects.equals(this.categoriaVendor, letraAceptaIVA.categoriaVendor) &&
        Objects.equals(this.cLetraAceptaIvaId, letraAceptaIVA.cLetraAceptaIvaId) &&
        Objects.equals(this.cLetraComprobanteId, letraAceptaIVA.cLetraComprobanteId) &&
        Objects.equals(this.created, letraAceptaIVA.created) &&
        Objects.equals(this.createdby, letraAceptaIVA.createdby) &&
        Objects.equals(this.cTaxId, letraAceptaIVA.cTaxId) &&
        Objects.equals(this.isactive, letraAceptaIVA.isactive) &&
        Objects.equals(this.montomax, letraAceptaIVA.montomax) &&
        Objects.equals(this.updated, letraAceptaIVA.updated) &&
        Objects.equals(this.updatedby, letraAceptaIVA.updatedby) &&
        Objects.equals(this.additionalvalues, letraAceptaIVA.additionalvalues) &&
        Objects.equals(this.referencedvalues, letraAceptaIVA.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adOrgId, categoriaCustomer, categoriaVendor, cLetraAceptaIvaId, cLetraComprobanteId, created, createdby, cTaxId, isactive, montomax, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LetraAceptaIVA {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    categoriaCustomer: ").append(toIndentedString(categoriaCustomer)).append("\n");
    sb.append("    categoriaVendor: ").append(toIndentedString(categoriaVendor)).append("\n");
    sb.append("    cLetraAceptaIvaId: ").append(toIndentedString(cLetraAceptaIvaId)).append("\n");
    sb.append("    cLetraComprobanteId: ").append(toIndentedString(cLetraComprobanteId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cTaxId: ").append(toIndentedString(cTaxId)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    montomax: ").append(toIndentedString(montomax)).append("\n");
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
