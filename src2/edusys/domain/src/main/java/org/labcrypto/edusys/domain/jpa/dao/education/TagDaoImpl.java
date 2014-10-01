package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.education.Tag;

public class TagDaoImpl extends EntityDaoImpl<Tag> {

  public TagDaoImpl() {
    super (Tag.class);
  }
}
