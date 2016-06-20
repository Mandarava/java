package com.mbp.qa.model.dto;

import java.io.Serializable;

public final class QADetailDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * プロジェクトＩＤ
	 */
	private String projectId;

	/**
	 * Q&A番号
	 */
	private String qaNo;

	/**
	 * グループＩＤ
	 */
	private String groupId;

	/**
	 * モジュールＩＤ
	 */
	private String moduleId;

	/**
	 * 社内フラグ
	 */
	private String companyFlg;

	/**
	 * Q&A提出方状態
	 */
	private String qaQState;

	/**
	 * Q&A回答方状態
	 */
	private String qaAState;

	/**
	 * 摘出作業
	 */
	private String stage;

	/**
	 * 提出者
	 */
	private String questioner;

	/**
	 * 提出日
	 */
	private String questionDate;

	/**
	 * 希望日
	 */
	private String expDate;

	/**
	 * 回答者
	 */
	private String answerer;

	/**
	 * 回答日
	 */
	private String answerDate;

	/**
	 * QAタイトル
	 */
	private String qaTitle;

	/**
	 * QAタイトル（履歴）
	 */
	private String qaTitleCn;

	/**
	 * 質問内容
	 */
	private String questionInfo;

	/**
	 * 質問内容（履歴）
	 */
	private String questionInfoCn;

	/**
	 * 質問添付資料
	 */
	private String qattachedInfo;

	/**
	 * 回答情報
	 */
	private String answerInfo;

	/**
	 * 回答情報（履歴）
	 */
	private String answerInfoCn;

	/**
	 * 回答添付資料
	 */
	private String aattachedInfo;

	/**
	 * 原因区分
	 */
	private String causeDiv;

	/**
	 * 質問区分
	 */
	private String questionDiv;

	/**
	 * 関係Q&A
	 */
	private String relationQaNo;

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
	private String updateTime;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getQaNo() {
		return qaNo;
	}

	public void setQaNo(String qaNo) {
		this.qaNo = qaNo;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getCompanyFlg() {
		return companyFlg;
	}

	public void setCompanyFlg(String companyFlg) {
		this.companyFlg = companyFlg;
	}

	public String getQaQState() {
		return qaQState;
	}

	public void setQaQState(String qaQState) {
		this.qaQState = qaQState;
	}

	public String getQaAState() {
		return qaAState;
	}

	public void setQaAState(String qaAState) {
		this.qaAState = qaAState;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getQuestioner() {
		return questioner;
	}

	public void setQuestioner(String questioner) {
		this.questioner = questioner;
	}

	public String getAnswerer() {
		return answerer;
	}

	public void setAnswerer(String answerer) {
		this.answerer = answerer;
	}

	public String getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(String questionDate) {
		this.questionDate = questionDate;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}

	public String getQaTitle() {
		return qaTitle;
	}

	public void setQaTitle(String qaTitle) {
		this.qaTitle = qaTitle;
	}

	public String getQaTitleCn() {
		return qaTitleCn;
	}

	public void setQaTitleCn(String qaTitleCn) {
		this.qaTitleCn = qaTitleCn;
	}

	public String getQuestionInfo() {
		return questionInfo;
	}

	public void setQuestionInfo(String questionInfo) {
		this.questionInfo = questionInfo;
	}

	public String getQuestionInfoCn() {
		return questionInfoCn;
	}

	public void setQuestionInfoCn(String questionInfoCn) {
		this.questionInfoCn = questionInfoCn;
	}

	public String getQattachedInfo() {
		return qattachedInfo;
	}

	public void setQattachedInfo(String qattachedInfo) {
		this.qattachedInfo = qattachedInfo;
	}

	public String getAnswerInfo() {
		return answerInfo;
	}

	public void setAnswerInfo(String answerInfo) {
		this.answerInfo = answerInfo;
	}

	public String getAnswerInfoCn() {
		return answerInfoCn;
	}

	public void setAnswerInfoCn(String answerInfoCn) {
		this.answerInfoCn = answerInfoCn;
	}

	public String getAattachedInfo() {
		return aattachedInfo;
	}

	public void setAattachedInfo(String aattachedInfo) {
		this.aattachedInfo = aattachedInfo;
	}

	public String getCauseDiv() {
		return causeDiv;
	}

	public void setCauseDiv(String causeDiv) {
		this.causeDiv = causeDiv;
	}

	public String getQuestionDiv() {
		return questionDiv;
	}

	public void setQuestionDiv(String questionDiv) {
		this.questionDiv = questionDiv;
	}

	public String getRelationQaNo() {
		return relationQaNo;
	}

	public void setRelationQaNo(String relationQaNo) {
		this.relationQaNo = relationQaNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemarkCn() {
		return remarkCn;
	}

	public void setRemarkCn(String remarkCn) {
		this.remarkCn = remarkCn;
	}

	public String getUpdaterId() {
		return updaterId;
	}

	public void setUpdaterId(String updaterId) {
		this.updaterId = updaterId;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}
