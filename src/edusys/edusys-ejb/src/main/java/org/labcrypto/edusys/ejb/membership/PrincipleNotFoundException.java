package org.labcrypto.edusys.ejb.membership;

import org.labcrypto.edusys.ejb.EdusysEJBException;

public class PrincipleNotFoundException extends EdusysEJBException {
    public PrincipleNotFoundException() {
    }

    public PrincipleNotFoundException(String message) {
        super(message);
    }

    public PrincipleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrincipleNotFoundException(Throwable cause) {
        super(cause);
    }

    public PrincipleNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
