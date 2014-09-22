package org.labcrypto.edusys.facade.membership;

public interface TokenFactory {
    Token create(Credential credential, User user);
}
