package org.labcrypto.edusys.facade;

import org.labcrypto.edusys.EdusysException;

public class FacadeException extends EdusysException {
    public FacadeException() {
        super();
    }
    public FacadeException(Throwable e) {
        super(e);
    }
}
