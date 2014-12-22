package org.labcrypto.edusys.domain.jpa.dao.membership.impl;

import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.dao.membership.RoleDao;
import org.labcrypto.edusys.domain.jpa.entity.membership.Role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RoleDaoImpl extends EntityDaoImpl< Role > implements RoleDao {

  public RoleDaoImpl() {
    super (Role.class);
  }

    @Override
  public Role getRoleByName (String roleName) {
    String query = "from Role as r where r.name = :roleName";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("roleName", roleName);
    List < Role > roles = executeQueryAsList (query, params, 0);
    if (roles.size () != 1) {
      return null;
    } else {
      return roles.get (0);
    }
  }
}
