package com.mftvanak.edusys.ws.education.services;

import com.mftvanak.edusys.domain.entity.education.Course;
import com.mftvanak.edusys.ws.EntityService;


public interface CourseService extends EntityService < Course > {

  void addTag (Long id, Long tagId);

  void removeTag (Long id, Long tagId);

  void addCourseResource (Long id, Long courseResourceId);

  void removeCourseResource (Long id, Long courseResourceId);

  void addCourseSyllabus (Long id, Long courseSyllabusId);

  void removeCourseSyllabus (Long id, Long courseSyllabusId);
}
