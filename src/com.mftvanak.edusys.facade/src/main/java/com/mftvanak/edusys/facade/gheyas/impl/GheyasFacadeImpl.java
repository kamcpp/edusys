package com.mftvanak.edusys.facade.gheyas.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.gheyas.GheyasDao;
import com.mftvanak.edusys.domain.entity.gheyas.GheyasClass;
import com.mftvanak.edusys.domain.entity.gheyas.GheyasClassGroup;
import com.mftvanak.edusys.domain.entity.gheyas.GheyasDebtor;
import com.mftvanak.edusys.domain.entity.gheyas.GheyasStudent;
import com.mftvanak.edusys.domain.entity.gheyas.GheyasTerm;
import com.mftvanak.edusys.facade.gheyas.GheyasFacade;


public class GheyasFacadeImpl implements GheyasFacade {

  @Autowired
  private GheyasDao gheyasDao;

  @Override
  public List < GheyasTerm > getTerms (int instituteId) {
    return gheyasDao.getTerms (instituteId);
  }

  @Override
  public List < GheyasClassGroup > getGroups (int instituteId) {
    return gheyasDao.getGroups (instituteId);
  }

  @Override
  public List < GheyasClass > getClasses (int instituteId, String groupCodes, String termCodes, String classNamePattern, boolean showAll,
      String className, long classCode) {
    return gheyasDao.getClasses (instituteId, groupCodes, termCodes, classNamePattern, showAll, className, classCode);
  }

  @Override
  public List < GheyasStudent > getStudents (int instituteId, String classCode) {
    return gheyasDao.getStudents (instituteId, classCode);
  }

  @Override
  public List < GheyasStudent > searchStudents (int instituteId, String name, String family) {
    return gheyasDao.searchStudents (instituteId, name, family);
  }

  @Override
  public List < GheyasDebtor > getDebtors (int instituteId) {
    return gheyasDao.getDebtors (instituteId);
  }

  @Override
  public void updateStudentDaneshgahField (int instituteId, String karamuzCode, String daneshgahFieldNewValue) {
    gheyasDao.updateStudentDaneshgahField (instituteId, karamuzCode, daneshgahFieldNewValue);
  }

  @Override
  public List < GheyasClass > getCommonClasses (String groupCodes, String termCodes) {
    return gheyasDao.getCommonClasses (groupCodes, termCodes);
  }
}
