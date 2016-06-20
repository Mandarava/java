package com.mbp.qa.model.form;

import java.io.Serializable;
import java.util.List;

import com.mbp.qa.model.po.ClassMaster;

public class CST0050Form extends BaseForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<ClassMaster> classList;
	public List<ClassMaster> getClassList() {
		return classList;
	}
	public void setClassList(List<ClassMaster> classList) {
		this.classList = classList;
	}
	
	
}
