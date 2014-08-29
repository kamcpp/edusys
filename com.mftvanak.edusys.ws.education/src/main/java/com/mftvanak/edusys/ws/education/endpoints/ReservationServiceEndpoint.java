package com.mftvanak.edusys.ws.education.endpoints;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mftvanak.edusys.domain.entity.cms.CmsGeneralReservation;
import com.mftvanak.edusys.domain.entity.cms.CmsReservation;
import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.ws.education.schemas.reservation.GetCmsGeneralReservationsRequest;
import com.mftvanak.edusys.ws.education.schemas.reservation.GetCmsGeneralReservationsResponse;
import com.mftvanak.edusys.ws.education.schemas.reservation.GetCmsReservationsRequest;
import com.mftvanak.edusys.ws.education.schemas.reservation.GetCmsReservationsResponse;
import com.mftvanak.edusys.ws.education.schemas.reservation.UpdateCmsGeneralReservationRequest;
import com.mftvanak.edusys.ws.education.schemas.reservation.UpdateCmsGeneralReservationResponse;
import com.mftvanak.edusys.ws.education.schemas.types.CmsGeneralReservationType;
import com.mftvanak.edusys.ws.education.schemas.types.CmsReservationType;
import com.mftvanak.edusys.ws.education.services.AuditService;
import com.mftvanak.edusys.ws.education.services.ReservationService;
import com.mftvanak.edusys.ws.education.services.SecurityService;
import com.mftvanak.edusys.ws.exceptions.ClientInformationNeededException;
import com.mftvanak.edusys.ws.exceptions.CmsGeneralReservationNotFoundException;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotActiveException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;


@Endpoint
public class ReservationServiceEndpoint {

  @Autowired
  private ReservationService reservationService;

  @Autowired
  private SecurityService securityService;

  @Autowired
  private AuditService auditService;

  @PayloadRoot (namespace = "http://education.ws.edusys.mftvanak.com/schemas/reservation", localPart = "UpdateCmsGeneralReservationRequest")
  public @ResponsePayload
  UpdateCmsGeneralReservationResponse handleUpdateCmsGeneralReservation (
      @RequestPayload UpdateCmsGeneralReservationRequest request) throws UserIsNotAuthorizedException,
      TokenIsNotAuthenticatedException, UserIsNotActiveException, ClientInformationNeededException,
      CmsGeneralReservationNotFoundException {
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
      auditService.addAuditLog (token, "UpdateCmsGeneralReservation", "ReservationService", "0.0.1",
          "Updating cms general reservations with id: '" + request.getCmsGeneralReservation ().getId () + "'", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (),
          request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    CmsGeneralReservation cmsGeneralReservation = reservationService.getCmsGeneralReservationById (request
        .getCmsGeneralReservation ().getId ());
    if (cmsGeneralReservation == null) {
      throw new CmsGeneralReservationNotFoundException ();
    }
    cmsGeneralReservation.setCalculatedDate (request.getCmsGeneralReservation ().getCalculatedDate ());
    cmsGeneralReservation.setCalled (request.getCmsGeneralReservation ().isCalled ());
    cmsGeneralReservation.setCancelled (request.getCmsGeneralReservation ().isCancelled ());
    cmsGeneralReservation.setDate (request.getCmsGeneralReservation ().getDate ());
    cmsGeneralReservation.setDescription (request.getCmsGeneralReservation ().getDescription ());
    cmsGeneralReservation.setEmail (request.getCmsGeneralReservation ().getEmail ());
    cmsGeneralReservation.setFollowed (request.getCmsGeneralReservation ().isFollowed ());
    cmsGeneralReservation.setHasRegisered (request.getCmsGeneralReservation ().isHasRegistered ());
    cmsGeneralReservation.setName (request.getCmsGeneralReservation ().getName ());
    cmsGeneralReservation.setNotAnswered (request.getCmsGeneralReservation ().isNotAnswered ());
    cmsGeneralReservation.setPhone (request.getCmsGeneralReservation ().getPhone ());
    cmsGeneralReservation.setSeen (request.getCmsGeneralReservation ().isSeen ());
    cmsGeneralReservation.setSmsSent (request.getCmsGeneralReservation ().isSmsSent ());
    cmsGeneralReservation.setSource (request.getCmsGeneralReservation ().getSource ());
    cmsGeneralReservation.setText (request.getCmsGeneralReservation ().getText ());
    cmsGeneralReservation.setWillInformUs (request.getCmsGeneralReservation ().isWillInformUs ());
    cmsGeneralReservation.setWillRegister (request.getCmsGeneralReservation ().isWillRegister ());
    reservationService.updateCmsGeneralReservation (cmsGeneralReservation);
    cmsGeneralReservation.setWillRegisterWithConditions (request.getCmsGeneralReservation ()
        .isWillRegisterWithCondition ());
    UpdateCmsGeneralReservationResponse response = new UpdateCmsGeneralReservationResponse ();
    return response;
  }

  @PayloadRoot (namespace = "http://education.ws.edusys.mftvanak.com/schemas/reservation", localPart = "GetCmsGeneralReservationsRequest")
  public @ResponsePayload
  GetCmsGeneralReservationsResponse handleGetCmsGeneralReservations (
      @RequestPayload GetCmsGeneralReservationsRequest request) throws UserIsNotAuthorizedException,
      TokenIsNotAuthenticatedException, UserIsNotActiveException, ClientInformationNeededException {
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
          "GetCmsGeneralReservations",
          "ReservationService",
          "0.0.1",
          "Getting cms general reservations for departmentId: '" + request.getDepartmentId () + "', groupId: '"
              + (request.getGroupId () == null ? "null" : request.getGroupId ()) + "', classId: '"
              + (request.getClassId () == null ? "null" : request.getClassId ()) + "'", "",
          clientDateTime.getMillis (), request.getClientMacAddress (), request.getClientIpAddress (),
          request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    List < CmsGeneralReservation > cmsGeneralReservations = reservationService.getCmsGeneralReservations (
        request.getDepartmentId (), request.getGroupId (), request.getClassId (), request.getCount ());
    GetCmsGeneralReservationsResponse response = new GetCmsGeneralReservationsResponse ();
    for (CmsGeneralReservation cmsGeneralReservation : cmsGeneralReservations) {
      CmsGeneralReservationType cmsGeneralReservationType = new CmsGeneralReservationType ();
      cmsGeneralReservationType.setCalled (cmsGeneralReservation.isCalled ());
      cmsGeneralReservationType.setCancelled (cmsGeneralReservation.isCancelled ());
      cmsGeneralReservationType.setFollowed (cmsGeneralReservation.isFollowed ());
      cmsGeneralReservationType.setHasRegistered (cmsGeneralReservation.isHasRegisered ());
      cmsGeneralReservationType.setNotAnswered (cmsGeneralReservation.isNotAnswered ());
      cmsGeneralReservationType.setSeen (cmsGeneralReservation.isSeen ());
      cmsGeneralReservationType.setSmsSent (cmsGeneralReservation.isSmsSent ());
      cmsGeneralReservationType.setWillInformUs (cmsGeneralReservation.isWillInformUs ());
      cmsGeneralReservationType.setWillRegister (cmsGeneralReservation.isWillRegister ());
      cmsGeneralReservationType.setWillRegisterWithCondition (cmsGeneralReservation.isWillRegisterWithConditions ());
      cmsGeneralReservationType.setCalculatedDate (cmsGeneralReservation.getCalculatedDate ());
      cmsGeneralReservationType.setCmsClassId (cmsGeneralReservation.getClazz ().getId ());
      cmsGeneralReservationType.setCmsClassName (cmsGeneralReservation.getClazz ().getName ());
      cmsGeneralReservationType.setCmsDepartmentId (cmsGeneralReservation.getClazz ().getGroup ().getDepartment ()
          .getId ());
      cmsGeneralReservationType.setCmsDepartmentName (cmsGeneralReservation.getClazz ().getGroup ().getDepartment ()
          .getName ());
      cmsGeneralReservationType.setCmsGroupId (cmsGeneralReservation.getClazz ().getGroup ().getId ());
      cmsGeneralReservationType.setCmsGroupName (cmsGeneralReservation.getClazz ().getGroup ().getName ());
      cmsGeneralReservationType.setDate (cmsGeneralReservation.getDate ());
      cmsGeneralReservationType.setEmail (cmsGeneralReservation.getEmail ());
      cmsGeneralReservationType.setPhone (cmsGeneralReservation.getPhone ());
      cmsGeneralReservationType.setId (cmsGeneralReservation.getId ());
      cmsGeneralReservationType.setText (cmsGeneralReservation.getText ());
      cmsGeneralReservationType.setName (cmsGeneralReservation.getName ());
      cmsGeneralReservationType.setDescription (cmsGeneralReservation.getDescription ());
      cmsGeneralReservationType.setSource (cmsGeneralReservation.getSource ());
      response.getCmsGeneralReservations ().add (cmsGeneralReservationType);
    }
    return response;
  }

  @PayloadRoot (namespace = "http://education.ws.edusys.mftvanak.com/schemas/reservation", localPart = "GetCmsReservationsRequest")
  public @ResponsePayload
  GetCmsReservationsResponse handleGetCmsReservations (@RequestPayload GetCmsReservationsRequest request)
      throws UserIsNotAuthorizedException, TokenIsNotAuthenticatedException, UserIsNotActiveException,
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
      auditService.addAuditLog (token, "GetCmsReservations", "ReservationService", "0.0.1",
          "Getting cms reservations for departmentId: '" + request.getDepartmentId () + "', reservationPlanId: '"
              + request.getReservationPlanId () + "'", "", clientDateTime.getMillis (), request.getClientMacAddress (),
          request.getClientIpAddress (), request.getClientComputerName (), request.getApplicationName ());
    } else {
      throw new ClientInformationNeededException ();
    }
    List < CmsReservation > cmsReservations = reservationService.getCmsReservations (request.getDepartmentId (),
        request.getReservationPlanId (), request.getCount ());
    GetCmsReservationsResponse response = new GetCmsReservationsResponse ();
    for (CmsReservation cmsReservation : cmsReservations) {
      CmsReservationType cmsReservationType = new CmsReservationType ();
      cmsReservationType.setCalled (cmsReservation.isCalled ());
      cmsReservationType.setCancelled (cmsReservation.isCancelled ());
      cmsReservationType.setFollowed (cmsReservation.isFollowed ());
      cmsReservationType.setHasRegistered (cmsReservation.isHasRegisered ());
      cmsReservationType.setNotAnswered (cmsReservation.isNotAnswered ());
      cmsReservationType.setSeen (cmsReservation.isSeen ());
      cmsReservationType.setSmsSent (cmsReservation.isSmsSent ());
      cmsReservationType.setWillInformUs (cmsReservation.isWillInformUs ());
      cmsReservationType.setWillRegister (cmsReservation.isWillRegister ());
      cmsReservationType.setWillRegisterWithCondition (cmsReservation.isWillRegisterWithConditions ());
      cmsReservationType.setCalculatedDate (cmsReservation.getCalculatedDate ());
      cmsReservationType.setCmsDepartmentId (cmsReservation.getDepartment ().getId ());
      cmsReservationType.setCmsDepartmentName (cmsReservation.getDepartment ().getName ());
      cmsReservationType.setDate (cmsReservation.getDate ());
      cmsReservationType.setEmail (cmsReservation.getEmail ());
      cmsReservationType.setPhone (cmsReservation.getPhone ());
      cmsReservationType.setId (cmsReservation.getId ());
      cmsReservationType.setText (cmsReservation.getText ());
      cmsReservationType.setName (cmsReservation.getName ());
      cmsReservationType.setTime (cmsReservation.getTime ());
      // cmsReservationType.setDescription (cmsReservation.getDescription ());
      // cmsReservationType.setSource (cmsReservation.getSource ());
      response.getCmsReservations ().add (cmsReservationType);
    }
    return response;
  }
}
