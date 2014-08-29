package com.mftvanak.edusys.ws.messaging.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.facade.messaging.SmsFacade;
import com.mftvanak.edusys.ws.messaging.services.SmsService;


public class SmsServiceImpl implements SmsService {

  @Autowired
  private SmsFacade smsFacade;

  @Override
  public long getCurrentBalance () {
    return smsFacade.getCurrentBalance ();
  }
}
