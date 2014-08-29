package org.labcrypto.edusys.facade.messaging.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.messaging.SendRequestDao;
import org.labcrypto.edusys.domain.pg.entity.messaging.SendRequest;
import org.labcrypto.edusys.facade.messaging.SendRequestFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class SendRequestFacadeImpl implements SendRequestFacade {

	@Autowired
	private SendRequestDao sendRequestDao;

	@Override
	public long addSendRequest(SendRequest sendRequest) {
		sendRequestDao.save(sendRequest);
		return sendRequest.getId();
	}

	@Override
	public void updateSendRequest(SendRequest sendRequest) {
		sendRequestDao.save(sendRequest);
	}

	@Override
	public void deleteSendRequest(long id) {
		sendRequestDao.delete(id);
	}

	@Override
	public SendRequest getSendRequestById(long id) {
		return sendRequestDao.getById(id);
	}

	@Override
	public List<SendRequest> getSendRequests() {
		return sendRequestDao.getAll();
	}

	@Override
	public List<SendRequest> getSendRequestsByOwnerId(long ownerId, int count) {
		return sendRequestDao.getSendRequestsByOwnerId(ownerId, count);
	}
}
