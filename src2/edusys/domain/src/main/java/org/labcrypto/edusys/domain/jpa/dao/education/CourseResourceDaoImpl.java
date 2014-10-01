package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.education.CourseResource;

public class CourseResourceDaoImpl extends EntityDaoImpl<CourseResource> {

  public CourseResourceDaoImpl() {
    super (CourseResource.class);
  }
}
