package com.mftvanak.edusys.ws.phonebook.services;

import com.mftvanak.edusys.domain.entity.official.Employee;


public interface OfficialService {

  Employee getEmployeeById (Long employeeId);

}
