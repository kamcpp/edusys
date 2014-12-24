package org.labcrypto.edusys.domain.jpa.dao.audit;

import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.audit.AuditLog;

public class AuditLogDaoImpl extends JpaEntityDao<AuditLog> implements AuditLogDao {

    public AuditLogDaoImpl() {
        super(AuditLog.class);
    }
}
