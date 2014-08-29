package com.mftvanak.edusys.facade.education.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.education.DepartmentDao;
import com.mftvanak.edusys.domain.entity.education.Department;
import com.mftvanak.edusys.facade.education.DepartmentFacade;


public class DepartmentFacadeImpl implements DepartmentFacade {

  @Autowired
  private DepartmentDao departmentDao;

  @Override
  public Long add (Department entity) {
    departmentDao.save (entity);
    return entity.getId ();
  }

  @Override
  public void update (Department entity) {
    departmentDao.save (entity);
  }

  @Override
  public void delete (Long id) {
    departmentDao.delete (id);
  }

  @Override
  public Department getById (Long id) {
    return departmentDao.getById (id);
  }

  @Override
  public List < Department > getByInstituteId (Long instituteId) {
    return departmentDao.getDepartmentsByInstituteId (instituteId);
  }

  @Override
  public List < Department > getAll () {
    return departmentDao.getAll ();
  }
}
