package org.labcrypto.edusys.facade.membership;

import java.io.Serializable;

public interface AuthenticationTokenFactory extends Serializable {
    AuthenticationToken create(Credential credential, User user);
}
