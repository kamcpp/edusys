package org.labcrypto.edusys.domain.pg.dao.education;

import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.education.Tag;


public class TagDao extends EntityDao < Tag > {

  public TagDao () {
    super (Tag.class);
  }
}
