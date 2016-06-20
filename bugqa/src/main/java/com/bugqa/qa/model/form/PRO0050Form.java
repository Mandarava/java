package com.bugqa.qa.model.form;

import java.io.Serializable;
import java.util.List;

import com.bugqa.qa.model.po.ClassMaster;
import com.bugqa.qa.model.po.CustomerMaster;
import com.bugqa.qa.model.po.DepartmentMaster;
import com.bugqa.qa.model.po.GeneralMaster;
import com.bugqa.qa.model.po.UserMaster;

public final class PRO0050Form extends BaseForm implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<CustomerMaster> customerMsg;

	private List<DepartmentMaster> departmentMsg;

	private List<ClassMaster> classMsg;

	private List<GeneralMaster> workTypeMsg;

	private List<UserMaster> listUserMsg;

	private List<UserMaster> selectListMsg;
	
	private List<UserMaster> userCustomerCode;

	private String user;

	private String projectId;

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

	public List<GeneralMaster> getWorkTypeMsg() {
		return workTypeMsg;
	}

	public void setWorkTypeMsg(List<GeneralMaster> workTypeMsg) {
		this.workTypeMsg = workTypeMsg;
	}

	public List<UserMaster> getListUserMsg() {
		return listUserMsg;
	}

	public void setListUserMsg(List<UserMaster> listUserMsg) {
		this.listUserMsg = listUserMsg;
	}

	public List<UserMaster> getSelectListMsg() {
		return selectListMsg;
	}

	public void setSelectListMsg(List<UserMaster> selectListMsg) {
		this.selectListMsg = selectListMsg;
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

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

}
