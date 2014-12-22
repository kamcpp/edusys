package org.labcrypto.edusys.ws.gheyas.services.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.gheyas.GheyasClass;
import org.labcrypto.edusys.domain.pg.entity.gheyas.GheyasClassGroup;
import org.labcrypto.edusys.domain.pg.entity.gheyas.GheyasDebtor;
import org.labcrypto.edusys.domain.pg.entity.gheyas.GheyasStudent;
import org.labcrypto.edusys.domain.pg.entity.gheyas.GheyasTerm;
import org.labcrypto.edusys.facade.gheyas.GheyasFacade;
import org.labcrypto.edusys.ws.gheyas.services.GheyasService;
import org.springframework.beans.factory.annotation.Autowired;

public class GheyasServiceImpl implements GheyasService {

	@Autowired
	private GheyasFacade gheyasFacade;

	@Override
	public List<GheyasTerm> getTerms(int instituteId) {
		return gheyasFacade.getTerms(instituteId);
	}

	@Override
	public List<GheyasClassGroup> getGroups(int instituteId) {
		return gheyasFacade.getGroups(instituteId);
	}

	@Override
	public List<GheyasClass> getClasses(int instituteId, String groupCodes,
			String termCodes, String classNamePattern, boolean showAll,
			String className, long classCode) {
		return gheyasFacade.getClasses(instituteId, groupCodes, termCodes,
				classNamePattern, showAll, className, classCode);
	}

	@Override
	public List<GheyasStudent> getStudents(int instituteId, String classCode) {
		return gheyasFacade.getStudents(instituteId, classCode);
	}

	@Override
	public List<GheyasStudent> searchStudents(int instituteId, String name,
			String family) {
		return gheyasFacade.searchStudents(instituteId, name, family);
	}

	@Override
	public List<GheyasDebtor> getDebtors(int instituteId) {
		return gheyasFacade.getDebtors(instituteId);
	}

	@Override
	public void updateStudentDaneshgahField(int instituteId,
			String karamuzCode, String daneshgahFieldNewValue) {
		gheyasFacade.updateStudentDaneshgahField(instituteId, karamuzCode,
				daneshgahFieldNewValue);
	}

	@Override
	public List<GheyasClass> getCommonClasses(String groupCodes,
			String termCodes) {
		return gheyasFacade.getCommonClasses(groupCodes, termCodes);
	}
}
