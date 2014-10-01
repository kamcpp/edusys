package org.labcrypto.edusys.domain.jpa.dao.membership.impl;

import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.membership.Token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TokenDaoImplImpl extends EntityDaoImpl< Token > {

  public TokenDaoImplImpl() {
    super (Token.class);
  }

  public Token getLatestActiveToken (Long userId) {
    String query = "from Token as t where t.user.id = :userId and t.active = true order by t.submitDate desc";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("userId", userId);
    List < Token > tokens = executeQueryAsList (query, params, 1);
    if (tokens.size () > 0) {
      return tokens.get (0);
    } else {
      return null;
    }
  }

  public Token getTokenByValue (String tokenValue) {
    String query = "from Token as t where t.value = :tokenValue";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("tokenValue", tokenValue);
    List < Token > tokens = executeQueryAsList (query, params, 0);
    if (tokens.size () > 0) {
      return tokens.get (0);
    } else {
      return null;
    }
  }
}
