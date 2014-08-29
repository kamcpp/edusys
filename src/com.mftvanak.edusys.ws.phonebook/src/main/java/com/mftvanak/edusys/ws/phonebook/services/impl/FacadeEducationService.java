package com.mftvanak.edusys.ws.phonebook.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.education.Department;
import com.mftvanak.edusys.facade.education.DepartmentFacade;
import com.mftvanak.edusys.ws.phonebook.services.EducationService;


public class FacadeEducationService implements EducationService {

  @Autowired
  private DepartmentFacade departmentFacade;

  @Override
  public Department getDepartmentById (Long departmentId) {
    return departmentFacade.getDepartmentById (departmentId);
  }
}
