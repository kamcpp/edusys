package com.mftvanak.edusys.facade.messaging.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.messaging.SendListItemDao;
import com.mftvanak.edusys.domain.entity.messaging.SendListItem;
import com.mftvanak.edusys.facade.messaging.SendListFacade;


public class SendListFacadeImpl implements SendListFacade {

  @Autowired
  private SendListItemDao sendListItemDao;

  @Override
  public Long addSendListItem (SendListItem sendListItem) {
    sendListItemDao.save (sendListItem);
    return sendListItem.getId ();
  }

  @Override
  public void updateSendListItem (SendListItem sendListItem) {
    sendListItemDao.save (sendListItem);
  }

  @Override
  public List < SendListItem > getSendListItemsByOwnerId (long ownerId, int count) {
    return sendListItemDao.getSendListItemsByOwnerId (ownerId, count);
  }

  @Override
  public List < SendListItem > getNotSentYetSmsSendListItems () {
    return sendListItemDao.getNotSentYetSmsSendListItems ();
  }
}
