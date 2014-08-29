package com.mftvanak.edusys.facade.membership;

import java.util.List;

import com.mftvanak.edusys.domain.entity.membership.Role;


public interface RoleFacade {

  Long addRole (Role role);

  void updateRole (Role role);

  void deleteRole (Long id);

  Role getRoleById (Long id);

  Role getRoleByName (String roleName);

  List < Role > getRoles ();
  
}
