package com.mftvanak.edusys.ws.personnel.services;

import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotActiveException;
import com.mftvanak.edusys.ws.exceptions.UserIsNotAuthorizedException;


public interface AuthenticationService {

  Token validateToken (String token) throws TokenIsNotAuthenticatedException, UserIsNotAuthorizedException, UserIsNotActiveException;

}
