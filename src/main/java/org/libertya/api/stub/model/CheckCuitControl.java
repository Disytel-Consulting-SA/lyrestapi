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
 * CheckCuitControl
 */
@Validated



public class CheckCuitControl   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_checkcuitcontrol_id")
  private Integer cCheckcuitcontrolId = null;

  @JsonProperty("checklimit")
  private BigDecimal checklimit = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("cuit")
  private String cuit = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("nombre")
  private String nombre = null;

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

  public CheckCuitControl adClientId(Integer adClientId) {
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

  public CheckCuitControl adOrgId(Integer adOrgId) {
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

  public CheckCuitControl cCheckcuitcontrolId(Integer cCheckcuitcontrolId) {
    this.cCheckcuitcontrolId = cCheckcuitcontrolId;
    return this;
  }

  /**
   *  
   * @return cCheckcuitcontrolId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCCheckcuitcontrolId() {
    return cCheckcuitcontrolId;
  }

  public void setCCheckcuitcontrolId(Integer cCheckcuitcontrolId) {
    this.cCheckcuitcontrolId = cCheckcuitcontrolId;
  }

  public CheckCuitControl checklimit(BigDecimal checklimit) {
    this.checklimit = checklimit;
    return this;
  }

  /**
   *  
   * @return checklimit
   **/
  @Schema(required = true, description = " ")
      @NotNull

    @Valid
    public BigDecimal getChecklimit() {
    return checklimit;
  }

  public void setChecklimit(BigDecimal checklimit) {
    this.checklimit = checklimit;
  }

  public CheckCuitControl created(String created) {
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

  public CheckCuitControl createdby(Integer createdby) {
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

  public CheckCuitControl cuit(String cuit) {
    this.cuit = cuit;
    return this;
  }

  /**
   *  
   * @return cuit
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public String getCuit() {
    return cuit;
  }

  public void setCuit(String cuit) {
    this.cuit = cuit;
  }

  public CheckCuitControl isactive(Boolean isactive) {
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

  public CheckCuitControl nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Nombre de Cliente
   * @return nombre
   **/
  @Schema(description = "Nombre de Cliente")
  
    public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public CheckCuitControl updated(String updated) {
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

  public CheckCuitControl updatedby(Integer updatedby) {
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

  public CheckCuitControl additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public CheckCuitControl addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public CheckCuitControl referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public CheckCuitControl addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    CheckCuitControl checkCuitControl = (CheckCuitControl) o;
    return Objects.equals(this.adClientId, checkCuitControl.adClientId) &&
        Objects.equals(this.adOrgId, checkCuitControl.adOrgId) &&
        Objects.equals(this.cCheckcuitcontrolId, checkCuitControl.cCheckcuitcontrolId) &&
        Objects.equals(this.checklimit, checkCuitControl.checklimit) &&
        Objects.equals(this.created, checkCuitControl.created) &&
        Objects.equals(this.createdby, checkCuitControl.createdby) &&
        Objects.equals(this.cuit, checkCuitControl.cuit) &&
        Objects.equals(this.isactive, checkCuitControl.isactive) &&
        Objects.equals(this.nombre, checkCuitControl.nombre) &&
        Objects.equals(this.updated, checkCuitControl.updated) &&
        Objects.equals(this.updatedby, checkCuitControl.updatedby) &&
        Objects.equals(this.additionalvalues, checkCuitControl.additionalvalues) &&
        Objects.equals(this.referencedvalues, checkCuitControl.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, cCheckcuitcontrolId, checklimit, created, createdby, cuit, isactive, nombre, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckCuitControl {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cCheckcuitcontrolId: ").append(toIndentedString(cCheckcuitcontrolId)).append("\n");
    sb.append("    checklimit: ").append(toIndentedString(checklimit)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    cuit: ").append(toIndentedString(cuit)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
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
