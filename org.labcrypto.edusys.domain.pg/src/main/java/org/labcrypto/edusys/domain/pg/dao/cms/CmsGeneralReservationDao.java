package org.labcrypto.edusys.domain.pg.dao.cms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.labcrypto.edusys.domain.pg.HibernateUtil;
import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.cms.CmsGeneralReservation;


public class CmsGeneralReservationDao extends EntityDao < CmsGeneralReservation > {

  public CmsGeneralReservationDao () {
    super (CmsGeneralReservation.class);
  }

  public void saveOrUpdate (CmsGeneralReservation cmsGeneralReservation) {
    Session session = HibernateUtil.getSessionFactory ().openSession ();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction ();
      CmsGeneralReservation existingCmsGeneralReservation = getById (cmsGeneralReservation.getId ());
      if (existingCmsGeneralReservation == null) {
        System.out.println ("Adding cmsGeneralReservation ...");
        session.save (cmsGeneralReservation);
        System.out.println ("Added new cmsGeneralReservation('" + cmsGeneralReservation.getId () + "').");
      } else {
        System.out.println ("Updating new cmsGeneralReservation('" + cmsGeneralReservation.getId () + "') ...");
        session.merge (cmsGeneralReservation);
        System.out.println ("Updated new cmsGeneralReservation('" + cmsGeneralReservation.getId () + "').");
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

  public List < CmsGeneralReservation > getCmsGeneralReservations (long departmentId, Long groupId, Long classId,
      Integer count) {
    Map < String, Object > params = new HashMap < String, Object > ();
    String query = "from CmsGeneralReservation as cgr where ";
    query += " cgr.clazz.group.department.id = :departmentId";
    params.put ("departmentId", departmentId);
    if (groupId != null) {
      query += " and cgr.clazz.group.id = :groupId";
      params.put ("groupId", groupId);
    }
    if (classId != null) {
      query += " and cgr.clazz.id = :classId";
      params.put ("classId", classId);
    }
    query += " order by cgr.date desc";
    return executeQueryAsList (query, params, count == null ? 0 : count);
  }
}
