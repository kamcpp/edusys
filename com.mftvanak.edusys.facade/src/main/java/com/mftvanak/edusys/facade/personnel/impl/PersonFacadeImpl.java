package com.mftvanak.edusys.facade.personnel.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.personnel.PersonDao;
import com.mftvanak.edusys.domain.entity.personnel.Person;
import com.mftvanak.edusys.facade.personnel.PersonFacade;


public class PersonFacadeImpl implements PersonFacade {

  @Autowired
  private PersonDao personDao;

  @Override
  public Long addPerson (Person person) {
    personDao.save (person);
    return person.getId ();
  }

  @Override
  public void updatePerson (Person person) {
    personDao.save (person);
  }

  @Override
  public void deletePerson (Long id) {
    personDao.delete (id);
  }

  @Override
  public Person getPersonById (Long id) {
    return personDao.getById (id);
  }

  @Override
  public List < Person > getPersons () {
    return personDao.getAll ();
  }
}
