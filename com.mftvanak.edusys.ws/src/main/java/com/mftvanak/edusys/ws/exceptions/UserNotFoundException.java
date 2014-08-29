package com.mftvanak.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER)
public class UserNotFoundException extends EduSysException {

  private static final long serialVersionUID = -6205519945417555547L;

  public UserNotFoundException () {
    super (ExceptionMessages.UserNotFound);
  }

  public UserNotFoundException (Throwable cause) {
    super (ExceptionMessages.UserNotFound, cause);
  }
}
