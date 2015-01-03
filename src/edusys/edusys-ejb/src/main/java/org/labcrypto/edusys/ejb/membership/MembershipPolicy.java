package org.labcrypto.edusys.ejb.membership;

public interface MembershipPolicy {

    boolean allowsAuthentication(Credential credential);

    void submitAuthenticateRequest(Credential credential);

    void submitAuthenticationFailure(Credential credential);

    void submitAuthenticationSuccess(Credential credential);
}
