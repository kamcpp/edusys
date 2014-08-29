package com.mftvanak.edusys.ws.personnel.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.personnel.Person;
import com.mftvanak.edusys.facade.personnel.PersonFacade;
import com.mftvanak.edusys.ws.personnel.services.PersonService;


public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonFacade personFacade;

  @Override
  public Long addPerson (Person person) {
    return personFacade.addPerson (person);
  }

  @Override
  public void updatePerson (Person person) {
    personFacade.updatePerson (person);
  }

  @Override
  public void deletePerson (Long id) {
    personFacade.deletePerson (id);
  }

  @Override
  public Person getPersonById (Long id) {
    return personFacade.getPersonById (id);
  }

  @Override
  public List < Person > getPersons () {
    return personFacade.getPersons ();
  }
}
