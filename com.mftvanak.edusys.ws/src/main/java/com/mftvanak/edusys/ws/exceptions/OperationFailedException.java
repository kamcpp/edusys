package com.mftvanak.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.SERVER)
public class OperationFailedException extends EduSysException {

  private static final long serialVersionUID = -1962507640417068470L;

  public OperationFailedException () {
    super (ExceptionMessages.OperationFailed);
  }

  public OperationFailedException (Throwable cause) {
    super (ExceptionMessages.OperationFailed, cause);
  }
}
