package org.labcrypto.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER)
public class AuthenticationInformationNeededException extends EduSysException {

  private static final long serialVersionUID = -7617113783002967242L;

  public AuthenticationInformationNeededException () {
    super (ExceptionMessages.UsernameIsEmpty);
  }

  public AuthenticationInformationNeededException (Throwable cause) {
    super (ExceptionMessages.UsernameIsEmpty, cause);
  }
}
