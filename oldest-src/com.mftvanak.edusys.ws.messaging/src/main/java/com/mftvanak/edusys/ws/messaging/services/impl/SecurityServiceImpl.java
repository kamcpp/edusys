package com.mftvanak.edusys.ws.messaging.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotActiveException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;
import com.mftvanak.edusys.ws.messaging.services.AuthenticationService;
import com.mftvanak.edusys.ws.messaging.services.AuthorizationService;
import com.mftvanak.edusys.ws.messaging.services.SecurityService;


public class SecurityServiceImpl implements SecurityService {

  @Autowired
  private AuthenticationService authenticationService;

  @Autowired
  private AuthorizationService authorizationService;

  @Override
  public Token authenticateAndAuthorizeToken (String token) throws UserIsNotAuthorizedException, TokenIsNotAuthenticatedException,
      UserIsNotActiveException {
    Token tokenObject = authenticationService.validateToken (token);
    return authorizationService.authorize (tokenObject);
  }
}
