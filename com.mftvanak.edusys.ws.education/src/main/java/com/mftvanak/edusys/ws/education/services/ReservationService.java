package com.mftvanak.edusys.ws.education.services;

import java.util.List;

import com.mftvanak.edusys.domain.entity.cms.CmsGeneralReservation;
import com.mftvanak.edusys.domain.entity.cms.CmsReservation;


public interface ReservationService {

  CmsGeneralReservation getCmsGeneralReservationById (Long id);

  void updateCmsGeneralReservation (CmsGeneralReservation cmsGeneralReservation);

  List < CmsGeneralReservation > getCmsGeneralReservations (long departmentId, Long groupId, Long classId, Integer count);

  List < CmsReservation > getCmsReservations (long departmentId, long reservationPlanId, Integer count);

}
