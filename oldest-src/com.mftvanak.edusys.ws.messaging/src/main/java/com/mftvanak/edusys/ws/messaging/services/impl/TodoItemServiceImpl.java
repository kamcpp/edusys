package com.mftvanak.edusys.ws.messaging.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.messaging.TodoItem;
import com.mftvanak.edusys.facade.messaging.TodoItemFacade;
import com.mftvanak.edusys.ws.messaging.services.TodoItemService;


public class TodoItemServiceImpl implements TodoItemService {

  @Autowired
  public TodoItemFacade todoItemFacade;

  @Override
  public Long addTodoItem (TodoItem todoItem) {
    return todoItemFacade.addTodoItem (todoItem);
  }

  @Override
  public void updateTodoItem (TodoItem todoItem) {
    todoItemFacade.updateTodoItem (todoItem);
  }

  @Override
  public void deleteTodoItem (Long id) {
    todoItemFacade.deleteTodoItem (id);
  }

  @Override
  public TodoItem getTodoItemById (Long id) {
    return todoItemFacade.getTodoItemById (id);
  }

  @Override
  public List < TodoItem > getTodoItems () {
    return todoItemFacade.getTodoItems ();
  }

  @Override
  public List < TodoItem > getTodoItemsForPerson (Long personId, int count) {
    return todoItemFacade.getTodoItemsForPerson (personId, count);
  }

  @Override
  public List < TodoItem > getTodoItemsAssignedByPerson (Long personId, int count) {
    return todoItemFacade.getTodoItemsAssignedByPerson (personId, count);
  }
}
