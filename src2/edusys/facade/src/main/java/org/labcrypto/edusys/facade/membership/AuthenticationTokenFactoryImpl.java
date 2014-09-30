package org.labcrypto.edusys.facade.membership;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthenticationTokenFactoryImpl implements AuthenticationTokenFactory {

    @Override
    public AuthenticationToken create(Credential credential, User user) {
        return new SimpleAuthenticationToken();
    }
}
