package org.labcrypto.edusys.ws.education.services.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.cms.CmsGeneralReservation;
import org.labcrypto.edusys.domain.pg.entity.cms.CmsReservation;
import org.labcrypto.edusys.facade.cms.CmsFacade;
import org.labcrypto.edusys.ws.education.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private CmsFacade cmsFacade;

	@Override
	public void updateCmsGeneralReservation(
			CmsGeneralReservation cmsGeneralReservation) {
		cmsFacade.update(cmsGeneralReservation);
	}

	@Override
	public List<CmsGeneralReservation> getCmsGeneralReservations(
			long departmentId, Long groupId, Long classId, Integer count) {
		return cmsFacade.getCmsGeneralReservations(departmentId, groupId,
				classId, count);
	}

	@Override
	public CmsGeneralReservation getCmsGeneralReservationById(Long id) {
		return cmsFacade.getCmsGeneralReservationById(id);
	}

	@Override
	public List<CmsReservation> getCmsReservations(long departmentId,
			long reservationPlanId, Integer count) {
		return cmsFacade.getCmsReservations(departmentId, reservationPlanId,
				count);
	}
}
