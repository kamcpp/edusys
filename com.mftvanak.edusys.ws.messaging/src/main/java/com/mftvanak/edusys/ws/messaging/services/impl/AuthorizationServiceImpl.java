package com.mftvanak.edusys.ws.messaging.services.impl;

import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;
import com.mftvanak.edusys.ws.messaging.services.AuthorizationService;


public class AuthorizationServiceImpl implements AuthorizationService {

  @Override
  public Token authorize (Token token) throws UserIsNotAuthorizedException {
    boolean isAuthorized = false;
    isAuthorized = true;
    if (!isAuthorized) {
      throw new UserIsNotAuthorizedException ();
    }
    return token;
  }
}
