package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CouponsSettlementsExistsItem
 */
@Validated



public class CouponsSettlementsExistsItem   {
  @JsonProperty("c_payment_id")
  private Integer cPaymentId = null;

  @JsonProperty("c_couponssettlements_id")
  private Integer cCouponssettlementsId = null;

  @JsonProperty("c_creditcardsettlement_id")
  private Integer cCreditcardsettlementId = null;

  @JsonProperty("c_creditcardcouponfilter_id")
  private Integer cCreditcardcouponfilterId = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  @JsonProperty("isreconciled")
  private Boolean isreconciled = null;

  @JsonProperty("include")
  private Boolean include = null;

  public CouponsSettlementsExistsItem cPaymentId(Integer cPaymentId) {
    this.cPaymentId = cPaymentId;
    return this;
  }

  /**
   * Cobro consultado
   * @return cPaymentId
   **/
  @Schema(description = "Cobro consultado")
  
    public Integer getCPaymentId() {
    return cPaymentId;
  }

  public void setCPaymentId(Integer cPaymentId) {
    this.cPaymentId = cPaymentId;
  }

  public CouponsSettlementsExistsItem cCouponssettlementsId(Integer cCouponssettlementsId) {
    this.cCouponssettlementsId = cCouponssettlementsId;
    return this;
  }

  /**
   * Cupon que lo tiene
   * @return cCouponssettlementsId
   **/
  @Schema(description = "Cupon que lo tiene")
  
    public Integer getCCouponssettlementsId() {
    return cCouponssettlementsId;
  }

  public void setCCouponssettlementsId(Integer cCouponssettlementsId) {
    this.cCouponssettlementsId = cCouponssettlementsId;
  }

  public CouponsSettlementsExistsItem cCreditcardsettlementId(Integer cCreditcardsettlementId) {
    this.cCreditcardsettlementId = cCreditcardsettlementId;
    return this;
  }

  /**
   * Liquidacion de la que cuelga ese cupon
   * @return cCreditcardsettlementId
   **/
  @Schema(description = "Liquidacion de la que cuelga ese cupon")
  
    public Integer getCCreditcardsettlementId() {
    return cCreditcardsettlementId;
  }

  public void setCCreditcardsettlementId(Integer cCreditcardsettlementId) {
    this.cCreditcardsettlementId = cCreditcardsettlementId;
  }

  public CouponsSettlementsExistsItem cCreditcardcouponfilterId(Integer cCreditcardcouponfilterId) {
    this.cCreditcardcouponfilterId = cCreditcardcouponfilterId;
    return this;
  }

  /**
   * Filtro del que cuelga ese cupon
   * @return cCreditcardcouponfilterId
   **/
  @Schema(description = "Filtro del que cuelga ese cupon")
  
    public Integer getCCreditcardcouponfilterId() {
    return cCreditcardcouponfilterId;
  }

  public void setCCreditcardcouponfilterId(Integer cCreditcardcouponfilterId) {
    this.cCreditcardcouponfilterId = cCreditcardcouponfilterId;
  }

  public CouponsSettlementsExistsItem isactive(Boolean isactive) {
    this.isactive = isactive;
    return this;
  }

  /**
   * Si el cupon esta activo. Se devuelve porque la regla R7 del modelo NO mira este campo: un cupon desactivado sigue bloqueando su cobro. Un item con isactive=false explica un rechazo que de otro modo pareceria inexplicable. 
   * @return isactive
   **/
  @Schema(description = "Si el cupon esta activo. Se devuelve porque la regla R7 del modelo NO mira este campo: un cupon desactivado sigue bloqueando su cobro. Un item con isactive=false explica un rechazo que de otro modo pareceria inexplicable. ")
  
    public Boolean isIsactive() {
    return isactive;
  }

  public void setIsactive(Boolean isactive) {
    this.isactive = isactive;
  }

  public CouponsSettlementsExistsItem isreconciled(Boolean isreconciled) {
    this.isreconciled = isreconciled;
    return this;
  }

  /**
   * Si el cupon esta marcado como conciliado
   * @return isreconciled
   **/
  @Schema(description = "Si el cupon esta marcado como conciliado")
  
    public Boolean isIsreconciled() {
    return isreconciled;
  }

  public void setIsreconciled(Boolean isreconciled) {
    this.isreconciled = isreconciled;
  }

  public CouponsSettlementsExistsItem include(Boolean include) {
    this.include = include;
    return this;
  }

  /**
   * Si el cupon participa del total de la liquidacion (couponstotalamount)
   * @return include
   **/
  @Schema(description = "Si el cupon participa del total de la liquidacion (couponstotalamount)")
  
    public Boolean isInclude() {
    return include;
  }

  public void setInclude(Boolean include) {
    this.include = include;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CouponsSettlementsExistsItem couponsSettlementsExistsItem = (CouponsSettlementsExistsItem) o;
    return Objects.equals(this.cPaymentId, couponsSettlementsExistsItem.cPaymentId) &&
        Objects.equals(this.cCouponssettlementsId, couponsSettlementsExistsItem.cCouponssettlementsId) &&
        Objects.equals(this.cCreditcardsettlementId, couponsSettlementsExistsItem.cCreditcardsettlementId) &&
        Objects.equals(this.cCreditcardcouponfilterId, couponsSettlementsExistsItem.cCreditcardcouponfilterId) &&
        Objects.equals(this.isactive, couponsSettlementsExistsItem.isactive) &&
        Objects.equals(this.isreconciled, couponsSettlementsExistsItem.isreconciled) &&
        Objects.equals(this.include, couponsSettlementsExistsItem.include);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cPaymentId, cCouponssettlementsId, cCreditcardsettlementId, cCreditcardcouponfilterId, isactive, isreconciled, include);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CouponsSettlementsExistsItem {\n");
    
    sb.append("    cPaymentId: ").append(toIndentedString(cPaymentId)).append("\n");
    sb.append("    cCouponssettlementsId: ").append(toIndentedString(cCouponssettlementsId)).append("\n");
    sb.append("    cCreditcardsettlementId: ").append(toIndentedString(cCreditcardsettlementId)).append("\n");
    sb.append("    cCreditcardcouponfilterId: ").append(toIndentedString(cCreditcardcouponfilterId)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
    sb.append("    isreconciled: ").append(toIndentedString(isreconciled)).append("\n");
    sb.append("    include: ").append(toIndentedString(include)).append("\n");
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
