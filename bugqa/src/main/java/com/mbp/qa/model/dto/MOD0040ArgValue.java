package com.mbp.qa.model.dto;

import java.io.Serializable;

public class MOD0040ArgValue extends BaseArgValue implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 组ID
	 */
	private String groupId;
	
	/**
	 * 项目ID
	 */
	private String projectId;
	
	public String getGroupId(){
		return groupId;
	}
	
	public void setGroupId(String groupId){
		this.groupId  = groupId;
	}
	
	
	public String getProjectId(){
		return projectId;
	}
	
	public void setProjectId(String projectId){
		this.projectId  = projectId;
	}
	

}
