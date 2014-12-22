package org.labcrypto.edusys.ws.education.services.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.education.Term;
import org.labcrypto.edusys.facade.education.TermFacade;
import org.labcrypto.edusys.ws.education.services.TermService;
import org.springframework.beans.factory.annotation.Autowired;

public class TermServiceImpl implements TermService {

	@Autowired
	private TermFacade termFacade;

	@Override
	public Long addEntity(Term entity) {
		return termFacade.add(entity);
	}

	@Override
	public void updateEntity(Term entity) {
		termFacade.update(entity);
	}

	@Override
	public void deleteEntity(Long id) {
		termFacade.delete(id);
	}

	@Override
	public Term getEntityById(Long id) {
		return termFacade.getById(id);
	}

	@Override
	public List<Term> getAllEntities() {
		return termFacade.getAll();
	}
}
