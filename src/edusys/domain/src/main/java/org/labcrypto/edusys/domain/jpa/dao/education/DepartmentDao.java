package org.labcrypto.edusys.domain.jpa.dao.education;

import org.labcrypto.edusys.domain.jpa.dao.EntityDao;
import org.labcrypto.edusys.domain.jpa.entity.education.Department;

import java.util.List;

public interface DepartmentDao extends EntityDao<Department> {

    List< Department > getDepartmentsByInstituteId (Long instituteId);
}
