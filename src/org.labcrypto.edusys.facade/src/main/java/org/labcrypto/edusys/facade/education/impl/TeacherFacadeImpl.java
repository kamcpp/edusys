package org.labcrypto.edusys.facade.education.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.education.TeacherDao;
import org.labcrypto.edusys.domain.pg.entity.education.Teacher;
import org.labcrypto.edusys.facade.education.TeacherFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class TeacherFacadeImpl implements TeacherFacade {

	@Autowired
	private TeacherDao teacherDao;

	@Override
	public Long add(Teacher entity) {
		teacherDao.save(entity);
		return entity.getPersonId();
	}

	@Override
	public void update(Teacher entity) {
		teacherDao.save(entity);
	}

	@Override
	public void delete(Long id) {
		teacherDao.delete(id);
	}

	@Override
	public Teacher getById(Long id) {
		return teacherDao.getById(id);
	}

	@Override
	public List<Teacher> getAll() {
		return teacherDao.getAll();
	}
}
