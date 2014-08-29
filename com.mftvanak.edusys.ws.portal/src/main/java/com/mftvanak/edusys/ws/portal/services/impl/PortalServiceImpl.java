package com.mftvanak.edusys.ws.portal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.edusys.domain.entity.education.Department;
import com.mftvanak.edusys.facade.education.DepartmentFacade;
import com.mftvanak.edusys.ws.portal.services.PortalService;

public class PortalServiceImpl implements PortalService {

	@Autowired
	private DepartmentFacade departmentFacade;

	private Long defaultInstituteId;

	@Override
	public Long getDefaultInstituteId() {
		return defaultInstituteId;
	}

	public void setDefaultInstituteId(Long defaultInstituteId) {
		this.defaultInstituteId = defaultInstituteId;
	}

	@Override
	public List<Department> getDepartmentsByInstituteId(Long instituteId) {
		return departmentFacade.getDepartmentsByInstituteId(instituteId);
	}
}
