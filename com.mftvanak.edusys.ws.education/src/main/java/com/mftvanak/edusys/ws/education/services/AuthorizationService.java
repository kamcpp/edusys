package com.mftvanak.edusys.ws.education.services;

import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;


public interface AuthorizationService {

  Token authorize (Token token) throws UserIsNotAuthorizedException;

}
