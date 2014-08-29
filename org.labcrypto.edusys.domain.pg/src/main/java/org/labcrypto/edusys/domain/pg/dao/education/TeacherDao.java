package org.labcrypto.edusys.domain.pg.dao.education;

import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.education.Teacher;


public class TeacherDao extends EntityDao < Teacher > {

  public TeacherDao () {
    super (Teacher.class);
  }
}
