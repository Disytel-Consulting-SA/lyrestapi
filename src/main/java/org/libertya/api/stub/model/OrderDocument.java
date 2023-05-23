package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.Order;
import org.libertya.api.stub.model.OrderLine;
import org.libertya.api.stub.model.OrderTax;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OrderDocument
 */
@Validated
public class OrderDocument   {
  @JsonProperty("header")
  private Order header = null;

  @JsonProperty("lines")
  @Valid
  private List<OrderLine> lines = null;

  @JsonProperty("taxes")
  @Valid
  private List<OrderTax> taxes = null;

  public OrderDocument header(Order header) {
    this.header = header;
    return this;
  }

  /**
   * Get header
   * @return header
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Order getHeader() {
    return header;
  }

  public void setHeader(Order header) {
    this.header = header;
  }

  public OrderDocument lines(List<OrderLine> lines) {
    this.lines = lines;
    return this;
  }

  public OrderDocument addLinesItem(OrderLine linesItem) {
    if (this.lines == null) {
      this.lines = new ArrayList<>();
    }
    this.lines.add(linesItem);
    return this;
  }

  /**
   * Get lines
   * @return lines
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<OrderLine> getLines() {
    return lines;
  }

  public void setLines(List<OrderLine> lines) {
    this.lines = lines;
  }

  public OrderDocument taxes(List<OrderTax> taxes) {
    this.taxes = taxes;
    return this;
  }

  public OrderDocument addTaxesItem(OrderTax taxesItem) {
    if (this.taxes == null) {
      this.taxes = new ArrayList<>();
    }
    this.taxes.add(taxesItem);
    return this;
  }

  /**
   * Get taxes
   * @return taxes
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<OrderTax> getTaxes() {
    return taxes;
  }

  public void setTaxes(List<OrderTax> taxes) {
    this.taxes = taxes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDocument orderDocument = (OrderDocument) o;
    return Objects.equals(this.header, orderDocument.header) &&
        Objects.equals(this.lines, orderDocument.lines) &&
        Objects.equals(this.taxes, orderDocument.taxes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, lines, taxes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDocument {\n");
    
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    lines: ").append(toIndentedString(lines)).append("\n");
    sb.append("    taxes: ").append(toIndentedString(taxes)).append("\n");
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
