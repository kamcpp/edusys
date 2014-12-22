package org.labcrypto.edusys.facade.audit.impl;

import org.labcrypto.edusys.domain.pg.dao.audit.AuditLogDao;
import org.labcrypto.edusys.domain.pg.entity.audit.AuditLog;
import org.labcrypto.edusys.facade.audit.AuditFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class AuditFacadeImpl implements AuditFacade {

	@Autowired
	private AuditLogDao auditLogDao;

	@Override
	public Long addAuditLog(String nodeId, long logDateTime,
			long clientDateTime, String operation, Long tokenId, Long personId,
			String username, String clientMacAddress, String clientIpAddress,
			String clientComputerName, String localAddress,
			String remoteAddress, String service, String serviceVersion,
			String application, String details, String description) {
		AuditLog auditLog = new AuditLog();
		auditLog.setClientComputerName(clientComputerName);
		auditLog.setClientDateTime(clientDateTime);
		auditLog.setClientIpAddress(clientIpAddress);
		auditLog.setClientMacAddress(clientMacAddress);
		auditLog.setDescription(description);
		auditLog.setDetails(details);
		auditLog.setLogDateTime(logDateTime);
		auditLog.setOperation(operation);
		auditLog.setService(service);
		auditLog.setServiceVersion(serviceVersion);
		auditLog.setTokenId(tokenId);
		auditLog.setPersonId(personId);
		auditLog.setUsername(username);
		auditLog.setApplication(application);
		auditLog.setLocalAddress(localAddress);
		auditLog.setRemoteAddress(remoteAddress);
		auditLogDao.save(auditLog);
		return auditLog.getId();
	}
}
