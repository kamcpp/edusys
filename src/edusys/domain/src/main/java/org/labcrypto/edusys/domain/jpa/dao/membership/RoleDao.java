package org.labcrypto.edusys.domain.jpa.dao.membership;

import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.membership.Role;

public interface RoleDao extends EntityDao<Role> {
    Role getRoleByName (String roleName);
}
