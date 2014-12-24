package org.labcrypto.edusys.domain.jpa.dao.membership;

import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.membership.Token;

public interface TokenDao extends EntityDao<Token> {

    Token getLatestActiveToken(Long userId);

    Token getTokenByValue(String tokenValue);
}
