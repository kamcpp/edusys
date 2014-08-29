package com.mftvanak.edusys.ws.messaging.services;

import com.mftvanak.edusys.domain.entity.personnel.Person;


public interface PersonnelService {

  Person getPersonById(Long id);
  
}
