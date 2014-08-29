package com.mftvanak.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER)
public class InstituteNotFoundException extends EduSysException {

  private static final long serialVersionUID = -4472037370075243481L;

  public InstituteNotFoundException () {
    super (ExceptionMessages.InstituteNotFound);
  }

  public InstituteNotFoundException (Throwable cause) {
    super (ExceptionMessages.InstituteNotFound, cause);
  }
}
