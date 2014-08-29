package org.labcrypto.edusys.domain.pg.dao.membership;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.membership.Role;


public class RoleDao extends EntityDao < Role > {

  public RoleDao () {
    super (Role.class);
  }

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
