package org.labcrypto.edusys.ejb.membership.impl;

import org.labcrypto.edusys.domain.jpa.dao.membership.UserDao;
import org.labcrypto.edusys.domain.jpa.entity.membership.User;
import org.labcrypto.edusys.ejb.membership.*;

import javax.inject.Inject;

public class DefaultPrincipleRepository implements PrincipleRepository {

    @Inject
    private UserDao userDao;

    @Override
    public Principal findByCredential(Credential credential)
            throws InvalidCredentialException, PrincipleNotFoundException {
        if (credential instanceof UsernamePasswordCredential) {
            String username = ((UsernamePasswordCredential) credential).getUsername();
            String passwordHash = ((UsernamePasswordCredential) credential).getPasswordHash();
            User user = userDao.getUsersByUsernameAndPassword(username, passwordHash);
        }
        throw new InvalidCredentialException("Credential is not supported.");
    }

    @Override
    public boolean hasActiveToken(Principal principal)
            throws InvalidCredentialException, PrincipleNotFoundException {
        return false;
    }

    @Override
    public Token getActiveToken(Principal principal)
            throws InvalidCredentialException, PrincipleNotFoundException {
        return null;
    }

    @Override
    public void registerToken(Principal principal, Token token)
            throws InvalidCredentialException, PrincipleNotFoundException {
    }

    @Override
    public Principal findByToken(Token token)
            throws InvalidTokenException, PrincipleNotFoundException {
        return null;
    }
}
