package org.labcrypto.edusys.domain.jpa.dao;

import java.util.List;

public interface EntityDao <T> {

    void save(T entity);

    void delete(Long id);

    T getById(Long id);

    List<T> getAll();
}
