package com.mftvanak.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER)
public class SendListItemNotFoundException extends EduSysException {

  private static final long serialVersionUID = -5153836270774680306L;

  public SendListItemNotFoundException () {
    super (ExceptionMessages.SendListItemNotFound);
  }

  public SendListItemNotFoundException (Throwable cause) {
    super (ExceptionMessages.SendListItemNotFound, cause);
  }
}
