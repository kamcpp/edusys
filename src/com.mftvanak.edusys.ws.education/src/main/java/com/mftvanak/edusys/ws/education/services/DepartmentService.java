package com.mftvanak.edusys.ws.education.services;

import java.util.List;

import com.mftvanak.edusys.domain.entity.education.Department;
import com.mftvanak.edusys.ws.EntityService;


public interface DepartmentService extends EntityService < Department > {

  List < Department > getByInstituteId (Long instituteId);

}
