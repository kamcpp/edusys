package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.CoursePlan;

public class CoursePlanDao extends EntityDao<CoursePlan> {

  public CoursePlanDao () {
    super (CoursePlan.class);
  }
}
