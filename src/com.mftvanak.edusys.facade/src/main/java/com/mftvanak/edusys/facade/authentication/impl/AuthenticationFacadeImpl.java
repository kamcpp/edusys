package com.mftvanak.edusys.facade.authentication.impl;

import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.membership.TokenDao;
import com.mftvanak.edusys.domain.dao.membership.UserDao;
import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.domain.entity.membership.User;
import com.mftvanak.edusys.facade.authentication.AuthenticationFacade;


public class AuthenticationFacadeImpl implements AuthenticationFacade {

  @Autowired
  private UserDao userDao;

  @Autowired
  private TokenDao tokenDao;

  @Override
  public Token authenticate (String username, String hashedPassword) {
    User user = userDao.getUsersByUsernameAndPassword (username, hashedPassword);
    if (user == null) {
      return null;
    }
    long currentTime = DateTime.now (DateTimeZone.UTC).getMillis ();

    Token token = tokenDao.getLatestActiveToken (user.getPersonId ());
    if (token == null) {
      token = makeToken (user, currentTime);
    } else {
      if (validateToken (token)) {
        return token;
      } else {
        token = makeToken (user, currentTime);
      }
    }
    token.setLastAccessDate (currentTime);
    tokenDao.save (token);
    return token;
  }

  @Override
  public Token validateToken (String tokenValue) {
    Token token = tokenDao.getTokenByValue (tokenValue);
    if (token == null) {
      return null;
    } else {
      boolean result = validateToken (token);
      if (result) {
        return token;
      } else {
        return null;
      }
    }
  }

  private boolean validateToken (Token token) {
    if (!token.isActive ()) {
      return false;
    } else {
      long currentTime = DateTime.now (DateTimeZone.UTC).getMillis ();
      boolean shouldBeDeactivated = false;
      if (currentTime - token.getLastAccessDate () > token.getDeactivityMaximumDurationInMinutes () * 60 * 1000) {
        shouldBeDeactivated = true;
      }
      if (currentTime >= token.getExpireDate ()) {
        shouldBeDeactivated = true;
      }
      if (shouldBeDeactivated) {
        token.setActive (false);
        tokenDao.save (token);
        return false;
      }
      token.setLastAccessDate (currentTime);
      tokenDao.save (token);
      return true;
    }
  }

  @Override
  public void deactivateToken (String tokenValue) {
    if (tokenValue == null) {
      return;
    }
    Token token = tokenDao.getTokenByValue (tokenValue);
    if (token == null) {
      return;
    } else {
      token.setActive (false);
      tokenDao.save (token);
    }
  }

  private Token makeToken (User user, long currentTime) {
    Token newToken = new Token ();
    newToken.setActive (true);
    newToken.setDescription ("");
    newToken.setDeactivityMaximumDurationInMinutes ((long) (24 * 60));
    newToken.setExpireDate (currentTime + 24 * 60 * 60 * 1000);
    newToken.setSubmitDate (currentTime);
    newToken.setLastAccessDate (currentTime);
    newToken.setUser (user);
    newToken.setValue (UUID.randomUUID ().toString ());
    return newToken;
  }

  @Override
  public boolean userExistsByUsername (String username) {
    User user = userDao.getUserByUsername (username);
    return user != null;
  }

  @Override
  public boolean userExistsByEmail (String email) {
    User user = userDao.getUserByEmail (email);
    return user != null;
  }

  @Override
  public boolean changePassword (String username, String currentHashedPassword, String newHashedPassword) {
    User user = userDao.getUsersByUsernameAndPassword (username, currentHashedPassword);
    if (user == null) {
      return false;
    }
    user.setHashedPassword (newHashedPassword);
    userDao.save (user);
    return true;
  }
}
