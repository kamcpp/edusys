package org.labcrypto.edusys.facade.membership;

import org.labcrypto.edusys.facade.FacadeException;

public class AuthenticationException extends FacadeException {
    public AuthenticationException(Throwable e) {
        super(e);
    }
}
