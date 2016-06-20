package com.bugqa.qa.model.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 得意先課マスター
 * 
 * @author zt c.
 *
 */
public class ClassMaster implements Serializable {

	private static final long serialVersionUID = 1L;

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
	 * 課名称
	 */
	private String className;

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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className == null ? null : className.trim();
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg == null ? null : deleteFlg.trim();
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