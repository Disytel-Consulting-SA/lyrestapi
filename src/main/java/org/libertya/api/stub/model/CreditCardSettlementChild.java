package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreditCardSettlementChild
 */
@Validated



public class CreditCardSettlementChild   {
  @JsonProperty("tablename")
  private String tablename = null;

  @JsonProperty("record_id")
  private Integer recordId = null;

  public CreditCardSettlementChild tablename(String tablename) {
    this.tablename = tablename;
    return this;
  }

  /**
   * Tabla de la fila hija (C_SettlementTaxes, C_SettlementRetenciones, C_CommissionConcepts, ...)
   * @return tablename
   **/
  @Schema(description = "Tabla de la fila hija (C_SettlementTaxes, C_SettlementRetenciones, C_CommissionConcepts, ...)")
  
    public String getTablename() {
    return tablename;
  }

  public void setTablename(String tablename) {
    this.tablename = tablename;
  }

  public CreditCardSettlementChild recordId(Integer recordId) {
    this.recordId = recordId;
    return this;
  }

  /**
   * ID de la fila hija
   * @return recordId
   **/
  @Schema(description = "ID de la fila hija")
  
    public Integer getRecordId() {
    return recordId;
  }

  public void setRecordId(Integer recordId) {
    this.recordId = recordId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditCardSettlementChild creditCardSettlementChild = (CreditCardSettlementChild) o;
    return Objects.equals(this.tablename, creditCardSettlementChild.tablename) &&
        Objects.equals(this.recordId, creditCardSettlementChild.recordId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tablename, recordId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditCardSettlementChild {\n");
    
    sb.append("    tablename: ").append(toIndentedString(tablename)).append("\n");
    sb.append("    recordId: ").append(toIndentedString(recordId)).append("\n");
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
