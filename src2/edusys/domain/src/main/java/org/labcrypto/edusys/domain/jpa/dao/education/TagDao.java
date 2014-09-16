package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.Tag;

public class TagDao extends EntityDao<Tag> {

  public TagDao () {
    super (Tag.class);
  }
}
