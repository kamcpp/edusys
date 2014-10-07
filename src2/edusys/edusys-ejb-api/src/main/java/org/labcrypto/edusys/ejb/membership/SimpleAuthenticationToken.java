package org.labcrypto.edusys.ejb.membership;

import java.util.Random;

public class SimpleAuthenticationToken implements AuthenticationToken {

    private String token;
    private User user;

    public SimpleAuthenticationToken() {
        this.token = "" + new Random().nextInt(Integer.MAX_VALUE);
    }

    public SimpleAuthenticationToken(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "<<" + token + ">>";
    }

    @Override
    public User getUser() {
        return user;
    }
}
