package com.mftvanak.edusys.ui.web.staff.forms;

import org.hibernate.validator.constraints.NotEmpty;


public class CourseCategoryForm {

  @NotEmpty
  private String name;
  private Long parentId;

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public Long getParentId () {
    return parentId;
  }

  public void setParentId (Long parentId) {
    this.parentId = parentId;
  }
}
