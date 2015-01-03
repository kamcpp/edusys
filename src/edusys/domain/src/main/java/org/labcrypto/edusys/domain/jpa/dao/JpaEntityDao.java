package org.labcrypto.edusys.domain.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaEntityDao<T> implements EntityDao<T> {

    // @PersistenceContext(unitName = "edusys")
    protected EntityManager entityManager;

    private Class<T> type;

    public JpaEntityDao(Class<T> type) {
        this.type = type;
    }

    @Override
    public void save(T entity) {
        Long id;
        try {
            id = (Long) type.getMethod("getId").invoke(entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (id == null) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
    }

    @Override
    public void delete(Long id) {
        T entity = getById(id);
        entityManager.remove(entity);
    }

    @Override
    public T getById(Long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(type);
        Root<T> root = query.from(type);
        ParameterExpression<Long> idParameter = criteriaBuilder.parameter(Long.class);
        query.select(root).where(criteriaBuilder.equal(root.get("id"), idParameter));
        TypedQuery<T> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult();
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root);
        TypedQuery<T> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
