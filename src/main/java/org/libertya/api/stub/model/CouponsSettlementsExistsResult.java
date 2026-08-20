package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.CouponsSettlementsExistsItem;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CouponsSettlementsExistsResult
 */
@Validated



public class CouponsSettlementsExistsResult   {
  @JsonProperty("encontrados")
  @Valid
  private List<CouponsSettlementsExistsItem> encontrados = null;

  public CouponsSettlementsExistsResult encontrados(List<CouponsSettlementsExistsItem> encontrados) {
    this.encontrados = encontrados;
    return this;
  }

  public CouponsSettlementsExistsResult addEncontradosItem(CouponsSettlementsExistsItem encontradosItem) {
    if (this.encontrados == null) {
      this.encontrados = new ArrayList<>();
    }
    this.encontrados.add(encontradosItem);
    return this;
  }

  /**
   * Solo los c_payment_id que YA estan colgados de alguna liquidacion. Los que no aparecen estan libres. Un cobro puede figurar una sola vez: el modelo impide que este en dos liquidaciones. 
   * @return encontrados
   **/
  @Schema(description = "Solo los c_payment_id que YA estan colgados de alguna liquidacion. Los que no aparecen estan libres. Un cobro puede figurar una sola vez: el modelo impide que este en dos liquidaciones. ")
      @Valid
    public List<CouponsSettlementsExistsItem> getEncontrados() {
    return encontrados;
  }

  public void setEncontrados(List<CouponsSettlementsExistsItem> encontrados) {
    this.encontrados = encontrados;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CouponsSettlementsExistsResult couponsSettlementsExistsResult = (CouponsSettlementsExistsResult) o;
    return Objects.equals(this.encontrados, couponsSettlementsExistsResult.encontrados);
  }

  @Override
  public int hashCode() {
    return Objects.hash(encontrados);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CouponsSettlementsExistsResult {\n");
    
    sb.append("    encontrados: ").append(toIndentedString(encontrados)).append("\n");
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
