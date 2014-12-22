package org.labcrypto.edusys.domain.jpa.dao.messaging;

import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.messaging.TodoItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TodoItemDaoImpl extends EntityDaoImpl< TodoItem > {

  public TodoItemDaoImpl() {
    super (TodoItem.class);
  }

  public List < TodoItem > getTodoItemsForPerson (Long personId, int count) {
    String query = "from TodoItem as ti where ti.receiver.id = :personId order by ti.priority desc, ti.submitDateTime desc";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("personId", personId);
    return executeQueryAsList (query, params, count);
  }

  public List < TodoItem > getTodoItemsForPerson (Long personId) {
    return getTodoItemsForPerson (personId, 0);
  }

  public List < TodoItem > getTodoItemsAssignedByPerson (Long personId, int count) {
    String query = "from TodoItem as ti where ti.owner.id = :personId order by ti.priority desc, ti.submitDateTime desc";
    Map < String, Object > params = new HashMap < String, Object > ();
    params.put ("personId", personId);
    return executeQueryAsList (query, params, count);
  }

  public List < TodoItem > getTodoItemsAssignedByPerson (Long personId) {
    return getTodoItemsAssignedByPerson (personId, 0);
  }
}
