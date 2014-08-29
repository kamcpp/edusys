package org.labcrypto.edusys.facade.phonebook;

import org.labcrypto.edusys.domain.pg.entity.phonebook.FollowUp;

public interface FollowUpFacade {

	Long addFollowUp(FollowUp followUp);

	void updateFollowUp(FollowUp followUp);

	void deleteFollowUp(Long id);

	FollowUp getFollowUpBId(Long id);
}
