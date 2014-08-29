package com.mftvanak.edusys.facade.education.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.education.CourseResourceDao;
import com.mftvanak.edusys.domain.entity.education.CourseResource;
import com.mftvanak.edusys.facade.education.CourseResourceFacade;


public class CourseResourceFacadeImpl implements CourseResourceFacade {

  @Autowired
  private CourseResourceDao courseResourceDao;

  @Override
  public Long add (CourseResource entity) {
    courseResourceDao.save (entity);
    return entity.getId ();
  }

  @Override
  public void update (CourseResource entity) {
    courseResourceDao.save (entity);
  }

  @Override
  public void delete (Long id) {
    courseResourceDao.delete (id);
  }

  @Override
  public CourseResource getById (Long id) {
    return courseResourceDao.getById (id);
  }

  @Override
  public List < CourseResource > getAll () {
    return courseResourceDao.getAll ();
  }
}
