package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.libertya.api.stub.model.CreditCardCouponFilter;
import org.libertya.api.stub.model.CreditCardSettlement;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreditCardSettlementDocument
 */
@Validated



public class CreditCardSettlementDocument   {
  @JsonProperty("header")
  private CreditCardSettlement header = null;

  @JsonProperty("filter")
  private CreditCardCouponFilter filter = null;

  public CreditCardSettlementDocument header(CreditCardSettlement header) {
    this.header = header;
    return this;
  }

  /**
   * Get header
   * @return header
   **/
  @Schema(description = "")
  
    @Valid
    public CreditCardSettlement getHeader() {
    return header;
  }

  public void setHeader(CreditCardSettlement header) {
    this.header = header;
  }

  public CreditCardSettlementDocument filter(CreditCardCouponFilter filter) {
    this.filter = filter;
    return this;
  }

  /**
   * Get filter
   * @return filter
   **/
  @Schema(description = "")
  
    @Valid
    public CreditCardCouponFilter getFilter() {
    return filter;
  }

  public void setFilter(CreditCardCouponFilter filter) {
    this.filter = filter;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditCardSettlementDocument creditCardSettlementDocument = (CreditCardSettlementDocument) o;
    return Objects.equals(this.header, creditCardSettlementDocument.header) &&
        Objects.equals(this.filter, creditCardSettlementDocument.filter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, filter);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditCardSettlementDocument {\n");
    
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
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
