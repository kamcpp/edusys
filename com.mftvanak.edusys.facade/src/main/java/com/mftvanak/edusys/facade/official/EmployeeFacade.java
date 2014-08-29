package com.mftvanak.edusys.facade.official;

import java.util.List;

import com.mftvanak.edusys.domain.entity.official.Employee;


public interface EmployeeFacade {

  Long addEmployee (Employee employee);

  void updateEmployee (Employee employee);

  void deleteEmployee (Long id);

  Employee getEmployeeById (Long id);

  Employee getEmployeeByEmployeeNumber (String employeeNumber);

  List < Employee > getEmployees ();

}
