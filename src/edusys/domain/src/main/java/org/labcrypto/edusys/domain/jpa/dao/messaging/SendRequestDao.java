package org.labcrypto.edusys.domain.jpa.dao.messaging;

import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.messaging.SendRequest;

import java.util.List;

public interface SendRequestDao extends EntityDao<SendRequest> {

    List< SendRequest > getSendRequestsByOwnerId (long ownerId, int count);
}
