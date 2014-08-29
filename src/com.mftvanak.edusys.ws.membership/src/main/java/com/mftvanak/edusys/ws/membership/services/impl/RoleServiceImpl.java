package com.mftvanak.edusys.ws.membership.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.membership.Role;
import com.mftvanak.edusys.facade.membership.RoleFacade;
import com.mftvanak.edusys.ws.membership.services.RoleService;


public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleFacade roleFacade;

  @Override
  public Long addRole (Role role) {
    return roleFacade.addRole (role);
  }

  @Override
  public void updateRole (Role role) {
    roleFacade.updateRole (role);
  }

  @Override
  public void deleteRole (Long id) {
    roleFacade.deleteRole (id);
  }

  @Override
  public Role getRoleById (Long id) {
    return roleFacade.getRoleById (id);
  }

  @Override
  public Role getRoleByName (String roleName) {
    return roleFacade.getRoleByName (roleName);
  }

  @Override
  public List < Role > getRoles () {
    return roleFacade.getRoles ();
  }
}
