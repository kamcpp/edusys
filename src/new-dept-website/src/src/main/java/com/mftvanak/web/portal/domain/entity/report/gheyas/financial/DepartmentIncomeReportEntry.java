package com.mftvanak.web.portal.domain.entity.report.gheyas.financial;

public class DepartmentIncomeReportEntry {

	private int gheyasId;
	private int income;
	private int abortion;
	private int obtained;
	private int incomeMinusAbortion;
	private int numberOfStudents;
	private String incomeString;
	private String abortionString;
	private String obtainedString;
	private String incomeMinusAbortionString;
	private String name;

	public int getGheyasId() {
		return gheyasId;
	}

	public void setGheyasId(int gheyasId) {
		this.gheyasId = gheyasId;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getAbortion() {
		return abortion;
	}

	public void setAbortion(int abortion) {
		this.abortion = abortion;
	}

	public int getObtained() {
		return obtained;
	}

	public void setObtained(int obtained) {
		this.obtained = obtained;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public String getIncomeString() {
		return incomeString;
	}

	public void setIncomeString(String incomeString) {
		this.incomeString = incomeString;
	}

	public String getAbortionString() {
		return abortionString;
	}

	public void setAbortionString(String abortionString) {
		this.abortionString = abortionString;
	}

	public String getObtainedString() {
		return obtainedString;
	}

	public void setObtainedString(String obtainedString) {
		this.obtainedString = obtainedString;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIncomeMinusAbortion() {
		return incomeMinusAbortion;
	}

	public void setIncomeMinusAbortion(int incomeMinusAbortion) {
		this.incomeMinusAbortion = incomeMinusAbortion;
	}

	public String getIncomeMinusAbortionString() {
		return incomeMinusAbortionString;
	}

	public void setIncomeMinusAbortionString(String incomeMinusAbortionString) {
		this.incomeMinusAbortionString = incomeMinusAbortionString;
	}
}
