package org.labcrypto.edusys.facade.membership;

import org.labcrypto.edusys.facade.FacadeException;

import java.io.Serializable;

public interface MembershipFacade extends Serializable {
    Token authenticate(Credential credential) throws AuthenticationException, FacadeException;
}
