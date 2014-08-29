package com.mftvanak.edusys.facade.messaging;

import java.util.List;

import com.mftvanak.edusys.domain.entity.messaging.SendListItem;


public interface SendListFacade {

  Long addSendListItem (SendListItem sendListItem);

  void updateSendListItem (SendListItem sendListItem);

  List < SendListItem > getSendListItemsByOwnerId (long ownerId, int count);

  List < SendListItem > getNotSentYetSmsSendListItems ();

}
