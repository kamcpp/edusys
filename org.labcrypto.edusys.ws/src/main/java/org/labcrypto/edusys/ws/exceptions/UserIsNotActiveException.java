package org.labcrypto.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER, faultStringOrReason = "User is not active.")
public class UserIsNotActiveException extends EduSysException {

  private static final long serialVersionUID = 670107926845365661L;

  public UserIsNotActiveException () {
    super (ExceptionMessages.UserIsNotActive);
  }

  public UserIsNotActiveException (Throwable throwable) {
    super (ExceptionMessages.UserIsNotActive, throwable);
  }
}
