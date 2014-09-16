package org.labcrypto.edusys.domain.jpa.dao.personnel;

import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.personnel.Person;


public class PersonDao extends EntityDao < Person > {

  public PersonDao () {
    super (Person.class);
  }
}
