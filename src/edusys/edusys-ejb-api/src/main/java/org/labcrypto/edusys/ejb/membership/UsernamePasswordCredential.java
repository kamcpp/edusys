package org.labcrypto.edusys.ejb.membership;

public class UsernamePasswordCredential implements Credential {
    private String username;
    private String passwordHash;

    public UsernamePasswordCredential() {
    }

    public UsernamePasswordCredential(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
