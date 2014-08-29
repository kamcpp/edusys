package com.mftvanak.edusys.facade.official.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.dao.official.EmployeeDao;
import com.mftvanak.edusys.domain.entity.official.Employee;
import com.mftvanak.edusys.facade.official.EmployeeFacade;


public class EmployeeFacadeImpl implements EmployeeFacade {

  @Autowired
  private EmployeeDao employeeDao;

  @Override
  public Long addEmployee (Employee employee) {
    employeeDao.save (employee);
    return employee.getPersonId ();
  }

  @Override
  public void updateEmployee (Employee employee) {
    employeeDao.save (employee);
  }

  @Override
  public void deleteEmployee (Long id) {
    employeeDao.delete (id);
  }

  @Override
  public Employee getEmployeeById (Long id) {
    return employeeDao.getById (id);
  }

  @Override
  public Employee getEmployeeByEmployeeNumber (String employeeNumber) {
    return employeeDao.getEmployeeByEmployeeNumber (employeeNumber);
  }

  @Override
  public List < Employee > getEmployees () {
    return employeeDao.getAll ();
  }
}
