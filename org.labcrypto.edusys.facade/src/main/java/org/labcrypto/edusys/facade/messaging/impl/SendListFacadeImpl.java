package org.labcrypto.edusys.facade.messaging.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.messaging.SendListItemDao;
import org.labcrypto.edusys.domain.pg.entity.messaging.SendListItem;
import org.labcrypto.edusys.facade.messaging.SendListFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class SendListFacadeImpl implements SendListFacade {

	@Autowired
	private SendListItemDao sendListItemDao;

	@Override
	public Long addSendListItem(SendListItem sendListItem) {
		sendListItemDao.save(sendListItem);
		return sendListItem.getId();
	}

	@Override
	public void updateSendListItem(SendListItem sendListItem) {
		sendListItemDao.save(sendListItem);
	}

	@Override
	public List<SendListItem> getSendListItemsByOwnerId(long ownerId, int count) {
		return sendListItemDao.getSendListItemsByOwnerId(ownerId, count);
	}

	@Override
	public List<SendListItem> getNotSentYetSmsSendListItems() {
		return sendListItemDao.getNotSentYetSmsSendListItems();
	}
}
