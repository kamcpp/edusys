package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.education.Student;

public class StudentDaoImpl extends EntityDaoImpl<Student> {

  public StudentDaoImpl() {
    super (Student.class);
  }
}
