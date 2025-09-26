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
 * DocumentDiscount
 */
@Validated



public class DocumentDiscount   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_documentdiscount_id")
  private Integer cDocumentdiscountId = null;

  @JsonProperty("c_documentdiscount_parent_id")
  private Integer cDocumentdiscountParentId = null;

  @JsonProperty("c_invoice_id")
  private Integer cInvoiceId = null;

  @JsonProperty("c_invoiceline_id")
  private Integer cInvoicelineId = null;

  @JsonProperty("c_order_id")
  private Integer cOrderId = null;

  @JsonProperty("c_orderline_id")
  private Integer cOrderlineId = null;

  @JsonProperty("c_payment_id")
  private Integer cPaymentId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("cumulativelevel")
  private String cumulativelevel = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("discountamt")
  private BigDecimal discountamt = null;

  @JsonProperty("discountapplication")
  private String discountapplication = null;

  @JsonProperty("discountbaseamt")
  private BigDecimal discountbaseamt = null;

  @JsonProperty("discountkind")
  private String discountkind = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("m_discountschema_id")
  private Integer mDiscountschemaId = null;

  @JsonProperty("taxrate")
  private BigDecimal taxrate = null;

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

  public DocumentDiscount adClientId(Integer adClientId) {
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

  public DocumentDiscount adOrgId(Integer adOrgId) {
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

  public DocumentDiscount cDocumentdiscountId(Integer cDocumentdiscountId) {
    this.cDocumentdiscountId = cDocumentdiscountId;
    return this;
  }

  /**
   * Descuento de Documento
   * @return cDocumentdiscountId
   **/
  @Schema(required = true, description = "Descuento de Documento")
      @NotNull

    public Integer getCDocumentdiscountId() {
    return cDocumentdiscountId;
  }

  public void setCDocumentdiscountId(Integer cDocumentdiscountId) {
    this.cDocumentdiscountId = cDocumentdiscountId;
  }

  public DocumentDiscount cDocumentdiscountParentId(Integer cDocumentdiscountParentId) {
    this.cDocumentdiscountParentId = cDocumentdiscountParentId;
    return this;
  }

  /**
   * Descuento de documento al cual pertenece este descuento por tasa de impuesto
   * @return cDocumentdiscountParentId
   **/
  @Schema(description = "Descuento de documento al cual pertenece este descuento por tasa de impuesto")
  
    public Integer getCDocumentdiscountParentId() {
    return cDocumentdiscountParentId;
  }

  public void setCDocumentdiscountParentId(Integer cDocumentdiscountParentId) {
    this.cDocumentdiscountParentId = cDocumentdiscountParentId;
  }

  public DocumentDiscount cInvoiceId(Integer cInvoiceId) {
    this.cInvoiceId = cInvoiceId;
    return this;
  }

  /**
   * Identificador de la factura
   * @return cInvoiceId
   **/
  @Schema(description = "Identificador de la factura")
  
    public Integer getCInvoiceId() {
    return cInvoiceId;
  }

  public void setCInvoiceId(Integer cInvoiceId) {
    this.cInvoiceId = cInvoiceId;
  }

  public DocumentDiscount cInvoicelineId(Integer cInvoicelineId) {
    this.cInvoicelineId = cInvoicelineId;
    return this;
  }

  /**
   * Línea de detalle de la factura
   * @return cInvoicelineId
   **/
  @Schema(description = "Línea de detalle de la factura")
  
    public Integer getCInvoicelineId() {
    return cInvoicelineId;
  }

  public void setCInvoicelineId(Integer cInvoicelineId) {
    this.cInvoicelineId = cInvoicelineId;
  }

  public DocumentDiscount cOrderId(Integer cOrderId) {
    this.cOrderId = cOrderId;
    return this;
  }

  /**
   * Pedido
   * @return cOrderId
   **/
  @Schema(description = "Pedido")
  
    public Integer getCOrderId() {
    return cOrderId;
  }

  public void setCOrderId(Integer cOrderId) {
    this.cOrderId = cOrderId;
  }

  public DocumentDiscount cOrderlineId(Integer cOrderlineId) {
    this.cOrderlineId = cOrderlineId;
    return this;
  }

  /**
   * Línea de Pedido de Cliente
   * @return cOrderlineId
   **/
  @Schema(description = "Línea de Pedido de Cliente")
  
    public Integer getCOrderlineId() {
    return cOrderlineId;
  }

  public void setCOrderlineId(Integer cOrderlineId) {
    this.cOrderlineId = cOrderlineId;
  }

  public DocumentDiscount cPaymentId(Integer cPaymentId) {
    this.cPaymentId = cPaymentId;
    return this;
  }

  /**
   * Identificador del pago
   * @return cPaymentId
   **/
  @Schema(description = "Identificador del pago")
  
    public Integer getCPaymentId() {
    return cPaymentId;
  }

  public void setCPaymentId(Integer cPaymentId) {
    this.cPaymentId = cPaymentId;
  }

  public DocumentDiscount created(String created) {
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

  public DocumentDiscount createdby(Integer createdby) {
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

  public DocumentDiscount cumulativelevel(String cumulativelevel) {
    this.cumulativelevel = cumulativelevel;
    return this;
  }

  /**
   * Nivel para cálculos acumulados
   * @return cumulativelevel
   **/
  @Schema(description = "Nivel para cálculos acumulados")
  
    public String getCumulativelevel() {
    return cumulativelevel;
  }

  public void setCumulativelevel(String cumulativelevel) {
    this.cumulativelevel = cumulativelevel;
  }

  public DocumentDiscount description(String description) {
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

  public DocumentDiscount discountamt(BigDecimal discountamt) {
    this.discountamt = discountamt;
    return this;
  }

  /**
   * Importe del Descuento calculado
   * @return discountamt
   **/
  @Schema(required = true, description = "Importe del Descuento calculado")
      @NotNull

    @Valid
    public BigDecimal getDiscountamt() {
    return discountamt;
  }

  public void setDiscountamt(BigDecimal discountamt) {
    this.discountamt = discountamt;
  }

  public DocumentDiscount discountapplication(String discountapplication) {
    this.discountapplication = discountapplication;
    return this;
  }

  /**
   * Forma de Aplicación del Descuento
   * @return discountapplication
   **/
  @Schema(description = "Forma de Aplicación del Descuento")
  
    public String getDiscountapplication() {
    return discountapplication;
  }

  public void setDiscountapplication(String discountapplication) {
    this.discountapplication = discountapplication;
  }

  public DocumentDiscount discountbaseamt(BigDecimal discountbaseamt) {
    this.discountbaseamt = discountbaseamt;
    return this;
  }

  /**
   * Importe Base de aplicación del Descuento
   * @return discountbaseamt
   **/
  @Schema(required = true, description = "Importe Base de aplicación del Descuento")
      @NotNull

    @Valid
    public BigDecimal getDiscountbaseamt() {
    return discountbaseamt;
  }

  public void setDiscountbaseamt(BigDecimal discountbaseamt) {
    this.discountbaseamt = discountbaseamt;
  }

  public DocumentDiscount discountkind(String discountkind) {
    this.discountkind = discountkind;
    return this;
  }

  /**
   * Tipo u Origen del Descuento
   * @return discountkind
   **/
  @Schema(description = "Tipo u Origen del Descuento")
  
    public String getDiscountkind() {
    return discountkind;
  }

  public void setDiscountkind(String discountkind) {
    this.discountkind = discountkind;
  }

  public DocumentDiscount isactive(Boolean isactive) {
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

  public DocumentDiscount mDiscountschemaId(Integer mDiscountschemaId) {
    this.mDiscountschemaId = mDiscountschemaId;
    return this;
  }

  /**
   * Esquema para calcular el porcentaje de descuento comercial
   * @return mDiscountschemaId
   **/
  @Schema(description = "Esquema para calcular el porcentaje de descuento comercial")
  
    public Integer getMDiscountschemaId() {
    return mDiscountschemaId;
  }

  public void setMDiscountschemaId(Integer mDiscountschemaId) {
    this.mDiscountschemaId = mDiscountschemaId;
  }

  public DocumentDiscount taxrate(BigDecimal taxrate) {
    this.taxrate = taxrate;
    return this;
  }

  /**
   * Tasa del Impuesto
   * @return taxrate
   **/
  @Schema(description = "Tasa del Impuesto")
  
    @Valid
    public BigDecimal getTaxrate() {
    return taxrate;
  }

  public void setTaxrate(BigDecimal taxrate) {
    this.taxrate = taxrate;
  }

  public DocumentDiscount updated(String updated) {
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

  public DocumentDiscount updatedby(Integer updatedby) {
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

  public DocumentDiscount additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public DocumentDiscount addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public DocumentDiscount referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public DocumentDiscount addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    DocumentDiscount documentDiscount = (DocumentDiscount) o;
    return Objects.equals(this.adClientId, documentDiscount.adClientId) &&
        Objects.equals(this.adOrgId, documentDiscount.adOrgId) &&
        Objects.equals(this.cDocumentdiscountId, documentDiscount.cDocumentdiscountId) &&
        Objects.equals(this.cDocumentdiscountParentId, documentDiscount.cDocumentdiscountParentId) &&
        Objects.equals(this.cInvoiceId, documentDiscount.cInvoiceId) &&
        Objects.equals(this.cInvoicelineId, documentDiscount.cInvoicelineId) &&
        Objects.equals(this.cOrderId, documentDiscount.cOrderId) &&
        Objects.equals(this.cOrderlineId, documentDiscount.cOrderlineId) &&
        Objects.equals(this.cPaymentId, documentDiscount.cPaymentId) &&
        Objects.equals(this.created, documentDiscount.created) &&
        Objects.equals(this.createdby, documentDiscount.createdby) &&
        Objects.equals(this.cumulativelevel, documentDiscount.cumulativelevel) &&
        Objects.equals(this.description, documentDiscount.description) &&
        Objects.equals(this.discountamt, documentDiscount.discountamt) &&
        Objects.equals(this.discountapplication, documentDiscount.discountapplication) &&
        Objects.equals(this.discountbaseamt, documentDiscount.discountbaseamt) &&
        Objects.equals(this.discountkind, documentDiscount.discountkind) &&
        Objects.equals(this.isactive, documentDiscount.isactive) &&
        Objects.equals(this.mDiscountschemaId, documentDiscount.mDiscountschemaId) &&
        Objects.equals(this.taxrate, documentDiscount.taxrate) &&
        Objects.equals(this.updated, documentDiscount.updated) &&
        Objects.equals(this.updatedby, documentDiscount.updatedby) &&
        Objects.equals(this.additionalvalues, documentDiscount.additionalvalues) &&
        Objects.equals(this.referencedvalues, documentDiscount.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, cDocumentdiscountId, cDocumentdiscountParentId, cInvoiceId, cInvoicelineId, cOrderId, cOrderlineId, cPaymentId, created, createdby, cumulativelevel, description, discountamt, discountapplication, discountbaseamt, discountkind, isactive, mDiscountschemaId, taxrate, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentDiscount {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cDocumentdiscountId: ").append(toIndentedString(cDocumentdiscountId)).append("\n");
    sb.append("    cDocumentdiscountParentId: ").append(toIndentedString(cDocumentdiscountParentId)).append("\n");
    sb.append("    cInvoiceId: ").append(toIndentedString(cInvoiceId)).append("\n");
    sb.append("    cInvoicelineId: ").append(toIndentedString(cInvoicelineId)).append("\n");
    sb.append("    cOrderId: ").append(toIndentedString(cOrderId)).append("\n");
    sb.append("    cOrderlineId: ").append(toIndentedString(cOrderlineId)).append("\n");
    sb.append("    cPaymentId: ").append(toIndentedString(cPaymentId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cumulativelevel: ").append(toIndentedString(cumulativelevel)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    discountamt: ").append(toIndentedString(discountamt)).append("\n");
    sb.append("    discountapplication: ").append(toIndentedString(discountapplication)).append("\n");
    sb.append("    discountbaseamt: ").append(toIndentedString(discountbaseamt)).append("\n");
    sb.append("    discountkind: ").append(toIndentedString(discountkind)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    mDiscountschemaId: ").append(toIndentedString(mDiscountschemaId)).append("\n");
    sb.append("    taxrate: ").append(toIndentedString(taxrate)).append("\n");
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
