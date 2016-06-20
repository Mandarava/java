package com.mbp.qa.model.form;

import java.io.Serializable;
import java.util.List;

import com.mbp.qa.model.po.DepartmentMaster;

public class CST0040Form extends BaseForm implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<DepartmentMaster> departmentpo;

	public List<DepartmentMaster> getDepartmentpo() {
		return departmentpo;
	}

	public void setDepartmentpo(List<DepartmentMaster> departmentpo) {
		this.departmentpo = departmentpo;
	}
}
