package org.labcrypto.edusys.facade.membership;

import org.labcrypto.edusys.facade.FacadeException;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MembershipRepositoryImpl implements MembershipRepository {

    @Override
    public User getByCredential(Credential credential) throws UserNotFoundException, FacadeException {
        // throw new UserNotFoundException();
        return null;
    }
}
