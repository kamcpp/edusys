package org.labcrypto.edusys.ejb.membership;

public interface PrincipleRepository {

    Principal findByCredential(Credential credential) throws
            InvalidCredentialException, PrincipleNotFoundException;

    boolean hasActiveToken(Principal principal) throws
            InvalidCredentialException, PrincipleNotFoundException;


    Token getActiveToken(Principal principal) throws
            InvalidCredentialException, PrincipleNotFoundException;

    void registerToken(Principal principal, Token token) throws
            InvalidCredentialException, PrincipleNotFoundException;

    Principal findByToken(Token token) throws
            InvalidTokenException, PrincipleNotFoundException;
}
