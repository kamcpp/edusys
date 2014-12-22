package org.labcrypto.edusys.ws.education.services.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.education.CoursePlan;
import org.labcrypto.edusys.facade.education.CoursePlanFacade;
import org.labcrypto.edusys.ws.education.services.CoursePlanService;
import org.springframework.beans.factory.annotation.Autowired;

public class CoursePlanServiceImpl implements CoursePlanService {

	@Autowired
	private CoursePlanFacade coursePlanFacade;

	@Override
	public Long addEntity(CoursePlan entity) {
		return coursePlanFacade.add(entity);
	}

	@Override
	public void updateEntity(CoursePlan entity) {
		coursePlanFacade.update(entity);
	}

	@Override
	public void deleteEntity(Long id) {
		coursePlanFacade.delete(id);
	}

	@Override
	public CoursePlan getEntityById(Long id) {
		return coursePlanFacade.getById(id);
	}

	@Override
	public List<CoursePlan> getAllEntities() {
		return coursePlanFacade.getAll();
	}
}
