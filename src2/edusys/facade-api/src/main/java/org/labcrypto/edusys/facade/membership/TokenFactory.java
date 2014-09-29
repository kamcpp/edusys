package org.labcrypto.edusys.facade.membership;

import java.io.Serializable;

public interface TokenFactory extends Serializable {
    Token create(Credential credential, User user);
}
