package com.bugqa.qa.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bugqa.qa.model.dto.GRO0040ArgValue;
import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.po.GroupMaster;
import com.bugqa.qa.service.BaseService;
import com.bugqa.qa.service.GRO0040Service;

@Service
public class GRO0040ServiceImpl extends BaseService implements GRO0040Service {

	/**
	 * 检索group信息
	 */
	@Override
	public List<GroupMaster> groupList(GRO0040ArgValue arg, Page page) {
		return super.groupDao.groupListByPage(arg, page);
	}

	/**
	 * 添加小组成员
	 */
	@Override
	public void addGroupMember(HashMap<String, String> map) {
		super.groupDao.addGroupMember(map);

	}

	/**
	 * 删除小组成员
	 */
	@Override
	public void deleteGroupMember(HashMap<String, String> map) {
		super.groupDao.deleteGroupMember(map);
	}
}
