package com.mftvanak.edusys.ws.phonebook.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.phonebook.PhoneEntrySearchPredicate;
import com.mftvanak.edusys.domain.entity.phonebook.FollowUp;
import com.mftvanak.edusys.domain.entity.phonebook.PhoneEntry;
import com.mftvanak.edusys.facade.phonebook.FollowUpFacade;
import com.mftvanak.edusys.facade.phonebook.PhoneEntryFacade;
import com.mftvanak.edusys.ws.phonebook.services.PhoneEntryService;


public class PhoneEntryServiceImpl implements PhoneEntryService {

  @Autowired
  private PhoneEntryFacade phoneEntryFacade;

  @Autowired
  private FollowUpFacade followUpFacade;

  @Override
  public Long addPhoneEntry (PhoneEntry phoneEntry) {
    return phoneEntryFacade.addPhoneEntry (phoneEntry);
  }

  @Override
  public void updatePhoneEntry (PhoneEntry phoneEntry) {
    phoneEntryFacade.updatePhoneEntry (phoneEntry);
  }

  @Override
  public void deletePhoneEntry (Long id) {
    phoneEntryFacade.deletePhoneEntry (id);
  }

  @Override
  public PhoneEntry getPhoneEntryById (Long id) {
    return phoneEntryFacade.getPhoneEntryById (id);
  }

  @Override
  public List < PhoneEntry > getPhoneEntriesByOwnerId (Long ownerId, int count) {
    if (count == 0) {
      return phoneEntryFacade.getPhoneEntriesByOwnerId (ownerId);
    } else {
      return phoneEntryFacade.getPhoneEntriesByOwnerId (ownerId, count);
    }
  }

  @Override
  public List < PhoneEntry > getPhoneEntriesByPredicate (PhoneEntrySearchPredicate predicate) {
    return phoneEntryFacade.getPhoneEntriesByPredicate (predicate);
  }

  @Override
  public List < FollowUp > getFollowUpsForPhoneEntry (Long phoneEntryId) {
    return phoneEntryFacade.getFollowUpsForPhoneEntry (phoneEntryId);
  }
}
