package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.CourseResource;

public class CourseResourceDao extends EntityDao<CourseResource> {

  public CourseResourceDao () {
    super (CourseResource.class);
  }
}
