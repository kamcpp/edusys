package org.labcrypto.edusys.ejb.membership.impl;


import org.labcrypto.edusys.ejb.membership.Token;
import org.labcrypto.edusys.ejb.membership.TokenNotFoundException;
import org.labcrypto.edusys.ejb.membership.TokenRepository;

public class DefaultTokenRepository implements TokenRepository {

    @Override
    public Token findByValue(String value) throws TokenNotFoundException {
        return null;
    }

    @Override
    public void expireToken(Token token) throws TokenNotFoundException {

    }

    @Override
    public void disableToken(Token token) throws TokenNotFoundException {

    }
}
