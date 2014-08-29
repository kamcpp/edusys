package com.mftvanak.edusys.ws.gheyas.endpoints;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mftvanak.edusys.domain.entity.gheyas.GheyasClass;
import com.mftvanak.edusys.domain.entity.gheyas.GheyasClassGroup;
import com.mftvanak.edusys.domain.entity.gheyas.GheyasDebtor;
import com.mftvanak.edusys.domain.entity.gheyas.GheyasStudent;
import com.mftvanak.edusys.domain.entity.gheyas.GheyasTerm;
import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.ws.exceptions.AuthenticationFailedException;
import com.mftvanak.edusys.ws.exceptions.ClientInformationNeededException;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotActiveException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;
import com.mftvanak.edusys.ws.gheyas.schemas.GetClassesRequest;
import com.mftvanak.edusys.ws.gheyas.schemas.GetClassesResponse;
import com.mftvanak.edusys.ws.gheyas.schemas.GetCommonClassesRequest;
import com.mftvanak.edusys.ws.gheyas.schemas.GetCommonClassesResponse;
import com.mftvanak.edusys.ws.gheyas.schemas.GetDebtorsRequest;
import com.mftvanak.edusys.ws.gheyas.schemas.GetDebtorsResponse;
import com.mftvanak.edusys.ws.gheyas.schemas.GetGroupsRequest;
import com.mftvanak.edusys.ws.gheyas.schemas.GetGroupsResponse;
import com.mftvanak.edusys.ws.gheyas.schemas.GetStudentsRequest;
import com.mftvanak.edusys.ws.gheyas.schemas.GetStudentsResponse;
import com.mftvanak.edusys.ws.gheyas.schemas.GetTermsRequest;
import com.mftvanak.edusys.ws.gheyas.schemas.GetTermsResponse;
import com.mftvanak.edusys.ws.gheyas.schemas.GheyasClassGroupType;
import com.mftvanak.edusys.ws.gheyas.schemas.GheyasClassType;
import com.mftvanak.edusys.ws.gheyas.schemas.GheyasDebtorType;
import com.mftvanak.edusys.ws.gheyas.schemas.GheyasStudentType;
import com.mftvanak.edusys.ws.gheyas.schemas.GheyasTermType;
import com.mftvanak.edusys.ws.gheyas.schemas.SearchStudentsRequest;
import com.mftvanak.edusys.ws.gheyas.schemas.SearchStudentsResponse;
import com.mftvanak.edusys.ws.gheyas.schemas.UpdateStudentDaneshgahFieldRequest;
import com.mftvanak.edusys.ws.gheyas.schemas.UpdateStudentDaneshgahFieldResponse;
import com.mftvanak.edusys.ws.gheyas.services.AuditService;
import com.mftvanak.edusys.ws.gheyas.services.GheyasService;
import com.mftvanak.edusys.ws.gheyas.services.SecurityService;


@Endpoint
public class GheyasServiceEndpoint {

  @Autowired
  private GheyasService gheyasService;

  @Autowired
  private SecurityService securityService;

  @Autowired
  private AuditService auditService;

  @PayloadRoot (namespace = "http://gheyas.ws.edusys.mftvanak.com/schemas", localPart = "GetTermsRequest")
  public @ResponsePayload
  GetTermsResponse handleGetTermsRequest (@RequestPayload GetTermsRequest request) throws TokenIsNotAuthenticatedException,
      AuthenticationFailedException, UserIsNotAuthorizedException, UserIsNotActiveException, ClientInformationNeededException {
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
      auditService.addAuditLog (token, "GetTerms", "GheyasService", "0.0.1", "Retrieving all terms", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    GetTermsResponse response = new GetTermsResponse ();
    for (GheyasTerm gheyasTerm : gheyasService.getTerms (request.getInstituteId ())) {
      GheyasTermType gheyasTermType = new GheyasTermType ();
      gheyasTermType.setCode (gheyasTerm.getCode ());
      gheyasTermType.setName (gheyasTerm.getName ());
      response.getGheyasGroups ().add (gheyasTermType);
    }
    return response;
  }

  @PayloadRoot (namespace = "http://gheyas.ws.edusys.mftvanak.com/schemas", localPart = "GetGroupsRequest")
  public @ResponsePayload
  GetGroupsResponse handleGetGroupsRequest (@RequestPayload GetGroupsRequest request) throws TokenIsNotAuthenticatedException,
      AuthenticationFailedException, UserIsNotAuthorizedException, UserIsNotActiveException, ClientInformationNeededException {
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
      auditService.addAuditLog (token, "GetGroups", "GheyasService", "0.0.1", "Retrieving all groups", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    GetGroupsResponse response = new GetGroupsResponse ();
    for (GheyasClassGroup gheyasClassGroup : gheyasService.getGroups (request.getInstituteId ())) {
      GheyasClassGroupType gheyasClassGroupType = new GheyasClassGroupType ();
      gheyasClassGroupType.setCode (gheyasClassGroup.getCode ());
      gheyasClassGroupType.setName (gheyasClassGroup.getName ());
      gheyasClassGroupType.setDescription (gheyasClassGroup.getDescription ());
      response.getGheyasGroups ().add (gheyasClassGroupType);
    }
    return response;
  }

  @PayloadRoot (namespace = "http://gheyas.ws.edusys.mftvanak.com/schemas", localPart = "GetClassesRequest")
  public @ResponsePayload
  GetClassesResponse handleGetClassesRequest (@RequestPayload GetClassesRequest request) throws TokenIsNotAuthenticatedException,
      AuthenticationFailedException, UserIsNotAuthorizedException, UserIsNotActiveException, ClientInformationNeededException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null || request.getClientIpAddress () == null || request.getClientComputerName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 && request.getClientDateTimeMonth () >= 0 && request.getClientDateTimeDay () >= 0
        && request.getClientDateTimeHour () >= 0 && request.getClientDateTimeMinute () >= 0 && request.getClientDateTimeSecond () >= 0
        && request.getClientDateTimeMilliSecond () >= 0 && !request.getClientMacAddress ().isEmpty () && !request.getClientIpAddress ().isEmpty ()
        && !request.getClientComputerName ().isEmpty () && !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (token, "GetClasses", "GheyasService", "0.0.1", "Retrieving all classes with termCodes '" + request.getTermCodes ()
          + "' and groupCodes '" + request.getGroupCodes () + "' and code '" + request.getClassCode () + "'", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    GetClassesResponse response = new GetClassesResponse ();
    for (GheyasClass gheyasClass : gheyasService.getClasses (request.getInstituteId (), request.getGroupCodes (), request.getTermCodes (),
        request.getClassNamePattern (), request.isShowAll (), request.getClassName (), request.getClassCode ())) {
      GheyasClassType gheyasClassType = new GheyasClassType ();
      gheyasClassType.setActiveDays (gheyasClass.getActiveDays ());
      gheyasClassType.setDescription (gheyasClass.getDescription ());
      gheyasClassType.setCode (gheyasClass.getCode ());
      gheyasClassType.setName (gheyasClass.getName ());
      gheyasClassType.setTeacherTarafHesabCode (gheyasClass.getTeacherTarafHesabCode ());
      gheyasClassType.setTeacherName (gheyasClass.getTeacherName ());
      gheyasClassType.setTeacherFamily (gheyasClass.getTeacherFamily ());
      gheyasClassType.setTeacherPhone1 (gheyasClass.getTeacherPhone1 ());
      gheyasClassType.setTeacherPhone2 (gheyasClass.getTeacherPhone2 ());
      gheyasClassType.setTeacherEmail (gheyasClass.getTeacherEmail ());
      gheyasClassType.setStartDate (gheyasClass.getStartDate ());
      gheyasClassType.setEndDate (gheyasClass.getEndDate ());
      gheyasClassType.setNumberOfStudents (gheyasClass.getNumberOfStudents ());
      response.getGheyasClasses ().add (gheyasClassType);
    }
    return response;
  }

  @PayloadRoot (namespace = "http://gheyas.ws.edusys.mftvanak.com/schemas", localPart = "GetStudentsRequest")
  public @ResponsePayload
  GetStudentsResponse handleGetStudentsRequest (@RequestPayload GetStudentsRequest request) throws TokenIsNotAuthenticatedException,
      AuthenticationFailedException, UserIsNotAuthorizedException, UserIsNotActiveException, ClientInformationNeededException {
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
      auditService.addAuditLog (token, "GetStudents", "GheyasService", "0.0.1", "Retrieving all students for class '" + request.getClassCode ()
          + "'", "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    GetStudentsResponse response = new GetStudentsResponse ();
    for (GheyasStudent gheyasStudent : gheyasService.getStudents (request.getInstituteId (), request.getClassCode ())) {
      GheyasStudentType gheyasStudentType = new GheyasStudentType ();
      gheyasStudentType.setAddress (gheyasStudent.getAddress ());
      gheyasStudentType.setBirthDate (gheyasStudent.getBirthDate ());
      gheyasStudentType.setKaramuzCode (gheyasStudent.getKaramuzCode ());
      gheyasStudentType.setTarafHesabCode (gheyasStudent.getTarafHesabCode ());
      gheyasStudentType.setDescription (gheyasStudent.getDescription ());
      gheyasStudentType.setEmail (gheyasStudent.getEmail ());
      gheyasStudentType.setPhone (gheyasStudent.getPhone ());
      gheyasStudentType.setEmergencyPhone (gheyasStudent.getEmergencyPhone ());
      gheyasStudentType.setFamily (gheyasStudent.getFamily ());
      gheyasStudentType.setName (gheyasStudent.getName ());
      gheyasStudentType.setPaid (gheyasStudent.getPaid ());
      gheyasStudentType.setPayment (gheyasStudent.getPayment ());
      gheyasStudentType.setPaymentDate (gheyasStudent.getPaymentDate ());
      gheyasStudentType.setReshteh (gheyasStudent.getReshteh ());
      gheyasStudentType.setDaneshgah (gheyasStudent.getDaneshgah ());
      gheyasStudentType.setClassName (gheyasStudent.getClassName ());
      gheyasStudentType.setClassCode (gheyasStudent.getClassCode ());
      gheyasStudentType.setState (gheyasStudent.getState ());
      response.getGheyasStudents ().add (gheyasStudentType);
    }
    return response;
  }

  @PayloadRoot (namespace = "http://gheyas.ws.edusys.mftvanak.com/schemas", localPart = "SearchStudentsRequest")
  public @ResponsePayload
  SearchStudentsResponse handleSearchStudentsRequest (@RequestPayload SearchStudentsRequest request) throws TokenIsNotAuthenticatedException,
      AuthenticationFailedException, UserIsNotAuthorizedException, UserIsNotActiveException, ClientInformationNeededException {
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
      auditService.addAuditLog (token, "SearchStudents", "GheyasService", "0.0.1",
          "Retrieving all students matching with name '" + request.getName () + " and family '" + request.getFamily () + "'", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    SearchStudentsResponse response = new SearchStudentsResponse ();
    for (GheyasStudent gheyasStudent : gheyasService.searchStudents (request.getInstituteId (), request.getName (), request.getFamily ())) {
      GheyasStudentType gheyasStudentType = new GheyasStudentType ();
      gheyasStudentType.setAddress (gheyasStudent.getAddress ());
      gheyasStudentType.setBirthDate (gheyasStudent.getBirthDate ());
      gheyasStudentType.setKaramuzCode (gheyasStudent.getKaramuzCode ());
      gheyasStudentType.setTarafHesabCode (gheyasStudent.getTarafHesabCode ());
      gheyasStudentType.setDescription (gheyasStudent.getDescription ());
      gheyasStudentType.setEmail (gheyasStudent.getEmail ());
      gheyasStudentType.setPhone (gheyasStudent.getPhone ());
      gheyasStudentType.setEmergencyPhone (gheyasStudent.getEmergencyPhone ());
      gheyasStudentType.setFamily (gheyasStudent.getFamily ());
      gheyasStudentType.setName (gheyasStudent.getName ());
      gheyasStudentType.setPaid (gheyasStudent.getPaid ());
      gheyasStudentType.setPayment (gheyasStudent.getPayment ());
      gheyasStudentType.setPaymentDate (gheyasStudent.getPaymentDate ());
      gheyasStudentType.setReshteh (gheyasStudent.getReshteh ());
      gheyasStudentType.setDaneshgah (gheyasStudent.getDaneshgah ());
      gheyasStudentType.setClassName (gheyasStudent.getClassName ());
      gheyasStudentType.setClassCode (gheyasStudent.getClassCode ());
      gheyasStudentType.setState (gheyasStudent.getState ());
      response.getGheyasStudents ().add (gheyasStudentType);
    }
    return response;
  }

  @PayloadRoot (namespace = "http://gheyas.ws.edusys.mftvanak.com/schemas", localPart = "GetDebtorsRequest")
  public @ResponsePayload
  GetDebtorsResponse handleGetDebtorsRequest (@RequestPayload GetDebtorsRequest request) throws TokenIsNotAuthenticatedException,
      AuthenticationFailedException, UserIsNotAuthorizedException, UserIsNotActiveException, ClientInformationNeededException {
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
      auditService.addAuditLog (token, "GetDebtors", "GheyasService", "0.0.1", "Retrieving all debtors ...", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    GetDebtorsResponse response = new GetDebtorsResponse ();
    for (GheyasDebtor gheyasDebtor : gheyasService.getDebtors (request.getInstituteId ())) {
      GheyasDebtorType gheyasDebtorType = new GheyasDebtorType ();
      gheyasDebtorType.setAddress (gheyasDebtor.getAddress ());
      gheyasDebtorType.setCode (gheyasDebtor.getCode ());
      gheyasDebtorType.setDebt (gheyasDebtor.getDebt ());
      gheyasDebtorType.setEmail (gheyasDebtor.getEmail ());
      gheyasDebtorType.setPhone1 (gheyasDebtor.getPhone1 ());
      gheyasDebtorType.setPhone2 (gheyasDebtor.getPhone2 ());
      gheyasDebtorType.setFamily (gheyasDebtor.getFamily ());
      gheyasDebtorType.setName (gheyasDebtor.getName ());
      gheyasDebtorType.setPaid (gheyasDebtor.getPaid ());
      gheyasDebtorType.setDiscount (gheyasDebtor.getDiscount ());
      gheyasDebtorType.setShouldPay (gheyasDebtor.getShouldPay ());
      response.getGheyasDebtors ().add (gheyasDebtorType);
    }
    return response;
  }

  @PayloadRoot (namespace = "http://gheyas.ws.edusys.mftvanak.com/schemas", localPart = "UpdateStudentDaneshgahFieldRequest")
  public @ResponsePayload
  UpdateStudentDaneshgahFieldResponse handleUpdateStudentDaneshgahFieldRequest (@RequestPayload UpdateStudentDaneshgahFieldRequest request)
      throws TokenIsNotAuthenticatedException, AuthenticationFailedException, UserIsNotAuthorizedException, UserIsNotActiveException,
      ClientInformationNeededException {
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
      auditService.addAuditLog (token, "UpdateStudentDaneshgahField", "GheyasService", "0.0.1", "Updating daneshgah field for student with id: '"
          + request.getKaramuzCode () + "' ...", "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (),
          request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    gheyasService.updateStudentDaneshgahField (request.getInstituteId (), request.getKaramuzCode (), request.getDaneshaghFieldNewValue ());
    UpdateStudentDaneshgahFieldResponse response = new UpdateStudentDaneshgahFieldResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://gheyas.ws.edusys.mftvanak.com/schemas", localPart = "GetCommonClassesRequest")
  public @ResponsePayload
  GetCommonClassesResponse handleGetCommonClassesRequest (@RequestPayload GetCommonClassesRequest request)
      throws TokenIsNotAuthenticatedException, AuthenticationFailedException, UserIsNotAuthorizedException, UserIsNotActiveException,
      ClientInformationNeededException {
    Token token = securityService.authenticateAndAuthorizeToken (request.getToken ());
    if (request.getClientMacAddress () == null || request.getClientIpAddress () == null || request.getClientComputerName () == null) {
      throw new ClientInformationNeededException ();
    }
    if (request.getClientDateTimeYear () >= 0 && request.getClientDateTimeMonth () >= 0 && request.getClientDateTimeDay () >= 0
        && request.getClientDateTimeHour () >= 0 && request.getClientDateTimeMinute () >= 0 && request.getClientDateTimeSecond () >= 0
        && request.getClientDateTimeMilliSecond () >= 0 && !request.getClientMacAddress ().isEmpty () && !request.getClientIpAddress ().isEmpty ()
        && !request.getClientComputerName ().isEmpty () && !request.getApplicationName ().isEmpty ()) {
      DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (),
          request.getClientDateTimeDay (), request.getClientDateTimeHour (), request.getClientDateTimeMinute (),
          request.getClientDateTimeSecond (), request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
      auditService.addAuditLog (token, "GetCommonClasses", "GheyasService", "0.0.1",
          "Retrieving all common classes with termCodes '" + request.getTermCodes () + "' and groupCodes '" + request.getGroupCodes () + "'", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    GetCommonClassesResponse response = new GetCommonClassesResponse ();
    for (GheyasClass gheyasClass : gheyasService.getCommonClasses (request.getGroupCodes (), request.getTermCodes ())) {
      GheyasClassType gheyasClassType = new GheyasClassType ();
      gheyasClassType.setActiveDays (gheyasClass.getActiveDays ());
      gheyasClassType.setDescription (gheyasClass.getDescription ());
      gheyasClassType.setCode (gheyasClass.getCode ());
      gheyasClassType.setName (gheyasClass.getName ());
      gheyasClassType.setTeacherTarafHesabCode (gheyasClass.getTeacherTarafHesabCode ());
      gheyasClassType.setTeacherName (gheyasClass.getTeacherName ());
      gheyasClassType.setTeacherFamily (gheyasClass.getTeacherFamily ());
      gheyasClassType.setTeacherPhone1 (gheyasClass.getTeacherPhone1 ());
      gheyasClassType.setTeacherPhone2 (gheyasClass.getTeacherPhone2 ());
      gheyasClassType.setTeacherEmail (gheyasClass.getTeacherEmail ());
      gheyasClassType.setStartDate (gheyasClass.getStartDate ());
      gheyasClassType.setEndDate (gheyasClass.getEndDate ());
      gheyasClassType.setNumberOfStudents (gheyasClass.getNumberOfStudents ());
      response.getGheyasClasses ().add (gheyasClassType);
    }
    return response;
  }
}
