package org.labcrypto.edusys.facade.gheyas.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.gheyas.GheyasDao;
import org.labcrypto.edusys.domain.pg.entity.gheyas.GheyasClass;
import org.labcrypto.edusys.domain.pg.entity.gheyas.GheyasClassGroup;
import org.labcrypto.edusys.domain.pg.entity.gheyas.GheyasDebtor;
import org.labcrypto.edusys.domain.pg.entity.gheyas.GheyasStudent;
import org.labcrypto.edusys.domain.pg.entity.gheyas.GheyasTerm;
import org.labcrypto.edusys.facade.gheyas.GheyasFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class GheyasFacadeImpl implements GheyasFacade {

	@Autowired
	private GheyasDao gheyasDao;

	@Override
	public List<GheyasTerm> getTerms(int instituteId) {
		return gheyasDao.getTerms(instituteId);
	}

	@Override
	public List<GheyasClassGroup> getGroups(int instituteId) {
		return gheyasDao.getGroups(instituteId);
	}

	@Override
	public List<GheyasClass> getClasses(int instituteId, String groupCodes,
			String termCodes, String classNamePattern, boolean showAll,
			String className, long classCode) {
		return gheyasDao.getClasses(instituteId, groupCodes, termCodes,
				classNamePattern, showAll, className, classCode);
	}

	@Override
	public List<GheyasStudent> getStudents(int instituteId, String classCode) {
		return gheyasDao.getStudents(instituteId, classCode);
	}

	@Override
	public List<GheyasStudent> searchStudents(int instituteId, String name,
			String family) {
		return gheyasDao.searchStudents(instituteId, name, family);
	}

	@Override
	public List<GheyasDebtor> getDebtors(int instituteId) {
		return gheyasDao.getDebtors(instituteId);
	}

	@Override
	public void updateStudentDaneshgahField(int instituteId,
			String karamuzCode, String daneshgahFieldNewValue) {
		gheyasDao.updateStudentDaneshgahField(instituteId, karamuzCode,
				daneshgahFieldNewValue);
	}

	@Override
	public List<GheyasClass> getCommonClasses(String groupCodes,
			String termCodes) {
		return gheyasDao.getCommonClasses(groupCodes, termCodes);
	}
}
