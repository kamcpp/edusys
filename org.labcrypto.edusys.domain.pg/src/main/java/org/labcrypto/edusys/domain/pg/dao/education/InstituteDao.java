package org.labcrypto.edusys.domain.pg.dao.education;

import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.education.Institute;


public class InstituteDao extends EntityDao < Institute > {

  public InstituteDao () {
    super (Institute.class);
  }
}
