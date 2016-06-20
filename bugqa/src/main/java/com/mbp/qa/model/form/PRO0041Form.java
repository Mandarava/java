package com.mbp.qa.model.form;

import java.io.Serializable;
import java.util.List;

import com.mbp.qa.model.po.ClassMaster;
import com.mbp.qa.model.po.CustomerMaster;
import com.mbp.qa.model.po.DepartmentMaster;
import com.mbp.qa.model.po.ProjectMemberMaster;
import com.mbp.qa.model.po.UserMaster;

public final class PRO0041Form extends BaseForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 当前用户项目信息
	 */
	private List<ProjectMemberMaster> userProjectMsg;
	
	private List<CustomerMaster> customerMsg;

	private List<DepartmentMaster> departmentMsg;

	private List<ClassMaster> classMsg;

	private List<UserMaster> userMsgSelect;

	private List<UserMaster> selectMsg;

	private List<UserMaster> userCustomerCode;

	private String user;

	private String userId;

	private String projectId;
	
	public List<ProjectMemberMaster> getUserProjectMag(){
		return userProjectMsg;
	}

	public void setUserProjectMsg(List<ProjectMemberMaster> userProjectMsg){
		this.userProjectMsg = userProjectMsg;
	}
	
	public List<CustomerMaster> getCustomerMsg() {
		return customerMsg;
	}

	public void setCustomerMsg(List<CustomerMaster> customerMsg) {
		this.customerMsg = customerMsg;
	}

	public List<DepartmentMaster> getDepartmentMsg() {
		return departmentMsg;
	}

	public void setDepartmentMsg(List<DepartmentMaster> departmentMsg) {
		this.departmentMsg = departmentMsg;
	}

	public List<ClassMaster> getClassMsg() {
		return classMsg;
	}

	public void setClassMsg(List<ClassMaster> classMsg) {
		this.classMsg = classMsg;
	}

	public List<UserMaster> getUserMsgSelect() {
		return userMsgSelect;
	}

	public void setUserMsgSelect(List<UserMaster> userMsgSelect) {
		this.userMsgSelect = userMsgSelect;
	}

	public List<UserMaster> getSelectMsg() {
		return selectMsg;
	}

	public void setSelectMsg(List<UserMaster> selectMsg) {
		this.selectMsg = selectMsg;
	}

	public List<UserMaster> getUserCustomerCode() {
		return userCustomerCode;
	}

	public void setUserCustomerCode(List<UserMaster> userCustomerCode) {
		this.userCustomerCode = userCustomerCode;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

}
