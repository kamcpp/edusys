package org.labcrypto.edusys.facade.education.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.education.StudentDao;
import org.labcrypto.edusys.domain.pg.entity.education.Student;
import org.labcrypto.edusys.facade.education.StudentFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class StudentFacadeImpl implements StudentFacade {

	@Autowired
	private StudentDao studentDao;

	@Override
	public Long add(Student entity) {
		studentDao.save(entity);
		return entity.getPersonId();
	}

	@Override
	public void update(Student entity) {
		studentDao.save(entity);
	}

	@Override
	public void delete(Long id) {
		studentDao.delete(id);
	}

	@Override
	public Student getById(Long id) {
		return studentDao.getById(id);
	}

	@Override
	public List<Student> getAll() {
		return studentDao.getAll();
	}
}
