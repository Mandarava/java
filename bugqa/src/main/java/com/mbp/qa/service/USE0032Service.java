package com.mbp.qa.service;

import java.util.List;

import com.mbp.qa.model.dto.USE0032ArgValue;
import com.mbp.qa.model.po.UserMaster;

public interface USE0032Service {

	/**
	 * 用户信息
	 * 
	 * @param userId
	 * @return
	 */
	List<UserMaster> userMsgCom(String userId);

	/**
	 * 更新用户
	 * 
	 * @param arg
	 */
	void updateUser(USE0032ArgValue arg) throws Exception;

}
