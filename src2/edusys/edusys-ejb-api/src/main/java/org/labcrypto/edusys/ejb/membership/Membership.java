package org.labcrypto.edusys.ejb.membership;

import org.labcrypto.edusys.ejb.EdusysEJBException;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.io.Serializable;

@Local
@Remote
public interface Membership extends Serializable {
    AuthenticationToken authenticate(Credential credential) throws AuthenticationEJBException, EdusysEJBException;
}
