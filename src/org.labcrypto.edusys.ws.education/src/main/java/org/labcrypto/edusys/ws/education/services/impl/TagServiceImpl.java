package org.labcrypto.edusys.ws.education.services.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.education.Tag;
import org.labcrypto.edusys.facade.education.TagFacade;
import org.labcrypto.edusys.ws.education.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;

public class TagServiceImpl implements TagService {

	@Autowired
	private TagFacade tagFacade;

	@Override
	public Long addEntity(Tag entity) {
		return tagFacade.add(entity);
	}

	@Override
	public void updateEntity(Tag entity) {
		tagFacade.update(entity);
	}

	@Override
	public void deleteEntity(Long id) {
		tagFacade.delete(id);
	}

	@Override
	public Tag getEntityById(Long id) {
		return tagFacade.getById(id);
	}

	@Override
	public List<Tag> getAllEntities() {
		return tagFacade.getAll();
	}
}
