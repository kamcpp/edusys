package org.labcrypto.edusys.ejb.membership;

import org.labcrypto.edusys.ejb.EdusysEJBException;
import org.labcrypto.edusys.ejb.interceptors.Auditable;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MembershipEJB implements Membership {

    @Inject
    private UserRepository userRepository;
    @Inject
    private AuthenticationTokenFactory authenticationTokenFactory;
    @Inject
    private AuthenticationTokenRepository authenticationTokenRepository;

    @Override
    @Auditable
    public AuthenticationToken authenticate(Credential credential) throws EdusysEJBException {
        try {
            User user = userRepository.getByCredential(credential);
            AuthenticationToken authenticationToken = authenticationTokenFactory.create(credential, user);
            authenticationTokenRepository.submitToken(authenticationToken, user);
            return authenticationToken;
        } catch (UserNotFoundEJBException e) {
            throw new AuthenticationEJBException(e);
        }
    }
}
