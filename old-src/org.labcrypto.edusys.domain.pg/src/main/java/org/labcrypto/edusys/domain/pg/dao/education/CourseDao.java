package org.labcrypto.edusys.domain.pg.dao.education;

import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.education.Course;


public class CourseDao extends EntityDao < Course > {

  public CourseDao () {
    super (Course.class);
  }
}
