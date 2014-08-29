package com.mftvanak.edusys.domain.entity.bpm.template;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mftvanak.edusys.domain.DomainConstants;


@Entity
@Table (name = "file_field_template", schema = "bpm")
public class FileFieldTemplate extends FieldTemplate {

  @Column (name = "filename", length = DomainConstants.STRING_COLUMN_DEFAULT_LENGTH, nullable = false)
  private String filename;

  @Column (name = "data", nullable = false)
  private byte[] data;

  public String getFilename () {
    return filename;
  }

  public void setFilename (String filename) {
    this.filename = filename;
  }

  public byte[] getData () {
    return data;
  }

  public void setData (byte[] data) {
    this.data = data;
  }
}
