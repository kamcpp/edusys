package com.mftvanak.edusys.ws.portal.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mftvanak.edusys.domain.entity.education.Department;
import com.mftvanak.edusys.ws.exceptions.InstituteNotFoundException;
import com.mftvanak.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import com.mftvanak.edusys.ws.portal.schemas.DepartmentType;
import com.mftvanak.edusys.ws.portal.schemas.GetDefaultInstituteIdRequest;
import com.mftvanak.edusys.ws.portal.schemas.GetDefaultInstituteIdResponse;
import com.mftvanak.edusys.ws.portal.schemas.GetDepartmentsRequest;
import com.mftvanak.edusys.ws.portal.schemas.GetDepartmentsResponse;
import com.mftvanak.edusys.ws.portal.services.PortalService;

@Endpoint
public class PortalServiceEndpoint {

	@Autowired
	private PortalService portalService;

	@PayloadRoot(namespace = "http://portal.ws.edusys.mftvanak.com/schemas", localPart = "GetDefaultInstituteIdRequest")
	public @ResponsePayload
	GetDefaultInstituteIdResponse handleGetDefaultInstituteIdRequest(
			@RequestPayload GetDefaultInstituteIdRequest request) {
		GetDefaultInstituteIdResponse response = new GetDefaultInstituteIdResponse();
		response.setInstituteId(portalService.getDefaultInstituteId());
		return response;
	}

	@PayloadRoot(namespace = "http://portal.ws.edusys.mftvanak.com/schemas", localPart = "GetDepartmentsRequest")
	public @ResponsePayload
	GetDepartmentsResponse handleGetDepartmentsRequest(
			@RequestPayload GetDepartmentsRequest request)
			throws TokenIsNotAuthenticatedException, InstituteNotFoundException {
		if (request.getInstituteId() != portalService.getDefaultInstituteId()) {
			throw new InstituteNotFoundException();
		}
		GetDepartmentsResponse response = new GetDepartmentsResponse();
		for (Department department : portalService
				.getDepartmentsByInstituteId(request.getInstituteId())) {
			DepartmentType departmentType = new DepartmentType();
			departmentType.setId(department.getId());
			departmentType.setPersianName(department.getPersianName());
			departmentType.setEnglishName(department.getEnglishName());
			departmentType.setColor(department.getColor());
			departmentType.setSeoKeywords(department.getSeoKeywords());
			departmentType.setSeoDescription(department.getSeoDescription());
			response.getDepartments().add(departmentType);
		}
		return response;
	}
}
