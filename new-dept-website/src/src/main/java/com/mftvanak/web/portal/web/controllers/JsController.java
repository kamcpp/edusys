package com.mftvanak.web.portal.web.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/js")
public class JsController {

	@RequestMapping("/init")
	public ModelAndView init(HttpServletResponse response) {
		response.setContentType("text/javascript");
		return new ModelAndView("js-init");
	}
}
