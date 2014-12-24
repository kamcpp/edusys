package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.CourseSyllabus;

public class CourseSyllabusDaoImpl extends JpaEntityDao<CourseSyllabus> implements CourseSyllabusDao {

  public CourseSyllabusDaoImpl() {
    super (CourseSyllabus.class);
  }
}
