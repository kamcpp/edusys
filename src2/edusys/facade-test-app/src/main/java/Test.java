import org.labcrypto.edusys.facade.FacadeException;
import org.labcrypto.edusys.facade.membership.AuthenticationException;
import org.labcrypto.edusys.facade.membership.MembershipFacade;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws NamingException, FacadeException {
        // Properties properties = new Properties();
        // properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.openejb.client.RemoteInitialContextFactory");
        // properties.put(Context.PROVIDER_URL, "http://127.0.0.1:8080/tomee/ejb");
        InitialContext context = new InitialContext();
        MembershipFacade membershipFacade = (MembershipFacade) context.lookup("MembershipFacadeRemote");
        System.out.println(membershipFacade.authenticate(null).toString());
    }
}
