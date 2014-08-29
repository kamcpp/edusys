package com.mftvanak.edusys.ws.membership.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.personnel.Person;
import com.mftvanak.edusys.facade.personnel.PersonFacade;
import com.mftvanak.edusys.ws.membership.services.PersonnelService;


public class FacadePersonnelService implements PersonnelService {

  @Autowired
  private PersonFacade personFacade;

  @Override
  public Person getPersonById (Long id) {
    return personFacade.getPersonById (id);
  }
}
