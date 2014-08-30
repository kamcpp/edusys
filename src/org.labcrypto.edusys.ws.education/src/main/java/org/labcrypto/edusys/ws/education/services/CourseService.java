package org.labcrypto.edusys.ws.education.services;

import org.labcrypto.edusys.domain.pg.entity.education.Course;
import org.labcrypto.edusys.ws.EntityService;

public interface CourseService extends EntityService<Course> {

	void addTag(Long id, Long tagId);

	void removeTag(Long id, Long tagId);

	void addCourseResource(Long id, Long courseResourceId);

	void removeCourseResource(Long id, Long courseResourceId);

	void addCourseSyllabus(Long id, Long courseSyllabusId);

	void removeCourseSyllabus(Long id, Long courseSyllabusId);
}
