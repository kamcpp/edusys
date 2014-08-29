package com.mftvanak.web.portal.domain.dao.report.gheyas.financial.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mftvanak.web.portal.domain.dao.report.gheyas.financial.GheyasReportDao;
import com.mftvanak.web.portal.domain.entity.report.gheyas.financial.DepartmentIncomeReportEntry;
import com.mftvanak.web.portal.domain.entity.report.gheyas.financial.RegisterationDetailsReportEntry;

public class FakeGheyasReportDao implements GheyasReportDao {

	@Override
	public List<DepartmentIncomeReportEntry> getDepartmentIncomeReport(
			String startFarsiDate, String endFarsiDate) {
		List<DepartmentIncomeReportEntry> fakeEntries = new ArrayList<DepartmentIncomeReportEntry>();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 1; i <= 8; i++) {
			DepartmentIncomeReportEntry fakeEntry = new DepartmentIncomeReportEntry();
			fakeEntry.setAbortion(1500000);
			fakeEntry.setGheyasId(53);
			fakeEntry.setName("دپارتمان" + i + "ام");
			fakeEntry.setIncome(35000000);
			fakeEntry.setIncomeString("35,000,000");
			fakeEntry.setObtained(25000000);
			fakeEntry.setObtainedString("25,000,000");
			fakeEntry.setAbortion(1300000);
			fakeEntry.setAbortionString("1,300,000");
			fakeEntry.setIncomeMinusAbortion(56789000);
			fakeEntry.setIncomeMinusAbortionString("56,789,000");
			fakeEntry.setNumberOfStudents(10 + new Random().nextInt(30) + 20);
			fakeEntries.add(fakeEntry);
		}

		return fakeEntries;
	}

	@Override
	public List<RegisterationDetailsReportEntry> getRegistrationReport(
			String departmentCode, String startFarsiDate, String endFarsiDate) {
		List<RegisterationDetailsReportEntry> fakeEntries = new ArrayList<RegisterationDetailsReportEntry>();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 1; i <= 50; i++) {
			RegisterationDetailsReportEntry fakeEntry = new RegisterationDetailsReportEntry();
			fakeEntry.setAbortionDate("93/06/23");
			fakeEntry.setAbortionPayment("4,500,000");
			fakeEntry.setClassName(i % 3 == 0 ? "Java Fundamentals"
					: "سی پلاس پلاس مقدماتی و پیشرفته در قالب پکیج");
			fakeEntry.setDiscount("1,200,000");
			fakeEntry.setEmergencyPhone("22334455");
			fakeEntry.setName("کامران امینی" + i);
			fakeEntry.setPaid("6,000,000");
			fakeEntry.setPayment("5,000,000");
			fakeEntry.setPaymentDate("93/05/" + ((i % 31) + 1));
			fakeEntry.setPhone("22556677");
			fakeEntry
					.setRegistrationStatus(i % 6 == 0 ? "انصراف"
							: "ثبت نام");
			fakeEntries.add(fakeEntry);
		}
		return fakeEntries;
	}
}
