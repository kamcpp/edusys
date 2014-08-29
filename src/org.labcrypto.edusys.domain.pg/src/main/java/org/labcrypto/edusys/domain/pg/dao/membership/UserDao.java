package org.labcrypto.edusys.domain.pg.dao.membership;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.membership.User;


public class UserDao extends EntityDao < User > {

  public UserDao () {
    super (User.class);
  }

  public User getUserByUsername (String username) {
    String query = "from User as u where u.username = :username";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("username", username);
    List < User > users = executeQueryAsList (query, params, 0);
    if (users.size () != 1) {
      return null;
    }
    return users.get (0);
  }

  public User getUserByEmail (String accountEmail) {
    String query = "from User as u where u.accountEmail = :email";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("email", accountEmail);
    List < User > users = executeQueryAsList (query, params, 0);
    if (users.size () != 1) {
      return null;
    }
    return users.get (0);
  }

  public User getUsersByUsernameAndPassword (String username, String hashedPassword) {
    String query = "from User as u where u.username = :username and u.hashedPassword = :hashedPassword";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("username", username);
    params.put ("hashedPassword", hashedPassword);
    List < User > users = executeQueryAsList (query, params, 0);
    if (users.size () != 1) {
      return null;
    }
    return users.get (0);
  }

  public List < User > getUsersUsingRole (Long roleId) {
    String query = "select u from User as u join Role as r where r.id = :roleId";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("roleId", roleId);
    return executeQueryAsList (query, params, 0);
  }
}
