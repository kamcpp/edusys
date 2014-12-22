package org.labcrypto.edusys.department_report_portal.faces.beans;

import org.labcrypto.edusys.department_report_portal.interceptors.Loggable;
import org.labcrypto.edusys.ejb.EdusysEJBException;
import org.labcrypto.edusys.ejb.membership.AuthenticationToken;
import org.labcrypto.edusys.ejb.membership.MembershipLocal;
import org.labcrypto.edusys.ejb.membership.UsernamePasswordCredential;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ManagedBean
public class LoginBean implements Serializable {

    private boolean rememberMe;
    private String captcha;
    private String username;
    private String password;

    @EJB(name="membershipEJB")
    private MembershipLocal membership;

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
            AuthenticationToken authenticationToken = membership.authenticate(new UsernamePasswordCredential(username, password));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("token", authenticationToken);
            return "home";
        } catch (EdusysEJBException e) {
            e.printStackTrace();
            return "login";
        }
    }
}
