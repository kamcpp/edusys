package com.mftvanak.edusys.facade.messaging;

import java.util.List;

import com.mftvanak.edusys.domain.entity.messaging.TodoItem;


public interface TodoItemFacade {

  Long addTodoItem (TodoItem todoItem);

  void updateTodoItem (TodoItem todoItem);

  void deleteTodoItem (Long id);

  TodoItem getTodoItemById (Long id);

  List < TodoItem > getTodoItems ();

  List < TodoItem > getTodoItemsForPerson (Long personId, int count);

  List < TodoItem > getTodoItemsAssignedByPerson (Long personId, int count);

}
