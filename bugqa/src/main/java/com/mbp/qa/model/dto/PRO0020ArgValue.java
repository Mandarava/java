package com.mbp.qa.model.dto;

import java.io.Serializable;
import java.util.Date;

public class PRO0020ArgValue extends BaseArgValue implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * プロジェクトＩＤ
	 */
	private String projectId;

	/**
	 * プロジェクト名称
	 */
	private String projectName;

	/**
	 * 社内得意先
	 */
	private String companyInCode;

	/**
	 * 社外得意先
	 */
	private String companOutCode;

	/**
	 * 開始日付
	 */
	private Date startDate;

	/**
	 * 終了日付
	 */
	private Date endDate;

	/**
	 * 対応終了日付
	 */
	private Date chkEndDate;

	/**
	 * 状態フラグ
	 */
	private String stateFlg;

	/**
	 * 更新ユーサーＩＤ
	 */
	private String updaterId;

	/**
	 * 更新日時
	 */
	private Date updateTime;

	/**
	 * 削除フラグ
	 */
	private String deleteFlg;

	/**
	 * 責任者
	 */
	private String chargeId;
	
	/**
	 * 责任者姓名
	 */
	private String chargeName;
	
	/**
	 * 经理
	 */
	private String managerId;
	
	/**
	 * 经理姓名
	 */
	private String managerName;
	
	/**
	 * 状态名
	 */
	private String stageName;
	
	/**
	 * 状态
	 */
	private String stage;
	
	/**
	 * 会社
	 */
	private String companyFlg;
	
	/**
	 * 会社名
	 */
	private String companyName;
	
	/**
	 * 用户ID(存放经理ID或者责任人ID)
	 */
	private String userId;
	
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId == null ? null : projectId.trim();
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName == null ? null : projectName.trim();
	}

	public String getCompanyInCode() {
		return companyInCode;
	}

	public void setCompanyInCode(String companyInCode) {
		this.companyInCode = companyInCode == null ? null : companyInCode.trim();
	}

	public String getCompanOutCode() {
		return companOutCode;
	}

	public void setCompanOutCode(String companOutCode) {
		this.companOutCode = companOutCode == null ? null : companOutCode.trim();
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getChkEndDate() {
		return chkEndDate;
	}

	public void setChkEndDate(Date chkEndDate) {
		this.chkEndDate = chkEndDate;
	}

	public String getStateFlg() {
		return stateFlg;
	}

	public void setStateFlg(String stateFlg) {
		this.stateFlg = stateFlg == null ? null : stateFlg.trim();
	}

	public String getUpdaterId() {
		return updaterId;
	}

	public void setUpdaterId(String updaterId) {
		this.updaterId = updaterId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg == null ? null : deleteFlg.trim();
	}

	public String getChargeId() {
		return chargeId;
	}

	public void setChargeId(String chargeId) {
		this.chargeId = chargeId == null ? null : chargeId.trim();
	}
	
	public String getChargeName() {
		return chargeName;
	}

	public void setChargeName(String chargeName) {
		this.chargeName = chargeName == null ? null : chargeName.trim();
	}
	
	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId == null ? null : managerId.trim();
	}
	
	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName == null ? null : managerName.trim();
	}
	
	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName == null ? null : stageName.trim();
	}
	
	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage == null ? null : stage.trim();
	}
	
	public String getCompanyFlg() {
		return companyFlg;
	}

	public void setCompanyFlg(String companyFlg) {
		this.companyFlg = companyFlg == null ? null : companyFlg.trim();
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName == null ? null : companyName.trim();
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}
	
}
