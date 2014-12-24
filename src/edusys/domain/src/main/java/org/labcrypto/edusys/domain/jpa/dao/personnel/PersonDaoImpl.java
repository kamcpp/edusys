package org.labcrypto.edusys.domain.jpa.dao.personnel;

import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.personnel.Person;


public class PersonDaoImpl extends JpaEntityDao<Person> implements PersonDao {

    public PersonDaoImpl() {
        super(Person.class);
    }
}
