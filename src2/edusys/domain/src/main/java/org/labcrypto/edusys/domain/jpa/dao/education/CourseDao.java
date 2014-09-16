package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.Course;

public class CourseDao extends EntityDao<Course> {

  public CourseDao () {
    super (Course.class);
  }
}
