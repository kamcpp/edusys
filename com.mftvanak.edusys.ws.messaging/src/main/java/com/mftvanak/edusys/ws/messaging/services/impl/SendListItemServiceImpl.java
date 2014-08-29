package com.mftvanak.edusys.ws.messaging.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.messaging.SendListItem;
import com.mftvanak.edusys.facade.messaging.SendListFacade;
import com.mftvanak.edusys.ws.messaging.services.SendListItemService;


public class SendListItemServiceImpl implements SendListItemService {

  @Autowired
  private SendListFacade sendListFacade;

  @Override
  public Long addSendListItem (SendListItem sendListItem) {
    return sendListFacade.addSendListItem (sendListItem);
  }

  @Override
  public List < SendListItem > getSendListItemsByOwnerId (long ownerId, int count) {
    return sendListFacade.getSendListItemsByOwnerId (ownerId, count);
  }
}
