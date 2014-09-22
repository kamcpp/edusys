package org.labcrypto.edusys.facade.membership;

public class DefaultToken implements Token {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
