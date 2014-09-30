package org.labcrypto.edusys.facade.membership;

import org.labcrypto.edusys.domain.jpa.dao.membership.TokenDao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AuthenticationTokenRepositoryImpl implements AuthenticationTokenRepository {

    //@Inject
    //private TokenDao tokenDao;

    @Override
    public void submitToken(AuthenticationToken authenticationToken, User user) {
        System.out.println("SUBMIT TOKEN");
    }

    @Override
    public void invalidateToken(AuthenticationToken authenticationToken) {
        System.out.println("INVALIDATE TOKEN");
    }
}
