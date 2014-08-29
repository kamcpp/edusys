package org.labcrypto.edusys.facade.education;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.education.Department;
import org.labcrypto.edusys.facade.EntityFacade;

public interface DepartmentFacade extends EntityFacade<Department> {

	List<Department> getByInstituteId(Long institudeId);
}
