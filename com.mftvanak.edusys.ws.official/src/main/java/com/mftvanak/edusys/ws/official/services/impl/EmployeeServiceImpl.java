package com.mftvanak.edusys.ws.official.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.official.Employee;
import com.mftvanak.edusys.facade.official.EmployeeFacade;
import com.mftvanak.edusys.ws.official.services.EmployeeService;


public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeFacade employeeFacade;

  @Override
  public Long addEmployee (Employee employee) {
    return employeeFacade.addEmployee (employee);
  }

  @Override
  public void updateEmployee (Employee employee) {
    employeeFacade.updateEmployee (employee);
  }

  @Override
  public void deleteEmployee (Long id) {
    employeeFacade.deleteEmployee (id);
  }

  @Override
  public Employee getEmployeeById (Long id) {
    return employeeFacade.getEmployeeById (id);
  }

  @Override
  public Employee getEmployeeByEmployeeNumber (String employeeNumber) {
    return employeeFacade.getEmployeeByEmployeeNumber (employeeNumber);
  }

  @Override
  public List < Employee > getEmployees () {
    return employeeFacade.getEmployees ();
  }

  @Override
  public boolean employeeExistsWithEmployeeNumber (String employeeNumber) {
    return employeeFacade.getEmployeeByEmployeeNumber (employeeNumber) != null;
  }
}
