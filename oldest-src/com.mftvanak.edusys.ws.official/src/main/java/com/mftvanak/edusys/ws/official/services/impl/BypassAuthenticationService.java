package com.mftvanak.edusys.ws.official.services.impl;

import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.ws.official.services.AuthenticationService;


public class BypassAuthenticationService implements AuthenticationService {

  @Override
  public Token validateToken (String token) {
    return null;
  }
}
