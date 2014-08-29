package com.mftvanak.web.portal.web.controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mftvanak.web.portal.web.kaptcha.KaptchaCommon;

@Controller
@RequestMapping ("/captcha")
public class KaptchaController {

  @RequestMapping (method = RequestMethod.GET)
  public void captcha (HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setDateHeader ("Expires", 0);
    response.setHeader ("Cache-Control", "no-store, no-cache, must-revalidate");
    response.addHeader ("Cache-Control", "post-check=0, pre-check=0");
    response.setHeader ("Pragma", "no-cache");

    response.setContentType ("image/jpeg");

    String capText = KaptchaCommon.getConfigurationProvider ().getKaptchaProducer ().createText ();

    request.getSession ().setAttribute (KaptchaCommon.getConfigurationProvider ().getSessionKey (), capText);
    request.getSession ().setAttribute (KaptchaCommon.getConfigurationProvider ().getSessionDate (), new Date ());
    BufferedImage bi = KaptchaCommon.getConfigurationProvider ().getKaptchaProducer ().createImage (capText);

    ServletOutputStream out = response.getOutputStream ();
    ImageIO.write (bi, "jpg", out);
  }
}
