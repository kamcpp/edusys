package org.labcrypto.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER)
public class UserIsNotAuthorizedException extends EduSysException {

  private static final long serialVersionUID = 670107926845365661L;

  public UserIsNotAuthorizedException () {
    super (ExceptionMessages.UserIsNotAuthorized);
  }

  public UserIsNotAuthorizedException (Throwable throwable) {
    super (ExceptionMessages.UserIsNotAuthorized, throwable);
  }
}
