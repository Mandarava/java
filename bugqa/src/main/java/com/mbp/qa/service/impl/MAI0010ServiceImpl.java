package com.mbp.qa.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mbp.qa.model.po.UserMaster;
import com.mbp.qa.service.BaseService;
import com.mbp.qa.service.MAI0010Service;

/**
 * 用户登录service
 * 
 * @author zt c.
 *
 */
@Service
public class MAI0010ServiceImpl extends BaseService implements MAI0010Service {

	private static Logger logger = LoggerFactory.getLogger(MAI0010ServiceImpl.class);

	/**
	 * 用户登录
	 * 
	 * @param userId
	 *            用户名
	 * @param pwd
	 *            密码
	 * @throws Exception
	 */
	public boolean userLogin(String userId, String pwd) {
		int result = 0;

		result = super.userDao.validLogin(userId, pwd);

		logger.info("userLogin : " + result);

		return result == 1;
	}

	/**
	 * 获得用户信息
	 */
	public UserMaster getUserInfo(String userId) {
		UserMaster result = super.userDao.getUserInfo(userId);
		logger.info("getUserInfo : " + result.getUserId());

		return result;
	}
}
