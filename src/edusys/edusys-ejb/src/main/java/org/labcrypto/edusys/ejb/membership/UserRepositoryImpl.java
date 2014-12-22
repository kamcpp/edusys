package org.labcrypto.edusys.ejb.membership;

import org.labcrypto.edusys.domain.jpa.dao.membership.UserDao;
import org.labcrypto.edusys.ejb.EdusysEJBException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

    @Inject
    private UserDao userDao;

    @Override
    public User getByCredential(Credential credential) throws EdusysEJBException {

        // throw new UserNotFoundException();
        return null;
    }
}
