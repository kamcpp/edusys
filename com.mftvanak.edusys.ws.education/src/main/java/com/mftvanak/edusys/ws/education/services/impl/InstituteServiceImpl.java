package com.mftvanak.edusys.ws.education.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.education.Institute;
import com.mftvanak.edusys.facade.education.InstituteFacade;
import com.mftvanak.edusys.ws.education.services.InstituteService;


public class InstituteServiceImpl implements InstituteService {

  @Autowired
  private InstituteFacade instituteFacade;

  @Override
  public Long addEntity (Institute entity) {
    return instituteFacade.add (entity);
  }

  @Override
  public void updateEntity (Institute entity) {
    instituteFacade.update (entity);
  }

  @Override
  public void deleteEntity (Long id) {
    instituteFacade.delete (id);
  }

  @Override
  public Institute getEntityById (Long id) {
    return instituteFacade.getById (id);
  }

  @Override
  public List < Institute > getAllEntities () {
    return instituteFacade.getAll ();
  }
}
