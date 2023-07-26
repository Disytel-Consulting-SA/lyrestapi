package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AllocationNewInvoices
 */
@Validated



public class AllocationNewInvoices   {
  @JsonProperty("c_invoice_id")
  private Integer cInvoiceId = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  public AllocationNewInvoices cInvoiceId(Integer cInvoiceId) {
    this.cInvoiceId = cInvoiceId;
    return this;
  }

  /**
   * Get cInvoiceId
   * @return cInvoiceId
   **/
  @Schema(description = "")
  
    public Integer getCInvoiceId() {
    return cInvoiceId;
  }

  public void setCInvoiceId(Integer cInvoiceId) {
    this.cInvoiceId = cInvoiceId;
  }

  public AllocationNewInvoices amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AllocationNewInvoices allocationNewInvoices = (AllocationNewInvoices) o;
    return Objects.equals(this.cInvoiceId, allocationNewInvoices.cInvoiceId) &&
        Objects.equals(this.amount, allocationNewInvoices.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cInvoiceId, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AllocationNewInvoices {\n");
    
    sb.append("    cInvoiceId: ").append(toIndentedString(cInvoiceId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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
