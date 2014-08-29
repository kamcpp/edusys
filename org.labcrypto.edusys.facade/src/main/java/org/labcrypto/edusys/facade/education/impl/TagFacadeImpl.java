package org.labcrypto.edusys.facade.education.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.education.TagDao;
import org.labcrypto.edusys.domain.pg.entity.education.Tag;
import org.labcrypto.edusys.facade.education.TagFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class TagFacadeImpl implements TagFacade {

	@Autowired
	private TagDao tagDao;

	@Override
	public Long add(Tag entity) {
		tagDao.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Tag entity) {
		tagDao.save(entity);
	}

	@Override
	public void delete(Long id) {
		tagDao.delete(id);
	}

	@Override
	public Tag getById(Long id) {
		return tagDao.getById(id);
	}

	@Override
	public List<Tag> getAll() {
		return tagDao.getAll();
	}
}
