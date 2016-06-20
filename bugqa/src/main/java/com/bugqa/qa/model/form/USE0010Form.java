package com.bugqa.qa.model.form;

import java.io.Serializable;
import java.util.List;

import com.bugqa.qa.model.po.UserMaster;

public final class USE0010Form extends BaseForm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<UserMaster> queryUserList;
	
	public List<UserMaster> getQueryUserList() {
		return queryUserList;
	}
	
	public void setQueryUserList(List<UserMaster> queryUserList) {
		this.queryUserList = queryUserList;
	}
}
