package org.labcrypto.edusys.domain.pg.entity.bpm.template;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.labcrypto.edusys.domain.pg.DomainConstants;


@Entity
@Table (name = "field_template", schema = "bpm")
public class FieldTemplate {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;

  @Column (name = "required", nullable = false)
  private boolean required;

  @Column (name = "english_name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String englishName;

  @Column (name = "persian_name", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String persianName;

  public boolean isRequired () {
    return required;
  }

  public void setRequired (boolean required) {
    this.required = required;
  }

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }
}
