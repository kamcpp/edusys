package com.mftvanak.edusys.facade.phonebook;

import com.mftvanak.edusys.domain.entity.phonebook.FollowUp;


public interface FollowUpFacade {

  Long addFollowUp (FollowUp followUp);

  void updateFollowUp (FollowUp followUp);

  void deleteFollowUp (Long id);

  FollowUp getFollowUpBId (Long id);
}
