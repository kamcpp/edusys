package com.mftvanak.edusys.ws.messaging.endpoints;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.domain.entity.messaging.MessageTemplate;
import com.mftvanak.edusys.domain.entity.personnel.Person;
import com.mftvanak.edusys.ws.exceptions.ClientInformationNeededException;
import com.mftvanak.edusys.ws.exceptions.MessageTemplateNotFoundException;
import com.mftvanak.edusys.ws.exceptions.PersonNotFoundException;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotActiveException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;
import com.mftvanak.edusys.ws.messaging.schemas.AddMessageTemplateRequest;
import com.mftvanak.edusys.ws.messaging.schemas.AddMessageTemplateResponse;
import com.mftvanak.edusys.ws.messaging.schemas.DeleteMessageTemplateRequest;
import com.mftvanak.edusys.ws.messaging.schemas.DeleteMessageTemplateResponse;
import com.mftvanak.edusys.ws.messaging.schemas.GetMessageTemplateByIdRequest;
import com.mftvanak.edusys.ws.messaging.schemas.GetMessageTemplateByIdResponse;
import com.mftvanak.edusys.ws.messaging.schemas.GetMessageTemplatesByOwnerIdRequest;
import com.mftvanak.edusys.ws.messaging.schemas.GetMessageTemplatesByOwnerIdResponse;
import com.mftvanak.edusys.ws.messaging.schemas.GetMessageTemplatesRequest;
import com.mftvanak.edusys.ws.messaging.schemas.GetMessageTemplatesResponse;
import com.mftvanak.edusys.ws.messaging.schemas.UpdateMessageTemplateRequest;
import com.mftvanak.edusys.ws.messaging.schemas.UpdateMessageTemplateResponse;
import com.mftvanak.edusys.ws.messaging.schemas.types.MessageTemplateType;
import com.mftvanak.edusys.ws.messaging.services.AuditService;
import com.mftvanak.edusys.ws.messaging.services.MessageTemplateService;
import com.mftvanak.edusys.ws.messaging.services.PersonnelService;
import com.mftvanak.edusys.ws.messaging.services.SecurityService;


@Endpoint
public class MessageTemplateServiceEndpoint {

  @Autowired
  private SecurityService securityService;

  @Autowired
  private AuditService auditService;

  @Autowired
  private PersonnelService personnelService;

  @Autowired
  private MessageTemplateService messageTemplateService;

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "AddMessageTemplateRequest")
  public @ResponsePayload
  AddMessageTemplateResponse handleAddMessageTemplateRequest (@RequestPayload AddMessageTemplateRequest request)
      throws UserIsNotAuthorizedException, TokenIsNotAuthenticatedException, UserIsNotActiveException, ClientInformationNeededException,
      PersonNotFoundException {
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
      auditService.addAuditLog (token, "AddMessageTemplate", "MessageTemplateService", "0.0.1", "Adding messageTemplate ...", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Person owner = personnelService.getPersonById (request.getMessageTemplate ().getOwnerId ());
    if (owner == null) {
      throw new PersonNotFoundException ();
    }
    MessageTemplate messageTemplate = new MessageTemplate ();
    messageTemplate.setDescription (request.getMessageTemplate ().getDescription ());
    messageTemplate.setName (request.getMessageTemplate ().getName ());
    messageTemplate.setText (request.getMessageTemplate ().getText ());
    messageTemplate.setType (request.getMessageTemplate ().getType ());
    messageTemplate.setOwner (owner);
    messageTemplate.setSubmitDateTime (DateTime.now (DateTimeZone.UTC).getMillis ());

    Long id = messageTemplateService.addMessageTemplate (messageTemplate);
    DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (), request.getClientDateTimeDay (),
        request.getClientDateTimeHour (), request.getClientDateTimeMinute (), request.getClientDateTimeSecond (),
        request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
    auditService.addAuditLog (token, "AddMessageTemplate", "MessageTemplateService", "0.0.1", "MessageTemplate is added with id '" + id + "'", "",
        clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
        request.getApplicationName ());

    AddMessageTemplateResponse response = new AddMessageTemplateResponse ();
    response.setMessageTemplateId (id);
    return response;
  }

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "UpdateMessageTemplateRequest")
  public @ResponsePayload
  UpdateMessageTemplateResponse handleUpdateMessageTemplateRequest (@RequestPayload UpdateMessageTemplateRequest request)
      throws UserIsNotAuthorizedException, TokenIsNotAuthenticatedException, UserIsNotActiveException, ClientInformationNeededException,
      PersonNotFoundException, MessageTemplateNotFoundException {
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
      auditService.addAuditLog (token, "UpdateMessageTemplate", "MessageTemplateService", "0.0.1", "Updating messageTemplate with id: '"
          + request.getMessageTemplate ().getId () + "' ...", "", clientDateTime.getMillis (), request.getClientMacAddress (),
          request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Person owner = personnelService.getPersonById (request.getMessageTemplate ().getOwnerId ());
    if (owner == null) {
      throw new PersonNotFoundException ();
    }
    MessageTemplate messageTemplate = messageTemplateService.getMessageTemplateById (request.getMessageTemplate ().getId ());
    if (messageTemplate == null) {
      throw new MessageTemplateNotFoundException ();
    }
    messageTemplate.setDescription (request.getMessageTemplate ().getDescription ());
    messageTemplate.setName (request.getMessageTemplate ().getName ());
    messageTemplate.setText (request.getMessageTemplate ().getText ());
    messageTemplate.setOwner (owner);
    messageTemplate.setType (request.getMessageTemplate ().getType ());
    messageTemplateService.updateMessageTemplate (messageTemplate);

    UpdateMessageTemplateResponse response = new UpdateMessageTemplateResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "DeleteMessageTemplateRequest")
  public @ResponsePayload
  DeleteMessageTemplateResponse handleDeleteMessageTemplateRequest (@RequestPayload DeleteMessageTemplateRequest request)
      throws UserIsNotAuthorizedException, TokenIsNotAuthenticatedException, UserIsNotActiveException, ClientInformationNeededException,
      PersonNotFoundException, MessageTemplateNotFoundException {
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
      auditService.addAuditLog (token, "DeleteMessageTemplate", "MessageTemplateService", "0.0.1",
          "Deleting messageTemplate with id: '" + request.getMessageTemplateId () + "' ...", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    MessageTemplate messageTemplate = messageTemplateService.getMessageTemplateById (request.getMessageTemplateId ());
    if (messageTemplate == null) {
      throw new MessageTemplateNotFoundException ();
    }
    messageTemplateService.deleteMessageTemplate (request.getMessageTemplateId ());
    DeleteMessageTemplateResponse response = new DeleteMessageTemplateResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "GetMessageTemplateByIdRequest")
  public @ResponsePayload
  GetMessageTemplateByIdResponse handleGetMessageTemplateByIdRequest (@RequestPayload GetMessageTemplateByIdRequest request)
      throws UserIsNotAuthorizedException, TokenIsNotAuthenticatedException, UserIsNotActiveException, ClientInformationNeededException,
      PersonNotFoundException, MessageTemplateNotFoundException {
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
      auditService.addAuditLog (token, "GetMessageTemplateById", "MessageTemplateService", "0.0.1",
          "Getting messageTemplate with id: '" + request.getMessageTemplateId () + "' ...", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    MessageTemplate messageTemplate = messageTemplateService.getMessageTemplateById (request.getMessageTemplateId ());
    if (messageTemplate == null) {
      throw new MessageTemplateNotFoundException ();
    }
    MessageTemplateType messageTemplateType = new MessageTemplateType ();
    messageTemplateType.setDescription (messageTemplate.getDescription ());
    messageTemplateType.setId (messageTemplate.getId ());
    messageTemplateType.setName (messageTemplate.getName ());
    messageTemplateType.setText (messageTemplate.getText ());
    messageTemplateType.setOwnerId (messageTemplate.getOwner ().getId ());
    messageTemplateType.setOwnerFullName (messageTemplate.getOwner ().getPersianName () + " " + messageTemplate.getOwner ().getPersianFamily ());
    messageTemplateType.setType (messageTemplate.getType ());

    DateTime submitDateTime = new DateTime (messageTemplate.getSubmitDateTime (), DateTimeZone.UTC);
    messageTemplateType.setSubmitDateTimeYear (submitDateTime.getYear ());
    messageTemplateType.setSubmitDateTimeMonth (submitDateTime.getMonthOfYear ());
    messageTemplateType.setSubmitDateTimeDay (submitDateTime.getDayOfMonth ());
    messageTemplateType.setSubmitDateTimeHour (submitDateTime.getHourOfDay ());
    messageTemplateType.setSubmitDateTimeMinute (submitDateTime.getMinuteOfHour ());
    messageTemplateType.setSubmitDateTimeSecond (submitDateTime.getSecondOfMinute ());
    messageTemplateType.setSubmitDateTimeMilliSecond (submitDateTime.getMillisOfSecond ());

    GetMessageTemplateByIdResponse response = new GetMessageTemplateByIdResponse ();
    response.setMessageTemplate (messageTemplateType);
    return response;
  }

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "GetMessageTemplatesRequest")
  public @ResponsePayload
  GetMessageTemplatesResponse handleGetMessageTemplatesRequest (@RequestPayload GetMessageTemplatesRequest request)
      throws UserIsNotAuthorizedException, TokenIsNotAuthenticatedException, UserIsNotActiveException, ClientInformationNeededException,
      PersonNotFoundException, MessageTemplateNotFoundException {
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
      auditService.addAuditLog (token, "GetMessageTemplates", "MessageTemplateService", "0.0.1", "Getting all messageTemplates ...", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    List < MessageTemplate > messageTemplates = messageTemplateService.getMessageTemplates ();
    GetMessageTemplatesResponse response = new GetMessageTemplatesResponse ();
    for (MessageTemplate messageTemplate : messageTemplates) {
      MessageTemplateType messageTemplateType = new MessageTemplateType ();
      messageTemplateType.setDescription (messageTemplate.getDescription ());
      messageTemplateType.setId (messageTemplate.getId ());
      messageTemplateType.setName (messageTemplate.getName ());
      messageTemplateType.setText (messageTemplate.getText ());
      messageTemplateType.setOwnerId (messageTemplate.getOwner ().getId ());
      messageTemplateType.setOwnerFullName (messageTemplate.getOwner ().getPersianName () + " " + messageTemplate.getOwner ().getPersianFamily ());
      messageTemplateType.setType (messageTemplate.getType ());

      DateTime submitDateTime = new DateTime (messageTemplate.getSubmitDateTime (), DateTimeZone.UTC);
      messageTemplateType.setSubmitDateTimeYear (submitDateTime.getYear ());
      messageTemplateType.setSubmitDateTimeMonth (submitDateTime.getMonthOfYear ());
      messageTemplateType.setSubmitDateTimeDay (submitDateTime.getDayOfMonth ());
      messageTemplateType.setSubmitDateTimeHour (submitDateTime.getHourOfDay ());
      messageTemplateType.setSubmitDateTimeMinute (submitDateTime.getMinuteOfHour ());
      messageTemplateType.setSubmitDateTimeSecond (submitDateTime.getSecondOfMinute ());
      messageTemplateType.setSubmitDateTimeMilliSecond (submitDateTime.getMillisOfSecond ());

      response.getMessageTemplates ().add (messageTemplateType);
    }
    return response;
  }

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "GetMessageTemplatesByOwnerIdRequest")
  public @ResponsePayload
  GetMessageTemplatesByOwnerIdResponse handleGetMessageTemplateByOwnerIdRequest (@RequestPayload GetMessageTemplatesByOwnerIdRequest request)
      throws UserIsNotAuthorizedException, TokenIsNotAuthenticatedException, UserIsNotActiveException, ClientInformationNeededException,
      PersonNotFoundException, MessageTemplateNotFoundException {
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
      auditService.addAuditLog (token, "GetMessageTemplates", "MessageTemplateService", "0.0.1", "Getting all messageTemplates ...", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    List < MessageTemplate > messageTemplates = messageTemplateService.getMessageTemplatesByOwnerId (request.getOwnerId (), request.getCount ());
    GetMessageTemplatesByOwnerIdResponse response = new GetMessageTemplatesByOwnerIdResponse ();
    for (MessageTemplate messageTemplate : messageTemplates) {
      MessageTemplateType messageTemplateType = new MessageTemplateType ();
      messageTemplateType.setDescription (messageTemplate.getDescription ());
      messageTemplateType.setId (messageTemplate.getId ());
      messageTemplateType.setName (messageTemplate.getName ());
      messageTemplateType.setText (messageTemplate.getText ());
      messageTemplateType.setOwnerId (messageTemplate.getOwner ().getId ());
      messageTemplateType.setOwnerFullName (messageTemplate.getOwner ().getPersianName () + " " + messageTemplate.getOwner ().getPersianFamily ());
      messageTemplateType.setType (messageTemplate.getType ());

      DateTime submitDateTime = new DateTime (messageTemplate.getSubmitDateTime (), DateTimeZone.UTC);
      messageTemplateType.setSubmitDateTimeYear (submitDateTime.getYear ());
      messageTemplateType.setSubmitDateTimeMonth (submitDateTime.getMonthOfYear ());
      messageTemplateType.setSubmitDateTimeDay (submitDateTime.getDayOfMonth ());
      messageTemplateType.setSubmitDateTimeHour (submitDateTime.getHourOfDay ());
      messageTemplateType.setSubmitDateTimeMinute (submitDateTime.getMinuteOfHour ());
      messageTemplateType.setSubmitDateTimeSecond (submitDateTime.getSecondOfMinute ());
      messageTemplateType.setSubmitDateTimeMilliSecond (submitDateTime.getMillisOfSecond ());

      response.getMessageTemplates ().add (messageTemplateType);
    }
    return response;
  }
}
