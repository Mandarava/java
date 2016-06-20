package com.mbp.qa.service;

import com.mbp.qa.model.po.UserMaster;

/**
 * 用户登录interface
 * 
 * @author zt c.
 *
 */
public interface MAI0010Service {

	boolean userLogin(String userId, String pwd);

	UserMaster getUserInfo(String userId);
}
