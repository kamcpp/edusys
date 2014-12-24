package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.Group;

public class GroupDaoImpl extends JpaEntityDao<Group> implements GroupDao {

  public GroupDaoImpl() {
    super (Group.class);
  }
}
