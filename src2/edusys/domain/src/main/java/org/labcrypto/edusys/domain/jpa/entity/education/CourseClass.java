package org.labcrypto.edusys.domain.jpa.entity.education;

import javax.persistence.*;


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
