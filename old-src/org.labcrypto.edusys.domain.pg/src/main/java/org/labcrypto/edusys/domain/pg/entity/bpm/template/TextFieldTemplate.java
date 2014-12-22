package org.labcrypto.edusys.domain.pg.entity.bpm.template;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.labcrypto.edusys.domain.pg.DomainConstants;


@Entity
@Table (name = "text_field_template", schema = "bpm")
public class TextFieldTemplate extends FieldTemplate {

  @Column (name = "text", length = DomainConstants.STRING_COLUMN_LONG_LENGTH, nullable = true)
  private String text;

  public String getText () {
    return text;
  }

  public void setText (String text) {
    this.text = text;
  }
}
