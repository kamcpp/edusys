package org.labcrypto.edusys.facade.official.impl;

import java.util.List;

import org.labcrypto.edusys.domain.pg.dao.official.EmployeeDao;
import org.labcrypto.edusys.domain.pg.entity.official.Employee;
import org.labcrypto.edusys.facade.official.EmployeeFacade;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeFacadeImpl implements EmployeeFacade {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Long addEmployee(Employee employee) {
		employeeDao.save(employee);
		return employee.getPersonId();
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeDao.delete(id);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeDao.getById(id);
	}

	@Override
	public Employee getEmployeeByEmployeeNumber(String employeeNumber) {
		return employeeDao.getEmployeeByEmployeeNumber(employeeNumber);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeDao.getAll();
	}
}
