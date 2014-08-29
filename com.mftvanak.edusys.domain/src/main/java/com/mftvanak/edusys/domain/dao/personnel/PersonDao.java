package com.mftvanak.edusys.domain.dao.personnel;

import com.mftvanak.edusys.domain.dao.EntityDao;
import com.mftvanak.edusys.domain.entity.personnel.Person;


public class PersonDao extends EntityDao < Person > {

  public PersonDao () {
    super (Person.class);
  }
}
