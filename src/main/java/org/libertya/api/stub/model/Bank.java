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
 * Bank
 */
@Validated



public class Bank   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("c_bank_id")
  private Integer cBankId = null;

  @JsonProperty("c_location_id")
  private Integer cLocationId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isownbank")
  private Boolean isownbank = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("routingno")
  private String routingno = null;

  @JsonProperty("swiftcode")
  private String swiftcode = null;

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

  public Bank adClientId(Integer adClientId) {
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

  public Bank adComponentobjectuid(String adComponentobjectuid) {
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

  public Bank adOrgId(Integer adOrgId) {
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

  public Bank cBankId(Integer cBankId) {
    this.cBankId = cBankId;
    return this;
  }

  /**
   * Banco
   * @return cBankId
   **/
  @Schema(required = true, description = "Banco")
      @NotNull

    public Integer getCBankId() {
    return cBankId;
  }

  public void setCBankId(Integer cBankId) {
    this.cBankId = cBankId;
  }

  public Bank cLocationId(Integer cLocationId) {
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

  public Bank created(String created) {
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

  public Bank createdby(Integer createdby) {
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

  public Bank description(String description) {
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

  public Bank isactive(Boolean isactive) {
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

  public Bank isownbank(Boolean isownbank) {
    this.isownbank = isownbank;
    return this;
  }

  /**
   * Banco para esta organización
   * @return isownbank
   **/
  @Schema(required = true, description = "Banco para esta organización")
      @NotNull

    public Boolean isIsownbank() {
    return isownbank;
  }

  public void setIsownbank(Boolean isownbank) {
    this.isownbank = isownbank;
  }

  public Bank name(String name) {
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

  public Bank routingno(String routingno) {
    this.routingno = routingno;
    return this;
  }

  /**
   * Número de sucursal bancaria
   * @return routingno
   **/
  @Schema(required = true, description = "Número de sucursal bancaria")
      @NotNull

    public String getRoutingno() {
    return routingno;
  }

  public void setRoutingno(String routingno) {
    this.routingno = routingno;
  }

  public Bank swiftcode(String swiftcode) {
    this.swiftcode = swiftcode;
    return this;
  }

  /**
   * Código Swift (Society of Worldwide Interbank Financial Telecommunications)
   * @return swiftcode
   **/
  @Schema(description = "Código Swift (Society of Worldwide Interbank Financial Telecommunications)")
  
    public String getSwiftcode() {
    return swiftcode;
  }

  public void setSwiftcode(String swiftcode) {
    this.swiftcode = swiftcode;
  }

  public Bank updated(String updated) {
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

  public Bank updatedby(Integer updatedby) {
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

  public Bank additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public Bank addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public Bank referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public Bank addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    Bank bank = (Bank) o;
    return Objects.equals(this.adClientId, bank.adClientId) &&
        Objects.equals(this.adComponentobjectuid, bank.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, bank.adOrgId) &&
        Objects.equals(this.cBankId, bank.cBankId) &&
        Objects.equals(this.cLocationId, bank.cLocationId) &&
        Objects.equals(this.created, bank.created) &&
        Objects.equals(this.createdby, bank.createdby) &&
        Objects.equals(this.description, bank.description) &&
        Objects.equals(this.isactive, bank.isactive) &&
        Objects.equals(this.isownbank, bank.isownbank) &&
        Objects.equals(this.name, bank.name) &&
        Objects.equals(this.routingno, bank.routingno) &&
        Objects.equals(this.swiftcode, bank.swiftcode) &&
        Objects.equals(this.updated, bank.updated) &&
        Objects.equals(this.updatedby, bank.updatedby) &&
        Objects.equals(this.additionalvalues, bank.additionalvalues) &&
        Objects.equals(this.referencedvalues, bank.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adComponentobjectuid, adOrgId, cBankId, cLocationId, created, createdby, description, isactive, isownbank, name, routingno, swiftcode, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Bank {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    cBankId: ").append(toIndentedString(cBankId)).append("\n");
    sb.append("    cLocationId: ").append(toIndentedString(cLocationId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isownbank: ").append(toIndentedString(isownbank)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    routingno: ").append(toIndentedString(routingno)).append("\n");
    sb.append("    swiftcode: ").append(toIndentedString(swiftcode)).append("\n");
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
