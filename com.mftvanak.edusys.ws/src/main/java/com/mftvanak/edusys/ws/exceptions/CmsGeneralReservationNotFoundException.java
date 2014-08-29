package com.mftvanak.edusys.ws.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;


@SoapFault (faultCode = FaultCode.SERVER)
public class CmsGeneralReservationNotFoundException extends EduSysException {

  private static final long serialVersionUID = 7966428824675446957L;

  public CmsGeneralReservationNotFoundException () {
    super (ExceptionMessages.CmsGeneralReservationNotFound);
  }

  public CmsGeneralReservationNotFoundException (Throwable cause) {
    super (ExceptionMessages.CmsGeneralReservationNotFound, cause);
  }
}
