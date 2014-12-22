package org.labcrypto.edusys.ws.education.services.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.entity.education.Department;
import org.labcrypto.edusys.facade.education.DepartmentFacade;
import org.labcrypto.edusys.ws.education.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentFacade departmentFacade;

	@Override
	public Long addEntity(Department entity) {
		return departmentFacade.add(entity);
	}

	@Override
	public void updateEntity(Department entity) {
		departmentFacade.update(entity);
	}

	@Override
	public void deleteEntity(Long id) {
		departmentFacade.delete(id);
	}

	@Override
	public Department getEntityById(Long id) {
		return departmentFacade.getById(id);
	}

	@Override
	public List<Department> getAllEntities() {
		return departmentFacade.getAll();
	}

	@Override
	public List<Department> getByInstituteId(Long instituteId) {
		return departmentFacade.getByInstituteId(instituteId);
	}
}
