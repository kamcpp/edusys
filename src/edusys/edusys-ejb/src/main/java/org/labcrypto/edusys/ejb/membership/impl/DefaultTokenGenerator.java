package org.labcrypto.edusys.ejb.membership.impl;

import org.labcrypto.edusys.ejb.membership.Credential;
import org.labcrypto.edusys.ejb.membership.Principal;
import org.labcrypto.edusys.ejb.membership.Token;
import org.labcrypto.edusys.ejb.membership.TokenGenerator;

public class DefaultTokenGenerator implements TokenGenerator {
    @Override
    public Token generate(Credential credential, Principal user) {
        return null;
    }
}
