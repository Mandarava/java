package com.mbp.qa.model.form;

import java.io.Serializable;
import java.util.List;

import com.mbp.qa.model.po.ClassMaster;
import com.mbp.qa.model.po.CustomerMaster;
import com.mbp.qa.model.po.DepartmentMaster;
import com.mbp.qa.model.po.GeneralMaster;
import com.mbp.qa.model.po.UserMaster;

public final class USE0031Form extends BaseForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * 标志
	 */
	private boolean flag;
	
	/*
	 * 用户ID
	 */
	private String userId;

	/*
	 * 代码
	 */
	private String code;

	/*
	 * 用户信息
	 */
	private List<UserMaster> userMsg;

	/*
	 * 用户权限
	 */
	private List<GeneralMaster> userPrevlList;

	/*
	 * 得意先信息
	 */
	private List<CustomerMaster> customerMsg;

	/*
	 * 部门信息
	 */
	private List<DepartmentMaster> departmentMsg;

	/*
	 * 课信息
	 */
	private List<ClassMaster> classMsg;


	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<UserMaster> getUserMsg() {
		return userMsg;
	}

	public void setUserMsg(List<UserMaster> userMsg) {
		this.userMsg = userMsg;
	}


	public List<GeneralMaster> getUserPrevlList() {
		return userPrevlList;
	}

	public void setUserPrevlList(List<GeneralMaster> userPrevlList) {
		this.userPrevlList = userPrevlList;
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

}
