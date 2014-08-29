package com.mftvanak.edusys.engine.scheduler.messaging;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.messaging.SendListItem;
import com.mftvanak.edusys.engine.scheduler.Task;
import com.mftvanak.edusys.facade.messaging.MessagingFacade;
import com.mftvanak.edusys.facade.messaging.SendListFacade;


public class SmsSenderTask implements Task {

  @Autowired
  private MessagingFacade messagingFacade;

  @Autowired
  private SendListFacade sendListFacade;

  private String name;

  @Override
  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  @Override
  public void run () {
    @SuppressWarnings ("unused")
    List < SendListItem > sendListItems = sendListFacade
        .getNotSentYetSmsSendListItems ();
  }
}
