package org.labcrypto.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault (faultCode = FaultCode.SERVER)
public class RoleIsInUseException extends EduSysException {

  private static final long serialVersionUID = -8470673421766548444L;

  public RoleIsInUseException () {
    super (ExceptionMessages.RoleIsInUse);
  }

  public RoleIsInUseException (Throwable cause) {
    super (ExceptionMessages.RoleIsInUse, cause);
  }
}
