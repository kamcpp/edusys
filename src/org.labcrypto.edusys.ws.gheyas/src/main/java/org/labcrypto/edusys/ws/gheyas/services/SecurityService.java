package org.labcrypto.edusys.ws.gheyas.services;

import org.labcrypto.edusys.domain.pg.entity.membership.Token;
import org.labcrypto.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import org.labcrypto.edusys.ws.exceptions.UserIsNotActiveException;
import org.labcrypto.edusys.ws.exceptions.UserIsNotAuthorizedException;

public interface SecurityService {

	Token authenticateAndAuthorizeToken(String token)
			throws UserIsNotAuthorizedException,
			TokenIsNotAuthenticatedException, UserIsNotActiveException;

}
