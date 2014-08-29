package com.mftvanak.edusys.facade.education.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.education.InstituteDao;
import com.mftvanak.edusys.domain.entity.education.Institute;
import com.mftvanak.edusys.facade.education.InstituteFacade;


public class InstituteFacadeImpl implements InstituteFacade {

  @Autowired
  private InstituteDao instituteDao;

  @Override
  public Long add (Institute entity) {
    instituteDao.save (entity);
    return entity.getId ();
  }

  @Override
  public void update (Institute entity) {
    instituteDao.save (entity);
  }

  @Override
  public void delete (Long id) {
    instituteDao.delete (id);
  }

  @Override
  public Institute getById (Long id) {
    return instituteDao.getById (id);
  }

  @Override
  public List < Institute > getAll () {
    return instituteDao.getAll ();
  }
}
