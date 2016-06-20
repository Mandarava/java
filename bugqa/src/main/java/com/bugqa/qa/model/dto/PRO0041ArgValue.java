package com.bugqa.qa.model.dto;

import java.io.Serializable;

public class PRO0041ArgValue extends BaseArgValue implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 项目ID
	 */
	private String projectId;
	
	/**
	 * 得意先code
	 */
	private String customerCode;
	
	
	/**
	 * 课ID
	 */
	private String departmentId;
	
	
	/**
	 * 部门ID
	 */
	private String classId;
	
	
	/**
	 * 用户信息
	 */
	private String users;
	
	
	public String getProjectId(){
		return projectId;
	}
	
	public void setProjectId(String projectId){
		this.projectId  = projectId;
	}
	
	public String getCustomerCode(){
		return customerCode;
	}
	
	public void setCustomerCode(String customerCode){
		this.customerCode  = customerCode;
	}
	
	public String getDepartmentId(){
		return departmentId;
	}
	
	public void setDepartmentId(String departmentId){
		this.departmentId  = departmentId;
	}
	
	public String getClassId(){
		return classId;
	}
	
	public void setClassId(String classId){
		this.classId  = classId;
	}
	
	public String getUsers(){
		return users;
	}
	
	public void setUsers(String users){
		this.users  = users;
	}
	
	
}
