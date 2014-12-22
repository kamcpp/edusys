package org.labcrypto.edusys.domain.dao.gheyas.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.labcrypto.edusys.domain.beans.gheyas.GheyasClass;
import org.labcrypto.edusys.domain.beans.gheyas.GheyasClassGroup;
import org.labcrypto.edusys.domain.beans.gheyas.GheyasDebtor;
import org.labcrypto.edusys.domain.beans.gheyas.GheyasStudent;
import org.labcrypto.edusys.domain.beans.gheyas.GheyasTerm;
import org.labcrypto.edusys.domain.dao.gheyas.GheyasConfiguration;
import org.labcrypto.edusys.domain.dao.gheyas.GheyasDao;
import org.springframework.beans.factory.annotation.Qualifier;

public class GheyasDaoImpl implements GheyasDao {

	@Resource
	@Qualifier("gheyasConfigurations")
	private Map<Integer, GheyasConfiguration> gheyasConfigurations;

	@Override
	public List<GheyasTerm> getTerms(int instituteId) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager
					.getConnection(gheyasConfigurations.get(instituteId)
							.getConnectionUrl());
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("exec GetTerms");
			List<GheyasTerm> toReturn = new ArrayList<GheyasTerm>();
			while (rs.next()) {
				GheyasTerm gheyasTerm = new GheyasTerm();
				gheyasTerm.setInstituteId(instituteId);
				gheyasTerm.setCode(rs.getString("Code"));
				gheyasTerm.setName(rs.getNString("Name"));
				toReturn.add(gheyasTerm);
			}
			connection.close();
			return toReturn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<GheyasClassGroup> getGroups(int instituteId) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager
					.getConnection(gheyasConfigurations.get(instituteId)
							.getConnectionUrl());
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("exec GetGroups");
			List<GheyasClassGroup> toReturn = new ArrayList<GheyasClassGroup>();
			while (rs.next()) {
				GheyasClassGroup gheyasClassGroup = new GheyasClassGroup();
				gheyasClassGroup.setInstituteId(instituteId);
				gheyasClassGroup.setCode(rs.getString("Code"));
				gheyasClassGroup.setName(rs.getNString("Name"));
				gheyasClassGroup.setDescription(rs.getNString("Tozihat"));
				toReturn.add(gheyasClassGroup);
			}
			connection.close();
			return toReturn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<GheyasClass> getClasses(int instituteId, String groupCodes,
			String termCodes, String classNamePattern, boolean showAll,
			String className, long classCode) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager
					.getConnection(gheyasConfigurations.get(instituteId)
							.getConnectionUrl());
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("exec GetClasses '"
					+ groupCodes + "', '" + termCodes + "', "
					+ classNamePattern + ", " + (showAll ? 1 : 0) + ", '"
					+ className + "', " + classCode);
			List<GheyasClass> toReturn = new ArrayList<GheyasClass>();
			while (rs.next()) {
				GheyasClass gheyasClass = new GheyasClass();
				gheyasClass.setInstituteId(instituteId);
				gheyasClass.setCode(rs.getString("Code"));
				gheyasClass.setActiveDays(rs.getNString("Active_Days"));
				gheyasClass.setName(rs.getNString("Name"));
				gheyasClass.setTeacherTarafHesabCode(rs
						.getString("TeacherTarafHesabCode"));
				gheyasClass.setTeacherName(rs.getNString("TeacherName"));
				gheyasClass.setTeacherFamily(rs.getNString("TeacherFamily"));
				gheyasClass.setTeacherPhone1(rs.getNString("TeacherPhone1"));
				gheyasClass.setTeacherPhone2(rs.getNString("TeacherPhone2"));
				gheyasClass.setTeacherEmail(rs.getNString("TeacherEmail"));
				gheyasClass.setDescription(rs.getNString("Tozihat"));
				gheyasClass.setStartDate(rs.getNString("StartDate"));
				gheyasClass.setEndDate(rs.getNString("EndDate"));
				gheyasClass.setNumberOfStudents(Integer.parseInt(rs
						.getString("NumberOfStudents")));
				toReturn.add(gheyasClass);
			}
			connection.close();
			return toReturn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<GheyasStudent> getStudents(int instituteId, String classCode) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager
					.getConnection(gheyasConfigurations.get(instituteId)
							.getConnectionUrl());
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("exec GetStudents "
					+ classCode);
			List<GheyasStudent> toReturn = new ArrayList<GheyasStudent>();
			while (rs.next()) {
				GheyasStudent gheyasStudent = new GheyasStudent();
				gheyasStudent.setInstituteId(instituteId);
				gheyasStudent.setKaramuzCode(rs.getString("KaramuzCode"));
				gheyasStudent.setTarafHesabCode(rs.getString("TarafHesabCode"));
				gheyasStudent.setName(rs.getNString("Name"));
				gheyasStudent.setFamily(rs.getNString("Family"));
				gheyasStudent.setAddress(rs.getNString("Address"));
				gheyasStudent.setBirthDate(rs.getString("BirthDate"));
				gheyasStudent.setDiscount(rs.getString("Discount"));
				gheyasStudent.setEmail(rs.getString("Email"));
				gheyasStudent.setPhone(rs.getString("Phone"));
				gheyasStudent.setEmergencyPhone(rs.getString("EmergencyPhone"));
				gheyasStudent.setPayment(rs.getString("Payment"));
				gheyasStudent.setPaid(rs.getString("Paid"));
				gheyasStudent.setPaymentDate(rs.getString("PaymentDate"));
				gheyasStudent.setDescription(rs.getNString("Description"));
				gheyasStudent.setReshteh(rs.getNString("Reshteh"));
				gheyasStudent.setDaneshgah(rs.getNString("Daneshgah"));
				gheyasStudent.setClassName(rs.getNString("ClassName"));
				gheyasStudent.setClassCode(rs.getString("ClassCode"));
				gheyasStudent.setState(rs.getString("State"));
				toReturn.add(gheyasStudent);
			}
			connection.close();
			return toReturn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<GheyasStudent> searchStudents(int instituteId, String name,
			String family) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager
					.getConnection(gheyasConfigurations.get(instituteId)
							.getConnectionUrl());
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("exec SearchStudents N'%"
					+ name + "%', N'%" + family + "%'");
			List<GheyasStudent> toReturn = new ArrayList<GheyasStudent>();
			while (rs.next()) {
				GheyasStudent gheyasStudent = new GheyasStudent();
				gheyasStudent.setInstituteId(instituteId);
				gheyasStudent.setKaramuzCode(rs.getString("KaramuzCode"));
				gheyasStudent.setTarafHesabCode(rs.getString("TarafHesabCode"));
				gheyasStudent.setName(rs.getNString("Name"));
				gheyasStudent.setFamily(rs.getNString("Family"));
				gheyasStudent.setAddress(rs.getNString("Address"));
				gheyasStudent.setBirthDate(rs.getString("BirthDate"));
				gheyasStudent.setDiscount(rs.getString("Discount"));
				gheyasStudent.setEmail(rs.getString("Email"));
				gheyasStudent.setPhone(rs.getString("Phone"));
				gheyasStudent.setEmergencyPhone(rs.getString("EmergencyPhone"));
				gheyasStudent.setPayment(rs.getString("Payment"));
				gheyasStudent.setPaid(rs.getString("Paid"));
				gheyasStudent.setPaymentDate(rs.getString("PaymentDate"));
				gheyasStudent.setDescription(rs.getNString("Description"));
				gheyasStudent.setReshteh(rs.getNString("Reshteh"));
				gheyasStudent.setDaneshgah(rs.getNString("Daneshgah"));
				gheyasStudent.setClassName(rs.getNString("ClassName"));
				gheyasStudent.setClassCode(rs.getString("ClassCode"));
				gheyasStudent.setState(rs.getString("State"));
				toReturn.add(gheyasStudent);
			}
			connection.close();
			return toReturn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<GheyasDebtor> getDebtors(int instituteId) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager
					.getConnection(gheyasConfigurations.get(instituteId)
							.getConnectionUrl());
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("exec GetDebtors");
			List<GheyasDebtor> toReturn = new ArrayList<GheyasDebtor>();
			while (rs.next()) {
				GheyasDebtor gheyasDebtor = new GheyasDebtor();
				gheyasDebtor.setInstituteId(instituteId);
				gheyasDebtor.setCode(rs.getString("Code"));
				gheyasDebtor.setName(rs.getNString("Name"));
				gheyasDebtor.setFamily(rs.getNString("Family"));
				gheyasDebtor.setAddress(rs.getNString("Address"));
				gheyasDebtor.setEmail(rs.getString("Email"));
				gheyasDebtor.setPhone1(rs.getString("Phone1"));
				gheyasDebtor.setPhone2(rs.getString("Phone2"));
				gheyasDebtor.setShouldPay(rs.getString("ShouldPay"));
				gheyasDebtor.setPaid(rs.getString("Paid"));
				gheyasDebtor.setDiscount(rs.getString("Discount"));
				gheyasDebtor.setDebt(rs.getString("Debt"));
				toReturn.add(gheyasDebtor);
			}
			connection.close();
			return toReturn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateStudentDaneshgahField(int instituteId,
			String karamuzCode, String daneshgahFieldNewValue) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager
					.getConnection(gheyasConfigurations.get(instituteId)
							.getConnectionUrl());
			Statement statement = connection.createStatement();
			statement.execute("exec UpdateStudentDaneshgahValue " + karamuzCode
					+ ", N'" + daneshgahFieldNewValue + "'");
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<GheyasClass> getCommonClasses(String groupCodes,
			String termCodes) {
		List<GheyasClass> toReturn = new ArrayList<GheyasClass>();
		toReturn.addAll(getCommonClasses(1, groupCodes, termCodes));
		toReturn.addAll(getCommonClasses(2, groupCodes, termCodes));
		return toReturn;
	}

	public List<GheyasClass> getCommonClasses(int instituteId,
			String groupCodes, String termCodes) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager
					.getConnection(gheyasConfigurations.get(1)
							.getConnectionUrl());
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("exec GetCommonClasses '"
					+ groupCodes + "', '" + termCodes + "'");
			List<GheyasClass> toReturn = new ArrayList<GheyasClass>();
			while (rs.next()) {
				GheyasClass gheyasClass = new GheyasClass();
				gheyasClass.setInstituteId(1);
				gheyasClass.setCode(rs.getString("Code"));
				gheyasClass.setActiveDays(rs.getNString("Active_Days"));
				gheyasClass.setName(rs.getNString("Name"));
				gheyasClass.setTeacherTarafHesabCode(rs
						.getString("TeacherTarafHesabCode"));
				gheyasClass.setTeacherName(rs.getNString("TeacherName"));
				gheyasClass.setTeacherFamily(rs.getNString("TeacherFamily"));
				gheyasClass.setTeacherPhone1(rs.getNString("TeacherPhone1"));
				gheyasClass.setTeacherPhone2(rs.getNString("TeacherPhone2"));
				gheyasClass.setTeacherEmail(rs.getNString("TeacherEmail"));
				gheyasClass.setDescription(rs.getNString("Tozihat"));
				gheyasClass.setStartDate(rs.getNString("StartDate"));
				gheyasClass.setEndDate(rs.getNString("EndDate"));
				gheyasClass.setNumberOfStudents(Integer.parseInt(rs
						.getString("NumberOfStudents")));
				toReturn.add(gheyasClass);
			}
			connection.close();
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
