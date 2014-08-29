package com.mftvanak.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER)
public class ClientInformationNeededException extends EduSysException {

  private static final long serialVersionUID = -2670431994836266736L;

  public ClientInformationNeededException () {
    super (ExceptionMessages.ClientInformationNeeded);
  }

  public ClientInformationNeededException (Throwable cause) {
    super (ExceptionMessages.ClientInformationNeeded, cause);
  }
}
