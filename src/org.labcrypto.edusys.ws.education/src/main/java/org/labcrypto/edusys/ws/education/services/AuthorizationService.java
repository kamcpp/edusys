package org.labcrypto.edusys.ws.education.services;

import org.labcrypto.edusys.domain.pg.entity.membership.Token;
import org.labcrypto.edusys.ws.exceptions.UserIsNotAuthorizedException;

public interface AuthorizationService {

	Token authorize(Token token) throws UserIsNotAuthorizedException;

}
