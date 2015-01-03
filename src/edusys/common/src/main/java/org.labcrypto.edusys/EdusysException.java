package org.labcrypto.edusys;

public class EdusysException extends Exception {
    public EdusysException() {
    }

    public EdusysException(String message) {
        super(message);
    }

    public EdusysException(String message, Throwable cause) {
        super(message, cause);
    }

    public EdusysException(Throwable cause) {
        super(cause);
    }

    public EdusysException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
