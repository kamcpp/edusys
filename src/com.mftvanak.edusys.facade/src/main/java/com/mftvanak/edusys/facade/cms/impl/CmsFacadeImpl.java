package com.mftvanak.edusys.facade.cms.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.cms.CmsClassDao;
import com.mftvanak.edusys.domain.dao.cms.CmsDepartmentDao;
import com.mftvanak.edusys.domain.dao.cms.CmsGeneralReservationDao;
import com.mftvanak.edusys.domain.dao.cms.CmsGroupDao;
import com.mftvanak.edusys.domain.dao.cms.CmsReservationDao;
import com.mftvanak.edusys.domain.dao.cms.CmsReservationPlanDao;
import com.mftvanak.edusys.domain.entity.cms.CmsClass;
import com.mftvanak.edusys.domain.entity.cms.CmsDepartment;
import com.mftvanak.edusys.domain.entity.cms.CmsGeneralReservation;
import com.mftvanak.edusys.domain.entity.cms.CmsGroup;
import com.mftvanak.edusys.domain.entity.cms.CmsReservation;
import com.mftvanak.edusys.domain.entity.cms.CmsReservationPlan;
import com.mftvanak.edusys.facade.cms.CmsFacade;


public class CmsFacadeImpl implements CmsFacade {

  @Autowired
  private CmsDepartmentDao cmsDepartmentDao;

  @Autowired
  private CmsGroupDao cmsGroupDao;

  @Autowired
  private CmsClassDao cmsClassDao;

  @Autowired
  private CmsGeneralReservationDao cmsGeneralReservationDao;

  @Autowired
  private CmsReservationPlanDao cmsReservationPlanDao;

  @Autowired
  private CmsReservationDao cmsReservationDao;

  @Override
  public void update (CmsGeneralReservation cmsGeneralReservation) {
    cmsGeneralReservationDao.save (cmsGeneralReservation);
  }

  @Override
  public void saveGeneralReservations (List < CmsDepartment > departments) {
    for (CmsDepartment cmsDepartment : departments) {
      Set < CmsGroup > groups = cmsDepartment.getGroups ();
      cmsDepartment.setGroups (null);
      cmsDepartmentDao.saveOrUpdate (cmsDepartment);
      for (CmsGroup cmsGroup : groups) {
        Set < CmsClass > classes = cmsGroup.getClasses ();
        cmsGroup.setClasses (null);
        cmsGroupDao.saveOrUpdate (cmsGroup);
        for (CmsClass cmsClass : classes) {
          Set < CmsGeneralReservation > generalReservations = cmsClass.getGeneralReservations ();
          cmsClass.setGeneralReservations (null);
          cmsClassDao.saveOrUpdate (cmsClass);
          for (CmsGeneralReservation cmsGeneralReservation : generalReservations) {
            cmsGeneralReservationDao.saveOrUpdate (cmsGeneralReservation);
          }
        }
      }
    }
  }

  @Override
  public void saveReservations (List < CmsDepartment > departments) {
    for (CmsDepartment cmsDepartment : departments) {
      Set < CmsReservation > reservations = cmsDepartment.getReservations ();
      cmsDepartment.setReservations (null);
      cmsDepartmentDao.saveOrUpdate (cmsDepartment);
      for (CmsReservation cmsReservation : reservations) {
        cmsReservationDao.saveOrUpdate (cmsReservation);
      }
    }
  }

  @Override
  public List < CmsGeneralReservation > getCmsGeneralReservations (long departmentId, Long groupId, Long classId, Integer count) {
    return cmsGeneralReservationDao.getCmsGeneralReservations (departmentId, groupId, classId, count);
  }

  @Override
  public CmsGeneralReservation getCmsGeneralReservationById (Long id) {
    return cmsGeneralReservationDao.getById (id);
  }

  @Override
  public CmsReservationPlan getCmsReservationPlan (long id) {
    return cmsReservationPlanDao.getById (id);
  }

  @Override
  public List < CmsReservation > getCmsReservations (long departmentId, long reservationPlanId, Integer count) {
    return cmsReservationDao.getCmsReservations (departmentId, reservationPlanId, count);
  }
}
