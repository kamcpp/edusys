package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.CourseSyllabus;

public class CourseSyllabusDao extends EntityDao<CourseSyllabus> {

  public CourseSyllabusDao () {
    super (CourseSyllabus.class);
  }
}
