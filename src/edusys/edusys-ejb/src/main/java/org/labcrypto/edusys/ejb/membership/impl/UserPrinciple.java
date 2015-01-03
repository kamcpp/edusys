package org.labcrypto.edusys.ejb.membership.impl;

import org.labcrypto.edusys.domain.jpa.entity.membership.User;
import org.labcrypto.edusys.ejb.membership.Principal;
import org.labcrypto.edusys.ejb.membership.Role;

import java.util.ArrayList;
import java.util.List;

public class UserPrinciple implements Principal {

    private List<Role> roles;
    private User user;

    public UserPrinciple(User user) {
        this.user = user;
    }
    @Override
    public List<Role> roles() {
        if (roles == null) {
            roles = new ArrayList<>();
        }
        return roles;
    }
}
