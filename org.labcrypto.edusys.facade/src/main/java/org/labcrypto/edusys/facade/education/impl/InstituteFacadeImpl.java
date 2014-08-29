package org.labcrypto.edusys.facade.education.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.education.InstituteDao;
import org.labcrypto.edusys.domain.pg.entity.education.Institute;
import org.labcrypto.edusys.facade.education.InstituteFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class InstituteFacadeImpl implements InstituteFacade {

	@Autowired
	private InstituteDao instituteDao;

	@Override
	public Long add(Institute entity) {
		instituteDao.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Institute entity) {
		instituteDao.save(entity);
	}

	@Override
	public void delete(Long id) {
		instituteDao.delete(id);
	}

	@Override
	public Institute getById(Long id) {
		return instituteDao.getById(id);
	}

	@Override
	public List<Institute> getAll() {
		return instituteDao.getAll();
	}
}
