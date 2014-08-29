package com.mftvanak.edusys.facade.education.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.education.CourseClassDao;
import com.mftvanak.edusys.domain.entity.education.CourseClass;
import com.mftvanak.edusys.facade.education.CourseClassFacade;


public class CourseClassFacadeImpl implements CourseClassFacade {

  @Autowired
  private CourseClassDao courseClassDao;

  @Override
  public Long add (CourseClass entity) {
    courseClassDao.save (entity);
    return entity.getId ();
  }

  @Override
  public void update (CourseClass entity) {
    courseClassDao.save (entity);
  }

  @Override
  public void delete (Long id) {
    courseClassDao.delete (id);
  }

  @Override
  public CourseClass getById (Long id) {
    return courseClassDao.getById (id);
  }

  @Override
  public List < CourseClass > getAll () {
    return courseClassDao.getAll ();
  }
}
