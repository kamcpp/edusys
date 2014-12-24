package org.labcrypto.edusys.domain.jpa.dao.membership;

import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.membership.User;

import java.util.List;

public class UserDaoImpl extends JpaEntityDao<User> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getUserByUsername(String username) {
        return entityManager.createQuery(
                "from User as u where u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public User getUserByEmail(String accountEmail) {
        return entityManager.createQuery(
                "from User as u where u.accountEmail = :email", User.class)
                .setParameter("email", accountEmail)
                .getSingleResult();
    }

    @Override
    public User getUsersByUsernameAndPassword(String username, String hashedPassword) {
        return entityManager.createQuery(
                "from User as u where u.username = :username and u.hashedPassword = :hashedPassword", User.class)
                .setParameter("username", username)
                .setParameter("hashedPassword", hashedPassword)
                .getSingleResult();
    }

    @Override
    public List<User> getUsersUsingRole(Long roleId) {
        return entityManager.createQuery(
                "select u from User as u join Role as r where r.id = :roleId", User.class)
                .setParameter("roleId", roleId)
                .getResultList();
    }
}
