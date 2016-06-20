package com.mbp.qa.model.dto;

import java.io.Serializable;

public final class BaseQADTO implements Serializable {

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
	 * グループ名
	 */
	private String groupName;

	/**
	 * モジュール名
	 */
	private String moduleName;

	/**
	 * QA问题标题
	 */
	private String qaTitle;

	/**
	 * 提问者
	 */
	private String questioner;

	/**
	 * 回答方状态
	 */
	private String qaAState;

	/**
	 * 提问日
	 */
	private String questionDate;

	/**
	 * 期望日
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

	public String getQaAState() {
		return qaAState;
	}

	public void setQaAState(String qaAState) {
		this.qaAState = qaAState;
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

}
