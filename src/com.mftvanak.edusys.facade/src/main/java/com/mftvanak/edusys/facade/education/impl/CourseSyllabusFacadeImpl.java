package com.mftvanak.edusys.facade.education.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.education.CourseSyllabusDao;
import com.mftvanak.edusys.domain.entity.education.CourseSyllabus;
import com.mftvanak.edusys.facade.education.CourseSyllabusFacade;


public class CourseSyllabusFacadeImpl implements CourseSyllabusFacade {

  @Autowired
  private CourseSyllabusDao courseSyllabusDao;

  @Override
  public Long add (CourseSyllabus entity) {
    courseSyllabusDao.save (entity);
    return entity.getId ();
  }

  @Override
  public void update (CourseSyllabus entity) {
    courseSyllabusDao.save (entity);
  }

  @Override
  public void delete (Long id) {
    courseSyllabusDao.delete (id);
  }

  @Override
  public CourseSyllabus getById (Long id) {
    return courseSyllabusDao.getById (id);
  }

  @Override
  public List < CourseSyllabus > getAll () {
    return courseSyllabusDao.getAll ();
  }
}
