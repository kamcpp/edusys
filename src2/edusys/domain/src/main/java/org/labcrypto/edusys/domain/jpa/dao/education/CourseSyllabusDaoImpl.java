package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.education.CourseSyllabus;

public class CourseSyllabusDaoImpl extends EntityDaoImpl<CourseSyllabus> {

  public CourseSyllabusDaoImpl() {
    super (CourseSyllabus.class);
  }
}
