package org.labcrypto.edusys.department_report_portal.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Loggable
@Interceptor
public class LoggingInterceptor {

    @AroundInvoke
    public Object audit(InvocationContext invocationContext) throws Exception {
        System.out.println("Logging ...");
        Object obj = invocationContext.proceed();
        System.out.println("Logged");
        return obj;
    }
}
