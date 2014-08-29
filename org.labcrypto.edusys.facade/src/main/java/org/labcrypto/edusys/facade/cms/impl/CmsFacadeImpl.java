package org.labcrypto.edusys.facade.cms.impl;

import java.util.List;
import java.util.Set;

import org.labcrypto.edusys.facade.cms.CmsFacade;
import org.springframework.beans.factory.annotation.Autowired;

import org.labcrypto.edusys.domain.pg.dao.cms.CmsClassDao;
import org.labcrypto.edusys.domain.pg.dao.cms.CmsDepartmentDao;
import org.labcrypto.edusys.domain.pg.dao.cms.CmsGeneralReservationDao;
import org.labcrypto.edusys.domain.pg.dao.cms.CmsGroupDao;
import org.labcrypto.edusys.domain.pg.dao.cms.CmsReservationDao;
import org.labcrypto.edusys.domain.pg.dao.cms.CmsReservationPlanDao;
import org.labcrypto.edusys.domain.pg.entity.cms.CmsClass;
import org.labcrypto.edusys.domain.pg.entity.cms.CmsDepartment;
import org.labcrypto.edusys.domain.pg.entity.cms.CmsGeneralReservation;
import org.labcrypto.edusys.domain.pg.entity.cms.CmsGroup;
import org.labcrypto.edusys.domain.pg.entity.cms.CmsReservation;
import org.labcrypto.edusys.domain.pg.entity.cms.CmsReservationPlan;


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
