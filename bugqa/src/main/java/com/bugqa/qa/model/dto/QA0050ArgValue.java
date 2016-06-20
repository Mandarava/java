package com.bugqa.qa.model.dto;

import java.io.Serializable;

public class QA0050ArgValue extends BaseArgValue implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 项目ID
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
	 * QA番号
	 */
	private String qaNo;

	/**
	 * 社内外区分
	 */
	private String rdbShanai;

	/**
	 * 提问方状态
	 */
	private String qaQState;

	/**
	 * 回答方状态
	 */
	private String qaAState;

	/**
	 * 摘出作业
	 */
	private String stage;

	/**
	 * 质问区分
	 */
	private String questionDiv;

	/**
	 * 原因区分
	 */
	private String causeDiv;

	/**
	 * 问题信息
	 */
	private String questionInfo;

	/**
	 * 提问者
	 */
	private String questioner;

	/**
	 * 回答者
	 */
	private String answerer;

	/**
	 * 提问日开始
	 */
	private String questionDateFrom;

	/**
	 * 提问日结束
	 */
	private String questionDateTo;

	/**
	 * 期望日开始
	 */
	private String expDateFrom;

	/**
	 * 期望日结束
	 */
	private String expDateTo;

	/**
	 * 回答日开始
	 */
	private String answerDateFrom;

	/**
	 * 回答日结束
	 */
	private String answerDateTo;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
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

	public String getQaNo() {
		return qaNo;
	}

	public void setQaNo(String qaNo) {
		this.qaNo = qaNo;
	}

	public String getRdbShanai() {
		return rdbShanai;
	}

	public void setRdbShanai(String rdbShanai) {
		this.rdbShanai = rdbShanai;
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

	public String getQuestionInfo() {
		return questionInfo;
	}

	public void setQuestionInfo(String questionInfo) {
		this.questionInfo = questionInfo;
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

	public String getQuestionDateFrom() {
		return questionDateFrom;
	}

	public void setQuestionDateFrom(String questionDateFrom) {
		this.questionDateFrom = questionDateFrom;
	}

	public String getQuestionDateTo() {
		return questionDateTo;
	}

	public void setQuestionDateTo(String questionDateTo) {
		this.questionDateTo = questionDateTo;
	}

	public String getExpDateFrom() {
		return expDateFrom;
	}

	public void setExpDateFrom(String expDateFrom) {
		this.expDateFrom = expDateFrom;
	}

	public String getExpDateTo() {
		return expDateTo;
	}

	public void setExpDateTo(String expDateTo) {
		this.expDateTo = expDateTo;
	}

	public String getAnswerDateFrom() {
		return answerDateFrom;
	}

	public void setAnswerDateFrom(String answerDateFrom) {
		this.answerDateFrom = answerDateFrom;
	}

	public String getAnswerDateTo() {
		return answerDateTo;
	}

	public void setAnswerDateTo(String answerDateTo) {
		this.answerDateTo = answerDateTo;
	}

}
