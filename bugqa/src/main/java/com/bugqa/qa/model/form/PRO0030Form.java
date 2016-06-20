package com.bugqa.qa.model.form;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.bugqa.qa.model.po.CustomerMaster;
import com.bugqa.qa.model.po.GeneralMaster;
import com.bugqa.qa.model.po.ModuleMaster;
import com.bugqa.qa.model.po.ProjectMaster;
import com.bugqa.qa.model.po.ProjectMemberMaster;
import com.bugqa.qa.model.po.UserMaster;

public final class PRO0030Form extends BaseForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * module viewtree信息
	 */
	private List<ModuleMaster> moduleMsg;
	
	/**
	 * 项目信息
	 */
	private List<ProjectMaster> projectList;
	
	/**
	 * 项目成员信息
	 */
	private List<ProjectMemberMaster> projectMemberList;
	
	/**
	 * 页面缓存信息
	 */
	private Map<String, Object> beforeMsgReturn;
	
	/**
	 * 项目经理信息
	 */
	private List<UserMaster> projectManagerMsg;
	
	/**
	 * 
	 */
	private File fileField;
	
	/**
	 * 
	 */
	private Map<String, Object> fileMsg;
	
	/**
	 * 
	 */
	private String projectId;
	
	/**
	 * 项目状态
	 */
	private List<GeneralMaster> proStage;
	
	/**
	 * 得意先信息
	 */
	private List<CustomerMaster> customerMsg;

	public List<ModuleMaster> getModuleMsg() {
		return moduleMsg;
	}
	
	public void setModuleMsg(List<ModuleMaster> moduleMsg) {
		this.moduleMsg = moduleMsg;
	}
	
	
	public List<ProjectMaster> getProjectList() {
		return projectList;
	}
	
	public void setProjectList(List<ProjectMaster> projectList){
		this.projectList = projectList;
	}
	
	public List<ProjectMemberMaster> getProjectMemberList() {
		return projectMemberList;
	}
	
	public void setProjectMemberList(List<ProjectMemberMaster> projectMemberList) {
		this.projectMemberList = projectMemberList;
	}
	
	public Map<String, Object> getBeforeMsgReturn() {
		return beforeMsgReturn;
	}
	
	public void setBeforeMsgReturn(Map<String, Object> beforeMsgReturn){
		this.beforeMsgReturn = beforeMsgReturn;
	}
	
	public List<UserMaster> getProjectManagerMsg() {
		return projectManagerMsg;
	}

	public void setProjectManagerMsg(List<UserMaster> projectManagerMsg) {
		this.projectManagerMsg = projectManagerMsg;
	}
		
	public String getProjectId(){
		return projectId;
	}
	
	public void setProjectId(String projectId){
		this.projectId = projectId;
	}
	
	private String groupId;
	
	public String getGroupId(){
		return groupId;
	}
	
	public void setGroupId(String groupId){
		this.groupId = groupId;
	}
	
	private String groupName;
	
	public String getGroupName(){
		return groupName;
	}
	
	public void setGroupName(String groupName){
		this.groupName = groupName;
	}
	
	private String moduleId;
	
	public String getModuleId(){
		return moduleId;
	}
	
	public void setModuleId(String moduleId){
		this.moduleId = moduleId;
	}
	
	private String moduleName;
	
	public String getModuleName(){
		return moduleName;
	}
	
	public void setModuleName(String moduleName){
		this.moduleName = moduleName;
	}
	 	
	public File getFileField() {
		return fileField;
	}
	
	public void setFileField(File fileField) {
		this.fileField = fileField;
	}
	
	public Map<String, Object> getFileMsg(){
		return fileMsg;
	}
	
	public void setFileMsg (Map<String, Object> fileMsg){
		this.fileMsg = fileMsg;
	}
	
	public List<GeneralMaster> getProStage() {
		return proStage;
	}

	public void setProStage(List<GeneralMaster> proStage) {
		this.proStage = proStage;
	}
	
	public List<CustomerMaster> getCustomerMsg() {
		return customerMsg;
	}

	public void setCustomerMsg(List<CustomerMaster> customerMsg) {
		this.customerMsg = customerMsg;
	}
	
}
