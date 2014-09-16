package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.CourseClass;

public class CourseClassDao extends EntityDao<CourseClass> {

    public CourseClassDao() {
        super(CourseClass.class);
    }
}
