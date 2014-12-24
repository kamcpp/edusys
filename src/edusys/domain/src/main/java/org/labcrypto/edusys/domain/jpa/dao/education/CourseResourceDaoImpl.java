package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.CourseResource;

public class CourseResourceDaoImpl extends JpaEntityDao<CourseResource> implements CourseResourceDao {

  public CourseResourceDaoImpl() {
    super (CourseResource.class);
  }
}
