package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.Student;

public class StudentDaoImpl extends JpaEntityDao<Student> implements StudentDao {

  public StudentDaoImpl() {
    super (Student.class);
  }
}
