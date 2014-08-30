package org.labcrypto.edusys.ws.education.services.impl;

import org.labcrypto.edusys.domain.pg.entity.membership.Token;
import org.labcrypto.edusys.ws.education.services.AuthenticationService;
import org.labcrypto.edusys.ws.education.services.AuthorizationService;
import org.labcrypto.edusys.ws.education.services.SecurityService;
import org.labcrypto.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import org.labcrypto.edusys.ws.exceptions.UserIsNotActiveException;
import org.labcrypto.edusys.ws.exceptions.UserIsNotAuthorizedException;
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
		return authorizationService.authorize(authenticationService
				.validateToken(token));
	}
}
