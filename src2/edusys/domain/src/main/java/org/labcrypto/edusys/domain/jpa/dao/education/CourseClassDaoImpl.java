package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.EntityDaoImpl;
import org.labcrypto.edusys.domain.jpa.entity.education.CourseClass;

public class CourseClassDaoImpl extends EntityDaoImpl<CourseClass> {

    public CourseClassDaoImpl() {
        super(CourseClass.class);
    }
}
