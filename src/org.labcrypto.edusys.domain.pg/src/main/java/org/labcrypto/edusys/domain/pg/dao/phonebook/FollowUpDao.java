package org.labcrypto.edusys.domain.pg.dao.phonebook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.labcrypto.edusys.domain.pg.dao.EntityDao;
import org.labcrypto.edusys.domain.pg.entity.phonebook.FollowUp;


public class FollowUpDao extends EntityDao < FollowUp > {

  public FollowUpDao () {
    super (FollowUp.class);
  }

  public List < FollowUp > getFollowUpsByPhoneEntry (Long phoneEntryId) {
    String query = "from FollowUp as f where f.phoneEntry.id = :phoneEntryId";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("phoneEntryId", phoneEntryId);
    return executeQueryAsList (query, params, 0);
  }
}
