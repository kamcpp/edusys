package org.labcrypto.edusys.domain.jpa.dao.phonebook;

import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.phonebook.PhoneEntry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PhoneEntryDaoImpl extends EntityDaoImpl< PhoneEntry > {

  public PhoneEntryDaoImpl() {
    super (PhoneEntry.class);
  }

  public List < PhoneEntry > getPhoneEntriesByOwnerId (Long ownerId) {
    return getPhoneEntriesByOwnerId (ownerId, 0);
  }

  public List < PhoneEntry > getPhoneEntriesByOwnerId (Long ownerId, int count) {
    String query = "from PhoneEntry as pe where pe.owner.id = :ownerId order by pe.submitDate desc";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("ownerId", ownerId);
    return executeQueryAsList (query, params, count);
  }

  public List < PhoneEntry > getPhoneEntriesByPredicate (org.labcrypto.edusys.domain.jpa.dao.phonebook.PhoneEntrySearchPredicate predicate) {
    boolean whereClauseAdded = false;
    boolean firstConditionAdded = false;
    String query = "from PhoneEntry as pe";
    Map < String, Object > params = new HashMap < String, Object > ();
    if (predicate.getDepartmentId () != null) {
      if (!whereClauseAdded) {
        query += " where";
        whereClauseAdded = true;
      }
      if (firstConditionAdded) {
        query += " and";
      } else {
        firstConditionAdded = true;
      }
      query += " pe.department.id = :departmentId";
      params.put ("departmentId", predicate.getDepartmentId ());
    }
    if (predicate.getSubmitDateStart () != null) {
      if (!whereClauseAdded) {
        query += " where";
        whereClauseAdded = true;
      }
      if (firstConditionAdded) {
        query += " and";
      } else {
        firstConditionAdded = true;
      }
      query += " pe.submitDate >= :submitDateStart";
      params.put ("submitDateStart", predicate.getSubmitDateStart ());
    }
    if (predicate.getSubmitDateEnd () != null) {
      if (!whereClauseAdded) {
        query += " where";
        whereClauseAdded = true;
      }
      if (firstConditionAdded) {
        query += " and";
      } else {
        firstConditionAdded = true;
      }
      query += " pe.submitDate <= :submitDateEnd";
      params.put ("submitDateEnd", predicate.getSubmitDateEnd ());
    }
    query += " order by pe.submitDate desc";
    return executeQueryAsList (query, params, 0);
  }
}
