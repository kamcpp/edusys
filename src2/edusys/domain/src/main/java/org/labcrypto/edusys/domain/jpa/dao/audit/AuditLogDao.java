package org.labcrypto.edusys.domain.jpa.dao.audit;

import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.audit.AuditLog;

public class AuditLogDao extends EntityDao<AuditLog> {

    public AuditLogDao() {
        super(AuditLog.class);
    }
}
