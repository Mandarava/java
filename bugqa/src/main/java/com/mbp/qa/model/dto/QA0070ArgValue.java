package com.mbp.qa.model.dto;

import java.io.Serializable;

public class QA0070ArgValue extends BaseArgValue implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 项目ID
	 */
	private String projectId;

	/**
	 * QA0060
	 */
	private QA0060ArgValue qa0060Arg;

	/**
	 * QA0050
	 */
	private QA0050ArgValue qa0050Arg;

	/**
	 * excel导出页面区分
	 */
	private String pageDiff;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getPageDiff() {
		return pageDiff;
	}

	public void setPageDiff(String pageDiff) {
		this.pageDiff = pageDiff;
	}

	public QA0060ArgValue getQa0060Arg() {
		return qa0060Arg;
	}

	public void setQa0060Arg(QA0060ArgValue qa0060Arg) {
		this.qa0060Arg = qa0060Arg;
	}

	public QA0050ArgValue getQa0050Arg() {
		return qa0050Arg;
	}

	public void setQa0050Arg(QA0050ArgValue qa0050Arg) {
		this.qa0050Arg = qa0050Arg;
	}

}
