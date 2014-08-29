package com.mftvanak.edusys.ws.education.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.education.Course;
import com.mftvanak.edusys.facade.education.CourseFacade;
import com.mftvanak.edusys.ws.education.services.CourseService;


public class CourseServiceImpl implements CourseService {

  @Autowired
  private CourseFacade courseFacade;

  @Override
  public Long addEntity (Course entity) {
    return courseFacade.add (entity);
  }

  @Override
  public void updateEntity (Course entity) {
    courseFacade.update (entity);
  }

  @Override
  public void deleteEntity (Long id) {
    courseFacade.delete (id);
  }

  @Override
  public Course getEntityById (Long id) {
    return courseFacade.getById (id);
  }

  @Override
  public List < Course > getAllEntities () {
    return courseFacade.getAll ();
  }

  @Override
  public void addTag (Long id, Long tagId) {
    courseFacade.addTag (id, tagId);
  }

  @Override
  public void removeTag (Long id, Long tagId) {
    courseFacade.removeTag (id, tagId);
  }

  @Override
  public void addCourseResource (Long id, Long courseResourceId) {
    courseFacade.addCourseResource (id, courseResourceId);
  }

  @Override
  public void removeCourseResource (Long id, Long courseResourceId) {
    courseFacade.removeCourseResource (id, courseResourceId);
  }

  @Override
  public void addCourseSyllabus (Long id, Long courseSyllabusId) {
    courseFacade.addCourseSyllabus (id, courseSyllabusId);
  }

  @Override
  public void removeCourseSyllabus (Long id, Long courseSyllabusId) {
    courseFacade.removeCourseSyllabus (id, courseSyllabusId);
  }
}
