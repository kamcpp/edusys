package com.mftvanak.edusys.ws.official.endpoints;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.domain.entity.official.Employee;
import com.mftvanak.edusys.domain.entity.personnel.Person;
import com.mftvanak.edusys.ws.exceptions.ClientInformationNeededException;
import com.mftvanak.edusys.ws.exceptions.EmployeeNotFoundException;
import com.mftvanak.edusys.ws.exceptions.PersonNotFoundException;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotActiveException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;
import com.mftvanak.edusys.ws.official.schemas.AddEmployeeRequest;
import com.mftvanak.edusys.ws.official.schemas.AddEmployeeResponse;
import com.mftvanak.edusys.ws.official.schemas.DeleteEmployeeRequest;
import com.mftvanak.edusys.ws.official.schemas.DeleteEmployeeResponse;
import com.mftvanak.edusys.ws.official.schemas.EmployeeExistsByEmployeeNumberRequest;
import com.mftvanak.edusys.ws.official.schemas.EmployeeExistsByEmployeeNumberResponse;
import com.mftvanak.edusys.ws.official.schemas.GetEmployeeByEmployeeNumberRequest;
import com.mftvanak.edusys.ws.official.schemas.GetEmployeeByEmployeeNumberResponse;
import com.mftvanak.edusys.ws.official.schemas.GetEmployeeByIdRequest;
import com.mftvanak.edusys.ws.official.schemas.GetEmployeeByIdResponse;
import com.mftvanak.edusys.ws.official.schemas.GetEmployeeSummariesRequest;
import com.mftvanak.edusys.ws.official.schemas.GetEmployeeSummariesResponse;
import com.mftvanak.edusys.ws.official.schemas.GetEmployeesRequest;
import com.mftvanak.edusys.ws.official.schemas.GetEmployeesResponse;
import com.mftvanak.edusys.ws.official.schemas.UpdateEmployeeRequest;
import com.mftvanak.edusys.ws.official.schemas.UpdateEmployeeResponse;
import com.mftvanak.edusys.ws.official.schemas.types.EmployeeSummaryType;
import com.mftvanak.edusys.ws.official.schemas.types.EmployeeType;
import com.mftvanak.edusys.ws.official.services.AuditService;
import com.mftvanak.edusys.ws.official.services.EmployeeService;
import com.mftvanak.edusys.ws.official.services.PersonnelService;
import com.mftvanak.edusys.ws.official.services.SecurityService;


@Endpoint
public class EmployeeServiceEndpoint {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private PersonnelService personnelService;

  @Autowired
  private SecurityService securityService;

  @Autowired
  private AuditService auditService;

  @PayloadRoot (namespace = "http://official.ws.edusys.mftvanak.com/schemas", localPart = "AddEmployeeRequest")
  public @ResponsePayload
  AddEmployeeResponse handleAddEmployeeRequest (@RequestPayload AddEmployeeRequest request) throws TokenIsNotAuthenticatedException,
      UserIsNotAuthorizedException, PersonNotFoundException, UserIsNotActiveException, ClientInformationNeededException {
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
      auditService.addAuditLog (token, "AddEmployee", "EmployeeService", "0.0.1", "Adding employee with personId '" +
          request.getEmployee ().getPersonId () +
          "'", "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Person person = personnelService.getPersonById (request.getEmployee ().getPersonId ());
    if (person == null) {
      throw new PersonNotFoundException ();
    }
    Employee employee = new Employee ();
    employee.setPerson (person);
    employee.setEmployeeNumber (request.getEmployee ().getEmployeeNumber ());
    Long id = employeeService.addEmployee (employee);
    DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (), request.getClientDateTimeDay (),
        request.getClientDateTimeHour (), request.getClientDateTimeMinute (), request.getClientDateTimeSecond (),
        request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
    auditService.addAuditLog (token, "AddEmployee", "EmployeeService", "0.0.1", "Employee is added with personId '" +
        request.getEmployee ().getPersonId () +
        "'", "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
        request.getApplicationName ());
    AddEmployeeResponse response = new AddEmployeeResponse ();
    response.setEmployeeId (id);
    return response;
  }

  @PayloadRoot (namespace = "http://official.ws.edusys.mftvanak.com/schemas", localPart = "UpdateEmployeeRequest")
  public @ResponsePayload
  UpdateEmployeeResponse handleUpdateEmployeeRequest (@RequestPayload UpdateEmployeeRequest request) throws TokenIsNotAuthenticatedException,
      UserIsNotAuthorizedException, EmployeeNotFoundException, UserIsNotActiveException, ClientInformationNeededException {
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
      auditService.addAuditLog (token, "UpdateEmployee", "EmployeeService", "0.0.1", "Updating employee with personId '" +
          request.getEmployee ().getPersonId () +
          "'", "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Employee employee = employeeService.getEmployeeById (request.getEmployee ().getPersonId ());
    if (employee == null) {
      throw new EmployeeNotFoundException ();
    }
    employee.setEmployeeNumber (request.getEmployee ().getEmployeeNumber ());
    employeeService.updateEmployee (employee);
    UpdateEmployeeResponse response = new UpdateEmployeeResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://official.ws.edusys.mftvanak.com/schemas", localPart = "DeleteEmployeeRequest")
  public @ResponsePayload
  DeleteEmployeeResponse handleDeleteEmployeeRequest (@RequestPayload DeleteEmployeeRequest request) throws TokenIsNotAuthenticatedException,
      UserIsNotAuthorizedException, EmployeeNotFoundException, UserIsNotActiveException, ClientInformationNeededException {
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
      auditService.addAuditLog (token, "DeleteEmployee", "EmployeeService", "0.0.1",
          "Deleting employee with personId '" + request.getEmployeeId () + "'", "", clientDateTime.getMillis (), request.getClientMacAddress (),
          request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Employee employee = employeeService.getEmployeeById (request.getEmployeeId ());
    if (employee == null) {
      throw new EmployeeNotFoundException ();
    }
    employeeService.deleteEmployee (request.getEmployeeId ());
    DeleteEmployeeResponse response = new DeleteEmployeeResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://official.ws.edusys.mftvanak.com/schemas", localPart = "GetEmployeeByIdRequest")
  public @ResponsePayload
  GetEmployeeByIdResponse handleGetEmployeeByIdRequest (@RequestPayload GetEmployeeByIdRequest request) throws TokenIsNotAuthenticatedException,
      UserIsNotAuthorizedException, EmployeeNotFoundException, UserIsNotActiveException, ClientInformationNeededException {
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
      auditService.addAuditLog (token, "GetEmployeeById", "EmployeeService", "0.0.1",
          "Getting employee with personId '" + request.getEmployeeId () + "'", "", clientDateTime.getMillis (), request.getClientMacAddress (),
          request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Employee employee = employeeService.getEmployeeById (request.getEmployeeId ());
    if (employee == null) {
      throw new EmployeeNotFoundException ();
    }
    EmployeeType employeeType = new EmployeeType ();
    employeeType.setPersonId (employee.getPersonId ());
    employeeType.setEmployeeNumber (employee.getEmployeeNumber ());
    GetEmployeeByIdResponse response = new GetEmployeeByIdResponse ();
    response.setEmployee (employeeType);
    return response;
  }

  @PayloadRoot (namespace = "http://official.ws.edusys.mftvanak.com/schemas", localPart = "GetEmployeeByEmployeeNumberRequest")
  public @ResponsePayload
  GetEmployeeByEmployeeNumberResponse handleGetEmployeeByEmployeeNumberRequest (@RequestPayload GetEmployeeByEmployeeNumberRequest request)
      throws TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, EmployeeNotFoundException, UserIsNotActiveException,
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
      auditService.addAuditLog (token, "GetEmployeeByEmployeeNumber", "EmployeeService", "0.0.1", "Getting employee with employee number '" +
          request.getEmployeeNumber () +
          "'", "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Employee employee = employeeService.getEmployeeByEmployeeNumber (request.getEmployeeNumber ());
    if (employee == null) {
      throw new EmployeeNotFoundException ();
    }
    EmployeeType employeeType = new EmployeeType ();
    employeeType.setPersonId (employee.getPersonId ());
    employeeType.setEmployeeNumber (employee.getEmployeeNumber ());
    GetEmployeeByEmployeeNumberResponse response = new GetEmployeeByEmployeeNumberResponse ();
    response.setEmployee (employeeType);
    return response;
  }

  @PayloadRoot (namespace = "http://official.ws.edusys.mftvanak.com/schemas", localPart = "GetEmployeesRequest")
  public @ResponsePayload
  GetEmployeesResponse handleGetEmployeesRequest (@RequestPayload GetEmployeesRequest request) throws TokenIsNotAuthenticatedException,
      UserIsNotAuthorizedException, UserIsNotActiveException, ClientInformationNeededException {
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
      auditService.addAuditLog (token, "GetEmployees", "EmployeeService", "0.0.1", "Getting all employees", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    List < Employee > employees = employeeService.getEmployees ();
    GetEmployeesResponse response = new GetEmployeesResponse ();
    for (Employee employee : employees) {
      EmployeeType employeeType = new EmployeeType ();
      employeeType.setPersonId (employee.getPersonId ());
      employeeType.setEmployeeNumber (employee.getEmployeeNumber ());
      response.getEmployees ().add (employeeType);
    }
    return response;
  }

  @PayloadRoot (namespace = "http://official.ws.edusys.mftvanak.com/schemas", localPart = "GetEmployeeSummariesRequest")
  public @ResponsePayload
  GetEmployeeSummariesResponse handleGetEmployeeSummariesRequest (@RequestPayload GetEmployeeSummariesRequest request)
      throws TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, UserIsNotActiveException, ClientInformationNeededException {
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
      auditService.addAuditLog (token, "GetEmployeeSummaries", "EmployeeService", "0.0.1", "Getting all employee summaries", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    List < Employee > employees = employeeService.getEmployees ();
    GetEmployeeSummariesResponse response = new GetEmployeeSummariesResponse ();
    for (Employee employee : employees) {
      EmployeeSummaryType employeeSummaryType = new EmployeeSummaryType ();
      employeeSummaryType.setPersonId (employee.getPersonId ());
      employeeSummaryType.setEmployeeNumber (employee.getEmployeeNumber ());
      employeeSummaryType.setPersianFullName (employee.getPerson ().getPersianName () + " " + employee.getPerson ().getPersianFamily ());
      employeeSummaryType.setEnglishFullName (employee.getPerson ().getEnglishName () + " " + employee.getPerson ().getEnglishFamily ());
      response.getEmployeeSummaries ().add (employeeSummaryType);
    }
    return response;
  }

  @PayloadRoot (namespace = "http://official.ws.edusys.mftvanak.com/schemas", localPart = "EmployeeExistsByEmployeeNumberRequest")
  public @ResponsePayload
  EmployeeExistsByEmployeeNumberResponse handleEmployeeExistsByEmployeeNumberRequest (@RequestPayload EmployeeExistsByEmployeeNumberRequest request)
      throws TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, UserIsNotActiveException, ClientInformationNeededException {
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
      auditService.addAuditLog (token, "EmployeeExistsByEmployeeNumber", "EmployeeService", "0.0.1",
          "Checking for employee with employee number '" + request.getEmployeeNumber () + "'", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    EmployeeExistsByEmployeeNumberResponse response = new EmployeeExistsByEmployeeNumberResponse ();
    response.setResult (employeeService.employeeExistsWithEmployeeNumber (request.getEmployeeNumber ()));
    DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (), request.getClientDateTimeDay (),
        request.getClientDateTimeHour (), request.getClientDateTimeMinute (), request.getClientDateTimeSecond (),
        request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
    auditService.addAuditLog (token, "EmployeeExistsByEmployeeNumber", "EmployeeService", "0.0.1",
        "Employee with employee number '" + request.getEmployeeNumber () + "' exists.", "", clientDateTime.getMillis (),
        request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    return response;
  }
}
