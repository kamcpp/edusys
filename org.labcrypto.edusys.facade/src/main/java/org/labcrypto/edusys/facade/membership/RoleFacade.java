package org.labcrypto.edusys.facade.membership;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.membership.Role;

public interface RoleFacade {

	Long addRole(Role role);

	void updateRole(Role role);

	void deleteRole(Long id);

	Role getRoleById(Long id);

	Role getRoleByName(String roleName);

	List<Role> getRoles();

}
