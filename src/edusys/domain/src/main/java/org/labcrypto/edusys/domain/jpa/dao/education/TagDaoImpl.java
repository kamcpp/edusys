package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.Tag;

public class TagDaoImpl extends JpaEntityDao<Tag> implements TagDao {

  public TagDaoImpl() {
    super (Tag.class);
  }
}
