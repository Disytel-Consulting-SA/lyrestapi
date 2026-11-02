package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CouponsSettlementsExists
 */
@Validated



public class CouponsSettlementsExists   {
  @JsonProperty("c_payment_ids")
  @Valid
  private List<Integer> cPaymentIds = null;

  public CouponsSettlementsExists cPaymentIds(List<Integer> cPaymentIds) {
    this.cPaymentIds = cPaymentIds;
    return this;
  }

  public CouponsSettlementsExists addCPaymentIdsItem(Integer cPaymentIdsItem) {
    if (this.cPaymentIds == null) {
      this.cPaymentIds = new ArrayList<>();
    }
    this.cPaymentIds.add(cPaymentIdsItem);
    return this;
  }

  /**
   * Cobros a consultar. Tope configurable, ver la descripcion del endpoint.
   * @return cPaymentIds
   **/
  @Schema(description = "Cobros a consultar. Tope configurable, ver la descripcion del endpoint.")
  
    public List<Integer> getCPaymentIds() {
    return cPaymentIds;
  }

  public void setCPaymentIds(List<Integer> cPaymentIds) {
    this.cPaymentIds = cPaymentIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CouponsSettlementsExists couponsSettlementsExists = (CouponsSettlementsExists) o;
    return Objects.equals(this.cPaymentIds, couponsSettlementsExists.cPaymentIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cPaymentIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CouponsSettlementsExists {\n");
    
    sb.append("    cPaymentIds: ").append(toIndentedString(cPaymentIds)).append("\n");
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
