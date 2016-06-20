package com.mbp.qa.model.form;

import java.io.Serializable;
import java.util.List;

import com.mbp.qa.model.po.GroupMaster;

public final class GRO0040Form extends BaseForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 组信息
	 */
	private List<GroupMaster> groupList;
	
	public List<GroupMaster> getGroupList() {
		return groupList;
	}
	
	public void setGroupList(List<GroupMaster> groupList){
		this.groupList = groupList;
	}
	
}
