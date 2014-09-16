package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.CoursePlanReservation;

public class CoursePlanReservationDao extends EntityDao<CoursePlanReservation> {

  public CoursePlanReservationDao () {
    super (CoursePlanReservation.class);
  }
}
