package com.mftvanak.edusys.ws.personnel.endpoints;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.domain.entity.personnel.Person;
import com.mftvanak.edusys.domain.entity.personnel.Person.GenderType;
import com.mftvanak.edusys.ws.exceptions.ClientInformationNeededException;
import com.mftvanak.edusys.ws.exceptions.PersonNotFoundException;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotActiveException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;
import com.mftvanak.edusys.ws.personnel.schemas.AddPersonRequest;
import com.mftvanak.edusys.ws.personnel.schemas.AddPersonResponse;
import com.mftvanak.edusys.ws.personnel.schemas.DeletePersonRequest;
import com.mftvanak.edusys.ws.personnel.schemas.DeletePersonResponse;
import com.mftvanak.edusys.ws.personnel.schemas.GetPersonByIdRequest;
import com.mftvanak.edusys.ws.personnel.schemas.GetPersonByIdResponse;
import com.mftvanak.edusys.ws.personnel.schemas.GetPersonsRequest;
import com.mftvanak.edusys.ws.personnel.schemas.GetPersonsResponse;
import com.mftvanak.edusys.ws.personnel.schemas.UpdatePersonRequest;
import com.mftvanak.edusys.ws.personnel.schemas.UpdatePersonResponse;
import com.mftvanak.edusys.ws.personnel.schemas.types.PersonType;
import com.mftvanak.edusys.ws.personnel.services.AuditService;
import com.mftvanak.edusys.ws.personnel.services.PersonService;
import com.mftvanak.edusys.ws.personnel.services.SecurityService;


@Endpoint
public class PersonServiceEndpoint {

  @Autowired
  private PersonService personService;

  @Autowired
  private SecurityService securityService;

  @Autowired
  private AuditService auditService;

  @PayloadRoot (namespace = "http://personnel.ws.edusys.mftvanak.com/schemas", localPart = "AddPersonRequest")
  public @ResponsePayload
  AddPersonResponse handleAddPersonRequest (@RequestPayload AddPersonRequest request) throws TokenIsNotAuthenticatedException,
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
      auditService.addAuditLog (token, "AddPerson", "PersonService", "0.0.1", "Adding person ...", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Person person = new Person ();
    person.setBirthDate (request.getPerson ().getDateOfBirth ());
    person.setPersianName (request.getPerson ().getPersianName ());
    person.setPersianFamily (request.getPerson ().getPersianFamily ());
    person.setEnglishName (request.getPerson ().getEnglishName ());
    person.setEnglishFamily (request.getPerson ().getEnglishFamily ());
    person.setFatherName (request.getPerson ().getFatherName ());
    GenderType genderType = GenderType.NotClear;
    if (request.getPerson ().getGender () == 1) {
      genderType = GenderType.Male;
    } else if (request.getPerson ().getGender () == 2) {
      genderType = GenderType.Female;
    } else if (request.getPerson ().getGender () == 3) {
      genderType = GenderType.Others;
    }
    person.setGender (genderType);
    person.setNationalCode (request.getPerson ().getNationalCode ());
    person.setShLocation (request.getPerson ().getShLocation ());
    person.setShSh (request.getPerson ().getShSh ());
    person.setPhone1 (request.getPerson ().getPhone1 ());
    person.setPhone2 (request.getPerson ().getPhone2 ());
    person.setPhone3 (request.getPerson ().getPhone3 ());
    person.setEmail1 (request.getPerson ().getEmail1 ());
    person.setEmail2 (request.getPerson ().getEmail2 ());
    person.setWebUrl1 (request.getPerson ().getWebUrl1 ());
    person.setWebUrl2 (request.getPerson ().getWebUrl2 ());
    person.setAddress1 (request.getPerson ().getAddress1 ());
    person.setAddress2 (request.getPerson ().getAddress2 ());
    person.setDescription (request.getPerson ().getDescription ());
    Long id = personService.addPerson (person);
    DateTime clientDateTime = new DateTime (request.getClientDateTimeYear (), request.getClientDateTimeMonth (), request.getClientDateTimeDay (),
        request.getClientDateTimeHour (), request.getClientDateTimeMinute (), request.getClientDateTimeSecond (),
        request.getClientDateTimeMilliSecond (), DateTimeZone.UTC);
    auditService.addAuditLog (token, "AddPerson", "PersonService", "0.0.1", "Person is added with id '" + id + "'", "",
        clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
        request.getApplicationName ());
    AddPersonResponse response = new AddPersonResponse ();
    response.setPersonId (id);
    return response;
  }

  @PayloadRoot (namespace = "http://personnel.ws.edusys.mftvanak.com/schemas", localPart = "UpdatePersonRequest")
  public @ResponsePayload
  UpdatePersonResponse handleUpdatePersonRequest (@RequestPayload UpdatePersonRequest request) throws TokenIsNotAuthenticatedException,
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
      auditService.addAuditLog (token, "UpdatePerson", "PersonService", "0.0.1", "Updating person with nodeId '" +
          request.getPerson ().getId () +
          "'", "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Person person = personService.getPersonById (request.getPerson ().getId ());
    if (person == null) {
      throw new PersonNotFoundException ();
    }
    person.setBirthDate (request.getPerson ().getDateOfBirth ());
    person.setPersianName (request.getPerson ().getPersianName ());
    person.setPersianFamily (request.getPerson ().getPersianFamily ());
    person.setEnglishName (request.getPerson ().getEnglishName ());
    person.setEnglishFamily (request.getPerson ().getEnglishFamily ());
    person.setFatherName (request.getPerson ().getFatherName ());
    GenderType genderType = GenderType.NotClear;
    if (request.getPerson ().getGender () == 1) {
      genderType = GenderType.Male;
    } else if (request.getPerson ().getGender () == 2) {
      genderType = GenderType.Female;
    } else if (request.getPerson ().getGender () == 3) {
      genderType = GenderType.Others;
    }
    person.setGender (genderType);
    person.setNationalCode (request.getPerson ().getNationalCode ());
    person.setShLocation (request.getPerson ().getShLocation ());
    person.setShSh (request.getPerson ().getShSh ());
    person.setPhone1 (request.getPerson ().getPhone1 ());
    person.setPhone2 (request.getPerson ().getPhone2 ());
    person.setPhone3 (request.getPerson ().getPhone3 ());
    person.setEmail1 (request.getPerson ().getEmail1 ());
    person.setEmail2 (request.getPerson ().getEmail2 ());
    person.setWebUrl1 (request.getPerson ().getWebUrl1 ());
    person.setWebUrl2 (request.getPerson ().getWebUrl2 ());
    person.setAddress1 (request.getPerson ().getAddress1 ());
    person.setAddress2 (request.getPerson ().getAddress2 ());
    person.setDescription (request.getPerson ().getDescription ());
    personService.updatePerson (person);
    UpdatePersonResponse response = new UpdatePersonResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://personnel.ws.edusys.mftvanak.com/schemas", localPart = "DeletePersonRequest")
  public @ResponsePayload
  DeletePersonResponse handleDeletePersonRequest (@RequestPayload DeletePersonRequest request) throws TokenIsNotAuthenticatedException,
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
      auditService.addAuditLog (token, "DeletePerson", "PersonService", "0.0.1", "Deleting person with nodeId '" + request.getPersonId () + "'",
          "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Person person = personService.getPersonById (request.getPersonId ());
    if (person == null) {
      throw new PersonNotFoundException ();
    }
    personService.deletePerson (request.getPersonId ());
    DeletePersonResponse response = new DeletePersonResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://personnel.ws.edusys.mftvanak.com/schemas", localPart = "GetPersonByIdRequest")
  public @ResponsePayload
  GetPersonByIdResponse handleGetPersonByIdRequest (@RequestPayload GetPersonByIdRequest request) throws TokenIsNotAuthenticatedException,
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
      auditService.addAuditLog (token, "GetPersonById", "PersonService", "0.0.1", "Getting person with nodeId '" + request.getPersonId () + "'",
          "", clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (),
          request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    Person person = personService.getPersonById (request.getPersonId ());
    if (person == null) {
      throw new PersonNotFoundException ();
    }
    PersonType personType = new PersonType ();
    personType.setId (person.getId ());
    personType.setDateOfBirth (person.getBirthDate ());
    personType.setPersianName (person.getPersianName ());
    personType.setPersianFamily (person.getPersianFamily ());
    personType.setEnglishName (person.getEnglishName ());
    personType.setEnglishFamily (person.getEnglishFamily ());
    personType.setFatherName (person.getFatherName ());
    personType.setGender (person.getGender ().getCode ());
    personType.setNationalCode (person.getNationalCode ());
    personType.setShLocation (person.getShLocation ());
    personType.setShSh (person.getShSh ());
    personType.setPhone1 (person.getPhone1 ());
    personType.setPhone2 (person.getPhone2 ());
    personType.setPhone3 (person.getPhone3 ());
    personType.setEmail1 (person.getEmail1 ());
    personType.setEmail2 (person.getEmail2 ());
    personType.setWebUrl1 (person.getWebUrl1 ());
    personType.setWebUrl2 (person.getWebUrl2 ());
    personType.setAddress1 (person.getAddress1 ());
    personType.setAddress2 (person.getAddress2 ());
    personType.setDescription (person.getDescription ());
    GetPersonByIdResponse response = new GetPersonByIdResponse ();
    response.setPerson (personType);
    return response;
  }

  @PayloadRoot (namespace = "http://personnel.ws.edusys.mftvanak.com/schemas", localPart = "GetPersonsRequest")
  public @ResponsePayload
  GetPersonsResponse handleGetPersonsResquest (@RequestPayload GetPersonsRequest request) throws TokenIsNotAuthenticatedException,
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
      auditService.addAuditLog (token, "GetPersons", "PersonService", "0.0.1", "Getting all persons", "", clientDateTime.getMillis (),
          request.getClientMacAddress (), request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    List < Person > persons = personService.getPersons ();
    GetPersonsResponse response = new GetPersonsResponse ();
    for (Person person : persons) {
      PersonType personType = new PersonType ();
      personType.setId (person.getId ());
      personType.setDateOfBirth (person.getBirthDate ());
      personType.setPersianName (person.getPersianName ());
      personType.setPersianFamily (person.getPersianFamily ());
      personType.setEnglishName (person.getEnglishName ());
      personType.setEnglishFamily (person.getEnglishFamily ());
      personType.setFatherName (person.getFatherName ());
      personType.setGender (person.getGender ().getCode ());
      personType.setNationalCode (person.getNationalCode ());
      personType.setShLocation (person.getShLocation ());
      personType.setShSh (person.getShSh ());
      personType.setPhone1 (person.getPhone1 ());
      personType.setPhone2 (person.getPhone2 ());
      personType.setPhone3 (person.getPhone3 ());
      personType.setEmail1 (person.getEmail1 ());
      personType.setEmail2 (person.getEmail2 ());
      personType.setWebUrl1 (person.getWebUrl1 ());
      personType.setWebUrl2 (person.getWebUrl2 ());
      personType.setAddress1 (person.getAddress1 ());
      personType.setAddress2 (person.getAddress2 ());
      personType.setDescription (person.getDescription ());
      response.getPersons ().add (personType);
    }
    return response;
  }
}
