package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.CouponsSettlements;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CouponsSettlementsBulk
 */
@Validated



public class CouponsSettlementsBulk   {
  @JsonProperty("c_creditcardsettlement_id")
  private Integer cCreditcardsettlementId = null;

  @JsonProperty("c_creditcardcouponfilter_id")
  private Integer cCreditcardcouponfilterId = null;

  @JsonProperty("coupons")
  @Valid
  private List<CouponsSettlements> coupons = null;

  public CouponsSettlementsBulk cCreditcardsettlementId(Integer cCreditcardsettlementId) {
    this.cCreditcardsettlementId = cCreditcardsettlementId;
    return this;
  }

  /**
   * Liquidacion a la que se cuelgan todos los cupones del lote
   * @return cCreditcardsettlementId
   **/
  @Schema(description = "Liquidacion a la que se cuelgan todos los cupones del lote")
  
    public Integer getCCreditcardsettlementId() {
    return cCreditcardsettlementId;
  }

  public void setCCreditcardsettlementId(Integer cCreditcardsettlementId) {
    this.cCreditcardsettlementId = cCreditcardsettlementId;
  }

  public CouponsSettlementsBulk cCreditcardcouponfilterId(Integer cCreditcardcouponfilterId) {
    this.cCreditcardcouponfilterId = cCreditcardcouponfilterId;
    return this;
  }

  /**
   * Filtro del cual cuelgan los cupones. Es NOT NULL en la base: un cupon sin filtro no se puede insertar. Si se omite aqui, cada cupon debe traerlo en su propio cuerpo. 
   * @return cCreditcardcouponfilterId
   **/
  @Schema(description = "Filtro del cual cuelgan los cupones. Es NOT NULL en la base: un cupon sin filtro no se puede insertar. Si se omite aqui, cada cupon debe traerlo en su propio cuerpo. ")
  
    public Integer getCCreditcardcouponfilterId() {
    return cCreditcardcouponfilterId;
  }

  public void setCCreditcardcouponfilterId(Integer cCreditcardcouponfilterId) {
    this.cCreditcardcouponfilterId = cCreditcardcouponfilterId;
  }

  public CouponsSettlementsBulk coupons(List<CouponsSettlements> coupons) {
    this.coupons = coupons;
    return this;
  }

  public CouponsSettlementsBulk addCouponsItem(CouponsSettlements couponsItem) {
    if (this.coupons == null) {
      this.coupons = new ArrayList<>();
    }
    this.coupons.add(couponsItem);
    return this;
  }

  /**
   * Cupones a crear. Cada uno se inserta en su propia transaccion.
   * @return coupons
   **/
  @Schema(description = "Cupones a crear. Cada uno se inserta en su propia transaccion.")
      @Valid
    public List<CouponsSettlements> getCoupons() {
    return coupons;
  }

  public void setCoupons(List<CouponsSettlements> coupons) {
    this.coupons = coupons;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CouponsSettlementsBulk couponsSettlementsBulk = (CouponsSettlementsBulk) o;
    return Objects.equals(this.cCreditcardsettlementId, couponsSettlementsBulk.cCreditcardsettlementId) &&
        Objects.equals(this.cCreditcardcouponfilterId, couponsSettlementsBulk.cCreditcardcouponfilterId) &&
        Objects.equals(this.coupons, couponsSettlementsBulk.coupons);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cCreditcardsettlementId, cCreditcardcouponfilterId, coupons);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CouponsSettlementsBulk {\n");
    
    sb.append("    cCreditcardsettlementId: ").append(toIndentedString(cCreditcardsettlementId)).append("\n");
    sb.append("    cCreditcardcouponfilterId: ").append(toIndentedString(cCreditcardcouponfilterId)).append("\n");
    sb.append("    coupons: ").append(toIndentedString(coupons)).append("\n");
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
