package org.labcrypto.edusys.ws.education.services.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.education.CourseClass;
import org.labcrypto.edusys.facade.education.CourseClassFacade;
import org.labcrypto.edusys.ws.education.services.CourseClassService;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseClassServiceImpl implements CourseClassService {

	@Autowired
	private CourseClassFacade courseClassFacade;

	@Override
	public Long addEntity(CourseClass entity) {
		return courseClassFacade.add(entity);
	}

	@Override
	public void updateEntity(CourseClass entity) {
		courseClassFacade.update(entity);
	}

	@Override
	public void deleteEntity(Long id) {
		courseClassFacade.delete(id);
	}

	@Override
	public CourseClass getEntityById(Long id) {
		return courseClassFacade.getById(id);
	}

	@Override
	public List<CourseClass> getAllEntities() {
		return courseClassFacade.getAll();
	}
}
