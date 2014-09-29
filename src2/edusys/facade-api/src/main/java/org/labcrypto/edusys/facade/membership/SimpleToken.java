package org.labcrypto.edusys.facade.membership;

import java.io.Serializable;
import java.util.Random;

public class SimpleToken implements Token {
    private String token;

    public SimpleToken() {
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
