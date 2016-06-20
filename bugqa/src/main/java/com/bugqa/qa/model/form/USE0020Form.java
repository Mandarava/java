package com.bugqa.qa.model.form;

import java.io.Serializable;
import java.util.List;

import com.bugqa.qa.model.po.ClassMaster;
import com.bugqa.qa.model.po.CustomerMaster;
import com.bugqa.qa.model.po.DepartmentMaster;
import com.bugqa.qa.model.po.GeneralMaster;
public final class USE0020Form extends BaseForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 得意先信息
	 */
	private List<CustomerMaster> selCustCodeList;

	/**
	 * 得意先信息
	 */
	private List<CustomerMaster> customerMsg;

	/**
	 * 部门信息
	 */
	private List<DepartmentMaster> departmentMsg;

	/**
	 * 课信息
	 */
	private List<ClassMaster> classMsg;

	/**
	 * 用户权限
	 */
	private List<GeneralMaster> userPrevlList;

	/**
	 * 标志
	 */
	private boolean flag;
	
	/**
	 * id存在性
	 */
	private String exitFlg;
	
	public List<CustomerMaster> getSelCustCodeList() {
		return selCustCodeList;
	}

	public void setSelCustCodeList(List<CustomerMaster> selCustCodeList) {
		this.selCustCodeList = selCustCodeList;
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

	public List<GeneralMaster> getUserPrevlList() {
		return userPrevlList;
	}

	public void setUserPrevlList(List<GeneralMaster> userPrevlList) {
		this.userPrevlList = userPrevlList;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public String getExitFlg() {
		return exitFlg;
	}

	public void setExitFlg(String exitFlg) {
		this.exitFlg = exitFlg;
	}
	
}
