package org.labcrypto.edusys.facade.education.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.education.CourseDao;
import org.labcrypto.edusys.domain.pg.dao.education.CourseResourceDao;
import org.labcrypto.edusys.domain.pg.dao.education.CourseSyllabusDao;
import org.labcrypto.edusys.domain.pg.dao.education.TagDao;
import org.labcrypto.edusys.domain.pg.entity.education.Course;
import org.labcrypto.edusys.facade.education.CourseFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class CourseFacadeImpl implements CourseFacade {

	@Autowired
	private CourseDao courseDao;

	@Autowired
	private TagDao tagDao;

	@Autowired
	private CourseResourceDao courseResourceDao;

	@Autowired
	private CourseSyllabusDao courseSyllabusDao;

	@Override
	public Long add(Course entity) {
		courseDao.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Course entity) {
		courseDao.save(entity);
	}

	@Override
	public void delete(Long id) {
		courseDao.delete(id);
	}

	@Override
	public Course getById(Long id) {
		return courseDao.getById(id);
	}

	@Override
	public List<Course> getAll() {
		return courseDao.getAll();
	}

	@Override
	public void addTag(Long id, Long tagId) {

	}

	@Override
	public void removeTag(Long id, Long tagId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCourseResource(Long id, Long courseResourceId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCourseResource(Long id, Long courseResourceId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCourseSyllabus(Long id, Long courseSyllabusId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCourseSyllabus(Long id, Long courseSyllabusId) {
		// TODO Auto-generated method stub

	}
}
