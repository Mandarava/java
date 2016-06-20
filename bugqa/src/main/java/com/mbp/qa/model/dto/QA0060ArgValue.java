package com.mbp.qa.model.dto;

import java.io.Serializable;

public class QA0060ArgValue extends BaseArgValue implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 页面区分flag
	 */
	private String flg;

	/**
	 * 项目ID
	 */
	private String projectId;

	public String getFlg() {
		return flg;
	}

	public void setFlg(String flg) {
		this.flg = flg;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

}
