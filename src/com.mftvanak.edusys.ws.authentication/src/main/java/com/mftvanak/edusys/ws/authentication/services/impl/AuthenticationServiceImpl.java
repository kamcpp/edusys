package com.mftvanak.edusys.ws.authentication.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.domain.entity.membership.User;
import com.mftvanak.edusys.facade.authentication.AuthenticationFacade;
import com.mftvanak.edusys.ws.authentication.services.AuthenticationService;


public class AuthenticationServiceImpl implements AuthenticationService {

  @Autowired
  private AuthenticationFacade authenticationFacade;

  @Override
  public Token authenticate (String username, String password, Date clientTime) {
    Token token = authenticationFacade.authenticate (username, password);
    return token;
  }

  @Override
  public User validateToken (String tokenValue) {
    Token token = authenticationFacade.validateToken (tokenValue);
    if (token != null) {
      return token.getUser ();
    } else {
      return null;
    }
  }

  @Override
  public void deactivateToken (String token) {
    authenticationFacade.deactivateToken (token);
  }

  @Override
  public boolean userExistsByUsername (String username) {
    return authenticationFacade.userExistsByUsername (username);
  }

  @Override
  public boolean userExistsByEmail (String email) {
    return authenticationFacade.userExistsByEmail (email);
  }

  @Override
  public boolean changePassword (String username, String currentHashedPassword, String newHashedPassword) {
    return authenticationFacade.changePassword (username, currentHashedPassword, newHashedPassword);
  }
}
