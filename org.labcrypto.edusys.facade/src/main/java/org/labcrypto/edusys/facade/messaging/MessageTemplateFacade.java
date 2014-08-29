package org.labcrypto.edusys.facade.messaging;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.messaging.MessageTemplate;

public interface MessageTemplateFacade {

	long addMessageTemplate(MessageTemplate messageTemplate);

	void updateMessageTemplate(MessageTemplate messageTemplate);

	void deleteMessageTemplate(long id);

	MessageTemplate getMessageTemplateById(long id);

	List<MessageTemplate> getMessageTemplates();

	List<MessageTemplate> getMessageTemplatesByOwnerId(long ownerId, int count);

}
