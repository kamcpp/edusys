package org.labcrypto.edusys.ws.education.services.impl;

import org.labcrypto.edusys.domain.pg.entity.membership.Token;
import org.labcrypto.edusys.ws.education.services.AuthenticationService;

public class BypassAuthenticationService implements AuthenticationService {

	@Override
	public Token validateToken(String token) {
		return null;
	}
}
