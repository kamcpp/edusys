package org.labcrypto.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER)
public class TokenIsNotAuthenticatedException extends EduSysException {

  private static final long serialVersionUID = 2329764163289253639L;

  public TokenIsNotAuthenticatedException () {
    super (ExceptionMessages.TokenIsNotAuthenticated);
  }

  public TokenIsNotAuthenticatedException (Throwable cause) {
    super (ExceptionMessages.TokenIsNotAuthenticated, cause);
  }
}
