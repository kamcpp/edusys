package com.mftvanak.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault (faultCode = FaultCode.SERVER)
public class RoleAlreadyExistsException extends EduSysException {

  private static final long serialVersionUID = -8258611286092225562L;

  public RoleAlreadyExistsException () {
    super (ExceptionMessages.RoleAlreadyExists);
  }

  public RoleAlreadyExistsException (Throwable cause) {
    super (ExceptionMessages.RoleAlreadyExists, cause);
  }
}
