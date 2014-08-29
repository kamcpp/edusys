package com.mftvanak.edusys.facade.audit;

public interface AuditFacade {

  Long addAuditLog (String nodeId, long logDateTime, long clientDateTime, String operation, Long tokenId, Long personId, String username,
      String clientMacAddress, String clientIpAddress, String clientComputerName, String localAddress, String remoteAddress, String service,
      String serviceVersion, String application, String details, String description);

}
