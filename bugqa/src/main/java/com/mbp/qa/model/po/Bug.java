package com.mbp.qa.model.po;

import java.io.Serializable;
import java.util.Date;

/**
 * バグ情報
 * 
 * @author zt c.
 */
public class Bug implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 影响度
	 */
	private String eikyoudo;
	/**
	 * 影响度
	 */
	private String influence;
	/**
	 * 请求日
	 */
	private String questionDate;
	/**
	 * 希望日
	 */
	private String textexpDate;
	/**
	 * プロジェクトＩＤ
	 */
	private String projectId;

	/**
	 * バグ番号
	 */
	private String bugNo;

	/**
	 * 機種/OS
	 */
	private String systemType;

	/**
	 * グループＩＤ
	 */
	private String groupId;

	/**
	 * モジュールＩＤ
	 */
	private String moduleId;

	/**
	 * 優先フラグ
	 */
	private String priorFlg;

	/**
	 * 社内フラグ
	 */
	private String companyFlg;

	/**
	 * バグ状態
	 */
	private String bugState;

	/**
	 * 発生日
	 */
	private Date occurDate;

	/**
	 * テスト仕様書(機能名)
	 */
	private String testSpec;

	/**
	 * 摘出作業
	 */
	private String stage;

	/**
	 * 現象
	 */
	private String phenomenon;

	/**
	 * 障害種別
	 */
	private String bugType;

	/**
	 * 条件区分
	 */
	private String condDiv;

	/**
	 * 発行者
	 */
	private String detector;

	/**
	 * 担当者
	 */
	private String developer;

	/**
	 * 予定検証者
	 */
	private String plnVerifier;

	/**
	 * 検証者
	 */
	private String verifier;

	/**
	 * 希望日
	 */
	private Date expDate;

	/**
	 * 障害情報
	 */
	private String bugInfo;

	/**
	 * 障害情報（履歴）
	 */
	private String bugInfoCn;

	/**
	 * 添付資料
	 */
	private String attachedInfo;

	/**
	 * 対応開始日付
	 */
	private Date modStartDate;

	/**
	 * 対応終了日付
	 */
	private Date modEndDate;

	/**
	 * 原因概要
	 */
	private String genCause;

	/**
	 * 原因概要（履歴）
	 */
	private String genCauseCn;

	/**
	 * 処置方法
	 */
	private String solveMtd;

	/**
	 * 処置方法（履歴）
	 */
	private String solveMtdCn;

	/**
	 * 回答者
	 */
	private String replier;

	/**
	 * 確認者
	 */
	private String confirmer;

	/**
	 * 修正プログラム名
	 */
	private String corrproName;

	/**
	 * 修正モジュール名
	 */
	private String responsible;
	/**
	 * 责任者
	 */

	private String corrmodName;

	/**
	 * 原因区分
	 */
	private String causeDiv;

	/**
	 * 原因細分
	 */
	private String specCauseDiv;

	/**
	 * 処置区分
	 */
	private String solveDiv;

	/**
	 * 検証日
	 */
	private Date verifyDate;

	/**
	 * 備考
	 */
	private String remark;

	/**
	 * 備考（履歴）
	 */
	private String remarkCn;

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

	public String getBugNo() {
		return bugNo;
	}

	public void setBugNo(String bugNo) {
		this.bugNo = bugNo == null ? null : bugNo.trim();
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType == null ? null : systemType.trim();
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

	public String getPriorFlg() {
		return priorFlg;
	}

	public void setPriorFlg(String priorFlg) {
		this.priorFlg = priorFlg == null ? null : priorFlg.trim();
	}

	public String getCompanyFlg() {
		return companyFlg;
	}

	public void setCompanyFlg(String companyFlg) {
		this.companyFlg = companyFlg == null ? null : companyFlg.trim();
	}

	public String getBugState() {
		return bugState;
	}

	public void setBugState(String bugState) {
		this.bugState = bugState == null ? null : bugState.trim();
	}

	public Date getOccurDate() {
		return occurDate;
	}

	public void setOccurDate(Date occurDate) {
		this.occurDate = occurDate;
	}

	public String getTestSpec() {
		return testSpec;
	}

	public void setTestSpec(String testSpec) {
		this.testSpec = testSpec == null ? null : testSpec.trim();
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage == null ? null : stage.trim();
	}

	public String getPhenomenon() {
		return phenomenon;
	}

	public void setPhenomenon(String phenomenon) {
		this.phenomenon = phenomenon == null ? null : phenomenon.trim();
	}

	public String getBugType() {
		return bugType;
	}

	public void setBugType(String bugType) {
		this.bugType = bugType == null ? null : bugType.trim();
	}

	public String getCondDiv() {
		return condDiv;
	}

	public void setCondDiv(String condDiv) {
		this.condDiv = condDiv == null ? null : condDiv.trim();
	}

	public String getDetector() {
		return detector;
	}

	public void setDetector(String detector) {
		this.detector = detector == null ? null : detector.trim();
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer == null ? null : developer.trim();
	}

	public String getPlnVerifier() {
		return plnVerifier;
	}

	public void setPlnVerifier(String plnVerifier) {
		this.plnVerifier = plnVerifier == null ? null : plnVerifier.trim();
	}

	public String getVerifier() {
		return verifier;
	}

	public void setVerifier(String verifier) {
		this.verifier = verifier == null ? null : verifier.trim();
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getBugInfo() {
		return bugInfo;
	}

	public void setBugInfo(String bugInfo) {
		this.bugInfo = bugInfo == null ? null : bugInfo.trim();
	}

	public String getBugInfoCn() {
		return bugInfoCn;
	}

	public void setBugInfoCn(String bugInfoCn) {
		this.bugInfoCn = bugInfoCn == null ? null : bugInfoCn.trim();
	}

	public String getAttachedInfo() {
		return attachedInfo;
	}

	public void setAttachedInfo(String attachedInfo) {
		this.attachedInfo = attachedInfo == null ? null : attachedInfo.trim();
	}

	public Date getModStartDate() {
		return modStartDate;
	}

	public void setModStartDate(Date modStartDate) {
		this.modStartDate = modStartDate;
	}

	public Date getModEndDate() {
		return modEndDate;
	}

	public void setModEndDate(Date modEndDate) {
		this.modEndDate = modEndDate;
	}

	public String getGenCause() {
		return genCause;
	}

	public void setGenCause(String genCause) {
		this.genCause = genCause == null ? null : genCause.trim();
	}

	public String getGenCauseCn() {
		return genCauseCn;
	}

	public void setGenCauseCn(String genCauseCn) {
		this.genCauseCn = genCauseCn == null ? null : genCauseCn.trim();
	}

	public String getSolveMtd() {
		return solveMtd;
	}

	public void setSolveMtd(String solveMtd) {
		this.solveMtd = solveMtd == null ? null : solveMtd.trim();
	}

	public String getSolveMtdCn() {
		return solveMtdCn;
	}

	public void setSolveMtdCn(String solveMtdCn) {
		this.solveMtdCn = solveMtdCn == null ? null : solveMtdCn.trim();
	}

	public String getReplier() {
		return replier;
	}

	public void setReplier(String replier) {
		this.replier = replier == null ? null : replier.trim();
	}

	public String getConfirmer() {
		return confirmer;
	}

	public void setConfirmer(String confirmer) {
		this.confirmer = confirmer == null ? null : confirmer.trim();
	}

	public String getCorrproName() {
		return corrproName;
	}

	public void setCorrproName(String corrproName) {
		this.corrproName = corrproName == null ? null : corrproName.trim();
	}

	public String getCorrmodName() {
		return corrmodName;
	}

	public void setCorrmodName(String corrmodName) {
		this.corrmodName = corrmodName == null ? null : corrmodName.trim();
	}

	public String getCauseDiv() {
		return causeDiv;
	}

	public void setCauseDiv(String causeDiv) {
		this.causeDiv = causeDiv == null ? null : causeDiv.trim();
	}

	public String getSpecCauseDiv() {
		return specCauseDiv;
	}

	public void setSpecCauseDiv(String specCauseDiv) {
		this.specCauseDiv = specCauseDiv == null ? null : specCauseDiv.trim();
	}

	public String getSolveDiv() {
		return solveDiv;
	}

	public void setSolveDiv(String solveDiv) {
		this.solveDiv = solveDiv == null ? null : solveDiv.trim();
	}

	public Date getVerifyDate() {
		return verifyDate;
	}

	public void setVerifyDate(Date verifyDate) {
		this.verifyDate = verifyDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getRemarkCn() {
		return remarkCn;
	}

	public void setRemarkCn(String remarkCn) {
		this.remarkCn = remarkCn == null ? null : remarkCn.trim();
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
	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible =responsible==null?null:responsible.trim();
	}

	public String getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(String questionDate) {
		this.questionDate = questionDate;
	}

	public String getTextexpDate() {
		return textexpDate;
	}

	public void setTextexpDate(String textexpDate) {
		this.textexpDate = textexpDate;
	}

	public String getEikyoudo() {
		return eikyoudo;
	}

	public void setEikyoudo(String eikyoudo) {
		this.eikyoudo = eikyoudo;
	}

	public String getInfluence() {
		return influence;
	}

	public void setInfluence(String influence) {
		this.influence = influence;
	}




}