package org.labcrypto.edusys.ws.education.services.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.education.Student;
import org.labcrypto.edusys.facade.education.StudentFacade;
import org.labcrypto.edusys.ws.education.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentFacade studentFacade;

	@Override
	public Long addEntity(Student entity) {
		return studentFacade.add(entity);
	}

	@Override
	public void updateEntity(Student entity) {
		studentFacade.update(entity);
	}

	@Override
	public void deleteEntity(Long id) {
		studentFacade.delete(id);
	}

	@Override
	public Student getEntityById(Long id) {
		return studentFacade.getById(id);
	}

	@Override
	public List<Student> getAllEntities() {
		return studentFacade.getAll();
	}
}
