package com.mftvanak.edusys.ws.portal.services;

import java.util.List;

import com.mftvanak.edusys.domain.entity.education.Department;

public interface PortalService {

	Long getDefaultInstituteId();

	List<Department> getDepartmentsByInstituteId(Long instituteId);
}
