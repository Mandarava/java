package com.bugqa.qa.model.dto;

import java.io.Serializable;

public class GRO0040ArgValue extends BaseArgValue implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 项目ID
	 */
	private String projectId;
	
	public String getProjectId(){
		return projectId;
	}
	
	public void setProjectId(String projectId){
		this.projectId  = projectId;
	}
}
