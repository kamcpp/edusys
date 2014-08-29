package org.labcrypto.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault (faultCode = FaultCode.SERVER)
public class ServerInternalErrorException extends EduSysException {

  private static final long serialVersionUID = 4081829830359294756L;

  public ServerInternalErrorException () {
    super (ExceptionMessages.ServerInternalError);
  }

  public ServerInternalErrorException (Throwable cause) {
    super (ExceptionMessages.ServerInternalError, cause);
  }
}
