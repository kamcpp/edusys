package org.labcrypto.edusys.ws.education.services.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.education.Institute;
import org.labcrypto.edusys.facade.education.InstituteFacade;
import org.labcrypto.edusys.ws.education.services.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;

public class InstituteServiceImpl implements InstituteService {

	@Autowired
	private InstituteFacade instituteFacade;

	@Override
	public Long addEntity(Institute entity) {
		return instituteFacade.add(entity);
	}

	@Override
	public void updateEntity(Institute entity) {
		instituteFacade.update(entity);
	}

	@Override
	public void deleteEntity(Long id) {
		instituteFacade.delete(id);
	}

	@Override
	public Institute getEntityById(Long id) {
		return instituteFacade.getById(id);
	}

	@Override
	public List<Institute> getAllEntities() {
		return instituteFacade.getAll();
	}
}
