package com.bugqa.qa.utils;

import org.apache.struts2.ServletActionContext;

import com.bugqa.qa.model.po.UserMaster;

/**
 * session 工具
 * 
 * @author zt c.
 *
 */
public final class SessionUtil {

	/**
	 * 获得登录用户
	 * 
	 * @return
	 */
	public static UserMaster getUser() {
		UserMaster user = (UserMaster) ServletActionContext.getRequest().getSession()
				.getAttribute("user");

		return user;
	}
}
