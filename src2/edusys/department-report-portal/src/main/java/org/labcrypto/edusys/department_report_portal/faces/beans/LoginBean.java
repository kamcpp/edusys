package org.labcrypto.edusys.department_report_portal.faces.beans;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean
public class LoginBean implements Serializable {

    private boolean rememberMe;
    private String captcha;
    private String username;
    private String password;

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String doLogin() {
        return "login";
    }
}
