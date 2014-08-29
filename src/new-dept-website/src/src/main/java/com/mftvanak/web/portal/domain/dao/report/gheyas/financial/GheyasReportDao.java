package com.mftvanak.web.portal.domain.dao.report.gheyas.financial;

import java.util.List;

import com.mftvanak.web.portal.domain.entity.report.gheyas.financial.DepartmentIncomeReportEntry;
import com.mftvanak.web.portal.domain.entity.report.gheyas.financial.RegisterationDetailsReportEntry;

public interface GheyasReportDao {

	List<DepartmentIncomeReportEntry> getDepartmentIncomeReport(
			String startFarsiDate, String endFarsiDate);

	List<RegisterationDetailsReportEntry> getRegistrationReport(
			String departmentCode, String startFarsiDate, String endFarsiDate);
}
