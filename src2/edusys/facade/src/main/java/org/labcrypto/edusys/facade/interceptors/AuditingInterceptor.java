package org.labcrypto.edusys.facade.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Auditable
@Interceptor
public class AuditingInterceptor {

    // @Inject
    // private AuditLogDao auditLogDao;

    @AroundInvoke
    public Object audit(InvocationContext invocationContext) throws Exception {
        System.out.println("Auditing ...");
        Object obj = invocationContext.proceed();
        System.out.println("Audited");
        return obj;
    }
}
