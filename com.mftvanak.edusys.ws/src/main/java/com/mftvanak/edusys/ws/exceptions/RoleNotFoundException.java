package com.mftvanak.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault (faultCode = FaultCode.SERVER)
public class RoleNotFoundException extends EduSysException {

  private static final long serialVersionUID = -6205519945417555547L;

  public RoleNotFoundException () {
    super (ExceptionMessages.RoleNotFound);
  }

  public RoleNotFoundException (Throwable cause) {
    super (ExceptionMessages.RoleNotFound, cause);
  }
}
