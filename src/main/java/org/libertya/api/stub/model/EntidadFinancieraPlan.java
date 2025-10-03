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
 * EntidadFinancieraPlan
 */
@Validated



public class EntidadFinancieraPlan   {
  @JsonProperty("accreditationdays")
  private Integer accreditationdays = null;

  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("cuotascobro")
  private Integer cuotascobro = null;

  @JsonProperty("cuotaspago")
  private Integer cuotaspago = null;

  @JsonProperty("datefrom")
  private String datefrom = null;

  @JsonProperty("dateto")
  private String dateto = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("m_discountschema_id")
  private Integer mDiscountschemaId = null;

  @JsonProperty("m_entidadfinanciera_id")
  private Integer mEntidadfinancieraId = null;

  @JsonProperty("m_entidadfinancieraplan_id")
  private Integer mEntidadfinancieraplanId = null;

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

  public EntidadFinancieraPlan accreditationdays(Integer accreditationdays) {
    this.accreditationdays = accreditationdays;
    return this;
  }

  /**
   * Cantidad de días luego de la venta en que la Entidad Financiera realiza el pago del cupón a la Compañía
   * @return accreditationdays
   **/
  @Schema(required = true, description = "Cantidad de días luego de la venta en que la Entidad Financiera realiza el pago del cupón a la Compañía")
      @NotNull

    public Integer getAccreditationdays() {
    return accreditationdays;
  }

  public void setAccreditationdays(Integer accreditationdays) {
    this.accreditationdays = accreditationdays;
  }

  public EntidadFinancieraPlan adClientId(Integer adClientId) {
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

  public EntidadFinancieraPlan adOrgId(Integer adOrgId) {
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

  public EntidadFinancieraPlan created(String created) {
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

  public EntidadFinancieraPlan createdby(Integer createdby) {
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

  public EntidadFinancieraPlan cuotascobro(Integer cuotascobro) {
    this.cuotascobro = cuotascobro;
    return this;
  }

  /**
   * Cantidad de Cuotas en las que la Entidad Financiera Liquida el cupón a la Compañía.
   * @return cuotascobro
   **/
  @Schema(required = true, description = "Cantidad de Cuotas en las que la Entidad Financiera Liquida el cupón a la Compañía.")
      @NotNull

    public Integer getCuotascobro() {
    return cuotascobro;
  }

  public void setCuotascobro(Integer cuotascobro) {
    this.cuotascobro = cuotascobro;
  }

  public EntidadFinancieraPlan cuotaspago(Integer cuotaspago) {
    this.cuotaspago = cuotaspago;
    return this;
  }

  /**
   * Cantidad de Cuotas en las que el cliente quiere pagar su Compra.
   * @return cuotaspago
   **/
  @Schema(required = true, description = "Cantidad de Cuotas en las que el cliente quiere pagar su Compra.")
      @NotNull

    public Integer getCuotaspago() {
    return cuotaspago;
  }

  public void setCuotaspago(Integer cuotaspago) {
    this.cuotaspago = cuotaspago;
  }

  public EntidadFinancieraPlan datefrom(String datefrom) {
    this.datefrom = datefrom;
    return this;
  }

  /**
   * Fecha de inicio para un rango
   * @return datefrom
   **/
  @Schema(required = true, description = "Fecha de inicio para un rango")
      @NotNull

    public String getDatefrom() {
    return datefrom;
  }

  public void setDatefrom(String datefrom) {
    this.datefrom = datefrom;
  }

  public EntidadFinancieraPlan dateto(String dateto) {
    this.dateto = dateto;
    return this;
  }

  /**
   * Fecha final de un rango (inclusive)
   * @return dateto
   **/
  @Schema(required = true, description = "Fecha final de un rango (inclusive)")
      @NotNull

    public String getDateto() {
    return dateto;
  }

  public void setDateto(String dateto) {
    this.dateto = dateto;
  }

  public EntidadFinancieraPlan description(String description) {
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

  public EntidadFinancieraPlan isactive(Boolean isactive) {
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

  public EntidadFinancieraPlan mDiscountschemaId(Integer mDiscountschemaId) {
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

  public EntidadFinancieraPlan mEntidadfinancieraId(Integer mEntidadfinancieraId) {
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

  public EntidadFinancieraPlan mEntidadfinancieraplanId(Integer mEntidadfinancieraplanId) {
    this.mEntidadfinancieraplanId = mEntidadfinancieraplanId;
    return this;
  }

  /**
   * Plan de Entidad Financiera
   * @return mEntidadfinancieraplanId
   **/
  @Schema(required = true, description = "Plan de Entidad Financiera")
      @NotNull

    public Integer getMEntidadfinancieraplanId() {
    return mEntidadfinancieraplanId;
  }

  public void setMEntidadfinancieraplanId(Integer mEntidadfinancieraplanId) {
    this.mEntidadfinancieraplanId = mEntidadfinancieraplanId;
  }

  public EntidadFinancieraPlan name(String name) {
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

  public EntidadFinancieraPlan updated(String updated) {
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

  public EntidadFinancieraPlan updatedby(Integer updatedby) {
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

  public EntidadFinancieraPlan value(String value) {
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

  public EntidadFinancieraPlan additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public EntidadFinancieraPlan addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public EntidadFinancieraPlan referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public EntidadFinancieraPlan addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    EntidadFinancieraPlan entidadFinancieraPlan = (EntidadFinancieraPlan) o;
    return Objects.equals(this.accreditationdays, entidadFinancieraPlan.accreditationdays) &&
        Objects.equals(this.adClientId, entidadFinancieraPlan.adClientId) &&
        Objects.equals(this.adOrgId, entidadFinancieraPlan.adOrgId) &&
        Objects.equals(this.created, entidadFinancieraPlan.created) &&
        Objects.equals(this.createdby, entidadFinancieraPlan.createdby) &&
        Objects.equals(this.cuotascobro, entidadFinancieraPlan.cuotascobro) &&
        Objects.equals(this.cuotaspago, entidadFinancieraPlan.cuotaspago) &&
        Objects.equals(this.datefrom, entidadFinancieraPlan.datefrom) &&
        Objects.equals(this.dateto, entidadFinancieraPlan.dateto) &&
        Objects.equals(this.description, entidadFinancieraPlan.description) &&
        Objects.equals(this.isactive, entidadFinancieraPlan.isactive) &&
        Objects.equals(this.mDiscountschemaId, entidadFinancieraPlan.mDiscountschemaId) &&
        Objects.equals(this.mEntidadfinancieraId, entidadFinancieraPlan.mEntidadfinancieraId) &&
        Objects.equals(this.mEntidadfinancieraplanId, entidadFinancieraPlan.mEntidadfinancieraplanId) &&
        Objects.equals(this.name, entidadFinancieraPlan.name) &&
        Objects.equals(this.updated, entidadFinancieraPlan.updated) &&
        Objects.equals(this.updatedby, entidadFinancieraPlan.updatedby) &&
        Objects.equals(this.value, entidadFinancieraPlan.value) &&
        Objects.equals(this.additionalvalues, entidadFinancieraPlan.additionalvalues) &&
        Objects.equals(this.referencedvalues, entidadFinancieraPlan.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accreditationdays, adClientId, adOrgId, created, createdby, cuotascobro, cuotaspago, datefrom, dateto, description, isactive, mDiscountschemaId, mEntidadfinancieraId, mEntidadfinancieraplanId, name, updated, updatedby, value, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntidadFinancieraPlan {\n");
    
    sb.append("    accreditationdays: ").append(toIndentedString(accreditationdays)).append("\n");
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cuotascobro: ").append(toIndentedString(cuotascobro)).append("\n");
    sb.append("    cuotaspago: ").append(toIndentedString(cuotaspago)).append("\n");
    sb.append("    datefrom: ").append(toIndentedString(datefrom)).append("\n");
    sb.append("    dateto: ").append(toIndentedString(dateto)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    mDiscountschemaId: ").append(toIndentedString(mDiscountschemaId)).append("\n");
    sb.append("    mEntidadfinancieraId: ").append(toIndentedString(mEntidadfinancieraId)).append("\n");
    sb.append("    mEntidadfinancieraplanId: ").append(toIndentedString(mEntidadfinancieraplanId)).append("\n");
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
