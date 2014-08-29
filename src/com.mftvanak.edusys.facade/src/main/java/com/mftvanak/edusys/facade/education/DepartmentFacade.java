package com.mftvanak.edusys.facade.education;

import java.util.List;

import com.mftvanak.edusys.domain.entity.education.Department;
import com.mftvanak.edusys.facade.EntityFacade;


public interface DepartmentFacade extends EntityFacade < Department > {

  List < Department > getByInstituteId (Long institudeId);
}
