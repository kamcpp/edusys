package org.labcrypto.edusys.ejb.membership;

public interface AuthenticationTokenRepository {

    void submitToken(AuthenticationToken authenticationToken, User user);

    void invalidateToken(AuthenticationToken authenticationToken);
}
