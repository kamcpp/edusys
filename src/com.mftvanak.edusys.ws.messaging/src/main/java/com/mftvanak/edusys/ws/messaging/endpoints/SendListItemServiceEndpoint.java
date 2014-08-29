package com.mftvanak.edusys.ws.messaging.endpoints;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.domain.entity.messaging.SendListItem;
import com.mftvanak.edusys.domain.entity.messaging.SendListItem.SendListItemStatusType;
import com.mftvanak.edusys.domain.entity.messaging.SendRequest;
import com.mftvanak.edusys.domain.entity.personnel.Person;
import com.mftvanak.edusys.ws.exceptions.ClientInformationNeededException;
import com.mftvanak.edusys.ws.exceptions.PersonNotFoundException;
import com.mftvanak.edusys.ws.exceptions.SendRequestNotFoundException;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotActiveException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;
import com.mftvanak.edusys.ws.messaging.schemas.AddSendListItemRequest;
import com.mftvanak.edusys.ws.messaging.schemas.AddSendListItemResponse;
import com.mftvanak.edusys.ws.messaging.schemas.GetSendListItemsByOwnerIdRequest;
import com.mftvanak.edusys.ws.messaging.schemas.GetSendListItemsByOwnerIdResponse;
import com.mftvanak.edusys.ws.messaging.schemas.types.SendListItemType;
import com.mftvanak.edusys.ws.messaging.services.AuditService;
import com.mftvanak.edusys.ws.messaging.services.PersonnelService;
import com.mftvanak.edusys.ws.messaging.services.SecurityService;
import com.mftvanak.edusys.ws.messaging.services.SendListItemService;
import com.mftvanak.edusys.ws.messaging.services.SendRequestService;


@Endpoint
public class SendListItemServiceEndpoint {

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

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "AddSendListItemRequest")
  public @ResponsePayload
  AddSendListItemResponse handleAddSendListItemRequest (@RequestPayload AddSendListItemRequest request) throws UserIsNotAuthorizedException,
      TokenIsNotAuthenticatedException, UserIsNotActiveException, ClientInformationNeededException, PersonNotFoundException,
      SendRequestNotFoundException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null || request.getClientIpAddress () == null || request.getClientComputerName () == null
        || request.getApplicationName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 && request.getClientDateTimeMonth () >= 0 && request.getClientDateTimeDay () >= 0
        && request.getClientDateTimeHour () >= 0 && request.getClientDateTimeMinute () >= 0 && request.getClientDateTimeSecond () >= 0
        && request.getClientDateTimeMilliSecond () >= 0 && !request.getClientMacAddress ().isEmpty () && !request.getClientIpAddress ().isEmpty ()
        && !request.getClientComputerName ().isEmpty () && !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (token, "AddSendListItem", "SendListService", "0.0.1", "Adding sendListItem to: '"
          + request.getSendListItem ().getTo () + "' ...", "", clientDateTime.getMillis (), request.getClientMacAddress (),
          request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Person owner = personnelService.getPersonById (request.getSendListItem ().getOwnerId ());
    if (owner == null) {
      throw new PersonNotFoundException ();
    }
    SendRequest sendRequest = sendRequestService.getSendRequestById (request.getSendListItem ().getSendRequestId ());
    if (sendRequest == null) {
      throw new SendRequestNotFoundException ();
    }
    SendListItem sendListItem = new SendListItem ();
    sendListItem.setSendRequest (sendRequest);
    sendListItem.setBody (request.getSendListItem ().getBody ());
    sendListItem.setCancellationReason ("");

    DateTime clientSubmitDateTime = new DateTime (request.getSendListItem ().getClientSubmitDateTimeYear (), request.getSendListItem ()
        .getClientSubmitDateTimeMonth (), request.getSendListItem ().getClientSubmitDateTimeDay (), request.getSendListItem ()
        .getClientSubmitDateTimeHour (), request.getSendListItem ().getClientSubmitDateTimeMinute (), request.getSendListItem ()
        .getClientSubmitDateTimeSecond (), request.getSendListItem ().getClientSubmitDateTimeMilliSecond (), DateTimeZone.UTC);
    sendListItem.setClientSubmitDateTime (clientSubmitDateTime.getMillis ());

    sendListItem.setContentType (request.getSendListItem ().getContentType ());
    sendListItem.setDelivery (request.getSendListItem ().getDelivery ());
    sendListItem.setDescription (request.getSendListItem ().getDescription ());
    sendListItem.setFrom (request.getSendListItem ().getFrom ());
    sendListItem.setNumberOfTries (0);
    sendListItem.setOwner (owner);
    sendListItem.setRetryReason ("");
    sendListItem.setServerSubmitDateTime (new DateTime (DateTimeZone.UTC).getMillis ());
    sendListItem.setStatus (SendListItemStatusType.New.getCode ());
    sendListItem.setSubject (request.getSendListItem ().getSubject ());
    sendListItem.setTo (request.getSendListItem ().getTo ());
    sendListItem.setType (request.getSendListItem ().getType ());
    Long id = sendListItemService.addSendListItem (sendListItem);

    DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (), request.getClientDateTimeDay (),
        request.getClientDateTimeHour (), request.getClientDateTimeMinute (), request.getClientDateTimeSecond (),
        request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
    auditService.addAuditLog (token, "AddSendListItem", "SendListService", "0.0.1", "SendListItem is added with id '" + id + "'", "",
        clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
        request.getApplicationName ());

    AddSendListItemResponse response = new AddSendListItemResponse ();
    response.setSendListItemId (sendListItem.getId ());
    return response;
  }

  public @ResponseBody
  GetSendListItemsByOwnerIdResponse handleGetSendListItemsByOwnerIdRequest (@RequestPayload GetSendListItemsByOwnerIdRequest request)
      throws UserIsNotAuthorizedException, TokenIsNotAuthenticatedException, UserIsNotActiveException, ClientInformationNeededException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null || request.getClientIpAddress () == null || request.getClientComputerName () == null
        || request.getApplicationName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 && request.getClientDateTimeMonth () >= 0 && request.getClientDateTimeDay () >= 0
        && request.getClientDateTimeHour () >= 0 && request.getClientDateTimeMinute () >= 0 && request.getClientDateTimeSecond () >= 0
        && request.getClientDateTimeMilliSecond () >= 0 && !request.getClientMacAddress ().isEmpty () && !request.getClientIpAddress ().isEmpty ()
        && !request.getClientComputerName ().isEmpty () && !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (token, "GetSendListItemsByOwnerId", "SendListService", "0.0.1", "Getting all sendListItems for owner with id: '"
          + request.getOwnerId () + "' ...", "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (),
          request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    List < SendListItem > sendListItems = sendListItemService.getSendListItemsByOwnerId (request.getOwnerId (), request.getCount ());
    GetSendListItemsByOwnerIdResponse response = new GetSendListItemsByOwnerIdResponse ();
    for (SendListItem sendListItem : sendListItems) {
      SendListItemType sendListItemType = new SendListItemType ();
      sendListItemType.setSendRequestId (sendListItem.getSendRequest ().getId ());
      sendListItemType.setBody (sendListItem.getBody ());
      sendListItemType.setCancellationReason (sendListItem.getCancellationReason ());

      DateTime clientSubmitDateTime = new DateTime (sendListItem.getClientSubmitDateTime (), DateTimeZone.UTC);
      sendListItemType.setClientSubmitDateTimeYear (clientSubmitDateTime.getYear ());
      sendListItemType.setClientSubmitDateTimeMonth (clientSubmitDateTime.getMonthOfYear ());
      sendListItemType.setClientSubmitDateTimeDay (clientSubmitDateTime.getDayOfMonth ());
      sendListItemType.setClientSubmitDateTimeHour (clientSubmitDateTime.getHourOfDay ());
      sendListItemType.setClientSubmitDateTimeMinute (clientSubmitDateTime.getMinuteOfHour ());
      sendListItemType.setClientSubmitDateTimeSecond (clientSubmitDateTime.getSecondOfMinute ());
      sendListItemType.setClientSubmitDateTimeMilliSecond (clientSubmitDateTime.getMillisOfSecond ());

      sendListItemType.setContentType (sendListItem.getContentType ());
      sendListItemType.setDelivery (sendListItem.getDelivery ());
      sendListItemType.setDescription (sendListItem.getDescription ());
      sendListItemType.setFrom (sendListItem.getFrom ());
      sendListItemType.setId (sendListItem.getId ());

      if (sendListItem.getLastTryDateTime () != null) {
        DateTime lastTryDateTime = new DateTime (sendListItem.getClientSubmitDateTime (), DateTimeZone.UTC);
        sendListItemType.setLastTryDateTimeYear (lastTryDateTime.getYear ());
        sendListItemType.setLastTryDateTimeMonth (lastTryDateTime.getMonthOfYear ());
        sendListItemType.setLastTryDateTimeDay (lastTryDateTime.getDayOfMonth ());
        sendListItemType.setLastTryDateTimeHour (lastTryDateTime.getHourOfDay ());
        sendListItemType.setLastTryDateTimeMinute (lastTryDateTime.getMinuteOfHour ());
        sendListItemType.setLastTryDateTimeSecond (lastTryDateTime.getSecondOfMinute ());
        sendListItemType.setLastTryDateTimeMilliSecond (lastTryDateTime.getMillisOfSecond ());
      }

      sendListItemType.setNumberOfTries (sendListItem.getNumberOfTries ());
      sendListItemType.setOwnerFullName (sendListItem.getOwner ().getPersianName () + " " + sendListItem.getOwner ().getPersianFamily ());
      sendListItemType.setOwnerId (sendListItem.getOwner ().getId ());
      sendListItemType.setRetryReason (sendListItem.getRetryReason ());

      DateTime serverSubmitDateTime = new DateTime (sendListItem.getServerSubmitDateTime (), DateTimeZone.UTC);
      sendListItemType.setServerSubmitDateTimeYear (serverSubmitDateTime.getYear ());
      sendListItemType.setServerSubmitDateTimeMonth (serverSubmitDateTime.getMonthOfYear ());
      sendListItemType.setServerSubmitDateTimeDay (serverSubmitDateTime.getDayOfMonth ());
      sendListItemType.setServerSubmitDateTimeHour (serverSubmitDateTime.getHourOfDay ());
      sendListItemType.setServerSubmitDateTimeMinute (serverSubmitDateTime.getMinuteOfHour ());
      sendListItemType.setServerSubmitDateTimeSecond (serverSubmitDateTime.getSecondOfMinute ());
      sendListItemType.setServerSubmitDateTimeMilliSecond (serverSubmitDateTime.getMillisOfSecond ());

      sendListItemType.setStatus (sendListItem.getStatus ());
      sendListItemType.setSubject (sendListItem.getSubject ());
      sendListItemType.setTo (sendListItem.getTo ());
      sendListItemType.setType (sendListItem.getType ());

      response.getSendListItems ().add (sendListItemType);
    }
    return response;
  }
}
