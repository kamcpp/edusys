package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.Student;

public class StudentDao extends EntityDao<Student> {

  public StudentDao () {
    super (Student.class);
  }
}
