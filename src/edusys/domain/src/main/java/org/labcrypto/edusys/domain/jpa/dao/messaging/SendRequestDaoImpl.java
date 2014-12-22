package org.labcrypto.edusys.domain.jpa.dao.messaging;

import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.messaging.SendRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SendRequestDaoImpl extends EntityDaoImpl< SendRequest > {

  public SendRequestDaoImpl() {
    super (SendRequest.class);
  }

  public List < SendRequest > getSendRequestsByOwnerId (long ownerId, int count) {
    String query = "from SendRequest sr mt where sr.owner.id = :ownerId order by sr.submitDateTime desc";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("ownerId", ownerId);
    return executeQueryAsList (query, params, count);
  }
}
