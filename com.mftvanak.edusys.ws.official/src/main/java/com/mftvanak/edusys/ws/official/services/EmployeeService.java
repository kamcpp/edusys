package com.mftvanak.edusys.ws.official.services;

import java.util.List;

import com.mftvanak.edusys.domain.entity.official.Employee;


public interface EmployeeService {

  Long addEmployee (Employee employee);

  void updateEmployee (Employee employee);

  void deleteEmployee (Long id);

  Employee getEmployeeById (Long id);

  Employee getEmployeeByEmployeeNumber (String employeeNumber);

  List < Employee > getEmployees ();

  boolean employeeExistsWithEmployeeNumber (String employeeNumber);

}
