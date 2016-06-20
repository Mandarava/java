package com.mbp.qa.model.form;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import com.mbp.qa.model.po.GeneralMaster;
import com.mbp.qa.model.po.GroupMaster;
import com.mbp.qa.model.po.ModuleMaster;
import com.mbp.qa.model.po.ProjectMaster;
import com.mbp.qa.model.po.UserMaster;

/**
 * QA0010 Form
 * 
 * @author zt c.
 *
 */
public final class QA0010Form extends BaseForm implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 摘出作业
	 */
	private List<GeneralMaster> stageList;

	/**
	 * 质问区分
	 */
	private List<GeneralMaster> questionDivList;

	/**
	 * 系统名
	 */
	private List<ProjectMaster> projectList;

	/**
	 * 发生个所
	 */
	private List<GroupMaster> groupList;

	/**
	 * 提问者
	 */
	private List<UserMaster> detectorList;

	/**
	 * 回答者
	 */
	private List<UserMaster> answererList;

	/**
	 * 发生机能
	 */
	private List<ModuleMaster> moduleList;

	/**
	 * Q&A番号
	 */
	private String qaNo;

	/**
	 * 上传的文件
	 */
	private File file;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public List<ModuleMaster> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<ModuleMaster> moduleList) {
		this.moduleList = moduleList;
	}

	public List<UserMaster> getDetectorList() {
		return detectorList;
	}

	public void setDetectorList(List<UserMaster> detectorList) {
		this.detectorList = detectorList;
	}

	public List<UserMaster> getAnswererList() {
		return answererList;
	}

	public void setAnswererList(List<UserMaster> answererList) {
		this.answererList = answererList;
	}

	public List<GroupMaster> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<GroupMaster> groupList) {
		this.groupList = groupList;
	}

	public List<GeneralMaster> getStageList() {
		return stageList;
	}

	public void setStageList(List<GeneralMaster> stageList) {
		this.stageList = stageList;
	}

	public List<GeneralMaster> getQuestionDivList() {
		return questionDivList;
	}

	public void setQuestionDivList(List<GeneralMaster> questionDivList) {
		this.questionDivList = questionDivList;
	}

	public List<ProjectMaster> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ProjectMaster> projectList) {
		this.projectList = projectList;
	}

	public String getQaNo() {
		return qaNo;
	}

	public void setQaNo(String qaNo) {
		this.qaNo = qaNo;
	}

}
