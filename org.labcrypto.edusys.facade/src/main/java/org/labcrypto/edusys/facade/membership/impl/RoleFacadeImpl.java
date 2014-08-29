package org.labcrypto.edusys.facade.membership.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.membership.RoleDao;
import org.labcrypto.edusys.domain.pg.entity.membership.Role;
import org.labcrypto.edusys.facade.membership.RoleFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class RoleFacadeImpl implements RoleFacade {

	@Autowired
	private RoleDao roleDao;

	@Override
	public Long addRole(Role role) {
		roleDao.save(role);
		return role.getId();
	}

	@Override
	public void updateRole(Role role) {
		roleDao.save(role);
	}

	@Override
	public void deleteRole(Long id) {
		roleDao.delete(id);
	}

	@Override
	public Role getRoleById(Long id) {
		return roleDao.getById(id);
	}

	@Override
	public Role getRoleByName(String name) {
		return roleDao.getRoleByName(name);
	}

	@Override
	public List<Role> getRoles() {
		return roleDao.getAll();
	}
}
