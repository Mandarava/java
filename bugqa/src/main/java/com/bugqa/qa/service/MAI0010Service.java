package com.bugqa.qa.service;

import com.bugqa.qa.model.po.UserMaster;

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
