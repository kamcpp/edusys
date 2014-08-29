package com.mftvanak.edusys.ws.phonebook.services;

import java.util.List;

import com.mftvanak.edusys.domain.dao.phonebook.PhoneEntrySearchPredicate;
import com.mftvanak.edusys.domain.entity.phonebook.FollowUp;
import com.mftvanak.edusys.domain.entity.phonebook.PhoneEntry;


public interface PhoneEntryService {

  Long addPhoneEntry (PhoneEntry phoneEntry);

  void updatePhoneEntry (PhoneEntry phoneEntry);

  void deletePhoneEntry (Long id);

  PhoneEntry getPhoneEntryById (Long id);

  List < PhoneEntry > getPhoneEntriesByOwnerId (Long ownerId, int count);
  
  List < PhoneEntry > getPhoneEntriesByPredicate (PhoneEntrySearchPredicate predicate);

  List < FollowUp > getFollowUpsForPhoneEntry (Long phoneEntryId);

}
