package org.labcrypto.edusys.domain.pg.entity.gheyas;

public class GheyasClassGroup {

  private int instituteId;
  private String code;
  private String name;
  private String description;

  public int getInstituteId () {
    return instituteId;
  }

  public void setInstituteId (int instituteId) {
    this.instituteId = instituteId;
  }

  public String getCode () {
    return code;
  }

  public void setCode (String code) {
    this.code = code;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public String getDescription () {
    return description;
  }

  public void setDescription (String description) {
    this.description = description;
  }
}
