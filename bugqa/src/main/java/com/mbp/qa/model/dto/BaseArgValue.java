package com.mbp.qa.model.dto;

import java.io.Serializable;

import com.mbp.qa.model.po.UserMaster;
import com.mbp.qa.utils.PageUtils;
import com.mbp.qa.utils.SessionUtil;

public class BaseArgValue implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户信息
	 */
	private UserMaster user = SessionUtil.getUser();

	/**
	 * 分页信息
	 */
	private Page page = PageUtils.initPage();

	public UserMaster getUser() {
		return user;
	}

	public void setUser(UserMaster user) {
		this.user = user;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
