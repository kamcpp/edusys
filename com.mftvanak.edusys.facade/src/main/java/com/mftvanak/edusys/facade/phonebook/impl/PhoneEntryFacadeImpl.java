package com.mftvanak.edusys.facade.phonebook.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.phonebook.FollowUpDao;
import com.mftvanak.edusys.domain.dao.phonebook.PhoneEntryDao;
import com.mftvanak.edusys.domain.entity.phonebook.FollowUp;
import com.mftvanak.edusys.domain.entity.phonebook.PhoneEntry;
import com.mftvanak.edusys.domain.dao.phonebook.PhoneEntrySearchPredicate;
import com.mftvanak.edusys.facade.phonebook.PhoneEntryFacade;


public class PhoneEntryFacadeImpl implements PhoneEntryFacade {

  @Autowired
  private PhoneEntryDao phoneEntryDao;

  @Autowired
  private FollowUpDao followUpDao;

  @Override
  public Long addPhoneEntry (PhoneEntry phoneEntry) {
    phoneEntryDao.save (phoneEntry);
    return phoneEntry.getId ();
  }

  @Override
  public void updatePhoneEntry (PhoneEntry phoneEntry) {
    phoneEntryDao.save (phoneEntry);
  }

  @Override
  public void deletePhoneEntry (Long id) {
    phoneEntryDao.delete (id);
  }

  @Override
  public PhoneEntry getPhoneEntryById (Long id) {
    return phoneEntryDao.getById (id);
  }

  @Override
  public List < PhoneEntry > getPhoneEntriesByOwnerId (Long ownerId) {
    return phoneEntryDao.getPhoneEntriesByOwnerId (ownerId);
  }

  @Override
  public List < PhoneEntry > getPhoneEntriesByOwnerId (Long ownerId, int count) {
    return phoneEntryDao.getPhoneEntriesByOwnerId (ownerId, count);
  }

  @Override
  public List < PhoneEntry > getPhoneEntries () {
    return phoneEntryDao.getAll ();
  }

  @Override
  public List < PhoneEntry > getPhoneEntriesByPredicate (PhoneEntrySearchPredicate predicate) {
    return phoneEntryDao.getPhoneEntriesByPredicate (predicate);
  }

  @Override
  public List < FollowUp > getFollowUpsForPhoneEntry (Long phoneEntryId) {
    return followUpDao.getFollowUpsByPhoneEntry (phoneEntryId);
  }
}
