package com.mftvanak.edusys.ws.phonebook.endpoints;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mftvanak.edusys.domain.dao.phonebook.PhoneEntrySearchPredicate;
import com.mftvanak.edusys.domain.entity.ColorType;
import com.mftvanak.edusys.domain.entity.education.Department;
import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.domain.entity.official.Employee;
import com.mftvanak.edusys.domain.entity.phonebook.PhoneEntry;
import com.mftvanak.edusys.domain.entity.phonebook.PhoneEntry.TypeDeMethodDeConnaissance;
import com.mftvanak.edusys.ws.exceptions.AuthenticationFailedException;
import com.mftvanak.edusys.ws.exceptions.ClientInformationNeededException;
import com.mftvanak.edusys.ws.exceptions.DepartmentNotFoundException;
import com.mftvanak.edusys.ws.exceptions.EmployeeNotFoundException;
import com.mftvanak.edusys.ws.exceptions.PhoneEntryNotFoundException;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotActiveException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;
import com.mftvanak.edusys.ws.phonebook.schemas.AddPhoneEntryRequest;
import com.mftvanak.edusys.ws.phonebook.schemas.AddPhoneEntryResponse;
import com.mftvanak.edusys.ws.phonebook.schemas.DeletePhoneEntryRequest;
import com.mftvanak.edusys.ws.phonebook.schemas.DeletePhoneEntryResponse;
import com.mftvanak.edusys.ws.phonebook.schemas.GetPhoneEntriesByOwnerIdRequest;
import com.mftvanak.edusys.ws.phonebook.schemas.GetPhoneEntriesByOwnerIdResponse;
import com.mftvanak.edusys.ws.phonebook.schemas.GetPhoneEntriesByPredicateRequest;
import com.mftvanak.edusys.ws.phonebook.schemas.GetPhoneEntriesByPredicateResponse;
import com.mftvanak.edusys.ws.phonebook.schemas.GetPhoneEntryByIdRequest;
import com.mftvanak.edusys.ws.phonebook.schemas.GetPhoneEntryByIdResponse;
import com.mftvanak.edusys.ws.phonebook.schemas.PhoneEntryType;
import com.mftvanak.edusys.ws.phonebook.schemas.UpdatePhoneEntryRequest;
import com.mftvanak.edusys.ws.phonebook.schemas.UpdatePhoneEntryResponse;
import com.mftvanak.edusys.ws.phonebook.services.AuditService;
import com.mftvanak.edusys.ws.phonebook.services.EducationService;
import com.mftvanak.edusys.ws.phonebook.services.FollowUpService;
import com.mftvanak.edusys.ws.phonebook.services.OfficialService;
import com.mftvanak.edusys.ws.phonebook.services.PhoneEntryService;
import com.mftvanak.edusys.ws.phonebook.services.SecurityService;


@Endpoint
public class PhoneBookServiceEndpoint {

  @Autowired
  private PhoneEntryService phoneEntryService;

  @Autowired
  private FollowUpService followUpService;

  @Autowired
  private EducationService educationService;

  @Autowired
  private OfficialService officialService;

  @Autowired
  private SecurityService securityService;

  @Autowired
  private AuditService auditService;

  @SuppressWarnings ("unused")
  private Logger logger = Logger.getLogger (PhoneBookServiceEndpoint.class);

  @PayloadRoot (namespace = "http://phonebook.ws.edusys.mftvanak.com/schemas", localPart = "AddPhoneEntryRequest")
  public @ResponsePayload
  AddPhoneEntryResponse handleAddPhoneEntry (@RequestPayload AddPhoneEntryRequest request) throws AuthenticationFailedException,
      DepartmentNotFoundException, EmployeeNotFoundException, TokenIsNotAuthenticatedException, UserIsNotAuthorizedException,
      UserIsNotActiveException, ClientInformationNeededException {
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
      auditService.addAuditLog (token, "AddPhoneEntry", "PhoneBookService", "0.0.1", "Adding phone entry ...", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Department department = educationService.getDepartmentById (request.getPhoneEntry ().getDepartmentId ());
    if (department == null) {
      throw new DepartmentNotFoundException ();
    }
    Employee employee = officialService.getEmployeeById (request.getPhoneEntry ().getOwnerId ());
    if (employee == null) {
      throw new EmployeeNotFoundException ();
    }
    PhoneEntry phoneEntry = new PhoneEntry ();
    if (request.getPhoneEntry ().getColor () != null) {
      phoneEntry.setColor (ColorType.valueOf (request.getPhoneEntry ().getColor ().value ()));
    } else {
      phoneEntry.setColor (null);
    }
    phoneEntry.setMethodDeConnaissance (TypeDeMethodDeConnaissance.valueOf (request.getPhoneEntry ().getMethodDeConnaissance ()));
    phoneEntry.setDepartment (department);
    phoneEntry.setDescription (request.getPhoneEntry ().getDescription ());
    phoneEntry.setName (request.getPhoneEntry ().getName ());
    phoneEntry.setNumber (request.getPhoneEntry ().getNumber ());
    phoneEntry.setOwner (employee);
    phoneEntry.setSeen (request.getPhoneEntry ().isSeen ());
    phoneEntry.setShouldBeFollowed (request.getPhoneEntry ().isShouldBeFollowed ());
    phoneEntry.setPrivateClass (request.getPhoneEntry ().isPrivate ());
    phoneEntry.setRegistered (request.getPhoneEntry ().isRegistered ());
    phoneEntry.setSubmitDate (new Date ().getTime ());
    phoneEntry.setResponse (request.getPhoneEntry ().getResponse ());
    Long id = phoneEntryService.addPhoneEntry (phoneEntry);
    DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (), request.getClientDateTimeDay (),
        request.getClientDateTimeHour (), request.getClientDateTimeMinute (), request.getClientDateTimeSecond (),
        request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
    auditService.addAuditLog (token, "AddPhoneEntry", "PhoneBookService", "0.0.1", "Phone entry is added with id '" + id + "'",
        phoneEntry.toString (), clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (),
        request.getClientComputerName (), request.getApplicationName ());
    AddPhoneEntryResponse response = new AddPhoneEntryResponse ();
    response.setPhoneEntryId (id);
    return response;
  }

  @PayloadRoot (namespace = "http://phonebook.ws.edusys.mftvanak.com/schemas", localPart = "UpdatePhoneEntryRequest")
  public @ResponsePayload
  UpdatePhoneEntryResponse handleUpdatePhoneEntry (@RequestPayload UpdatePhoneEntryRequest request) throws AuthenticationFailedException,
      DepartmentNotFoundException, EmployeeNotFoundException, TokenIsNotAuthenticatedException, UserIsNotAuthorizedException,
      UserIsNotActiveException, ClientInformationNeededException {
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
      auditService.addAuditLog (token, "UpdatePhoneEntry", "PhoneBookService", "0.0.1", "Updating phone entry with id '" +
          request.getPhoneEntry ().getId () +
          "'", "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Department department = educationService.getDepartmentById (request.getPhoneEntry ().getDepartmentId ());
    if (department == null) {
      throw new DepartmentNotFoundException ();
    }
    Employee employee = officialService.getEmployeeById (request.getPhoneEntry ().getOwnerId ());
    if (employee == null) {
      throw new EmployeeNotFoundException ();
    }
    PhoneEntry phoneEntry = phoneEntryService.getPhoneEntryById (request.getPhoneEntry ().getId ());
    DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (), request.getClientDateTimeDay (),
        request.getClientDateTimeHour (), request.getClientDateTimeMinute (), request.getClientDateTimeSecond (),
        request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
    auditService.addAuditLog (token, "UpdatePhoneEntry", "PhoneBookService", "0.0.1",
        "Phone entry is being updated with id '" + phoneEntry.getId () + "'", phoneEntry.toString (), clientDateTime.getMillis (),
        request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    if (request.getPhoneEntry ().getColor () != null) {
      phoneEntry.setColor (ColorType.valueOf (request.getPhoneEntry ().getColor ().value ()));
    } else {
      phoneEntry.setColor (null);
    }
    phoneEntry.setMethodDeConnaissance (TypeDeMethodDeConnaissance.valueOf (request.getPhoneEntry ().getMethodDeConnaissance ()));
    phoneEntry.setDepartment (department);
    phoneEntry.setDescription (request.getPhoneEntry ().getDescription ());
    phoneEntry.setName (request.getPhoneEntry ().getName ());
    phoneEntry.setNumber (request.getPhoneEntry ().getNumber ());
    phoneEntry.setOwner (employee);
    phoneEntry.setSeen (request.getPhoneEntry ().isSeen ());
    phoneEntry.setShouldBeFollowed (request.getPhoneEntry ().isShouldBeFollowed ());
    phoneEntry.setPrivateClass (request.getPhoneEntry ().isPrivate ());
    phoneEntry.setRegistered (request.getPhoneEntry ().isRegistered ());
    phoneEntry.setResponse (request.getPhoneEntry ().getResponse ());
    phoneEntryService.updatePhoneEntry (phoneEntry);
    auditService.addAuditLog (token, "UpdatePhoneEntry", "PhoneBookService", "0.0.1", "Phone entry is updated with id '" +
        phoneEntry.getId () +
        "'", phoneEntry.toString (), clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (),
        request.getClientComputerName (), request.getApplicationName ());
    UpdatePhoneEntryResponse response = new UpdatePhoneEntryResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://phonebook.ws.edusys.mftvanak.com/schemas", localPart = "DeletePhoneEntryRequest")
  public @ResponsePayload
  DeletePhoneEntryResponse handleDeletePhoneEntry (@RequestPayload DeletePhoneEntryRequest request) throws AuthenticationFailedException,
      TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, PhoneEntryNotFoundException, UserIsNotActiveException,
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
      auditService.addAuditLog (token, "DeletePhoneEntry", "PhoneBookService", "0.0.1",
          "Deleting phonebook with nodeId '" + request.getPhoneEntryId () + "'", "", clientDateTime.getMillis (), request.getClientMacAddress (),
          request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    PhoneEntry phoneEntry = phoneEntryService.getPhoneEntryById (request.getPhoneEntryId ());
    if (phoneEntry == null) {
      throw new PhoneEntryNotFoundException ();
    }
    phoneEntryService.deletePhoneEntry (request.getPhoneEntryId ());
    DeletePhoneEntryResponse response = new DeletePhoneEntryResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://phonebook.ws.edusys.mftvanak.com/schemas", localPart = "GetPhoneEntryByIdRequest")
  public @ResponsePayload
  GetPhoneEntryByIdResponse handleGetPhoneEntryByIdRequest (@RequestPayload GetPhoneEntryByIdRequest request)
      throws AuthenticationFailedException, TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, UserIsNotActiveException,
      ClientInformationNeededException, EmployeeNotFoundException {
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
      auditService.addAuditLog (token, "GetPhoneEntryById", "PhoneBookService", "0.0.1",
          "Getting phonebook with nodeId '" + request.getPhoneEntryId () + "'", "", clientDateTime.getMillis (), request.getClientMacAddress (),
          request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }

    PhoneEntry phoneEntry = phoneEntryService.getPhoneEntryById (request.getPhoneEntryId ());
    Employee employee = officialService.getEmployeeById (phoneEntry.getOwner ().getPersonId ());
    if (employee == null) {
      throw new EmployeeNotFoundException ();
    }
    GetPhoneEntryByIdResponse response = new GetPhoneEntryByIdResponse ();
    PhoneEntryType phoneEntryType = new PhoneEntryType ();
    if (phoneEntry.getColor () != null) {
      phoneEntryType.setColor (com.mftvanak.edusys.ws.phonebook.schemas.ColorType.fromValue (phoneEntry.getColor ().toString ()));
    }
    phoneEntryType.setMethodDeConnaissance (phoneEntry.getMethodDeConnaissance ().getCode ());
    phoneEntryType.setDepartmentId (phoneEntry.getDepartment ().getId ());
    phoneEntryType.setDepartmentName (phoneEntry.getDepartment ().getPersianName ());
    phoneEntryType.setInstituteId (phoneEntry.getDepartment ().getInstitute ().getId ());
    phoneEntryType.setDescription (phoneEntry.getDescription ());
    phoneEntryType.setResponse (phoneEntry.getResponse ());
    phoneEntryType.setId (phoneEntry.getId ());
    phoneEntryType.setName (phoneEntry.getName ());
    phoneEntryType.setNumber (phoneEntry.getNumber ());
    phoneEntryType.setOwnerId (phoneEntry.getOwner ().getPersonId ());
    phoneEntryType.setOwnerName (employee.getPerson ().getPersianName () + " " + employee.getPerson ().getPersianFamily ());
    if (phoneEntry.getSeen () != null) {
      phoneEntryType.setSeen (phoneEntry.getSeen ());
    } else {
      phoneEntryType.setSeen (false);
    }
    if (phoneEntry.getShouldBeFollowed () != null) {
      phoneEntryType.setShouldBeFollowed (phoneEntry.getShouldBeFollowed ());
    } else {
      phoneEntryType.setShouldBeFollowed (false);
    }
    if (phoneEntry.getPrivateClass () != null) {
      phoneEntryType.setPrivate (phoneEntry.getPrivateClass ());
    } else {
      phoneEntryType.setPrivate (false);
    }
    if (phoneEntry.getRegistered () != null) {
      phoneEntryType.setRegistered (phoneEntry.getRegistered ());
    } else {
      phoneEntryType.setRegistered (false);
    }
    phoneEntryType.setSubmitDate (phoneEntry.getSubmitDate ());
    response.setPhoneEntry (phoneEntryType);
    return response;
  }

  @PayloadRoot (namespace = "http://phonebook.ws.edusys.mftvanak.com/schemas", localPart = "GetPhoneEntriesByOwnerIdRequest")
  public @ResponsePayload
  GetPhoneEntriesByOwnerIdResponse handleGetPhoneEntriesByOwnerIdRequest (@RequestPayload GetPhoneEntriesByOwnerIdRequest request)
      throws AuthenticationFailedException, TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, UserIsNotActiveException,
      ClientInformationNeededException, EmployeeNotFoundException {
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
      auditService.addAuditLog (token, "GetPhoneEntriesByOwnerId", "PhoneBookService", "0.0.1", "Getting " +
          (request.getCount () == 0 ? "all" : request.getCount ()) +
          " latest  phone entri(es) for personId '" +
          request.getOwnerId () +
          "'", "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }

    GetPhoneEntriesByOwnerIdResponse response = new GetPhoneEntriesByOwnerIdResponse ();
    List < PhoneEntry > phoneEntries = phoneEntryService.getPhoneEntriesByOwnerId (request.getOwnerId (), request.getCount ());
    for (PhoneEntry phoneEntry : phoneEntries) {
      PhoneEntryType phoneEntryType = new PhoneEntryType ();
      if (phoneEntry.getColor () != null) {
        phoneEntryType.setColor (com.mftvanak.edusys.ws.phonebook.schemas.ColorType.fromValue (phoneEntry.getColor ().toString ()));
      }
      phoneEntryType.setMethodDeConnaissance (phoneEntry.getMethodDeConnaissance ().getCode ());
      phoneEntryType.setDepartmentId (phoneEntry.getDepartment ().getId ());
      phoneEntryType.setDepartmentName (phoneEntry.getDepartment ().getPersianName ());
      phoneEntryType.setInstituteId (phoneEntry.getDepartment ().getInstitute ().getId ());
      phoneEntryType.setDescription (phoneEntry.getDescription ());
      phoneEntryType.setResponse (phoneEntry.getResponse ());
      phoneEntryType.setId (phoneEntry.getId ());
      phoneEntryType.setName (phoneEntry.getName ());
      phoneEntryType.setNumber (phoneEntry.getNumber ());
      phoneEntryType.setOwnerId (phoneEntry.getOwner ().getPersonId ());
      phoneEntryType.setOwnerName (phoneEntry.getOwner ().getPerson ().getPersianName () +
          " " +
          phoneEntry.getOwner ().getPerson ().getPersianFamily ());
      if (phoneEntry.getSeen () != null) {
        phoneEntryType.setSeen (phoneEntry.getSeen ());
      } else {
        phoneEntryType.setSeen (false);
      }
      if (phoneEntry.getShouldBeFollowed () != null) {
        phoneEntryType.setShouldBeFollowed (phoneEntry.getShouldBeFollowed ());
      } else {
        phoneEntryType.setShouldBeFollowed (false);
      }
      if (phoneEntry.getPrivateClass () != null) {
        phoneEntryType.setPrivate (phoneEntry.getPrivateClass ());
      } else {
        phoneEntryType.setPrivate (false);
      }
      if (phoneEntry.getRegistered () != null) {
        phoneEntryType.setRegistered (phoneEntry.getRegistered ());
      } else {
        phoneEntryType.setRegistered (false);
      }
      phoneEntryType.setSubmitDate (phoneEntry.getSubmitDate ());
      response.getPhoneEntries ().add (phoneEntryType);
    }
    return response;
  }

  @PayloadRoot (namespace = "http://phonebook.ws.edusys.mftvanak.com/schemas", localPart = "GetPhoneEntriesByPredicateRequest")
  public @ResponsePayload
  GetPhoneEntriesByPredicateResponse handleGetPhoneEntriesByPredicateRequest (@RequestPayload GetPhoneEntriesByPredicateRequest request)
      throws AuthenticationFailedException, TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, UserIsNotActiveException,
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
      auditService.addAuditLog (token, "GetPhoneEntriesByPredicate", "PhoneBookService", "0.0.1", "Getting phonebook with predicate", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    PhoneEntrySearchPredicate predicate = new PhoneEntrySearchPredicate ();
    // TODO predicate.setColors (request.getPredicate ().getColors ());
    predicate.setDepartmentId (request.getPredicate ().getDepartmentId ());
    predicate.setDescription (request.getPredicate ().getDescription ());
    predicate.setFollowUpTypes (request.getPredicate ().getFollowUpTypes ());
    predicate.setName (request.getPredicate ().getName ());
    predicate.setNumber (request.getPredicate ().getNumber ());
    predicate.setOwnerId (request.getPredicate ().getOwnerId ());

    if (request.getPredicate ().getSubmitDateStartYear () != null &&
        request.getPredicate ().getSubmitDateStartMonth () != null &&
        request.getPredicate ().getSubmitDateStartDay () != null) {
      Calendar calSubmitDateStart = Calendar.getInstance ();
      calSubmitDateStart.set (Calendar.YEAR, request.getPredicate ().getSubmitDateStartYear ());
      calSubmitDateStart.set (Calendar.MONTH, request.getPredicate ().getSubmitDateStartMonth ());
      System.out.println ("=======> " + request.getPredicate ().getSubmitDateStartMonth ());
      calSubmitDateStart.set (Calendar.DAY_OF_MONTH, request.getPredicate ().getSubmitDateStartDay ());
      calSubmitDateStart.set (Calendar.HOUR, 0);
      calSubmitDateStart.set (Calendar.MINUTE, 0);
      calSubmitDateStart.set (Calendar.SECOND, 0);
      calSubmitDateStart.set (Calendar.MILLISECOND, 0);
      predicate.setSubmitDateStart (calSubmitDateStart.getTime ().getTime ());
      System.out.println ("--> " + calSubmitDateStart.getTime ().toString ());
    }

    if (request.getPredicate ().getSubmitDateEndYear () != null &&
        request.getPredicate ().getSubmitDateEndMonth () != null &&
        request.getPredicate ().getSubmitDateEndDay () != null) {
      Calendar calSubmitDateEnd = Calendar.getInstance ();
      calSubmitDateEnd.set (Calendar.YEAR, request.getPredicate ().getSubmitDateEndYear ());
      calSubmitDateEnd.set (Calendar.MONTH, request.getPredicate ().getSubmitDateEndMonth ());
      calSubmitDateEnd.set (Calendar.DAY_OF_MONTH, request.getPredicate ().getSubmitDateEndDay ());
      calSubmitDateEnd.set (Calendar.HOUR, 23);
      calSubmitDateEnd.set (Calendar.MINUTE, 59);
      calSubmitDateEnd.set (Calendar.SECOND, 59);
      calSubmitDateEnd.set (Calendar.MILLISECOND, 999);
      predicate.setSubmitDateEnd (calSubmitDateEnd.getTime ().getTime ());
      System.out.println ("--> " + calSubmitDateEnd.getTime ().toString ());
    }
    GetPhoneEntriesByPredicateResponse response = new GetPhoneEntriesByPredicateResponse ();
    List < PhoneEntry > phoneEntries = phoneEntryService.getPhoneEntriesByPredicate (predicate);
    for (PhoneEntry phoneEntry : phoneEntries) {
      PhoneEntryType phoneEntryType = new PhoneEntryType ();
      if (phoneEntry.getColor () != null) {
        phoneEntryType.setColor (com.mftvanak.edusys.ws.phonebook.schemas.ColorType.fromValue (phoneEntry.getColor ().toString ()));
      }
      phoneEntryType.setMethodDeConnaissance (phoneEntry.getMethodDeConnaissance ().getCode ());
      phoneEntryType.setDepartmentId (phoneEntry.getDepartment ().getId ());
      phoneEntryType.setDepartmentName (phoneEntry.getDepartment ().getPersianName ());
      phoneEntryType.setInstituteId (phoneEntry.getDepartment ().getInstitute ().getId ());
      phoneEntryType.setDescription (phoneEntry.getDescription ());
      phoneEntryType.setResponse (phoneEntry.getResponse ());
      phoneEntryType.setId (phoneEntry.getId ());
      phoneEntryType.setName (phoneEntry.getName ());
      phoneEntryType.setNumber (phoneEntry.getNumber ());
      phoneEntryType.setOwnerId (phoneEntry.getOwner ().getPersonId ());
      phoneEntryType.setOwnerName (phoneEntry.getOwner ().getPerson ().getPersianName () +
          " " +
          phoneEntry.getOwner ().getPerson ().getPersianFamily ());
      if (phoneEntry.getSeen () != null) {
        phoneEntryType.setSeen (phoneEntry.getSeen ());
      } else {
        phoneEntryType.setSeen (false);
      }
      if (phoneEntry.getShouldBeFollowed () != null) {
        phoneEntryType.setShouldBeFollowed (phoneEntry.getShouldBeFollowed ());
      } else {
        phoneEntryType.setShouldBeFollowed (false);
      }
      if (phoneEntry.getPrivateClass () != null) {
        phoneEntryType.setPrivate (phoneEntry.getPrivateClass ());
      } else {
        phoneEntryType.setPrivate (false);
      }
      if (phoneEntry.getRegistered () != null) {
        phoneEntryType.setRegistered (phoneEntry.getRegistered ());
      } else {
        phoneEntryType.setRegistered (false);
      }
      phoneEntryType.setSubmitDate (phoneEntry.getSubmitDate ());
      response.getPhoneEntries ().add (phoneEntryType);
    }
    return response;
  }
}
