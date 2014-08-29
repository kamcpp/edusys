package com.mftvanak.edusys.domain.entity.education;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;


@Entity
@Table (name = "course_class", schema = "education")
public class CourseClass {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }
}
