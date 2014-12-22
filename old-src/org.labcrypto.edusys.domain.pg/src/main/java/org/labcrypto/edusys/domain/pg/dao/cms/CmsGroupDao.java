package org.labcrypto.edusys.domain.pg.dao.cms;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.labcrypto.edusys.domain.pg.HibernateUtil;
import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.cms.CmsGroup;


public class CmsGroupDao extends EntityDao < CmsGroup > {

  public CmsGroupDao () {
    super (CmsGroup.class);
  }

  public void saveOrUpdate (CmsGroup cmsGroup) {
    Session session = HibernateUtil.getSessionFactory ().openSession ();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction ();
      CmsGroup existingCmsGroup = getById (cmsGroup.getId ());
      if (existingCmsGroup == null) {
        System.out.println ("Adding cmsGroup ...");
        session.save (cmsGroup);
        System.out.println ("Added new cmsGroup('" + cmsGroup.getId () + "').");
      } else {
        System.out.println ("Updating new cmsGroup('" + cmsGroup.getId () + "') ...");
        session.merge (cmsGroup);
        System.out.println ("Updated new cmsGroup('" + cmsGroup.getId () + "').");
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
