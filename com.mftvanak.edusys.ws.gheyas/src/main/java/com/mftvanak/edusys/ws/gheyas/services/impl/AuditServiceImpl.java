package com.mftvanak.edusys.ws.gheyas.services.impl;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpServletConnection;

import com.mftvanak.edusys.domain.entity.membership.Token;
import com.mftvanak.edusys.facade.audit.AuditFacade;
import com.mftvanak.edusys.ws.gheyas.services.AuditService;


public class AuditServiceImpl implements AuditService {

  @Autowired
  private AuditFacade auditFacade;

  @Override
  public void addAuditLog (Token token, String operation, String service, String serviceVersion, String details, String description,
      long clientDateTime, String clientMacAddress, String clientIpAddress, String clientComputerName, String application) {
    TransportContext context = TransportContextHolder.getTransportContext ();
    HttpServletConnection connection = (HttpServletConnection) context.getConnection ();
    HttpServletRequest request = connection.getHttpServletRequest ();
    String remoteAddress = request.getRemoteAddr ();
    String localAddress = request.getLocalAddr ();
    auditFacade.addAuditLog (UUID.randomUUID ().toString (), DateTime.now (DateTimeZone.UTC).getMillis (), clientDateTime, operation, token.getId (), token.getUser ()
        .getPersonId (), token.getUser ().getUsername (), clientMacAddress, clientIpAddress, clientComputerName, localAddress, remoteAddress, service,
        serviceVersion, application, details, description);
  }
}
