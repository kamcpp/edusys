package com.mftvanak.edusys.domain.dao.messaging;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mftvanak.edusys.domain.dao.EntityDao;
import com.mftvanak.edusys.domain.entity.messaging.MessageTemplate;


public class MessageTemplateDao extends EntityDao < MessageTemplate > {

  public MessageTemplateDao () {
    super (MessageTemplate.class);
  }

  public List < MessageTemplate > getMessageTemplatesByOwnerId (long ownerId, int count) {
    String query = "from MessageTemplate as mt where mt.owner.id = :ownerId order by mt.submitDateTime desc";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("ownerId", ownerId);
    return executeQueryAsList (query, params, count);
  }
}
