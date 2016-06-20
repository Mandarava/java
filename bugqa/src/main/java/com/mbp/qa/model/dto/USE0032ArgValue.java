package com.mbp.qa.model.dto;

import java.io.Serializable;
import java.util.Date;

public class USE0032ArgValue extends BaseArgValue implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ユーサーＩＤ
	 */
	private String userId;

	/**
	 * ユーザー名称
	 */
	private String userName;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * 确认密码
	 */
	private String repassword;

	/**
	 * メール
	 */
	private String mailAddress;

	/**
	 * 更新ユーサーＩＤ
	 */
	private String updaterId;

	/**
	 * 更新日時
	 */
	private Date updateTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword == null ? null : repassword.trim();
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress == null ? null : mailAddress.trim();
	}

	public String getUpdaterId() {
		return updaterId;
	}

	public void setUpdaterId(String updaterId) {
		this.updaterId = updaterId == null ? null : updaterId.trim();
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
