package com.bugqa.qa.model.dto;

import java.io.Serializable;

public class QA0030ArgValue extends BaseArgValue implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * QA番号
	 */
	private String qaNo;

	/**
	 * 项目ID
	 */
	private String projectId;

	public String getQaNo() {
		return qaNo;
	}

	public void setQaNo(String qaNo) {
		this.qaNo = qaNo;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

}
