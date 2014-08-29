package com.mftvanak.edusys.domain.entity.bpm.template;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mftvanak.edusys.domain.DomainConstants;


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
