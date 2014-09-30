package org.labcrypto.edusys.facade.membership;

import org.labcrypto.edusys.facade.FacadeException;
import org.labcrypto.edusys.facade.interceptors.Auditable;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless(name = "membershipFacade")
public class MembershipFacadeImpl implements MembershipFacade {

    @Inject
    private MembershipRepository membershipRepository;
    @Inject
    private AuthenticationTokenFactory authenticationTokenFactory;
    @Inject
    private AuthenticationTokenRepository authenticationTokenRepository;

    @Override
    @Auditable
    public AuthenticationToken authenticate(Credential credential) throws AuthenticationException, FacadeException {
        try {
            User user = membershipRepository.getByCredential(credential);
            AuthenticationToken authenticationToken = authenticationTokenFactory.create(credential, user);
            authenticationTokenRepository.submitToken(authenticationToken, user);
            return authenticationToken;
        } catch (UserNotFoundException e) {
            throw new AuthenticationException(e);
        }
    }
}
