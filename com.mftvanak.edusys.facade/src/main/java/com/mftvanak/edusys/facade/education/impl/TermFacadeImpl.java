package com.mftvanak.edusys.facade.education.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.education.TermDao;
import com.mftvanak.edusys.domain.entity.education.Term;
import com.mftvanak.edusys.facade.education.TermFacade;


public class TermFacadeImpl implements TermFacade {

  @Autowired
  private TermDao termDao;

  @Override
  public Long add (Term entity) {
    termDao.save (entity);
    return entity.getId ();
  }

  @Override
  public void update (Term entity) {
    termDao.save (entity);
  }

  @Override
  public void delete (Long id) {
    termDao.delete (id);
  }

  @Override
  public Term getById (Long id) {
    return termDao.getById (id);
  }

  @Override
  public List < Term > getAll () {
    return termDao.getAll ();
  }
}
