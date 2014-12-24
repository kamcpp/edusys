package org.labcrypto.edusys.domain.jpa.dao.messaging;

import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.messaging.SendListItem;

import java.util.List;

public class SendListItemDaoImpl extends JpaEntityDao<SendListItem> implements SendListItemDao {

    public SendListItemDaoImpl() {
        super(SendListItem.class);
    }

    @Override
    public List<SendListItem> getSendListItemsByOwnerId(long ownerId, int count) {
        return entityManager.createQuery(
                "from SendListItem as sli where sli.owner.id = :ownerId order by sli.serverSubmitDateTime desc", SendListItem.class)
                .setParameter("ownerId", ownerId)
                .setMaxResults(count)
                .getResultList();
    }

    @Override
    public List<SendListItem> getSendListItemsByOwnerId(long ownerId) {
        return getSendListItemsByOwnerId(ownerId, 0);
    }

    @Override
    public List<SendListItem> getNotSentYetSmsSendListItems() {
        return entityManager.createQuery(
                "from SendListItem as sli where sli.delivery = 1 and sli.type = 1 and sli.status < 3 order by sli.serverSubmitDateTime, sli.status desc", SendListItem.class)
                .getResultList();
    }
}
