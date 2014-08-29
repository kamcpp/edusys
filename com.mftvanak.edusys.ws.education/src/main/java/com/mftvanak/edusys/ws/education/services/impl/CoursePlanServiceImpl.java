package com.mftvanak.edusys.ws.education.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.education.CoursePlan;
import com.mftvanak.edusys.facade.education.CoursePlanFacade;
import com.mftvanak.edusys.ws.education.services.CoursePlanService;


public class CoursePlanServiceImpl implements CoursePlanService {

  @Autowired
  private CoursePlanFacade coursePlanFacade;

  @Override
  public Long addEntity (CoursePlan entity) {
    return coursePlanFacade.add (entity);
  }

  @Override
  public void updateEntity (CoursePlan entity) {
    coursePlanFacade.update (entity);
  }

  @Override
  public void deleteEntity (Long id) {
    coursePlanFacade.delete (id);
  }

  @Override
  public CoursePlan getEntityById (Long id) {
    return coursePlanFacade.getById (id);
  }

  @Override
  public List < CoursePlan > getAllEntities () {
    return coursePlanFacade.getAll ();
  }
}
