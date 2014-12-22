package org.labcrypto.edusys.domain.jpa.dao.audit;

import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.audit.AuditLog;

public class AuditLogDaoImpl extends EntityDaoImpl<AuditLog> {

    public AuditLogDaoImpl() {
        super(AuditLog.class);
    }
}
