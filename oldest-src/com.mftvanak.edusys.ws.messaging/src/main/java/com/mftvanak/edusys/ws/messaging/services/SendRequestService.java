package com.mftvanak.edusys.ws.messaging.services;

import java.util.List;

import com.mftvanak.edusys.domain.entity.messaging.SendRequest;


public interface SendRequestService {

  long addSendRequest (SendRequest sendRequest);

  void updateSendRequest (SendRequest sendRequest);

  void deleteSendRequest (long id);

  SendRequest getSendRequestById (long id);

  List < SendRequest > getSendRequests ();

  List < SendRequest > getSendRequestByOwnerId (long ownerId, int count);

}
