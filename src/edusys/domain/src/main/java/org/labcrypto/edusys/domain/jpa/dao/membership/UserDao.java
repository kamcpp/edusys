package org.labcrypto.edusys.domain.jpa.dao.membership;

import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.membership.User;

import java.util.List;

public interface UserDao extends EntityDao<User> {
    User getUserByUsername(String username);

    User getUserByEmail(String accountEmail);

    User getUsersByUsernameAndPassword(String username, String hashedPassword);

    List<User> getUsersUsingRole(Long roleId);
}
