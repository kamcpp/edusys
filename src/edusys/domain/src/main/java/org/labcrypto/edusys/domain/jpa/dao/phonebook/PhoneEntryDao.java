package org.labcrypto.edusys.domain.jpa.dao.phonebook;

import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.phonebook.PhoneEntry;

import java.util.List;

public interface PhoneEntryDao extends EntityDao<PhoneEntry> {

    List< PhoneEntry > getPhoneEntriesByOwnerId (Long ownerId);

    List < PhoneEntry > getPhoneEntriesByOwnerId (Long ownerId, int count);

    List < PhoneEntry > getPhoneEntriesByPredicate (PhoneEntrySearchPredicate predicate);
}
