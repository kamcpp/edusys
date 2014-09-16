package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.Institute;

public class InstituteDao extends EntityDao<Institute> {

  public InstituteDao () {
    super (Institute.class);
  }
}
