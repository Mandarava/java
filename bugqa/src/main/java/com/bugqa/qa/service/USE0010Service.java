package com.bugqa.qa.service;

import java.util.List;

import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.dto.USE0010ArgValue;
import com.bugqa.qa.model.po.UserMaster;

public interface USE0010Service {

	/**
	 * 检索所有用户信息
	 * 
	 * @param arg
	 * @param page
	 * @return
	 */
	List<UserMaster> queryUser(USE0010ArgValue arg, Page page);

	/**
	 * 删除用户
	 * 
	 * @param userId
	 */
	void deleteUser(String userId);

}
