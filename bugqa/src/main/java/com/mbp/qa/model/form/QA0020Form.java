package com.mbp.qa.model.form;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import com.mbp.qa.model.dto.QADetailDTO;
import com.mbp.qa.model.po.GeneralMaster;
import com.mbp.qa.model.po.GroupMaster;
import com.mbp.qa.model.po.ModuleMaster;
import com.mbp.qa.model.po.ProjectMaster;
import com.mbp.qa.model.po.ProjectMemberMaster;
import com.mbp.qa.model.po.UserMaster;

public final class QA0020Form extends BaseForm implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 系统名
	 */
	private ProjectMaster project;

	/**
	 * 摘出作业
	 */
	private List<GeneralMaster> stageList;

	/**
	 * 原因区分
	 */
	private List<GeneralMaster> causeDivList;

	/**
	 * 質問区分
	 */
	private List<GeneralMaster> questionDivList;

	/**
	 * 発生機能
	 */
	private List<GroupMaster> groupList;

	/**
	 * 発生個所
	 */
	private List<ModuleMaster> moduleList;

	/**
	 * 提问者
	 */
	private List<UserMaster> questionerList;

	/**
	 * 回答者
	 */
	private List<UserMaster> answererList;

	/**
	 * QA信息
	 */
	private QADetailDTO qaInfo;

	/**
	 * 项目成员信息
	 */
	private ProjectMemberMaster memberInfo;

	/**
	 * 回答者添附资料
	 */
	private File AUploadFile;

	/**
	 * 提问者添附资料
	 */
	private File QUploadFile;

	public File getAUploadFile() {
		return AUploadFile;
	}

	public void setAUploadFile(File aUploadFile) {
		AUploadFile = aUploadFile;
	}

	public File getQUploadFile() {
		return QUploadFile;
	}

	public void setQUploadFile(File qUploadFile) {
		QUploadFile = qUploadFile;
	}

	public ProjectMaster getProject() {
		return project;
	}

	public void setProject(ProjectMaster project) {
		this.project = project;
	}

	public QADetailDTO getQaInfo() {
		return qaInfo;
	}

	public void setQaInfo(QADetailDTO qaInfo) {
		this.qaInfo = qaInfo;
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

	public List<GroupMaster> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<GroupMaster> groupList) {
		this.groupList = groupList;
	}

	public List<ModuleMaster> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<ModuleMaster> moduleList) {
		this.moduleList = moduleList;
	}

	public List<UserMaster> getQuestionerList() {
		return questionerList;
	}

	public void setQuestionerList(List<UserMaster> questionerList) {
		this.questionerList = questionerList;
	}

	public List<UserMaster> getAnswererList() {
		return answererList;
	}

	public void setAnswererList(List<UserMaster> answererList) {
		this.answererList = answererList;
	}

	public List<GeneralMaster> getQuestionDivList() {
		return questionDivList;
	}

	public void setQuestionDivList(List<GeneralMaster> questionDivList) {
		this.questionDivList = questionDivList;
	}

	public ProjectMemberMaster getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(ProjectMemberMaster memberInfo) {
		this.memberInfo = memberInfo;
	}

}
