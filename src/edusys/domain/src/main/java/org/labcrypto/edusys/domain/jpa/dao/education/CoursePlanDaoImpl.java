package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.CoursePlan;

public class CoursePlanDaoImpl extends JpaEntityDao<CoursePlan> implements CoursePlanDao {

  public CoursePlanDaoImpl() {
    super (CoursePlan.class);
  }
}
