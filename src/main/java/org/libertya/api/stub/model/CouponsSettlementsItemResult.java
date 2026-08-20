package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CouponsSettlementsItemResult
 */
@Validated



public class CouponsSettlementsItemResult   {
  @JsonProperty("c_payment_id")
  private Integer cPaymentId = null;

  @JsonProperty("estado")
  private String estado = null;

  @JsonProperty("c_couponssettlements_id")
  private Integer cCouponssettlementsId = null;

  @JsonProperty("c_creditcardsettlement_id_en_conflicto")
  private Integer cCreditcardsettlementIdEnConflicto = null;

  @JsonProperty("motivo")
  private String motivo = null;

  public CouponsSettlementsItemResult cPaymentId(Integer cPaymentId) {
    this.cPaymentId = cPaymentId;
    return this;
  }

  /**
   * Cobro al que corresponde el cupon
   * @return cPaymentId
   **/
  @Schema(description = "Cobro al que corresponde el cupon")
  
    public Integer getCPaymentId() {
    return cPaymentId;
  }

  public void setCPaymentId(Integer cPaymentId) {
    this.cPaymentId = cPaymentId;
  }

  public CouponsSettlementsItemResult estado(String estado) {
    this.estado = estado;
    return this;
  }

  /**
   * creado     = el cupon se inserto en esta llamada. ya_existia = el c_payment_id ya estaba colgado de ESTA liquidacion; no se hizo nada. conflicto  = el c_payment_id ya esta colgado de OTRA liquidacion (R7) o el modelo lo rechazo. error      = fallo no atribuible a una regla conocida; ver motivo. 
   * @return estado
   **/
  @Schema(description = "creado     = el cupon se inserto en esta llamada. ya_existia = el c_payment_id ya estaba colgado de ESTA liquidacion; no se hizo nada. conflicto  = el c_payment_id ya esta colgado de OTRA liquidacion (R7) o el modelo lo rechazo. error      = fallo no atribuible a una regla conocida; ver motivo. ")
  
    public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public CouponsSettlementsItemResult cCouponssettlementsId(Integer cCouponssettlementsId) {
    this.cCouponssettlementsId = cCouponssettlementsId;
    return this;
  }

  /**
   * ID del cupon creado, o del que ya existia / esta en conflicto
   * @return cCouponssettlementsId
   **/
  @Schema(description = "ID del cupon creado, o del que ya existia / esta en conflicto")
  
    public Integer getCCouponssettlementsId() {
    return cCouponssettlementsId;
  }

  public void setCCouponssettlementsId(Integer cCouponssettlementsId) {
    this.cCouponssettlementsId = cCouponssettlementsId;
  }

  public CouponsSettlementsItemResult cCreditcardsettlementIdEnConflicto(Integer cCreditcardsettlementIdEnConflicto) {
    this.cCreditcardsettlementIdEnConflicto = cCreditcardsettlementIdEnConflicto;
    return this;
  }

  /**
   * Solo si estado=conflicto por R7: la liquidacion que ya tiene ese cobro
   * @return cCreditcardsettlementIdEnConflicto
   **/
  @Schema(description = "Solo si estado=conflicto por R7: la liquidacion que ya tiene ese cobro")
  
    public Integer getCCreditcardsettlementIdEnConflicto() {
    return cCreditcardsettlementIdEnConflicto;
  }

  public void setCCreditcardsettlementIdEnConflicto(Integer cCreditcardsettlementIdEnConflicto) {
    this.cCreditcardsettlementIdEnConflicto = cCreditcardsettlementIdEnConflicto;
  }

  public CouponsSettlementsItemResult motivo(String motivo) {
    this.motivo = motivo;
    return this;
  }

  /**
   * Regla o mensaje del modelo que explica el estado (R6, R7, o el texto crudo del core)
   * @return motivo
   **/
  @Schema(description = "Regla o mensaje del modelo que explica el estado (R6, R7, o el texto crudo del core)")
  
    public String getMotivo() {
    return motivo;
  }

  public void setMotivo(String motivo) {
    this.motivo = motivo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CouponsSettlementsItemResult couponsSettlementsItemResult = (CouponsSettlementsItemResult) o;
    return Objects.equals(this.cPaymentId, couponsSettlementsItemResult.cPaymentId) &&
        Objects.equals(this.estado, couponsSettlementsItemResult.estado) &&
        Objects.equals(this.cCouponssettlementsId, couponsSettlementsItemResult.cCouponssettlementsId) &&
        Objects.equals(this.cCreditcardsettlementIdEnConflicto, couponsSettlementsItemResult.cCreditcardsettlementIdEnConflicto) &&
        Objects.equals(this.motivo, couponsSettlementsItemResult.motivo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cPaymentId, estado, cCouponssettlementsId, cCreditcardsettlementIdEnConflicto, motivo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CouponsSettlementsItemResult {\n");
    
    sb.append("    cPaymentId: ").append(toIndentedString(cPaymentId)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
    sb.append("    cCouponssettlementsId: ").append(toIndentedString(cCouponssettlementsId)).append("\n");
    sb.append("    cCreditcardsettlementIdEnConflicto: ").append(toIndentedString(cCreditcardsettlementIdEnConflicto)).append("\n");
    sb.append("    motivo: ").append(toIndentedString(motivo)).append("\n");
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
