package com.mbp.qa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mbp.qa.model.dto.MAI0061ArgValue;
import com.mbp.qa.model.dto.MAI0061RetValue;
import com.mbp.qa.model.dto.QAMyNoticeDTO;
import com.mbp.qa.model.dto.QAMyWorkDTO;
import com.mbp.qa.service.BaseService;
import com.mbp.qa.service.MAI0061Service;

/**
 * MAI0061 首页Q&A情报取得serviceImpl
 * 
 * @author zt c.
 *
 */
@Service
public class MAI0061ServiceImpl extends BaseService implements MAI0061Service {

	private static Logger logger = LoggerFactory.getLogger(MAI0061ServiceImpl.class);

	/**
	 * 我的工作列表取得
	 * 
	 * @return 我的工作列表 JSON
	 * @throws Exception
	 */
	@Override
	public MAI0061RetValue getQAMyWork(MAI0061ArgValue arg) {

		List<QAMyWorkDTO> result = new ArrayList<>();

		result = super.qaDao.getQAMyWorkByPage(arg);

		logger.info("getQAMyWork result size ： " + result.size());

		// HTML转义
		for (QAMyWorkDTO dto : result) {
			// 回答日
			dto.setAnswerDate(escapeHTML(dto.getAnswerDate()));
			// 回答者
			dto.setAnswerer(escapeHTML(dto.getAnswerer()));
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
			// 回答方状态
			dto.setQaAState(escapeHTML(dto.getQaAState()));
			// QA番号
			dto.setQaNo(escapeHTML(dto.getQaNo()));
			// 提问方状态
			dto.setQaQState(escapeHTML(dto.getQaQState()));
			// 标题
			dto.setQaTitle(escapeHTML(dto.getQaTitle()));
			// 提问日
			dto.setQuestionDate(escapeHTML(dto.getQuestionDate()));
			// 提问者
			dto.setQuestioner(escapeHTML(dto.getQuestioner()));
		}

		MAI0061RetValue ret = new MAI0061RetValue();
		ret.setQaMyWorkList(result);
		return ret;
	}

	/**
	 * 我关注的工作列表取得
	 * 
	 * @return 我关注的工作列表 JSON
	 */
	@Override
	public MAI0061RetValue getQAMyNotice(MAI0061ArgValue arg) {

		List<QAMyNoticeDTO> result = new ArrayList<>();
		result = super.qaDao.getQAMyNoticeByPage(arg);

		logger.info("getQAMyNotice result size : " + result.size());

		// HTML转义
		for (QAMyNoticeDTO dto : result) {
			// 回答日
			dto.setAnswerDate(escapeHTML(dto.getAnswerDate()));
			// 回答者
			dto.setAnswerer(escapeHTML(dto.getAnswerer()));
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
			// 回答方状态
			dto.setQaAState(escapeHTML(dto.getQaAState()));
			// QA番号
			dto.setQaNo(escapeHTML(dto.getQaNo()));
			// 提问方状态
			dto.setQaQState(escapeHTML(dto.getQaQState()));
			// 标题
			dto.setQaTitle(escapeHTML(dto.getQaTitle()));
			// 提问日
			dto.setQuestionDate(escapeHTML(dto.getQuestionDate()));
			// 提问者
			dto.setQuestioner(escapeHTML(dto.getQuestioner()));
		}

		MAI0061RetValue ret = new MAI0061RetValue();
		ret.setQaMyNoticeList(result);
		return ret;
	}

}
