package org.labcrypto.edusys.facade.education.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.education.CoursePlanDao;
import org.labcrypto.edusys.domain.pg.entity.education.CoursePlan;
import org.labcrypto.edusys.facade.education.CoursePlanFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class CoursePlanFacadeImpl implements CoursePlanFacade {

	@Autowired
	private CoursePlanDao coursePlanDao;

	@Override
	public Long add(CoursePlan entity) {
		coursePlanDao.save(entity);
		return entity.getId();
	}

	@Override
	public void update(CoursePlan entity) {
		coursePlanDao.save(entity);
	}

	@Override
	public void delete(Long id) {
		coursePlanDao.delete(id);
	}

	@Override
	public CoursePlan getById(Long id) {
		return coursePlanDao.getById(id);
	}

	@Override
	public List<CoursePlan> getAll() {
		return coursePlanDao.getAll();
	}
}
