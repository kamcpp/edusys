package com.mftvanak.edusys.facade.education;

import com.mftvanak.edusys.domain.entity.education.Course;
import com.mftvanak.edusys.facade.EntityFacade;


public interface CourseFacade extends EntityFacade < Course > {

  void addTag (Long id, Long tagId);

  void removeTag (Long id, Long tagId);

  void addCourseResource (Long id, Long courseResourceId);

  void removeCourseResource (Long id, Long courseResourceId);

  void addCourseSyllabus (Long id, Long courseSyllabusId);

  void removeCourseSyllabus (Long id, Long courseSyllabusId);

}
