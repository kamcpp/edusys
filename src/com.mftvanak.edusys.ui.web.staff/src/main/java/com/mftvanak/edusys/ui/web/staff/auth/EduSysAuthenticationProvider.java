package com.mftvanak.edusys.ui.web.staff.auth;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.mftvanak.edusys.ws.authentication.schemas.AuthenticationRequest;
import com.mftvanak.edusys.ws.authentication.schemas.AuthenticationResponse;
import com.mftvanak.edusys.ws.authentication.schemas.RoleType;


public class EduSysAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  private WebServiceTemplate authenticationWsTemplate;

  @Override
  public Authentication authenticate (Authentication authentication)
      throws AuthenticationException {
    AuthenticationRequest request = new AuthenticationRequest ();
    request.setClientComputerName ("WebServer");
    request.setApplicationName ("StaffWeb");
    request.setClientDateTimeDay (1);
    request.setClientDateTimeMonth (1);
    request.setClientDateTimeYear (1);
    request.setClientDateTimeHour (1);
    request.setClientDateTimeMinute (1);
    request.setClientDateTimeSecond (1);
    request.setClientDateTimeMilliSecond (1);
    request.setClientIpAddress ("1.1.1.1");
    request.setClientMacAddress ("1:1:1:1:1:1");
    request.setPassword (DigestUtils.sha1Hex (authentication.getCredentials ()
        .toString ()));
    request.setUsername (authentication.getName ());

    AuthenticationResponse response = (AuthenticationResponse) authenticationWsTemplate
        .marshalSendAndReceive (request);
    System.out.println ("===> " + response.getToken ());

    List < GrantedAuthority > grantedAuthorities = new ArrayList <> ();
    for (RoleType role : response.getRoles ()) {
      grantedAuthorities.add (new SimpleGrantedAuthority (role.getName ()));
    }
    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken (
        authentication.getName (), authentication.getCredentials (),
        grantedAuthorities);
    token.setDetails (response);
    return token;
  }

  @Override
  public boolean supports (Class < ? > authentication) {
    return UsernamePasswordAuthenticationToken.class
        .isAssignableFrom (authentication);
  }
}
