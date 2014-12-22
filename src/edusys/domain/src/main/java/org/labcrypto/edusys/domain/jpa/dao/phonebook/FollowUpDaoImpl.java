package org.labcrypto.edusys.domain.jpa.dao.phonebook;

import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.phonebook.FollowUp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FollowUpDaoImpl extends EntityDaoImpl< FollowUp > {

  public FollowUpDaoImpl() {
    super (FollowUp.class);
  }

  public List < FollowUp > getFollowUpsByPhoneEntry (Long phoneEntryId) {
    String query = "from FollowUp as f where f.phoneEntry.id = :phoneEntryId";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("phoneEntryId", phoneEntryId);
    return executeQueryAsList (query, params, 0);
  }
}
