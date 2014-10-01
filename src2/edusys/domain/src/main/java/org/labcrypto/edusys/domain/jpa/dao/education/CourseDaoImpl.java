package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.education.Course;

public class CourseDaoImpl extends EntityDaoImpl<Course> {

  public CourseDaoImpl() {
    super (Course.class);
  }
}
