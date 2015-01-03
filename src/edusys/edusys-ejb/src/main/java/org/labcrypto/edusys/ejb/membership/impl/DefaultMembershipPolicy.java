package org.labcrypto.edusys.ejb.membership.impl;

import org.labcrypto.edusys.ejb.membership.Credential;
import org.labcrypto.edusys.ejb.membership.MembershipPolicy;

public class DefaultMembershipPolicy implements MembershipPolicy {

    @Override
    public boolean allowsAuthentication(Credential credential) {
        return true;
    }

    @Override
    public void submitAuthenticateRequest(Credential credential) {

    }

    @Override
    public void submitAuthenticationFailure(Credential credential) {

    }

    @Override
    public void submitAuthenticationSuccess(Credential credential) {

    }
}
