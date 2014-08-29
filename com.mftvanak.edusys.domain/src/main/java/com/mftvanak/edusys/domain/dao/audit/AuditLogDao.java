package com.mftvanak.edusys.domain.dao.audit;

import com.mftvanak.edusys.domain.dao.EntityDao;
import com.mftvanak.edusys.domain.entity.audit.AuditLog;


public class AuditLogDao extends EntityDao < AuditLog > {

  public AuditLogDao () {
    super (AuditLog.class);
  }
}
