package org.labcrypto.edusys.domain.jpa.dao.membership;

import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.membership.Role;

public class RoleDaoImpl extends JpaEntityDao<Role> implements RoleDao {

    public RoleDaoImpl() {
        super(Role.class);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return entityManager.createQuery(
                "from Role as r where r.name = :roleName", Role.class)
                .setParameter("roleName", roleName)
                .getSingleResult();
    }
}
