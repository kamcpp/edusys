package org.labcrypto.edusys.domain.mongo.dao;

import org.labcrypto.edusys.domain.mongo.entity.AuditLog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuditLogRepository extends
		PagingAndSortingRepository<AuditLog, Long> {

}
