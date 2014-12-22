package org.labcrypto.edusys.domain.jpa.dao.personnel;

import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.personnel.Person;


public class PersonDaoImpl extends EntityDaoImpl< Person > {

  public PersonDaoImpl() {
    super (Person.class);
  }
}
