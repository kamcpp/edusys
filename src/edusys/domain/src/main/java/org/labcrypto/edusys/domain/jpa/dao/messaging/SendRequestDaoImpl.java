package org.labcrypto.edusys.domain.jpa.dao.messaging;

import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.messaging.SendRequest;

import java.util.List;

public class SendRequestDaoImpl extends JpaEntityDao<SendRequest> implements SendRequestDao {

    public SendRequestDaoImpl() {
        super(SendRequest.class);
    }

    @Override
    public List<SendRequest> getSendRequestsByOwnerId(long ownerId, int count) {
        return entityManager.createQuery(
                "from SendRequest sr where sr.owner.id = :ownerId order by sr.submitDateTime desc", SendRequest.class)
                .setParameter("ownerId", ownerId)
                .setMaxResults(count)
                .getResultList();
    }
}
