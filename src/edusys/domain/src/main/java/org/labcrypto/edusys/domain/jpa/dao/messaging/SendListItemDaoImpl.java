package org.labcrypto.edusys.domain.jpa.dao.messaging;

import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.messaging.SendListItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SendListItemDaoImpl extends EntityDaoImpl< SendListItem > {

  public SendListItemDaoImpl() {
    super (SendListItem.class);
  }

  public List < SendListItem > getSendListItemsByOwnerId (long ownerId, int count) {
    String query = "from SendListItem as sli where sli.owner.id = :ownerId order by sli.serverSubmitDateTime desc";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("ownerId", ownerId);
    return executeQueryAsList (query, params, count);
  }

  public List < SendListItem > getSendListItemsByOwnerId (long ownerId) {
    return getSendListItemsByOwnerId (ownerId, 0);
  }

  public List < SendListItem > getNotSentYetSmsSendListItems () {
    String query = "from SendListItem as sli where sli.delivery = 1 and sli.type = 1 and sli.status < 3 order by sli.serverSubmitDateTime, sli.status desc";
    return executeQueryAsList (query, null, 0);
  }
}
