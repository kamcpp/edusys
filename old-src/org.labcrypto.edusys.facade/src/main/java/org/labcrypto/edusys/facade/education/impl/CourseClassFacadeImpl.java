package org.labcrypto.edusys.facade.education.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.education.CourseClassDao;
import org.labcrypto.edusys.domain.pg.entity.education.CourseClass;
import org.labcrypto.edusys.facade.education.CourseClassFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class CourseClassFacadeImpl implements CourseClassFacade {

	@Autowired
	private CourseClassDao courseClassDao;

	@Override
	public Long add(CourseClass entity) {
		courseClassDao.save(entity);
		return entity.getId();
	}

	@Override
	public void update(CourseClass entity) {
		courseClassDao.save(entity);
	}

	@Override
	public void delete(Long id) {
		courseClassDao.delete(id);
	}

	@Override
	public CourseClass getById(Long id) {
		return courseClassDao.getById(id);
	}

	@Override
	public List<CourseClass> getAll() {
		return courseClassDao.getAll();
	}
}
