package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.Course;

public class CourseDaoImpl extends JpaEntityDao<Course> implements CourseDao {

  public CourseDaoImpl() {
    super (Course.class);
  }
}
