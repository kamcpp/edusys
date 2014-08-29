package com.mftvanak.edusys.domain.dao.education;

import com.mftvanak.edusys.domain.dao.EntityDao;
import com.mftvanak.edusys.domain.entity.education.Course;


public class CourseDao extends EntityDao < Course > {

  public CourseDao () {
    super (Course.class);
  }
}
