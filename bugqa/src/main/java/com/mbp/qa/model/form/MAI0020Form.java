package com.mbp.qa.model.form;

import java.io.Serializable;

public class MAI0020Form extends BaseForm implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 固定检索页面跳转区分flg
	 */
	private String flg;

	/**
	 * 项目ID
	 */
	private String projectId;

	/**
	 * QA番号
	 */
	private String qaNo;

	/**
	 * 系统名
	 */
	private String projectName;

	/**
	 * 履历连番
	 */
	private String serialNum;

	private String bugNo;

	public String getBugNo() {
		return bugNo;
	}

	public void setBugNo(String bugNo) {
		this.bugNo = bugNo;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getQaNo() {
		return qaNo;
	}

	public void setQaNo(String qaNo) {
		this.qaNo = qaNo;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getFlg() {
		return flg;
	}

	public void setFlg(String flg) {
		this.flg = flg;
	}

}
