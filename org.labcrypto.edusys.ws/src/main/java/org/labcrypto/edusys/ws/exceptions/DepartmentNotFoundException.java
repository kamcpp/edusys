package org.labcrypto.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault (faultCode = FaultCode.SERVER)
public class DepartmentNotFoundException extends EduSysException {

  private static final long serialVersionUID = 4520362066244857000L;

  public DepartmentNotFoundException () {
    super (ExceptionMessages.DepartmentNotFound);
  }

  public DepartmentNotFoundException (Throwable cause) {
    super (ExceptionMessages.DepartmentNotFound, cause);
  }
}
