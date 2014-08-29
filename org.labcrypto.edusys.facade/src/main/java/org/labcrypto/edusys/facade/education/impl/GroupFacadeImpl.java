package org.labcrypto.edusys.facade.education.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.education.GroupDao;
import org.labcrypto.edusys.domain.pg.entity.education.Group;
import org.labcrypto.edusys.facade.education.GroupFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class GroupFacadeImpl implements GroupFacade {

	@Autowired
	private GroupDao groupDao;

	@Override
	public Long add(Group entity) {
		groupDao.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Group entity) {
		groupDao.save(entity);
	}

	@Override
	public void delete(Long id) {
		groupDao.delete(id);
	}

	@Override
	public Group getById(Long id) {
		return groupDao.getById(id);
	}

	@Override
	public List<Group> getAll() {
		return groupDao.getAll();
	}
}
