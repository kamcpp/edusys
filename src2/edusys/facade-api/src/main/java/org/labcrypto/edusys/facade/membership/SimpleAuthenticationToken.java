package org.labcrypto.edusys.facade.membership;

import java.util.Random;

public class SimpleAuthenticationToken implements AuthenticationToken {
    private String token;

    public SimpleAuthenticationToken() {
        this.token = "" + new Random().nextInt(Integer.MAX_VALUE);
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
}
