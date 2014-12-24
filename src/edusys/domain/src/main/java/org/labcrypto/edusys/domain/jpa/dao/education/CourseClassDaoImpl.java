package org.labcrypto.edusys.domain.jpa.dao.education;


import org.labcrypto.edusys.domain.jpa.dao.JpaEntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.CourseClass;

public class CourseClassDaoImpl extends JpaEntityDao<CourseClass> implements CourseClassDao {

    public CourseClassDaoImpl() {
        super(CourseClass.class);
    }
}
