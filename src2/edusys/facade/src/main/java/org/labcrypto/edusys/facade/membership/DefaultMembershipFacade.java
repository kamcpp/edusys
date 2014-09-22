package org.labcrypto.edusys.facade.membership;

import org.labcrypto.edusys.facade.FacadeException;

public class DefaultMembershipFacade implements MembershipFacade {

    private MembershipRepositoryFactory membershipRepositoryFactory;
    private TokenFactory tokenFactory;
    private TokenRepositoryFactory tokenRepositoryFactory;

    @Override
    public Token authenticate(Credential credential) throws AuthenticationException, FacadeException {
        try {
            User user = membershipRepositoryFactory.getMembershipRepository().getByCredential(credential);
            Token token = tokenFactory.create(credential, user);
            tokenRepositoryFactory.getTokenRepository().submitToken(token, user);
            return token;
        } catch (UserNotFoundException e) {
            throw new AuthenticationException(e);
        }
    }
}
