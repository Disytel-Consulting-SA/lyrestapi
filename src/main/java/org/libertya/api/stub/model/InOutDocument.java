package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.InOut;
import org.libertya.api.stub.model.InOutLine;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InOutDocument
 */
@Validated
public class InOutDocument   {
  @JsonProperty("header")
  private InOut header = null;

  @JsonProperty("lines")
  @Valid
  private List<InOutLine> lines = null;

  public InOutDocument header(InOut header) {
    this.header = header;
    return this;
  }

  /**
   * Get header
   * @return header
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public InOut getHeader() {
    return header;
  }

  public void setHeader(InOut header) {
    this.header = header;
  }

  public InOutDocument lines(List<InOutLine> lines) {
    this.lines = lines;
    return this;
  }

  public InOutDocument addLinesItem(InOutLine linesItem) {
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
    public List<InOutLine> getLines() {
    return lines;
  }

  public void setLines(List<InOutLine> lines) {
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
    InOutDocument inOutDocument = (InOutDocument) o;
    return Objects.equals(this.header, inOutDocument.header) &&
        Objects.equals(this.lines, inOutDocument.lines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, lines);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InOutDocument {\n");
    
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
