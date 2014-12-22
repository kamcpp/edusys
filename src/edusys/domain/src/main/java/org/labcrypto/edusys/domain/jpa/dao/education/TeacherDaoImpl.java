package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.education.Teacher;

public class TeacherDaoImpl extends EntityDaoImpl<Teacher> {

  public TeacherDaoImpl() {
    super (Teacher.class);
  }
}
