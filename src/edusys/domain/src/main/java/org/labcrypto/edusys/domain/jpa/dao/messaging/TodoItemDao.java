package org.labcrypto.edusys.domain.jpa.dao.messaging;

import org.labcrypto.edusys.domain.jpa.entity.messaging.TodoItem;

import java.util.List;

public interface TodoItemDao {

    List< TodoItem > getTodoItemsForPerson (Long personId, int count);

    List < TodoItem > getTodoItemsForPerson (Long personId);

    List < TodoItem > getTodoItemsAssignedByPerson (Long personId, int count);

    List < TodoItem > getTodoItemsAssignedByPerson (Long personId);
}
