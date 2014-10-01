package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.education.Group;

public class GroupDaoImpl extends EntityDaoImpl<Group> {

  public GroupDaoImpl() {
    super (Group.class);
  }
}
