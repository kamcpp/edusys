package com.mftvanak.edusys.ws.education.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.education.Department;
import com.mftvanak.edusys.facade.education.DepartmentFacade;
import com.mftvanak.edusys.ws.education.services.DepartmentService;


public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  private DepartmentFacade departmentFacade;

  @Override
  public Long addEntity (Department entity) {
    return departmentFacade.add (entity);
  }

  @Override
  public void updateEntity (Department entity) {
    departmentFacade.update (entity);
  }

  @Override
  public void deleteEntity (Long id) {
    departmentFacade.delete (id);
  }

  @Override
  public Department getEntityById (Long id) {
    return departmentFacade.getById (id);
  }

  @Override
  public List < Department > getAllEntities () {
    return departmentFacade.getAll ();
  }

  @Override
  public List < Department > getByInstituteId (Long instituteId) {
    return departmentFacade.getByInstituteId (instituteId);
  }
}
