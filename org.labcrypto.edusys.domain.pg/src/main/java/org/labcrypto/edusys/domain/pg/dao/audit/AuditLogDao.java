package org.labcrypto.edusys.domain.pg.dao.audit;

import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.audit.AuditLog;


public class AuditLogDao extends EntityDao < AuditLog > {

  public AuditLogDao () {
    super (AuditLog.class);
  }
}
