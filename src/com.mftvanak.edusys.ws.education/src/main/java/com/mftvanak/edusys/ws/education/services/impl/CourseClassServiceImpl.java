package com.mftvanak.edusys.ws.education.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.education.CourseClass;
import com.mftvanak.edusys.facade.education.CourseClassFacade;
import com.mftvanak.edusys.ws.education.services.CourseClassService;


public class CourseClassServiceImpl implements CourseClassService {

  @Autowired
  private CourseClassFacade courseClassFacade;

  @Override
  public Long addEntity (CourseClass entity) {
    return courseClassFacade.add (entity);
  }

  @Override
  public void updateEntity (CourseClass entity) {
    courseClassFacade.update (entity);
  }

  @Override
  public void deleteEntity (Long id) {
    courseClassFacade.delete (id);
  }

  @Override
  public CourseClass getEntityById (Long id) {
    return courseClassFacade.getById (id);
  }

  @Override
  public List < CourseClass > getAllEntities () {
    return courseClassFacade.getAll ();
  }
}
