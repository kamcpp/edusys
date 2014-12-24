package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.Teacher;

public class TeacherDaoImpl extends JpaEntityDao<Teacher> implements TeacherDao {

  public TeacherDaoImpl() {
    super (Teacher.class);
  }
}
