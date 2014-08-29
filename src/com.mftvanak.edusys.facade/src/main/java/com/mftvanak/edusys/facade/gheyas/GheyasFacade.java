package com.mftvanak.edusys.facade.gheyas;

import java.util.List;

import com.mftvanak.edusys.domain.entity.gheyas.GheyasClass;
import com.mftvanak.edusys.domain.entity.gheyas.GheyasClassGroup;
import com.mftvanak.edusys.domain.entity.gheyas.GheyasDebtor;
import com.mftvanak.edusys.domain.entity.gheyas.GheyasStudent;
import com.mftvanak.edusys.domain.entity.gheyas.GheyasTerm;


public interface GheyasFacade {

  List < GheyasTerm > getTerms (int instituteId);

  List < GheyasClassGroup > getGroups (int instituteId);

  List < GheyasClass > getClasses (int instituteId, String groupCodes, String termCodes, String classNamePattern, boolean showAll,
      String className, long classCode);

  List < GheyasStudent > getStudents (int instituteId, String classCode);

  List < GheyasStudent > searchStudents (int instituteId, String name, String family);

  List < GheyasDebtor > getDebtors (int instituteId);

  void updateStudentDaneshgahField (int instituteId, String karamuzCode, String daneshgahFieldNewValue);

  List < GheyasClass > getCommonClasses (String groupCodes, String termCodes);

}
