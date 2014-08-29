package com.mftvanak.edusys.facade.education.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.education.CoursePlanReservationDao;
import com.mftvanak.edusys.domain.entity.education.CoursePlanReservation;
import com.mftvanak.edusys.facade.education.CoursePlanReservationFacade;


public class CoursePlanReservationFacadeImpl implements CoursePlanReservationFacade {

  @Autowired
  private CoursePlanReservationDao coursePlanReservationDao;

  @Override
  public Long add (CoursePlanReservation entity) {
    coursePlanReservationDao.save (entity);
    return entity.getId ();
  }

  @Override
  public void update (CoursePlanReservation entity) {
    coursePlanReservationDao.save (entity);
  }

  @Override
  public void delete (Long id) {
    coursePlanReservationDao.delete (id);
  }

  @Override
  public CoursePlanReservation getById (Long id) {
    return coursePlanReservationDao.getById (id);
  }

  @Override
  public List < CoursePlanReservation > getAll () {
    return coursePlanReservationDao.getAll ();
  }
}
