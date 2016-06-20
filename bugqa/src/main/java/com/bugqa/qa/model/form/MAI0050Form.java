package com.bugqa.qa.model.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bugqa.qa.model.po.ProjectMaster;

/**
 * 項目によって节点
 * 
 * @author zt c.
 *
 */
public final class MAI0050Form extends BaseForm implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 項目によって节点項目
	 */
	private List<ProjectMaster> project = new ArrayList<>();

	public List<ProjectMaster> getProject() {
		return project;
	}

	public void setProject(List<ProjectMaster> project) {
		this.project = project;
	}

}
