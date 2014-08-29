package org.labcrypto.edusys.domain.pg.dao.education;

import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.education.Group;


public class GroupDao extends EntityDao < Group > {

  public GroupDao () {
    super (Group.class);
  }
}
