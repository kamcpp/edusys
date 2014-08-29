package com.mftvanak.edusys.facade.phonebook.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.phonebook.FollowUpDao;
import com.mftvanak.edusys.domain.entity.phonebook.FollowUp;
import com.mftvanak.edusys.facade.phonebook.FollowUpFacade;


public class FollowUpFacadeImpl implements FollowUpFacade {

  @Autowired
  private FollowUpDao followUpDao;

  @Override
  public Long addFollowUp (FollowUp followUp) {
    followUpDao.save (followUp);
    return followUp.getId ();
  }

  @Override
  public void updateFollowUp (FollowUp followUp) {
    followUpDao.save (followUp);
  }

  @Override
  public void deleteFollowUp (Long id) {
    followUpDao.delete (id);
  }

  @Override
  public FollowUp getFollowUpBId (Long id) {
    return followUpDao.getById (id);
  }
}
