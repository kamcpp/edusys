package org.labcrypto.edusys.ws.education.services.impl;

import org.labcrypto.edusys.domain.pg.entity.membership.Token;
import org.labcrypto.edusys.facade.authentication.AuthenticationFacade;
import org.labcrypto.edusys.ws.education.services.AuthenticationService;
import org.labcrypto.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import org.labcrypto.edusys.ws.exceptions.UserIsNotActiveException;
import org.labcrypto.edusys.ws.exceptions.UserIsNotAuthorizedException;
import org.springframework.beans.factory.annotation.Autowired;

public class FacadeAuthenticationService implements AuthenticationService {

	@Autowired
	private AuthenticationFacade authenticationFacade;

	@Override
	public Token validateToken(String token)
			throws TokenIsNotAuthenticatedException,
			UserIsNotAuthorizedException, UserIsNotActiveException {
		Token t = authenticationFacade.validateToken(token);
		if (t == null) {
			throw new TokenIsNotAuthenticatedException();
		}
		if (!t.getUser().isActive()) {
			throw new UserIsNotActiveException();
		}
		return t;
	}
}
