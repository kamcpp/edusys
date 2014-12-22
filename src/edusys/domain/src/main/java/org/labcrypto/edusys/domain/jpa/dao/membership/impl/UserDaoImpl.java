package org.labcrypto.edusys.domain.jpa.dao.membership.impl;

import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.dao.membership.UserDao;
import org.labcrypto.edusys.domain.jpa.entity.membership.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl extends EntityDaoImpl<User> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getUserByUsername(String username) {
        String query = "from User as u where u.username = :username";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);
        List<User> users = executeQueryAsList(query, params, 0);
        if (users.size() != 1) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public User getUserByEmail(String accountEmail) {
        String query = "from User as u where u.accountEmail = :email";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("email", accountEmail);
        List<User> users = executeQueryAsList(query, params, 0);
        if (users.size() != 1) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public User getUsersByUsernameAndPassword(String username, String hashedPassword) {
        String query = "from User as u where u.username = :username and u.hashedPassword = :hashedPassword";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);
        params.put("hashedPassword", hashedPassword);
        List<User> users = executeQueryAsList(query, params, 0);
        if (users.size() != 1) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public List<User> getUsersUsingRole(Long roleId) {
        String query = "select u from User as u join Role as r where r.id = :roleId";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roleId", roleId);
        return executeQueryAsList(query, params, 0);
    }
}
