package com.mftvanak.edusys.domain.dao.messaging;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mftvanak.edusys.domain.dao.EntityDao;
import com.mftvanak.edusys.domain.entity.messaging.TodoItem;


public class TodoItemDao extends EntityDao < TodoItem > {

  public TodoItemDao () {
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
