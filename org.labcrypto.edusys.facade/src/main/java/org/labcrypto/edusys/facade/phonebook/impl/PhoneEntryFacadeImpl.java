package org.labcrypto.edusys.facade.phonebook.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.phonebook.FollowUpDao;
import org.labcrypto.edusys.domain.pg.dao.phonebook.PhoneEntryDao;
import org.labcrypto.edusys.domain.pg.dao.phonebook.PhoneEntrySearchPredicate;
import org.labcrypto.edusys.domain.pg.entity.phonebook.FollowUp;
import org.labcrypto.edusys.domain.pg.entity.phonebook.PhoneEntry;
import org.labcrypto.edusys.facade.phonebook.PhoneEntryFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class PhoneEntryFacadeImpl implements PhoneEntryFacade {

	@Autowired
	private PhoneEntryDao phoneEntryDao;

	@Autowired
	private FollowUpDao followUpDao;

	@Override
	public Long addPhoneEntry(PhoneEntry phoneEntry) {
		phoneEntryDao.save(phoneEntry);
		return phoneEntry.getId();
	}

	@Override
	public void updatePhoneEntry(PhoneEntry phoneEntry) {
		phoneEntryDao.save(phoneEntry);
	}

	@Override
	public void deletePhoneEntry(Long id) {
		phoneEntryDao.delete(id);
	}

	@Override
	public PhoneEntry getPhoneEntryById(Long id) {
		return phoneEntryDao.getById(id);
	}

	@Override
	public List<PhoneEntry> getPhoneEntriesByOwnerId(Long ownerId) {
		return phoneEntryDao.getPhoneEntriesByOwnerId(ownerId);
	}

	@Override
	public List<PhoneEntry> getPhoneEntriesByOwnerId(Long ownerId, int count) {
		return phoneEntryDao.getPhoneEntriesByOwnerId(ownerId, count);
	}

	@Override
	public List<PhoneEntry> getPhoneEntries() {
		return phoneEntryDao.getAll();
	}

	@Override
	public List<PhoneEntry> getPhoneEntriesByPredicate(
			PhoneEntrySearchPredicate predicate) {
		return phoneEntryDao.getPhoneEntriesByPredicate(predicate);
	}

	@Override
	public List<FollowUp> getFollowUpsForPhoneEntry(Long phoneEntryId) {
		return followUpDao.getFollowUpsByPhoneEntry(phoneEntryId);
	}
}
