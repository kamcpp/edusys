package org.labcrypto.edusys.ejb.membership;

import java.io.Serializable;

public interface AuthenticationTokenFactory extends Serializable {
    AuthenticationToken create(Credential credential, User user);
}
