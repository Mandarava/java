package com.mbp.qa.model.form;

import java.io.Serializable;
import java.util.List;

import com.mbp.qa.model.dto.DeptInfo;
import com.mbp.qa.model.po.CustomerMaster;
import com.mbp.qa.model.po.DepartmentMaster;
import com.mbp.qa.model.po.ClassMaster;

public class CST0030Form extends BaseForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//客户信息
	private CustomerMaster customerpo;
	//部门信息
	private List<DepartmentMaster> departmentpoList;
	private List<DeptInfo> deptInfoList;
	//课室信息
	private List<ClassMaster> classpoList;
	
	
	
	public CustomerMaster getCustomerpo() {
		return customerpo;
	}
	public void setCustomerpo(CustomerMaster customerpo) {
		this.customerpo = customerpo;
	}
	public List<DepartmentMaster> getDepartmentpoList() {
		return departmentpoList;
	}
	public void setDepartmentpoList(List<DepartmentMaster> departmentpoList) {
		this.departmentpoList = departmentpoList;
	}
	public List<ClassMaster> getClasspoList() {
		return classpoList;
	}
	public void setClasspoList(List<ClassMaster> classpoList) {
		this.classpoList = classpoList;
	}
	public List<DeptInfo> getDeptInfoList() {
		return deptInfoList;
	}
	public void setDeptInfoList(List<DeptInfo> deptInfoList) {
		this.deptInfoList = deptInfoList;
	}
	
	
}
