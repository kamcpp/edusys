package com.mftvanak.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER)
public class NegativeResultException extends EduSysException {

  private static final long serialVersionUID = 8697975081208789786L;

  public NegativeResultException () {
    super (ExceptionMessages.NegativeResult);
  }

  public NegativeResultException (Throwable cause) {
    super (ExceptionMessages.NegativeResult, cause);
  }
}
