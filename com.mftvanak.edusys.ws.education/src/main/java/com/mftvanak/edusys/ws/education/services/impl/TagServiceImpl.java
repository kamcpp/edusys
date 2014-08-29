package com.mftvanak.edusys.ws.education.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.education.Tag;
import com.mftvanak.edusys.facade.education.TagFacade;
import com.mftvanak.edusys.ws.education.services.TagService;


public class TagServiceImpl implements TagService {

  @Autowired
  private TagFacade tagFacade;

  @Override
  public Long addEntity (Tag entity) {
    return tagFacade.add (entity);
  }

  @Override
  public void updateEntity (Tag entity) {
    tagFacade.update (entity);
  }

  @Override
  public void deleteEntity (Long id) {
    tagFacade.delete (id);
  }

  @Override
  public Tag getEntityById (Long id) {
    return tagFacade.getById (id);
  }

  @Override
  public List < Tag > getAllEntities () {
    return tagFacade.getAll ();
  }
}
