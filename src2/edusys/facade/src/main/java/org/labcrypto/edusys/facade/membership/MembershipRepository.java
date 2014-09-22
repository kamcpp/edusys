package org.labcrypto.edusys.facade.membership;

import org.labcrypto.edusys.facade.FacadeException;

public interface MembershipRepository {
    User getByCredential(Credential credential) throws UserNotFoundException, FacadeException;
}
