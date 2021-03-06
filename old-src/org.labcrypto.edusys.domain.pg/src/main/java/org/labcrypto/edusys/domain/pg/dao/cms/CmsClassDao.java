package org.labcrypto.edusys.domain.pg.dao.cms;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.labcrypto.edusys.domain.pg.HibernateUtil;
import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.cms.CmsClass;


public class CmsClassDao extends EntityDao < CmsClass > {

  public CmsClassDao () {
    super (CmsClass.class);
  }

  public void saveOrUpdate (CmsClass cmsClass) {
    Session session = HibernateUtil.getSessionFactory ().openSession ();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction ();
      CmsClass existingCmsGroup = getById (cmsClass.getId ());
      if (existingCmsGroup == null) {
        System.out.println ("Adding new cmsClass ...");
        session.save (cmsClass);
        System.out.println ("Added new cmsClass('" + cmsClass.getId () + "').");
      } else {
        System.out.println ("Updating new cmsClass('" + cmsClass.getId () + "') ...");
        session.merge (cmsClass);
        System.out.println ("Updated new cmsClass('" + cmsClass.getId () + "').");
      }
      transaction.commit ();
    } catch (HibernateException e) {
      transaction.rollback ();
      e.printStackTrace ();
      throw e;
    } finally {
      session.close ();
    }
  }
}
