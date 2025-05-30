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
 * InvoiceLine
 */
@Validated



public class InvoiceLine   {
  @JsonProperty("a_asset_id")
  private Integer aAssetId = null;

  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_bpartner_vendor_id")
  private Integer cBpartnerVendorId = null;

  @JsonProperty("c_charge_id")
  private Integer cChargeId = null;

  @JsonProperty("c_invoice_id")
  private Integer cInvoiceId = null;

  @JsonProperty("c_invoiceline_id")
  private Integer cInvoicelineId = null;

  @JsonProperty("c_orderline_id")
  private Integer cOrderlineId = null;

  @JsonProperty("costprice")
  private BigDecimal costprice = null;

  @JsonProperty("c_project_id")
  private Integer cProjectId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("c_tax_id")
  private Integer cTaxId = null;

  @JsonProperty("c_uom_id")
  private Integer cUomId = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("documentdiscountamt")
  private BigDecimal documentdiscountamt = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isdescription")
  private Boolean isdescription = null;

  @JsonProperty("isprinted")
  private Boolean isprinted = null;

  @JsonProperty("line")
  private Integer line = null;

  @JsonProperty("linebonusamt")
  private BigDecimal linebonusamt = null;

  @JsonProperty("linediscountamt")
  private BigDecimal linediscountamt = null;

  @JsonProperty("linenetamount")
  private BigDecimal linenetamount = null;

  @JsonProperty("linenetamt")
  private BigDecimal linenetamt = null;

  @JsonProperty("linetotalamt")
  private BigDecimal linetotalamt = null;

  @JsonProperty("manualgeneraldiscountamt")
  private BigDecimal manualgeneraldiscountamt = null;

  @JsonProperty("m_attributesetinstance_id")
  private Integer mAttributesetinstanceId = null;

  @JsonProperty("m_import_clearance_id")
  private Integer mImportClearanceId = null;

  @JsonProperty("m_inoutline_id")
  private Integer mInoutlineId = null;

  @JsonProperty("m_product_id")
  private Integer mProductId = null;

  @JsonProperty("priceactual")
  private BigDecimal priceactual = null;

  @JsonProperty("priceentered")
  private BigDecimal priceentered = null;

  @JsonProperty("pricelimit")
  private BigDecimal pricelimit = null;

  @JsonProperty("pricelist")
  private BigDecimal pricelist = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("qtyentered")
  private BigDecimal qtyentered = null;

  @JsonProperty("qtyinvoiced")
  private BigDecimal qtyinvoiced = null;

  @JsonProperty("ref_invoiceline_id")
  private Integer refInvoicelineId = null;

  @JsonProperty("salesrep_orig_id")
  private Integer salesrepOrigId = null;

  @JsonProperty("taxamt")
  private BigDecimal taxamt = null;

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

  public InvoiceLine aAssetId(Integer aAssetId) {
    this.aAssetId = aAssetId;
    return this;
  }

  /**
   * Activo usado por la compañía o sus clientes
   * @return aAssetId
   **/
  @Schema(description = "Activo usado por la compañía o sus clientes")
  
    public Integer getAAssetId() {
    return aAssetId;
  }

  public void setAAssetId(Integer aAssetId) {
    this.aAssetId = aAssetId;
  }

  public InvoiceLine adClientId(Integer adClientId) {
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

  public InvoiceLine adOrgId(Integer adOrgId) {
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

  public InvoiceLine cBpartnerVendorId(Integer cBpartnerVendorId) {
    this.cBpartnerVendorId = cBpartnerVendorId;
    return this;
  }

  /**
   * Proveedor actual del artículo de la línea de la factura
   * @return cBpartnerVendorId
   **/
  @Schema(description = "Proveedor actual del artículo de la línea de la factura")
  
    public Integer getCBpartnerVendorId() {
    return cBpartnerVendorId;
  }

  public void setCBpartnerVendorId(Integer cBpartnerVendorId) {
    this.cBpartnerVendorId = cBpartnerVendorId;
  }

  public InvoiceLine cChargeId(Integer cChargeId) {
    this.cChargeId = cChargeId;
    return this;
  }

  /**
   * Cargos adicionales del documento
   * @return cChargeId
   **/
  @Schema(description = "Cargos adicionales del documento")
  
    public Integer getCChargeId() {
    return cChargeId;
  }

  public void setCChargeId(Integer cChargeId) {
    this.cChargeId = cChargeId;
  }

  public InvoiceLine cInvoiceId(Integer cInvoiceId) {
    this.cInvoiceId = cInvoiceId;
    return this;
  }

  /**
   * Identificador de la factura
   * @return cInvoiceId
   **/
  @Schema(required = true, description = "Identificador de la factura")
      @NotNull

    public Integer getCInvoiceId() {
    return cInvoiceId;
  }

  public void setCInvoiceId(Integer cInvoiceId) {
    this.cInvoiceId = cInvoiceId;
  }

  public InvoiceLine cInvoicelineId(Integer cInvoicelineId) {
    this.cInvoicelineId = cInvoicelineId;
    return this;
  }

  /**
   * Línea de detalle de la factura
   * @return cInvoicelineId
   **/
  @Schema(required = true, description = "Línea de detalle de la factura")
      @NotNull

    public Integer getCInvoicelineId() {
    return cInvoicelineId;
  }

  public void setCInvoicelineId(Integer cInvoicelineId) {
    this.cInvoicelineId = cInvoicelineId;
  }

  public InvoiceLine cOrderlineId(Integer cOrderlineId) {
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

  public InvoiceLine costprice(BigDecimal costprice) {
    this.costprice = costprice;
    return this;
  }

  /**
   * Precio de costo actual del artículo
   * @return costprice
   **/
  @Schema(required = true, description = "Precio de costo actual del artículo")
      @NotNull

    @Valid
    public BigDecimal getCostprice() {
    return costprice;
  }

  public void setCostprice(BigDecimal costprice) {
    this.costprice = costprice;
  }

  public InvoiceLine cProjectId(Integer cProjectId) {
    this.cProjectId = cProjectId;
    return this;
  }

  /**
   * Identifica un proyecto único
   * @return cProjectId
   **/
  @Schema(description = "Identifica un proyecto único")
  
    public Integer getCProjectId() {
    return cProjectId;
  }

  public void setCProjectId(Integer cProjectId) {
    this.cProjectId = cProjectId;
  }

  public InvoiceLine created(String created) {
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

  public InvoiceLine createdby(Integer createdby) {
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

  public InvoiceLine cTaxId(Integer cTaxId) {
    this.cTaxId = cTaxId;
    return this;
  }

  /**
   * Identificador del Impuesto
   * @return cTaxId
   **/
  @Schema(required = true, description = "Identificador del Impuesto")
      @NotNull

    public Integer getCTaxId() {
    return cTaxId;
  }

  public void setCTaxId(Integer cTaxId) {
    this.cTaxId = cTaxId;
  }

  public InvoiceLine cUomId(Integer cUomId) {
    this.cUomId = cUomId;
    return this;
  }

  /**
   * Unidad de Medida
   * @return cUomId
   **/
  @Schema(description = "Unidad de Medida")
  
    public Integer getCUomId() {
    return cUomId;
  }

  public void setCUomId(Integer cUomId) {
    this.cUomId = cUomId;
  }

  public InvoiceLine description(String description) {
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

  public InvoiceLine documentdiscountamt(BigDecimal documentdiscountamt) {
    this.documentdiscountamt = documentdiscountamt;
    return this;
  }

  /**
   * Descuento a Nivel de Documento calculado para esta Línea
   * @return documentdiscountamt
   **/
  @Schema(required = true, description = "Descuento a Nivel de Documento calculado para esta Línea")
      @NotNull

    @Valid
    public BigDecimal getDocumentdiscountamt() {
    return documentdiscountamt;
  }

  public void setDocumentdiscountamt(BigDecimal documentdiscountamt) {
    this.documentdiscountamt = documentdiscountamt;
  }

  public InvoiceLine isactive(Boolean isactive) {
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

  public InvoiceLine isdescription(Boolean isdescription) {
    this.isdescription = isdescription;
    return this;
  }

  /**
   * Sólo Descripción
   * @return isdescription
   **/
  @Schema(required = true, description = "Sólo Descripción")
      @NotNull

    public Boolean isIsdescription() {
    return isdescription;
  }

  public void setIsdescription(Boolean isdescription) {
    this.isdescription = isdescription;
  }

  public InvoiceLine isprinted(Boolean isprinted) {
    this.isprinted = isprinted;
    return this;
  }

  /**
   * Indica si este documento es impreso
   * @return isprinted
   **/
  @Schema(required = true, description = "Indica si este documento es impreso")
      @NotNull

    public Boolean isIsprinted() {
    return isprinted;
  }

  public void setIsprinted(Boolean isprinted) {
    this.isprinted = isprinted;
  }

  public InvoiceLine line(Integer line) {
    this.line = line;
    return this;
  }

  /**
   * No. Línea único para este documento
   * @return line
   **/
  @Schema(required = true, description = "No. Línea único para este documento")
      @NotNull

    public Integer getLine() {
    return line;
  }

  public void setLine(Integer line) {
    this.line = line;
  }

  public InvoiceLine linebonusamt(BigDecimal linebonusamt) {
    this.linebonusamt = linebonusamt;
    return this;
  }

  /**
   * Importe de bonificación de la línea
   * @return linebonusamt
   **/
  @Schema(required = true, description = "Importe de bonificación de la línea")
      @NotNull

    @Valid
    public BigDecimal getLinebonusamt() {
    return linebonusamt;
  }

  public void setLinebonusamt(BigDecimal linebonusamt) {
    this.linebonusamt = linebonusamt;
  }

  public InvoiceLine linediscountamt(BigDecimal linediscountamt) {
    this.linediscountamt = linediscountamt;
    return this;
  }

  /**
   * Descuento de línea como un porcentaje
   * @return linediscountamt
   **/
  @Schema(required = true, description = "Descuento de línea como un porcentaje")
      @NotNull

    @Valid
    public BigDecimal getLinediscountamt() {
    return linediscountamt;
  }

  public void setLinediscountamt(BigDecimal linediscountamt) {
    this.linediscountamt = linediscountamt;
  }

  public InvoiceLine linenetamount(BigDecimal linenetamount) {
    this.linenetamount = linenetamount;
    return this;
  }

  /**
   *  
   * @return linenetamount
   **/
  @Schema(required = true, description = " ")
      @NotNull

    @Valid
    public BigDecimal getLinenetamount() {
    return linenetamount;
  }

  public void setLinenetamount(BigDecimal linenetamount) {
    this.linenetamount = linenetamount;
  }

  public InvoiceLine linenetamt(BigDecimal linenetamt) {
    this.linenetamt = linenetamt;
    return this;
  }

  /**
   * Importe Neto de la Línea (Cantidad * Precio Actual) sin Fletes ni Cargos
   * @return linenetamt
   **/
  @Schema(required = true, description = "Importe Neto de la Línea (Cantidad * Precio Actual) sin Fletes ni Cargos")
      @NotNull

    @Valid
    public BigDecimal getLinenetamt() {
    return linenetamt;
  }

  public void setLinenetamt(BigDecimal linenetamt) {
    this.linenetamt = linenetamt;
  }

  public InvoiceLine linetotalamt(BigDecimal linetotalamt) {
    this.linetotalamt = linetotalamt;
    return this;
  }

  /**
   * Total de Línea (Impuestos Incluidos)
   * @return linetotalamt
   **/
  @Schema(description = "Total de Línea (Impuestos Incluidos)")
  
    @Valid
    public BigDecimal getLinetotalamt() {
    return linetotalamt;
  }

  public void setLinetotalamt(BigDecimal linetotalamt) {
    this.linetotalamt = linetotalamt;
  }

  public InvoiceLine manualgeneraldiscountamt(BigDecimal manualgeneraldiscountamt) {
    this.manualgeneraldiscountamt = manualgeneraldiscountamt;
    return this;
  }

  /**
   * Importe de Descuento General
   * @return manualgeneraldiscountamt
   **/
  @Schema(description = "Importe de Descuento General")
  
    @Valid
    public BigDecimal getManualgeneraldiscountamt() {
    return manualgeneraldiscountamt;
  }

  public void setManualgeneraldiscountamt(BigDecimal manualgeneraldiscountamt) {
    this.manualgeneraldiscountamt = manualgeneraldiscountamt;
  }

  public InvoiceLine mAttributesetinstanceId(Integer mAttributesetinstanceId) {
    this.mAttributesetinstanceId = mAttributesetinstanceId;
    return this;
  }

  /**
   * Instancia del Conjunto de Attributos del Producto
   * @return mAttributesetinstanceId
   **/
  @Schema(required = true, description = "Instancia del Conjunto de Attributos del Producto")
      @NotNull

    public Integer getMAttributesetinstanceId() {
    return mAttributesetinstanceId;
  }

  public void setMAttributesetinstanceId(Integer mAttributesetinstanceId) {
    this.mAttributesetinstanceId = mAttributesetinstanceId;
  }

  public InvoiceLine mImportClearanceId(Integer mImportClearanceId) {
    this.mImportClearanceId = mImportClearanceId;
    return this;
  }

  /**
   *  
   * @return mImportClearanceId
   **/
  @Schema(description = " ")
  
    public Integer getMImportClearanceId() {
    return mImportClearanceId;
  }

  public void setMImportClearanceId(Integer mImportClearanceId) {
    this.mImportClearanceId = mImportClearanceId;
  }

  public InvoiceLine mInoutlineId(Integer mInoutlineId) {
    this.mInoutlineId = mInoutlineId;
    return this;
  }

  /**
   * Línea en el Entrega o Documento de Recibo
   * @return mInoutlineId
   **/
  @Schema(description = "Línea en el Entrega o Documento de Recibo")
  
    public Integer getMInoutlineId() {
    return mInoutlineId;
  }

  public void setMInoutlineId(Integer mInoutlineId) {
    this.mInoutlineId = mInoutlineId;
  }

  public InvoiceLine mProductId(Integer mProductId) {
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

  public InvoiceLine priceactual(BigDecimal priceactual) {
    this.priceactual = priceactual;
    return this;
  }

  /**
   * Precio Actual
   * @return priceactual
   **/
  @Schema(required = true, description = "Precio Actual")
      @NotNull

    @Valid
    public BigDecimal getPriceactual() {
    return priceactual;
  }

  public void setPriceactual(BigDecimal priceactual) {
    this.priceactual = priceactual;
  }

  public InvoiceLine priceentered(BigDecimal priceentered) {
    this.priceentered = priceentered;
    return this;
  }

  /**
   * Precio
   * @return priceentered
   **/
  @Schema(required = true, description = "Precio")
      @NotNull

    @Valid
    public BigDecimal getPriceentered() {
    return priceentered;
  }

  public void setPriceentered(BigDecimal priceentered) {
    this.priceentered = priceentered;
  }

  public InvoiceLine pricelimit(BigDecimal pricelimit) {
    this.pricelimit = pricelimit;
    return this;
  }

  /**
   * Precio más bajo del producto
   * @return pricelimit
   **/
  @Schema(required = true, description = "Precio más bajo del producto")
      @NotNull

    @Valid
    public BigDecimal getPricelimit() {
    return pricelimit;
  }

  public void setPricelimit(BigDecimal pricelimit) {
    this.pricelimit = pricelimit;
  }

  public InvoiceLine pricelist(BigDecimal pricelist) {
    this.pricelist = pricelist;
    return this;
  }

  /**
   * Precio de Tarifa
   * @return pricelist
   **/
  @Schema(required = true, description = "Precio de Tarifa")
      @NotNull

    @Valid
    public BigDecimal getPricelist() {
    return pricelist;
  }

  public void setPricelist(BigDecimal pricelist) {
    this.pricelist = pricelist;
  }

  public InvoiceLine processed(Boolean processed) {
    this.processed = processed;
    return this;
  }

  /**
   * El documento ha sido procesado
   * @return processed
   **/
  @Schema(required = true, description = "El documento ha sido procesado")
      @NotNull

    public Boolean isProcessed() {
    return processed;
  }

  public void setProcessed(Boolean processed) {
    this.processed = processed;
  }

  public InvoiceLine qtyentered(BigDecimal qtyentered) {
    this.qtyentered = qtyentered;
    return this;
  }

  /**
   * Cantidad
   * @return qtyentered
   **/
  @Schema(required = true, description = "Cantidad")
      @NotNull

    @Valid
    public BigDecimal getQtyentered() {
    return qtyentered;
  }

  public void setQtyentered(BigDecimal qtyentered) {
    this.qtyentered = qtyentered;
  }

  public InvoiceLine qtyinvoiced(BigDecimal qtyinvoiced) {
    this.qtyinvoiced = qtyinvoiced;
    return this;
  }

  /**
   * Cantidad facturada
   * @return qtyinvoiced
   **/
  @Schema(required = true, description = "Cantidad facturada")
      @NotNull

    @Valid
    public BigDecimal getQtyinvoiced() {
    return qtyinvoiced;
  }

  public void setQtyinvoiced(BigDecimal qtyinvoiced) {
    this.qtyinvoiced = qtyinvoiced;
  }

  public InvoiceLine refInvoicelineId(Integer refInvoicelineId) {
    this.refInvoicelineId = refInvoicelineId;
    return this;
  }

  /**
   *  
   * @return refInvoicelineId
   **/
  @Schema(description = " ")
  
    public Integer getRefInvoicelineId() {
    return refInvoicelineId;
  }

  public void setRefInvoicelineId(Integer refInvoicelineId) {
    this.refInvoicelineId = refInvoicelineId;
  }

  public InvoiceLine salesrepOrigId(Integer salesrepOrigId) {
    this.salesrepOrigId = salesrepOrigId;
    return this;
  }

  /**
   * Responsable de Ventas Original
   * @return salesrepOrigId
   **/
  @Schema(description = "Responsable de Ventas Original")
  
    public Integer getSalesrepOrigId() {
    return salesrepOrigId;
  }

  public void setSalesrepOrigId(Integer salesrepOrigId) {
    this.salesrepOrigId = salesrepOrigId;
  }

  public InvoiceLine taxamt(BigDecimal taxamt) {
    this.taxamt = taxamt;
    return this;
  }

  /**
   * Importe del Impuesto
   * @return taxamt
   **/
  @Schema(description = "Importe del Impuesto")
  
    @Valid
    public BigDecimal getTaxamt() {
    return taxamt;
  }

  public void setTaxamt(BigDecimal taxamt) {
    this.taxamt = taxamt;
  }

  public InvoiceLine updated(String updated) {
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

  public InvoiceLine updatedby(Integer updatedby) {
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

  public InvoiceLine additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public InvoiceLine addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public InvoiceLine referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public InvoiceLine addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    InvoiceLine invoiceLine = (InvoiceLine) o;
    return Objects.equals(this.aAssetId, invoiceLine.aAssetId) &&
        Objects.equals(this.adClientId, invoiceLine.adClientId) &&
        Objects.equals(this.adOrgId, invoiceLine.adOrgId) &&
        Objects.equals(this.cBpartnerVendorId, invoiceLine.cBpartnerVendorId) &&
        Objects.equals(this.cChargeId, invoiceLine.cChargeId) &&
        Objects.equals(this.cInvoiceId, invoiceLine.cInvoiceId) &&
        Objects.equals(this.cInvoicelineId, invoiceLine.cInvoicelineId) &&
        Objects.equals(this.cOrderlineId, invoiceLine.cOrderlineId) &&
        Objects.equals(this.costprice, invoiceLine.costprice) &&
        Objects.equals(this.cProjectId, invoiceLine.cProjectId) &&
        Objects.equals(this.created, invoiceLine.created) &&
        Objects.equals(this.createdby, invoiceLine.createdby) &&
        Objects.equals(this.cTaxId, invoiceLine.cTaxId) &&
        Objects.equals(this.cUomId, invoiceLine.cUomId) &&
        Objects.equals(this.description, invoiceLine.description) &&
        Objects.equals(this.documentdiscountamt, invoiceLine.documentdiscountamt) &&
        Objects.equals(this.isactive, invoiceLine.isactive) &&
        Objects.equals(this.isdescription, invoiceLine.isdescription) &&
        Objects.equals(this.isprinted, invoiceLine.isprinted) &&
        Objects.equals(this.line, invoiceLine.line) &&
        Objects.equals(this.linebonusamt, invoiceLine.linebonusamt) &&
        Objects.equals(this.linediscountamt, invoiceLine.linediscountamt) &&
        Objects.equals(this.linenetamount, invoiceLine.linenetamount) &&
        Objects.equals(this.linenetamt, invoiceLine.linenetamt) &&
        Objects.equals(this.linetotalamt, invoiceLine.linetotalamt) &&
        Objects.equals(this.manualgeneraldiscountamt, invoiceLine.manualgeneraldiscountamt) &&
        Objects.equals(this.mAttributesetinstanceId, invoiceLine.mAttributesetinstanceId) &&
        Objects.equals(this.mImportClearanceId, invoiceLine.mImportClearanceId) &&
        Objects.equals(this.mInoutlineId, invoiceLine.mInoutlineId) &&
        Objects.equals(this.mProductId, invoiceLine.mProductId) &&
        Objects.equals(this.priceactual, invoiceLine.priceactual) &&
        Objects.equals(this.priceentered, invoiceLine.priceentered) &&
        Objects.equals(this.pricelimit, invoiceLine.pricelimit) &&
        Objects.equals(this.pricelist, invoiceLine.pricelist) &&
        Objects.equals(this.processed, invoiceLine.processed) &&
        Objects.equals(this.qtyentered, invoiceLine.qtyentered) &&
        Objects.equals(this.qtyinvoiced, invoiceLine.qtyinvoiced) &&
        Objects.equals(this.refInvoicelineId, invoiceLine.refInvoicelineId) &&
        Objects.equals(this.salesrepOrigId, invoiceLine.salesrepOrigId) &&
        Objects.equals(this.taxamt, invoiceLine.taxamt) &&
        Objects.equals(this.updated, invoiceLine.updated) &&
        Objects.equals(this.updatedby, invoiceLine.updatedby) &&
        Objects.equals(this.additionalvalues, invoiceLine.additionalvalues) &&
        Objects.equals(this.referencedvalues, invoiceLine.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aAssetId, adClientId, adOrgId, cBpartnerVendorId, cChargeId, cInvoiceId, cInvoicelineId, cOrderlineId, costprice, cProjectId, created, createdby, cTaxId, cUomId, description, documentdiscountamt, isactive, isdescription, isprinted, line, linebonusamt, linediscountamt, linenetamount, linenetamt, linetotalamt, manualgeneraldiscountamt, mAttributesetinstanceId, mImportClearanceId, mInoutlineId, mProductId, priceactual, priceentered, pricelimit, pricelist, processed, qtyentered, qtyinvoiced, refInvoicelineId, salesrepOrigId, taxamt, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvoiceLine {\n");
    
    sb.append("    aAssetId: ").append(toIndentedString(aAssetId)).append("\n");
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cBpartnerVendorId: ").append(toIndentedString(cBpartnerVendorId)).append("\n");
    sb.append("    cChargeId: ").append(toIndentedString(cChargeId)).append("\n");
    sb.append("    cInvoiceId: ").append(toIndentedString(cInvoiceId)).append("\n");
    sb.append("    cInvoicelineId: ").append(toIndentedString(cInvoicelineId)).append("\n");
    sb.append("    cOrderlineId: ").append(toIndentedString(cOrderlineId)).append("\n");
    sb.append("    costprice: ").append(toIndentedString(costprice)).append("\n");
    sb.append("    cProjectId: ").append(toIndentedString(cProjectId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cTaxId: ").append(toIndentedString(cTaxId)).append("\n");
    sb.append("    cUomId: ").append(toIndentedString(cUomId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    documentdiscountamt: ").append(toIndentedString(documentdiscountamt)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isdescription: ").append(toIndentedString(isdescription)).append("\n");
    sb.append("    isprinted: ").append(toIndentedString(isprinted)).append("\n");
    sb.append("    line: ").append(toIndentedString(line)).append("\n");
    sb.append("    linebonusamt: ").append(toIndentedString(linebonusamt)).append("\n");
    sb.append("    linediscountamt: ").append(toIndentedString(linediscountamt)).append("\n");
    sb.append("    linenetamount: ").append(toIndentedString(linenetamount)).append("\n");
    sb.append("    linenetamt: ").append(toIndentedString(linenetamt)).append("\n");
    sb.append("    linetotalamt: ").append(toIndentedString(linetotalamt)).append("\n");
    sb.append("    manualgeneraldiscountamt: ").append(toIndentedString(manualgeneraldiscountamt)).append("\n");
    sb.append("    mAttributesetinstanceId: ").append(toIndentedString(mAttributesetinstanceId)).append("\n");
    sb.append("    mImportClearanceId: ").append(toIndentedString(mImportClearanceId)).append("\n");
    sb.append("    mInoutlineId: ").append(toIndentedString(mInoutlineId)).append("\n");
    sb.append("    mProductId: ").append(toIndentedString(mProductId)).append("\n");
    sb.append("    priceactual: ").append(toIndentedString(priceactual)).append("\n");
    sb.append("    priceentered: ").append(toIndentedString(priceentered)).append("\n");
    sb.append("    pricelimit: ").append(toIndentedString(pricelimit)).append("\n");
    sb.append("    pricelist: ").append(toIndentedString(pricelist)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    qtyentered: ").append(toIndentedString(qtyentered)).append("\n");
    sb.append("    qtyinvoiced: ").append(toIndentedString(qtyinvoiced)).append("\n");
    sb.append("    refInvoicelineId: ").append(toIndentedString(refInvoicelineId)).append("\n");
    sb.append("    salesrepOrigId: ").append(toIndentedString(salesrepOrigId)).append("\n");
    sb.append("    taxamt: ").append(toIndentedString(taxamt)).append("\n");
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
