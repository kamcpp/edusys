package com.mftvanak.edusys.ws.membership.services;

import java.util.List;

import com.mftvanak.edusys.domain.entity.membership.User;


public interface UserService {

  Long addUser (User user);

  void updateUser (User user);

  void deleteUser (Long id);

  User getUserById (Long id);

  List < User > getUsers ();

  void grantRoleToUser (Long userId, Long roleId) throws Exception;

  void revokeRoleFromUser (Long userId, Long roleId) throws Exception;

  List < User > getUsersUsingRole (Long roleId);
  
}
