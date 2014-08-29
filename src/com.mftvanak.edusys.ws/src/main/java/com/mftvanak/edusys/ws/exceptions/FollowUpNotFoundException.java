package com.mftvanak.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER)
public class FollowUpNotFoundException extends EduSysException {

  private static final long serialVersionUID = -2712671927682565211L;

  public FollowUpNotFoundException () {
    super (ExceptionMessages.FollowUpNotFound);
  }

  public FollowUpNotFoundException (Throwable cause) {
    super (ExceptionMessages.FollowUpNotFound, cause);
  }
}
