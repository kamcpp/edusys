package org.labcrypto.edusys.ws.authentication.endpoints;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.labcrypto.edusys.ws.authentication.schemas.AuthenticationRequest;
import org.labcrypto.edusys.ws.authentication.schemas.AuthenticationResponse;
import org.labcrypto.edusys.ws.authentication.schemas.ChangePasswordRequest;
import org.labcrypto.edusys.ws.authentication.schemas.ChangePasswordResponse;
import org.labcrypto.edusys.ws.authentication.schemas.DeactivateTokenRequest;
import org.labcrypto.edusys.ws.authentication.schemas.DeactivateTokenResponse;
import org.labcrypto.edusys.ws.authentication.schemas.RoleType;
import org.labcrypto.edusys.ws.authentication.schemas.UserExistsByEmailRequest;
import org.labcrypto.edusys.ws.authentication.schemas.UserExistsByEmailResponse;
import org.labcrypto.edusys.ws.authentication.schemas.UserExistsByUsernameRequest;
import org.labcrypto.edusys.ws.authentication.schemas.UserExistsByUsernameResponse;
import org.labcrypto.edusys.ws.authentication.schemas.ValidateTokenRequest;
import org.labcrypto.edusys.ws.authentication.schemas.ValidateTokenResponse;
import org.labcrypto.edusys.ws.authentication.services.AuditService;
import org.labcrypto.edusys.ws.authentication.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import org.labcrypto.edusys.domain.pg.entity.membership.Role;
import org.labcrypto.edusys.domain.pg.entity.membership.Token;
import org.labcrypto.edusys.domain.pg.entity.membership.User;
import org.labcrypto.edusys.ws.exceptions.AuthenticationFailedException;
import org.labcrypto.edusys.ws.exceptions.AuthenticationInformationNeededException;
import org.labcrypto.edusys.ws.exceptions.ClientInformationNeededException;
import org.labcrypto.edusys.ws.exceptions.EduSysException;
import org.labcrypto.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import org.labcrypto.edusys.ws.exceptions.WrongUsernameOrPasswordException;


@Endpoint
public class AuthenticationServiceEndpoint {

  @Autowired
  private AuthenticationService authenticationService;

  @Autowired
  private AuditService auditService;

  @PayloadRoot (namespace = "http://authentication.ws.edusys.mftvanak.com/schemas", localPart = "AuthenticationRequest")
  public @ResponsePayload
  AuthenticationResponse handleAuthenticationRequest (@RequestPayload AuthenticationRequest request) throws EduSysException {
    AuthenticationResponse response = new AuthenticationResponse ();
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
      auditService.addAuditLog (null, "Authentication", "AuthenticationService", "0.0.1",
          "Authentication request with username '" + request.getUsername () + "'", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    if (request.getUsername () == null) {
      throw new AuthenticationInformationNeededException ();
    }
    if (request.getPassword () == null) {
      throw new AuthenticationInformationNeededException ();
    }
    Token token = authenticationService.authenticate (request.getUsername (), request.getPassword (), new Date ());
    if (token == null) {
      throw new AuthenticationFailedException ();
    }
    response.setToken (token.getValue ());
    response.setUserId (token.getUser ().getPersonId ());
    response.setUsername (token.getUser ().getUsername ());
    response.setAccountEmail (token.getUser ().getAccountEmail ());
    response.setPhone1 (token.getUser ().getPerson ().getPhone1 ());
    response.setPhone2 (token.getUser ().getPerson ().getPhone2 ());
    response.setPhone3 (token.getUser ().getPerson ().getPhone3 ());
    response.setEmail1 (token.getUser ().getPerson ().getEmail1 ());
    response.setEmail2 (token.getUser ().getPerson ().getEmail2 ());
    response.setPersianFullName (token.getUser ().getPerson ().getPersianName () + " " + token.getUser ().getPerson ().getPersianFamily ());
    response.setEnglishFullName (token.getUser ().getPerson ().getEnglishName () + " " + token.getUser ().getPerson ().getEnglishFamily ());
    for (Role role : token.getUser ().getRoles ()) {
      RoleType roleType = new RoleType ();
      roleType.setId (role.getId ());
      roleType.setName (role.getName ());
      response.getRoles ().add (roleType);
    }
    DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (), request.getClientDateTimeDay (),
        request.getClientDateTimeHour (), request.getClientDateTimeMinute (), request.getClientDateTimeSecond (),
        request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
    auditService.addAuditLog (null, "Authenticated", "AuthenticationService", "0.0.1",
        "Authentication succeeded with for username '" + request.getUsername () + "' with token '" + token.getValue () + "'", "",
        clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
        request.getApplicationName ());
    return response;
  }

  @PayloadRoot (namespace = "http://authentication.ws.edusys.mftvanak.com/schemas", localPart = "ValidateTokenRequest")
  public @ResponsePayload
  ValidateTokenResponse handleValidateToken (@RequestPayload ValidateTokenRequest request) throws TokenIsNotAuthenticatedException,
      ClientInformationNeededException {
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
      auditService.addAuditLog (null, "ValidateToken", "AuthenticationService", "0.0.1",
          "Authentication request with token '" + request.getToken () + "'", "", clientDateTime.getMillis (), request.getClientMacAddress (),
          request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    User user = authenticationService.validateToken (request.getToken ());
    ValidateTokenResponse response = new ValidateTokenResponse ();
    if (user == null) {
      throw new TokenIsNotAuthenticatedException ();
    } else {
      response.setUserId (user.getPersonId ());
      response.setUsername (user.getUsername ());
      response.setEmail (user.getAccountEmail ());
      response.setPersianFullName (user.getPerson ().getPersianName () + " " + user.getPerson ().getPersianFamily ());
      response.setEnglishFullName (user.getPerson ().getEnglishName () + " " + user.getPerson ().getEnglishFamily ());
      for (Role role : user.getRoles ()) {
        RoleType roleType = new RoleType ();
        roleType.setId (role.getId ());
        roleType.setName (role.getName ());
        response.getRoles ().add (roleType);
      }
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (null, "TokenValidated", "AuthenticationService", "0.0.1",
          "Authentication succeeded with token '" + request.getToken () + "'. It is for username '" + user.getUsername () + "'", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    }
    return response;
  }

  @PayloadRoot (namespace = "http://authentication.ws.edusys.mftvanak.com/schemas", localPart = "DeactivateTokenRequest")
  public @ResponsePayload
  DeactivateTokenResponse handleDeactivateTokenRequest (@RequestPayload DeactivateTokenRequest request) throws ClientInformationNeededException {
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
      auditService.addAuditLog (null, "DeactivateToken", "AuthenticationService", "0.0.1", "Deactivating token '" + request.getToken () + "'", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    authenticationService.deactivateToken (request.getToken ());
    DeactivateTokenResponse response = new DeactivateTokenResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://authentication.ws.edusys.mftvanak.com/schemas", localPart = "UserExistsByUsernameRequest")
  public @ResponsePayload
  UserExistsByUsernameResponse handleUserExistsByUsernameRequest (@RequestPayload UserExistsByUsernameRequest request)
      throws ClientInformationNeededException {
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
      auditService.addAuditLog (null, "UserExistsByUsername", "AuthenticationService", "0.0.1",
          "Checking for user with username '" + request.getUsername () + "'", "", clientDateTime.getMillis (), request.getClientMacAddress (),
          request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    UserExistsByUsernameResponse response = new UserExistsByUsernameResponse ();
    response.setResult (authenticationService.userExistsByUsername (request.getUsername ()));
    return response;
  }

  @PayloadRoot (namespace = "http://authentication.ws.edusys.mftvanak.com/schemas", localPart = "UserExistsByEmailRequest")
  public @ResponsePayload
  UserExistsByEmailResponse handleUserExistsByEmailRequest (@RequestPayload UserExistsByEmailRequest request)
      throws ClientInformationNeededException {
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
      auditService.addAuditLog (null, "UserExistsByEmail", "AuthenticationService", "0.0.1",
          "Checking for user with email '" + request.getEmail () + "'", "", clientDateTime.getMillis (), request.getClientMacAddress (),
          request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    UserExistsByEmailResponse response = new UserExistsByEmailResponse ();
    response.setResult (authenticationService.userExistsByEmail (request.getEmail ()));
    return response;
  }

  @PayloadRoot (namespace = "http://authentication.ws.edusys.mftvanak.com/schemas", localPart = "ChangePasswordRequest")
  public @ResponsePayload
  ChangePasswordResponse handleChangePasswordRequest (@RequestPayload ChangePasswordRequest request) throws TokenIsNotAuthenticatedException,
      ClientInformationNeededException, WrongUsernameOrPasswordException {
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
      auditService.addAuditLog (null, "ChangePassword", "AuthenticationService", "0.0.1",
          "Changing password for username '" + request.getUsername () + "'", "", clientDateTime.getMillis (), request.getClientMacAddress (),
          request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    boolean result = authenticationService.changePassword (request.getUsername (), request.getCurrentHashedPassword (),
        request.getNewHashedPassword ());
    if (!result) {
      throw new WrongUsernameOrPasswordException ();
    }
    ChangePasswordResponse response = new ChangePasswordResponse ();
    return response;
  }
}
