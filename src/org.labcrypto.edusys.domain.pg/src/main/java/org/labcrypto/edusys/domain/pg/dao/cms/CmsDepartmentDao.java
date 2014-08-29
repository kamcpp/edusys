package org.labcrypto.edusys.domain.pg.dao.cms;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.labcrypto.edusys.domain.pg.HibernateUtil;
import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.cms.CmsDepartment;


public class CmsDepartmentDao extends EntityDao < CmsDepartment > {

  public CmsDepartmentDao () {
    super (CmsDepartment.class);
  }

  public void saveOrUpdate (CmsDepartment cmsDepartemant) {
    Session session = HibernateUtil.getSessionFactory ().openSession ();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction ();
      CmsDepartment existingCmsDepartment = getById (cmsDepartemant.getId ());
      if (existingCmsDepartment == null) {
        System.out.println ("Adding cmsDepartemant ...");
        session.save (cmsDepartemant);
        System.out.println ("Added new cmsDepartemant('" + cmsDepartemant.getId () + "').");
      } else {
        System.out.println ("Updating new cmsDepartemant('" + cmsDepartemant.getId () + "') ...");
        session.merge (cmsDepartemant);
        System.out.println ("Updated new cmsDepartemant('" + cmsDepartemant.getId () + "').");
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
