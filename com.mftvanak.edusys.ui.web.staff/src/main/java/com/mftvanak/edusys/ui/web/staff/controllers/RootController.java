package com.mftvanak.edusys.ui.web.staff.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping ("/")
public class RootController {

  @RequestMapping (value = "/", method = RequestMethod.GET)
  public String getRoot (ModelMap model, Principal principal) {
    model.addAttribute ("principal", principal);
    return "home";
  }
}
