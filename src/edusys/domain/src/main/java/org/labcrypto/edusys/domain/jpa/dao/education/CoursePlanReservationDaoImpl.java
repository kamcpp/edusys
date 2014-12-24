package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.CoursePlanReservation;

public class CoursePlanReservationDaoImpl extends JpaEntityDao<CoursePlanReservation> implements CoursePlanReservationDao {

  public CoursePlanReservationDaoImpl() {
    super (CoursePlanReservation.class);
  }
}
