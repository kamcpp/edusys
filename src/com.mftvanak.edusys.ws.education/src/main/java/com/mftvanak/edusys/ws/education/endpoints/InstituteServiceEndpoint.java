package com.mftvanak.edusys.ws.education.endpoints;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mftvanak.edusys.domain.entity.education.Department;
import com.mftvanak.edusys.domain.entity.education.Institute;
import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.ws.education.schemas.institute.AddDepartmentRequest;
import com.mftvanak.edusys.ws.education.schemas.institute.AddDepartmentResponse;
import com.mftvanak.edusys.ws.education.schemas.institute.AddInstituteRequest;
import com.mftvanak.edusys.ws.education.schemas.institute.AddInstituteResponse;
import com.mftvanak.edusys.ws.education.schemas.institute.DeleteInstituteRequest;
import com.mftvanak.edusys.ws.education.schemas.institute.DeleteInstituteResponse;
import com.mftvanak.edusys.ws.education.schemas.institute.GetInstituteByIdRequest;
import com.mftvanak.edusys.ws.education.schemas.institute.GetInstituteByIdResponse;
import com.mftvanak.edusys.ws.education.schemas.institute.GetInstitutesRequest;
import com.mftvanak.edusys.ws.education.schemas.institute.GetInstitutesResponse;
import com.mftvanak.edusys.ws.education.schemas.institute.RemoveDepartmentRequest;
import com.mftvanak.edusys.ws.education.schemas.institute.RemoveDepartmentResponse;
import com.mftvanak.edusys.ws.education.schemas.institute.UpdateInstituteRequest;
import com.mftvanak.edusys.ws.education.schemas.institute.UpdateInstituteResponse;
import com.mftvanak.edusys.ws.education.schemas.types.InstituteType;
import com.mftvanak.edusys.ws.education.services.AuditService;
import com.mftvanak.edusys.ws.education.services.DepartmentService;
import com.mftvanak.edusys.ws.education.services.InstituteService;
import com.mftvanak.edusys.ws.education.services.SecurityService;
import com.mftvanak.edusys.ws.exceptions.ClientInformationNeededException;
import com.mftvanak.edusys.ws.exceptions.DepartmentNotFoundException;
import com.mftvanak.edusys.ws.exceptions.InstituteNotFoundException;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotActiveException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;


@Endpoint
public class InstituteServiceEndpoint {

  @Autowired
  private InstituteService instituteService;

  @Autowired
  private DepartmentService departmentService;

  @Autowired
  private SecurityService securityService;

  @Autowired
  private AuditService auditService;

  @PayloadRoot (namespace = "http://education.ws.edusys.mftvanak.com/schemas/institute", localPart = "AddInstituteRequest")
  public @ResponsePayload
  AddInstituteResponse handleAddInstituteRequest (@RequestPayload AddInstituteRequest request)
      throws TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, UserIsNotActiveException,
      ClientInformationNeededException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null || request.getClientIpAddress () == null
        || request.getClientComputerName () == null || request.getApplicationName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 && request.getClientDateTimeMonth () >= 0
        && request.getClientDateTimeDay () >= 0 && request.getClientDateTimeHour () >= 0
        && request.getClientDateTimeMinute () >= 0 && request.getClientDateTimeSecond () >= 0
        && request.getClientDateTimeMilliSecond () >= 0 && !request.getClientMacAddress ().isEmpty ()
        && !request.getClientIpAddress ().isEmpty () && !request.getClientComputerName ().isEmpty ()
        && !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (token, "AddInstitute", "InstituteService", "0.0.1",
          "Adding institute with persian name '" + request.getInstitute ().getPersianName () + "'", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (),
          request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Institute institute = new Institute ();
    institute.setPersianName (request.getInstitute ().getPersianName ());
    institute.setEnglishName (request.getInstitute ().getEnglishName ());
    institute.setPhone1 (request.getInstitute ().getPhone1 ());
    institute.setPhone2 (request.getInstitute ().getPhone2 ());
    institute.setFaxNumber (request.getInstitute ().getFaxNumber ());
    institute.setEmail1 (request.getInstitute ().getEmail1 ());
    institute.setEmail2 (request.getInstitute ().getEmail2 ());
    institute.setWebUrl1 (request.getInstitute ().getWebUrl1 ());
    institute.setWebUrl2 (request.getInstitute ().getWebUrl2 ());
    Long id = instituteService.addEntity (institute);
    DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
        request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
        request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
    auditService.addAuditLog (
        token,
        "AddInstitute",
        "InstituteService",
        "0.0.1",
        "Institute is added with persian name '" + request.getInstitute ().getPersianName () + "' and id '"
            + institute.getId () + "'", "", clientDateTime.getMillis (), request.getClientMacAddress (),
        request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    AddInstituteResponse response = new AddInstituteResponse ();
    response.setInstituteId (id);
    return response;
  }

  @PayloadRoot (namespace = "http://education.ws.edusys.mftvanak.com/schemas/institute", localPart = "UpdateInstituteRequest")
  public @ResponsePayload
  UpdateInstituteResponse handleUpdateInstituteRequest (@RequestPayload UpdateInstituteRequest request)
      throws TokenIsNotAuthenticatedException, InstituteNotFoundException, UserIsNotAuthorizedException,
      UserIsNotActiveException, ClientInformationNeededException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null || request.getClientIpAddress () == null
        || request.getClientComputerName () == null || request.getApplicationName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 && request.getClientDateTimeMonth () >= 0
        && request.getClientDateTimeDay () >= 0 && request.getClientDateTimeHour () >= 0
        && request.getClientDateTimeMinute () >= 0 && request.getClientDateTimeSecond () >= 0
        && request.getClientDateTimeMilliSecond () >= 0 && !request.getClientMacAddress ().isEmpty ()
        && !request.getClientIpAddress ().isEmpty () && !request.getClientComputerName ().isEmpty ()
        && !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (token, "UpdateInstitute", "InstituteService", "0.0.1", "Updating institute with id '"
          + request.getInstitute ().getId () + "'", "", clientDateTime.getMillis (), request.getClientMacAddress (),
          request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Institute institute = instituteService.getEntityById (request.getInstitute ().getId ());
    if (institute == null) {
      throw new InstituteNotFoundException ();
    }
    institute.setPersianName (request.getInstitute ().getPersianName ());
    institute.setEnglishName (request.getInstitute ().getEnglishName ());
    institute.setPhone1 (request.getInstitute ().getPhone1 ());
    institute.setPhone2 (request.getInstitute ().getPhone2 ());
    institute.setFaxNumber (request.getInstitute ().getFaxNumber ());
    institute.setEmail1 (request.getInstitute ().getEmail1 ());
    institute.setEmail2 (request.getInstitute ().getEmail2 ());
    institute.setWebUrl1 (request.getInstitute ().getWebUrl1 ());
    institute.setWebUrl2 (request.getInstitute ().getWebUrl2 ());
    instituteService.updateEntity (institute);
    UpdateInstituteResponse response = new UpdateInstituteResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://education.ws.edusys.mftvanak.com/schemas/institute", localPart = "DeleteInstituteRequest")
  public @ResponsePayload
  DeleteInstituteResponse handleDeleteInstituteRequest (@RequestPayload DeleteInstituteRequest request)
      throws TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, InstituteNotFoundException,
      UserIsNotActiveException, ClientInformationNeededException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null || request.getClientIpAddress () == null
        || request.getClientComputerName () == null || request.getApplicationName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 && request.getClientDateTimeMonth () >= 0
        && request.getClientDateTimeDay () >= 0 && request.getClientDateTimeHour () >= 0
        && request.getClientDateTimeMinute () >= 0 && request.getClientDateTimeSecond () >= 0
        && request.getClientDateTimeMilliSecond () >= 0 && !request.getClientMacAddress ().isEmpty ()
        && !request.getClientIpAddress ().isEmpty () && !request.getClientComputerName ().isEmpty ()
        && !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (token, "DeleteInstitute", "InstituteService", "0.0.1", "Deleting institute with id '"
          + request.getInstituteId () + "'", "", clientDateTime.getMillis (), request.getClientMacAddress (),
          request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Institute institute = instituteService.getEntityById (request.getInstituteId ());
    if (institute == null) {
      throw new InstituteNotFoundException ();
    }
    instituteService.deleteEntity (request.getInstituteId ());
    DeleteInstituteResponse response = new DeleteInstituteResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://education.ws.edusys.mftvanak.com/schemas/institute", localPart = "GetInstituteByIdRequest")
  public @ResponsePayload
  GetInstituteByIdResponse handleGetInstituteByIdRequest (@RequestPayload GetInstituteByIdRequest request)
      throws TokenIsNotAuthenticatedException, InstituteNotFoundException, UserIsNotAuthorizedException,
      UserIsNotActiveException, ClientInformationNeededException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null || request.getClientIpAddress () == null
        || request.getClientComputerName () == null || request.getApplicationName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 && request.getClientDateTimeMonth () >= 0
        && request.getClientDateTimeDay () >= 0 && request.getClientDateTimeHour () >= 0
        && request.getClientDateTimeMinute () >= 0 && request.getClientDateTimeSecond () >= 0
        && request.getClientDateTimeMilliSecond () >= 0 && !request.getClientMacAddress ().isEmpty ()
        && !request.getClientIpAddress ().isEmpty () && !request.getClientComputerName ().isEmpty ()
        && !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (token, "GetInstituteById", "InstituteService", "0.0.1", "Getting institute with id '"
          + request.getInstituteId () + "'", "", clientDateTime.getMillis (), request.getClientMacAddress (),
          request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Institute institute = instituteService.getEntityById (request.getInstituteId ());
    if (institute == null) {
      throw new InstituteNotFoundException ();
    }
    InstituteType instituteType = new InstituteType ();
    instituteType.setId (institute.getId ());
    instituteType.setPersianName (institute.getPersianName ());
    instituteType.setEnglishName (institute.getEnglishName ());
    instituteType.setPhone1 (institute.getPhone1 ());
    instituteType.setPhone2 (institute.getPhone2 ());
    instituteType.setFaxNumber (institute.getFaxNumber ());
    instituteType.setEmail1 (institute.getEmail1 ());
    instituteType.setEmail2 (institute.getEmail2 ());
    instituteType.setWebUrl1 (institute.getWebUrl1 ());
    instituteType.setWebUrl2 (institute.getWebUrl2 ());
    GetInstituteByIdResponse response = new GetInstituteByIdResponse ();
    response.setInstitute (instituteType);
    return response;
  }

  @PayloadRoot (namespace = "http://education.ws.edusys.mftvanak.com/schemas/institute", localPart = "GetInstitutesRequest")
  public @ResponsePayload
  GetInstitutesResponse handleGetInstitutesRequest (@RequestPayload GetInstitutesRequest request)
      throws TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, UserIsNotActiveException,
      ClientInformationNeededException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null || request.getClientIpAddress () == null
        || request.getClientComputerName () == null || request.getApplicationName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 && request.getClientDateTimeMonth () >= 0
        && request.getClientDateTimeDay () >= 0 && request.getClientDateTimeHour () >= 0
        && request.getClientDateTimeMinute () >= 0 && request.getClientDateTimeSecond () >= 0
        && request.getClientDateTimeMilliSecond () >= 0 && !request.getClientMacAddress ().isEmpty ()
        && !request.getClientIpAddress ().isEmpty () && !request.getClientComputerName ().isEmpty ()
        && !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (token, "GetInstitutes", "InstituteService", "0.0.1", "Getting all institutes", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (),
          request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    GetInstitutesResponse response = new GetInstitutesResponse ();
    List < Institute > institutes = instituteService.getAllEntities ();
    for (Institute institute : institutes) {
      InstituteType instituteType = new InstituteType ();
      instituteType.setId (institute.getId ());
      instituteType.setPersianName (institute.getPersianName ());
      instituteType.setEnglishName (institute.getEnglishName ());
      instituteType.setPhone1 (institute.getPhone1 ());
      instituteType.setPhone2 (institute.getPhone2 ());
      instituteType.setFaxNumber (institute.getFaxNumber ());
      instituteType.setEmail1 (institute.getEmail1 ());
      instituteType.setEmail2 (institute.getEmail2 ());
      instituteType.setWebUrl1 (institute.getWebUrl1 ());
      instituteType.setWebUrl2 (institute.getWebUrl2 ());
      response.getInstitutes ().add (instituteType);
    }
    return response;
  }

  @PayloadRoot (namespace = "http://education.ws.edusys.mftvanak.com/schemas/institute", localPart = "AddDepartmentRequest")
  public @ResponsePayload
  AddDepartmentResponse handleAddDepartmentRequest (@RequestPayload AddDepartmentRequest request)
      throws TokenIsNotAuthenticatedException, InstituteNotFoundException, DepartmentNotFoundException,
      UserIsNotAuthorizedException, UserIsNotActiveException, ClientInformationNeededException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null || request.getClientIpAddress () == null
        || request.getClientComputerName () == null || request.getApplicationName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 && request.getClientDateTimeMonth () >= 0
        && request.getClientDateTimeDay () >= 0 && request.getClientDateTimeHour () >= 0
        && request.getClientDateTimeMinute () >= 0 && request.getClientDateTimeSecond () >= 0
        && request.getClientDateTimeMilliSecond () >= 0 && !request.getClientMacAddress ().isEmpty ()
        && !request.getClientIpAddress ().isEmpty () && !request.getClientComputerName ().isEmpty ()
        && !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (
          token,
          "AddDepartmentToInstitute",
          "InstituteService",
          "0.0.1",
          "Adding a department with id '" + request.getDepartmentId () + " to an institute with id '"
              + request.getInstituteId () + "'", "", clientDateTime.getMillis (), request.getClientMacAddress (),
          request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Institute institute = instituteService.getEntityById (request.getInstituteId ());
    if (institute == null) {
      throw new InstituteNotFoundException ();
    }
    Department department = departmentService.getEntityById (request.getDepartmentId ());
    if (department == null) {
      throw new DepartmentNotFoundException ();
    }
    AddDepartmentResponse response = new AddDepartmentResponse ();
    institute.getDepartments ().add (department);
    instituteService.updateEntity (institute);
    return response;
  }

  @PayloadRoot (namespace = "http://education.ws.edusys.mftvanak.com/schemas/institute", localPart = "RemoveDepartmentRequest")
  public @ResponsePayload
  RemoveDepartmentResponse handleRemoveDepartmentRequest (@RequestPayload RemoveDepartmentRequest request)
      throws TokenIsNotAuthenticatedException, InstituteNotFoundException, DepartmentNotFoundException,
      UserIsNotAuthorizedException, UserIsNotActiveException, ClientInformationNeededException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null || request.getClientIpAddress () == null
        || request.getClientComputerName () == null || request.getApplicationName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 && request.getClientDateTimeMonth () >= 0
        && request.getClientDateTimeDay () >= 0 && request.getClientDateTimeHour () >= 0
        && request.getClientDateTimeMinute () >= 0 && request.getClientDateTimeSecond () >= 0
        && request.getClientDateTimeMilliSecond () >= 0 && !request.getClientMacAddress ().isEmpty ()
        && !request.getClientIpAddress ().isEmpty () && !request.getClientComputerName ().isEmpty ()
        && !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (
          token,
          "RemoveDepartmentFromInstitute",
          "InstituteService",
          "0.0.1",
          "Removing a department with id '" + request.getDepartmentId () + " from an institute with id '"
              + request.getInstituteId () + "'", "", clientDateTime.getMillis (), request.getClientMacAddress (),
          request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Institute institute = instituteService.getEntityById (request.getInstituteId ());
    if (institute == null) {
      throw new InstituteNotFoundException ();
    }
    Department department = departmentService.getEntityById (request.getDepartmentId ());
    if (department == null) {
      throw new DepartmentNotFoundException ();
    }
    RemoveDepartmentResponse response = new RemoveDepartmentResponse ();
    institute.getDepartments ().remove (department);
    instituteService.updateEntity (institute);
    return response;
  }
}
