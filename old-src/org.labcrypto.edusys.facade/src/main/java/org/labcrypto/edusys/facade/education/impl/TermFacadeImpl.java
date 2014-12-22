package org.labcrypto.edusys.facade.education.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.education.TermDao;
import org.labcrypto.edusys.domain.pg.entity.education.Term;
import org.labcrypto.edusys.facade.education.TermFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class TermFacadeImpl implements TermFacade {

	@Autowired
	private TermDao termDao;

	@Override
	public Long add(Term entity) {
		termDao.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Term entity) {
		termDao.save(entity);
	}

	@Override
	public void delete(Long id) {
		termDao.delete(id);
	}

	@Override
	public Term getById(Long id) {
		return termDao.getById(id);
	}

	@Override
	public List<Term> getAll() {
		return termDao.getAll();
	}
}
