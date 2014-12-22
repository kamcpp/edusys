package org.labcrypto.edusys.facade.messaging;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.messaging.TodoItem;

public interface TodoItemFacade {

	Long addTodoItem(TodoItem todoItem);

	void updateTodoItem(TodoItem todoItem);

	void deleteTodoItem(Long id);

	TodoItem getTodoItemById(Long id);

	List<TodoItem> getTodoItems();

	List<TodoItem> getTodoItemsForPerson(Long personId, int count);

	List<TodoItem> getTodoItemsAssignedByPerson(Long personId, int count);

}
