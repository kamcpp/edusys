package org.labcrypto.edusys.domain.pg.dao.cms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.labcrypto.edusys.domain.pg.HibernateUtil;
import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.cms.CmsReservation;


public class CmsReservationDao extends EntityDao < CmsReservation > {

  public CmsReservationDao () {
    super (CmsReservation.class);
  }

  public void saveOrUpdate (CmsReservation cmsReservation) {
    Session session = HibernateUtil.getSessionFactory ().openSession ();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction ();
      CmsReservation existingCmsReservation = getById (cmsReservation.getId ());
      if (existingCmsReservation == null) {
        System.out.println ("Adding cmsReservation ...");
        session.save (cmsReservation);
        System.out.println ("Added new cmsReservation('" + cmsReservation.getId () + "').");
      } else {
        System.out.println ("Updating new cmsReservation('" + cmsReservation.getId () + "') ...");
        session.merge (cmsReservation);
        System.out.println ("Updated new cmsReservation('" + cmsReservation.getId () + "').");
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

  public List < CmsReservation > getCmsReservations (long departmentId, long reservationPlanId, Integer count) {
    Map < String, Object > params = new HashMap < String, Object > ();
    String query = "from CmsReservation as cr where ";
    query += " cr.department.id = :departmentId";
    query += " and cr.reservationPlan.id = :reservationPlanId";
    query += " order by cr.date desc";
    params.put ("departmentId", departmentId);
    params.put ("reservationPlanId", reservationPlanId);
    return executeQueryAsList (query, params, count == null ? 0 : count);
  }
}
