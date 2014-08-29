package com.mftvanak.edusys.ws.phonebook.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.facade.authentication.AuthenticationFacade;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotActiveException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;
import com.mftvanak.edusys.ws.phonebook.services.AuthenticationService;


public class FacadeAuthenticationService implements AuthenticationService {

  @Autowired
  private AuthenticationFacade authenticationFacade;

  @Override
  public Token validateToken (String token) throws TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, UserIsNotActiveException {
    Token t = authenticationFacade.validateToken (token);
    if (t == null) {
      throw new TokenIsNotAuthenticatedException ();
    }
    if (!t.getUser ().isActive ()) {
      throw new UserIsNotActiveException ();
    }
    return t;
  }
}
