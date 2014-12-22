package org.labcrypto.edusys.ejb.membership;

import java.io.Serializable;

public interface AuthenticationToken extends Serializable {
    User getUser();
}
