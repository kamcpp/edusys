package org.labcrypto.edusys.domain.jpa.dao.phonebook;

import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.phonebook.FollowUp;

import java.util.List;

public interface FollowUpDao extends EntityDao<FollowUp> {

    List< FollowUp > getFollowUpsByPhoneEntry (Long phoneEntryId);
}
