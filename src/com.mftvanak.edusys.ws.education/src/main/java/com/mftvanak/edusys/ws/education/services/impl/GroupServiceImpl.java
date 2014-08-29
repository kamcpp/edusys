package com.mftvanak.edusys.ws.education.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.education.Group;
import com.mftvanak.edusys.facade.education.GroupFacade;
import com.mftvanak.edusys.ws.education.services.GroupService;


public class GroupServiceImpl implements GroupService {

  @Autowired
  private GroupFacade groupFacade;

  @Override
  public Long addEntity (Group entity) {
    return groupFacade.add (entity);
  }

  @Override
  public void updateEntity (Group entity) {
    groupFacade.update (entity);
  }

  @Override
  public void deleteEntity (Long id) {
    groupFacade.delete (id);
  }

  @Override
  public Group getEntityById (Long id) {
    return groupFacade.getById (id);
  }

  @Override
  public List < Group > getAllEntities () {
    return groupFacade.getAll ();
  }
}
