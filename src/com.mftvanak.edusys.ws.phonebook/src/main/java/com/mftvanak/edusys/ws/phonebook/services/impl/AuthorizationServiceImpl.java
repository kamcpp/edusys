package com.mftvanak.edusys.ws.phonebook.services.impl;

import com.mftvanak.edusys.domain.entity.membership.Role;
import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;
import com.mftvanak.edusys.ws.phonebook.services.AuthorizationService;


public class AuthorizationServiceImpl implements AuthorizationService {

  @Override
  public Token authorize (Token token) throws UserIsNotAuthorizedException {
    boolean isAuthorized = false;
    for (Role role : token.getUser ().getRoles ()) {
      if (role.getName ().equals ("ROLE_PHONEBOOK")) {
        isAuthorized = true;
      }
    }
    if (!isAuthorized) {
      throw new UserIsNotAuthorizedException ();
    }
    return token;
  }
}
