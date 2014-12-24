package org.labcrypto.edusys.domain.jpa.dao.messaging;

import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.messaging.SendListItem;

import java.util.List;

public interface SendListItemDao extends EntityDao<SendListItem> {

    List<SendListItem> getSendListItemsByOwnerId(long ownerId, int count);

    List<SendListItem> getSendListItemsByOwnerId(long ownerId);

    List<SendListItem> getNotSentYetSmsSendListItems();
}
