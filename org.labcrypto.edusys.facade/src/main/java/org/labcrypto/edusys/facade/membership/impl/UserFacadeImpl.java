package org.labcrypto.edusys.facade.membership.impl;

import java.util.ArrayList;
import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.membership.RoleDao;
import org.labcrypto.edusys.domain.pg.dao.membership.UserDao;
import org.labcrypto.edusys.domain.pg.entity.membership.Role;
import org.labcrypto.edusys.domain.pg.entity.membership.User;
import org.labcrypto.edusys.facade.membership.UserFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class UserFacadeImpl implements UserFacade {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Override
	public Long addUser(User user) {
		userDao.save(user);
		return user.getPersonId();
	}

	@Override
	public void updateUser(User user) {
		userDao.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		userDao.delete(id);
	}

	@Override
	public void enableUser(Long id) {
		User user = userDao.getById(id);
		user.setActive(true);
		userDao.save(user);
	}

	@Override
	public void disableUser(Long id) {
		User user = userDao.getById(id);
		user.setActive(false);
		userDao.save(user);
	}

	@Override
	public void grantRole(Long userId, Long roleId) {
		User user = userDao.getById(userId);
		Role role = roleDao.getById(roleId);
		user.getRoles().add(role);
		userDao.save(user);
	}

	@Override
	public void revokeRole(Long userId, Long roleId) {
		User user = userDao.getById(userId);
		Role role = roleDao.getById(roleId);
		user.getRoles().remove(role);
		userDao.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return userDao.getById(id);
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		return userDao.getAll();
	}

	@Override
	public List<Role> getRolesForUser(Long id) {
		User user = userDao.getById(id);
		List<Role> toReturn = new ArrayList<Role>();
		for (Role role : user.getRoles()) {
			toReturn.add(role);
		}
		return toReturn;
	}

	@Override
	public List<User> getUsersUsingRole(Long roleId) {
		return userDao.getUsersUsingRole(roleId);
	}
}
