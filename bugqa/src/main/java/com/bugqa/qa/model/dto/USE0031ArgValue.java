package com.bugqa.qa.model.dto;

import java.io.Serializable;
import java.util.Date;

public class USE0031ArgValue extends BaseArgValue implements Serializable {
	
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
	 * ユーザー権限
	 */
	private String userPrevl;

	/**
	 * 社内フラグ
	 */
	private String companyFlg;

	/**
	 * メール
	 */
	private String mailAddress;

	/**
	 * 得意先コード
	 */
	private String customerCode;

	/**
	 * 部門ＩＤ
	 */
	private String departmentId;

	/**
	 * 課ＩＤ
	 */
	private String classId;

	/**
	 * 削除フラグ
	 */
	private String deleteFlg;

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
	
	public String getUserPrevl() {
		return userPrevl;
	}

	public void setUserPrevl(String userPrevl) {
		this.userPrevl = userPrevl == null ? null : userPrevl.trim();
	}

	public String getCompanyFlg() {
		return companyFlg;
	}

	public void setCompanyFlg(String companyFlg) {
		this.companyFlg = companyFlg == null ? null : companyFlg.trim();
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress == null ? null : mailAddress.trim();
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode == null ? null : customerCode.trim();
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId == null ? null : departmentId.trim();
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId == null ? null : classId.trim();
	}

	public String getDeleteflg() {
		return deleteFlg;
	}

	public void setDeleteflg(String deleteflg) {
		this.deleteFlg = deleteflg == null ? null : deleteflg.trim();
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
