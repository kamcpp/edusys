package com.mftvanak.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER)
public class TokenIsEmptyException extends EduSysException {

  private static final long serialVersionUID = 4971637026348011211L;

  public TokenIsEmptyException () {
    super (ExceptionMessages.TokenIsEmpty);
  }

  public TokenIsEmptyException (Throwable cause) {
    super (ExceptionMessages.TokenIsEmpty, cause);
  }
}
