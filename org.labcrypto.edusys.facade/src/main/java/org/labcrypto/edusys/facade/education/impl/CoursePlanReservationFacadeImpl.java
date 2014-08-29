package org.labcrypto.edusys.facade.education.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.education.CoursePlanReservationDao;
import org.labcrypto.edusys.domain.pg.entity.education.CoursePlanReservation;
import org.labcrypto.edusys.facade.education.CoursePlanReservationFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class CoursePlanReservationFacadeImpl implements
		CoursePlanReservationFacade {

	@Autowired
	private CoursePlanReservationDao coursePlanReservationDao;

	@Override
	public Long add(CoursePlanReservation entity) {
		coursePlanReservationDao.save(entity);
		return entity.getId();
	}

	@Override
	public void update(CoursePlanReservation entity) {
		coursePlanReservationDao.save(entity);
	}

	@Override
	public void delete(Long id) {
		coursePlanReservationDao.delete(id);
	}

	@Override
	public CoursePlanReservation getById(Long id) {
		return coursePlanReservationDao.getById(id);
	}

	@Override
	public List<CoursePlanReservation> getAll() {
		return coursePlanReservationDao.getAll();
	}
}
