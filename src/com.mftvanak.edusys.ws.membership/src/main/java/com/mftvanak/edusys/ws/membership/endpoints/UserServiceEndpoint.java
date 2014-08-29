package com.mftvanak.edusys.ws.membership.endpoints;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mftvanak.edusys.domain.entity.membership.Role;
import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.domain.entity.membership.User;
import com.mftvanak.edusys.domain.entity.personnel.Person;
import com.mftvanak.edusys.ws.exceptions.AuthenticationFailedException;
import com.mftvanak.edusys.ws.exceptions.ClientInformationNeededException;
import com.mftvanak.edusys.ws.exceptions.OperationFailedException;
import com.mftvanak.edusys.ws.exceptions.PersonNotFoundException;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotActiveException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;
import com.mftvanak.edusys.ws.exceptions.UserNotFoundException;
import com.mftvanak.edusys.ws.membership.schemas.AddUserRequest;
import com.mftvanak.edusys.ws.membership.schemas.AddUserResponse;
import com.mftvanak.edusys.ws.membership.schemas.DeleteUserRequest;
import com.mftvanak.edusys.ws.membership.schemas.DeleteUserResponse;
import com.mftvanak.edusys.ws.membership.schemas.GetRolesForUserRequest;
import com.mftvanak.edusys.ws.membership.schemas.GetRolesForUserResponse;
import com.mftvanak.edusys.ws.membership.schemas.GetUserByIdRequest;
import com.mftvanak.edusys.ws.membership.schemas.GetUserByIdResponse;
import com.mftvanak.edusys.ws.membership.schemas.GetUsersRequest;
import com.mftvanak.edusys.ws.membership.schemas.GetUsersResponse;
import com.mftvanak.edusys.ws.membership.schemas.GrantRoleToUserRequest;
import com.mftvanak.edusys.ws.membership.schemas.GrantRoleToUserResponse;
import com.mftvanak.edusys.ws.membership.schemas.RevokeRoleFromUserRequest;
import com.mftvanak.edusys.ws.membership.schemas.RevokeRoleFromUserResponse;
import com.mftvanak.edusys.ws.membership.schemas.UpdateUserRequest;
import com.mftvanak.edusys.ws.membership.schemas.UpdateUserResponse;
import com.mftvanak.edusys.ws.membership.schemas.types.RoleType;
import com.mftvanak.edusys.ws.membership.schemas.types.UserType;
import com.mftvanak.edusys.ws.membership.services.AuditService;
import com.mftvanak.edusys.ws.membership.services.PersonnelService;
import com.mftvanak.edusys.ws.membership.services.SecurityService;
import com.mftvanak.edusys.ws.membership.services.UserService;


@Endpoint
public class UserServiceEndpoint {

  @Autowired
  private UserService userService;

  @Autowired
  private PersonnelService personnelService;

  @Autowired
  private SecurityService securityService;

  @Autowired
  private AuditService auditService;

  @PayloadRoot (namespace = "http://membership.ws.edusys.mftvanak.com/schemas", localPart = "AddUserRequest")
  public @ResponsePayload
  AddUserResponse handleAddUserRequest (@RequestPayload AddUserRequest request) throws AuthenticationFailedException,
      TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, PersonNotFoundException, UserIsNotActiveException,
      ClientInformationNeededException {
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
      auditService.addAuditLog (token, "AddUser", "UserService", "0.0.1", "Adding user with username '" +
          request.getUser ().getUsername () +
          "' and personId '" +
          request.getUser ().getPersonId () +
          "'", "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Person person = personnelService.getPersonById (request.getUser ().getPersonId ());
    if (person == null) {
      throw new PersonNotFoundException ();
    }
    User user = new User ();
    user.setPerson (person);
    user.setUsername (request.getUser ().getUsername ());
    user.setAccountEmail (request.getUser ().getAccountEmail ());
    user.setHashedPassword (request.getUser ().getHashedPassword ());
    user.setActive (request.getUser ().isActive ());
    Long id = userService.addUser (user);
    DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (), request.getClientDateTimeDay (),
        request.getClientDateTimeHour (), request.getClientDateTimeMinute (), request.getClientDateTimeSecond (),
        request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
    auditService.addAuditLog (token, "AddUser", "UserService", "0.0.1", "User is added with username '" +
        request.getUser ().getUsername () +
        "' and personId '" +
        request.getUser ().getPersonId () +
        "'", "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
        request.getApplicationName ());
    AddUserResponse response = new AddUserResponse ();
    response.setUserId (id);
    return response;
  }

  @PayloadRoot (namespace = "http://membership.ws.edusys.mftvanak.com/schemas", localPart = "UpdateUserRequest")
  public @ResponsePayload
  UpdateUserResponse handleUpdateUserRequest (@RequestPayload UpdateUserRequest request) throws AuthenticationFailedException,
      UserNotFoundException, TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, UserIsNotActiveException,
      ClientInformationNeededException {
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
      auditService.addAuditLog (token, "UpdateUser", "UserService", "0.0.1", "Updating user with username '" +
          request.getUser ().getUsername () +
          "' and personId '" +
          request.getUser ().getPersonId () +
          "'", "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    User user = userService.getUserById (request.getUser ().getPersonId ());
    if (user == null) {
      throw new UserNotFoundException ();
    }
    user.setActive (request.getUser ().isActive ());
    user.setAccountEmail (request.getUser ().getAccountEmail ());
    user.setHashedPassword (request.getUser ().getHashedPassword ());
    user.setUsername (request.getUser ().getUsername ());
    userService.updateUser (user);
    UpdateUserResponse response = new UpdateUserResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://membership.ws.edusys.mftvanak.com/schemas", localPart = "DeleteUserRequest")
  public @ResponsePayload
  DeleteUserResponse handleDeleteUserRequest (@RequestPayload DeleteUserRequest request) throws AuthenticationFailedException,
      TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, UserNotFoundException, UserIsNotActiveException,
      ClientInformationNeededException {
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
      auditService.addAuditLog (token, "DeleteUser", "UserService", "0.0.1", "Deleting user with personId '" + request.getUserId () + "'", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    User user = userService.getUserById (request.getUserId ());
    if (user == null) {
      throw new UserNotFoundException ();
    }
    userService.deleteUser (request.getUserId ());
    DeleteUserResponse response = new DeleteUserResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://membership.ws.edusys.mftvanak.com/schemas", localPart = "GetUsersRequest")
  public @ResponsePayload
  GetUsersResponse handleGetUsersRequest (@RequestPayload GetUsersRequest request) throws AuthenticationFailedException,
      TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, UserIsNotActiveException, ClientInformationNeededException {
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
      auditService.addAuditLog (token, "GetUsers", "UserService", "0.0.1", "Getting all users", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    List < User > users = userService.getUsers ();
    GetUsersResponse response = new GetUsersResponse ();
    for (User user : users) {
      UserType userType = new UserType ();
      userType.setPersonId (user.getPersonId ());
      userType.setActive (user.isActive ());
      userType.setAccountEmail (user.getAccountEmail ());
      userType.setHashedPassword (user.getHashedPassword ());
      userType.setUsername (user.getUsername ());
      response.getUsers ().add (userType);
    }
    return response;
  }

  @PayloadRoot (namespace = "http://membership.ws.edusys.mftvanak.com/schemas", localPart = "GetUserByIdRequest")
  public @ResponsePayload
  GetUserByIdResponse handleGetUserByIdRequest (@RequestPayload GetUserByIdRequest request) throws AuthenticationFailedException,
      UserNotFoundException, TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, UserIsNotActiveException,
      ClientInformationNeededException {
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
      auditService.addAuditLog (token, "GetUserById", "UserService", "0.0.1", "Getting user with personId '" + request.getUserId () + "'", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    User user = userService.getUserById (request.getUserId ());
    if (user == null) {
      throw new UserNotFoundException ();
    }
    UserType userType = new UserType ();
    userType.setPersonId (user.getPersonId ());
    userType.setActive (user.isActive ());
    userType.setAccountEmail (user.getAccountEmail ());
    userType.setHashedPassword (user.getHashedPassword ());
    userType.setUsername (user.getUsername ());
    GetUserByIdResponse response = new GetUserByIdResponse ();
    response.setUser (userType);
    return response;
  }

  @PayloadRoot (namespace = "http://membership.ws.edusys.mftvanak.com/schemas", localPart = "GrantRoleToUserRequest")
  public @ResponsePayload
  GrantRoleToUserResponse handleGrantRoleToUserRequest (@RequestPayload GrantRoleToUserRequest request) throws OperationFailedException,
      AuthenticationFailedException, TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, UserIsNotActiveException,
      ClientInformationNeededException, UserNotFoundException {
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
      auditService.addAuditLog (token, "GrantRoleToUser", "UserService", "0.0.1", "Granting role with id '" +
          request.getRoleId () +
          "' to user with nodeId '" +
          request.getUserId () +
          "'", "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    User user = userService.getUserById (request.getUserId ());
    if (user == null) {
      throw new UserNotFoundException ();
    }
    try {
      userService.grantRoleToUser (request.getUserId (), request.getRoleId ());
    } catch (Exception ex) {
      throw new OperationFailedException (ex);
    }
    GrantRoleToUserResponse response = new GrantRoleToUserResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://membership.ws.edusys.mftvanak.com/schemas", localPart = "RevokeRoleFromUserRequest")
  public @ResponsePayload
  RevokeRoleFromUserResponse handleRevokeRoleFromUserRequest (@RequestPayload RevokeRoleFromUserRequest request) throws OperationFailedException,
      AuthenticationFailedException, TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, UserIsNotActiveException,
      ClientInformationNeededException {
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
      auditService.addAuditLog (token, "RevokeRoleFromUser", "UserService", "0.0.1", "Revoking role with id '" +
          request.getRoleId () +
          "' from user with nodeId '" +
          request.getUserId () +
          "'", "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    try {
      userService.revokeRoleFromUser (request.getUserId (), request.getRoleId ());
    } catch (Exception ex) {
      throw new OperationFailedException (ex);
    }
    RevokeRoleFromUserResponse response = new RevokeRoleFromUserResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://membership.ws.edusys.mftvanak.com/schemas", localPart = "GetRolesForUserRequest")
  public @ResponsePayload
  GetRolesForUserResponse handleGetRolesForUserRequest (@RequestPayload GetRolesForUserRequest request) throws AuthenticationFailedException,
      UserNotFoundException, TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, UserIsNotActiveException,
      ClientInformationNeededException {
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
      auditService.addAuditLog (token, "GetRolesForUser", "UserService", "0.0.1",
          "Getting all roles for user with nodeId '" + request.getUserId () + "'", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    User user = userService.getUserById (request.getUserId ());
    if (user == null) {
      throw new UserNotFoundException ();
    }
    GetRolesForUserResponse response = new GetRolesForUserResponse ();
    for (Role role : user.getRoles ()) {
      RoleType roleType = new RoleType ();
      roleType.setId (role.getId ());
      roleType.setName (role.getName ());
      response.getRoles ().add (roleType);
    }
    return response;
  }
}
