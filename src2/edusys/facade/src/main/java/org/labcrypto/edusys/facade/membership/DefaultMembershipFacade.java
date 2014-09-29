package org.labcrypto.edusys.facade.membership;

import org.labcrypto.edusys.facade.FacadeException;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.io.Serializable;

@Remote
@Stateless(name = "MembershipFacade")
public class DefaultMembershipFacade implements MembershipFacade {

    // private MembershipRepositoryFactory membershipRepositoryFactory;
    private TokenFactory tokenFactory;
    // private TokenRepositoryFactory tokenRepositoryFactory;

    public DefaultMembershipFacade() {
        tokenFactory = new DefaultTokenFactory();
    }

    @Override
    public Token authenticate(Credential credential) throws AuthenticationException, FacadeException {
//        try {
//            User user = membershipRepositoryFactory.getMembershipRepository().getByCredential(credential);
//            Token token = tokenFactory.create(credential, user);
//            tokenRepositoryFactory.getTokenRepository().submitToken(token, user);
//            return token;
//        } catch (UserNotFoundException e) {
//            throw new AuthenticationException(e);
//        }
        return tokenFactory.create(credential, null);
    }
}
