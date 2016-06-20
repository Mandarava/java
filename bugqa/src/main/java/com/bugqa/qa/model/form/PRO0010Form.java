package com.bugqa.qa.model.form;

import java.io.Serializable;
import java.util.List;

import com.bugqa.qa.model.po.ProjectMaster;

public final class PRO0010Form extends BaseForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<ProjectMaster> queryProject;
	
	public List<ProjectMaster> getQueryProject() {
		return queryProject;
	}
	
	public void setQueryProject(List<ProjectMaster> queryProject) {
		this.queryProject = queryProject;
	}
	
	
}
