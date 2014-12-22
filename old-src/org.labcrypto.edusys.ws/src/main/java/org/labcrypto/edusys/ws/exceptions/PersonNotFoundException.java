package org.labcrypto.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER)
public class PersonNotFoundException extends EduSysException {

  private static final long serialVersionUID = 6320876403934202960L;

  public PersonNotFoundException () {
    super (ExceptionMessages.PersonNotFound);
  }

  public PersonNotFoundException (Throwable cause) {
    super (ExceptionMessages.PersonNotFound, cause);
  }
}
