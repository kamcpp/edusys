package org.labcrypto.edusys.facade.education;

import org.labcrypto.edusys.domain.pg.entity.education.Course;
import org.labcrypto.edusys.facade.EntityFacade;

public interface CourseFacade extends EntityFacade<Course> {

	void addTag(Long id, Long tagId);

	void removeTag(Long id, Long tagId);

	void addCourseResource(Long id, Long courseResourceId);

	void removeCourseResource(Long id, Long courseResourceId);

	void addCourseSyllabus(Long id, Long courseSyllabusId);

	void removeCourseSyllabus(Long id, Long courseSyllabusId);

}
