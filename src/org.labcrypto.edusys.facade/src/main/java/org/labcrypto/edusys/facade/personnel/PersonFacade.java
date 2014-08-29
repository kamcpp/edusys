package org.labcrypto.edusys.facade.personnel;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.personnel.Person;

public interface PersonFacade {

	Long addPerson(Person person);

	void updatePerson(Person person);

	void deletePerson(Long id);

	Person getPersonById(Long id);

	List<Person> getPersons();

}
