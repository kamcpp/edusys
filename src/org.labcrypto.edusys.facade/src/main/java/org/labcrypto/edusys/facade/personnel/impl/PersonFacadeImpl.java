package org.labcrypto.edusys.facade.personnel.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.personnel.PersonDao;
import org.labcrypto.edusys.domain.pg.entity.personnel.Person;
import org.labcrypto.edusys.facade.personnel.PersonFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class PersonFacadeImpl implements PersonFacade {

	@Autowired
	private PersonDao personDao;

	@Override
	public Long addPerson(Person person) {
		personDao.save(person);
		return person.getId();
	}

	@Override
	public void updatePerson(Person person) {
		personDao.save(person);
	}

	@Override
	public void deletePerson(Long id) {
		personDao.delete(id);
	}

	@Override
	public Person getPersonById(Long id) {
		return personDao.getById(id);
	}

	@Override
	public List<Person> getPersons() {
		return personDao.getAll();
	}
}
