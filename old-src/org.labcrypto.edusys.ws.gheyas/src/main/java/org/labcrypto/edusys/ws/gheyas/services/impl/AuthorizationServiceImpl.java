package org.labcrypto.edusys.ws.gheyas.services.impl;

import org.labcrypto.edusys.domain.pg.entity.membership.Role;
import org.labcrypto.edusys.domain.pg.entity.membership.Token;
import org.labcrypto.edusys.ws.exceptions.UserIsNotAuthorizedException;
import org.labcrypto.edusys.ws.gheyas.services.AuthorizationService;

public class AuthorizationServiceImpl implements AuthorizationService {

	@Override
	public Token authorize(Token token) throws UserIsNotAuthorizedException {
		boolean isAuthorized = false;
		for (Role role : token.getUser().getRoles()) {
			if (role.getName().equals("ROLE_EDU_REPORT")) {
				isAuthorized = true;
			}
		}
		if (!isAuthorized) {
			throw new UserIsNotAuthorizedException();
		}
		return token;
	}
}
