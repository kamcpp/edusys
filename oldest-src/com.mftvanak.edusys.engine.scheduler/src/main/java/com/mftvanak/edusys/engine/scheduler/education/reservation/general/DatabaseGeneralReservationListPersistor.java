package com.mftvanak.edusys.engine.scheduler.education.reservation.general;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.cms.CmsClass;
import com.mftvanak.edusys.domain.entity.cms.CmsDepartment;
import com.mftvanak.edusys.domain.entity.cms.CmsGeneralReservation;
import com.mftvanak.edusys.domain.entity.cms.CmsGroup;
import com.mftvanak.edusys.engine.scheduler.education.Persistor;
import com.mftvanak.edusys.engine.scheduler.education.reservation.DepartmentItem;
import com.mftvanak.edusys.facade.cms.CmsFacade;


public class DatabaseGeneralReservationListPersistor implements Persistor {

  @Autowired
  private CmsFacade cmsFacade;

  @Override
  public void persist (List < DepartmentItem > departmentItems) {
    try {
      List < CmsDepartment > departments = new ArrayList < CmsDepartment > ();
      for (DepartmentItem departmentItem : departmentItems) {
        CmsDepartment department = new CmsDepartment ();
        department.setId (departmentItem.getId ());
        department.setName (departmentItem.getName ());
        for (GroupItem groupItem : departmentItem.getGroups ()) {
          CmsGroup group = new CmsGroup ();
          group.setDepartment (department);
          group.setId (groupItem.getId ());
          group.setName (groupItem.getName ());
          for (ClassItem classItem : groupItem.getClasses ()) {
            CmsClass clazz = new CmsClass ();
            clazz.setGroup (group);
            clazz.setId (classItem.getId ());
            clazz.setName (classItem.getName ());
            for (GeneralReservationItem generalReservationItem : classItem.getGeneralReservationItems ()) {
              CmsGeneralReservation generalReservation = new CmsGeneralReservation ();
              generalReservation.setCalculatedDate (0);
              generalReservation.setClazz (clazz);
              generalReservation.setDate (generalReservationItem.getDate ());
              generalReservation.setEmail (generalReservationItem.getEmail ());
              generalReservation.setId (generalReservationItem.getId ());
              generalReservation.setName (generalReservationItem.getName ());
              generalReservation.setPhone (generalReservationItem.getPhone ());
              generalReservation.setText (generalReservationItem.getText ());
              generalReservation.setSeen (false);
              generalReservation.setCalled (false);
              generalReservation.setSmsSent (false);
              clazz.getGeneralReservations ().add (generalReservation);
              generalReservation.setClazz (clazz);
            }
            group.getClasses ().add (clazz);
            clazz.setGroup (group);
          }
          department.getGroups ().add (group);
          group.setDepartment (department);
        }
        departments.add (department);
      }
      cmsFacade.saveGeneralReservations (departments);
    } catch (Exception e) {
      e.printStackTrace ();
    }
  }
}
