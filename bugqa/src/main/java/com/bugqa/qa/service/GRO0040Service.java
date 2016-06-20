package com.bugqa.qa.service;

import java.util.HashMap;
import java.util.List;

import com.bugqa.qa.model.dto.GRO0040ArgValue;
import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.po.GroupMaster;

public interface GRO0040Service {

	/**
	 * 检索group信息
	 * 
	 * @param projectId
	 * @return
	 */
	List<GroupMaster> groupList(GRO0040ArgValue arg, Page page);

	/**
	 * 添加小组成员
	 * 
	 * @param map
	 */
	void addGroupMember(HashMap<String, String> map);

	/**
	 * 删除小组成员
	 * 
	 * @param map
	 */
	void deleteGroupMember(HashMap<String, String> map);

}
