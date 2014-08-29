package org.labcrypto.edusys.facade.education.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.education.CourseSyllabusDao;
import org.labcrypto.edusys.domain.pg.entity.education.CourseSyllabus;
import org.labcrypto.edusys.facade.education.CourseSyllabusFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class CourseSyllabusFacadeImpl implements CourseSyllabusFacade {

	@Autowired
	private CourseSyllabusDao courseSyllabusDao;

	@Override
	public Long add(CourseSyllabus entity) {
		courseSyllabusDao.save(entity);
		return entity.getId();
	}

	@Override
	public void update(CourseSyllabus entity) {
		courseSyllabusDao.save(entity);
	}

	@Override
	public void delete(Long id) {
		courseSyllabusDao.delete(id);
	}

	@Override
	public CourseSyllabus getById(Long id) {
		return courseSyllabusDao.getById(id);
	}

	@Override
	public List<CourseSyllabus> getAll() {
		return courseSyllabusDao.getAll();
	}
}
