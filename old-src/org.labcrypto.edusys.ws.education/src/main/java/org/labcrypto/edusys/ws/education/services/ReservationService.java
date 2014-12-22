package org.labcrypto.edusys.ws.education.services;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.cms.CmsGeneralReservation;
import org.labcrypto.edusys.domain.pg.entity.cms.CmsReservation;

public interface ReservationService {

	CmsGeneralReservation getCmsGeneralReservationById(Long id);

	void updateCmsGeneralReservation(CmsGeneralReservation cmsGeneralReservation);

	List<CmsGeneralReservation> getCmsGeneralReservations(long departmentId,
			Long groupId, Long classId, Integer count);

	List<CmsReservation> getCmsReservations(long departmentId,
			long reservationPlanId, Integer count);

}
