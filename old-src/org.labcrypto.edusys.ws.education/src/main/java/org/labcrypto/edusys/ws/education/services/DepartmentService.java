package org.labcrypto.edusys.ws.education.services;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.education.Department;
import org.labcrypto.edusys.ws.EntityService;

public interface DepartmentService extends EntityService<Department> {

	List<Department> getByInstituteId(Long instituteId);

}
