package org.labcrypto.edusys.facade.education.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.education.CourseResourceDao;
import org.labcrypto.edusys.domain.pg.entity.education.CourseResource;
import org.labcrypto.edusys.facade.education.CourseResourceFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class CourseResourceFacadeImpl implements CourseResourceFacade {

	@Autowired
	private CourseResourceDao courseResourceDao;

	@Override
	public Long add(CourseResource entity) {
		courseResourceDao.save(entity);
		return entity.getId();
	}

	@Override
	public void update(CourseResource entity) {
		courseResourceDao.save(entity);
	}

	@Override
	public void delete(Long id) {
		courseResourceDao.delete(id);
	}

	@Override
	public CourseResource getById(Long id) {
		return courseResourceDao.getById(id);
	}

	@Override
	public List<CourseResource> getAll() {
		return courseResourceDao.getAll();
	}
}
