package org.labcrypto.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER)
public class PhoneEntryNotFoundException extends EduSysException {

  private static final long serialVersionUID = 5203304873216236445L;

  public PhoneEntryNotFoundException () {
    super (ExceptionMessages.PhoneEntryNotFound);
  }

  public PhoneEntryNotFoundException (Throwable cause) {
    super (ExceptionMessages.PhoneEntryNotFound, cause);
  }
}
