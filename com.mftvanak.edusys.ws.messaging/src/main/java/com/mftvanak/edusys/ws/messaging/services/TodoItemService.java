package com.mftvanak.edusys.ws.messaging.services;

import java.util.List;

import com.mftvanak.edusys.domain.entity.messaging.TodoItem;


public interface TodoItemService {

  Long addTodoItem (TodoItem todoItem);

  void updateTodoItem (TodoItem todoItem);

  void deleteTodoItem (Long id);

  TodoItem getTodoItemById (Long id);

  List < TodoItem > getTodoItems ();

  List < TodoItem > getTodoItemsForPerson (Long personId, int count);

  List < TodoItem > getTodoItemsAssignedByPerson (Long personId, int count);

}
