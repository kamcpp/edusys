package org.labcrypto.edusys.facade.membership;

public class Facade {
    public static MembershipFacadeFactory getMembershipFacadeFactory() {
        return new DefaultMembershipFacadeFactory();
    }
}
