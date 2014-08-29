package com.mftvanak.edusys.domain.entity.education;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "course_resource", schema = "education")
public class CourseResource {

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
