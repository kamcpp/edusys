package com.mftvanak.edusys.ws.messaging.services;

import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotActiveException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;


public interface SecurityService {

  Token authenticateAndAuthorizeToken (String token) throws UserIsNotAuthorizedException, TokenIsNotAuthenticatedException,
      UserIsNotActiveException;

}
