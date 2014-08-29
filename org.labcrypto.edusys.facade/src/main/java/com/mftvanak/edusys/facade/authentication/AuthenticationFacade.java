package com.mftvanak.edusys.facade.authentication;

import com.mftvanak.edusys.domain.entity.membership.Token;


public interface AuthenticationFacade {

  Token authenticate (String username, String hashedPassword);

  Token validateToken (String tokenValue);

  void deactivateToken (String tokenValue);

  boolean userExistsByUsername (String username);

  boolean userExistsByEmail (String email);

  boolean changePassword (String username, String currentHashedPassword, String newHashedPassword);
  
}
