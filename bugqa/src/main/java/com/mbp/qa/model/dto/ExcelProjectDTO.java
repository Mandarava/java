package com.mbp.qa.model.dto;

import java.io.Serializable;

public final class ExcelProjectDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 系统名
	 */
	private String projectName;

	/**
	 * 开始日
	 */
	private String startDate;

	/**
	 * 结束日
	 */
	private String endDate;

	/**
	 * 発信元
	 */
	private String customerNameSumIn;

	/**
	 * 発信先
	 */
	private String customerNameSumOut;

	public String getCustomerNameSumIn() {
		return customerNameSumIn;
	}

	public void setCustomerNameSumIn(String customerNameSumIn) {
		this.customerNameSumIn = customerNameSumIn;
	}

	public String getCustomerNameSumOut() {
		return customerNameSumOut;
	}

	public void setCustomerNameSumOut(String customerNameSumOut) {
		this.customerNameSumOut = customerNameSumOut;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
