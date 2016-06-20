package com.bugqa.qa.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bugqa.qa.model.dto.CustomQADTO;
import com.bugqa.qa.model.dto.QA0050ArgValue;
import com.bugqa.qa.model.dto.QA0050RetValue;
import com.bugqa.qa.model.po.GroupMaster;
import com.bugqa.qa.model.po.ModuleMaster;
import com.bugqa.qa.model.po.ProjectMaster;
import com.bugqa.qa.service.BaseService;
import com.bugqa.qa.service.QA0050Service;

/**
 * QA0050高级检索 service
 * 
 * @author zt c.
 *
 */
@Service
public class QA0050ServiceImpl extends BaseService implements QA0050Service {

	private static Logger logger = LoggerFactory.getLogger(QA0050ServiceImpl.class);

	/**
	 * グループ名内容的取得
	 * 
	 * @param projectId
	 *            项目ID
	 * @return グループ名
	 */
	@Override
	public QA0050RetValue getGroupID(String projectId) {
		List<GroupMaster> groupList = super.groupDao.getGroupID(projectId);
		logger.info("getGroupID result size ： " + groupList.size());
		QA0050RetValue ret = new QA0050RetValue();
		ret.setGroupIdList(groupList);
		return ret;
	}

	/**
	 * モジュール名内容的取得
	 * 
	 * @param projectId
	 *            画面．システム名．プロジェクトＩＤ
	 * @param groupId
	 *            画面．グループ名．グループＩＤ
	 * @return
	 */
	@Override
	public QA0050RetValue getModuleName(String projectId, String groupId) {
		List<ModuleMaster> result = super.moduleDao.getModule(projectId, groupId);
		logger.info("getModuleName result size ： " + result.size());
		QA0050RetValue ret = new QA0050RetValue();
		ret.setModuleNameList(result);
		return ret;
	}

	@Override
	public QA0050RetValue initSelectOptionData(String userId) {

		QA0050RetValue selectOptionData = new QA0050RetValue();
		// システム名
		List<ProjectMaster> project = super.projectDao.getProjectName(userId);
		// 如果系统名存在
		if (project != null && project.size() > 0) {
			selectOptionData.setProjectNameList(project);
			// Q&A回答方状態
			selectOptionData.setQaAStateList(super.generalDao.getKbn07());
			// 対応状態
			selectOptionData.setQaQStateList(super.generalDao.getKbn06());
			// 原因区分
			selectOptionData.setCauseDivList(super.generalDao.getKbnRQ());
			// 質問区分
			selectOptionData.setQuestionDivList(super.generalDao.getKbnQD());
			// 摘出作業
			selectOptionData.setStageList(super.generalDao.getKbn01());

			// 默认第一个
			String projectId = project.get(0).getProjectId();
			// グループ名内容
			selectOptionData.setGroupIdList(super.groupDao.getGroupID(projectId));
		}
		logger.info("initSelectOptionData success");

		return selectOptionData;
	}

	/**
	 * 自定义QA检索
	 * 
	 * @param 自定义检索条件
	 * @return 检索的QA结果
	 */
	@Override
	public QA0050RetValue customQASearchByPage(QA0050ArgValue arg) {
		List<CustomQADTO> result = qaDao.customQASearchByPage(arg);
		// HTML转义
		for (CustomQADTO dto : result) {
			// 回答日
			dto.setAnswerDate(escapeHTML(dto.getAnswerDate()));
			// 回答者
			dto.setAnswerer(escapeHTML(dto.getAnswerer()));
			// 原因区分
			dto.setCauseDiv(escapeHTML(dto.getCauseDiv()));
			// 期望日
			dto.setExpDate(escapeHTML(dto.getExpDate()));
			// group名
			dto.setGroupName(escapeHTML(dto.getGroupName()));
			// module名
			dto.setModuleName(escapeHTML(dto.getModuleName()));
			// 项目ID
			dto.setProjectId(escapeHTML(dto.getProjectId()));
			// 项目名
			dto.setProjectName(escapeHTML(dto.getProjectName()));
			// 回答者状态
			dto.setQaAState(escapeHTML(dto.getQaAState()));
			// QA番号
			dto.setQaNo(escapeHTML(dto.getQaNo()));
			// 提问者状态
			dto.setQaQState(escapeHTML(dto.getQaQState()));
			// 标题
			dto.setQaTitle(escapeHTML(dto.getQaTitle()));
			// 提问日
			dto.setQuestionDate(escapeHTML(dto.getQuestionDate()));
			// 质问区分
			dto.setQuestionDiv(escapeHTML(dto.getQuestionDiv()));
			// 提问者
			dto.setQuestioner(escapeHTML(dto.getQuestioner()));
			// 摘出作业
			dto.setStage(escapeHTML(dto.getStage()));
		}

		logger.info("customQASearchByPage result size ： " + result.size());
		QA0050RetValue ret = new QA0050RetValue();
		ret.setCustomQAList(result);
		return ret;
	}
}
