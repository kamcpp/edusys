package org.labcrypto.edusys.domain.pg.dao.personnel;

import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.personnel.Person;


public class PersonDao extends EntityDao < Person > {

  public PersonDao () {
    super (Person.class);
  }
}
