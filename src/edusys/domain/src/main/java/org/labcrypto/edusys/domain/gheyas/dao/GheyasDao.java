package org.labcrypto.edusys.domain.gheyas.dao;

import java.util.List;

import org.labcrypto.edusys.domain.gheyas.entity.*;

public interface GheyasDao {

	List<GheyasTerm> getTerms(int instituteId);

	List<GheyasClassGroup> getGroups(int instituteId);

	List<GheyasClass> getClasses(int instituteId, String groupCode,
			String termCode, String classNamePattern, boolean showAll,
			String className, long classCode);

	List<GheyasStudent> getStudents(int instituteId, String classCode);

	List<GheyasStudent> searchStudents(int instituteId, String name,
			String family);

	List<GheyasDebtor> getDebtors(int instituteId);

	void updateStudentDaneshgahField(int instituteId, String karamuzCode,
			String daneshgahFieldNewValue);

	List<GheyasClass> getCommonClasses(String groupCodes, String termCodes);

}
