package com.mftvanak.edusys.facade;

import java.util.List;


public interface EntityFacade < T > {

  Long add (T entity);

  void update (T entity);

  void delete (Long id);

  T getById (Long id);

  List < T > getAll ();
}
