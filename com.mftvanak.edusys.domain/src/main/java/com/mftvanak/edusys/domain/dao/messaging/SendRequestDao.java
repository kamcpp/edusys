package com.mftvanak.edusys.domain.dao.messaging;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mftvanak.edusys.domain.dao.EntityDao;
import com.mftvanak.edusys.domain.entity.messaging.SendRequest;


public class SendRequestDao extends EntityDao < SendRequest > {

  public SendRequestDao () {
    super (SendRequest.class);
  }

  public List < SendRequest > getSendRequestsByOwnerId (long ownerId, int count) {
    String query = "from SendRequest sr mt where sr.owner.id = :ownerId order by sr.submitDateTime desc";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("ownerId", ownerId);
    return executeQueryAsList (query, params, count);
  }
}
