package org.labcrypto.edusys.ws.education.services;

import org.labcrypto.edusys.domain.pg.entity.membership.Token;
import org.labcrypto.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import org.labcrypto.edusys.ws.exceptions.UserIsNotActiveException;
import org.labcrypto.edusys.ws.exceptions.UserIsNotAuthorizedException;

public interface AuthenticationService {

	Token validateToken(String token) throws TokenIsNotAuthenticatedException,
			UserIsNotAuthorizedException, UserIsNotActiveException;

}
