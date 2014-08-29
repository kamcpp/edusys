package com.mftvanak.edusys.ui.web.staff.forms;

import org.hibernate.validator.constraints.NotEmpty;

import com.mftvanak.edusys.ui.web.staff.kaptcha.Constants;
import com.mftvanak.edusys.ui.web.staff.validation.constraints.Captcha;


public class LoginForm {

  @NotEmpty (message = "لطفا نام کاربری را وارد نمایید")
  private String username;
  @NotEmpty (message = "لطفا کلمه عبور را وارد نمایید")
  private String password;
  @NotEmpty(message = "لطفا عبارت داخل عکس را وارد نمایید")
  @Captcha (sessionKey = Constants.KAPTCHA_SESSION_KEY, message = "لطفا در وارد کردن عبارت داخل عکس دقت کنید")
  private String captcha;

  public String getUsername () {
    return username;
  }

  public void setUsername (String username) {
    this.username = username;
  }

  public String getPassword () {
    return password;
  }

  public void setPassword (String password) {
    this.password = password;
  }

  public String getCaptcha () {
    return captcha;
  }

  public void setCaptcha (String captcha) {
    this.captcha = captcha;
  }
}
