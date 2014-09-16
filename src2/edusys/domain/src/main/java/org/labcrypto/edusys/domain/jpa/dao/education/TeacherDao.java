package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.Teacher;

public class TeacherDao extends EntityDao<Teacher> {

  public TeacherDao () {
    super (Teacher.class);
  }
}
