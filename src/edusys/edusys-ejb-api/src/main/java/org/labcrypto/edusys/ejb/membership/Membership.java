package org.labcrypto.edusys.ejb.membership;

import java.util.List;

public interface Membership {

    Token authenticate(Credential credential) throws
            InvalidCredentialException, BadCredentialException, ServerException, MembershipPolicyException;

    void validateToken(Token token) throws
            InvalidTokenException, ExpiredTokenException, ServerException;

    void disableToken(Token token) throws
            InvalidTokenException, ExpiredTokenException, ServerException;

    List<Role> getRoles(Token token) throws
            InvalidTokenException, ExpiredTokenException, ServerException;
}
