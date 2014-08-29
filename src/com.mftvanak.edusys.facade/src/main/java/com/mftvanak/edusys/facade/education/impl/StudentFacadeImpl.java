package com.mftvanak.edusys.facade.education.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.education.StudentDao;
import com.mftvanak.edusys.domain.entity.education.Student;
import com.mftvanak.edusys.facade.education.StudentFacade;


public class StudentFacadeImpl implements StudentFacade {

  @Autowired
  private StudentDao studentDao;

  @Override
  public Long add (Student entity) {
    studentDao.save (entity);
    return entity.getPersonId ();
  }

  @Override
  public void update (Student entity) {
    studentDao.save (entity);
  }

  @Override
  public void delete (Long id) {
    studentDao.delete (id);
  }

  @Override
  public Student getById (Long id) {
    return studentDao.getById (id);
  }

  @Override
  public List < Student > getAll () {
    return studentDao.getAll ();
  }
}
