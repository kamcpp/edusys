package com.mftvanak.edusys.ws.membership.endpoints;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mftvanak.edusys.domain.entity.membership.Role;
import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.ws.exceptions.AuthenticationFailedException;
import com.mftvanak.edusys.ws.exceptions.ClientInformationNeededException;
import com.mftvanak.edusys.ws.exceptions.RoleAlreadyExistsException;
import com.mftvanak.edusys.ws.exceptions.RoleIsInUseException;
import com.mftvanak.edusys.ws.exceptions.RoleNotFoundException;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotActiveException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;
import com.mftvanak.edusys.ws.membership.schemas.AddRoleRequest;
import com.mftvanak.edusys.ws.membership.schemas.AddRoleResponse;
import com.mftvanak.edusys.ws.membership.schemas.DeleteRoleRequest;
import com.mftvanak.edusys.ws.membership.schemas.DeleteRoleResponse;
import com.mftvanak.edusys.ws.membership.schemas.GetRoleByIdRequest;
import com.mftvanak.edusys.ws.membership.schemas.GetRoleByIdResponse;
import com.mftvanak.edusys.ws.membership.schemas.GetRoleByNameRequest;
import com.mftvanak.edusys.ws.membership.schemas.GetRoleByNameResponse;
import com.mftvanak.edusys.ws.membership.schemas.GetRolesRequest;
import com.mftvanak.edusys.ws.membership.schemas.GetRolesResponse;
import com.mftvanak.edusys.ws.membership.schemas.UpdateRoleRequest;
import com.mftvanak.edusys.ws.membership.schemas.UpdateRoleResponse;
import com.mftvanak.edusys.ws.membership.schemas.types.RoleType;
import com.mftvanak.edusys.ws.membership.services.AuditService;
import com.mftvanak.edusys.ws.membership.services.RoleService;
import com.mftvanak.edusys.ws.membership.services.SecurityService;
import com.mftvanak.edusys.ws.membership.services.UserService;


@Endpoint
public class RoleServiceEndpoint {

  @Autowired
  private RoleService roleService;

  @Autowired
  private UserService userService;

  @Autowired
  private SecurityService securityService;

  @Autowired
  private AuditService auditService;

  @PayloadRoot (namespace = "http://membership.ws.edusys.mftvanak.com/schemas", localPart = "AddRoleRequest")
  public @ResponsePayload
  AddRoleResponse getAddRoleRequest (@RequestPayload AddRoleRequest request) throws AuthenticationFailedException, RoleAlreadyExistsException,
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
      auditService.addAuditLog (token, "AddRole", "RoleService", "0.0.1", "Adding role '" + request.getRole ().getName () + "'", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Role existingRole = roleService.getRoleByName (request.getRole ().getName ());
    if (existingRole != null) {
      throw new RoleAlreadyExistsException ();
    }
    Role role = new Role ();
    role.setName (request.getRole ().getName ());
    Long id = roleService.addRole (role);
    DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (), request.getClientDateTimeDay (),
        request.getClientDateTimeHour (), request.getClientDateTimeMinute (), request.getClientDateTimeSecond (),
        request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
    auditService.addAuditLog (token, "AddRole", "RoleService", "0.0.1", "Role is added with id '" + request.getRole ().getId () + "'", "",
        clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
        request.getApplicationName ());
    AddRoleResponse response = new AddRoleResponse ();
    response.setRoleId (id);
    return response;
  }

  @PayloadRoot (namespace = "http://membership.ws.edusys.mftvanak.com/schemas", localPart = "UpdateRoleRequest")
  public @ResponsePayload
  UpdateRoleResponse getUpdateRoleRequest (@RequestPayload UpdateRoleRequest request) throws RoleNotFoundException, AuthenticationFailedException,
      RoleAlreadyExistsException, TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, UserIsNotActiveException,
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
      auditService.addAuditLog (token, "UpdateRole", "RoleService", "0.0.1", "Updating role '" +
          request.getRole ().getName () +
          "' with nodeId '" +
          request.getRole ().getId () +
          "'", "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Role role = roleService.getRoleById (request.getRole ().getId ());
    if (role == null) {
      throw new RoleNotFoundException ();
    }
    Role existingRole = roleService.getRoleByName (request.getRole ().getName ());
    if (existingRole != null) {
      throw new RoleAlreadyExistsException ();
    }
    role.setName (request.getRole ().getName ());
    roleService.updateRole (role);
    UpdateRoleResponse response = new UpdateRoleResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://membership.ws.edusys.mftvanak.com/schemas", localPart = "DeleteRoleRequest")
  public @ResponsePayload
  DeleteRoleResponse getDeleteRoleRequest (@RequestPayload DeleteRoleRequest request) throws AuthenticationFailedException, RoleIsInUseException,
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
      auditService.addAuditLog (token, "DeleteRole", "RoleService", "0.0.1", "Deleting role with nodeId '" + request.getRoleId () + "'", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    if (userService.getUsersUsingRole (request.getRoleId ()).size () > 0) {
      throw new RoleIsInUseException ();
    }
    roleService.deleteRole (request.getRoleId ());
    DeleteRoleResponse response = new DeleteRoleResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://membership.ws.edusys.mftvanak.com/schemas", localPart = "GetRolesRequest")
  public @ResponsePayload
  GetRolesResponse getGetRolesRequest (@RequestPayload GetRolesRequest request) throws AuthenticationFailedException,
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
      auditService.addAuditLog (token, "GetRoles", "RoleService", "0.0.1", "Getting all roles", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    GetRolesResponse response = new GetRolesResponse ();
    for (Role role : roleService.getRoles ()) {
      RoleType roleType = new RoleType ();
      roleType.setId (role.getId ());
      roleType.setName (role.getName ());
      response.getRoles ().add (roleType);
    }
    return response;
  }

  @PayloadRoot (namespace = "http://membership.ws.edusys.mftvanak.com/schemas", localPart = "GetRoleByIdRequest")
  public @ResponsePayload
  GetRoleByIdResponse getGetRoleByIdRequest (@RequestPayload GetRoleByIdRequest request) throws RoleNotFoundException,
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
      auditService.addAuditLog (token, "GetRoleById", "RoleService", "0.0.1", "Getting role with nodeId '" + request.getRoleId () + "'", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Role role = roleService.getRoleById (request.getRoleId ());
    if (role == null) {
      throw new RoleNotFoundException ();
    }
    RoleType roleType = new RoleType ();
    roleType.setId (role.getId ());
    roleType.setName (role.getName ());
    GetRoleByIdResponse response = new GetRoleByIdResponse ();
    response.setRole (roleType);
    return response;
  }

  @PayloadRoot (namespace = "http://membership.ws.edusys.mftvanak.com/schemas", localPart = "GetRoleByNameRequest")
  public @ResponsePayload
  GetRoleByNameResponse getGetRoleByNameRequest (@RequestPayload GetRoleByNameRequest request) throws RoleNotFoundException,
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
      auditService.addAuditLog (token, "GetRoleByName", "RoleService", "0.0.1", "Getting role with name '" + request.getName () + "'", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Role role = roleService.getRoleByName (request.getName ());
    if (role == null) {
      throw new RoleNotFoundException ();
    }
    RoleType roleType = new RoleType ();
    roleType.setId (role.getId ());
    roleType.setName (role.getName ());
    GetRoleByNameResponse response = new GetRoleByNameResponse ();
    response.setRole (roleType);
    return response;
  }
}
