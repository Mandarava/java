package com.mbp.qa.model.form;

import com.mbp.qa.model.po.UserMaster;

public class MAI0010Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/**
	 * ユーサーＩＤ
	 */
	private String userId;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * 登录用户
	 */
	private UserMaster user;

	public UserMaster getUser() {
		return user;
	}

	public void setUser(UserMaster user) {
		this.user = user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
