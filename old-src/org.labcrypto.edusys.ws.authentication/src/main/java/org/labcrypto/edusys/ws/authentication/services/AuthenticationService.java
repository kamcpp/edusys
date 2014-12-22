package org.labcrypto.edusys.ws.authentication.services;

import java.util.Date;

import org.labcrypto.edusys.domain.pg.entity.membership.Token;
import org.labcrypto.edusys.domain.pg.entity.membership.User;

public interface AuthenticationService {

	Token authenticate(String username, String password, Date clientTime);

	User validateToken(String token);

	void deactivateToken(String token);

	boolean userExistsByUsername(String username);

	boolean userExistsByEmail(String email);

	boolean changePassword(String username, String currentHashedPassword,
			String newHashedPassword);

}
