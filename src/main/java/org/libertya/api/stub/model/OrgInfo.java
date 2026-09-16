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
 * OrgInfo
 */
@Validated



public class OrgInfo   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("allowautomaticallocation")
  private Boolean allowautomaticallocation = null;

  @JsonProperty("authorizations")
  private Boolean authorizations = null;

  @JsonProperty("checkcuitcontrol")
  private Boolean checkcuitcontrol = null;

  @JsonProperty("c_location_id")
  private Integer cLocationId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("cuit")
  private String cuit = null;

  @JsonProperty("duns")
  private String duns = null;

  @JsonProperty("initialchecklimit")
  private BigDecimal initialchecklimit = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("m_warehouse_id")
  private Integer mWarehouseId = null;

  @JsonProperty("nombrecomercio")
  private String nombrecomercio = null;

  @JsonProperty("overdueinvoicescharge")
  private BigDecimal overdueinvoicescharge = null;

  @JsonProperty("parent_org_id")
  private Integer parentOrgId = null;

  @JsonProperty("shipmentpermitfe")
  private Boolean shipmentpermitfe = null;

  @JsonProperty("taxid")
  private String taxid = null;

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

  public OrgInfo adClientId(Integer adClientId) {
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

  public OrgInfo adOrgId(Integer adOrgId) {
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

  public OrgInfo allowautomaticallocation(Boolean allowautomaticallocation) {
    this.allowautomaticallocation = allowautomaticallocation;
    return this;
  }

  /**
   * Esta marca permite incluir a esta organización en la generación automática de imputaciones de documentos
   * @return allowautomaticallocation
   **/
  @Schema(required = true, description = "Esta marca permite incluir a esta organización en la generación automática de imputaciones de documentos")
      @NotNull

    public Boolean isAllowautomaticallocation() {
    return allowautomaticallocation;
  }

  public void setAllowautomaticallocation(Boolean allowautomaticallocation) {
    this.allowautomaticallocation = allowautomaticallocation;
  }

  public OrgInfo authorizations(Boolean authorizations) {
    this.authorizations = authorizations;
    return this;
  }

  /**
   *  
   * @return authorizations
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isAuthorizations() {
    return authorizations;
  }

  public void setAuthorizations(Boolean authorizations) {
    this.authorizations = authorizations;
  }

  public OrgInfo checkcuitcontrol(Boolean checkcuitcontrol) {
    this.checkcuitcontrol = checkcuitcontrol;
    return this;
  }

  /**
   * Control de CUIT de Cheques activado
   * @return checkcuitcontrol
   **/
  @Schema(required = true, description = "Control de CUIT de Cheques activado")
      @NotNull

    public Boolean isCheckcuitcontrol() {
    return checkcuitcontrol;
  }

  public void setCheckcuitcontrol(Boolean checkcuitcontrol) {
    this.checkcuitcontrol = checkcuitcontrol;
  }

  public OrgInfo cLocationId(Integer cLocationId) {
    this.cLocationId = cLocationId;
    return this;
  }

  /**
   * Ubicación o Dirección
   * @return cLocationId
   **/
  @Schema(description = "Ubicación o Dirección")
  
    public Integer getCLocationId() {
    return cLocationId;
  }

  public void setCLocationId(Integer cLocationId) {
    this.cLocationId = cLocationId;
  }

  public OrgInfo created(String created) {
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

  public OrgInfo createdby(Integer createdby) {
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

  public OrgInfo cuit(String cuit) {
    this.cuit = cuit;
    return this;
  }

  /**
   *  
   * @return cuit
   **/
  @Schema(description = " ")
  
    public String getCuit() {
    return cuit;
  }

  public void setCuit(String cuit) {
    this.cuit = cuit;
  }

  public OrgInfo duns(String duns) {
    this.duns = duns;
    return this;
  }

  /**
   * Introduzca el CIF/NIF DE LA EMPRESA O PARTICULAR
   * @return duns
   **/
  @Schema(required = true, description = "Introduzca el CIF/NIF DE LA EMPRESA O PARTICULAR")
      @NotNull

    public String getDuns() {
    return duns;
  }

  public void setDuns(String duns) {
    this.duns = duns;
  }

  public OrgInfo initialchecklimit(BigDecimal initialchecklimit) {
    this.initialchecklimit = initialchecklimit;
    return this;
  }

  /**
   * Monto límite inicial por CUIT para operar con cheques
   * @return initialchecklimit
   **/
  @Schema(required = true, description = "Monto límite inicial por CUIT para operar con cheques")
      @NotNull

    @Valid
    public BigDecimal getInitialchecklimit() {
    return initialchecklimit;
  }

  public void setInitialchecklimit(BigDecimal initialchecklimit) {
    this.initialchecklimit = initialchecklimit;
  }

  public OrgInfo isactive(Boolean isactive) {
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

  public OrgInfo mWarehouseId(Integer mWarehouseId) {
    this.mWarehouseId = mWarehouseId;
    return this;
  }

  /**
   * Almacén
   * @return mWarehouseId
   **/
  @Schema(description = "Almacén")
  
    public Integer getMWarehouseId() {
    return mWarehouseId;
  }

  public void setMWarehouseId(Integer mWarehouseId) {
    this.mWarehouseId = mWarehouseId;
  }

  public OrgInfo nombrecomercio(String nombrecomercio) {
    this.nombrecomercio = nombrecomercio;
    return this;
  }

  /**
   *  
   * @return nombrecomercio
   **/
  @Schema(description = " ")
  
    public String getNombrecomercio() {
    return nombrecomercio;
  }

  public void setNombrecomercio(String nombrecomercio) {
    this.nombrecomercio = nombrecomercio;
  }

  public OrgInfo overdueinvoicescharge(BigDecimal overdueinvoicescharge) {
    this.overdueinvoicescharge = overdueinvoicescharge;
    return this;
  }

  /**
   * Importe del Cargo por cobro de facturas vencidas en Recibos de Cliente
   * @return overdueinvoicescharge
   **/
  @Schema(required = true, description = "Importe del Cargo por cobro de facturas vencidas en Recibos de Cliente")
      @NotNull

    @Valid
    public BigDecimal getOverdueinvoicescharge() {
    return overdueinvoicescharge;
  }

  public void setOverdueinvoicescharge(BigDecimal overdueinvoicescharge) {
    this.overdueinvoicescharge = overdueinvoicescharge;
  }

  public OrgInfo parentOrgId(Integer parentOrgId) {
    this.parentOrgId = parentOrgId;
    return this;
  }

  /**
   * Organización Superior
   * @return parentOrgId
   **/
  @Schema(description = "Organización Superior")
  
    public Integer getParentOrgId() {
    return parentOrgId;
  }

  public void setParentOrgId(Integer parentOrgId) {
    this.parentOrgId = parentOrgId;
  }

  public OrgInfo shipmentpermitfe(Boolean shipmentpermitfe) {
    this.shipmentpermitfe = shipmentpermitfe;
    return this;
  }

  /**
   *  
   * @return shipmentpermitfe
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Boolean isShipmentpermitfe() {
    return shipmentpermitfe;
  }

  public void setShipmentpermitfe(Boolean shipmentpermitfe) {
    this.shipmentpermitfe = shipmentpermitfe;
  }

  public OrgInfo taxid(String taxid) {
    this.taxid = taxid;
    return this;
  }

  /**
   * Codigo único de Identificacion Tributaria / Documento Nacional de Identidad
   * @return taxid
   **/
  @Schema(required = true, description = "Codigo único de Identificacion Tributaria / Documento Nacional de Identidad")
      @NotNull

    public String getTaxid() {
    return taxid;
  }

  public void setTaxid(String taxid) {
    this.taxid = taxid;
  }

  public OrgInfo updated(String updated) {
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

  public OrgInfo updatedby(Integer updatedby) {
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

  public OrgInfo additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public OrgInfo addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public OrgInfo referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public OrgInfo addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    OrgInfo orgInfo = (OrgInfo) o;
    return Objects.equals(this.adClientId, orgInfo.adClientId) &&
        Objects.equals(this.adOrgId, orgInfo.adOrgId) &&
        Objects.equals(this.allowautomaticallocation, orgInfo.allowautomaticallocation) &&
        Objects.equals(this.authorizations, orgInfo.authorizations) &&
        Objects.equals(this.checkcuitcontrol, orgInfo.checkcuitcontrol) &&
        Objects.equals(this.cLocationId, orgInfo.cLocationId) &&
        Objects.equals(this.created, orgInfo.created) &&
        Objects.equals(this.createdby, orgInfo.createdby) &&
        Objects.equals(this.cuit, orgInfo.cuit) &&
        Objects.equals(this.duns, orgInfo.duns) &&
        Objects.equals(this.initialchecklimit, orgInfo.initialchecklimit) &&
        Objects.equals(this.isactive, orgInfo.isactive) &&
        Objects.equals(this.mWarehouseId, orgInfo.mWarehouseId) &&
        Objects.equals(this.nombrecomercio, orgInfo.nombrecomercio) &&
        Objects.equals(this.overdueinvoicescharge, orgInfo.overdueinvoicescharge) &&
        Objects.equals(this.parentOrgId, orgInfo.parentOrgId) &&
        Objects.equals(this.shipmentpermitfe, orgInfo.shipmentpermitfe) &&
        Objects.equals(this.taxid, orgInfo.taxid) &&
        Objects.equals(this.updated, orgInfo.updated) &&
        Objects.equals(this.updatedby, orgInfo.updatedby) &&
        Objects.equals(this.additionalvalues, orgInfo.additionalvalues) &&
        Objects.equals(this.referencedvalues, orgInfo.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, allowautomaticallocation, authorizations, checkcuitcontrol, cLocationId, created, createdby, cuit, duns, initialchecklimit, isactive, mWarehouseId, nombrecomercio, overdueinvoicescharge, parentOrgId, shipmentpermitfe, taxid, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrgInfo {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    allowautomaticallocation: ").append(toIndentedString(allowautomaticallocation)).append("\n");
    sb.append("    authorizations: ").append(toIndentedString(authorizations)).append("\n");
    sb.append("    checkcuitcontrol: ").append(toIndentedString(checkcuitcontrol)).append("\n");
    sb.append("    cLocationId: ").append(toIndentedString(cLocationId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cuit: ").append(toIndentedString(cuit)).append("\n");
    sb.append("    duns: ").append(toIndentedString(duns)).append("\n");
    sb.append("    initialchecklimit: ").append(toIndentedString(initialchecklimit)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    mWarehouseId: ").append(toIndentedString(mWarehouseId)).append("\n");
    sb.append("    nombrecomercio: ").append(toIndentedString(nombrecomercio)).append("\n");
    sb.append("    overdueinvoicescharge: ").append(toIndentedString(overdueinvoicescharge)).append("\n");
    sb.append("    parentOrgId: ").append(toIndentedString(parentOrgId)).append("\n");
    sb.append("    shipmentpermitfe: ").append(toIndentedString(shipmentpermitfe)).append("\n");
    sb.append("    taxid: ").append(toIndentedString(taxid)).append("\n");
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
