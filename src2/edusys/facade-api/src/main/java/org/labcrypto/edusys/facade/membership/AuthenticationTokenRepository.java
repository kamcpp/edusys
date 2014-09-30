package org.labcrypto.edusys.facade.membership;

public interface AuthenticationTokenRepository {

    void submitToken(AuthenticationToken authenticationToken, User user);

    void invalidateToken(AuthenticationToken authenticationToken);
}
