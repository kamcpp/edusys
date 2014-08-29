package org.labcrypto.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER)
public class TodoItemNotFoundException extends EduSysException {

  private static final long serialVersionUID = 6483631528438419146L;

  public TodoItemNotFoundException () {
    super (ExceptionMessages.TodoItemNotFound);
  }

  public TodoItemNotFoundException (Throwable cause) {
    super (ExceptionMessages.TodoItemNotFound, cause);
  }
}
