package org.labcrypto.edusys.ejb;

import org.labcrypto.edusys.domain.jpa.dao.membership.UserDao;
import org.labcrypto.edusys.domain.jpa.dao.membership.UserDaoImpl;

import javax.enterprise.inject.Produces;

public class DaoProducer {

    @Produces
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
