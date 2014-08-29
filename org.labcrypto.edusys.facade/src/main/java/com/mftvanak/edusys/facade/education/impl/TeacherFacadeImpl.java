package com.mftvanak.edusys.facade.education.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.education.TeacherDao;
import com.mftvanak.edusys.domain.entity.education.Teacher;
import com.mftvanak.edusys.facade.education.TeacherFacade;


public class TeacherFacadeImpl implements TeacherFacade {

  @Autowired
  private TeacherDao teacherDao;
  
  @Override
  public Long add (Teacher entity) {
  teacherDao.save (entity);
    return entity.getPersonId ();
  }

  @Override
  public void update (Teacher entity) {
    teacherDao.save (entity);
  }

  @Override
  public void delete (Long id) {
    teacherDao.delete (id);
  }

  @Override
  public Teacher getById (Long id) {
    return teacherDao.getById (id);
  }

  @Override
  public List < Teacher > getAll () {
    return teacherDao.getAll ();
  }
}
