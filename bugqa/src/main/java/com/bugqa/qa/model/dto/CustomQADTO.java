package com.bugqa.qa.model.dto;

import java.io.Serializable;

public final class CustomQADTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * QA番号
	 */
	private String qaNo;

	/**
	 * 项目ID
	 */
	private String projectId;

	/**
	 * 项目名
	 */
	private String projectName;

	/**
	 * 提问方状态
	 */
	private String qaQState;

	/**
	 * 回答方状态
	 */
	private String qaAState;

	/**
	 * グループ名
	 */
	private String groupName;

	/**
	 * モジュール名
	 */
	private String moduleName;

	/**
	 * 问题的标题
	 */
	private String qaTitle;

	/**
	 * 提问者
	 */
	private String questioner;

	/**
	 * 回答者
	 */
	private String answerer;

	/**
	 * 提问日
	 */
	private String questionDate;

	/**
	 * 期望日
	 */
	private String expDate;

	/**
	 * 回答日
	 */
	private String answerDate;

	/**
	 * 质问区分
	 */
	private String questionDiv;

	/**
	 * 原因区分
	 */
	private String causeDiv;

	/**
	 * 摘出作业
	 */
	private String stage;

	public String getQaNo() {
		return qaNo;
	}

	public void setQaNo(String qaNo) {
		this.qaNo = qaNo;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getQaTitle() {
		return qaTitle;
	}

	public void setQaTitle(String qaTitle) {
		this.qaTitle = qaTitle;
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

	public String getQuestionDiv() {
		return questionDiv;
	}

	public void setQuestionDiv(String questionDiv) {
		this.questionDiv = questionDiv;
	}

	public String getCauseDiv() {
		return causeDiv;
	}

	public void setCauseDiv(String causeDiv) {
		this.causeDiv = causeDiv;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
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

}
