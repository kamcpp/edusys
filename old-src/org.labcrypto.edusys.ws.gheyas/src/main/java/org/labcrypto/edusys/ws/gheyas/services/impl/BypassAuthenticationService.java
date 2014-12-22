package org.labcrypto.edusys.ws.gheyas.services.impl;

import org.labcrypto.edusys.domain.pg.entity.membership.Token;
import org.labcrypto.edusys.ws.gheyas.services.AuthenticationService;

public class BypassAuthenticationService implements AuthenticationService {

	@Override
	public Token validateToken(String token) {
		return null;
	}
}
