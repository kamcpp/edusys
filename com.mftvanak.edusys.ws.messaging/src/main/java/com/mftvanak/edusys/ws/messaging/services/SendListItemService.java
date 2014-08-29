package com.mftvanak.edusys.ws.messaging.services;

import java.util.List;

import com.mftvanak.edusys.domain.entity.messaging.SendListItem;


public interface SendListItemService {

  Long addSendListItem (SendListItem sendListItem);

  List < SendListItem > getSendListItemsByOwnerId (long ownerId, int count);

}
