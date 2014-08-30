package com.mftvanak.edusys.ws.education.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.education.CoursePlanReservation;
import com.mftvanak.edusys.facade.education.CoursePlanReservationFacade;
import com.mftvanak.edusys.ws.education.services.CoursePlanReservationService;


public class CoursePlanReservationServiceImpl implements CoursePlanReservationService {

  @Autowired
  private CoursePlanReservationFacade coursePlanReservationFacade;

  @Override
  public Long addEntity (CoursePlanReservation entity) {
    return coursePlanReservationFacade.add (entity);
  }

  @Override
  public void updateEntity (CoursePlanReservation entity) {
    coursePlanReservationFacade.update (entity);
  }

  @Override
  public void deleteEntity (Long id) {
    coursePlanReservationFacade.delete (id);
  }

  @Override
  public CoursePlanReservation getEntityById (Long id) {
    return coursePlanReservationFacade.getById (id);
  }

  @Override
  public List < CoursePlanReservation > getAllEntities () {
    return coursePlanReservationFacade.getAll ();
  }
}