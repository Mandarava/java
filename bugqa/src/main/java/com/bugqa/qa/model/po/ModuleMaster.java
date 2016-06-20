package com.bugqa.qa.model.po;

import java.io.Serializable;
import java.util.Date;

/**
 * モジュールマスター
 * 
 * @author zt c.
 *
 */
public class ModuleMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * プロジェクトＩＤ
	 */
	private String projectId;

	/**
	 * グループＩＤ
	 */
	private String groupId;

	/**
	 * モジュールＩＤ
	 */
	private String moduleId;

	/**
	 * モジュール名称
	 */
	private String moduleName;

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

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId == null ? null : projectId.trim();
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId == null ? null : groupId.trim();
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId == null ? null : moduleId.trim();
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName == null ? null : moduleName.trim();
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