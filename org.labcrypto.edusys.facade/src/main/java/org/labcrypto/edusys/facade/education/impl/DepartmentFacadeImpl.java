package org.labcrypto.edusys.facade.education.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.education.DepartmentDao;
import org.labcrypto.edusys.domain.pg.entity.education.Department;
import org.labcrypto.edusys.facade.education.DepartmentFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentFacadeImpl implements DepartmentFacade {

	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public Long add(Department entity) {
		departmentDao.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Department entity) {
		departmentDao.save(entity);
	}

	@Override
	public void delete(Long id) {
		departmentDao.delete(id);
	}

	@Override
	public Department getById(Long id) {
		return departmentDao.getById(id);
	}

	@Override
	public List<Department> getByInstituteId(Long instituteId) {
		return departmentDao.getDepartmentsByInstituteId(instituteId);
	}

	@Override
	public List<Department> getAll() {
		return departmentDao.getAll();
	}
}
