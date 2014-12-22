package com.mftvanak.edusys.ws.phonebook.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.official.Employee;
import com.mftvanak.edusys.facade.official.EmployeeFacade;
import com.mftvanak.edusys.ws.phonebook.services.OfficialService;


public class FacadeOfficialService implements OfficialService {

  @Autowired
  private EmployeeFacade employeeFacade;

  @Override
  public Employee getEmployeeById (Long employeeId) {
    return employeeFacade.getEmployeeById (employeeId);
  }
}
