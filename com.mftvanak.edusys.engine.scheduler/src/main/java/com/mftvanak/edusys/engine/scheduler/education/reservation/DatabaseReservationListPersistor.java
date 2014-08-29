package com.mftvanak.edusys.engine.scheduler.education.reservation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.cms.CmsDepartment;
import com.mftvanak.edusys.domain.entity.cms.CmsReservation;
import com.mftvanak.edusys.domain.entity.cms.CmsReservationPlan;
import com.mftvanak.edusys.engine.scheduler.education.Persistor;
import com.mftvanak.edusys.facade.cms.CmsFacade;


public class DatabaseReservationListPersistor implements Persistor {

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
        for (ReservationItem reservationItem : departmentItem.getReservations ()) {
          CmsReservationPlan reservationPlan = cmsFacade.getCmsReservationPlan (reservationItem.getPlanId ());
          CmsReservation reservation = new CmsReservation ();
          reservation.setCalculatedDate (0);
          reservation.setDepartment (department);
          reservation.setReservationPlan (reservationPlan);
          reservation.setDate (reservationItem.getDate ());
          reservation.setEmail (reservationItem.getEmail ());
          reservation.setTime (reservationItem.getTime ());
          reservation.setId (reservationItem.getId ());
          reservation.setName (reservationItem.getName ());
          reservation.setPhone (reservationItem.getPhone ());
          reservation.setText (reservationItem.getText ());
          reservation.setSeen (false);
          reservation.setCalled (false);
          reservation.setSmsSent (false);
          department.getReservations ().add (reservation);
        }
        departments.add (department);
      }
      cmsFacade.saveReservations (departments);
    } catch (Exception e) {
      e.printStackTrace ();
    }
  }
}
