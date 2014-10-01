package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.education.CoursePlan;

public class CoursePlanDaoImpl extends EntityDaoImpl<CoursePlan> {

  public CoursePlanDaoImpl() {
    super (CoursePlan.class);
  }
}
