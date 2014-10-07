package org.labcrypto.edusys.ejb.membership;

import org.labcrypto.edusys.ejb.EdusysEJBException;

public interface UserRepository {
    User getByCredential(Credential credential) throws EdusysEJBException;
}
