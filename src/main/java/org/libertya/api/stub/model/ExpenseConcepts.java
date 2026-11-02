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
 * ExpenseConcepts
 */
@Validated



public class ExpenseConcepts   {
  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("c_cardsettlementconcepts_id")
  private Integer cCardsettlementconceptsId = null;

  @JsonProperty("c_creditcardsettlement_id")
  private Integer cCreditcardsettlementId = null;

  @JsonProperty("c_expenseconcepts_id")
  private Integer cExpenseconceptsId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

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

  public ExpenseConcepts adClientId(Integer adClientId) {
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

  public ExpenseConcepts adOrgId(Integer adOrgId) {
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

  public ExpenseConcepts amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Importe en una moneda definida
   * @return amount
   **/
  @Schema(description = "Importe en una moneda definida")
  
    @Valid
    public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public ExpenseConcepts cCardsettlementconceptsId(Integer cCardsettlementconceptsId) {
    this.cCardsettlementconceptsId = cCardsettlementconceptsId;
    return this;
  }

  /**
   *  
   * @return cCardsettlementconceptsId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCCardsettlementconceptsId() {
    return cCardsettlementconceptsId;
  }

  public void setCCardsettlementconceptsId(Integer cCardsettlementconceptsId) {
    this.cCardsettlementconceptsId = cCardsettlementconceptsId;
  }

  public ExpenseConcepts cCreditcardsettlementId(Integer cCreditcardsettlementId) {
    this.cCreditcardsettlementId = cCreditcardsettlementId;
    return this;
  }

  /**
   * Liquidaciones de Tarjetas de Crédito
   * @return cCreditcardsettlementId
   **/
  @Schema(required = true, description = "Liquidaciones de Tarjetas de Crédito")
      @NotNull

    public Integer getCCreditcardsettlementId() {
    return cCreditcardsettlementId;
  }

  public void setCCreditcardsettlementId(Integer cCreditcardsettlementId) {
    this.cCreditcardsettlementId = cCreditcardsettlementId;
  }

  public ExpenseConcepts cExpenseconceptsId(Integer cExpenseconceptsId) {
    this.cExpenseconceptsId = cExpenseconceptsId;
    return this;
  }

  /**
   *  
   * @return cExpenseconceptsId
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public Integer getCExpenseconceptsId() {
    return cExpenseconceptsId;
  }

  public void setCExpenseconceptsId(Integer cExpenseconceptsId) {
    this.cExpenseconceptsId = cExpenseconceptsId;
  }

  public ExpenseConcepts created(String created) {
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

  public ExpenseConcepts createdby(Integer createdby) {
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

  public ExpenseConcepts isactive(Boolean isactive) {
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

  public ExpenseConcepts updated(String updated) {
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

  public ExpenseConcepts updatedby(Integer updatedby) {
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

  public ExpenseConcepts additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public ExpenseConcepts addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public ExpenseConcepts referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public ExpenseConcepts addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    ExpenseConcepts expenseConcepts = (ExpenseConcepts) o;
    return Objects.equals(this.adClientId, expenseConcepts.adClientId) &&
        Objects.equals(this.adOrgId, expenseConcepts.adOrgId) &&
        Objects.equals(this.amount, expenseConcepts.amount) &&
        Objects.equals(this.cCardsettlementconceptsId, expenseConcepts.cCardsettlementconceptsId) &&
        Objects.equals(this.cCreditcardsettlementId, expenseConcepts.cCreditcardsettlementId) &&
        Objects.equals(this.cExpenseconceptsId, expenseConcepts.cExpenseconceptsId) &&
        Objects.equals(this.created, expenseConcepts.created) &&
        Objects.equals(this.createdby, expenseConcepts.createdby) &&
        Objects.equals(this.isactive, expenseConcepts.isactive) &&
        Objects.equals(this.updated, expenseConcepts.updated) &&
        Objects.equals(this.updatedby, expenseConcepts.updatedby) &&
        Objects.equals(this.additionalvalues, expenseConcepts.additionalvalues) &&
        Objects.equals(this.referencedvalues, expenseConcepts.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adClientId, adOrgId, amount, cCardsettlementconceptsId, cCreditcardsettlementId, cExpenseconceptsId, created, createdby, isactive, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExpenseConcepts {\n");
    
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    cCardsettlementconceptsId: ").append(toIndentedString(cCardsettlementconceptsId)).append("\n");
    sb.append("    cCreditcardsettlementId: ").append(toIndentedString(cCreditcardsettlementId)).append("\n");
    sb.append("    cExpenseconceptsId: ").append(toIndentedString(cExpenseconceptsId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
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
