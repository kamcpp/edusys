package com.mftvanak.web.portal.domain.dao.report.gheyas.financial.impl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mftvanak.web.portal.domain.config.GheyasConfiguration;
import com.mftvanak.web.portal.domain.dao.report.gheyas.financial.GheyasReportDao;
import com.mftvanak.web.portal.domain.entity.report.gheyas.financial.DepartmentIncomeReportEntry;
import com.mftvanak.web.portal.domain.entity.report.gheyas.financial.RegisterationDetailsReportEntry;

public class DefaultGheyasReportDao implements GheyasReportDao {

	private Connection connection;
	@Autowired
	private GheyasConfiguration gheyasConfiguration;

	@Override
	public List<DepartmentIncomeReportEntry> getDepartmentIncomeReport(
			String startFarsiDate, String endFarsiDate) {
		try {

			ResultSet rs = getStatement().executeQuery(
					"select * from dbo.CalculateDepartmentIncome('"
							+ startFarsiDate + "', '" + endFarsiDate
							+ "', 0) order by IncomeMinusAbortion DESC");
			List<DepartmentIncomeReportEntry> toReturn = new ArrayList<DepartmentIncomeReportEntry>();
			while (rs.next()) {
				DepartmentIncomeReportEntry entry = new DepartmentIncomeReportEntry();
				entry.setGheyasId(rs.getInt("DepartmentId"));
				entry.setName(rs.getString("DepartmentName"));
				entry.setIncome(rs.getInt("Income"));
				entry.setObtained(rs.getInt("Obtained"));
				entry.setAbortion(rs.getInt("Abortion"));
				entry.setIncomeMinusAbortion(rs.getInt("IncomeMinusAbortion"));
				entry.setIncomeString(rs.getString("IncomeString"));
				entry.setObtainedString(rs.getString("ObtainedString"));
				entry.setAbortionString(rs.getString("AbortionString"));
				entry.setIncomeMinusAbortionString(rs
						.getString("IncomeMinusAbortionString"));
				entry.setNumberOfStudents(rs.getInt("NumberOfStudents"));
				toReturn.add(entry);
			}
			closeConnection();
			return toReturn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private Statement getStatement() throws ClassNotFoundException,
			SQLException {
		if (connection == null) {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(gheyasConfiguration
					.getConnectionUrl());
		}
		return connection.createStatement();
	}

	private void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
		} finally {
			connection = null;
		}
	}

	@Override
	public List<RegisterationDetailsReportEntry> getRegistrationReport(
			String departmentCode, String startFarsiDate, String endFarsiDate) {
		try {

			ResultSet rs = getStatement().executeQuery(
					"select * from dbo.GetDepartmentDetails(" + departmentCode
							+ ", '" + startFarsiDate + "', '" + endFarsiDate
							+ "')");
			List<RegisterationDetailsReportEntry> toReturn = new ArrayList<RegisterationDetailsReportEntry>();
			while (rs.next()) {
				RegisterationDetailsReportEntry entry = new RegisterationDetailsReportEntry();
				entry.setAbortionDate(rs.getString("EnserafDate"));
				entry.setAbortionPayment(rs.getString("MablaghEnseraf"));
				entry.setClassName(rs.getString("ClassName"));
				entry.setDiscount(rs.getString("Discount"));
				entry.setEmergencyPhone(rs.getString("EmergencyPhone"));
				entry.setName(rs.getString("Name"));
				entry.setPaid(rs.getString("Paid"));
				entry.setPayment(rs.getString("Payment"));
				entry.setPaymentDate(rs.getString("PaymentDate"));
				entry.setPhone(rs.getString("Phone"));
				entry.setRegistrationStatus(rs.getString("Status").equals("E") ? "انصراف"
						: "ثبت نام");
				toReturn.add(entry);
			}
			closeConnection();
			return toReturn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
