package org.labcrypto.edusys.domain.jpa.dao;

import org.hibernate.SessionFactory;

/**
 * Created by kamran on 17/09/14.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
