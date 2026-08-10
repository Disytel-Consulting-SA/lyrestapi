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
 * ElementValue
 */
@Validated



public class ElementValue   {
  @JsonProperty("accountsign")
  private String accountsign = null;

  @JsonProperty("accounttype")
  private String accounttype = null;

  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_element_id")
  private Integer cElementId = null;

  @JsonProperty("c_elementvalue_id")
  private Integer cElementvalueId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isadjustable")
  private Boolean isadjustable = null;

  @JsonProperty("isdoccontrolled")
  private Boolean isdoccontrolled = null;

  @JsonProperty("issummary")
  private Boolean issummary = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("postactual")
  private Boolean postactual = null;

  @JsonProperty("postbudget")
  private Boolean postbudget = null;

  @JsonProperty("postencumbrance")
  private Boolean postencumbrance = null;

  @JsonProperty("poststatistical")
  private Boolean poststatistical = null;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedby")
  private Integer updatedby = null;

  @JsonProperty("validfrom")
  private String validfrom = null;

  @JsonProperty("validto")
  private String validto = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("additionalvalues")
  @Valid
  private List<Propertiesmap> additionalvalues = null;

  @JsonProperty("referencedvalues")
  @Valid
  private List<Propertiesmap> referencedvalues = null;

  public ElementValue accountsign(String accountsign) {
    this.accountsign = accountsign;
    return this;
  }

  /**
   * Indica el signo natural de la cuenta ya sea Débito o Crédito
   * @return accountsign
   **/
  @Schema(required = true, description = "Indica el signo natural de la cuenta ya sea Débito o Crédito")
      @NotNull

    public String getAccountsign() {
    return accountsign;
  }

  public void setAccountsign(String accountsign) {
    this.accountsign = accountsign;
  }

  public ElementValue accounttype(String accounttype) {
    this.accounttype = accounttype;
    return this;
  }

  /**
   * Indica el tipo de cuenta
   * @return accounttype
   **/
  @Schema(required = true, description = "Indica el tipo de cuenta")
      @NotNull

    public String getAccounttype() {
    return accounttype;
  }

  public void setAccounttype(String accounttype) {
    this.accounttype = accounttype;
  }

  public ElementValue adClientId(Integer adClientId) {
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

  public ElementValue adOrgId(Integer adOrgId) {
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

  public ElementValue cElementId(Integer cElementId) {
    this.cElementId = cElementId;
    return this;
  }

  /**
   * Elemento de Cuenta
   * @return cElementId
   **/
  @Schema(required = true, description = "Elemento de Cuenta")
      @NotNull

    public Integer getCElementId() {
    return cElementId;
  }

  public void setCElementId(Integer cElementId) {
    this.cElementId = cElementId;
  }

  public ElementValue cElementvalueId(Integer cElementvalueId) {
    this.cElementvalueId = cElementvalueId;
    return this;
  }

  /**
   * Valor del Elemento
   * @return cElementvalueId
   **/
  @Schema(required = true, description = "Valor del Elemento")
      @NotNull

    public Integer getCElementvalueId() {
    return cElementvalueId;
  }

  public void setCElementvalueId(Integer cElementvalueId) {
    this.cElementvalueId = cElementvalueId;
  }

  public ElementValue created(String created) {
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

  public ElementValue createdby(Integer createdby) {
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

  public ElementValue description(String description) {
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

  public ElementValue isactive(Boolean isactive) {
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

  public ElementValue isadjustable(Boolean isadjustable) {
    this.isadjustable = isadjustable;
    return this;
  }

  /**
   * Ajustable por el índice de inflación
   * @return isadjustable
   **/
  @Schema(required = true, description = "Ajustable por el índice de inflación")
      @NotNull

    public Boolean isIsadjustable() {
    return isadjustable;
  }

  public void setIsadjustable(Boolean isadjustable) {
    this.isadjustable = isadjustable;
  }

  public ElementValue isdoccontrolled(Boolean isdoccontrolled) {
    this.isdoccontrolled = isdoccontrolled;
    return this;
  }

  /**
   * Control de cuenta - Si una cuenta es controlada por un documento
   * @return isdoccontrolled
   **/
  @Schema(description = "Control de cuenta - Si una cuenta es controlada por un documento")
  
    public Boolean isIsdoccontrolled() {
    return isdoccontrolled;
  }

  public void setIsdoccontrolled(Boolean isdoccontrolled) {
    this.isdoccontrolled = isdoccontrolled;
  }

  public ElementValue issummary(Boolean issummary) {
    this.issummary = issummary;
    return this;
  }

  /**
   * Carpeta
   * @return issummary
   **/
  @Schema(required = true, description = "Carpeta")
      @NotNull

    public Boolean isIssummary() {
    return issummary;
  }

  public void setIssummary(Boolean issummary) {
    this.issummary = issummary;
  }

  public ElementValue name(String name) {
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

  public ElementValue postactual(Boolean postactual) {
    this.postactual = postactual;
    return this;
  }

  /**
   * Valores reales pueden ser aplicados
   * @return postactual
   **/
  @Schema(required = true, description = "Valores reales pueden ser aplicados")
      @NotNull

    public Boolean isPostactual() {
    return postactual;
  }

  public void setPostactual(Boolean postactual) {
    this.postactual = postactual;
  }

  public ElementValue postbudget(Boolean postbudget) {
    this.postbudget = postbudget;
    return this;
  }

  /**
   * Valores del presupuesto pueden ser aplicados
   * @return postbudget
   **/
  @Schema(required = true, description = "Valores del presupuesto pueden ser aplicados")
      @NotNull

    public Boolean isPostbudget() {
    return postbudget;
  }

  public void setPostbudget(Boolean postbudget) {
    this.postbudget = postbudget;
  }

  public ElementValue postencumbrance(Boolean postencumbrance) {
    this.postencumbrance = postencumbrance;
    return this;
  }

  /**
   * Registro de gravámenes a esta cuenta
   * @return postencumbrance
   **/
  @Schema(required = true, description = "Registro de gravámenes a esta cuenta")
      @NotNull

    public Boolean isPostencumbrance() {
    return postencumbrance;
  }

  public void setPostencumbrance(Boolean postencumbrance) {
    this.postencumbrance = postencumbrance;
  }

  public ElementValue poststatistical(Boolean poststatistical) {
    this.poststatistical = poststatistical;
    return this;
  }

  /**
   * Registro de cantidades estadísticas a esta cuenta
   * @return poststatistical
   **/
  @Schema(required = true, description = "Registro de cantidades estadísticas a esta cuenta")
      @NotNull

    public Boolean isPoststatistical() {
    return poststatistical;
  }

  public void setPoststatistical(Boolean poststatistical) {
    this.poststatistical = poststatistical;
  }

  public ElementValue updated(String updated) {
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

  public ElementValue updatedby(Integer updatedby) {
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

  public ElementValue validfrom(String validfrom) {
    this.validfrom = validfrom;
    return this;
  }

  /**
   * Válido desde; incluyendo esta fecha (primer día)
   * @return validfrom
   **/
  @Schema(description = "Válido desde; incluyendo esta fecha (primer día)")
  
    public String getValidfrom() {
    return validfrom;
  }

  public void setValidfrom(String validfrom) {
    this.validfrom = validfrom;
  }

  public ElementValue validto(String validto) {
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

  public ElementValue value(String value) {
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

  public ElementValue additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public ElementValue addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public ElementValue referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public ElementValue addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    ElementValue elementValue = (ElementValue) o;
    return Objects.equals(this.accountsign, elementValue.accountsign) &&
        Objects.equals(this.accounttype, elementValue.accounttype) &&
        Objects.equals(this.adClientId, elementValue.adClientId) &&
        Objects.equals(this.adOrgId, elementValue.adOrgId) &&
        Objects.equals(this.cElementId, elementValue.cElementId) &&
        Objects.equals(this.cElementvalueId, elementValue.cElementvalueId) &&
        Objects.equals(this.created, elementValue.created) &&
        Objects.equals(this.createdby, elementValue.createdby) &&
        Objects.equals(this.description, elementValue.description) &&
        Objects.equals(this.isactive, elementValue.isactive) &&
        Objects.equals(this.isadjustable, elementValue.isadjustable) &&
        Objects.equals(this.isdoccontrolled, elementValue.isdoccontrolled) &&
        Objects.equals(this.issummary, elementValue.issummary) &&
        Objects.equals(this.name, elementValue.name) &&
        Objects.equals(this.postactual, elementValue.postactual) &&
        Objects.equals(this.postbudget, elementValue.postbudget) &&
        Objects.equals(this.postencumbrance, elementValue.postencumbrance) &&
        Objects.equals(this.poststatistical, elementValue.poststatistical) &&
        Objects.equals(this.updated, elementValue.updated) &&
        Objects.equals(this.updatedby, elementValue.updatedby) &&
        Objects.equals(this.validfrom, elementValue.validfrom) &&
        Objects.equals(this.validto, elementValue.validto) &&
        Objects.equals(this.value, elementValue.value) &&
        Objects.equals(this.additionalvalues, elementValue.additionalvalues) &&
        Objects.equals(this.referencedvalues, elementValue.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountsign, accounttype, adClientId, adOrgId, cElementId, cElementvalueId, created, createdby, description, isactive, isadjustable, isdoccontrolled, issummary, name, postactual, postbudget, postencumbrance, poststatistical, updated, updatedby, validfrom, validto, value, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ElementValue {\n");
    
    sb.append("    accountsign: ").append(toIndentedString(accountsign)).append("\n");
    sb.append("    accounttype: ").append(toIndentedString(accounttype)).append("\n");
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cElementId: ").append(toIndentedString(cElementId)).append("\n");
    sb.append("    cElementvalueId: ").append(toIndentedString(cElementvalueId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isadjustable: ").append(toIndentedString(isadjustable)).append("\n");
    sb.append("    isdoccontrolled: ").append(toIndentedString(isdoccontrolled)).append("\n");
    sb.append("    issummary: ").append(toIndentedString(issummary)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    postactual: ").append(toIndentedString(postactual)).append("\n");
    sb.append("    postbudget: ").append(toIndentedString(postbudget)).append("\n");
    sb.append("    postencumbrance: ").append(toIndentedString(postencumbrance)).append("\n");
    sb.append("    poststatistical: ").append(toIndentedString(poststatistical)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedby: ").append(toIndentedString(updatedby)).append("\n");
    sb.append("    validfrom: ").append(toIndentedString(validfrom)).append("\n");
    sb.append("    validto: ").append(toIndentedString(validto)).append("\n");
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
