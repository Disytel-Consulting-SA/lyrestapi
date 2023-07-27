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
 * OrderLine
 */
@Validated



public class OrderLine   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_bpartner_id")
  private Integer cBpartnerId = null;

  @JsonProperty("c_bpartner_location_id")
  private Integer cBpartnerLocationId = null;

  @JsonProperty("c_charge_id")
  private Integer cChargeId = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("checkoutplace")
  private String checkoutplace = null;

  @JsonProperty("c_order_id")
  private Integer cOrderId = null;

  @JsonProperty("c_orderline_id")
  private Integer cOrderlineId = null;

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

  @JsonProperty("datedelivered")
  private String datedelivered = null;

  @JsonProperty("dateinvoiced")
  private String dateinvoiced = null;

  @JsonProperty("dateordered")
  private String dateordered = null;

  @JsonProperty("datepromised")
  private String datepromised = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("diffamt")
  private BigDecimal diffamt = null;

  @JsonProperty("discount")
  private BigDecimal discount = null;

  @JsonProperty("documentdiscountamt")
  private BigDecimal documentdiscountamt = null;

  @JsonProperty("freightamt")
  private BigDecimal freightamt = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isdescription")
  private Boolean isdescription = null;

  @JsonProperty("line")
  private Integer line = null;

  @JsonProperty("linebonusamt")
  private BigDecimal linebonusamt = null;

  @JsonProperty("linediscountamt")
  private BigDecimal linediscountamt = null;

  @JsonProperty("linenetamt")
  private BigDecimal linenetamt = null;

  @JsonProperty("linetotalamt")
  private BigDecimal linetotalamt = null;

  @JsonProperty("manualgeneraldiscountamt")
  private BigDecimal manualgeneraldiscountamt = null;

  @JsonProperty("m_attributesetinstance_id")
  private Integer mAttributesetinstanceId = null;

  @JsonProperty("m_product_id")
  private Integer mProductId = null;

  @JsonProperty("m_shipper_id")
  private Integer mShipperId = null;

  @JsonProperty("m_warehouse_id")
  private Integer mWarehouseId = null;

  @JsonProperty("order_min")
  private BigDecimal orderMin = null;

  @JsonProperty("order_pack")
  private BigDecimal orderPack = null;

  @JsonProperty("priceactual")
  private BigDecimal priceactual = null;

  @JsonProperty("pricediff")
  private BigDecimal pricediff = null;

  @JsonProperty("priceentered")
  private BigDecimal priceentered = null;

  @JsonProperty("pricelimit")
  private BigDecimal pricelimit = null;

  @JsonProperty("pricelist")
  private BigDecimal pricelist = null;

  @JsonProperty("pricereception")
  private BigDecimal pricereception = null;

  @JsonProperty("processed")
  private Boolean processed = null;

  @JsonProperty("qtydelivered")
  private BigDecimal qtydelivered = null;

  @JsonProperty("qtydiff")
  private BigDecimal qtydiff = null;

  @JsonProperty("qtyentered")
  private BigDecimal qtyentered = null;

  @JsonProperty("qtyinvoiced")
  private BigDecimal qtyinvoiced = null;

  @JsonProperty("qtyordered")
  private BigDecimal qtyordered = null;

  @JsonProperty("qtyreception")
  private BigDecimal qtyreception = null;

  @JsonProperty("qtyreserved")
  private BigDecimal qtyreserved = null;

  @JsonProperty("qtyreturned")
  private BigDecimal qtyreturned = null;

  @JsonProperty("qtytransferred")
  private BigDecimal qtytransferred = null;

  @JsonProperty("receptionamt")
  private BigDecimal receptionamt = null;

  @JsonProperty("ref_orderline_id")
  private Integer refOrderlineId = null;

  @JsonProperty("salesrep_orig_id")
  private Integer salesrepOrigId = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public OrderLine adClientId(Integer adClientId) {
    this.adClientId = adClientId;
    return this;
  }

  /**
   * Get adClientId
   * @return adClientId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getAdClientId() {
    return adClientId;
  }

  public void setAdClientId(Integer adClientId) {
    this.adClientId = adClientId;
  }

  public OrderLine adOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
    return this;
  }

  /**
   * Get adOrgId
   * @return adOrgId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getAdOrgId() {
    return adOrgId;
  }

  public void setAdOrgId(Integer adOrgId) {
    this.adOrgId = adOrgId;
  }

  public OrderLine cBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
    return this;
  }

  /**
   * Get cBpartnerId
   * @return cBpartnerId
   **/
  @Schema(description = "")
  
    public Integer getCBpartnerId() {
    return cBpartnerId;
  }

  public void setCBpartnerId(Integer cBpartnerId) {
    this.cBpartnerId = cBpartnerId;
  }

  public OrderLine cBpartnerLocationId(Integer cBpartnerLocationId) {
    this.cBpartnerLocationId = cBpartnerLocationId;
    return this;
  }

  /**
   * Get cBpartnerLocationId
   * @return cBpartnerLocationId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCBpartnerLocationId() {
    return cBpartnerLocationId;
  }

  public void setCBpartnerLocationId(Integer cBpartnerLocationId) {
    this.cBpartnerLocationId = cBpartnerLocationId;
  }

  public OrderLine cChargeId(Integer cChargeId) {
    this.cChargeId = cChargeId;
    return this;
  }

  /**
   * Get cChargeId
   * @return cChargeId
   **/
  @Schema(description = "")
  
    public Integer getCChargeId() {
    return cChargeId;
  }

  public void setCChargeId(Integer cChargeId) {
    this.cChargeId = cChargeId;
  }

  public OrderLine cCurrencyId(Integer cCurrencyId) {
    this.cCurrencyId = cCurrencyId;
    return this;
  }

  /**
   * Get cCurrencyId
   * @return cCurrencyId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCCurrencyId() {
    return cCurrencyId;
  }

  public void setCCurrencyId(Integer cCurrencyId) {
    this.cCurrencyId = cCurrencyId;
  }

  public OrderLine checkoutplace(String checkoutplace) {
    this.checkoutplace = checkoutplace;
    return this;
  }

  /**
   * Get checkoutplace
   * @return checkoutplace
   **/
  @Schema(description = "")
  
    public String getCheckoutplace() {
    return checkoutplace;
  }

  public void setCheckoutplace(String checkoutplace) {
    this.checkoutplace = checkoutplace;
  }

  public OrderLine cOrderId(Integer cOrderId) {
    this.cOrderId = cOrderId;
    return this;
  }

  /**
   * Get cOrderId
   * @return cOrderId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCOrderId() {
    return cOrderId;
  }

  public void setCOrderId(Integer cOrderId) {
    this.cOrderId = cOrderId;
  }

  public OrderLine cOrderlineId(Integer cOrderlineId) {
    this.cOrderlineId = cOrderlineId;
    return this;
  }

  /**
   * Get cOrderlineId
   * @return cOrderlineId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCOrderlineId() {
    return cOrderlineId;
  }

  public void setCOrderlineId(Integer cOrderlineId) {
    this.cOrderlineId = cOrderlineId;
  }

  public OrderLine cProjectId(Integer cProjectId) {
    this.cProjectId = cProjectId;
    return this;
  }

  /**
   * Get cProjectId
   * @return cProjectId
   **/
  @Schema(description = "")
  
    public Integer getCProjectId() {
    return cProjectId;
  }

  public void setCProjectId(Integer cProjectId) {
    this.cProjectId = cProjectId;
  }

  public OrderLine created(String created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public OrderLine createdby(Integer createdby) {
    this.createdby = createdby;
    return this;
  }

  /**
   * Get createdby
   * @return createdby
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCreatedby() {
    return createdby;
  }

  public void setCreatedby(Integer createdby) {
    this.createdby = createdby;
  }

  public OrderLine cTaxId(Integer cTaxId) {
    this.cTaxId = cTaxId;
    return this;
  }

  /**
   * Get cTaxId
   * @return cTaxId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCTaxId() {
    return cTaxId;
  }

  public void setCTaxId(Integer cTaxId) {
    this.cTaxId = cTaxId;
  }

  public OrderLine cUomId(Integer cUomId) {
    this.cUomId = cUomId;
    return this;
  }

  /**
   * Get cUomId
   * @return cUomId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCUomId() {
    return cUomId;
  }

  public void setCUomId(Integer cUomId) {
    this.cUomId = cUomId;
  }

  public OrderLine datedelivered(String datedelivered) {
    this.datedelivered = datedelivered;
    return this;
  }

  /**
   * Get datedelivered
   * @return datedelivered
   **/
  @Schema(description = "")
  
    public String getDatedelivered() {
    return datedelivered;
  }

  public void setDatedelivered(String datedelivered) {
    this.datedelivered = datedelivered;
  }

  public OrderLine dateinvoiced(String dateinvoiced) {
    this.dateinvoiced = dateinvoiced;
    return this;
  }

  /**
   * Get dateinvoiced
   * @return dateinvoiced
   **/
  @Schema(description = "")
  
    public String getDateinvoiced() {
    return dateinvoiced;
  }

  public void setDateinvoiced(String dateinvoiced) {
    this.dateinvoiced = dateinvoiced;
  }

  public OrderLine dateordered(String dateordered) {
    this.dateordered = dateordered;
    return this;
  }

  /**
   * Get dateordered
   * @return dateordered
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDateordered() {
    return dateordered;
  }

  public void setDateordered(String dateordered) {
    this.dateordered = dateordered;
  }

  public OrderLine datepromised(String datepromised) {
    this.datepromised = datepromised;
    return this;
  }

  /**
   * Get datepromised
   * @return datepromised
   **/
  @Schema(description = "")
  
    public String getDatepromised() {
    return datepromised;
  }

  public void setDatepromised(String datepromised) {
    this.datepromised = datepromised;
  }

  public OrderLine description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  @Schema(description = "")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public OrderLine diffamt(BigDecimal diffamt) {
    this.diffamt = diffamt;
    return this;
  }

  /**
   * Get diffamt
   * @return diffamt
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getDiffamt() {
    return diffamt;
  }

  public void setDiffamt(BigDecimal diffamt) {
    this.diffamt = diffamt;
  }

  public OrderLine discount(BigDecimal discount) {
    this.discount = discount;
    return this;
  }

  /**
   * Get discount
   * @return discount
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getDiscount() {
    return discount;
  }

  public void setDiscount(BigDecimal discount) {
    this.discount = discount;
  }

  public OrderLine documentdiscountamt(BigDecimal documentdiscountamt) {
    this.documentdiscountamt = documentdiscountamt;
    return this;
  }

  /**
   * Get documentdiscountamt
   * @return documentdiscountamt
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getDocumentdiscountamt() {
    return documentdiscountamt;
  }

  public void setDocumentdiscountamt(BigDecimal documentdiscountamt) {
    this.documentdiscountamt = documentdiscountamt;
  }

  public OrderLine freightamt(BigDecimal freightamt) {
    this.freightamt = freightamt;
    return this;
  }

  /**
   * Get freightamt
   * @return freightamt
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getFreightamt() {
    return freightamt;
  }

  public void setFreightamt(BigDecimal freightamt) {
    this.freightamt = freightamt;
  }

  public OrderLine isactive(Boolean isactive) {
    this.isactive = isactive;
    return this;
  }

  /**
   * Get isactive
   * @return isactive
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsactive() {
    return isactive;
  }

  public void setIsactive(Boolean isactive) {
    this.isactive = isactive;
  }

  public OrderLine isdescription(Boolean isdescription) {
    this.isdescription = isdescription;
    return this;
  }

  /**
   * Get isdescription
   * @return isdescription
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isIsdescription() {
    return isdescription;
  }

  public void setIsdescription(Boolean isdescription) {
    this.isdescription = isdescription;
  }

  public OrderLine line(Integer line) {
    this.line = line;
    return this;
  }

  /**
   * Get line
   * @return line
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getLine() {
    return line;
  }

  public void setLine(Integer line) {
    this.line = line;
  }

  public OrderLine linebonusamt(BigDecimal linebonusamt) {
    this.linebonusamt = linebonusamt;
    return this;
  }

  /**
   * Get linebonusamt
   * @return linebonusamt
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getLinebonusamt() {
    return linebonusamt;
  }

  public void setLinebonusamt(BigDecimal linebonusamt) {
    this.linebonusamt = linebonusamt;
  }

  public OrderLine linediscountamt(BigDecimal linediscountamt) {
    this.linediscountamt = linediscountamt;
    return this;
  }

  /**
   * Get linediscountamt
   * @return linediscountamt
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getLinediscountamt() {
    return linediscountamt;
  }

  public void setLinediscountamt(BigDecimal linediscountamt) {
    this.linediscountamt = linediscountamt;
  }

  public OrderLine linenetamt(BigDecimal linenetamt) {
    this.linenetamt = linenetamt;
    return this;
  }

  /**
   * Get linenetamt
   * @return linenetamt
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getLinenetamt() {
    return linenetamt;
  }

  public void setLinenetamt(BigDecimal linenetamt) {
    this.linenetamt = linenetamt;
  }

  public OrderLine linetotalamt(BigDecimal linetotalamt) {
    this.linetotalamt = linetotalamt;
    return this;
  }

  /**
   * Get linetotalamt
   * @return linetotalamt
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getLinetotalamt() {
    return linetotalamt;
  }

  public void setLinetotalamt(BigDecimal linetotalamt) {
    this.linetotalamt = linetotalamt;
  }

  public OrderLine manualgeneraldiscountamt(BigDecimal manualgeneraldiscountamt) {
    this.manualgeneraldiscountamt = manualgeneraldiscountamt;
    return this;
  }

  /**
   * Get manualgeneraldiscountamt
   * @return manualgeneraldiscountamt
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getManualgeneraldiscountamt() {
    return manualgeneraldiscountamt;
  }

  public void setManualgeneraldiscountamt(BigDecimal manualgeneraldiscountamt) {
    this.manualgeneraldiscountamt = manualgeneraldiscountamt;
  }

  public OrderLine mAttributesetinstanceId(Integer mAttributesetinstanceId) {
    this.mAttributesetinstanceId = mAttributesetinstanceId;
    return this;
  }

  /**
   * Get mAttributesetinstanceId
   * @return mAttributesetinstanceId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getMAttributesetinstanceId() {
    return mAttributesetinstanceId;
  }

  public void setMAttributesetinstanceId(Integer mAttributesetinstanceId) {
    this.mAttributesetinstanceId = mAttributesetinstanceId;
  }

  public OrderLine mProductId(Integer mProductId) {
    this.mProductId = mProductId;
    return this;
  }

  /**
   * Get mProductId
   * @return mProductId
   **/
  @Schema(description = "")
  
    public Integer getMProductId() {
    return mProductId;
  }

  public void setMProductId(Integer mProductId) {
    this.mProductId = mProductId;
  }

  public OrderLine mShipperId(Integer mShipperId) {
    this.mShipperId = mShipperId;
    return this;
  }

  /**
   * Get mShipperId
   * @return mShipperId
   **/
  @Schema(description = "")
  
    public Integer getMShipperId() {
    return mShipperId;
  }

  public void setMShipperId(Integer mShipperId) {
    this.mShipperId = mShipperId;
  }

  public OrderLine mWarehouseId(Integer mWarehouseId) {
    this.mWarehouseId = mWarehouseId;
    return this;
  }

  /**
   * Get mWarehouseId
   * @return mWarehouseId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getMWarehouseId() {
    return mWarehouseId;
  }

  public void setMWarehouseId(Integer mWarehouseId) {
    this.mWarehouseId = mWarehouseId;
  }

  public OrderLine orderMin(BigDecimal orderMin) {
    this.orderMin = orderMin;
    return this;
  }

  /**
   * Get orderMin
   * @return orderMin
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getOrderMin() {
    return orderMin;
  }

  public void setOrderMin(BigDecimal orderMin) {
    this.orderMin = orderMin;
  }

  public OrderLine orderPack(BigDecimal orderPack) {
    this.orderPack = orderPack;
    return this;
  }

  /**
   * Get orderPack
   * @return orderPack
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getOrderPack() {
    return orderPack;
  }

  public void setOrderPack(BigDecimal orderPack) {
    this.orderPack = orderPack;
  }

  public OrderLine priceactual(BigDecimal priceactual) {
    this.priceactual = priceactual;
    return this;
  }

  /**
   * Get priceactual
   * @return priceactual
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getPriceactual() {
    return priceactual;
  }

  public void setPriceactual(BigDecimal priceactual) {
    this.priceactual = priceactual;
  }

  public OrderLine pricediff(BigDecimal pricediff) {
    this.pricediff = pricediff;
    return this;
  }

  /**
   * Get pricediff
   * @return pricediff
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getPricediff() {
    return pricediff;
  }

  public void setPricediff(BigDecimal pricediff) {
    this.pricediff = pricediff;
  }

  public OrderLine priceentered(BigDecimal priceentered) {
    this.priceentered = priceentered;
    return this;
  }

  /**
   * Get priceentered
   * @return priceentered
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getPriceentered() {
    return priceentered;
  }

  public void setPriceentered(BigDecimal priceentered) {
    this.priceentered = priceentered;
  }

  public OrderLine pricelimit(BigDecimal pricelimit) {
    this.pricelimit = pricelimit;
    return this;
  }

  /**
   * Get pricelimit
   * @return pricelimit
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getPricelimit() {
    return pricelimit;
  }

  public void setPricelimit(BigDecimal pricelimit) {
    this.pricelimit = pricelimit;
  }

  public OrderLine pricelist(BigDecimal pricelist) {
    this.pricelist = pricelist;
    return this;
  }

  /**
   * Get pricelist
   * @return pricelist
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getPricelist() {
    return pricelist;
  }

  public void setPricelist(BigDecimal pricelist) {
    this.pricelist = pricelist;
  }

  public OrderLine pricereception(BigDecimal pricereception) {
    this.pricereception = pricereception;
    return this;
  }

  /**
   * Get pricereception
   * @return pricereception
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getPricereception() {
    return pricereception;
  }

  public void setPricereception(BigDecimal pricereception) {
    this.pricereception = pricereception;
  }

  public OrderLine processed(Boolean processed) {
    this.processed = processed;
    return this;
  }

  /**
   * Get processed
   * @return processed
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Boolean isProcessed() {
    return processed;
  }

  public void setProcessed(Boolean processed) {
    this.processed = processed;
  }

  public OrderLine qtydelivered(BigDecimal qtydelivered) {
    this.qtydelivered = qtydelivered;
    return this;
  }

  /**
   * Get qtydelivered
   * @return qtydelivered
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getQtydelivered() {
    return qtydelivered;
  }

  public void setQtydelivered(BigDecimal qtydelivered) {
    this.qtydelivered = qtydelivered;
  }

  public OrderLine qtydiff(BigDecimal qtydiff) {
    this.qtydiff = qtydiff;
    return this;
  }

  /**
   * Get qtydiff
   * @return qtydiff
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getQtydiff() {
    return qtydiff;
  }

  public void setQtydiff(BigDecimal qtydiff) {
    this.qtydiff = qtydiff;
  }

  public OrderLine qtyentered(BigDecimal qtyentered) {
    this.qtyentered = qtyentered;
    return this;
  }

  /**
   * Get qtyentered
   * @return qtyentered
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getQtyentered() {
    return qtyentered;
  }

  public void setQtyentered(BigDecimal qtyentered) {
    this.qtyentered = qtyentered;
  }

  public OrderLine qtyinvoiced(BigDecimal qtyinvoiced) {
    this.qtyinvoiced = qtyinvoiced;
    return this;
  }

  /**
   * Get qtyinvoiced
   * @return qtyinvoiced
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getQtyinvoiced() {
    return qtyinvoiced;
  }

  public void setQtyinvoiced(BigDecimal qtyinvoiced) {
    this.qtyinvoiced = qtyinvoiced;
  }

  public OrderLine qtyordered(BigDecimal qtyordered) {
    this.qtyordered = qtyordered;
    return this;
  }

  /**
   * Get qtyordered
   * @return qtyordered
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getQtyordered() {
    return qtyordered;
  }

  public void setQtyordered(BigDecimal qtyordered) {
    this.qtyordered = qtyordered;
  }

  public OrderLine qtyreception(BigDecimal qtyreception) {
    this.qtyreception = qtyreception;
    return this;
  }

  /**
   * Get qtyreception
   * @return qtyreception
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getQtyreception() {
    return qtyreception;
  }

  public void setQtyreception(BigDecimal qtyreception) {
    this.qtyreception = qtyreception;
  }

  public OrderLine qtyreserved(BigDecimal qtyreserved) {
    this.qtyreserved = qtyreserved;
    return this;
  }

  /**
   * Get qtyreserved
   * @return qtyreserved
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getQtyreserved() {
    return qtyreserved;
  }

  public void setQtyreserved(BigDecimal qtyreserved) {
    this.qtyreserved = qtyreserved;
  }

  public OrderLine qtyreturned(BigDecimal qtyreturned) {
    this.qtyreturned = qtyreturned;
    return this;
  }

  /**
   * Get qtyreturned
   * @return qtyreturned
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getQtyreturned() {
    return qtyreturned;
  }

  public void setQtyreturned(BigDecimal qtyreturned) {
    this.qtyreturned = qtyreturned;
  }

  public OrderLine qtytransferred(BigDecimal qtytransferred) {
    this.qtytransferred = qtytransferred;
    return this;
  }

  /**
   * Get qtytransferred
   * @return qtytransferred
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getQtytransferred() {
    return qtytransferred;
  }

  public void setQtytransferred(BigDecimal qtytransferred) {
    this.qtytransferred = qtytransferred;
  }

  public OrderLine receptionamt(BigDecimal receptionamt) {
    this.receptionamt = receptionamt;
    return this;
  }

  /**
   * Get receptionamt
   * @return receptionamt
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getReceptionamt() {
    return receptionamt;
  }

  public void setReceptionamt(BigDecimal receptionamt) {
    this.receptionamt = receptionamt;
  }

  public OrderLine refOrderlineId(Integer refOrderlineId) {
    this.refOrderlineId = refOrderlineId;
    return this;
  }

  /**
   * Get refOrderlineId
   * @return refOrderlineId
   **/
  @Schema(description = "")
  
    public Integer getRefOrderlineId() {
    return refOrderlineId;
  }

  public void setRefOrderlineId(Integer refOrderlineId) {
    this.refOrderlineId = refOrderlineId;
  }

  public OrderLine salesrepOrigId(Integer salesrepOrigId) {
    this.salesrepOrigId = salesrepOrigId;
    return this;
  }

  /**
   * Get salesrepOrigId
   * @return salesrepOrigId
   **/
  @Schema(description = "")
  
    public Integer getSalesrepOrigId() {
    return salesrepOrigId;
  }

  public void setSalesrepOrigId(Integer salesrepOrigId) {
    this.salesrepOrigId = salesrepOrigId;
  }

  public OrderLine updated(String updated) {
    this.updated = updated;
    return this;
  }

  /**
   * Get updated
   * @return updated
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  public OrderLine updatedby(Integer updatedby) {
    this.updatedby = updatedby;
    return this;
  }

  /**
   * Get updatedby
   * @return updatedby
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getUpdatedby() {
    return updatedby;
  }

  public void setUpdatedby(Integer updatedby) {
    this.updatedby = updatedby;
  }

  public OrderLine referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public OrderLine addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    OrderLine orderLine = (OrderLine) o;
    return Objects.equals(this.adClientId, orderLine.adClientId) &&
        Objects.equals(this.adOrgId, orderLine.adOrgId) &&
        Objects.equals(this.cBpartnerId, orderLine.cBpartnerId) &&
        Objects.equals(this.cBpartnerLocationId, orderLine.cBpartnerLocationId) &&
        Objects.equals(this.cChargeId, orderLine.cChargeId) &&
        Objects.equals(this.cCurrencyId, orderLine.cCurrencyId) &&
        Objects.equals(this.checkoutplace, orderLine.checkoutplace) &&
        Objects.equals(this.cOrderId, orderLine.cOrderId) &&
        Objects.equals(this.cOrderlineId, orderLine.cOrderlineId) &&
        Objects.equals(this.cProjectId, orderLine.cProjectId) &&
        Objects.equals(this.created, orderLine.created) &&
        Objects.equals(this.createdby, orderLine.createdby) &&
        Objects.equals(this.cTaxId, orderLine.cTaxId) &&
        Objects.equals(this.cUomId, orderLine.cUomId) &&
        Objects.equals(this.datedelivered, orderLine.datedelivered) &&
        Objects.equals(this.dateinvoiced, orderLine.dateinvoiced) &&
        Objects.equals(this.dateordered, orderLine.dateordered) &&
        Objects.equals(this.datepromised, orderLine.datepromised) &&
        Objects.equals(this.description, orderLine.description) &&
        Objects.equals(this.diffamt, orderLine.diffamt) &&
        Objects.equals(this.discount, orderLine.discount) &&
        Objects.equals(this.documentdiscountamt, orderLine.documentdiscountamt) &&
        Objects.equals(this.freightamt, orderLine.freightamt) &&
        Objects.equals(this.isactive, orderLine.isactive) &&
        Objects.equals(this.isdescription, orderLine.isdescription) &&
        Objects.equals(this.line, orderLine.line) &&
        Objects.equals(this.linebonusamt, orderLine.linebonusamt) &&
        Objects.equals(this.linediscountamt, orderLine.linediscountamt) &&
        Objects.equals(this.linenetamt, orderLine.linenetamt) &&
        Objects.equals(this.linetotalamt, orderLine.linetotalamt) &&
        Objects.equals(this.manualgeneraldiscountamt, orderLine.manualgeneraldiscountamt) &&
        Objects.equals(this.mAttributesetinstanceId, orderLine.mAttributesetinstanceId) &&
        Objects.equals(this.mProductId, orderLine.mProductId) &&
        Objects.equals(this.mShipperId, orderLine.mShipperId) &&
        Objects.equals(this.mWarehouseId, orderLine.mWarehouseId) &&
        Objects.equals(this.orderMin, orderLine.orderMin) &&
        Objects.equals(this.orderPack, orderLine.orderPack) &&
        Objects.equals(this.priceactual, orderLine.priceactual) &&
        Objects.equals(this.pricediff, orderLine.pricediff) &&
        Objects.equals(this.priceentered, orderLine.priceentered) &&
        Objects.equals(this.pricelimit, orderLine.pricelimit) &&
        Objects.equals(this.pricelist, orderLine.pricelist) &&
        Objects.equals(this.pricereception, orderLine.pricereception) &&
        Objects.equals(this.processed, orderLine.processed) &&
        Objects.equals(this.qtydelivered, orderLine.qtydelivered) &&
        Objects.equals(this.qtydiff, orderLine.qtydiff) &&
        Objects.equals(this.qtyentered, orderLine.qtyentered) &&
        Objects.equals(this.qtyinvoiced, orderLine.qtyinvoiced) &&
        Objects.equals(this.qtyordered, orderLine.qtyordered) &&
        Objects.equals(this.qtyreception, orderLine.qtyreception) &&
        Objects.equals(this.qtyreserved, orderLine.qtyreserved) &&
        Objects.equals(this.qtyreturned, orderLine.qtyreturned) &&
        Objects.equals(this.qtytransferred, orderLine.qtytransferred) &&
        Objects.equals(this.receptionamt, orderLine.receptionamt) &&
        Objects.equals(this.refOrderlineId, orderLine.refOrderlineId) &&
        Objects.equals(this.salesrepOrigId, orderLine.salesrepOrigId) &&
        Objects.equals(this.updated, orderLine.updated) &&
        Objects.equals(this.updatedby, orderLine.updatedby) &&
        Objects.equals(this.referencedvalues, orderLine.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, cBpartnerId, cBpartnerLocationId, cChargeId, cCurrencyId, checkoutplace, cOrderId, cOrderlineId, cProjectId, created, createdby, cTaxId, cUomId, datedelivered, dateinvoiced, dateordered, datepromised, description, diffamt, discount, documentdiscountamt, freightamt, isactive, isdescription, line, linebonusamt, linediscountamt, linenetamt, linetotalamt, manualgeneraldiscountamt, mAttributesetinstanceId, mProductId, mShipperId, mWarehouseId, orderMin, orderPack, priceactual, pricediff, priceentered, pricelimit, pricelist, pricereception, processed, qtydelivered, qtydiff, qtyentered, qtyinvoiced, qtyordered, qtyreception, qtyreserved, qtyreturned, qtytransferred, receptionamt, refOrderlineId, salesrepOrigId, updated, updatedby, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderLine {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cBpartnerId: ").append(toIndentedString(cBpartnerId)).append("\n");
    sb.append("    cBpartnerLocationId: ").append(toIndentedString(cBpartnerLocationId)).append("\n");
    sb.append("    cChargeId: ").append(toIndentedString(cChargeId)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    checkoutplace: ").append(toIndentedString(checkoutplace)).append("\n");
    sb.append("    cOrderId: ").append(toIndentedString(cOrderId)).append("\n");
    sb.append("    cOrderlineId: ").append(toIndentedString(cOrderlineId)).append("\n");
    sb.append("    cProjectId: ").append(toIndentedString(cProjectId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cTaxId: ").append(toIndentedString(cTaxId)).append("\n");
    sb.append("    cUomId: ").append(toIndentedString(cUomId)).append("\n");
    sb.append("    datedelivered: ").append(toIndentedString(datedelivered)).append("\n");
    sb.append("    dateinvoiced: ").append(toIndentedString(dateinvoiced)).append("\n");
    sb.append("    dateordered: ").append(toIndentedString(dateordered)).append("\n");
    sb.append("    datepromised: ").append(toIndentedString(datepromised)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    diffamt: ").append(toIndentedString(diffamt)).append("\n");
    sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
    sb.append("    documentdiscountamt: ").append(toIndentedString(documentdiscountamt)).append("\n");
    sb.append("    freightamt: ").append(toIndentedString(freightamt)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isdescription: ").append(toIndentedString(isdescription)).append("\n");
    sb.append("    line: ").append(toIndentedString(line)).append("\n");
    sb.append("    linebonusamt: ").append(toIndentedString(linebonusamt)).append("\n");
    sb.append("    linediscountamt: ").append(toIndentedString(linediscountamt)).append("\n");
    sb.append("    linenetamt: ").append(toIndentedString(linenetamt)).append("\n");
    sb.append("    linetotalamt: ").append(toIndentedString(linetotalamt)).append("\n");
    sb.append("    manualgeneraldiscountamt: ").append(toIndentedString(manualgeneraldiscountamt)).append("\n");
    sb.append("    mAttributesetinstanceId: ").append(toIndentedString(mAttributesetinstanceId)).append("\n");
    sb.append("    mProductId: ").append(toIndentedString(mProductId)).append("\n");
    sb.append("    mShipperId: ").append(toIndentedString(mShipperId)).append("\n");
    sb.append("    mWarehouseId: ").append(toIndentedString(mWarehouseId)).append("\n");
    sb.append("    orderMin: ").append(toIndentedString(orderMin)).append("\n");
    sb.append("    orderPack: ").append(toIndentedString(orderPack)).append("\n");
    sb.append("    priceactual: ").append(toIndentedString(priceactual)).append("\n");
    sb.append("    pricediff: ").append(toIndentedString(pricediff)).append("\n");
    sb.append("    priceentered: ").append(toIndentedString(priceentered)).append("\n");
    sb.append("    pricelimit: ").append(toIndentedString(pricelimit)).append("\n");
    sb.append("    pricelist: ").append(toIndentedString(pricelist)).append("\n");
    sb.append("    pricereception: ").append(toIndentedString(pricereception)).append("\n");
    sb.append("    processed: ").append(toIndentedString(processed)).append("\n");
    sb.append("    qtydelivered: ").append(toIndentedString(qtydelivered)).append("\n");
    sb.append("    qtydiff: ").append(toIndentedString(qtydiff)).append("\n");
    sb.append("    qtyentered: ").append(toIndentedString(qtyentered)).append("\n");
    sb.append("    qtyinvoiced: ").append(toIndentedString(qtyinvoiced)).append("\n");
    sb.append("    qtyordered: ").append(toIndentedString(qtyordered)).append("\n");
    sb.append("    qtyreception: ").append(toIndentedString(qtyreception)).append("\n");
    sb.append("    qtyreserved: ").append(toIndentedString(qtyreserved)).append("\n");
    sb.append("    qtyreturned: ").append(toIndentedString(qtyreturned)).append("\n");
    sb.append("    qtytransferred: ").append(toIndentedString(qtytransferred)).append("\n");
    sb.append("    receptionamt: ").append(toIndentedString(receptionamt)).append("\n");
    sb.append("    refOrderlineId: ").append(toIndentedString(refOrderlineId)).append("\n");
    sb.append("    salesrepOrigId: ").append(toIndentedString(salesrepOrigId)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
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
