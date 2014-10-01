package org.labcrypto.edusys.department_report_portal.faces.beans;

import org.labcrypto.edusys.department_report_portal.interceptors.Loggable;
import org.labcrypto.edusys.facade.FacadeException;
import org.labcrypto.edusys.facade.membership.AuthenticationException;
import org.labcrypto.edusys.facade.membership.AuthenticationToken;
import org.labcrypto.edusys.facade.membership.MembershipFacade;
import org.labcrypto.edusys.facade.membership.UsernamePasswordCredential;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ManagedBean
public class LoginBean implements Serializable {

    private boolean rememberMe;
    private String captcha;
    private String username;
    private String password;

    @Inject
    private MembershipFacade membershipFacade;

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

    @Loggable
    public String doLogin() {
        try {
            AuthenticationToken authenticationToken = membershipFacade.authenticate(new UsernamePasswordCredential(username, password));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("token", authenticationToken);
            return "home";
        } catch (FacadeException e) {
            e.printStackTrace();
            return "login";
        }
    }
}
