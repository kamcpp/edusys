package com.mftvanak.web.portal.web.controllers;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mftvanak.web.portal.domain.dao.report.gheyas.financial.GheyasReportDao;
import com.mftvanak.web.portal.domain.entity.report.gheyas.financial.DepartmentIncomeReportEntry;
import com.mftvanak.web.portal.domain.entity.report.gheyas.financial.RegisterationDetailsReportEntry;

@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private GheyasReportDao gheyasReportDao;

	@RequestMapping(value = "/dept/{dateDuration}", method = RequestMethod.GET)
	public @ResponseBody List<DepartmentIncomeReportEntry> getDepartmentIncomeReport(
			@PathVariable String dateDuration) {
		String decodedString = StringUtils.newStringUtf8(Base64
				.decodeBase64(dateDuration));
		String[] tokens = decodedString.split(",");
		return gheyasReportDao.getDepartmentIncomeReport(tokens[0], tokens[1]);
	}

	@RequestMapping(value = "/reg/{dateDuration}", method = RequestMethod.GET)
	public @ResponseBody List<RegisterationDetailsReportEntry> getRegistrationReport(
			@PathVariable String dateDuration) {
		String decodedString = StringUtils.newStringUtf8(Base64
				.decodeBase64(dateDuration));
		String[] tokens = decodedString.split(",");
		return gheyasReportDao.getRegistrationReport(tokens[0], tokens[1],
				tokens[2]);
	}
}
