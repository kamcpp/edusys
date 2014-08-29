package com.mftvanak.edusys.facade.education.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.education.CoursePlanDao;
import com.mftvanak.edusys.domain.entity.education.CoursePlan;
import com.mftvanak.edusys.facade.education.CoursePlanFacade;


public class CoursePlanFacadeImpl implements CoursePlanFacade {

  @Autowired
  private CoursePlanDao coursePlanDao;

  @Override
  public Long add (CoursePlan entity) {
    coursePlanDao.save (entity);
    return entity.getId ();
  }

  @Override
  public void update (CoursePlan entity) {
    coursePlanDao.save (entity);
  }

  @Override
  public void delete (Long id) {
    coursePlanDao.delete (id);
  }

  @Override
  public CoursePlan getById (Long id) {
    return coursePlanDao.getById (id);
  }

  @Override
  public List < CoursePlan > getAll () {
    return coursePlanDao.getAll ();
  }
}
