package com.mftvanak.edusys.ws.messaging.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.messaging.SendRequest;
import com.mftvanak.edusys.facade.messaging.SendRequestFacade;
import com.mftvanak.edusys.ws.messaging.services.SendRequestService;


public class SendRequestServiceImpl implements SendRequestService {

  @Autowired
  private SendRequestFacade sendRequestFacade;

  @Override
  public long addSendRequest (SendRequest sendRequest) {
    return sendRequestFacade.addSendRequest (sendRequest);
  }

  @Override
  public void updateSendRequest (SendRequest sendRequest) {
    sendRequestFacade.updateSendRequest (sendRequest);
  }

  @Override
  public void deleteSendRequest (long id) {
    sendRequestFacade.deleteSendRequest (id);
  }

  @Override
  public SendRequest getSendRequestById (long id) {
    return sendRequestFacade.getSendRequestById (id);
  }

  @Override
  public List < SendRequest > getSendRequests () {
    return sendRequestFacade.getSendRequests ();
  }

  @Override
  public List < SendRequest > getSendRequestByOwnerId (long ownerId, int count) {
    return sendRequestFacade.getSendRequestsByOwnerId (ownerId, count);
  }
}
