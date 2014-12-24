package org.labcrypto.edusys.domain.jpa.dao.messaging;

import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.messaging.MessageTemplate;

import java.util.List;

public interface MessageTemplateDao extends EntityDao<MessageTemplate> {

    List< MessageTemplate > getMessageTemplatesByOwnerId (long ownerId, int count);
}
