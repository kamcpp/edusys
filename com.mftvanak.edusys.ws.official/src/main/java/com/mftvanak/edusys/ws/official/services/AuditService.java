package com.mftvanak.edusys.ws.official.services;

import com.mftvanak.edusys.domain.entity.membership.Token;


public interface AuditService {

  void addAuditLog (Token token, String operation, String service, String serviceVersion, String details, String description, long clientDateTime,
      String clientMacAddress, String clientIpAddress, String clientComputerName, String application);

}
