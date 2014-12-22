package com.mftvanak.edusys.ws.phonebook.services;

import com.mftvanak.edusys.domain.entity.phonebook.FollowUp;


public interface FollowUpService {

  Long addFollowUp (FollowUp followUp);

  void updateFollowUp (FollowUp followUp);

  void deleteFollowUp (Long id);

  FollowUp getFollowUpById (Long id);

}
