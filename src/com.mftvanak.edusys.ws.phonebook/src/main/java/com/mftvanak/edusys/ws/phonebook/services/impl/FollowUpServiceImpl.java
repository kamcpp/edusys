package com.mftvanak.edusys.ws.phonebook.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.phonebook.FollowUp;
import com.mftvanak.edusys.facade.phonebook.FollowUpFacade;
import com.mftvanak.edusys.ws.phonebook.services.FollowUpService;


public class FollowUpServiceImpl implements FollowUpService {

  @Autowired
  private FollowUpFacade followUpFacade;

  @Override
  public Long addFollowUp (FollowUp followUp) {
    return followUpFacade.addFollowUp (followUp);
  }

  @Override
  public void updateFollowUp (FollowUp followUp) {
    followUpFacade.updateFollowUp (followUp);
  }

  @Override
  public void deleteFollowUp (Long id) {
    followUpFacade.deleteFollowUp (id);
  }

  @Override
  public FollowUp getFollowUpById (Long id) {
    return followUpFacade.getFollowUpBId (id);
  }
}
