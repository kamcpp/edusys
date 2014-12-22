package org.labcrypto.edusys.ws.education.services.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.education.Teacher;
import org.labcrypto.edusys.facade.education.TeacherFacade;
import org.labcrypto.edusys.ws.education.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherFacade teacherFacade;

	@Override
	public Long addEntity(Teacher entity) {
		return teacherFacade.add(entity);
	}

	@Override
	public void updateEntity(Teacher entity) {
		teacherFacade.update(entity);
	}

	@Override
	public void deleteEntity(Long id) {
		teacherFacade.delete(id);
	}

	@Override
	public Teacher getEntityById(Long id) {
		return teacherFacade.getById(id);
	}

	@Override
	public List<Teacher> getAllEntities() {
		return teacherFacade.getAll();
	}
}
