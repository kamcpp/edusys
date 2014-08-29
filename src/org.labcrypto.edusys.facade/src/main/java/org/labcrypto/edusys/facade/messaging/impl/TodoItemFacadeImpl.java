package org.labcrypto.edusys.facade.messaging.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.messaging.TodoItemDao;
import org.labcrypto.edusys.domain.pg.entity.messaging.TodoItem;
import org.labcrypto.edusys.facade.messaging.TodoItemFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class TodoItemFacadeImpl implements TodoItemFacade {

	@Autowired
	private TodoItemDao todoItemDao;

	@Override
	public Long addTodoItem(TodoItem todoItem) {
		todoItemDao.save(todoItem);
		return todoItem.getId();
	}

	@Override
	public void updateTodoItem(TodoItem todoItem) {
		todoItemDao.save(todoItem);
	}

	@Override
	public void deleteTodoItem(Long id) {
		todoItemDao.delete(id);
	}

	@Override
	public TodoItem getTodoItemById(Long id) {
		return todoItemDao.getById(id);
	}

	@Override
	public List<TodoItem> getTodoItems() {
		return todoItemDao.getAll();
	}

	@Override
	public List<TodoItem> getTodoItemsForPerson(Long personId, int count) {
		if (count == 0) {
			return todoItemDao.getTodoItemsForPerson(personId);
		} else {
			return todoItemDao.getTodoItemsForPerson(personId, count);
		}
	}

	@Override
	public List<TodoItem> getTodoItemsAssignedByPerson(Long personId, int count) {
		if (count == 0) {
			return todoItemDao.getTodoItemsAssignedByPerson(personId);
		} else {
			return todoItemDao.getTodoItemsAssignedByPerson(personId, count);
		}
	}
}
