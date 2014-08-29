package com.mftvanak.edusys.facade.messaging.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.messaging.MessageTemplateDao;
import com.mftvanak.edusys.domain.entity.messaging.MessageTemplate;
import com.mftvanak.edusys.facade.messaging.MessageTemplateFacade;


public class MessageTemplateFacadeImpl implements MessageTemplateFacade {

  @Autowired
  private MessageTemplateDao messageTemplateDao;

  @Override
  public long addMessageTemplate (MessageTemplate messageTemplate) {
    messageTemplateDao.save (messageTemplate);
    return messageTemplate.getId ();
  }

  @Override
  public void updateMessageTemplate (MessageTemplate messageTemplate) {
    messageTemplateDao.save (messageTemplate);
  }

  @Override
  public void deleteMessageTemplate (long id) {
    messageTemplateDao.delete (id);
  }

  @Override
  public MessageTemplate getMessageTemplateById (long id) {
    return messageTemplateDao.getById (id);
  }

  @Override
  public List < MessageTemplate > getMessageTemplates () {
    return messageTemplateDao.getAll ();
  }

  @Override
  public List < MessageTemplate > getMessageTemplatesByOwnerId (long ownerId, int count) {
    return messageTemplateDao.getMessageTemplatesByOwnerId (ownerId, count);
  }
}
