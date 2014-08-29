package com.mftvanak.edusys.ws.messaging.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.messaging.MessageTemplate;
import com.mftvanak.edusys.facade.messaging.MessageTemplateFacade;
import com.mftvanak.edusys.ws.messaging.services.MessageTemplateService;


public class MessageTemplateServiceImpl implements MessageTemplateService {

  @Autowired
  private MessageTemplateFacade messageTemplateFacade;

  @Override
  public long addMessageTemplate (MessageTemplate messageTemplate) {
    return messageTemplateFacade.addMessageTemplate (messageTemplate);
  }

  @Override
  public void updateMessageTemplate (MessageTemplate messageTemplate) {
    messageTemplateFacade.updateMessageTemplate (messageTemplate);
  }

  @Override
  public void deleteMessageTemplate (long id) {
    messageTemplateFacade.deleteMessageTemplate (id);
  }

  @Override
  public MessageTemplate getMessageTemplateById (long id) {
    return messageTemplateFacade.getMessageTemplateById (id);
  }

  @Override
  public List < MessageTemplate > getMessageTemplates () {
    return messageTemplateFacade.getMessageTemplates ();
  }

  @Override
  public List < MessageTemplate > getMessageTemplatesByOwnerId (long ownerId, int count) {
    return messageTemplateFacade.getMessageTemplatesByOwnerId (ownerId, count);
  }
}
