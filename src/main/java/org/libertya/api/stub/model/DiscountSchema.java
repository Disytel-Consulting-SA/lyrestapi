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
 * DiscountSchema
 */
@Validated



public class DiscountSchema   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("cumulativelevel")
  private String cumulativelevel = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("discountapplication")
  private String discountapplication = null;

  @JsonProperty("discountcontexttype")
  private String discountcontexttype = null;

  @JsonProperty("discounttype")
  private String discounttype = null;

  @JsonProperty("flatdiscount")
  private BigDecimal flatdiscount = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isbpartnerflatdiscount")
  private Boolean isbpartnerflatdiscount = null;

  @JsonProperty("isbpartnerscope")
  private Boolean isbpartnerscope = null;

  @JsonProperty("isgeneralscope")
  private Boolean isgeneralscope = null;

  @JsonProperty("isquantitybased")
  private Boolean isquantitybased = null;

  @JsonProperty("m_discountschema_id")
  private Integer mDiscountschemaId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("processing")
  private String processing = null;

  @JsonProperty("script")
  private String script = null;

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

  public DiscountSchema adClientId(Integer adClientId) {
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

  public DiscountSchema adComponentobjectuid(String adComponentobjectuid) {
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

  public DiscountSchema adOrgId(Integer adOrgId) {
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

  public DiscountSchema created(String created) {
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

  public DiscountSchema createdby(Integer createdby) {
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

  public DiscountSchema cumulativelevel(String cumulativelevel) {
    this.cumulativelevel = cumulativelevel;
    return this;
  }

  /**
   * Nivel para cálculos acumulados
   * @return cumulativelevel
   **/
  @Schema(required = true, description = "Nivel para cálculos acumulados")
      @NotNull

    public String getCumulativelevel() {
    return cumulativelevel;
  }

  public void setCumulativelevel(String cumulativelevel) {
    this.cumulativelevel = cumulativelevel;
  }

  public DiscountSchema description(String description) {
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

  public DiscountSchema discountapplication(String discountapplication) {
    this.discountapplication = discountapplication;
    return this;
  }

  /**
   * Forma de Aplicación del Descuento
   * @return discountapplication
   **/
  @Schema(required = true, description = "Forma de Aplicación del Descuento")
      @NotNull

    public String getDiscountapplication() {
    return discountapplication;
  }

  public void setDiscountapplication(String discountapplication) {
    this.discountapplication = discountapplication;
  }

  public DiscountSchema discountcontexttype(String discountcontexttype) {
    this.discountcontexttype = discountcontexttype;
    return this;
  }

  /**
   * Tipo de Contexto de uso de este esquema de descuento
   * @return discountcontexttype
   **/
  @Schema(required = true, description = "Tipo de Contexto de uso de este esquema de descuento")
      @NotNull

    public String getDiscountcontexttype() {
    return discountcontexttype;
  }

  public void setDiscountcontexttype(String discountcontexttype) {
    this.discountcontexttype = discountcontexttype;
  }

  public DiscountSchema discounttype(String discounttype) {
    this.discounttype = discounttype;
    return this;
  }

  /**
   * Tipo de cálculo del descuento comercial
   * @return discounttype
   **/
  @Schema(required = true, description = "Tipo de cálculo del descuento comercial")
      @NotNull

    public String getDiscounttype() {
    return discounttype;
  }

  public void setDiscounttype(String discounttype) {
    this.discounttype = discounttype;
  }

  public DiscountSchema flatdiscount(BigDecimal flatdiscount) {
    this.flatdiscount = flatdiscount;
    return this;
  }

  /**
   * Porcentaje de descuento simple
   * @return flatdiscount
   **/
  @Schema(description = "Porcentaje de descuento simple")
  
    @Valid
    public BigDecimal getFlatdiscount() {
    return flatdiscount;
  }

  public void setFlatdiscount(BigDecimal flatdiscount) {
    this.flatdiscount = flatdiscount;
  }

  public DiscountSchema isactive(Boolean isactive) {
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

  public DiscountSchema isbpartnerflatdiscount(Boolean isbpartnerflatdiscount) {
    this.isbpartnerflatdiscount = isbpartnerflatdiscount;
    return this;
  }

  /**
   * Descuento Neto de Entidad Comercial
   * @return isbpartnerflatdiscount
   **/
  @Schema(required = true, description = "Descuento Neto de Entidad Comercial")
      @NotNull

    public Boolean isIsbpartnerflatdiscount() {
    return isbpartnerflatdiscount;
  }

  public void setIsbpartnerflatdiscount(Boolean isbpartnerflatdiscount) {
    this.isbpartnerflatdiscount = isbpartnerflatdiscount;
  }

  public DiscountSchema isbpartnerscope(Boolean isbpartnerscope) {
    this.isbpartnerscope = isbpartnerscope;
    return this;
  }

  /**
   * El esquema está destinado a la configuración de Entidad Comercial
   * @return isbpartnerscope
   **/
  @Schema(required = true, description = "El esquema está destinado a la configuración de Entidad Comercial")
      @NotNull

    public Boolean isIsbpartnerscope() {
    return isbpartnerscope;
  }

  public void setIsbpartnerscope(Boolean isbpartnerscope) {
    this.isbpartnerscope = isbpartnerscope;
  }

  public DiscountSchema isgeneralscope(Boolean isgeneralscope) {
    this.isgeneralscope = isgeneralscope;
    return this;
  }

  /**
   * El esquema contiene descuentos de aplicación general en el sistema
   * @return isgeneralscope
   **/
  @Schema(required = true, description = "El esquema contiene descuentos de aplicación general en el sistema")
      @NotNull

    public Boolean isIsgeneralscope() {
    return isgeneralscope;
  }

  public void setIsgeneralscope(Boolean isgeneralscope) {
    this.isgeneralscope = isgeneralscope;
  }

  public DiscountSchema isquantitybased(Boolean isquantitybased) {
    this.isquantitybased = isquantitybased;
    return this;
  }

  /**
   * Nivel de corte del descuento comercial en cantidad (No en valor)
   * @return isquantitybased
   **/
  @Schema(required = true, description = "Nivel de corte del descuento comercial en cantidad (No en valor)")
      @NotNull

    public Boolean isIsquantitybased() {
    return isquantitybased;
  }

  public void setIsquantitybased(Boolean isquantitybased) {
    this.isquantitybased = isquantitybased;
  }

  public DiscountSchema mDiscountschemaId(Integer mDiscountschemaId) {
    this.mDiscountschemaId = mDiscountschemaId;
    return this;
  }

  /**
   * Esquema para calcular el porcentaje de descuento comercial
   * @return mDiscountschemaId
   **/
  @Schema(required = true, description = "Esquema para calcular el porcentaje de descuento comercial")
      @NotNull

    public Integer getMDiscountschemaId() {
    return mDiscountschemaId;
  }

  public void setMDiscountschemaId(Integer mDiscountschemaId) {
    this.mDiscountschemaId = mDiscountschemaId;
  }

  public DiscountSchema name(String name) {
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

  public DiscountSchema processing(String processing) {
    this.processing = processing;
    return this;
  }

  /**
   *  
   * @return processing
   **/
  @Schema(description = " ")
  
    public String getProcessing() {
    return processing;
  }

  public void setProcessing(String processing) {
    this.processing = processing;
  }

  public DiscountSchema script(String script) {
    this.script = script;
    return this;
  }

  /**
   * Script de lenguaje Java para calcular resultados
   * @return script
   **/
  @Schema(description = "Script de lenguaje Java para calcular resultados")
  
    public String getScript() {
    return script;
  }

  public void setScript(String script) {
    this.script = script;
  }

  public DiscountSchema updated(String updated) {
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

  public DiscountSchema updatedby(Integer updatedby) {
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

  public DiscountSchema validfrom(String validfrom) {
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

  public DiscountSchema validto(String validto) {
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

  public DiscountSchema additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public DiscountSchema addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public DiscountSchema referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public DiscountSchema addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    DiscountSchema discountSchema = (DiscountSchema) o;
    return Objects.equals(this.adClientId, discountSchema.adClientId) &&
        Objects.equals(this.adComponentobjectuid, discountSchema.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, discountSchema.adOrgId) &&
        Objects.equals(this.created, discountSchema.created) &&
        Objects.equals(this.createdby, discountSchema.createdby) &&
        Objects.equals(this.cumulativelevel, discountSchema.cumulativelevel) &&
        Objects.equals(this.description, discountSchema.description) &&
        Objects.equals(this.discountapplication, discountSchema.discountapplication) &&
        Objects.equals(this.discountcontexttype, discountSchema.discountcontexttype) &&
        Objects.equals(this.discounttype, discountSchema.discounttype) &&
        Objects.equals(this.flatdiscount, discountSchema.flatdiscount) &&
        Objects.equals(this.isactive, discountSchema.isactive) &&
        Objects.equals(this.isbpartnerflatdiscount, discountSchema.isbpartnerflatdiscount) &&
        Objects.equals(this.isbpartnerscope, discountSchema.isbpartnerscope) &&
        Objects.equals(this.isgeneralscope, discountSchema.isgeneralscope) &&
        Objects.equals(this.isquantitybased, discountSchema.isquantitybased) &&
        Objects.equals(this.mDiscountschemaId, discountSchema.mDiscountschemaId) &&
        Objects.equals(this.name, discountSchema.name) &&
        Objects.equals(this.processing, discountSchema.processing) &&
        Objects.equals(this.script, discountSchema.script) &&
        Objects.equals(this.updated, discountSchema.updated) &&
        Objects.equals(this.updatedby, discountSchema.updatedby) &&
        Objects.equals(this.validfrom, discountSchema.validfrom) &&
        Objects.equals(this.validto, discountSchema.validto) &&
        Objects.equals(this.additionalvalues, discountSchema.additionalvalues) &&
        Objects.equals(this.referencedvalues, discountSchema.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adOrgId, created, createdby, cumulativelevel, description, discountapplication, discountcontexttype, discounttype, flatdiscount, isactive, isbpartnerflatdiscount, isbpartnerscope, isgeneralscope, isquantitybased, mDiscountschemaId, name, processing, script, updated, updatedby, validfrom, validto, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DiscountSchema {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cumulativelevel: ").append(toIndentedString(cumulativelevel)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    discountapplication: ").append(toIndentedString(discountapplication)).append("\n");
    sb.append("    discountcontexttype: ").append(toIndentedString(discountcontexttype)).append("\n");
    sb.append("    discounttype: ").append(toIndentedString(discounttype)).append("\n");
    sb.append("    flatdiscount: ").append(toIndentedString(flatdiscount)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isbpartnerflatdiscount: ").append(toIndentedString(isbpartnerflatdiscount)).append("\n");
    sb.append("    isbpartnerscope: ").append(toIndentedString(isbpartnerscope)).append("\n");
    sb.append("    isgeneralscope: ").append(toIndentedString(isgeneralscope)).append("\n");
    sb.append("    isquantitybased: ").append(toIndentedString(isquantitybased)).append("\n");
    sb.append("    mDiscountschemaId: ").append(toIndentedString(mDiscountschemaId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    processing: ").append(toIndentedString(processing)).append("\n");
    sb.append("    script: ").append(toIndentedString(script)).append("\n");
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
