package com.mftvanak.edusys.ws.messaging.services;

import java.util.List;

import com.mftvanak.edusys.domain.entity.messaging.MessageTemplate;


public interface MessageTemplateService {

  long addMessageTemplate (MessageTemplate messageTemplate);

  void updateMessageTemplate (MessageTemplate messageTemplate);

  void deleteMessageTemplate (long id);

  MessageTemplate getMessageTemplateById (long id);

  List < MessageTemplate > getMessageTemplates ();

  List < MessageTemplate > getMessageTemplatesByOwnerId (long ownerId, int count);
}
