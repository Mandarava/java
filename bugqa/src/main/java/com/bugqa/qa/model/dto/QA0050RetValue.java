package com.bugqa.qa.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bugqa.qa.model.po.GeneralMaster;
import com.bugqa.qa.model.po.GroupMaster;
import com.bugqa.qa.model.po.ModuleMaster;
import com.bugqa.qa.model.po.ProjectMaster;

/**
 * QA0050表格数据DTO
 * 
 * @author zt
 *
 */
public final class QA0050RetValue implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 自定义QA检索结果
	 */
	private List<CustomQADTO> customQAList = new ArrayList<>();

	/**
	 * 系统名
	 */
	private List<ProjectMaster> projectNameList;

	/**
	 * 回答方状态
	 */
	private List<GeneralMaster> qaAStateList;

	/**
	 * 质问区分
	 */
	private List<GeneralMaster> questionDivList;

	/**
	 * グループ名
	 */
	private List<GroupMaster> groupIdList;

	/**
	 * 提问方状态
	 */
	private List<GeneralMaster> qaQStateList;

	/**
	 * 摘出作业
	 */
	private List<GeneralMaster> stageList;

	/**
	 * 原因区分
	 */
	private List<GeneralMaster> causeDivList;

	/**
	 * モジュール名
	 */
	private List<ModuleMaster> moduleNameList;

	public List<CustomQADTO> getCustomQAList() {
		return customQAList;
	}

	public void setCustomQAList(List<CustomQADTO> customQAList) {
		this.customQAList = customQAList;
	}

	public List<ProjectMaster> getProjectNameList() {
		return projectNameList;
	}

	public void setProjectNameList(List<ProjectMaster> projectNameList) {
		this.projectNameList = projectNameList;
	}

	public List<GeneralMaster> getQaAStateList() {
		return qaAStateList;
	}

	public void setQaAStateList(List<GeneralMaster> qaAStateList) {
		this.qaAStateList = qaAStateList;
	}

	public List<GeneralMaster> getQuestionDivList() {
		return questionDivList;
	}

	public void setQuestionDivList(List<GeneralMaster> questionDivList) {
		this.questionDivList = questionDivList;
	}

	public List<GroupMaster> getGroupIdList() {
		return groupIdList;
	}

	public void setGroupIdList(List<GroupMaster> groupIdList) {
		this.groupIdList = groupIdList;
	}

	public List<GeneralMaster> getQaQStateList() {
		return qaQStateList;
	}

	public void setQaQStateList(List<GeneralMaster> qaQStateList) {
		this.qaQStateList = qaQStateList;
	}

	public List<GeneralMaster> getStageList() {
		return stageList;
	}

	public void setStageList(List<GeneralMaster> stageList) {
		this.stageList = stageList;
	}

	public List<GeneralMaster> getCauseDivList() {
		return causeDivList;
	}

	public void setCauseDivList(List<GeneralMaster> causeDivList) {
		this.causeDivList = causeDivList;
	}

	public List<ModuleMaster> getModuleNameList() {
		return moduleNameList;
	}

	public void setModuleNameList(List<ModuleMaster> moduleNameList) {
		this.moduleNameList = moduleNameList;
	}

}
