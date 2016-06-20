package com.bugqa.qa.model.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 采番マスター
 * 
 * @author zt c.
 *
 */
public class IdMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * プロジェクトＩＤ
	 */
	private String projectId;

	/**
	 * 社内フラグ
	 */
	private String companyFlg;

	/**
	 * 摘出作業
	 */
	private String stage;

	/**
	 * 会社名
	 */
	private String companyName;

	/**
	 * 作業名
	 */
	private String stageName;

	/**
	 * 連番
	 */
	private String serialNo;

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

	public String getCompanyFlg() {
		return companyFlg;
	}

	public void setCompanyFlg(String companyFlg) {
		this.companyFlg = companyFlg == null ? null : companyFlg.trim();
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage == null ? null : stage.trim();
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName == null ? null : companyName.trim();
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName == null ? null : stageName.trim();
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo == null ? null : serialNo.trim();
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