package org.labcrypto.edusys.domain.jpa.dao.membership;

import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.membership.Token;

public class TokenDaoImpl extends JpaEntityDao<Token> implements TokenDao {

    public TokenDaoImpl() {
        super(Token.class);
    }

    @Override
    public Token getLatestActiveToken(Long userId) {
        return entityManager.createQuery(
                "from Token as t where t.user.id = :userId and t.active = true order by t.submitDate desc", Token.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }

    @Override
    public Token getTokenByValue(String tokenValue) {
        return entityManager.createQuery(
                "from Token as t where t.value = :tokenValue", Token.class)
                .setParameter("tokenValue", tokenValue)
                .getSingleResult();
    }
}
