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
 * DiscountConfig
 */
@Validated



public class DiscountConfig   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_componentversion_id")
  private Integer adComponentversionId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("applypaymentterm")
  private Boolean applypaymentterm = null;

  @JsonProperty("bpartner_discountproduct_id")
  private Integer bpartnerDiscountproductId = null;

  @JsonProperty("bpartner_surchargeproduct_id")
  private Integer bpartnerSurchargeproductId = null;

  @JsonProperty("charge_discountproduct_id")
  private Integer chargeDiscountproductId = null;

  @JsonProperty("charge_surchargeproduct_id")
  private Integer chargeSurchargeproductId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("credit_doctype_id")
  private Integer creditDoctypeId = null;

  @JsonProperty("creditdocumenttype")
  private String creditdocumenttype = null;

  @JsonProperty("debit_doctype_id")
  private Integer debitDoctypeId = null;

  @JsonProperty("debitdocumenttype")
  private String debitdocumenttype = null;

  @JsonProperty("documentdiscount1")
  private String documentdiscount1 = null;

  @JsonProperty("documentdiscount2")
  private String documentdiscount2 = null;

  @JsonProperty("documentdiscountcharge_id")
  private Integer documentdiscountchargeId = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isapplyalldocumentdiscount")
  private Boolean isapplyalldocumentdiscount = null;

  @JsonProperty("linediscount1")
  private String linediscount1 = null;

  @JsonProperty("linediscount2")
  private String linediscount2 = null;

  @JsonProperty("linediscount3")
  private String linediscount3 = null;

  @JsonProperty("linediscount4")
  private String linediscount4 = null;

  @JsonProperty("maxpromotionalcoupons")
  private Integer maxpromotionalcoupons = null;

  @JsonProperty("m_discountconfig_id")
  private Integer mDiscountconfigId = null;

  @JsonProperty("paymentmedium_discountproduct_id")
  private Integer paymentmediumDiscountproductId = null;

  @JsonProperty("paymentmedium_surchargeproduct_id")
  private Integer paymentmediumSurchargeproductId = null;

  @JsonProperty("paymentterm_discountproduct_id")
  private Integer paymenttermDiscountproductId = null;

  @JsonProperty("paymentterm_surchargeproduct_id")
  private Integer paymenttermSurchargeproductId = null;

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

  public DiscountConfig adClientId(Integer adClientId) {
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

  public DiscountConfig adComponentobjectuid(String adComponentobjectuid) {
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

  public DiscountConfig adComponentversionId(Integer adComponentversionId) {
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

  public DiscountConfig adOrgId(Integer adOrgId) {
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

  public DiscountConfig applypaymentterm(Boolean applypaymentterm) {
    this.applypaymentterm = applypaymentterm;
    return this;
  }

  /**
   * Aplica el importe de Esquema de Vencimiento a la factura, la cual permite generar el documento débito o crédito correspondiente.
   * @return applypaymentterm
   **/
  @Schema(required = true, description = "Aplica el importe de Esquema de Vencimiento a la factura, la cual permite generar el documento débito o crédito correspondiente.")
      @NotNull

    public Boolean isApplypaymentterm() {
    return applypaymentterm;
  }

  public void setApplypaymentterm(Boolean applypaymentterm) {
    this.applypaymentterm = applypaymentterm;
  }

  public DiscountConfig bpartnerDiscountproductId(Integer bpartnerDiscountproductId) {
    this.bpartnerDiscountproductId = bpartnerDiscountproductId;
    return this;
  }

  /**
   * Artículo para Descuento de Entidad Comercial
   * @return bpartnerDiscountproductId
   **/
  @Schema(required = true, description = "Artículo para Descuento de Entidad Comercial")
      @NotNull

    public Integer getBpartnerDiscountproductId() {
    return bpartnerDiscountproductId;
  }

  public void setBpartnerDiscountproductId(Integer bpartnerDiscountproductId) {
    this.bpartnerDiscountproductId = bpartnerDiscountproductId;
  }

  public DiscountConfig bpartnerSurchargeproductId(Integer bpartnerSurchargeproductId) {
    this.bpartnerSurchargeproductId = bpartnerSurchargeproductId;
    return this;
  }

  /**
   * Artículo para Recargo de Entidad Comercial
   * @return bpartnerSurchargeproductId
   **/
  @Schema(required = true, description = "Artículo para Recargo de Entidad Comercial")
      @NotNull

    public Integer getBpartnerSurchargeproductId() {
    return bpartnerSurchargeproductId;
  }

  public void setBpartnerSurchargeproductId(Integer bpartnerSurchargeproductId) {
    this.bpartnerSurchargeproductId = bpartnerSurchargeproductId;
  }

  public DiscountConfig chargeDiscountproductId(Integer chargeDiscountproductId) {
    this.chargeDiscountproductId = chargeDiscountproductId;
    return this;
  }

  /**
   * Artículo para Descuento de Cargos de Organización
   * @return chargeDiscountproductId
   **/
  @Schema(required = true, description = "Artículo para Descuento de Cargos de Organización")
      @NotNull

    public Integer getChargeDiscountproductId() {
    return chargeDiscountproductId;
  }

  public void setChargeDiscountproductId(Integer chargeDiscountproductId) {
    this.chargeDiscountproductId = chargeDiscountproductId;
  }

  public DiscountConfig chargeSurchargeproductId(Integer chargeSurchargeproductId) {
    this.chargeSurchargeproductId = chargeSurchargeproductId;
    return this;
  }

  /**
   * Artículo para Recargo de Cargos de Organización
   * @return chargeSurchargeproductId
   **/
  @Schema(required = true, description = "Artículo para Recargo de Cargos de Organización")
      @NotNull

    public Integer getChargeSurchargeproductId() {
    return chargeSurchargeproductId;
  }

  public void setChargeSurchargeproductId(Integer chargeSurchargeproductId) {
    this.chargeSurchargeproductId = chargeSurchargeproductId;
  }

  public DiscountConfig created(String created) {
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

  public DiscountConfig createdby(Integer createdby) {
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

  public DiscountConfig creditDoctypeId(Integer creditDoctypeId) {
    this.creditDoctypeId = creditDoctypeId;
    return this;
  }

  /**
   * Tipo de Documento para créditos
   * @return creditDoctypeId
   **/
  @Schema(required = true, description = "Tipo de Documento para créditos")
      @NotNull

    public Integer getCreditDoctypeId() {
    return creditDoctypeId;
  }

  public void setCreditDoctypeId(Integer creditDoctypeId) {
    this.creditDoctypeId = creditDoctypeId;
  }

  public DiscountConfig creditdocumenttype(String creditdocumenttype) {
    this.creditdocumenttype = creditdocumenttype;
    return this;
  }

  /**
   * Tipo de Documento para Créditos correspondientes a Descuentos en Recibos de Cliente
   * @return creditdocumenttype
   **/
  @Schema(required = true, description = "Tipo de Documento para Créditos correspondientes a Descuentos en Recibos de Cliente")
      @NotNull

    public String getCreditdocumenttype() {
    return creditdocumenttype;
  }

  public void setCreditdocumenttype(String creditdocumenttype) {
    this.creditdocumenttype = creditdocumenttype;
  }

  public DiscountConfig debitDoctypeId(Integer debitDoctypeId) {
    this.debitDoctypeId = debitDoctypeId;
    return this;
  }

  /**
   * Tipo de Documento para débitos
   * @return debitDoctypeId
   **/
  @Schema(required = true, description = "Tipo de Documento para débitos")
      @NotNull

    public Integer getDebitDoctypeId() {
    return debitDoctypeId;
  }

  public void setDebitDoctypeId(Integer debitDoctypeId) {
    this.debitDoctypeId = debitDoctypeId;
  }

  public DiscountConfig debitdocumenttype(String debitdocumenttype) {
    this.debitdocumenttype = debitdocumenttype;
    return this;
  }

  /**
   * Tipo de Documento para Débitos correspondientes a recargos en Recibos de Cliente
   * @return debitdocumenttype
   **/
  @Schema(required = true, description = "Tipo de Documento para Débitos correspondientes a recargos en Recibos de Cliente")
      @NotNull

    public String getDebitdocumenttype() {
    return debitdocumenttype;
  }

  public void setDebitdocumenttype(String debitdocumenttype) {
    this.debitdocumenttype = debitdocumenttype;
  }

  public DiscountConfig documentdiscount1(String documentdiscount1) {
    this.documentdiscount1 = documentdiscount1;
    return this;
  }

  /**
   * Descuento a nivel de documento que contiene mayor prioridad de aplicación (Prioridad 1)
   * @return documentdiscount1
   **/
  @Schema(description = "Descuento a nivel de documento que contiene mayor prioridad de aplicación (Prioridad 1)")
  
    public String getDocumentdiscount1() {
    return documentdiscount1;
  }

  public void setDocumentdiscount1(String documentdiscount1) {
    this.documentdiscount1 = documentdiscount1;
  }

  public DiscountConfig documentdiscount2(String documentdiscount2) {
    this.documentdiscount2 = documentdiscount2;
    return this;
  }

  /**
   * Descuento a nivel de documento que contiene prioridad 2 de aplicación
   * @return documentdiscount2
   **/
  @Schema(description = "Descuento a nivel de documento que contiene prioridad 2 de aplicación")
  
    public String getDocumentdiscount2() {
    return documentdiscount2;
  }

  public void setDocumentdiscount2(String documentdiscount2) {
    this.documentdiscount2 = documentdiscount2;
  }

  public DiscountConfig documentdiscountchargeId(Integer documentdiscountchargeId) {
    this.documentdiscountchargeId = documentdiscountchargeId;
    return this;
  }

  /**
   * Cargo que se asocia al documento (Pedido, Factura) que sufre Descuentos a Nivel de Documento
   * @return documentdiscountchargeId
   **/
  @Schema(description = "Cargo que se asocia al documento (Pedido, Factura) que sufre Descuentos a Nivel de Documento")
  
    public Integer getDocumentdiscountchargeId() {
    return documentdiscountchargeId;
  }

  public void setDocumentdiscountchargeId(Integer documentdiscountchargeId) {
    this.documentdiscountchargeId = documentdiscountchargeId;
  }

  public DiscountConfig isactive(Boolean isactive) {
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

  public DiscountConfig isapplyalldocumentdiscount(Boolean isapplyalldocumentdiscount) {
    this.isapplyalldocumentdiscount = isapplyalldocumentdiscount;
    return this;
  }

  /**
   * Aplica todos los descuentos a nivel de documento (Esquemas Generales y de Entidad Comercial)
   * @return isapplyalldocumentdiscount
   **/
  @Schema(required = true, description = "Aplica todos los descuentos a nivel de documento (Esquemas Generales y de Entidad Comercial)")
      @NotNull

    public Boolean isIsapplyalldocumentdiscount() {
    return isapplyalldocumentdiscount;
  }

  public void setIsapplyalldocumentdiscount(Boolean isapplyalldocumentdiscount) {
    this.isapplyalldocumentdiscount = isapplyalldocumentdiscount;
  }

  public DiscountConfig linediscount1(String linediscount1) {
    this.linediscount1 = linediscount1;
    return this;
  }

  /**
   * Descuento a nivel de línea que contiene mayor prioridad de aplicación (Prioridad 1)
   * @return linediscount1
   **/
  @Schema(description = "Descuento a nivel de línea que contiene mayor prioridad de aplicación (Prioridad 1)")
  
    public String getLinediscount1() {
    return linediscount1;
  }

  public void setLinediscount1(String linediscount1) {
    this.linediscount1 = linediscount1;
  }

  public DiscountConfig linediscount2(String linediscount2) {
    this.linediscount2 = linediscount2;
    return this;
  }

  /**
   * Descuento a nivel de línea que contiene prioridad 2 de aplicación
   * @return linediscount2
   **/
  @Schema(description = "Descuento a nivel de línea que contiene prioridad 2 de aplicación")
  
    public String getLinediscount2() {
    return linediscount2;
  }

  public void setLinediscount2(String linediscount2) {
    this.linediscount2 = linediscount2;
  }

  public DiscountConfig linediscount3(String linediscount3) {
    this.linediscount3 = linediscount3;
    return this;
  }

  /**
   * Descuento a nivel de línea que contiene prioridad 3 de aplicación
   * @return linediscount3
   **/
  @Schema(description = "Descuento a nivel de línea que contiene prioridad 3 de aplicación")
  
    public String getLinediscount3() {
    return linediscount3;
  }

  public void setLinediscount3(String linediscount3) {
    this.linediscount3 = linediscount3;
  }

  public DiscountConfig linediscount4(String linediscount4) {
    this.linediscount4 = linediscount4;
    return this;
  }

  /**
   * Descuento a nivel de línea que contiene prioridad 4 de aplicación
   * @return linediscount4
   **/
  @Schema(description = "Descuento a nivel de línea que contiene prioridad 4 de aplicación")
  
    public String getLinediscount4() {
    return linediscount4;
  }

  public void setLinediscount4(String linediscount4) {
    this.linediscount4 = linediscount4;
  }

  public DiscountConfig maxpromotionalcoupons(Integer maxpromotionalcoupons) {
    this.maxpromotionalcoupons = maxpromotionalcoupons;
    return this;
  }

  /**
   * Cantidad máxima de códigos o cupones promocionales a aplicar en transacciones de ventas
   * @return maxpromotionalcoupons
   **/
  @Schema(required = true, description = "Cantidad máxima de códigos o cupones promocionales a aplicar en transacciones de ventas")
      @NotNull

    public Integer getMaxpromotionalcoupons() {
    return maxpromotionalcoupons;
  }

  public void setMaxpromotionalcoupons(Integer maxpromotionalcoupons) {
    this.maxpromotionalcoupons = maxpromotionalcoupons;
  }

  public DiscountConfig mDiscountconfigId(Integer mDiscountconfigId) {
    this.mDiscountconfigId = mDiscountconfigId;
    return this;
  }

  /**
   * Configuración de Descuentos para una o todas las organizaciones
   * @return mDiscountconfigId
   **/
  @Schema(required = true, description = "Configuración de Descuentos para una o todas las organizaciones")
      @NotNull

    public Integer getMDiscountconfigId() {
    return mDiscountconfigId;
  }

  public void setMDiscountconfigId(Integer mDiscountconfigId) {
    this.mDiscountconfigId = mDiscountconfigId;
  }

  public DiscountConfig paymentmediumDiscountproductId(Integer paymentmediumDiscountproductId) {
    this.paymentmediumDiscountproductId = paymentmediumDiscountproductId;
    return this;
  }

  /**
   *  
   * @return paymentmediumDiscountproductId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getPaymentmediumDiscountproductId() {
    return paymentmediumDiscountproductId;
  }

  public void setPaymentmediumDiscountproductId(Integer paymentmediumDiscountproductId) {
    this.paymentmediumDiscountproductId = paymentmediumDiscountproductId;
  }

  public DiscountConfig paymentmediumSurchargeproductId(Integer paymentmediumSurchargeproductId) {
    this.paymentmediumSurchargeproductId = paymentmediumSurchargeproductId;
    return this;
  }

  /**
   *  
   * @return paymentmediumSurchargeproductId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getPaymentmediumSurchargeproductId() {
    return paymentmediumSurchargeproductId;
  }

  public void setPaymentmediumSurchargeproductId(Integer paymentmediumSurchargeproductId) {
    this.paymentmediumSurchargeproductId = paymentmediumSurchargeproductId;
  }

  public DiscountConfig paymenttermDiscountproductId(Integer paymenttermDiscountproductId) {
    this.paymenttermDiscountproductId = paymenttermDiscountproductId;
    return this;
  }

  /**
   *  
   * @return paymenttermDiscountproductId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getPaymenttermDiscountproductId() {
    return paymenttermDiscountproductId;
  }

  public void setPaymenttermDiscountproductId(Integer paymenttermDiscountproductId) {
    this.paymenttermDiscountproductId = paymenttermDiscountproductId;
  }

  public DiscountConfig paymenttermSurchargeproductId(Integer paymenttermSurchargeproductId) {
    this.paymenttermSurchargeproductId = paymenttermSurchargeproductId;
    return this;
  }

  /**
   *  
   * @return paymenttermSurchargeproductId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getPaymenttermSurchargeproductId() {
    return paymenttermSurchargeproductId;
  }

  public void setPaymenttermSurchargeproductId(Integer paymenttermSurchargeproductId) {
    this.paymenttermSurchargeproductId = paymenttermSurchargeproductId;
  }

  public DiscountConfig updated(String updated) {
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

  public DiscountConfig updatedby(Integer updatedby) {
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

  public DiscountConfig additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public DiscountConfig addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public DiscountConfig referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public DiscountConfig addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    DiscountConfig discountConfig = (DiscountConfig) o;
    return Objects.equals(this.adClientId, discountConfig.adClientId) &&
        Objects.equals(this.adComponentobjectuid, discountConfig.adComponentobjectuid) &&
        Objects.equals(this.adComponentversionId, discountConfig.adComponentversionId) &&
        Objects.equals(this.adOrgId, discountConfig.adOrgId) &&
        Objects.equals(this.applypaymentterm, discountConfig.applypaymentterm) &&
        Objects.equals(this.bpartnerDiscountproductId, discountConfig.bpartnerDiscountproductId) &&
        Objects.equals(this.bpartnerSurchargeproductId, discountConfig.bpartnerSurchargeproductId) &&
        Objects.equals(this.chargeDiscountproductId, discountConfig.chargeDiscountproductId) &&
        Objects.equals(this.chargeSurchargeproductId, discountConfig.chargeSurchargeproductId) &&
        Objects.equals(this.created, discountConfig.created) &&
        Objects.equals(this.createdby, discountConfig.createdby) &&
        Objects.equals(this.creditDoctypeId, discountConfig.creditDoctypeId) &&
        Objects.equals(this.creditdocumenttype, discountConfig.creditdocumenttype) &&
        Objects.equals(this.debitDoctypeId, discountConfig.debitDoctypeId) &&
        Objects.equals(this.debitdocumenttype, discountConfig.debitdocumenttype) &&
        Objects.equals(this.documentdiscount1, discountConfig.documentdiscount1) &&
        Objects.equals(this.documentdiscount2, discountConfig.documentdiscount2) &&
        Objects.equals(this.documentdiscountchargeId, discountConfig.documentdiscountchargeId) &&
        Objects.equals(this.isactive, discountConfig.isactive) &&
        Objects.equals(this.isapplyalldocumentdiscount, discountConfig.isapplyalldocumentdiscount) &&
        Objects.equals(this.linediscount1, discountConfig.linediscount1) &&
        Objects.equals(this.linediscount2, discountConfig.linediscount2) &&
        Objects.equals(this.linediscount3, discountConfig.linediscount3) &&
        Objects.equals(this.linediscount4, discountConfig.linediscount4) &&
        Objects.equals(this.maxpromotionalcoupons, discountConfig.maxpromotionalcoupons) &&
        Objects.equals(this.mDiscountconfigId, discountConfig.mDiscountconfigId) &&
        Objects.equals(this.paymentmediumDiscountproductId, discountConfig.paymentmediumDiscountproductId) &&
        Objects.equals(this.paymentmediumSurchargeproductId, discountConfig.paymentmediumSurchargeproductId) &&
        Objects.equals(this.paymenttermDiscountproductId, discountConfig.paymenttermDiscountproductId) &&
        Objects.equals(this.paymenttermSurchargeproductId, discountConfig.paymenttermSurchargeproductId) &&
        Objects.equals(this.updated, discountConfig.updated) &&
        Objects.equals(this.updatedby, discountConfig.updatedby) &&
        Objects.equals(this.additionalvalues, discountConfig.additionalvalues) &&
        Objects.equals(this.referencedvalues, discountConfig.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adComponentversionId, adOrgId, applypaymentterm, bpartnerDiscountproductId, bpartnerSurchargeproductId, chargeDiscountproductId, chargeSurchargeproductId, created, createdby, creditDoctypeId, creditdocumenttype, debitDoctypeId, debitdocumenttype, documentdiscount1, documentdiscount2, documentdiscountchargeId, isactive, isapplyalldocumentdiscount, linediscount1, linediscount2, linediscount3, linediscount4, maxpromotionalcoupons, mDiscountconfigId, paymentmediumDiscountproductId, paymentmediumSurchargeproductId, paymenttermDiscountproductId, paymenttermSurchargeproductId, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DiscountConfig {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adComponentversionId: ").append(toIndentedString(adComponentversionId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    applypaymentterm: ").append(toIndentedString(applypaymentterm)).append("\n");
    sb.append("    bpartnerDiscountproductId: ").append(toIndentedString(bpartnerDiscountproductId)).append("\n");
    sb.append("    bpartnerSurchargeproductId: ").append(toIndentedString(bpartnerSurchargeproductId)).append("\n");
    sb.append("    chargeDiscountproductId: ").append(toIndentedString(chargeDiscountproductId)).append("\n");
    sb.append("    chargeSurchargeproductId: ").append(toIndentedString(chargeSurchargeproductId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    creditDoctypeId: ").append(toIndentedString(creditDoctypeId)).append("\n");
    sb.append("    creditdocumenttype: ").append(toIndentedString(creditdocumenttype)).append("\n");
    sb.append("    debitDoctypeId: ").append(toIndentedString(debitDoctypeId)).append("\n");
    sb.append("    debitdocumenttype: ").append(toIndentedString(debitdocumenttype)).append("\n");
    sb.append("    documentdiscount1: ").append(toIndentedString(documentdiscount1)).append("\n");
    sb.append("    documentdiscount2: ").append(toIndentedString(documentdiscount2)).append("\n");
    sb.append("    documentdiscountchargeId: ").append(toIndentedString(documentdiscountchargeId)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isapplyalldocumentdiscount: ").append(toIndentedString(isapplyalldocumentdiscount)).append("\n");
    sb.append("    linediscount1: ").append(toIndentedString(linediscount1)).append("\n");
    sb.append("    linediscount2: ").append(toIndentedString(linediscount2)).append("\n");
    sb.append("    linediscount3: ").append(toIndentedString(linediscount3)).append("\n");
    sb.append("    linediscount4: ").append(toIndentedString(linediscount4)).append("\n");
    sb.append("    maxpromotionalcoupons: ").append(toIndentedString(maxpromotionalcoupons)).append("\n");
    sb.append("    mDiscountconfigId: ").append(toIndentedString(mDiscountconfigId)).append("\n");
    sb.append("    paymentmediumDiscountproductId: ").append(toIndentedString(paymentmediumDiscountproductId)).append("\n");
    sb.append("    paymentmediumSurchargeproductId: ").append(toIndentedString(paymentmediumSurchargeproductId)).append("\n");
    sb.append("    paymenttermDiscountproductId: ").append(toIndentedString(paymenttermDiscountproductId)).append("\n");
    sb.append("    paymenttermSurchargeproductId: ").append(toIndentedString(paymenttermSurchargeproductId)).append("\n");
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
