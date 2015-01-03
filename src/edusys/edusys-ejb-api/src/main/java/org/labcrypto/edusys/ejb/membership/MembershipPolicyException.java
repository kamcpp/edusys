package org.labcrypto.edusys.ejb.membership;

import org.labcrypto.edusys.ejb.EdusysEJBException;

public class MembershipPolicyException extends EdusysEJBException {
    public MembershipPolicyException() {
    }

    public MembershipPolicyException(String message) {
        super(message);
    }

    public MembershipPolicyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MembershipPolicyException(Throwable cause) {
        super(cause);
    }

    public MembershipPolicyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
