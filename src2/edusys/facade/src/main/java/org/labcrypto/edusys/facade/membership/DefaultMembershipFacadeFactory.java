package org.labcrypto.edusys.facade.membership;

public class DefaultMembershipFacadeFactory implements MembershipFacadeFactory {
    @Override
    public MembershipFacade getMembershipFacade() {
        return new DefaultMembershipFacade();
    }
}
