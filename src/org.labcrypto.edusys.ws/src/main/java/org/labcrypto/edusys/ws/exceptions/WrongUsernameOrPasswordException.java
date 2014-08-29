package org.labcrypto.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER, faultStringOrReason = "Wrong username or password.")
public class WrongUsernameOrPasswordException extends EduSysException {

  private static final long serialVersionUID = -3090207039748679724L;

  public WrongUsernameOrPasswordException () {
    super (ExceptionMessages.WrongUsernameOrPassword);
  }

  public WrongUsernameOrPasswordException (Throwable cause) {
    super (ExceptionMessages.WrongUsernameOrPassword, cause);
  }
}
