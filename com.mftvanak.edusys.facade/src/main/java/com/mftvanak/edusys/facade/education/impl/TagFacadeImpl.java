package com.mftvanak.edusys.facade.education.impl;

import java.util.List;

import com.mftvanak.edusys.domain.dao.education.TagDao;
import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.education.Tag;
import com.mftvanak.edusys.facade.education.TagFacade;


public class TagFacadeImpl implements TagFacade {

  @Autowired
  private TagDao tagDao;

  @Override
  public Long add (Tag entity) {
    tagDao.save (entity);
    return entity.getId ();
  }

  @Override
  public void update (Tag entity) {
    tagDao.save (entity);
  }

  @Override
  public void delete (Long id) {
    tagDao.delete (id);
  }

  @Override
  public Tag getById (Long id) {
    return tagDao.getById (id);
  }

  @Override
  public List < Tag > getAll () {
    return tagDao.getAll ();
  }
}
