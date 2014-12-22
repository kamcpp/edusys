package com.mftvanak.edusys.ws.membership.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.membership.User;
import com.mftvanak.edusys.facade.membership.UserFacade;
import com.mftvanak.edusys.ws.membership.services.UserService;


public class UserServiceImpl implements UserService {

  @Autowired
  private UserFacade userFacade;

  @Override
  public Long addUser (User user) {
    return userFacade.addUser (user);
  }

  @Override
  public void updateUser (User user) {
    userFacade.updateUser (user);
  }

  @Override
  public void deleteUser (Long id) {
    userFacade.deleteUser (id);
  }

  @Override
  public User getUserById (Long id) {
    return userFacade.getUserById (id);
  }

  @Override
  public List < User > getUsers () {
    return userFacade.getUsers ();
  }

  @Override
  public void grantRoleToUser (Long userId, Long roleId) throws Exception {
    userFacade.grantRole (userId, roleId);
  }

  @Override
  public void revokeRoleFromUser (Long userId, Long roleId) throws Exception {
    userFacade.revokeRole (userId, roleId);
  }

  @Override
  public List < User > getUsersUsingRole (Long roleId) {
    return userFacade.getUsersUsingRole (roleId);
  }
}
