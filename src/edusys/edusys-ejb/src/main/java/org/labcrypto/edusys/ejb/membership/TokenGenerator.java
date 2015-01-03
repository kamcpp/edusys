package org.labcrypto.edusys.ejb.membership;

public interface TokenGenerator {
    Token generate(Credential credential, Principal user);
}
