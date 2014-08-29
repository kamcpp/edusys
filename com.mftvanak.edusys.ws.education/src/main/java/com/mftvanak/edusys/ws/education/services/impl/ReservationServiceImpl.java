package com.mftvanak.edusys.ws.education.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.cms.CmsGeneralReservation;
import com.mftvanak.edusys.domain.entity.cms.CmsReservation;
import com.mftvanak.edusys.facade.cms.CmsFacade;
import com.mftvanak.edusys.ws.education.services.ReservationService;


public class ReservationServiceImpl implements ReservationService {

  @Autowired
  private CmsFacade cmsFacade;

  @Override
  public void updateCmsGeneralReservation (CmsGeneralReservation cmsGeneralReservation) {
    cmsFacade.update (cmsGeneralReservation);
  }

  @Override
  public List < CmsGeneralReservation > getCmsGeneralReservations (long departmentId, Long groupId, Long classId,
      Integer count) {
    return cmsFacade.getCmsGeneralReservations (departmentId, groupId, classId, count);
  }

  @Override
  public CmsGeneralReservation getCmsGeneralReservationById (Long id) {
    return cmsFacade.getCmsGeneralReservationById (id);
  }

  @Override
  public List < CmsReservation > getCmsReservations (long departmentId, long reservationPlanId, Integer count) {
    return cmsFacade.getCmsReservations (departmentId, reservationPlanId, count);
  }
}
