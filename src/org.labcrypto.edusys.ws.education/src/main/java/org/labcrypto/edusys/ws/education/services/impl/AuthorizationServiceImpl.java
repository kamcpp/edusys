package org.labcrypto.edusys.ws.education.services.impl;

import org.labcrypto.edusys.domain.pg.entity.membership.Role;
import org.labcrypto.edusys.domain.pg.entity.membership.Token;
import org.labcrypto.edusys.ws.education.services.AuthorizationService;
import org.labcrypto.edusys.ws.exceptions.UserIsNotAuthorizedException;

public class AuthorizationServiceImpl implements AuthorizationService {

	@Override
	public Token authorize(Token token) throws UserIsNotAuthorizedException {
		boolean isAdmin = false;
		for (Role role : token.getUser().getRoles()) {
			if (role.getName().equals("ROLE_ADMIN")
					|| role.getName().equals("ROLE_PHONEBOOK")
					|| role.getName().equals("ROLE_EMPLOYEE")) {
				isAdmin = true;
			}
		}
		if (!isAdmin) {
			throw new UserIsNotAuthorizedException();
		}
		return token;
	}
}
