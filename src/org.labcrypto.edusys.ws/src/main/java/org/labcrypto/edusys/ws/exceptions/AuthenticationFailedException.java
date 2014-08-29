package org.labcrypto.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER, faultStringOrReason = "Authentication failed.")
public class AuthenticationFailedException extends EduSysException {

  private static final long serialVersionUID = -2566572539891639292L;

  public AuthenticationFailedException () {
    super (ExceptionMessages.AuthenticationFailed);
  }

  public AuthenticationFailedException (Throwable cause) {
    super (ExceptionMessages.AuthenticationFailed, cause);
  }
}
