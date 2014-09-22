package org.labcrypto.edusys.facade.membership;

import org.labcrypto.edusys.facade.FacadeException;

public interface MembershipFacade {
    Token authenticate(Credential credential) throws AuthenticationException, FacadeException;
}
