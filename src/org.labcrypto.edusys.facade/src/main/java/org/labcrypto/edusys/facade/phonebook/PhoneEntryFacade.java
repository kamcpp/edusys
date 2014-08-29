package org.labcrypto.edusys.facade.phonebook;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.phonebook.PhoneEntrySearchPredicate;
import org.labcrypto.edusys.domain.pg.entity.phonebook.FollowUp;
import org.labcrypto.edusys.domain.pg.entity.phonebook.PhoneEntry;

public interface PhoneEntryFacade {

	Long addPhoneEntry(PhoneEntry phoneEntry);

	void updatePhoneEntry(PhoneEntry phoneEntry);

	void deletePhoneEntry(Long id);

	PhoneEntry getPhoneEntryById(Long id);

	List<PhoneEntry> getPhoneEntries();

	List<PhoneEntry> getPhoneEntriesByOwnerId(Long ownerId);

	List<PhoneEntry> getPhoneEntriesByOwnerId(Long ownerId, int count);

	List<PhoneEntry> getPhoneEntriesByPredicate(
			PhoneEntrySearchPredicate predicate);

	List<FollowUp> getFollowUpsForPhoneEntry(Long phoneEntryId);
}
