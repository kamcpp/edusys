package org.labcrypto.edusys.domain.jpa.dao.messaging;

import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.messaging.MessageTemplate;

import java.util.List;

public class MessageTemplateDaoImpl extends JpaEntityDao<MessageTemplate> implements MessageTemplateDao {

    public MessageTemplateDaoImpl() {
        super(MessageTemplate.class);
    }

    @Override
    public List<MessageTemplate> getMessageTemplatesByOwnerId(long ownerId, int count) {
        return entityManager.createQuery(
                "from MessageTemplate as mt where mt.owner.id = :ownerId order by mt.submitDateTime desc", MessageTemplate.class)
                .setParameter("ownerId", ownerId)
                .setMaxResults(count)
                .getResultList();
    }
}
