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
 * BankAccount
 */
@Validated



public class BankAccount   {
  @JsonProperty("accountno")
  private String accountno = null;

  @JsonProperty("ad_client_id")
  private Integer adClientId = null;

  @JsonProperty("ad_componentobjectuid")
  private String adComponentobjectuid = null;

  @JsonProperty("ad_org_id")
  private Integer adOrgId = null;

  @JsonProperty("bankaccounttype")
  private String bankaccounttype = null;

  @JsonProperty("bban")
  private String bban = null;

  @JsonProperty("c_bankaccount_id")
  private Integer cBankaccountId = null;

  @JsonProperty("c_bankaccount_location_id")
  private Integer cBankaccountLocationId = null;

  @JsonProperty("c_bank_id")
  private Integer cBankId = null;

  @JsonProperty("cc")
  private String cc = null;

  @JsonProperty("c_currency_id")
  private Integer cCurrencyId = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("createdby")
  private Integer createdby = null;

  @JsonProperty("creditlimit")
  private BigDecimal creditlimit = null;

  @JsonProperty("currentbalance")
  private BigDecimal currentbalance = null;

  @JsonProperty("dc")
  private String dc = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("electronicpaymentsaccount")
  private Boolean electronicpaymentsaccount = null;

  @JsonProperty("iban")
  private String iban = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("ischequesencartera")
  private Boolean ischequesencartera = null;

  @JsonProperty("isdefault")
  private Boolean isdefault = null;

  @JsonProperty("oficina")
  private String oficina = null;

  @JsonProperty("sucursal")
  private String sucursal = null;

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

  public BankAccount accountno(String accountno) {
    this.accountno = accountno;
    return this;
  }

  /**
   * Número de cuenta
   * @return accountno
   **/
  @Schema(required = true, description = "Número de cuenta")
      @NotNull

    public String getAccountno() {
    return accountno;
  }

  public void setAccountno(String accountno) {
    this.accountno = accountno;
  }

  public BankAccount adClientId(Integer adClientId) {
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

  public BankAccount adComponentobjectuid(String adComponentobjectuid) {
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

  public BankAccount adOrgId(Integer adOrgId) {
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

  public BankAccount bankaccounttype(String bankaccounttype) {
    this.bankaccounttype = bankaccounttype;
    return this;
  }

  /**
   * Tipo de cuenta Bancaria
   * @return bankaccounttype
   **/
  @Schema(required = true, description = "Tipo de cuenta Bancaria")
      @NotNull

    public String getBankaccounttype() {
    return bankaccounttype;
  }

  public void setBankaccounttype(String bankaccounttype) {
    this.bankaccounttype = bankaccounttype;
  }

  public BankAccount bban(String bban) {
    this.bban = bban;
    return this;
  }

  /**
   * Numero de Cuenta Basico
   * @return bban
   **/
  @Schema(description = "Numero de Cuenta Basico")
  
    public String getBban() {
    return bban;
  }

  public void setBban(String bban) {
    this.bban = bban;
  }

  public BankAccount cBankaccountId(Integer cBankaccountId) {
    this.cBankaccountId = cBankaccountId;
    return this;
  }

  /**
   * Cuenta Bancaria
   * @return cBankaccountId
   **/
  @Schema(required = true, description = "Cuenta Bancaria")
      @NotNull

    public Integer getCBankaccountId() {
    return cBankaccountId;
  }

  public void setCBankaccountId(Integer cBankaccountId) {
    this.cBankaccountId = cBankaccountId;
  }

  public BankAccount cBankaccountLocationId(Integer cBankaccountLocationId) {
    this.cBankaccountLocationId = cBankaccountLocationId;
    return this;
  }

  /**
   *  
   * @return cBankaccountLocationId
   **/
  @Schema(description = " ")
  
    public Integer getCBankaccountLocationId() {
    return cBankaccountLocationId;
  }

  public void setCBankaccountLocationId(Integer cBankaccountLocationId) {
    this.cBankaccountLocationId = cBankaccountLocationId;
  }

  public BankAccount cBankId(Integer cBankId) {
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

  public BankAccount cc(String cc) {
    this.cc = cc;
    return this;
  }

  /**
   * Cuenta Corriente
   * @return cc
   **/
  @Schema(required = true, description = "Cuenta Corriente")
      @NotNull

    public String getCc() {
    return cc;
  }

  public void setCc(String cc) {
    this.cc = cc;
  }

  public BankAccount cCurrencyId(Integer cCurrencyId) {
    this.cCurrencyId = cCurrencyId;
    return this;
  }

  /**
   * Moneda para este registro
   * @return cCurrencyId
   **/
  @Schema(required = true, description = "Moneda para este registro")
      @NotNull

    public Integer getCCurrencyId() {
    return cCurrencyId;
  }

  public void setCCurrencyId(Integer cCurrencyId) {
    this.cCurrencyId = cCurrencyId;
  }

  public BankAccount created(String created) {
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

  public BankAccount createdby(Integer createdby) {
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

  public BankAccount creditlimit(BigDecimal creditlimit) {
    this.creditlimit = creditlimit;
    return this;
  }

  /**
   * Importe de Crédito permitido
   * @return creditlimit
   **/
  @Schema(required = true, description = "Importe de Crédito permitido")
      @NotNull

    @Valid
    public BigDecimal getCreditlimit() {
    return creditlimit;
  }

  public void setCreditlimit(BigDecimal creditlimit) {
    this.creditlimit = creditlimit;
  }

  public BankAccount currentbalance(BigDecimal currentbalance) {
    this.currentbalance = currentbalance;
    return this;
  }

  /**
   * Saldo Actual
   * @return currentbalance
   **/
  @Schema(required = true, description = "Saldo Actual")
      @NotNull

    @Valid
    public BigDecimal getCurrentbalance() {
    return currentbalance;
  }

  public void setCurrentbalance(BigDecimal currentbalance) {
    this.currentbalance = currentbalance;
  }

  public BankAccount dc(String dc) {
    this.dc = dc;
    return this;
  }

  /**
   * DC
   * @return dc
   **/
  @Schema(description = "DC")
  
    public String getDc() {
    return dc;
  }

  public void setDc(String dc) {
    this.dc = dc;
  }

  public BankAccount description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Descripción corta opcional del registro
   * @return description
   **/
  @Schema(required = true, description = "Descripción corta opcional del registro")
      @NotNull

    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BankAccount electronicpaymentsaccount(Boolean electronicpaymentsaccount) {
    this.electronicpaymentsaccount = electronicpaymentsaccount;
    return this;
  }

  /**
   *  
   * @return electronicpaymentsaccount
   **/
  @Schema(description = " ")
  
    public Boolean isElectronicpaymentsaccount() {
    return electronicpaymentsaccount;
  }

  public void setElectronicpaymentsaccount(Boolean electronicpaymentsaccount) {
    this.electronicpaymentsaccount = electronicpaymentsaccount;
  }

  public BankAccount iban(String iban) {
    this.iban = iban;
    return this;
  }

  /**
   * Numero de Cuenta Bancaria Internacional
   * @return iban
   **/
  @Schema(description = "Numero de Cuenta Bancaria Internacional")
  
    public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public BankAccount isactive(Boolean isactive) {
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

  public BankAccount ischequesencartera(Boolean ischequesencartera) {
    this.ischequesencartera = ischequesencartera;
    return this;
  }

  /**
   * Indica que esta cuenta bancaria es utilizada como cuenta de cheques en cartera
   * @return ischequesencartera
   **/
  @Schema(required = true, description = "Indica que esta cuenta bancaria es utilizada como cuenta de cheques en cartera")
      @NotNull

    public Boolean isIschequesencartera() {
    return ischequesencartera;
  }

  public void setIschequesencartera(Boolean ischequesencartera) {
    this.ischequesencartera = ischequesencartera;
  }

  public BankAccount isdefault(Boolean isdefault) {
    this.isdefault = isdefault;
    return this;
  }

  /**
   * Valor Predeterminado
   * @return isdefault
   **/
  @Schema(required = true, description = "Valor Predeterminado")
      @NotNull

    public Boolean isIsdefault() {
    return isdefault;
  }

  public void setIsdefault(Boolean isdefault) {
    this.isdefault = isdefault;
  }

  public BankAccount oficina(String oficina) {
    this.oficina = oficina;
    return this;
  }

  /**
   * Oficina
   * @return oficina
   **/
  @Schema(required = true, description = "Oficina")
      @NotNull

    public String getOficina() {
    return oficina;
  }

  public void setOficina(String oficina) {
    this.oficina = oficina;
  }

  public BankAccount sucursal(String sucursal) {
    this.sucursal = sucursal;
    return this;
  }

  /**
   *  
   * @return sucursal
   **/
  @Schema(required = true, description = " ")
      @NotNull

    public String getSucursal() {
    return sucursal;
  }

  public void setSucursal(String sucursal) {
    this.sucursal = sucursal;
  }

  public BankAccount updated(String updated) {
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

  public BankAccount updatedby(Integer updatedby) {
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

  public BankAccount additionalvalues(List<Propertiesmap> additionalvalues) {
    this.additionalvalues = additionalvalues;
    return this;
  }

  public BankAccount addAdditionalvaluesItem(Propertiesmap additionalvaluesItem) {
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

  public BankAccount referencedvalues(List<Propertiesmap> referencedvalues) {
    this.referencedvalues = referencedvalues;
    return this;
  }

  public BankAccount addReferencedvaluesItem(Propertiesmap referencedvaluesItem) {
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
    BankAccount bankAccount = (BankAccount) o;
    return Objects.equals(this.accountno, bankAccount.accountno) &&
        Objects.equals(this.adClientId, bankAccount.adClientId) &&
        Objects.equals(this.adComponentobjectuid, bankAccount.adComponentobjectuid) &&
        Objects.equals(this.adOrgId, bankAccount.adOrgId) &&
        Objects.equals(this.bankaccounttype, bankAccount.bankaccounttype) &&
        Objects.equals(this.bban, bankAccount.bban) &&
        Objects.equals(this.cBankaccountId, bankAccount.cBankaccountId) &&
        Objects.equals(this.cBankaccountLocationId, bankAccount.cBankaccountLocationId) &&
        Objects.equals(this.cBankId, bankAccount.cBankId) &&
        Objects.equals(this.cc, bankAccount.cc) &&
        Objects.equals(this.cCurrencyId, bankAccount.cCurrencyId) &&
        Objects.equals(this.created, bankAccount.created) &&
        Objects.equals(this.createdby, bankAccount.createdby) &&
        Objects.equals(this.creditlimit, bankAccount.creditlimit) &&
        Objects.equals(this.currentbalance, bankAccount.currentbalance) &&
        Objects.equals(this.dc, bankAccount.dc) &&
        Objects.equals(this.description, bankAccount.description) &&
        Objects.equals(this.electronicpaymentsaccount, bankAccount.electronicpaymentsaccount) &&
        Objects.equals(this.iban, bankAccount.iban) &&
        Objects.equals(this.isactive, bankAccount.isactive) &&
        Objects.equals(this.ischequesencartera, bankAccount.ischequesencartera) &&
        Objects.equals(this.isdefault, bankAccount.isdefault) &&
        Objects.equals(this.oficina, bankAccount.oficina) &&
        Objects.equals(this.sucursal, bankAccount.sucursal) &&
        Objects.equals(this.updated, bankAccount.updated) &&
        Objects.equals(this.updatedby, bankAccount.updatedby) &&
        Objects.equals(this.additionalvalues, bankAccount.additionalvalues) &&
        Objects.equals(this.referencedvalues, bankAccount.referencedvalues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountno, adClientId, adComponentobjectuid, adOrgId, bankaccounttype, bban, cBankaccountId, cBankaccountLocationId, cBankId, cc, cCurrencyId, created, createdby, creditlimit, currentbalance, dc, description, electronicpaymentsaccount, iban, isactive, ischequesencartera, isdefault, oficina, sucursal, updated, updatedby, additionalvalues, referencedvalues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankAccount {\n");
    
    sb.append("    accountno: ").append(toIndentedString(accountno)).append("\n");
    sb.append("    adClientId: ").append(toIndentedString(adClientId)).append("\n");
    sb.append("    adComponentobjectuid: ").append(toIndentedString(adComponentobjectuid)).append("\n");
    sb.append("    adOrgId: ").append(toIndentedString(adOrgId)).append("\n");
    sb.append("    bankaccounttype: ").append(toIndentedString(bankaccounttype)).append("\n");
    sb.append("    bban: ").append(toIndentedString(bban)).append("\n");
    sb.append("    cBankaccountId: ").append(toIndentedString(cBankaccountId)).append("\n");
    sb.append("    cBankaccountLocationId: ").append(toIndentedString(cBankaccountLocationId)).append("\n");
    sb.append("    cBankId: ").append(toIndentedString(cBankId)).append("\n");
    sb.append("    cc: ").append(toIndentedString(cc)).append("\n");
    sb.append("    cCurrencyId: ").append(toIndentedString(cCurrencyId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdby: ").append(toIndentedString(createdby)).append("\n");
    sb.append("    creditlimit: ").append(toIndentedString(creditlimit)).append("\n");
    sb.append("    currentbalance: ").append(toIndentedString(currentbalance)).append("\n");
    sb.append("    dc: ").append(toIndentedString(dc)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    electronicpaymentsaccount: ").append(toIndentedString(electronicpaymentsaccount)).append("\n");
    sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    ischequesencartera: ").append(toIndentedString(ischequesencartera)).append("\n");
    sb.append("    isdefault: ").append(toIndentedString(isdefault)).append("\n");
    sb.append("    oficina: ").append(toIndentedString(oficina)).append("\n");
    sb.append("    sucursal: ").append(toIndentedString(sucursal)).append("\n");
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
