package org.labcrypto.edusys.facade.membership;

public interface TokenRepository {
    void submitToken(Token token, User user);
}
