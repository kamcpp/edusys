package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.education.Institute;

public class InstituteDaoImpl extends EntityDaoImpl<Institute> {

  public InstituteDaoImpl() {
    super (Institute.class);
  }
}
