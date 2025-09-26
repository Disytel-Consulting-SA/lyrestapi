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
 * DiscountSchemaBreak
 */
@Validated



public class DiscountSchemaBreak   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("applicationpolicy")
  private String applicationpolicy = null;

  @JsonProperty("breakdiscount")
  private BigDecimal breakdiscount = null;

  @JsonProperty("breakvalue")
  private BigDecimal breakvalue = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isappliedeveryday")
  private Boolean isappliedeveryday = null;

  @JsonProperty("isappliedonfriday")
  private Boolean isappliedonfriday = null;

  @JsonProperty("isappliedonmonday")
  private Boolean isappliedonmonday = null;

  @JsonProperty("isappliedonsaturday")
  private Boolean isappliedonsaturday = null;

  @JsonProperty("isappliedonsunday")
  private Boolean isappliedonsunday = null;

  @JsonProperty("isappliedonthursday")
  private Boolean isappliedonthursday = null;

  @JsonProperty("isappliedontuesday")
  private Boolean isappliedontuesday = null;

  @JsonProperty("isappliedonwednesday")
  private Boolean isappliedonwednesday = null;

  @JsonProperty("isbpartnerflatdiscount")
  private Boolean isbpartnerflatdiscount = null;

  @JsonProperty("isbreak")
  private Boolean isbreak = null;

  @JsonProperty("m_discountschemabreak_id")
  private Integer mDiscountschemabreakId = null;

  @JsonProperty("m_discountschema_id")
  private Integer mDiscountschemaId = null;

  @JsonProperty("m_product_category_id")
  private Integer mProductCategoryId = null;

  @JsonProperty("m_product_gamas_id")
  private Integer mProductGamasId = null;

  @JsonProperty("m_product_id")
  private Integer mProductId = null;

  @JsonProperty("m_product_lines_id")
  private Integer mProductLinesId = null;

  @JsonProperty("price_gross")
  private BigDecimal priceGross = null;

  @JsonProperty("seqno")
  private Integer seqno = null;

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

  public DiscountSchemaBreak adClientId(Integer adClientId) {
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

  public DiscountSchemaBreak adComponentobjectuid(String adComponentobjectuid) {
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

  public DiscountSchemaBreak adOrgId(Integer adOrgId) {
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

  public DiscountSchemaBreak applicationpolicy(String applicationpolicy) {
    this.applicationpolicy = applicationpolicy;
    return this;
  }

  /**
   * Forma de evaluación de las condiciones para determinar la aplicación del descuento
   * @return applicationpolicy
   **/
  @Schema(required = true, description = "Forma de evaluación de las condiciones para determinar la aplicación del descuento")
      @NotNull

    public String getApplicationpolicy() {
    return applicationpolicy;
  }

  public void setApplicationpolicy(String applicationpolicy) {
    this.applicationpolicy = applicationpolicy;
  }

  public DiscountSchemaBreak breakdiscount(BigDecimal breakdiscount) {
    this.breakdiscount = breakdiscount;
    return this;
  }

  /**
   * Descuento Comercial en porcentaje para el nivel de corte
   * @return breakdiscount
   **/
  @Schema(required = true, description = "Descuento Comercial en porcentaje para el nivel de corte")
      @NotNull

    @Valid
    public BigDecimal getBreakdiscount() {
    return breakdiscount;
  }

  public void setBreakdiscount(BigDecimal breakdiscount) {
    this.breakdiscount = breakdiscount;
  }

  public DiscountSchemaBreak breakvalue(BigDecimal breakvalue) {
    this.breakvalue = breakvalue;
    return this;
  }

  /**
   * Valor mínimo para el valor de corte del descuento
   * @return breakvalue
   **/
  @Schema(required = true, description = "Valor mínimo para el valor de corte del descuento")
      @NotNull

    @Valid
    public BigDecimal getBreakvalue() {
    return breakvalue;
  }

  public void setBreakvalue(BigDecimal breakvalue) {
    this.breakvalue = breakvalue;
  }

  public DiscountSchemaBreak cBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
    return this;
  }

  /**
   * Identifica una Entidad Comercial
   * @return cBpartnerId
   **/
  @Schema(description = "Identifica una Entidad Comercial")
  
    public Integer getCBpartnerId() {
    return cBpartnerId;
  }

  public void setCBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
  }

  public DiscountSchemaBreak created(String created) {
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

  public DiscountSchemaBreak createdby(Integer createdby) {
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

  public DiscountSchemaBreak isactive(Boolean isactive) {
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

  public DiscountSchemaBreak isappliedeveryday(Boolean isappliedeveryday) {
    this.isappliedeveryday = isappliedeveryday;
    return this;
  }

  /**
   * Se aplica todos los días de la semana
   * @return isappliedeveryday
   **/
  @Schema(required = true, description = "Se aplica todos los días de la semana")
      @NotNull

    public Boolean isIsappliedeveryday() {
    return isappliedeveryday;
  }

  public void setIsappliedeveryday(Boolean isappliedeveryday) {
    this.isappliedeveryday = isappliedeveryday;
  }

  public DiscountSchemaBreak isappliedonfriday(Boolean isappliedonfriday) {
    this.isappliedonfriday = isappliedonfriday;
    return this;
  }

  /**
   * Se aplica los días viernes de cada semana
   * @return isappliedonfriday
   **/
  @Schema(required = true, description = "Se aplica los días viernes de cada semana")
      @NotNull

    public Boolean isIsappliedonfriday() {
    return isappliedonfriday;
  }

  public void setIsappliedonfriday(Boolean isappliedonfriday) {
    this.isappliedonfriday = isappliedonfriday;
  }

  public DiscountSchemaBreak isappliedonmonday(Boolean isappliedonmonday) {
    this.isappliedonmonday = isappliedonmonday;
    return this;
  }

  /**
   * Se aplica los días lunes de cada semana
   * @return isappliedonmonday
   **/
  @Schema(required = true, description = "Se aplica los días lunes de cada semana")
      @NotNull

    public Boolean isIsappliedonmonday() {
    return isappliedonmonday;
  }

  public void setIsappliedonmonday(Boolean isappliedonmonday) {
    this.isappliedonmonday = isappliedonmonday;
  }

  public DiscountSchemaBreak isappliedonsaturday(Boolean isappliedonsaturday) {
    this.isappliedonsaturday = isappliedonsaturday;
    return this;
  }

  /**
   * Se aplica los días sábado de cada semana
   * @return isappliedonsaturday
   **/
  @Schema(required = true, description = "Se aplica los días sábado de cada semana")
      @NotNull

    public Boolean isIsappliedonsaturday() {
    return isappliedonsaturday;
  }

  public void setIsappliedonsaturday(Boolean isappliedonsaturday) {
    this.isappliedonsaturday = isappliedonsaturday;
  }

  public DiscountSchemaBreak isappliedonsunday(Boolean isappliedonsunday) {
    this.isappliedonsunday = isappliedonsunday;
    return this;
  }

  /**
   * Se aplica los días domingo de cada semana
   * @return isappliedonsunday
   **/
  @Schema(required = true, description = "Se aplica los días domingo de cada semana")
      @NotNull

    public Boolean isIsappliedonsunday() {
    return isappliedonsunday;
  }

  public void setIsappliedonsunday(Boolean isappliedonsunday) {
    this.isappliedonsunday = isappliedonsunday;
  }

  public DiscountSchemaBreak isappliedonthursday(Boolean isappliedonthursday) {
    this.isappliedonthursday = isappliedonthursday;
    return this;
  }

  /**
   * Se aplica los días jueves de cada semana
   * @return isappliedonthursday
   **/
  @Schema(required = true, description = "Se aplica los días jueves de cada semana")
      @NotNull

    public Boolean isIsappliedonthursday() {
    return isappliedonthursday;
  }

  public void setIsappliedonthursday(Boolean isappliedonthursday) {
    this.isappliedonthursday = isappliedonthursday;
  }

  public DiscountSchemaBreak isappliedontuesday(Boolean isappliedontuesday) {
    this.isappliedontuesday = isappliedontuesday;
    return this;
  }

  /**
   * Se aplica los días martes de cada semana
   * @return isappliedontuesday
   **/
  @Schema(required = true, description = "Se aplica los días martes de cada semana")
      @NotNull

    public Boolean isIsappliedontuesday() {
    return isappliedontuesday;
  }

  public void setIsappliedontuesday(Boolean isappliedontuesday) {
    this.isappliedontuesday = isappliedontuesday;
  }

  public DiscountSchemaBreak isappliedonwednesday(Boolean isappliedonwednesday) {
    this.isappliedonwednesday = isappliedonwednesday;
    return this;
  }

  /**
   * Se aplica los días miércoles de cada semana
   * @return isappliedonwednesday
   **/
  @Schema(required = true, description = "Se aplica los días miércoles de cada semana")
      @NotNull

    public Boolean isIsappliedonwednesday() {
    return isappliedonwednesday;
  }

  public void setIsappliedonwednesday(Boolean isappliedonwednesday) {
    this.isappliedonwednesday = isappliedonwednesday;
  }

  public DiscountSchemaBreak isbpartnerflatdiscount(Boolean isbpartnerflatdiscount) {
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

  public DiscountSchemaBreak isbreak(Boolean isbreak) {
    this.isbreak = isbreak;
    return this;
  }

  /**
   * Si se aplica este descuento los subsiguientes no serán tenidos en cuenta
   * @return isbreak
   **/
  @Schema(required = true, description = "Si se aplica este descuento los subsiguientes no serán tenidos en cuenta")
      @NotNull

    public Boolean isIsbreak() {
    return isbreak;
  }

  public void setIsbreak(Boolean isbreak) {
    this.isbreak = isbreak;
  }

  public DiscountSchemaBreak mDiscountschemabreakId(Integer mDiscountschemabreakId) {
    this.mDiscountschemabreakId = mDiscountschemabreakId;
    return this;
  }

  /**
   * Corte del Descuento comercial
   * @return mDiscountschemabreakId
   **/
  @Schema(required = true, description = "Corte del Descuento comercial")
      @NotNull

    public Integer getMDiscountschemabreakId() {
    return mDiscountschemabreakId;
  }

  public void setMDiscountschemabreakId(Integer mDiscountschemabreakId) {
    this.mDiscountschemabreakId = mDiscountschemabreakId;
  }

  public DiscountSchemaBreak mDiscountschemaId(Integer mDiscountschemaId) {
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

  public DiscountSchemaBreak mProductCategoryId(Integer mProductCategoryId) {
    this.mProductCategoryId = mProductCategoryId;
    return this;
  }

  /**
   * Categoría de la que este producto es parte
   * @return mProductCategoryId
   **/
  @Schema(description = "Categoría de la que este producto es parte")
  
    public Integer getMProductCategoryId() {
    return mProductCategoryId;
  }

  public void setMProductCategoryId(Integer mProductCategoryId) {
    this.mProductCategoryId = mProductCategoryId;
  }

  public DiscountSchemaBreak mProductGamasId(Integer mProductGamasId) {
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

  public DiscountSchemaBreak mProductId(Integer mProductId) {
    this.mProductId = mProductId;
    return this;
  }

  /**
   * Producto; servicio o Artículo
   * @return mProductId
   **/
  @Schema(description = "Producto; servicio o Artículo")
  
    public Integer getMProductId() {
    return mProductId;
  }

  public void setMProductId(Integer mProductId) {
    this.mProductId = mProductId;
  }

  public DiscountSchemaBreak mProductLinesId(Integer mProductLinesId) {
    this.mProductLinesId = mProductLinesId;
    return this;
  }

  /**
   *  
   * @return mProductLinesId
   **/
  @Schema(description = " ")
  
    public Integer getMProductLinesId() {
    return mProductLinesId;
  }

  public void setMProductLinesId(Integer mProductLinesId) {
    this.mProductLinesId = mProductLinesId;
  }

  public DiscountSchemaBreak priceGross(BigDecimal priceGross) {
    this.priceGross = priceGross;
    return this;
  }

  /**
   *  
   * @return priceGross
   **/
  @Schema(description = " ")
  
    @Valid
    public BigDecimal getPriceGross() {
    return priceGross;
  }

  public void setPriceGross(BigDecimal priceGross) {
    this.priceGross = priceGross;
  }

  public DiscountSchemaBreak seqno(Integer seqno) {
    this.seqno = seqno;
    return this;
  }

  /**
   * Método de ordenar registros; el número más bajo viene primero
   * @return seqno
   **/
  @Schema(required = true, description = "Método de ordenar registros; el número más bajo viene primero")
      @NotNull

    public Integer getSeqno() {
    return seqno;
  }

  public void setSeqno(Integer seqno) {
    this.seqno = seqno;
  }

  public DiscountSchemaBreak updated(String updated) {
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

  public DiscountSchemaBreak updatedby(Integer updatedby) {
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

  public DiscountSchemaBreak additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public DiscountSchemaBreak addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public DiscountSchemaBreak referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public DiscountSchemaBreak addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    DiscountSchemaBreak discountSchemaBreak = (DiscountSchemaBreak) o;
    return Objects.equals(this.adClientId, discountSchemaBreak.adClientId) &&
        Objects.equals(this.adComponentobjectuid, discountSchemaBreak.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, discountSchemaBreak.adOrgId) &&
        Objects.equals(this.applicationpolicy, discountSchemaBreak.applicationpolicy) &&
        Objects.equals(this.breakdiscount, discountSchemaBreak.breakdiscount) &&
        Objects.equals(this.breakvalue, discountSchemaBreak.breakvalue) &&
        Objects.equals(this.cBpartnerId, discountSchemaBreak.cBpartnerId) &&
        Objects.equals(this.created, discountSchemaBreak.created) &&
        Objects.equals(this.createdby, discountSchemaBreak.createdby) &&
        Objects.equals(this.isactive, discountSchemaBreak.isactive) &&
        Objects.equals(this.isappliedeveryday, discountSchemaBreak.isappliedeveryday) &&
        Objects.equals(this.isappliedonfriday, discountSchemaBreak.isappliedonfriday) &&
        Objects.equals(this.isappliedonmonday, discountSchemaBreak.isappliedonmonday) &&
        Objects.equals(this.isappliedonsaturday, discountSchemaBreak.isappliedonsaturday) &&
        Objects.equals(this.isappliedonsunday, discountSchemaBreak.isappliedonsunday) &&
        Objects.equals(this.isappliedonthursday, discountSchemaBreak.isappliedonthursday) &&
        Objects.equals(this.isappliedontuesday, discountSchemaBreak.isappliedontuesday) &&
        Objects.equals(this.isappliedonwednesday, discountSchemaBreak.isappliedonwednesday) &&
        Objects.equals(this.isbpartnerflatdiscount, discountSchemaBreak.isbpartnerflatdiscount) &&
        Objects.equals(this.isbreak, discountSchemaBreak.isbreak) &&
        Objects.equals(this.mDiscountschemabreakId, discountSchemaBreak.mDiscountschemabreakId) &&
        Objects.equals(this.mDiscountschemaId, discountSchemaBreak.mDiscountschemaId) &&
        Objects.equals(this.mProductCategoryId, discountSchemaBreak.mProductCategoryId) &&
        Objects.equals(this.mProductGamasId, discountSchemaBreak.mProductGamasId) &&
        Objects.equals(this.mProductId, discountSchemaBreak.mProductId) &&
        Objects.equals(this.mProductLinesId, discountSchemaBreak.mProductLinesId) &&
        Objects.equals(this.priceGross, discountSchemaBreak.priceGross) &&
        Objects.equals(this.seqno, discountSchemaBreak.seqno) &&
        Objects.equals(this.updated, discountSchemaBreak.updated) &&
        Objects.equals(this.updatedby, discountSchemaBreak.updatedby) &&
        Objects.equals(this.additionalvalues, discountSchemaBreak.additionalvalues) &&
        Objects.equals(this.referencedvalues, discountSchemaBreak.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adOrgId, applicationpolicy, breakdiscount, breakvalue, cBpartnerId, created, createdby, isactive, isappliedeveryday, isappliedonfriday, isappliedonmonday, isappliedonsaturday, isappliedonsunday, isappliedonthursday, isappliedontuesday, isappliedonwednesday, isbpartnerflatdiscount, isbreak, mDiscountschemabreakId, mDiscountschemaId, mProductCategoryId, mProductGamasId, mProductId, mProductLinesId, priceGross, seqno, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DiscountSchemaBreak {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    applicationpolicy: ").append(toIndentedString(applicationpolicy)).append("\n");
    sb.append("    breakdiscount: ").append(toIndentedString(breakdiscount)).append("\n");
    sb.append("    breakvalue: ").append(toIndentedString(breakvalue)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isappliedeveryday: ").append(toIndentedString(isappliedeveryday)).append("\n");
    sb.append("    isappliedonfriday: ").append(toIndentedString(isappliedonfriday)).append("\n");
    sb.append("    isappliedonmonday: ").append(toIndentedString(isappliedonmonday)).append("\n");
    sb.append("    isappliedonsaturday: ").append(toIndentedString(isappliedonsaturday)).append("\n");
    sb.append("    isappliedonsunday: ").append(toIndentedString(isappliedonsunday)).append("\n");
    sb.append("    isappliedonthursday: ").append(toIndentedString(isappliedonthursday)).append("\n");
    sb.append("    isappliedontuesday: ").append(toIndentedString(isappliedontuesday)).append("\n");
    sb.append("    isappliedonwednesday: ").append(toIndentedString(isappliedonwednesday)).append("\n");
    sb.append("    isbpartnerflatdiscount: ").append(toIndentedString(isbpartnerflatdiscount)).append("\n");
    sb.append("    isbreak: ").append(toIndentedString(isbreak)).append("\n");
    sb.append("    mDiscountschemabreakId: ").append(toIndentedString(mDiscountschemabreakId)).append("\n");
    sb.append("    mDiscountschemaId: ").append(toIndentedString(mDiscountschemaId)).append("\n");
    sb.append("    mProductCategoryId: ").append(toIndentedString(mProductCategoryId)).append("\n");
    sb.append("    mProductGamasId: ").append(toIndentedString(mProductGamasId)).append("\n");
    sb.append("    mProductId: ").append(toIndentedString(mProductId)).append("\n");
    sb.append("    mProductLinesId: ").append(toIndentedString(mProductLinesId)).append("\n");
    sb.append("    priceGross: ").append(toIndentedString(priceGross)).append("\n");
    sb.append("    seqno: ").append(toIndentedString(seqno)).append("\n");
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
