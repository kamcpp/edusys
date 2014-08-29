package org.labcrypto.edusys.facade.cms;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.cms.CmsDepartment;
import org.labcrypto.edusys.domain.pg.entity.cms.CmsGeneralReservation;
import org.labcrypto.edusys.domain.pg.entity.cms.CmsReservation;
import org.labcrypto.edusys.domain.pg.entity.cms.CmsReservationPlan;

public interface CmsFacade {

	void update(CmsGeneralReservation cmsGeneralReservation);

	void saveGeneralReservations(List<CmsDepartment> departments);

	void saveReservations(List<CmsDepartment> departments);

	CmsGeneralReservation getCmsGeneralReservationById(Long id);

	List<CmsGeneralReservation> getCmsGeneralReservations(long departmentId,
			Long groupId, Long classId, Integer count);

	CmsReservationPlan getCmsReservationPlan(long id);

	List<CmsReservation> getCmsReservations(long departmentId,
			long reservationPlanId, Integer count);

}
