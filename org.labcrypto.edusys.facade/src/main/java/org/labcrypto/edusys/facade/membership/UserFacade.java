package org.labcrypto.edusys.facade.membership;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.membership.Role;
import org.labcrypto.edusys.domain.pg.entity.membership.User;

public interface UserFacade {

	Long addUser(User user);

	void updateUser(User user);

	void deleteUser(Long id);

	void enableUser(Long id);

	void disableUser(Long id);

	void grantRole(Long userId, Long roleId) throws Exception;

	void revokeRole(Long userId, Long roleId) throws Exception;

	User getUserById(Long id);

	User getUserByUsername(String username);

	List<User> getUsers();

	List<Role> getRolesForUser(Long userId);

	List<User> getUsersUsingRole(Long roleId);

}
