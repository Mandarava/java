package com.mbp.qa.model.po;

import java.io.Serializable;
import java.util.Date;

/**
 * Q&A情報
 * 
 * @author zt c.
 *
 */
public class QA implements Serializable {

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
	private Date questionDate;

	/**
	 * 希望日
	 */
	private Date expDate;

	/**
	 * 回答者
	 */
	private String answerer;

	/**
	 * 回答日
	 */
	private Date answerDate;

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
	private Date updateTime;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId == null ? null : projectId.trim();
	}

	public String getQaNo() {
		return qaNo;
	}

	public void setQaNo(String qaNo) {
		this.qaNo = qaNo == null ? null : qaNo.trim();
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

	public String getCompanyFlg() {
		return companyFlg;
	}

	public void setCompanyFlg(String companyFlg) {
		this.companyFlg = companyFlg == null ? null : companyFlg.trim();
	}

	public String getQaQState() {
		return qaQState;
	}

	public void setQaQState(String qaQState) {
		this.qaQState = qaQState == null ? null : qaQState.trim();
	}

	public String getQaAState() {
		return qaAState;
	}

	public void setQaAState(String qaAState) {
		this.qaAState = qaAState == null ? null : qaAState.trim();
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage == null ? null : stage.trim();
	}

	public String getQuestioner() {
		return questioner;
	}

	public void setQuestioner(String questioner) {
		this.questioner = questioner == null ? null : questioner.trim();
	}

	public Date getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(Date questionDate) {
		this.questionDate = questionDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getAnswerer() {
		return answerer;
	}

	public void setAnswerer(String answerer) {
		this.answerer = answerer == null ? null : answerer.trim();
	}

	public Date getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}

	public String getQaTitle() {
		return qaTitle;
	}

	public void setQaTitle(String qaTitle) {
		this.qaTitle = qaTitle == null ? null : qaTitle.trim();
	}

	public String getQaTitleCn() {
		return qaTitleCn;
	}

	public void setQaTitleCn(String qaTitleCn) {
		this.qaTitleCn = qaTitleCn == null ? null : qaTitleCn.trim();
	}

	public String getQuestionInfo() {
		return questionInfo;
	}

	public void setQuestionInfo(String questionInfo) {
		this.questionInfo = questionInfo == null ? null : questionInfo.trim();
	}

	public String getQuestionInfoCn() {
		return questionInfoCn;
	}

	public void setQuestionInfoCn(String questionInfoCn) {
		this.questionInfoCn = questionInfoCn == null ? null : questionInfoCn.trim();
	}

	public String getQattachedInfo() {
		return qattachedInfo;
	}

	public void setQattachedInfo(String qattachedInfo) {
		this.qattachedInfo = qattachedInfo == null ? null : qattachedInfo.trim();
	}

	public String getAnswerInfo() {
		return answerInfo;
	}

	public void setAnswerInfo(String answerInfo) {
		this.answerInfo = answerInfo == null ? null : answerInfo.trim();
	}

	public String getAnswerInfoCn() {
		return answerInfoCn;
	}

	public void setAnswerInfoCn(String answerInfoCn) {
		this.answerInfoCn = answerInfoCn == null ? null : answerInfoCn.trim();
	}

	public String getAattachedInfo() {
		return aattachedInfo;
	}

	public void setAattachedInfo(String aattachedInfo) {
		this.aattachedInfo = aattachedInfo == null ? null : aattachedInfo.trim();
	}

	public String getCauseDiv() {
		return causeDiv;
	}

	public void setCauseDiv(String causeDiv) {
		this.causeDiv = causeDiv == null ? null : causeDiv.trim();
	}

	public String getQuestionDiv() {
		return questionDiv;
	}

	public void setQuestionDiv(String questionDiv) {
		this.questionDiv = questionDiv == null ? null : questionDiv.trim();
	}

	public String getRelationQaNo() {
		return relationQaNo;
	}

	public void setRelationQaNo(String relationQaNo) {
		this.relationQaNo = relationQaNo == null ? null : relationQaNo.trim();
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
}