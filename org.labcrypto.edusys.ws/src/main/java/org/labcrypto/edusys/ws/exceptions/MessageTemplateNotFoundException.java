package org.labcrypto.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER)
public class MessageTemplateNotFoundException extends EduSysException {

  private static final long serialVersionUID = -2472639090583551494L;

  public MessageTemplateNotFoundException () {
    super (ExceptionMessages.MessageTemplateNotFound);
  }

  public MessageTemplateNotFoundException (Throwable cause) {
    super (ExceptionMessages.MessageTemplateNotFound, cause);
  }
}
