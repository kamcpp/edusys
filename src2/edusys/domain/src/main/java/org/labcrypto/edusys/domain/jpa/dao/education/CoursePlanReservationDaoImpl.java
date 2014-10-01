package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.education.CoursePlanReservation;

public class CoursePlanReservationDaoImpl extends EntityDaoImpl<CoursePlanReservation> {

  public CoursePlanReservationDaoImpl() {
    super (CoursePlanReservation.class);
  }
}
