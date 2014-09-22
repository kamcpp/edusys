package org.labcrypto.edusys.department_report_portal.faces.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class LoginProcessorBean {

    @ManagedProperty(value="#{loginBean}")
    private LoginBean loginBean;

    public LoginProcessorBean() {
        System.out.println("Login Processor Bean has been created.");
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public String doLogin() {

        return "login";
    }
}
