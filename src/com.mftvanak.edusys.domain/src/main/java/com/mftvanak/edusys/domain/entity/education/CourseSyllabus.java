package com.mftvanak.edusys.domain.entity.education;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "course_syllabus", schema = "education")
public class CourseSyllabus {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "course_id", nullable = false)
  private Course course;

  public Long getId () {
    return id;
  }

  public void setId (Long id) {
    this.id = id;
  }

  public Course getCourse () {
    return course;
  }

  public void setCourse (Course course) {
    this.course = course;
  }
}
