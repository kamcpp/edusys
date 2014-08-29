package org.labcrypto.edusys.domain.pg.dao.education;

import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.education.CourseClass;


public class CourseClassDao extends EntityDao < CourseClass > {

  public CourseClassDao () {
    super (CourseClass.class);
  }
}
