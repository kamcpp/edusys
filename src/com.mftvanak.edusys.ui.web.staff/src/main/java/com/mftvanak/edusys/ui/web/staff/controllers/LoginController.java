package com.mftvanak.edusys.ui.web.staff.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.mftvanak.edusys.ui.web.staff.forms.LoginForm;


@Controller
@RequestMapping ("/login")
public class LoginController {

  @Autowired
  @Qualifier ("authenticationManager")
  protected AuthenticationManager authenticationManager;

  @RequestMapping (method = RequestMethod.GET)
  public String get (ModelMap model, Principal principal) {
    model.addAttribute ("principal", principal);
    model.addAttribute ("loginForm", new LoginForm ());
    return "login";
  }

  @RequestMapping (method = RequestMethod.POST)
  public Object post (@Valid LoginForm loginForm, BindingResult result, ModelMap model, Principal principal, HttpServletRequest request,
      HttpServletResponse response) {
    if (result.hasErrors ()) {
      return "login";
    }
    model.addAttribute ("principal", principal);

    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken (loginForm.getUsername (), loginForm.getPassword ());
    request.getSession ();
    token.setDetails (new WebAuthenticationDetails (request));

    try {
      Authentication authenticatedUser = authenticationManager.authenticate (token);
      SecurityContextHolder.getContext ().setAuthentication (authenticatedUser);
    } catch (Exception e) {
      e.printStackTrace ();
      model.addAttribute ("ErrorMessage", "نام کاربری و یا کلمه عبور اشتباه است.");
      return "login";
    }
    return new RedirectView ("");
  }
}
