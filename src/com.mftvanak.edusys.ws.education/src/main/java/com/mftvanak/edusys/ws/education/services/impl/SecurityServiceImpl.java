package com.mftvanak.edusys.ws.education.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.ws.education.services.AuthenticationService;
import com.mftvanak.edusys.ws.education.services.AuthorizationService;
import com.mftvanak.edusys.ws.education.services.SecurityService;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotActiveException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;


public class SecurityServiceImpl implements SecurityService {

  @Autowired
  private AuthenticationService authenticationService;

  @Autowired
  private AuthorizationService authorizationService;

  @Override
  public Token authenticateAndAuthorizeToken (String token) throws UserIsNotAuthorizedException,
      TokenIsNotAuthenticatedException, UserIsNotActiveException {
    return authorizationService.authorize (authenticationService.validateToken (token));
  }
}
