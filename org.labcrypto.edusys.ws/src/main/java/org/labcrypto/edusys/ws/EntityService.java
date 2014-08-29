package org.labcrypto.edusys.ws;

import java.util.List;


public interface EntityService<T> {
  
  Long addEntity(T entity);
  
  void updateEntity(T entity);
  
  void deleteEntity(Long id);
  
  T getEntityById(Long id);
  
  List<T> getAllEntities();
}
