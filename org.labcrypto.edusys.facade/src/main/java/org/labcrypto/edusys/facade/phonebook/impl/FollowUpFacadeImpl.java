package org.labcrypto.edusys.facade.phonebook.impl;

import org.labcrypto.edusys.domain.pg.dao.phonebook.FollowUpDao;
import org.labcrypto.edusys.domain.pg.entity.phonebook.FollowUp;
import org.labcrypto.edusys.facade.phonebook.FollowUpFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class FollowUpFacadeImpl implements FollowUpFacade {

	@Autowired
	private FollowUpDao followUpDao;

	@Override
	public Long addFollowUp(FollowUp followUp) {
		followUpDao.save(followUp);
		return followUp.getId();
	}

	@Override
	public void updateFollowUp(FollowUp followUp) {
		followUpDao.save(followUp);
	}

	@Override
	public void deleteFollowUp(Long id) {
		followUpDao.delete(id);
	}

	@Override
	public FollowUp getFollowUpBId(Long id) {
		return followUpDao.getById(id);
	}
}
