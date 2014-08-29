package org.labcrypto.edusys.facade.messaging;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.messaging.SendListItem;

public interface SendListFacade {

	Long addSendListItem(SendListItem sendListItem);

	void updateSendListItem(SendListItem sendListItem);

	List<SendListItem> getSendListItemsByOwnerId(long ownerId, int count);

	List<SendListItem> getNotSentYetSmsSendListItems();

}
