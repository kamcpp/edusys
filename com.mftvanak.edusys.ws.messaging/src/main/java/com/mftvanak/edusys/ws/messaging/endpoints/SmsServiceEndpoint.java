package com.mftvanak.edusys.ws.messaging.endpoints;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.ws.exceptions.ClientInformationNeededException;
import com.mftvanak.edusys.ws.exceptions.PersonNotFoundException;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotActiveException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;
import com.mftvanak.edusys.ws.messaging.schemas.GetCurrentBalanceRequest;
import com.mftvanak.edusys.ws.messaging.schemas.GetCurrentBalanceResponse;
import com.mftvanak.edusys.ws.messaging.services.AuditService;
import com.mftvanak.edusys.ws.messaging.services.SecurityService;
import com.mftvanak.edusys.ws.messaging.services.SmsService;


@Endpoint
public class SmsServiceEndpoint {

  @Autowired
  private SecurityService securityService;

  @Autowired
  private AuditService auditService;

  @Autowired
  private SmsService smsService;

  @PayloadRoot (namespace = "http://messaging.ws.edusys.mftvanak.com/schemas", localPart = "GetCurrentBalanceRequest")
  public @ResponsePayload
  GetCurrentBalanceResponse handleGetCurrentBalanceRequest (@RequestPayload GetCurrentBalanceRequest request) throws UserIsNotAuthorizedException,
      TokenIsNotAuthenticatedException, UserIsNotActiveException, ClientInformationNeededException, PersonNotFoundException {
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
      auditService.addAuditLog (token, "GetCurrentBalance", "SmsService", "0.0.1", "Getting current balance ...", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }

    GetCurrentBalanceResponse response = new GetCurrentBalanceResponse ();
    response.setBalance (smsService.getCurrentBalance ());
    return response;
  }
}
