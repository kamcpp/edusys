package org.labcrypto.edusys.facade.membership;

import java.io.Serializable;

public interface AuthenticationToken extends Serializable {
    User getUser();
}
