package com.mftvanak.edusys.ws.personnel.services;

import java.util.List;

import com.mftvanak.edusys.domain.entity.personnel.Person;


public interface PersonService {

  Long addPerson (Person person);

  void updatePerson (Person person);

  void deletePerson (Long id);

  Person getPersonById (Long id);

  List < Person > getPersons ();

}
