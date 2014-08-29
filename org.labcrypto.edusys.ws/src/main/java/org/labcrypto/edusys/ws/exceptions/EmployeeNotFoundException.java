package org.labcrypto.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault (faultCode = FaultCode.SERVER)
public class EmployeeNotFoundException extends EduSysException {

  private static final long serialVersionUID = -4647519504480797761L;

  public EmployeeNotFoundException () {
    super (ExceptionMessages.EmployeeNotFound);
  }

  public EmployeeNotFoundException (Throwable cause) {
    super (ExceptionMessages.EmployeeNotFound, cause);
  }
}
