package org.labcrypto.edusys.ejb;

import org.labcrypto.edusys.EdusysException;

public class EdusysEJBException extends EdusysException {
    public EdusysEJBException() {
    }

    public EdusysEJBException(String message) {
        super(message);
    }

    public EdusysEJBException(String message, Throwable cause) {
        super(message, cause);
    }

    public EdusysEJBException(Throwable cause) {
        super(cause);
    }

    public EdusysEJBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
