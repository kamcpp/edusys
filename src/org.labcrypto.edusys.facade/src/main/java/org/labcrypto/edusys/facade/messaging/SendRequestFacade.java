package org.labcrypto.edusys.facade.messaging;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.messaging.SendRequest;

public interface SendRequestFacade {

	long addSendRequest(SendRequest sendRequest);

	void updateSendRequest(SendRequest sendRequest);

	void deleteSendRequest(long id);

	SendRequest getSendRequestById(long id);

	List<SendRequest> getSendRequests();

	List<SendRequest> getSendRequestsByOwnerId(long ownerId, int count);

}
