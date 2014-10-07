package org.labcrypto.edusys.ejb.membership;

import org.labcrypto.edusys.ejb.EdusysEJBException;

import javax.ejb.Remote;
import java.io.Serializable;

@Remote
public interface MembershipRemote extends Serializable {
    AuthenticationToken authenticate(Credential credential) throws AuthenticationEJBException, EdusysEJBException;
}
