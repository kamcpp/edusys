package org.labcrypto.edusys.ws.education.services.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.education.Group;
import org.labcrypto.edusys.facade.education.GroupFacade;
import org.labcrypto.edusys.ws.education.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;

public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupFacade groupFacade;

	@Override
	public Long addEntity(Group entity) {
		return groupFacade.add(entity);
	}

	@Override
	public void updateEntity(Group entity) {
		groupFacade.update(entity);
	}

	@Override
	public void deleteEntity(Long id) {
		groupFacade.delete(id);
	}

	@Override
	public Group getEntityById(Long id) {
		return groupFacade.getById(id);
	}

	@Override
	public List<Group> getAllEntities() {
		return groupFacade.getAll();
	}
}
