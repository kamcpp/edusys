package com.mftvanak.edusys.facade.cms;

import java.util.List;

import com.mftvanak.edusys.domain.entity.cms.CmsDepartment;
import com.mftvanak.edusys.domain.entity.cms.CmsGeneralReservation;
import com.mftvanak.edusys.domain.entity.cms.CmsReservation;
import com.mftvanak.edusys.domain.entity.cms.CmsReservationPlan;


public interface CmsFacade {

  void update (CmsGeneralReservation cmsGeneralReservation);

  void saveGeneralReservations (List < CmsDepartment > departments);

  void saveReservations (List < CmsDepartment > departments);

  CmsGeneralReservation getCmsGeneralReservationById (Long id);

  List < CmsGeneralReservation > getCmsGeneralReservations (long departmentId, Long groupId, Long classId, Integer count);

  CmsReservationPlan getCmsReservationPlan (long id);

  List < CmsReservation > getCmsReservations (long departmentId, long reservationPlanId, Integer count);

}
