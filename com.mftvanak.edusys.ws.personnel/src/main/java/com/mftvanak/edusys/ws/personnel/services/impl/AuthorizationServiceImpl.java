package com.mftvanak.edusys.ws.personnel.services.impl;

import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;
import com.mftvanak.edusys.ws.personnel.services.AuthorizationService;


public class AuthorizationServiceImpl implements AuthorizationService {

  @Override
  public Token authorize (Token token) throws UserIsNotAuthorizedException {
    boolean isAuthorized = true;
    if (!isAuthorized) {
      throw new UserIsNotAuthorizedException ();
    }
    return token;
  }
}
