package org.labcrypto.edusys.ejb.interceptors;

import org.labcrypto.edusys.domain.jpa.entity.audit.AuditLog;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Auditable
@Interceptor
public class AuditingInterceptor {

    @PersistenceContext(unitName = "edusys")
    private EntityManager entityManager;

    @AroundInvoke
    public Object audit(InvocationContext invocationContext) throws Exception {
        System.out.println("Saving audit log entity ...");
        AuditLog auditLog = new AuditLog();
        auditLog.setApplication("TestApplication");
        auditLog.setClientComputerName("TestClientComputerName");
        auditLog.setClientDateTime(1000);
        auditLog.setClientIpAddress("TestClientIpAddress");
        auditLog.setClientMacAddress("TestClientMacAddress");
        auditLog.setDescription("TestDescripiton");
        auditLog.setDetails("TestDetails");
        auditLog.setLocalAddress("TestLocalAddress");
        auditLog.setLogDateTime(2000);
        auditLog.setOperation("TestOperation");
        auditLog.setPersonId(50000L);
        auditLog.setRemoteAddress("TestRemoteAddress");
        auditLog.setService("TestService");
        auditLog.setServiceVersion("TestServiceVersion");
        auditLog.setTokenId(6000L);
        auditLog.setUsername("TestUserName");
        entityManager.persist(auditLog);
        Object obj = invocationContext.proceed();
        System.out.println("Audited");
        return obj;
    }
}
