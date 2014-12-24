package org.labcrypto.edusys.domain.jpa.dao.messaging;

import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.messaging.TodoItem;

import java.util.List;

public class TodoItemDaoImpl extends JpaEntityDao<TodoItem> implements TodoItemDao {

    public TodoItemDaoImpl() {
        super(TodoItem.class);
    }

    @Override
    public List<TodoItem> getTodoItemsForPerson(Long personId, int count) {
        return entityManager.createQuery(
                "from TodoItem as ti where ti.receiver.id = :personId order by ti.priority desc, ti.submitDateTime desc", TodoItem.class)
                .setParameter("personId", personId)
                .setMaxResults(count)
                .getResultList();
    }

    @Override
    public List<TodoItem> getTodoItemsForPerson(Long personId) {
        return getTodoItemsForPerson(personId, 0);
    }

    @Override
    public List<TodoItem> getTodoItemsAssignedByPerson(Long personId, int count) {
        return entityManager.createQuery(
                "from TodoItem as ti where ti.owner.id = :personId order by ti.priority desc, ti.submitDateTime desc", TodoItem.class)
                .setParameter("personId", personId)
                .setMaxResults(count)
                .getResultList();
    }

    @Override
    public List<TodoItem> getTodoItemsAssignedByPerson(Long personId) {
        return getTodoItemsAssignedByPerson(personId, 0);
    }
}
