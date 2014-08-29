package com.mftvanak.edusys.ws.messaging.endpoints;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.domain.entity.messaging.SendRequest;
import com.mftvanak.edusys.domain.entity.personnel.Person;
import com.mftvanak.edusys.ws.exceptions.ClientInformationNeededException;
import com.mftvanak.edusys.ws.exceptions.PersonNotFoundException;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotActiveException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;
import com.mftvanak.edusys.ws.messaging.schemas.AddSendRequestRequest;
import com.mftvanak.edusys.ws.messaging.schemas.AddSendRequestResponse;
import com.mftvanak.edusys.ws.messaging.schemas.DeleteSendRequestRequest;
import com.mftvanak.edusys.ws.messaging.schemas.DeleteSendRequestResponse;
import com.mftvanak.edusys.ws.messaging.schemas.GetSendRequestByIdRequest;
import com.mftvanak.edusys.ws.messaging.schemas.GetSendRequestByIdResponse;
import com.mftvanak.edusys.ws.messaging.schemas.GetSendRequestsByOwnerIdRequest;
import com.mftvanak.edusys.ws.messaging.schemas.GetSendRequestsByOwnerIdResponse;
import com.mftvanak.edusys.ws.messaging.schemas.GetSendRequestsRequest;
import com.mftvanak.edusys.ws.messaging.schemas.GetSendRequestsResponse;
import com.mftvanak.edusys.ws.messaging.schemas.UpdateSendRequestRequest;
import com.mftvanak.edusys.ws.messaging.schemas.UpdateSendRequestResponse;
import com.mftvanak.edusys.ws.messaging.services.AuditService;
import com.mftvanak.edusys.ws.messaging.services.PersonnelService;
import com.mftvanak.edusys.ws.messaging.services.SecurityService;
import com.mftvanak.edusys.ws.messaging.services.SendListItemService;
import com.mftvanak.edusys.ws.messaging.services.SendRequestService;


@Endpoint
public class SendRequestServiceEndpoint {

  @Autowired
  private SecurityService securityService;

  @Autowired
  private AuditService auditService;

  @Autowired
  private PersonnelService personnelService;

  @Autowired
  private SendListItemService sendListItemService;

  @Autowired
  private SendRequestService sendRequestService;

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "AddSendRequestRequest")
  public @ResponsePayload
  AddSendRequestResponse handleAddSendRequestRequest (@RequestPayload AddSendRequestRequest request) throws UserIsNotAuthorizedException,
      TokenIsNotAuthenticatedException, UserIsNotActiveException, ClientInformationNeededException, PersonNotFoundException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null ||
        request.getClientIpAddress () == null ||
        request.getClientComputerName () == null ||
        request.getApplicationName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 &&
        request.getClientDateTimeMonth () >= 0 &&
        request.getClientDateTimeDay () >= 0 &&
        request.getClientDateTimeHour () >= 0 &&
        request.getClientDateTimeMinute () >= 0 &&
        request.getClientDateTimeSecond () >= 0 &&
        request.getClientDateTimeMilliSecond () >= 0 &&
        !request.getClientMacAddress ().isEmpty () &&
        !request.getClientIpAddress ().isEmpty () &&
        !request.getClientComputerName ().isEmpty () &&
        !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (token, "AddSendRequest", "SendRequestService", "0.0.1", "Adding sendRequest ...", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Person owner = personnelService.getPersonById (request.getSendRequest ().getOwnerId ());
    if (owner == null) {
      throw new PersonNotFoundException ();
    }
    SendRequest sendRequest = new SendRequest ();
    sendRequest.setDescription (request.getSendRequest ().getDescription ());
    sendRequest.setName (request.getSendRequest ().getName ());
    sendRequest.setNumberOfDeliveredSendListItems (0);
    sendRequest.setNumberOfSendListItems (0);
    sendRequest.setOwner (owner);
    sendRequest.setSubmitDateTime (DateTime.now (DateTimeZone.UTC).getMillis ());

    Long id = sendRequestService.addSendRequest (sendRequest);
    DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (), request.getClientDateTimeDay (),
        request.getClientDateTimeHour (), request.getClientDateTimeMinute (), request.getClientDateTimeSecond (),
        request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
    auditService.addAuditLog (token, "AddSendRequest", "SendRequestService", "0.0.1", "SendRequest is added with id '" + id + "'", "",
        clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
        request.getApplicationName ());

    AddSendRequestResponse response = new AddSendRequestResponse ();
    response.setSendRequestId (id);
    return response;
  }

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "UpdateSendRequestRequest")
  public @ResponsePayload
  UpdateSendRequestResponse handleUpdateSendRequestRequest (@RequestPayload UpdateSendRequestRequest request) {
    UpdateSendRequestResponse response = new UpdateSendRequestResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "DeleteSendRequestRequest")
  public @ResponsePayload
  DeleteSendRequestResponse handleDeleteSendRequestRequest (@RequestPayload DeleteSendRequestRequest request) {
    DeleteSendRequestResponse response = new DeleteSendRequestResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "GetSendRequestByIdRequest")
  public @ResponsePayload
  GetSendRequestByIdResponse handleGetSendRequestByIdRequest (@RequestPayload GetSendRequestByIdRequest request) {
    GetSendRequestByIdResponse response = new GetSendRequestByIdResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "GetSendRequestsRequest")
  public @ResponsePayload
  GetSendRequestsResponse handleGetSendRequestsRequest (@RequestPayload GetSendRequestsRequest request) {
    GetSendRequestsResponse response = new GetSendRequestsResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "GetSendRequestByOwnerIdRequest")
  public @ResponsePayload
  GetSendRequestsByOwnerIdResponse handleGetSendRequestByOwnerIdRequest (@RequestPayload GetSendRequestsByOwnerIdRequest request) {
    GetSendRequestsByOwnerIdResponse response = new GetSendRequestsByOwnerIdResponse ();
    return response;
  }
}
