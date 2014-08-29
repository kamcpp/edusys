package com.mftvanak.edusys.facade.education.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.education.GroupDao;
import com.mftvanak.edusys.domain.entity.education.Group;
import com.mftvanak.edusys.facade.education.GroupFacade;


public class GroupFacadeImpl implements GroupFacade {

  @Autowired
  private GroupDao groupDao;

  @Override
  public Long add (Group entity) {
    groupDao.save (entity);
    return entity.getId ();
  }

  @Override
  public void update (Group entity) {
    groupDao.save (entity);
  }

  @Override
  public void delete (Long id) {
    groupDao.delete (id);
  }

  @Override
  public Group getById (Long id) {
    return groupDao.getById (id);
  }

  @Override
  public List < Group > getAll () {
    return groupDao.getAll ();
  }
}
