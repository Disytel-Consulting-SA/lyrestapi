package org.libertya.api.stub.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.libertya.api.stub.model.Journal;
import org.libertya.api.stub.model.JournalLine;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * JournalDocument
 */
@Validated



public class JournalDocument   {
  @JsonProperty("header")
  private Journal header = null;

  @JsonProperty("lines")
  @Valid
  private List<JournalLine> lines = null;

  public JournalDocument header(Journal header) {
    this.header = header;
    return this;
  }

  /**
   * Get header
   * @return header
   **/
  @Schema(description = "")
  
    @Valid
    public Journal getHeader() {
    return header;
  }

  public void setHeader(Journal header) {
    this.header = header;
  }

  public JournalDocument lines(List<JournalLine> lines) {
    this.lines = lines;
    return this;
  }

  public JournalDocument addLinesItem(JournalLine linesItem) {
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
  @Schema(description = "")
      @Valid
    public List<JournalLine> getLines() {
    return lines;
  }

  public void setLines(List<JournalLine> lines) {
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
    JournalDocument journalDocument = (JournalDocument) o;
    return Objects.equals(this.header, journalDocument.header) &&
        Objects.equals(this.lines, journalDocument.lines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, lines);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JournalDocument {\n");
    
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
