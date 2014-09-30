package org.labcrypto.edusys.facade.membership;

import org.labcrypto.edusys.facade.FacadeException;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.io.Serializable;

@Remote
@Local
public interface MembershipFacade extends Serializable {
    AuthenticationToken authenticate(Credential credential) throws AuthenticationException, FacadeException;
}
