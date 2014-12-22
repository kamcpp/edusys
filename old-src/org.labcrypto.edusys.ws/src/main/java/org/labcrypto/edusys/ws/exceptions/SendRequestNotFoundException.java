package org.labcrypto.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER)
public class SendRequestNotFoundException extends EduSysException {

  private static final long serialVersionUID = -5351427048069971246L;

  public SendRequestNotFoundException () {
    super (ExceptionMessages.SendRequestNotFound);
  }

  public SendRequestNotFoundException (Throwable cause) {
    super (ExceptionMessages.SendRequestNotFound, cause);
  }
}
