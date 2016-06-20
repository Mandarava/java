package com.bugqa.qa.model.dto;

import java.io.Serializable;

public final class ExcelQADTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Q&A番号
	 */
	private String qaNo;

	/**
	 * 提出日
	 */
	private String questionDate;

	/**
	 * 希望日
	 */
	private String expDate;

	/**
	 * 提出者
	 */
	private String questioner;

	/**
	 * モジュール名称
	 */
	private String moduleName;

	/**
	 * モジュールＩＤ
	 */
	private String moduleId;

	/**
	 * 名称(摘出作業)
	 */
	private String stage;

	/**
	 * 名称(原因区分)
	 */
	private String causeDiv;

	/**
	 * 質問内容
	 */
	private String questionInfo;

	/**
	 * 回答情報
	 */
	private String answerInfo;

	/**
	 * 回答日
	 */
	private String answerDate;

	/**
	 * 回答者
	 */
	private String answerer;

	/**
	 * 名称(質問区分)
	 */
	private String questionDiv;

	/**
	 * 名称(Q&A提出方状態)
	 */
	private String qaQState;

	/**
	 * 名称(Q&A回答方状態)
	 */
	private String qaAState;

	/**
	 * 附件信息
	 */
	private String aattachedInfo;

	public String getAattachedInfo() {
		return aattachedInfo;
	}

	public void setAattachedInfo(String aattachedInfo) {
		this.aattachedInfo = aattachedInfo;
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

	public String getQuestioner() {
		return questioner;
	}

	public void setQuestioner(String questioner) {
		this.questioner = questioner;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getQuestionInfo() {
		return questionInfo;
	}

	public void setQuestionInfo(String questionInfo) {
		this.questionInfo = questionInfo;
	}

	public String getAnswerInfo() {
		return answerInfo;
	}

	public void setAnswerInfo(String answerInfo) {
		this.answerInfo = answerInfo;
	}

	public String getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}

	public String getAnswerer() {
		return answerer;
	}

	public void setAnswerer(String answerer) {
		this.answerer = answerer;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
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

	public String getQaNo() {
		return qaNo;
	}

	public void setQaNo(String qaNo) {
		this.qaNo = qaNo;
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

}
