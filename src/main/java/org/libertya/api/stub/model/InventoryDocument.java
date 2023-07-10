package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.Inventory;
import org.libertya.api.stub.model.InventoryLine;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InventoryDocument
 */
@Validated
public class InventoryDocument   {
  @JsonProperty("header")
  private Inventory header = null;

  @JsonProperty("lines")
  @Valid
  private List<InventoryLine> lines = null;

  public InventoryDocument header(Inventory header) {
    this.header = header;
    return this;
  }

  /**
   * Get header
   * @return header
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Inventory getHeader() {
    return header;
  }

  public void setHeader(Inventory header) {
    this.header = header;
  }

  public InventoryDocument lines(List<InventoryLine> lines) {
    this.lines = lines;
    return this;
  }

  public InventoryDocument addLinesItem(InventoryLine linesItem) {
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
    public List<InventoryLine> getLines() {
    return lines;
  }

  public void setLines(List<InventoryLine> lines) {
    this.lines = lines;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InventoryDocument inventoryDocument = (InventoryDocument) o;
    return Objects.equals(this.header, inventoryDocument.header) &&
        Objects.equals(this.lines, inventoryDocument.lines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, lines);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InventoryDocument {\n");
    
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    lines: ").append(toIndentedString(lines)).append("\n");
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
