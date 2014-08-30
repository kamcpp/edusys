package org.labcrypto.edusys.ws.gheyas.services.impl;

import org.labcrypto.edusys.domain.pg.entity.membership.Token;
import org.labcrypto.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import org.labcrypto.edusys.ws.exceptions.UserIsNotActiveException;
import org.labcrypto.edusys.ws.exceptions.UserIsNotAuthorizedException;
import org.labcrypto.edusys.ws.gheyas.services.AuthenticationService;
import org.labcrypto.edusys.ws.gheyas.services.AuthorizationService;
import org.labcrypto.edusys.ws.gheyas.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;

public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private AuthorizationService authorizationService;

	@Override
	public Token authenticateAndAuthorizeToken(String token)
			throws UserIsNotAuthorizedException,
			TokenIsNotAuthenticatedException, UserIsNotActiveException {
		Token tokenObject = authenticationService.validateToken(token);
		return authorizationService.authorize(tokenObject);
	}
}
