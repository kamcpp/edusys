package com.mftvanak.edusys.facade.messaging.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.common.messaging.SmsSender;
import com.mftvanak.edusys.facade.messaging.MessagingFacade;


public class MessagingFacadeImpl implements MessagingFacade {

  @Autowired
  private SmsSender smsSender;
  
  @Override
  public String sendSms (String to, String body) {
    return smsSender.send(to, body);
  }

  @Override
  public String[] sendSms (String[] tos, String body) {
    return smsSender.send(tos, body);
  }
}
