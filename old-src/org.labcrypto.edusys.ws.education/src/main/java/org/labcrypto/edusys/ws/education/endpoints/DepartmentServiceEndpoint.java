package org.labcrypto.edusys.ws.education.endpoints;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.labcrypto.edusys.domain.pg.entity.education.Department;
import org.labcrypto.edusys.domain.pg.entity.education.Institute;
import org.labcrypto.edusys.domain.pg.entity.membership.Token;
import org.labcrypto.edusys.ws.education.schemas.department.AddDepartmentRequest;
import org.labcrypto.edusys.ws.education.schemas.department.AddDepartmentResponse;
import org.labcrypto.edusys.ws.education.schemas.department.DeleteDepartmentRequest;
import org.labcrypto.edusys.ws.education.schemas.department.DeleteDepartmentResponse;
import org.labcrypto.edusys.ws.education.schemas.department.GetDepartmentByIdRequest;
import org.labcrypto.edusys.ws.education.schemas.department.GetDepartmentByIdResponse;
import org.labcrypto.edusys.ws.education.schemas.department.GetDepartmentsRequest;
import org.labcrypto.edusys.ws.education.schemas.department.GetDepartmentsResponse;
import org.labcrypto.edusys.ws.education.schemas.department.UpdateDepartmentRequest;
import org.labcrypto.edusys.ws.education.schemas.department.UpdateDepartmentResponse;
import org.labcrypto.edusys.ws.education.schemas.types.DepartmentType;
import org.labcrypto.edusys.ws.education.services.AuditService;
import org.labcrypto.edusys.ws.education.services.DepartmentService;
import org.labcrypto.edusys.ws.education.services.InstituteService;
import org.labcrypto.edusys.ws.education.services.SecurityService;
import org.labcrypto.edusys.ws.exceptions.ClientInformationNeededException;
import org.labcrypto.edusys.ws.exceptions.DepartmentNotFoundException;
import org.labcrypto.edusys.ws.exceptions.InstituteNotFoundException;
import org.labcrypto.edusys.ws.exceptions.TokenIsNotAuthenticatedException;
import org.labcrypto.edusys.ws.exceptions.UserIsNotActiveException;
import org.labcrypto.edusys.ws.exceptions.UserIsNotAuthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class DepartmentServiceEndpoint {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private InstituteService instituteService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private AuditService auditService;

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(DepartmentServiceEndpoint.class);

	@PayloadRoot(namespace = "http://education.ws.edusys.mftvanak.com/schemas/department", localPart = "AddDepartmentRequest")
	public @ResponsePayload AddDepartmentResponse handleAddDepartmentRequest(
			@RequestPayload AddDepartmentRequest request)
			throws TokenIsNotAuthenticatedException,
			UserIsNotAuthorizedException, UserIsNotActiveException,
			ClientInformationNeededException, InstituteNotFoundException {
		Token token = securityService.authenticateAndAuthorizeToken(request
				.getToken());
		if (request.getClientMacAddress() == null
				|| request.getClientIpAddress() == null
				|| request.getClientComputerName() == null
				|| request.getApplicationName() == null) {
			throw new ClientInformationNeededException();
		}
		if (request.getClientDateTimeYear() >= 0
				&& request.getClientDateTimeMonth() >= 0
				&& request.getClientDateTimeDay() >= 0
				&& request.getClientDateTimeHour() >= 0
				&& request.getClientDateTimeMinute() >= 0
				&& request.getClientDateTimeSecond() >= 0
				&& request.getClientDateTimeMilliSecond() >= 0
				&& !request.getClientMacAddress().isEmpty()
				&& !request.getClientIpAddress().isEmpty()
				&& !request.getClientComputerName().isEmpty()
				&& !request.getApplicationName().isEmpty()) {
			DateTime clientDateTime = new DateTime(
					request.getClientDateTimeYear(),
					request.getClientDateTimeMonth(),
					request.getClientDateTimeDay(),
					request.getClientDateTimeHour(),
					request.getClientDateTimeMinute(),
					request.getClientDateTimeSecond(),
					request.getClientDateTimeMilliSecond(), DateTimeZone.UTC);
			auditService.addAuditLog(token, "AddDepartment",
					"DepartmentService", "0.0.1",
					"Adding department with name '"
							+ request.getDepartment().getPersianName() + "'",
					"", clientDateTime.getMillis(),
					request.getClientMacAddress(),
					request.getClientIpAddress(),
					request.getClientComputerName(),
					request.getApplicationName());
		} else {
			throw new ClientInformationNeededException();
		}
		Institute institute = instituteService.getEntityById(request
				.getDepartment().getInstituteId());
		if (institute == null) {
			throw new InstituteNotFoundException();
		}
		Department department = new Department();
		department.setPersianName(request.getDepartment().getPersianName());
		department.setEnglishName(request.getDepartment().getEnglishName());
		department.setColor(request.getDepartment().getColor());
		department.setShowOrder(request.getDepartment().getShowOrder());
		department.setSeoKeywords(request.getDepartment().getSeoKeywords());
		department.setSeoDescription(request.getDepartment()
				.getSeoDescription());
		department.setInstitute(institute);
		Long id = departmentService.addEntity(department);
		DateTime clientDateTime = new DateTime(request.getClientDateTimeYear(),
				request.getClientDateTimeMonth(),
				request.getClientDateTimeDay(),
				request.getClientDateTimeHour(),
				request.getClientDateTimeMinute(),
				request.getClientDateTimeSecond(),
				request.getClientDateTimeMilliSecond(), DateTimeZone.UTC);
		auditService.addAuditLog(token, "AddDepartment", "DepartmentService",
				"0.0.1", "Department is added with id '"
						+ request.getDepartment().getId() + "'", "",
				clientDateTime.getMillis(), request.getClientMacAddress(),
				request.getClientIpAddress(), request.getClientComputerName(),
				request.getApplicationName());
		AddDepartmentResponse response = new AddDepartmentResponse();
		response.setDepartmentId(id);
		return response;
	}

	@PayloadRoot(namespace = "http://education.ws.edusys.mftvanak.com/schemas/department", localPart = "UpdateDepartmentRequest")
	public @ResponsePayload UpdateDepartmentResponse handleUpdateDepartmentRequest(
			@RequestPayload UpdateDepartmentRequest request)
			throws TokenIsNotAuthenticatedException,
			UserIsNotAuthorizedException, DepartmentNotFoundException,
			UserIsNotActiveException, ClientInformationNeededException {
		Token token = securityService.authenticateAndAuthorizeToken(request
				.getToken());
		if (request.getClientMacAddress() == null
				|| request.getClientIpAddress() == null
				|| request.getClientComputerName() == null
				|| request.getApplicationName() == null) {
			throw new ClientInformationNeededException();
		}
		if (request.getClientDateTimeYear() >= 0
				&& request.getClientDateTimeMonth() >= 0
				&& request.getClientDateTimeDay() >= 0
				&& request.getClientDateTimeHour() >= 0
				&& request.getClientDateTimeMinute() >= 0
				&& request.getClientDateTimeSecond() >= 0
				&& request.getClientDateTimeMilliSecond() >= 0
				&& !request.getClientMacAddress().isEmpty()
				&& !request.getClientIpAddress().isEmpty()
				&& !request.getClientComputerName().isEmpty()
				&& !request.getApplicationName().isEmpty()) {
			DateTime clientDateTime = new DateTime(
					request.getClientDateTimeYear(),
					request.getClientDateTimeMonth(),
					request.getClientDateTimeDay(),
					request.getClientDateTimeHour(),
					request.getClientDateTimeMinute(),
					request.getClientDateTimeSecond(),
					request.getClientDateTimeMilliSecond(), DateTimeZone.UTC);
			auditService.addAuditLog(token, "UpdateDepartment",
					"DepartmentService", "0.0.1",
					"Updating department with id '"
							+ request.getDepartment().getId() + "'", "",
					clientDateTime.getMillis(), request.getClientMacAddress(),
					request.getClientIpAddress(),
					request.getClientComputerName(),
					request.getApplicationName());
		} else {
			throw new ClientInformationNeededException();
		}
		Department department = departmentService.getEntityById(request
				.getDepartment().getId());
		if (department == null) {
			throw new DepartmentNotFoundException();
		}
		department.setPersianName(request.getDepartment().getPersianName());
		department.setEnglishName(request.getDepartment().getEnglishName());
		department.setColor(request.getDepartment().getColor());
		department.setShowOrder(request.getDepartment().getShowOrder());
		department.setSeoKeywords(request.getDepartment().getSeoKeywords());
		department.setSeoDescription(request.getDepartment()
				.getSeoDescription());
		departmentService.updateEntity(department);
		UpdateDepartmentResponse response = new UpdateDepartmentResponse();
		return response;
	}

	@PayloadRoot(namespace = "http://education.ws.edusys.mftvanak.com/schemas/department", localPart = "DeleteDepartmentRequest")
	public @ResponsePayload DeleteDepartmentResponse handleDeleteDepartmentRequest(
			@RequestPayload DeleteDepartmentRequest request)
			throws TokenIsNotAuthenticatedException,
			UserIsNotAuthorizedException, DepartmentNotFoundException,
			UserIsNotActiveException, ClientInformationNeededException {
		Token token = securityService.authenticateAndAuthorizeToken(request
				.getToken());
		if (request.getClientMacAddress() == null
				|| request.getClientIpAddress() == null
				|| request.getClientComputerName() == null
				|| request.getApplicationName() == null) {
			throw new ClientInformationNeededException();
		}
		if (request.getClientDateTimeYear() >= 0
				&& request.getClientDateTimeMonth() >= 0
				&& request.getClientDateTimeDay() >= 0
				&& request.getClientDateTimeHour() >= 0
				&& request.getClientDateTimeMinute() >= 0
				&& request.getClientDateTimeSecond() >= 0
				&& request.getClientDateTimeMilliSecond() >= 0
				&& !request.getClientMacAddress().isEmpty()
				&& !request.getClientIpAddress().isEmpty()
				&& !request.getClientComputerName().isEmpty()
				&& !request.getApplicationName().isEmpty()) {
			DateTime clientDateTime = new DateTime(
					request.getClientDateTimeYear(),
					request.getClientDateTimeMonth(),
					request.getClientDateTimeDay(),
					request.getClientDateTimeHour(),
					request.getClientDateTimeMinute(),
					request.getClientDateTimeSecond(),
					request.getClientDateTimeMilliSecond(), DateTimeZone.UTC);
			auditService.addAuditLog(token, "DeleteDepartment",
					"DepartmentService", "0.0.1",
					"Updating department with id '" + request.getDepartmentId()
							+ "'", "", clientDateTime.getMillis(),
					request.getClientMacAddress(),
					request.getClientIpAddress(),
					request.getClientComputerName(),
					request.getApplicationName());
		} else {
			throw new ClientInformationNeededException();
		}
		Department department = departmentService.getEntityById(request
				.getDepartmentId());
		if (department == null) {
			throw new DepartmentNotFoundException();
		}
		departmentService.deleteEntity(request.getDepartmentId());
		DeleteDepartmentResponse response = new DeleteDepartmentResponse();
		return response;
	}

	@PayloadRoot(namespace = "http://education.ws.edusys.mftvanak.com/schemas/department", localPart = "GetDepartmentByIdRequest")
	public @ResponsePayload GetDepartmentByIdResponse handleGetDepartmentByIdRequest(
			@RequestPayload GetDepartmentByIdRequest request)
			throws TokenIsNotAuthenticatedException,
			UserIsNotAuthorizedException, UserIsNotActiveException,
			ClientInformationNeededException {
		Token token = securityService.authenticateAndAuthorizeToken(request
				.getToken());
		if (request.getClientMacAddress() == null
				|| request.getClientIpAddress() == null
				|| request.getClientComputerName() == null
				|| request.getApplicationName() == null) {
			throw new ClientInformationNeededException();
		}
		if (request.getClientDateTimeYear() >= 0
				&& request.getClientDateTimeMonth() >= 0
				&& request.getClientDateTimeDay() >= 0
				&& request.getClientDateTimeHour() >= 0
				&& request.getClientDateTimeMinute() >= 0
				&& request.getClientDateTimeSecond() >= 0
				&& request.getClientDateTimeMilliSecond() >= 0
				&& !request.getClientMacAddress().isEmpty()
				&& !request.getClientIpAddress().isEmpty()
				&& !request.getClientComputerName().isEmpty()
				&& !request.getApplicationName().isEmpty()) {
			DateTime clientDateTime = new DateTime(
					request.getClientDateTimeYear(),
					request.getClientDateTimeMonth(),
					request.getClientDateTimeDay(),
					request.getClientDateTimeHour(),
					request.getClientDateTimeMinute(),
					request.getClientDateTimeSecond(),
					request.getClientDateTimeMilliSecond(), DateTimeZone.UTC);
			auditService.addAuditLog(token, "GetDepartmentById",
					"DepartmentService", "0.0.1",
					"Getting department with id '" + request.getDepartmentId()
							+ "'", "", clientDateTime.getMillis(),
					request.getClientMacAddress(),
					request.getClientIpAddress(),
					request.getClientComputerName(),
					request.getApplicationName());
		} else {
			throw new ClientInformationNeededException();
		}
		GetDepartmentByIdResponse response = new GetDepartmentByIdResponse();
		Department department = departmentService.getEntityById(request
				.getDepartmentId());
		DepartmentType departmentType = new DepartmentType();
		departmentType.setId(department.getId());
		departmentType.setInstituteId(department.getInstitute().getId());
		departmentType.setPersianName(department.getPersianName());
		departmentType.setEnglishName(department.getEnglishName());
		departmentType.setColor(department.getColor());
		departmentType.setShowOrder(department.getShowOrder());
		departmentType.setSeoKeywords(department.getSeoKeywords());
		departmentType.setSeoDescription(department.getSeoDescription());
		response.setDepartment(departmentType);
		return response;
	}

	@PayloadRoot(namespace = "http://education.ws.edusys.mftvanak.com/schemas/department", localPart = "GetDepartmentsRequest")
	public @ResponsePayload GetDepartmentsResponse handleGetDepartmentsRequest(
			@RequestPayload GetDepartmentsRequest request)
			throws TokenIsNotAuthenticatedException,
			InstituteNotFoundException, UserIsNotAuthorizedException,
			UserIsNotActiveException, ClientInformationNeededException {
		Token token = securityService.authenticateAndAuthorizeToken(request
				.getToken());
		if (request.getClientMacAddress() == null
				|| request.getClientIpAddress() == null
				|| request.getClientComputerName() == null
				|| request.getApplicationName() == null) {
			throw new ClientInformationNeededException();
		}
		if (request.getClientDateTimeYear() >= 0
				&& request.getClientDateTimeMonth() >= 0
				&& request.getClientDateTimeDay() >= 0
				&& request.getClientDateTimeHour() >= 0
				&& request.getClientDateTimeMinute() >= 0
				&& request.getClientDateTimeSecond() >= 0
				&& request.getClientDateTimeMilliSecond() >= 0
				&& !request.getClientMacAddress().isEmpty()
				&& !request.getClientIpAddress().isEmpty()
				&& !request.getClientComputerName().isEmpty()
				&& !request.getApplicationName().isEmpty()) {
			DateTime clientDateTime = new DateTime(
					request.getClientDateTimeYear(),
					request.getClientDateTimeMonth(),
					request.getClientDateTimeDay(),
					request.getClientDateTimeHour(),
					request.getClientDateTimeMinute(),
					request.getClientDateTimeSecond(),
					request.getClientDateTimeMilliSecond(), DateTimeZone.UTC);
			auditService.addAuditLog(token, "GetDepartments",
					"DepartmentService", "0.0.1", "Getting all departments",
					"", clientDateTime.getMillis(),
					request.getClientMacAddress(),
					request.getClientIpAddress(),
					request.getClientComputerName(),
					request.getApplicationName());
		} else {
			throw new ClientInformationNeededException();
		}
		Institute institute = instituteService.getEntityById(request
				.getInstituteId());
		if (institute == null) {
			throw new InstituteNotFoundException();
		}
		GetDepartmentsResponse response = new GetDepartmentsResponse();
		for (Department department : departmentService.getByInstituteId(request
				.getInstituteId())) {
			DepartmentType departmentType = new DepartmentType();
			departmentType.setId(department.getId());
			departmentType.setInstituteId(department.getInstitute().getId());
			departmentType.setPersianName(department.getPersianName());
			departmentType.setEnglishName(department.getEnglishName());
			departmentType.setColor(department.getColor());
			departmentType.setShowOrder(department.getShowOrder());
			departmentType.setSeoKeywords(department.getSeoKeywords());
			departmentType.setSeoDescription(department.getSeoDescription());
			response.getDepartments().add(departmentType);
		}
		return response;
	}
}
