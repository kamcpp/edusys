package org.labcrypto.edusys.domain.pg.dao.education;

import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.education.Student;


public class StudentDao extends EntityDao < Student > {

  public StudentDao () {
    super (Student.class);
  }
}
