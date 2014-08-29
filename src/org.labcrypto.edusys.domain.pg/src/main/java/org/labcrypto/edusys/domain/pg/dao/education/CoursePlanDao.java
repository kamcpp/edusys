package org.labcrypto.edusys.domain.pg.dao.education;

import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.education.CoursePlan;


public class CoursePlanDao extends EntityDao < CoursePlan > {

  public CoursePlanDao () {
    super (CoursePlan.class);
  }
}
