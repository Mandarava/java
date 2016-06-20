package com.mbp.qa.model.form;

import java.io.Serializable;
import java.util.List;

import com.mbp.qa.model.po.UserMaster;

public final class USE0032Form extends BaseForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * 用户ID
	 */
	private String userId;

	/*
	 * 代码
	 */
	private String code;

	/*
	 * 用户信息
	 */
	private List<UserMaster> userMsgCom;


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<UserMaster> getUserMsgCom() {
		return userMsgCom;
	}

	public void setUserMsgCom(List<UserMaster> userMsgCom) {
		this.userMsgCom = userMsgCom;
	}

}
